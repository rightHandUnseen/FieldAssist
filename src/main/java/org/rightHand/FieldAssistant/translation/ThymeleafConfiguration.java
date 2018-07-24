package org.rightHand.FieldAssistant.translation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.spring5.SpringTemplateEngine;

@Configuration
public class ThymeleafConfiguration {

	@Autowired
    private DatabaseMessageSource databaseMessageSource;

    @Bean
    public SpringTemplateEngine thymeleafTemplateEngine() {
        SpringTemplateEngine engine = new SpringTemplateEngine();
        // ...
        engine.setTemplateEngineMessageSource(databaseMessageSource);
        return engine;
    }
	
}
