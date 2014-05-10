/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.kel6.schedule.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Junta
 */
@Entity
@Table(name = "slot_waktu")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SlotWaktu.findAll", query = "SELECT s FROM SlotWaktu s"),
    @NamedQuery(name = "SlotWaktu.findByIdSlot", query = "SELECT s FROM SlotWaktu s WHERE s.idSlot = :idSlot"),
    @NamedQuery(name = "SlotWaktu.findByTanggal", query = "SELECT s FROM SlotWaktu s WHERE s.tanggal = :tanggal")})
public class SlotWaktu implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_slot")
    private Long idSlot;
    @Column(name = "tanggal")
    @Temporal(TemporalType.DATE)
    private Date tanggal;
    @JoinColumn(name = "id_ruangan", referencedColumnName = "id_ruangan")
    @ManyToOne
    private Ruangan idRuangan;
    @JoinColumn(name = "id_jdwl_ss", referencedColumnName = "id_jdw_ss")
    @ManyToOne
    private JdwlSmnSdg idJdwlSs;
    @JoinColumn(name = "id_jam", referencedColumnName = "id_jam")
    @ManyToOne
    private JamKuliahHari idJam;

    public SlotWaktu() {
    }

    public SlotWaktu(Long idSlot) {
        this.idSlot = idSlot;
    }

    public Long getIdSlot() {
        return idSlot;
    }

    public void setIdSlot(Long idSlot) {
        this.idSlot = idSlot;
    }

    public Date getTanggal() {
        return tanggal;
    }

    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }

    public Ruangan getIdRuangan() {
        return idRuangan;
    }

    public void setIdRuangan(Ruangan idRuangan) {
        this.idRuangan = idRuangan;
    }

    public JdwlSmnSdg getIdJdwlSs() {
        return idJdwlSs;
    }

    public void setIdJdwlSs(JdwlSmnSdg idJdwlSs) {
        this.idJdwlSs = idJdwlSs;
    }

    public JamKuliahHari getIdJam() {
        return idJam;
    }

    public void setIdJam(JamKuliahHari idJam) {
        this.idJam = idJam;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSlot != null ? idSlot.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SlotWaktu)) {
            return false;
        }
        SlotWaktu other = (SlotWaktu) object;
        if ((this.idSlot == null && other.idSlot != null) || (this.idSlot != null && !this.idSlot.equals(other.idSlot))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.kel6.schedule.entities.SlotWaktu[ idSlot=" + idSlot + " ]";
    }
    
}
