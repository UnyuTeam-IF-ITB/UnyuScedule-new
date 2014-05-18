/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.kel6.schedule.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Esa_Lucu
 */
@Entity
@Table(name = "jam_kuliah_hari")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "JamKuliahHari.findAll", query = "SELECT j FROM JamKuliahHari j"),
    @NamedQuery(name = "JamKuliahHari.findByIdJam", query = "SELECT j FROM JamKuliahHari j WHERE j.idJam = :idJam"),
    @NamedQuery(name = "JamKuliahHari.findByWaktuJam", query = "SELECT j FROM JamKuliahHari j WHERE j.waktuJam = :waktuJam")})
public class JamKuliahHari implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_jam")
    private Long idJam;
    @Size(max = 30)
    @Column(name = "waktu_jam")
    private String waktuJam;
    @OneToMany(mappedBy = "idJam")
    private List<KetersediaanRuangan> ketersediaanRuanganList;
    @OneToMany(mappedBy = "idJam")
    private List<KetersediaanDosen> ketersediaanDosenList;
    @OneToMany(mappedBy = "idJam")
    private List<JadwalDetail> jadwalDetailList;

    public JamKuliahHari() {
    }

    public JamKuliahHari(Long idJam) {
        this.idJam = idJam;
    }

    public Long getIdJam() {
        return idJam;
    }

    public void setIdJam(Long idJam) {
        this.idJam = idJam;
    }

    public String getWaktuJam() {
        return waktuJam;
    }

    public void setWaktuJam(String waktuJam) {
        this.waktuJam = waktuJam;
    }

    @XmlTransient
    public List<KetersediaanRuangan> getKetersediaanRuanganList() {
        return ketersediaanRuanganList;
    }

    public void setKetersediaanRuanganList(List<KetersediaanRuangan> ketersediaanRuanganList) {
        this.ketersediaanRuanganList = ketersediaanRuanganList;
    }

    @XmlTransient
    public List<KetersediaanDosen> getKetersediaanDosenList() {
        return ketersediaanDosenList;
    }

    public void setKetersediaanDosenList(List<KetersediaanDosen> ketersediaanDosenList) {
        this.ketersediaanDosenList = ketersediaanDosenList;
    }

    @XmlTransient
    public List<JadwalDetail> getJadwalDetailList() {
        return jadwalDetailList;
    }

    public void setJadwalDetailList(List<JadwalDetail> jadwalDetailList) {
        this.jadwalDetailList = jadwalDetailList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idJam != null ? idJam.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof JamKuliahHari)) {
            return false;
        }
        JamKuliahHari other = (JamKuliahHari) object;
        if ((this.idJam == null && other.idJam != null) || (this.idJam != null && !this.idJam.equals(other.idJam))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.kel6.schedule.entities.JamKuliahHari[ idJam=" + idJam + " ]";
    }
    
}
