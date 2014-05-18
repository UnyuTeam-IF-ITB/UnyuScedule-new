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
@Table(name = "ketersediaan_dosen")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "KetersediaanDosen.findAll", query = "SELECT k FROM KetersediaanDosen k"),
    @NamedQuery(name = "KetersediaanDosen.findByIdKetersediaan", query = "SELECT k FROM KetersediaanDosen k WHERE k.idKetersediaan = :idKetersediaan"),
    @NamedQuery(name = "KetersediaanDosen.findByTanggalSedia", query = "SELECT k FROM KetersediaanDosen k WHERE k.tanggalSedia = :tanggalSedia")})
public class KetersediaanDosen implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_ketersediaan")
    private Long idKetersediaan;
    @Column(name = "tanggal_sedia")
    @Temporal(TemporalType.DATE)
    private Date tanggalSedia;
    @JoinColumn(name = "id_jam", referencedColumnName = "id_jam")
    @ManyToOne
    private JamKuliahHari idJam;
    @JoinColumn(name = "nik_dosen", referencedColumnName = "nik_dosen")
    @ManyToOne
    private Dosen nikDosen;

    public KetersediaanDosen() {
    }

    public KetersediaanDosen(Long idKetersediaan) {
        this.idKetersediaan = idKetersediaan;
    }

    public Long getIdKetersediaan() {
        return idKetersediaan;
    }

    public void setIdKetersediaan(Long idKetersediaan) {
        this.idKetersediaan = idKetersediaan;
    }

    public Date getTanggalSedia() {
        return tanggalSedia;
    }

    public void setTanggalSedia(Date tanggalSedia) {
        this.tanggalSedia = tanggalSedia;
    }

    public JamKuliahHari getIdJam() {
        return idJam;
    }

    public void setIdJam(JamKuliahHari idJam) {
        this.idJam = idJam;
    }

    public Dosen getNikDosen() {
        return nikDosen;
    }

    public void setNikDosen(Dosen nikDosen) {
        this.nikDosen = nikDosen;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idKetersediaan != null ? idKetersediaan.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof KetersediaanDosen)) {
            return false;
        }
        KetersediaanDosen other = (KetersediaanDosen) object;
        if ((this.idKetersediaan == null && other.idKetersediaan != null) || (this.idKetersediaan != null && !this.idKetersediaan.equals(other.idKetersediaan))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.kel6.schedule.entities.KetersediaanDosen[ idKetersediaan=" + idKetersediaan + " ]";
    }
    
}
