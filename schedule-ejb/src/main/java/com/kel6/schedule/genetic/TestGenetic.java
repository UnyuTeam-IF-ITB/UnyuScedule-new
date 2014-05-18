/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.kel6.schedule.genetic;

import com.kel6.schedule.entities.JdwlSmnSdg;
import com.kel6.schedule.genetic.DataSource;
import com.kel6.schedule.genetic.Genetic;
import com.kel6.schedule.session.DosenFacade;
import com.kel6.schedule.session.KaryaAkhirFacade;
import com.kel6.schedule.session.PeriodeFacade;
import com.kel6.schedule.session.RuanganFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.sql.rowset.spi.SyncProvider;

/**
 *
 * @author Esa_Lucu
 */
public class TestGenetic {
    @EJB
    private static PeriodeFacade ejbPeriode = new PeriodeFacade();
    @EJB
    private static DosenFacade ejbDosen = new DosenFacade();
    @EJB
    private static KaryaAkhirFacade ejbKA = new KaryaAkhirFacade();
    @EJB
    private static RuanganFacade ejbRuangan = new RuanganFacade();
    public static void main(String[] args) {
        Genetic gen = new Genetic();
        DataSource dataSource ;
        dataSource = DataSource.getInstance();
        dataSource.setListGenDosen(ejbDosen.findAll()); // daftar dosen, bidang keahlian, avaible dosen
        dataSource.setListGenKaryaAkhir(ejbKA.findAll()); // daftar karya akhir, mahasiswa, daftar pembimbing
        dataSource.setListGenRuangan(ejbRuangan.findAll()); // daftar ruangan, avaible ruangan
        dataSource.setListGenSlotWaktu(dataSource.getListGenSlotWaktu()); // daftar slot waktu dari table slotwaktu
        dataSource.setPeriodeJadwal(ejbPeriode.find("16")); // periode pelaksanaan sidang / seminar
        gen.startNewThread();
//        List <JdwlSmnSdg> jadwal = gen.GenerateJadwal();
        // print jadwal for checking
//        System.out.println("ID SLOT WAKTU" + "\t"+
//                            "DATE" + "\t"+
//                            "ID_RUANGAN" +"\t"+
//                            "ID_KA"+"\t"+
//                            "ID_PEMBIMBING"+"\t"+
//                            "ID_DOSEN");
        
    }
    
    
}
