/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.kel6.schedule.web;

import com.kel6.schedule.entities.JamKuliahHari;
import com.kel6.schedule.session.JamKuliahHariFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author Junta
 */
@Named(value = "jamKuliahHariController")
@SessionScoped
public class JamKuliahHariController implements Serializable {
    @EJB
    private com.kel6.schedule.session.JamKuliahHariFacade ejbFacade;
    private List<JamKuliahHari> listJamKuliahhari;
    private JamKuliahHari jamKuliahhari;

    /**
     * Creates a new instance of JamKuliahHariController
     */
    public JamKuliahHariController() {
    }

    /**
     * Creates a new instance of KetersediaanController
     */
    public List<JamKuliahHari>getListKetersediaanDosen() {  
        if((listJamKuliahhari == null) || (listJamKuliahhari.isEmpty()))            
            refresh();  
        return listJamKuliahhari;  
    }
    
    public void refresh() {  
        listJamKuliahhari = ejbFacade.findAll();
    }  
    
    /** 
     * returns details of a customer. Useful for displaying in a form a customer's details 
     * @return 
     */  
    public JamKuliahHari getDetails() {  
        return jamKuliahhari;  
    } 
    
    
  
    /** 
     * Action handler - Called when a line in the table is clicked 
     * @param jamKuliahhari 
     * @return 
     */  
    public String showDetails(JamKuliahHari jamKuliahhari) {  
        this.jamKuliahhari = jamKuliahhari;  
        return "EditKetersediaanDosen"; // will display CustomerDetails.xml JSF page  
    } 
    
    public String goAdd() {  
        this.jamKuliahhari = new JamKuliahHari();  
        return "AddKetersediaanDosen"; // will display CustomerDetails.xml JSF page  
    } 
  
    /** 
     * Action handler - update the customer model in the database. 
     * called when one press the update button in the form 
     * @return 
     */  
    public String update() {  
        System.out.println("###UPDATE###");  
        ejbFacade.edit(jamKuliahhari);
        refresh();
        return "ListKetersediaanDosen"; // will display the customer list in a table  
    }  
  
    /** 
     * Action handler - returns to the list of customers in the table 
     */  
    public String list() {  
        System.out.println("###LIST###");  
        return "ListKetersediaanDosen";  
    }  
    
    public String addNew() {
        this.ejbFacade.create(jamKuliahhari);
        //listJamKuliahhari.add(jamKuliahhari);
       refresh();
        return "ListKetersediaanDosen";
        
    }
    public String delete(JamKuliahHari jamKuliahhari){
        this.jamKuliahhari = jamKuliahhari;
        this.ejbFacade.remove(jamKuliahhari);
        refresh();
        return "ListKetersediaanDosen";
    }
}
