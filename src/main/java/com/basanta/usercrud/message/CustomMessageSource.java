package com.basanta.usercrud.message;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import java.util.Locale;


@Service
public class CustomMessageSource {

    private final MessageSource messageSource;



    public CustomMessageSource(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    public String get(String message, Object... objects){

        String message1 = messageSource.getMessage(message, objects, getCurrentLocale() );
        return message1;


    }

    public Locale getCurrentLocale() {
        Locale locale = LocaleContextHolder.getLocale();
        if (locale.getDisplayLanguage().equalsIgnoreCase("np")) {
            locale = new Locale("np", "Nepal");
        }
        return locale;
    }

    public String getEnglish(String code, Object... objects) {
        return messageSource.getMessage(code, objects, LocaleContextHolder.getLocale());
    }

    public String getNepali(String code, Object... objects) {
        return messageSource.getMessage(code, objects, new Locale("np", "Nepal"));
    }

}
