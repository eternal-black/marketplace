package com.marketplace.bean;

import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

@ManagedBean(name = "localeBean")
@SessionScoped
public class LocaleBean {

    @Getter @Setter private String localeCode;
    @Getter @Setter private Map<String,Object> countries;

    @PostConstruct
    private void init() {
        countries = new LinkedHashMap<String,Object>();
        countries.put("Russian", new Locale("ru", "RU"));
        countries.put("English", new Locale("en", "US"));
    }

    public void countryLocaleCodeChanged(ValueChangeEvent e){
        String newLocaleValue = e.getNewValue().toString();

        for (Map.Entry<String, Object> entry : countries.entrySet()) {
            if(entry.getValue().toString().equals(newLocaleValue)){
                FacesContext.getCurrentInstance()
                        .getViewRoot().setLocale((Locale)entry.getValue());
            }
        }
    }
}
