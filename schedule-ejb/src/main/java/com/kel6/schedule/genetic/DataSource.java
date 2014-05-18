/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.kel6.schedule.genetic;

import com.kel6.schedule.entities.Dosen;
import com.kel6.schedule.entities.JamKuliahHari;
import com.kel6.schedule.entities.KaryaAkhir;
import com.kel6.schedule.entities.Periode;
import com.kel6.schedule.entities.Ruangan;
import com.kel6.schedule.entities.SlotWaktu;
import com.kel6.schedule.entities.Topik;
import com.kel6.schedule.staticvariable.StaticVariable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Esa_Lucu
 */
public class DataSource {
    private List<Dosen> listGenDosen;
    private List<SlotWaktu> listGenSlotWaktu;
    private List<Ruangan> listGenRuangan;
    private List<KaryaAkhir> listGenKaryaAkhir;
    private List<KaryaAkhir> tempKaryaAkhir;
    private List<Date> listDatePeriode;
    private List<JamKuliahHari> listJam;
    private Periode periodeJadwal;

    private static int index = 0;
   
    private static DataSource instance = new DataSource();

    public void getPeriodeData(){
        
    }
    public void getRuanganData(){}
    public void getKaryaAkhirData(){}
    public static DataSource getInstance (){
        return instance;
    }

    public static void resetData() {
        //instance = new DataSource();
        index = 0;       
    }
    
    public Ruangan getRandRuangan() {
        int indexs = (int) (Math.random() * listGenRuangan.size());

        return listGenRuangan.get(indexs);
    }

    public List<SlotWaktu> getRandWaktu() {
        int indexs = (int) (Math.random() * listGenSlotWaktu.size());
        List<SlotWaktu> listSlotWaktu = new ArrayList<SlotWaktu>();
        while(listGenSlotWaktu.get(indexs).getJam().getIdJam()>=StaticVariable.SIZE_JAM_PERHARI-StaticVariable.SIZE_LAMA_SIDANG){
            indexs = (int) (Math.random() * listGenSlotWaktu.size());
        }
        for(int i=0;i<StaticVariable.SIZE_LAMA_SIDANG;i++){
            listSlotWaktu.add(listGenSlotWaktu.get(index+i));
        }
        
        return listSlotWaktu;
    }
    
    public void setPeriodeJadwal(Periode periodeJadwal) {
        this.periodeJadwal = periodeJadwal;

            Calendar tempPeriodeAwal = Calendar.getInstance();
            tempPeriodeAwal.setTime(periodeJadwal.getRentangSdgAwal());
            Calendar tempPeriodeAkhir = Calendar.getInstance();
            tempPeriodeAkhir.setTime(periodeJadwal.getRentangSdgAkhir());
            listDatePeriode = new ArrayList();
            while(tempPeriodeAwal.before(tempPeriodeAkhir)){
                listDatePeriode.add(tempPeriodeAwal.getTime());
                tempPeriodeAwal.add(Calendar.DATE, 1);
            }
    }
    public Date getRandDate() {
        int indexs = (int) (Math.random() * listDatePeriode.size());
        return listDatePeriode.get(indexs);
    }
    
    public List<Dosen> getListGenDosen() {
        return listGenDosen;
    }

    public void setListGenDosen(List<Dosen> listGenDosen) {
        this.listGenDosen = listGenDosen;
    }

    public List<SlotWaktu> getListGenSlotWaktu() {
        return listGenSlotWaktu;
    }

    public void setListGenSlotWaktu(List<SlotWaktu> listGenSlotWaktu) {
        this.listGenSlotWaktu = listGenSlotWaktu;
    }

    public List<Ruangan> getListGenRuangan() {
        return listGenRuangan;
    }

    public void setListGenRuangan(List<Ruangan> listGenRuangan) {
        this.listGenRuangan = listGenRuangan;
    }

    public List<KaryaAkhir> getListGenKaryaAkhir() {
        return listGenKaryaAkhir;
    }
    
    public KaryaAkhir getRandKA() {
        int index = (int) (Math.random() * listGenDosen.size());
        KaryaAkhir temp = listGenKaryaAkhir.get(index);
        index++;
        return temp;
    }
    
    public List<Dosen> getRandDosen(KaryaAkhir ka) {
        List<Dosen> listDosen = new ArrayList();
        boolean duplicateStatus, topikStatus;
        int i=0;
        int counter = 0;
        while (i<StaticVariable.SIZE_DOSEN_PENGUJI){
            duplicateStatus = false;
            topikStatus = false;
            int index = (int) (Math.random() * listGenDosen.size());
            
            for (int j=0; j<listDosen.size(); j++) {
                if (listDosen.get(j).getNikDosen().equals(listGenDosen.get(index).getNikDosen())) {
                    duplicateStatus = true;
                    j = listDosen.size(); // stop looping when same dosen
                }
            }
            
            List<Topik> listTopik = listGenDosen.get(index).getTopikList();
            for (int k=0; k<listTopik.size(); k++) {
                for (int l=0; l<ka.getTopikList().size();l++){
                    if (listTopik.get(k).getIdTopik() == ka.getTopikList().get(0).getIdTopik()) {
                        topikStatus = true;
                        k = listTopik.size(); // stop looping when same topik
                        l = ka.getTopikList().size(); // stop looping when same topik
                    }
                }
            }

            if (!duplicateStatus) {
                if (topikStatus || (counter > (listGenDosen.size() * listGenDosen.size()))) {
                    listDosen.add(listGenDosen.get(index));
                    i++;
                    counter = 0;
                }
            }
            counter++;
        }

        return listDosen;
    }

    public List<JamKuliahHari> getListJam() {
        return listJam;
    }

    public void setListJam(List<JamKuliahHari> listJam) {
        this.listJam = listJam;
    }

    public void setListGenKaryaAkhir(List<KaryaAkhir> listGenKaryaAkhir) {
        this.listGenKaryaAkhir = listGenKaryaAkhir;
    }

    public List<KaryaAkhir> getTempKaryaAkhir() {
        return tempKaryaAkhir;
    }

    public void setTempKaryaAkhir(List<KaryaAkhir> tempKaryaAkhir) {
        this.tempKaryaAkhir = tempKaryaAkhir;
    }

    public List<Date> getListDatePeriode() {
        return listDatePeriode;
    }

    public void setListDatePeriode(List<Date> listDatePeriode) {
        this.listDatePeriode = listDatePeriode;
    }

    public Periode getPeriodeJadwal() {
        return periodeJadwal;
    }

//    public void setPeriodeJadwal(Periode periodeJadwal) {
//        this.periodeJadwal = periodeJadwal;
//    }

    public static int getIndex() {
        return index;
    }

    public static void setIndex(int index) {
        DataSource.index = index;
    }


    public static void setInstance(DataSource instance) {
        DataSource.instance = instance;
    }
    
    public void generateSlotWaktu(){
        listGenSlotWaktu = new ArrayList<SlotWaktu>();
        //long periode1 = periodeJadwal.getRentangSdgAwal().getTime();
        long periode2 = periodeJadwal.getRentangSdgAkhir().getTime();
        Calendar cal = Calendar.getInstance();
        cal.setTime(periodeJadwal.getRentangSdgAwal());
        SimpleDateFormat formatter = new SimpleDateFormat("EEE");
        String day ;
        while(cal.getTimeInMillis()<=periode2){
            day = formatter.format(cal.getTime());
            if(!day.equals("Sab") && !day.equals("Min")){
                for(int i=0;i<listJam.size();i++){
                    SlotWaktu slot = new SlotWaktu(cal.getTime(),listJam.get(i));
                    listGenSlotWaktu.add(slot);
                }
            }
            cal.add(Calendar.DATE, 1);
        }
    }
    
    
}
