package org.rightHand.FieldAssistant.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.expression.SecurityExpressionHandler;
import org.springframework.security.access.hierarchicalroles.RoleHierarchyImpl;
import org.springframework.security.access.vote.RoleHierarchyVoter;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.expression.DefaultWebSecurityExpressionHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource dataSource;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(dataSource).passwordEncoder(new BCryptPasswordEncoder())
				.usersByUsernameQuery("select username, password, enabled from user where username=?")
				.authoritiesByUsernameQuery(
						"SELECT u.username AS username, r.name AS role FROM user_role ur JOIN user u ON ur.user_id = u.id JOIN role r ON ur.role_id = r.id AND u.username=?");
	}

	// This sets the Security Configs
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()

				// Authentication management
				// Login
				.and().formLogin().loginPage("/login").loginProcessingUrl("/login").usernameParameter("username")
				.passwordParameter("password").defaultSuccessUrl("/core/index")
				// Logout
				.and().logout().clearAuthentication(true).logoutUrl("/logout").logoutSuccessUrl("/login")
				.deleteCookies("JSESSIONID").invalidateHttpSession(true)
				// Authorization management
				// Open
				.and().authorizeRequests().antMatchers("/", "/login").permitAll()
				//Only anonymous access
				.and().authorizeRequests().antMatchers("/register", "/registration", "/login").anonymous()
				// User
				.and().authorizeRequests().antMatchers("/core/*").hasRole("USER")
				// Publisher
				.and().authorizeRequests().antMatchers("/publisher/*").hasRole("PUBLISHER")
				// Pioneer
				.and().authorizeRequests().antMatchers("/pioneer/*").hasRole("PIONEER")
				// Ministerial Servant
				.and().authorizeRequests().antMatchers("/servants/*").hasRole("MINISTERIAL_SERVANT")
				// Literature Manager
				.and().authorizeRequests().antMatchers("/literature/*").hasRole("LITERATURE_MANAGER")
				// Territory Manager
				.and().authorizeRequests().antMatchers("/territory/*").hasRole("TERRITORY_MANAGER")
				// Congregation Admin
				.and().authorizeRequests().antMatchers("/congregation/*").hasRole("CONGREGATION_MANAGER")
				// Elder
				.and().authorizeRequests().antMatchers("/elders/*").hasRole("ELDER")
				// Circuit Overseer
				.and().authorizeRequests().antMatchers("/circuit/*").hasRole("CIRCUIT_OVERSEER")
				// Super Admin
				.and().authorizeRequests().antMatchers("/developer/*").hasRole("SUPER_ADMIN")
				// Overall configuration
				// Expression handler
				.and().authorizeRequests().expressionHandler(webExpressionHandler());

	}
	
	@Bean
    public RoleHierarchyVoter roleVoter() {
        return new RoleHierarchyVoter(roleHierarchy());
    }

	// This implements a Hierarchy among roles, allowing for simpler configuration
	@Bean
	public RoleHierarchyImpl roleHierarchy() {
		RoleHierarchyImpl roleHierarchy = new RoleHierarchyImpl();
		String hierarchy = "ROLE_PUBLISHER > ROLE_USER ";

		// Pioneer
		hierarchy+="ROLE_PIONEER > ROLE_PUBLISHER ";

		// Ministerial Servant
		hierarchy+="ROLE_MINISTERIAL_SERVANT > ROLE_PUBLISHER ";

		// Elder
		hierarchy+="ROLE_ELDER > ROLE_MINISTERIAL_SERVANT ";

		// Service Overseer
		hierarchy+=
				"ROLE_SERVICE_OVERSEER > ROLE_LITERATURE_MANAGER " + "ROLE_SERVICE_OVERSEER > ROLE_TERRITORY_MANAGER ";
		

		// Secretary
		hierarchy+="SECRETARY > ROLE_PIONEER ";

		// Body Coordinator
		hierarchy+=
				"ROLE_BODY_COORDINATOR > ROLE_SERVICE_OVERSEER " + "ROLE_BODY_COORDINATOR > ROLE_SECRETARY ";
		

		// If Jehovah wants so, its there =)

		// Circuit Overseer
		hierarchy+="ROLE_CIRCUIT_OVERSEER > ROLE_BODY_COORDINATOR " + "ROLE_CIRCUIT_OVERSEER > ROLE_ELDER ";
		// roleHierarchy.setHierarchy("ROLE_CIRCUIT_OVERSEER > ROLE_ELDER");

		// Branch Manager
		hierarchy+="ROLE_BRANCH_MANAGER > ROLE_CIRCUIT_OVERSEER ";

		// World HQ Manager
		hierarchy+="ROLE_HEADQUARTERS_MANAGER > ROLE_BRANCH_MANAGER ";

		// Super Admin - Development Purposes
		hierarchy+=
				"ROLE_SUPER_ADMIN > ROLE_HEADQUARTERS_MANAGER " + "ROLE_SUPER_ADMIN > ROLE_CONGREGATION_ADMIN "
						+ "ROLE_SUPER_ADMIN > ROLE_PIONEER " + "ROLE_SUPER_ADMIN > ROLE_CONGREGATION_ADMIN ";
		roleHierarchy.setHierarchy(hierarchy);
		return roleHierarchy;
	}

	// This implements the Hierarchy into the Handler

	private SecurityExpressionHandler<FilterInvocation> webExpressionHandler() {
		DefaultWebSecurityExpressionHandler defaultWebSecurityExpressionHandler = new DefaultWebSecurityExpressionHandler();
		defaultWebSecurityExpressionHandler.setRoleHierarchy(roleHierarchy());
		return defaultWebSecurityExpressionHandler;
	}
	
	@Override
    public void init(WebSecurity web) throws Exception {
        web.expressionHandler(webExpressionHandler());
        super.init(web);
    }

}
