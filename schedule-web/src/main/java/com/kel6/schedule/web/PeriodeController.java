/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.kel6.schedule.web;


import com.kel6.schedule.entities.Periode;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Esa_Lucu
 */
@ManagedBean (name= "periodeController")
@SessionScoped
public class PeriodeController {
    @EJB
    private com.kel6.schedule.session.PeriodeFacade ejbFacade;
    private List<Periode> listPeriode;
    private Periode periode;
    /**
     * Creates a new instance of PeriodeController
     */
    public PeriodeController() {
    }
    
    public List<Periode>getListPeriode() {  
        if((listPeriode == null) || (listPeriode.isEmpty()))            
            refresh();  
        return listPeriode;  
    }
    
    public void refresh() {  
        listPeriode = ejbFacade.findAll();
    }  
    
    /** 
     * returns details of a customer. Useful for displaying in a form a customer's details 
     * @return 
     */  
    public Periode getDetails() {  
        return periode;  
    } 
    
    
  
    /** 
     * Action handler - Called when a line in the table is clicked 
     * @param periode 
     * @return 
     */  
    public String showDetails(Periode periode) {  
        this.periode = periode;  
        return "EditPeriode"; // will display CustomerDetails.xml JSF page  
    } 
    
    public String goAdd() {  
        this.periode = new Periode();  
        return "AddPeriode"; // will display CustomerDetails.xml JSF page  
    } 
  
    /** 
     * Action handler - update the customer model in the database. 
     * called when one press the update button in the form 
     * @return 
     */  
    public String update() {  
        System.out.println("###UPDATE###");  
        ejbFacade.edit(this.getDetails());
   //     refresh();
        return "/admin/ListPeriode?faces-redirect=true"; // will display the customer list in a table  
    }  
  
    /** 
     * Action handler - returns to the list of customers in the table 
     */  
    public String list() {  
        System.out.println("###LIST###");  
        return "/admin/ListPeriode?faces-redirect=true";  
    }  
    
    public String addNew() {
        this.ejbFacade.create(periode);
        //listPeriode.add(periode);
       refresh();
        return "/admin/ListPeriode?faces-redirect=true";
        
    }
    public String delete(Periode periode){
        this.periode = periode;
        this.ejbFacade.remove(periode);
        refresh();
        return "/admin/ListPeriode?faces-redirect=true";
    }
    
}
