/**
 * Copyright (c) 2014 Oracle and/or its affiliates. All rights reserved.
 *
 * You may not modify, use, reproduce, or distribute this software except in
 * compliance with  the terms of the License at:
 * http://java.net/projects/javaeetutorial/pages/BerkeleyLicense
 */
package com.kel6.schedule.web;

import java.io.Serializable;
import java.util.Locale;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 * <p>Managed bean that retrieves current locale, used on each page.</p>
 */
@Named
@SessionScoped
public class LocaleBean implements Serializable {

    private static final Logger logger =
            Logger.getLogger("com.kel6.schedule.web.LocaleBean");
    private static final long serialVersionUID = -2181710426297811604L;
    private Locale locale =
            FacesContext.getCurrentInstance().getViewRoot().getLocale();

    public LocaleBean() {
    }

    public Locale getLocale() {
        logger.log(Level.INFO, "Entering LocaleBean.getLocale");
        return locale;
    }

    public void setLocale(Locale locale) {
        logger.log(Level.INFO, "Entering LocaleBean.setLocale");
        this.locale = locale;
    }

    public String getLanguage() {
        logger.log(Level.INFO, "Entering LocaleBean.getLanguage");
        return locale.getLanguage();
    }

    public void setLanguage(String language) {
        logger.log(Level.INFO, "Entering LocaleBean.setLanguage");
        locale = new Locale(language);
        FacesContext.getCurrentInstance().getViewRoot().setLocale(locale);
    }
}
