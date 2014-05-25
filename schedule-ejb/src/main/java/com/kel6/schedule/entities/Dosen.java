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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Esa_Lucu
 */
@Entity
@Table(name = "dosen")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dosen.findAll", query = "SELECT d FROM Dosen d"),
    @NamedQuery(name = "Dosen.findByNikDosen", query = "SELECT d FROM Dosen d WHERE d.nikDosen = :nikDosen"),
    @NamedQuery(name = "Dosen.findByNmDosen", query = "SELECT d FROM Dosen d WHERE d.nmDosen = :nmDosen"),
    @NamedQuery(name = "Dosen.findByAlamatDsn", query = "SELECT d FROM Dosen d WHERE d.alamatDsn = :alamatDsn"),
    @NamedQuery(name = "Dosen.findByJnsKlmnDsn", query = "SELECT d FROM Dosen d WHERE d.jnsKlmnDsn = :jnsKlmnDsn"),
    @NamedQuery(name = "Dosen.findByUsername", query = "SELECT d FROM Dosen d WHERE d.username = :username"),
    @NamedQuery(name = "Dosen.findByPassword", query = "SELECT d FROM Dosen d WHERE d.password = :password")})
@XmlAccessorType(XmlAccessType.FIELD)
public class Dosen implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "nik_dosen")
    private String nikDosen;
    @Size(max = 100)
    @Column(name = "nm_dosen")
    private String nmDosen;
    @Size(max = 200)
    @Column(name = "alamat_dsn")
    private String alamatDsn;
    @Column(name = "jns_klmn_dsn")
    private Integer jnsKlmnDsn;
    @Size(max = 255)
    @Column(name = "username")
    private String username;
    @Size(max = 255)
    @Column(name = "password")
    private String password;
    @JoinTable(name = "bidang_dosen", joinColumns = {
        @JoinColumn(name = "nik_dosen", referencedColumnName = "nik_dosen")}, inverseJoinColumns = {
        @JoinColumn(name = "id_bidang", referencedColumnName = "id_topik")})
    @ManyToMany
    private List<Topik> topikList;
    @JoinTable(name = "penguji", joinColumns = {
        @JoinColumn(name = "nik_dosen", referencedColumnName = "nik_dosen")}, inverseJoinColumns = {
        @JoinColumn(name = "id_smnsdg", referencedColumnName = "id_smnsdg")})
    @ManyToMany
    private List<SeminarSidang> seminarSidangList;
    @JoinTable(name = "pembimbing", joinColumns = {
        @JoinColumn(name = "nik_dosen", referencedColumnName = "nik_dosen")}, inverseJoinColumns = {
        @JoinColumn(name = "id_ka", referencedColumnName = "id_ka")})
    @ManyToMany
    private List<KaryaAkhir> karyaAkhirList;
    @OneToMany(mappedBy = "nikDosen")
    private List<Koordinator> koordinatorList;
    @OneToMany(mappedBy = "nikDosen")
    private List<KetersediaanDosen> ketersediaanDosenList;

    public Dosen() {
    }

    public Dosen(String nikDosen) {
        this.nikDosen = nikDosen;
    }

    public String getNikDosen() {
        return nikDosen;
    }

    public void setNikDosen(String nikDosen) {
        this.nikDosen = nikDosen;
    }

    public String getNmDosen() {
        return nmDosen;
    }

    public void setNmDosen(String nmDosen) {
        this.nmDosen = nmDosen;
    }

    public String getAlamatDsn() {
        return alamatDsn;
    }

    public void setAlamatDsn(String alamatDsn) {
        this.alamatDsn = alamatDsn;
    }

    public Integer getJnsKlmnDsn() {
        return jnsKlmnDsn;
    }

    public void setJnsKlmnDsn(Integer jnsKlmnDsn) {
        this.jnsKlmnDsn = jnsKlmnDsn;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @XmlTransient
    public List<Topik> getTopikList() {
        return topikList;
    }

    public void setTopikList(List<Topik> topikList) {
        this.topikList = topikList;
    }

    @XmlTransient
    public List<SeminarSidang> getSeminarSidangList() {
        return seminarSidangList;
    }

    public void setSeminarSidangList(List<SeminarSidang> seminarSidangList) {
        this.seminarSidangList = seminarSidangList;
    }

    @XmlTransient
    public List<KaryaAkhir> getKaryaAkhirList() {
        return karyaAkhirList;
    }

    public void setKaryaAkhirList(List<KaryaAkhir> karyaAkhirList) {
        this.karyaAkhirList = karyaAkhirList;
    }

    @XmlTransient
    public List<Koordinator> getKoordinatorList() {
        return koordinatorList;
    }

    public void setKoordinatorList(List<Koordinator> koordinatorList) {
        this.koordinatorList = koordinatorList;
    }

    @XmlTransient
    public List<KetersediaanDosen> getKetersediaanDosenList() {
        return ketersediaanDosenList;
    }

    public void setKetersediaanDosenList(List<KetersediaanDosen> ketersediaanDosenList) {
        this.ketersediaanDosenList = ketersediaanDosenList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nikDosen != null ? nikDosen.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dosen)) {
            return false;
        }
        Dosen other = (Dosen) object;
        if ((this.nikDosen == null && other.nikDosen != null) || (this.nikDosen != null && !this.nikDosen.equals(other.nikDosen))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.kel6.schedule.entities.Dosen[ nikDosen=" + nikDosen + " ]";
    }
    
}
