/**
 * Copyright (c) 2014 Oracle and/or its affiliates. All rights reserved.
 *
 * You may not modify, use, reproduce, or distribute this software except in
 * compliance with  the terms of the License at:
 * http://java.net/projects/javaeetutorial/pages/BerkeleyLicense
 */
package com.kel6.schedule.web;

import com.kel6.schedule.entities.Dosen;
import com.kel6.schedule.entities.Koordinator;
import com.kel6.schedule.qualifiers.KoordinatorIn;
import com.kel6.schedule.qualifiers.LoggedIn;
//import com.forest.web.util.JsfUtil;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Produces;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Esa
 */
@Named(value = "userController")
@SessionScoped
public class UserController implements Serializable {
    
    private static final String BUNDLE = "bundles.Bundle";
    private static final long serialVersionUID = -8851462237612818158L;

    Dosen user;
    Koordinator krd;
    @EJB
    private com.kel6.schedule.session.DosenFacade ejbFacade;
    @EJB
    private com.kel6.schedule.session.KoordinatorFacade ejbKoordinator;
    
    
    private String username;
    private String password;
//    @Inject
//    CustomerController customerController;

    /**
     * Creates a new instance of Login
     */
    public UserController() {
    }

    /**
     * Login method based on
     * <code>HttpServletRequest</code> and security realm
     */
    public String login() {
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
        String result = "/index?faces-redirect=true";

        
            //request.login(this.getUsername(), this.getPassword());
    //        JsfUtil.addSuccessMessage(JsfUtil.getStringFromBundle(BUNDLE, "Login_Success"));

            this.user = ejbFacade.getDosenByUserName(getUsername());
            if(user != null && username != null  && username.equals(user.getUsername()) 
                    && password != null  && password.equals(user.getPassword())) {
                addMessage("Login Berhasil");
                this.getAuthenticatedUser();
                this.krd = ejbKoordinator.getKoordinatorByNik(user.getNikDosen());
                if(krd != null ){
                   this.getAuthenticatedKoordinator();
                }
                result = "/index?faces-redirect=true";
            } else {
                addMessage("Login Gagal");
                return null;
            }
            
        
        return result;
    }

    public String logout() {
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
        
  //      try {
            this.user = null;
            
//            request.logout();
            // clear the session
            ((HttpSession) context.getExternalContext().getSession(false)).invalidate();
            
 //           JsfUtil.addSuccessMessage(JsfUtil.getStringFromBundle(BUNDLE, "Logout_Success"));

    //    } catch (ServletException ex) {

      //      Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
 //           JsfUtil.addErrorMessage(JsfUtil.getStringFromBundle(BUNDLE, "Logout_Failed"));
        //} finally {
            return "/index?faces-redirect=true";
       // }
    }

    /**
     * @return the ejbFacade
     */
    public com.kel6.schedule.session.DosenFacade getEjbFacade() {
        return ejbFacade;
    }

    public @Produces
    @LoggedIn
    Dosen getAuthenticatedUser() {
        return user;
    }

    public boolean isLogged() {
        return (getUser() == null) ? false : true;
    }

    public boolean isKoordinator() {
//        for (Groups g : user.getGroupsList()) {
//            if (g.getName().equals("ADMINS")) {
//                return true;
//            }
//        }
        
        return (getKoordinator() == null) ? false : true;
    }

    public String goAdmin() {
        if (isKoordinator()) {
            return "/admin/index";
        } else {
            return "index";
        }
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the user
     */
    public Dosen getUser() {
        return user;
    }
    
    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public @Produces
    @KoordinatorIn
    Dosen getAuthenticatedKoordinator() {
        return user;
    }

    private Koordinator getKoordinator() {
        return this.krd;
    }
}
