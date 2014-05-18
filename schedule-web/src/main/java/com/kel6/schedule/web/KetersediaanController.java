/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.kel6.schedule.web;

import com.kel6.schedule.entities.Dosen;
import com.kel6.schedule.entities.JamKuliahHari;
import com.kel6.schedule.entities.KetersediaanDosen;
import com.kel6.schedule.qualifiers.LoggedIn;
import com.kel6.schedule.session.KetersediaanDosenFacade;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Produces;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.event.ScheduleEntryMoveEvent;
import org.primefaces.event.ScheduleEntryResizeEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.ScheduleEvent;
import org.primefaces.model.ScheduleModel;



/**
 *      
 * @author Esa_Lucu
 */
@Named(value = "ketersediaanController")
@SessionScoped
public class KetersediaanController implements Serializable{
    @EJB
    private KetersediaanDosenFacade ejbFacade;
    private List<KetersediaanDosen> listKetersediaanDosen;
    private KetersediaanDosen ketersediaanDosen;
    private Map <String,String> map;
    
    @EJB
    private com.kel6.schedule.session.JamKuliahHariFacade ejbJam;
    private List<JamKuliahHari> listJamKuliahHari;
    private JamKuliahHari jamKuliahhari;
    private List<JamKuliahHari> listSelected;
    private List <String> listItemSelected;
    
    @Inject
    @LoggedIn
    Dosen authenticated;

    public Dosen getAuthenticated() {
        return authenticated;
    }

    public void setAuthenticated(Dosen authenticated) {
        this.authenticated = authenticated;
    }

    /**
     * Creates a new instance of KetersediaanController
     */
    public JamKuliahHari getJamKuliahHari() {
        return jamKuliahhari;
    }

    public void setJamKuliahhari(JamKuliahHari jamKuliahhari) {
        this.jamKuliahhari = jamKuliahhari;
    }

    
     /**
     * Creates a new instance of KetersediaanController
     */
    public List<JamKuliahHari>getListJamKuliahHari() {  
        if((listJamKuliahHari == null) || (listJamKuliahHari.isEmpty())){            
            refreshJam();
            Map tempMap = new HashMap<String, String>();
            for(int i=0;i<listJamKuliahHari.size();i++){
                tempMap.put(listJamKuliahHari.get(i).getWaktuJam(),listJamKuliahHari.get(i).getIdJam());
            }
            map = sortByKeys(tempMap);
            
        }
        return listJamKuliahHari;  
    }
    
    @Produces
    @Named(value="selectedJam")
    public List<JamKuliahHari> getSelectedItem(){
        return this.getSelectedItem();
    }
    
    /*
     * Paramterized method to sort Map e.g. HashMap or Hashtable in Java
     * throw NullPointerException if Map contains null key
     */
    public static <K extends Comparable,V extends Comparable> Map<K,V> sortByKeys(Map<K,V> map){
        List<K> keys = new LinkedList<K>(map.keySet());
        Collections.sort(keys);
     
        //LinkedHashMap will keep the keys in the order they are inserted
        //which is currently sorted on natural ordering
        Map<K,V> sortedMap = new LinkedHashMap<K,V>();
        for(K key: keys){
            sortedMap.put(key, map.get(key));
        }
     
        return sortedMap;
    }


    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }
    
    

    public List<String> getListItemSelected() {
        return listItemSelected;
    }

    public void setListItemSelected(List<String> listItemSelected) {
        this.listItemSelected = listItemSelected;
//        JamKuliahHari newKS = new JamKuliahHari();
//        newKS.setIdJam(Long.MIN_VALUE);
//        listSelected.add(newKS);
    }
    
    
    public void setListSelected(List<JamKuliahHari> listSelected) {
        this.listSelected = listSelected;
    }
 
    public List<JamKuliahHari> getListSelected() {
        return listSelected;
    }
    
    public void refreshJam() {  
        listJamKuliahHari = ejbJam.findAll();
    }  
    
    public KetersediaanController() {
        eventModel = new DefaultScheduleModel();
        eventModel.addEvent(new DefaultScheduleEvent("Champions League Match", previousDay8Pm(), previousDay11Pm()));
        eventModel.addEvent(new DefaultScheduleEvent("Birthday Party", today1Pm(), today6Pm()));
        eventModel.addEvent(new DefaultScheduleEvent("Breakfast at Tiffanys", nextDay9Am(), nextDay11Am()));
        eventModel.addEvent(new DefaultScheduleEvent("Plant the new garden stuff", theDayAfter3Pm(), fourDaysLater3pm()));
    }
    public List<KetersediaanDosen>getListKetersediaanDosen() {  
        if((listKetersediaanDosen == null) || (listKetersediaanDosen.isEmpty()))            
            refresh();  
        return listKetersediaanDosen;  
    }
    
    public void refresh() {  
        listKetersediaanDosen = ejbFacade.findAll();
    }  
    
    /** 
     * returns details of a customer. Useful for displaying in a form a customer's details 
     * @return 
     */  
    public KetersediaanDosen getDetails() {  
        return ketersediaanDosen;  
    } 
    
    
  
    /** 
     * Action handler - Called when a line in the table is clicked 
     * @param ketersediaanDosen 
     * @return 
     */  
    public String showDetails(KetersediaanDosen ketersediaanDosen) {  
        this.ketersediaanDosen = ketersediaanDosen;  
        return "EditKetersediaanDosen"; // will display CustomerDetails.xml JSF page  
    } 
    
    public String goAdd() {  
        this.ketersediaanDosen = new KetersediaanDosen();  
        return "AddKetersediaanDosen"; // will display CustomerDetails.xml JSF page  
    } 
  
    /** 
     * Action handler - update the customer model in the database. 
     * called when one press the update button in the form 
     * @return 
     */  
    public String update() {  
        System.out.println("###UPDATE###");  
        ejbFacade.edit(ketersediaanDosen);
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
    
    public void addNew() {
        this.ejbFacade.create(ketersediaanDosen);
        //listKetersediaanDosen.add(ketersediaanDosen);
       //refresh();
       // return "ListKetersediaanDosen";
        
    }
    public String delete(KetersediaanDosen ketersediaanDosen){
        this.ketersediaanDosen = ketersediaanDosen;
        this.ejbFacade.remove(ketersediaanDosen);
        refresh();
        return "ListKetersediaanDosen";
    }

    public KetersediaanDosen getKetersediaanDosen() {
        return ketersediaanDosen;
    }

    public void setKetersediaanDosen(KetersediaanDosen ketersediaanDosen) {
        this.ketersediaanDosen = ketersediaanDosen;
    }
    
    private ScheduleModel eventModel;
     
    private ScheduleEvent event = new DefaultScheduleEvent();
 
    public Date getRandomDate(Date base) {
        Calendar date = Calendar.getInstance();
        date.setTime(base);
        date.add(Calendar.DATE, ((int) (Math.random()*30)) + 1);    //set random day of month
         
        return date.getTime();
    }
     
    public Date getInitialDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(calendar.get(Calendar.YEAR), Calendar.FEBRUARY, calendar.get(Calendar.DATE), 0, 0, 0);
         
        return calendar.getTime();
    }
     
    public ScheduleModel getEventModel() {
        return eventModel;
    }
     
    private Calendar today() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DATE), 0, 0, 0);
 
        return calendar;
    }
     
    private Date previousDay8Pm() {
        Calendar t = (Calendar) today().clone();
        t.set(Calendar.AM_PM, Calendar.PM);
        t.set(Calendar.DATE, t.get(Calendar.DATE) - 1);
        t.set(Calendar.HOUR, 8);
         
        return t.getTime();
    }
     
    private Date previousDay11Pm() {
        Calendar t = (Calendar) today().clone();
        t.set(Calendar.AM_PM, Calendar.PM);
        t.set(Calendar.DATE, t.get(Calendar.DATE) - 1);
        t.set(Calendar.HOUR, 11);
         
        return t.getTime();
    }
     
    private Date today1Pm() {
        Calendar t = (Calendar) today().clone();
        t.set(Calendar.AM_PM, Calendar.PM);
        t.set(Calendar.HOUR, 1);
         
        return t.getTime();
    }
     
    private Date theDayAfter3Pm() {
        Calendar t = (Calendar) today().clone();
        t.set(Calendar.DATE, t.get(Calendar.DATE) + 2);    
        t.set(Calendar.AM_PM, Calendar.PM);
        t.set(Calendar.HOUR, 3);
         
        return t.getTime();
    }
 
    private Date today6Pm() {
        Calendar t = (Calendar) today().clone();
        t.set(Calendar.AM_PM, Calendar.PM);
        t.set(Calendar.HOUR, 6);
         
        return t.getTime();
    }
     
    private Date nextDay9Am() {
        Calendar t = (Calendar) today().clone();
        t.set(Calendar.AM_PM, Calendar.AM);
        t.set(Calendar.DATE, t.get(Calendar.DATE) + 1);
        t.set(Calendar.HOUR, 9);
         
        return t.getTime();
    }
     
    private Date nextDay11Am() {
        Calendar t = (Calendar) today().clone();
        t.set(Calendar.AM_PM, Calendar.AM);
        t.set(Calendar.DATE, t.get(Calendar.DATE) + 1);
        t.set(Calendar.HOUR, 11);
         
        return t.getTime();
    }
     
    private Date fourDaysLater3pm() {
        Calendar t = (Calendar) today().clone();
        t.set(Calendar.AM_PM, Calendar.PM);
        t.set(Calendar.DATE, t.get(Calendar.DATE) + 4);
        t.set(Calendar.HOUR, 3);
         
        return t.getTime();
    }
     
    public ScheduleEvent getEvent() {
        return event;
    }
 
    public void setEvent(ScheduleEvent event) {
        this.event = event;
    }
     
    JamKuliahHari selected;

    public JamKuliahHari getSelected() {
        return selected;
    }

    public void setSelected(JamKuliahHari selected) {
        this.selected = selected;
    }
    
    public void addEvent(ActionEvent actionEvent) {
        int i;
        if(event.getId() == null){
            eventModel.addEvent(event);
            for(i=0;i<listItemSelected.size();i++){
                
                JamKuliahHari n = new JamKuliahHari();
                String str = listItemSelected.get(i);
                Long lng = Long.valueOf(str);
                n.setIdJam(lng);
                //n.setWaktuJam(listSelected.get(i).getWaktuJam());
                //n.setIdJam(listItemSelected.get(i));
                KetersediaanDosen ksd = new KetersediaanDosen();
                ksd.setIdJam(n);
                ksd.setTanggalSedia(this.event.getStartDate());
                ksd.setNikDosen(getAuthenticated());
                //addNew();
                ejbFacade.create(ksd);
                
                eventModel.addEvent(event);
            }
        }
        else
            eventModel.updateEvent(event);
         
        event = new DefaultScheduleEvent();
    }
     
    public void onEventSelect(SelectEvent selectEvent) {
        event = (ScheduleEvent) selectEvent.getObject();
    }
     
    public void onDateSelect(SelectEvent selectEvent) {
        event = new DefaultScheduleEvent("", (Date) selectEvent.getObject(), (Date) selectEvent.getObject());
        if(listItemSelected!=null){
            listItemSelected.clear();
        }
        populateCheckBox();
        
    }
    
    public void populateCheckBox(){
        listKetersediaanDosen = ejbFacade.getKetersediaanByNikDate(getAuthenticated(), this.event.getStartDate());
        if(listKetersediaanDosen!=null){
            listItemSelected = new ArrayList<>();
            for(int i=0; i<listKetersediaanDosen.size();i++){
                listItemSelected.add(listKetersediaanDosen.get(i).getIdJam().getIdJam().toString());
            }
        }
    }
     
    public void onEventMove(ScheduleEntryMoveEvent event) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Event moved", "Day delta:" + event.getDayDelta() + ", Minute delta:" + event.getMinuteDelta());
         
        addMessage(message);
    }
     
    public void onEventResize(ScheduleEntryResizeEvent event) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Event resized", "Day delta:" + event.getDayDelta() + ", Minute delta:" + event.getMinuteDelta());
         
        addMessage(message);
    }
    
     
    private void addMessage(FacesMessage message) {
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
}
