/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.kel6.schedule.web;

import com.kel6.schedule.entities.JdwlSmnSdg;
import com.kel6.schedule.entities.Periode;
import com.kel6.schedule.genetic.DataSource;
import com.kel6.schedule.genetic.DataSource;
import com.kel6.schedule.genetic.Genetic;
import com.kel6.schedule.genetic.TempJadwal;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.sql.rowset.spi.SyncProvider;

/**
 *
 * @author Esa_Lucu
 */
/**
 *
 * @author Esa_Lucu
 */
@ManagedBean (name= "testGenetic")
@ViewScoped
public class TestGenetic implements Serializable{
    @EJB
    private com.kel6.schedule.session.PeriodeFacade ejbPeriode;
    @EJB
    private com.kel6.schedule.session.DosenFacade ejbDosen;
    @EJB
    private com.kel6.schedule.session.KaryaAkhirFacade ejbKA;
    @EJB
    private com.kel6.schedule.session.RuanganFacade ejbRuangan;
    @EJB
    private com.kel6.schedule.session.JamKuliahHariFacade ejbJam;
    private List<TempJadwal> listJadwal;

    public List<TempJadwal> getListJadwal() {
        return listJadwal;
    }

    public void setListJadwal(List<TempJadwal> listJadwal) {
        this.listJadwal = listJadwal;
    }
    
    public void generateJadwal(Periode periode){
        Genetic gen = new Genetic();
        DataSource dataSource ;
        dataSource = DataSource.getInstance();
        dataSource.setListGenDosen(ejbDosen.findAll()); // daftar dosen, bidang keahlian, avaible dosen
        dataSource.setListGenKaryaAkhir(ejbKA.findAll()); // daftar karya akhir, mahasiswa, daftar pembimbing
        dataSource.setListJam(ejbJam.findAll()); // daftar karya akhir, mahasiswa, daftar pembimbing
        dataSource.setListGenRuangan(ejbRuangan.findAll()); // daftar ruangan, avaible ruangan
        dataSource.setListGenSlotWaktu(dataSource.getListGenSlotWaktu()); // daftar slot waktu dari table slotwaktu
        dataSource.setPeriodeJadwal(ejbPeriode.getPeriodeById(periode.getIdPeriode())); // periode pelaksanaan sidang / seminar
        
        
        dataSource.generateSlotWaktu();
        listJadwal = gen.generateJadwal();
        // print jadwal for checking
//        System.out.println("ID SLOT WAKTU" + "\t"+
//                            "DATE" + "\t"+
//                            "ID_RUANGAN" +"\t"+
//                            "ID_KA"+"\t"+
//                            "ID_PEMBIMBING"+"\t"+
//                            "ID_DOSEN");
        
    }
    
    
}
