/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.kel6.schedule.web;

import com.kel6.schedule.entities.Dosen;
import com.kel6.schedule.qualifiers.LoggedIn;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;

/**
 *
 * @author Esa_Lucu
 */
@Named(value = "leftMenuController")
@Dependent
public class LeftMenuController {
    @Inject
    @LoggedIn
    Dosen authenticated;
    /**
     * Creates a new instance of LeftMenuController
     */
    public LeftMenuController() {
    }
    
    public String goHome(){
        return "index";
    }
    
    public String goKetersediaan(){
        return "/dosen/EntryKetersediaan";
    }
    
    public String goViewJadwal(){
        return "/jadwal/ViewJadwal";
    }
    
    
    
}
