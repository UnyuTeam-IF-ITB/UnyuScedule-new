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
@Table(name = "ketersediaandosen")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ketersediaandosen.findAll", query = "SELECT k FROM Ketersediaandosen k"),
    @NamedQuery(name = "Ketersediaandosen.findByIdKetersediaan", query = "SELECT k FROM Ketersediaandosen k WHERE k.idKetersediaan = :idKetersediaan"),
    @NamedQuery(name = "Ketersediaandosen.findByTanggalSedia", query = "SELECT k FROM Ketersediaandosen k WHERE k.tanggalSedia = :tanggalSedia")})
public class Ketersediaandosen implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_ketersediaan")
    private Long idKetersediaan;
    @Column(name = "tanggal_sedia")
    @Temporal(TemporalType.DATE)
    private Date tanggalSedia;
    @JoinColumn(name = "nik_dosen", referencedColumnName = "nik_dosen")
    @ManyToOne
    private Dosen nikDosen;
    @JoinColumn(name = "id_jam", referencedColumnName = "id_jam")
    @ManyToOne
    private JamKuliahhari idJam;

    public Ketersediaandosen() {
    }

    public Ketersediaandosen(Long idKetersediaan) {
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

    public Dosen getNikDosen() {
        return nikDosen;
    }

    public void setNikDosen(Dosen nikDosen) {
        this.nikDosen = nikDosen;
    }

    public JamKuliahhari getIdJam() {
        return idJam;
    }

    public void setIdJam(JamKuliahhari idJam) {
        this.idJam = idJam;
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
        if (!(object instanceof Ketersediaandosen)) {
            return false;
        }
        Ketersediaandosen other = (Ketersediaandosen) object;
        if ((this.idKetersediaan == null && other.idKetersediaan != null) || (this.idKetersediaan != null && !this.idKetersediaan.equals(other.idKetersediaan))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.rpl.entities.Ketersediaandosen[ idKetersediaan=" + idKetersediaan + " ]";
    }
    
}
