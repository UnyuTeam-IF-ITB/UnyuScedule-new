/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.kel6.schedule.entities;

import java.util.Date;

/**
 *
 * @author Esa_Lucu
 */
public class SlotWaktu {
    private JamKuliahHari jam;
    private Date tanggal;

    public SlotWaktu(Date time, JamKuliahHari get) {
        this.jam = get;
        this.tanggal = time;
    }

    public SlotWaktu() {
        
    }

    public JamKuliahHari getJam() {
        return jam;
    }

    public void setJam(JamKuliahHari jam) {
        this.jam = jam;
    }

    public Date getTanggal() {
        return tanggal;
    }

    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }
    
    
}
