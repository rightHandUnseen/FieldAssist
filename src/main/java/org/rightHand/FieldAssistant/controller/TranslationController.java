package org.rightHand.FieldAssistant.controller;

import org.rightHand.FieldAssistant.translation.service.SupportedLocaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller

public class TranslationController {

	@Autowired
	private SupportedLocaleService localeService;
	
	@RequestMapping(value="languages/listall", method = RequestMethod.POST)
    public ModelAndView messages() {
        ModelAndView mav = new ModelAndView("base");
    	mav.addObject("locales",localeService.listAll());
    	return mav;
    }
	
}
