/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.kel6.schedule.genetic;

import java.util.Date;

/**
 *
 * @author Esa_Lucu
 */
public class TempJadwal {
    private String judulKaryaAkhir;
    private String pembimbing;
    private String penguji;
    private Date  tanggalSidang;
    private String slotWaktu;

    public String getJudulKaryaAkhir() {
        return judulKaryaAkhir;
    }

    public void setJudulKaryaAkhir(String judulKaryaAkhir) {
        this.judulKaryaAkhir = judulKaryaAkhir;
    }

    public String getPembimbing() {
        return pembimbing;
    }

    public void setPembimbing(String pembimbing) {
        this.pembimbing = pembimbing;
    }

    public String getPenguji() {
        return penguji;
    }

    public void setPenguji(String penguji) {
        this.penguji = penguji;
    }

    public Date getTanggalSidang() {
        return tanggalSidang;
    }

    public void setTanggalSidang(Date tanggalSidang) {
        this.tanggalSidang = tanggalSidang;
    }

    public String getSlotWaktu() {
        return slotWaktu;
    }

    public void setSlotWaktu(String slotWaktu) {
        this.slotWaktu = slotWaktu;
    }
    
    
    
    
}
