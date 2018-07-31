package org.rightHand.FieldAssistant.translation;

import java.text.MessageFormat;
import java.util.Locale;

import org.rightHand.FieldAssistant.translation.model.MessageIdentity;
import org.rightHand.FieldAssistant.translation.model.SupportedLocale;
import org.rightHand.FieldAssistant.translation.repository.SupportedLocaleRepository;
import org.rightHand.FieldAssistant.translation.service.DefaultMessageService;
import org.rightHand.FieldAssistant.translation.service.TranslatedMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceResolvable;
import org.springframework.context.NoSuchMessageException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class DatabaseMessageSource implements MessageSource {

	@Autowired
	JdbcTemplate jdbcTemplate;
	@Autowired
	private DefaultMessageService defaultMessageService;
	@Autowired
	private TranslatedMessageService translatedMessageService;
	@Autowired
	private SupportedLocaleRepository supportedLocaleRepository;

	@Override
	public String getMessage(String code, Object[] args, String defaultMessage, Locale locale) {
		return resolveMessage(code, args, locale);
	}

	@Override
	public String getMessage(String code, Object[] args, Locale locale) throws NoSuchMessageException {
		return resolveMessage(code, args, locale);
	}

	@Override
	public String getMessage(MessageSourceResolvable resolvable, Locale locale) throws NoSuchMessageException {
		for (String code : resolvable.getCodes()) {
			String message = resolveMessage(code, resolvable.getArguments(), locale);
			if (message != null) {
				return message;
			}
		}
		return null;
	}

	private String resolveMessage(String code, Object[] args, Locale locale) {
		SupportedLocale supportedLocale = supportedLocaleRepository.findByLocale(locale);
		String message = "";
		if(supportedLocale == null) {
			MessageIdentity messageIdentity = new MessageIdentity(defaultMessageService.findByMessageCode(code), supportedLocale);
			message = translatedMessageService.findOne(messageIdentity).getMessageValue();
		} else {
			message = defaultMessageService.findByMessageCode(code).getMessageValue();
		}
		MessageFormat messageFormat = new MessageFormat(message, locale);
	    StringBuffer formattedMessage = new StringBuffer();
	    messageFormat.format(args, formattedMessage, null);
	    return formattedMessage.toString();
	}

}
