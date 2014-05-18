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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Esa_Lucu
 */
@Entity
@Table(name = "seminar_sidang")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SeminarSidang.findAll", query = "SELECT s FROM SeminarSidang s"),
    @NamedQuery(name = "SeminarSidang.findByIdSmnsdg", query = "SELECT s FROM SeminarSidang s WHERE s.idSmnsdg = :idSmnsdg"),
    @NamedQuery(name = "SeminarSidang.findByStatusSelesai", query = "SELECT s FROM SeminarSidang s WHERE s.statusSelesai = :statusSelesai")})
public class SeminarSidang implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_smnsdg")
    private Long idSmnsdg;
    @Column(name = "status_selesai")
    private Integer statusSelesai;
    @ManyToMany(mappedBy = "seminarSidangList")
    private List<Dosen> dosenList;
    @JoinColumn(name = "id_ka", referencedColumnName = "id_ka")
    @ManyToOne
    private KaryaAkhir idKa;
    @JoinColumn(name = "id_jdw_ss", referencedColumnName = "id_jdw_ss")
    @ManyToOne
    private JdwlSmnSdg idJdwSs;
    @OneToMany(mappedBy = "idSmnsdg")
    private List<JdwlSmnSdg> jdwlSmnSdgList;
    @OneToMany(mappedBy = "idSmnsdg")
    private List<Seminar> seminarList;
    @OneToMany(mappedBy = "idSmnsdg")
    private List<Sidang> sidangList;

    public SeminarSidang() {
    }

    public SeminarSidang(Long idSmnsdg) {
        this.idSmnsdg = idSmnsdg;
    }

    public Long getIdSmnsdg() {
        return idSmnsdg;
    }

    public void setIdSmnsdg(Long idSmnsdg) {
        this.idSmnsdg = idSmnsdg;
    }

    public Integer getStatusSelesai() {
        return statusSelesai;
    }

    public void setStatusSelesai(Integer statusSelesai) {
        this.statusSelesai = statusSelesai;
    }

    @XmlTransient
    public List<Dosen> getDosenList() {
        return dosenList;
    }

    public void setDosenList(List<Dosen> dosenList) {
        this.dosenList = dosenList;
    }

    public KaryaAkhir getIdKa() {
        return idKa;
    }

    public void setIdKa(KaryaAkhir idKa) {
        this.idKa = idKa;
    }

    public JdwlSmnSdg getIdJdwSs() {
        return idJdwSs;
    }

    public void setIdJdwSs(JdwlSmnSdg idJdwSs) {
        this.idJdwSs = idJdwSs;
    }

    @XmlTransient
    public List<JdwlSmnSdg> getJdwlSmnSdgList() {
        return jdwlSmnSdgList;
    }

    public void setJdwlSmnSdgList(List<JdwlSmnSdg> jdwlSmnSdgList) {
        this.jdwlSmnSdgList = jdwlSmnSdgList;
    }

    @XmlTransient
    public List<Seminar> getSeminarList() {
        return seminarList;
    }

    public void setSeminarList(List<Seminar> seminarList) {
        this.seminarList = seminarList;
    }

    @XmlTransient
    public List<Sidang> getSidangList() {
        return sidangList;
    }

    public void setSidangList(List<Sidang> sidangList) {
        this.sidangList = sidangList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSmnsdg != null ? idSmnsdg.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SeminarSidang)) {
            return false;
        }
        SeminarSidang other = (SeminarSidang) object;
        if ((this.idSmnsdg == null && other.idSmnsdg != null) || (this.idSmnsdg != null && !this.idSmnsdg.equals(other.idSmnsdg))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.kel6.schedule.entities.SeminarSidang[ idSmnsdg=" + idSmnsdg + " ]";
    }
    
}
