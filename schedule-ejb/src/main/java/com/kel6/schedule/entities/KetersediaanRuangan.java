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
 * @author Esa_Lucu
 */
@Entity
@Table(name = "ketersediaan_ruangan")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "KetersediaanRuangan.findAll", query = "SELECT k FROM KetersediaanRuangan k"),
    @NamedQuery(name = "KetersediaanRuangan.findByIdKetRuangan", query = "SELECT k FROM KetersediaanRuangan k WHERE k.idKetRuangan = :idKetRuangan"),
    @NamedQuery(name = "KetersediaanRuangan.findByTanggal", query = "SELECT k FROM KetersediaanRuangan k WHERE k.tanggal = :tanggal")})
public class KetersediaanRuangan implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_ket_ruangan")
    private Long idKetRuangan;
    @Column(name = "tanggal")
    @Temporal(TemporalType.DATE)
    private Date tanggal;
    @JoinColumn(name = "id_ruangan", referencedColumnName = "id_ruangan")
    @ManyToOne
    private Ruangan idRuangan;
    @JoinColumn(name = "id_jam", referencedColumnName = "id_jam")
    @ManyToOne
    private JamKuliahHari idJam;

    public KetersediaanRuangan() {
    }

    public KetersediaanRuangan(Long idKetRuangan) {
        this.idKetRuangan = idKetRuangan;
    }

    public Long getIdKetRuangan() {
        return idKetRuangan;
    }

    public void setIdKetRuangan(Long idKetRuangan) {
        this.idKetRuangan = idKetRuangan;
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

    public JamKuliahHari getIdJam() {
        return idJam;
    }

    public void setIdJam(JamKuliahHari idJam) {
        this.idJam = idJam;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idKetRuangan != null ? idKetRuangan.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof KetersediaanRuangan)) {
            return false;
        }
        KetersediaanRuangan other = (KetersediaanRuangan) object;
        if ((this.idKetRuangan == null && other.idKetRuangan != null) || (this.idKetRuangan != null && !this.idKetRuangan.equals(other.idKetRuangan))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.kel6.schedule.entities.KetersediaanRuangan[ idKetRuangan=" + idKetRuangan + " ]";
    }
    
}
