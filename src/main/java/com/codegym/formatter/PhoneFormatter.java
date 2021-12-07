package com.codegym.formatter;


import com.codegym.model.SmartPhone;
import com.codegym.service.smartPhone.ISmartPhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;
import java.util.Optional;
@Component
public class PhoneFormatter implements Formatter<SmartPhone> {
    private ISmartPhoneService smartPhoneService;


    @Autowired
    public PhoneFormatter(ISmartPhoneService smartPhoneService) {
        this.smartPhoneService = smartPhoneService;
    }

    @Override
    public SmartPhone parse(String id, Locale locale) throws ParseException {
        Optional<SmartPhone> smartPhone =  smartPhoneService.findById(Long.parseLong(id));
        return smartPhone.orElse(null);
    }

    @Override
    public String print(SmartPhone object, Locale locale) {
        return null;
    }
}
