package org.rightHand.FieldAssistant.translation;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.rightHand.FieldAssistant.model.Language;
import org.rightHand.FieldAssistant.services.LanguageService;
import org.rightHand.FieldAssistant.translation.model.DefaultMessage;
import org.rightHand.FieldAssistant.translation.model.LocaleIdentity;
import org.rightHand.FieldAssistant.translation.model.MessageIdentity;
import org.rightHand.FieldAssistant.translation.model.Region;
import org.rightHand.FieldAssistant.translation.model.SupportedLocale;
import org.rightHand.FieldAssistant.translation.model.TranslatedMessage;
import org.rightHand.FieldAssistant.translation.repository.TranslatedMessageRepository;
import org.rightHand.FieldAssistant.translation.service.DefaultMessageService;
import org.rightHand.FieldAssistant.translation.service.RegionService;
import org.rightHand.FieldAssistant.translation.service.SupportedLocaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class SystemMessagesLoader implements ApplicationRunner{

	
	@Autowired
	private DefaultMessageService messages;
	@Autowired
	private LanguageService languages;
	@Autowired
	private RegionService regions;
	@Autowired
	private SupportedLocaleService locales;
	@Autowired
	private TranslatedMessageRepository translatedMessage;
	
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		loadMessages();
	}

	
	public void loadMessages() {

	    
		Language english = new Language("English", "en", "E");
		english = languages.save(english);
		Region us = new Region("us", "United States"); 
		us = regions.save(us);
		LocaleIdentity localeId = new LocaleIdentity(english, us);
		SupportedLocale locale = new SupportedLocale(localeId, "en_us");
		locale = locales.save(locale);
		List<DefaultMessage> defaultMessages = new ArrayList<DefaultMessage>();
		defaultMessages.add(messages.save(new DefaultMessage("mainTitle","Field Assistant")));
		
		
		// Login Form
		defaultMessages.add(messages.save(new DefaultMessage("login.formtitle","Login to the System")));
		defaultMessages.add(messages.save(new DefaultMessage("login.username.label","Username")));
		defaultMessages.add(messages.save(new DefaultMessage("login.username.placeholder","username")));
		defaultMessages.add(messages.save(new DefaultMessage("login.password.label","Password")));
		defaultMessages.add(messages.save(new DefaultMessage("login.password.placeholder","password")));
		defaultMessages.add(messages.save(new DefaultMessage("login.rememberme.label","Remember me?")));
		defaultMessages.add(messages.save(new DefaultMessage("login.loginbutton","Login")));
		defaultMessages.add(messages.save(new DefaultMessage("login.registerbutton","Register")));
		
		// Logout
		defaultMessages.add(messages.save(new DefaultMessage("logoutButton","Logout")));
		
		MessageIdentity messageId;
		TranslatedMessage translation;
		for(DefaultMessage message: defaultMessages) {
			messageId = new MessageIdentity(message, locale);	
			translation = new TranslatedMessage(messageId, message.getMessageValue());
			translatedMessage.save(translation);
			
		}
		
	}
	
}
