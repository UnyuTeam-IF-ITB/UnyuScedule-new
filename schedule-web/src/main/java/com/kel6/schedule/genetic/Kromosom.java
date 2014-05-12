/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.kel6.schedule.genetic;

import com.kel6.schedule.entities.Dosen;
import com.kel6.schedule.entities.KaryaAkhir;
import com.kel6.schedule.entities.Ruangan;
import com.kel6.schedule.entities.SlotWaktu;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Noor Falih
 */
public class Kromosom {

    List<Dosen> genDosenPenguji;
    KaryaAkhir genKA;
    Ruangan genRuangan;
    SlotWaktu genWaktu;
    Date genDate;
    int pinalty = 0;

    static Kromosom UpdateGenDosen(Kromosom krom) {
        DataSource sourceData = DataSource.getInstance();
        krom.setGenDosenPenguji(sourceData.getRandDosen(krom.getGenKA()));

        return krom;
    }

    static Kromosom UpdateGenWaktu(Kromosom krom) {
        DataSource sourceData = DataSource.getInstance();
        krom.setGenWaktu(sourceData.getRandWaktu());

        return krom;
    }

    static Kromosom UpdateGenRuangan(Kromosom krom) {
        DataSource sourceData = DataSource.getInstance();
        krom.setGenRuangan(sourceData.getRandRuangan());

        return krom;
    }

    static Kromosom UpdateGenDate(Kromosom krom) {
        DataSource sourceData = DataSource.getInstance();
        krom.setGenDate(sourceData.getRandDate());

        return krom;
    }
    
    public static Kromosom GenerateKromosom() {
      DataSource sourceData = DataSource.getInstance();
      Kromosom krom = new Kromosom();
      boolean statusValidDosen = true;
      boolean statusValidRuangan = true;
      // generate kromosom by random gen
      krom.setGenWaktu(sourceData.getRandWaktu());

      krom.setGenDate(sourceData.getRandDate());

      krom.setGenKA(sourceData.getRandKA());

      krom.setGenRuangan(sourceData.getRandRuangan());
      krom.setGenDosenPenguji(sourceData.getRandDosen(krom.getGenKA()));

      krom.setPinalty(FitnessCalc.getPinalty(krom, null));
      return krom;
    }

    public KaryaAkhir getGenKA() {
        return genKA;
    }

    public void setGenKA(KaryaAkhir genKA) {
        this.genKA = genKA;
    }

    public List<Dosen> getGenDosenPenguji() {
        return genDosenPenguji;
    }

    public void setGenDosenPenguji(List<Dosen> genDosenPenguji) {
        this.genDosenPenguji = genDosenPenguji;
    }

   
    
    public Ruangan getGenRuangan() {
        return genRuangan;
    }

    public void setGenRuangan(Ruangan genRuangan) {
        this.genRuangan = genRuangan;
    }

    public SlotWaktu getGenWaktu() {
        return genWaktu;
    }

    public void setGenWaktu(SlotWaktu genWaktu) {
        this.genWaktu = genWaktu;
    }

    public int getPinalty() {
        return pinalty;
    }

    public void setPinalty(int pinalty) {
        this.pinalty = pinalty;
    }

    public Date getGenDate() {
        return genDate;
    }

    public void setGenDate(Date genDate) {
        this.genDate = genDate;
    }
}