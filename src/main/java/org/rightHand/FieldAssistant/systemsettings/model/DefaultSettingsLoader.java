package org.rightHand.FieldAssistant.systemsettings.model;

import org.rightHand.FieldAssistant.model.Role;
import org.rightHand.FieldAssistant.model.User;
import org.rightHand.FieldAssistant.services.RoleService;
import org.rightHand.FieldAssistant.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DefaultSettingsLoader implements ApplicationRunner {

	@Autowired
	private RoleService roleService;
	@Autowired
	private UserService userService;

	private void loadDefaultSettings() {
		loadDefaultRoles();
	}

	private void loadDefaultRoles() {
		roleService.save(new Role("ROLE_USER"));
		roleService.save(new Role("ROLE_PUBLISHER"));
		roleService.save(new Role("ROLE_PIONEER"));
		roleService.save(new Role("ROLE_MINISTERIAL_SERVANT"));
		roleService.save(new Role("ROLE_LITERATURE_MANAGER"));
		roleService.save(new Role("ROLE_AUDIO_MANAGER"));
		roleService.save(new Role("ROLE_TERRITORY_MANAGER"));
		roleService.save(new Role("ROLE_ELDER"));
		roleService.save(new Role("ROLE_SERVICE_OVERSEER"));
		roleService.save(new Role("ROLE_BODY_COORDINATOR"));
		roleService.save(new Role("ROLE_SECRETARY"));
		roleService.save(new Role("ROLE_GROUP_COORDINATOR"));
		roleService.save(new Role("ROLE_CIRCUIT_OVERSEER"));
		roleService.save(new Role("ROLE_CONGREGATION_ADMIN"));
		roleService.save(new Role("ROLE_BRANCH_MANAGER"));
		roleService.save(new Role("ROLE_HEADQUARTERS_MANAGER"));
		roleService.save(new Role("ROLE_SUPER_ADMIN"));
		User admin = new User("admin", "test", "tfduque@hotmail.com");
		admin.addRole(roleService.findByName("ROLE_SUPER_ADMIN"));
		userService.save(admin);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		loadDefaultSettings();
	}

}
