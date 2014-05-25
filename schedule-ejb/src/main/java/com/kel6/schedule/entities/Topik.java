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
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "topik")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Topik.findAll", query = "SELECT t FROM Topik t"),
    @NamedQuery(name = "Topik.findByIdTopik", query = "SELECT t FROM Topik t WHERE t.idTopik = :idTopik"),
    @NamedQuery(name = "Topik.findByNmTopik", query = "SELECT t FROM Topik t WHERE t.nmTopik = :nmTopik")})
@XmlAccessorType(XmlAccessType.FIELD)
public class Topik implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_topik")
    private Integer idTopik;
    @Size(max = 150)
    @Column(name = "nm_topik")
    private String nmTopik;
    @ManyToMany(mappedBy = "topikList")
    private List<KaryaAkhir> karyaAkhirList;
    @ManyToMany(mappedBy = "topikList")
    private List<Dosen> dosenList;

    public Topik() {
    }

    public Topik(Integer idTopik) {
        this.idTopik = idTopik;
    }

    public Integer getIdTopik() {
        return idTopik;
    }

    public void setIdTopik(Integer idTopik) {
        this.idTopik = idTopik;
    }

    public String getNmTopik() {
        return nmTopik;
    }

    public void setNmTopik(String nmTopik) {
        this.nmTopik = nmTopik;
    }

    @XmlTransient
    public List<KaryaAkhir> getKaryaAkhirList() {
        return karyaAkhirList;
    }

    public void setKaryaAkhirList(List<KaryaAkhir> karyaAkhirList) {
        this.karyaAkhirList = karyaAkhirList;
    }

    @XmlTransient
    public List<Dosen> getDosenList() {
        return dosenList;
    }

    public void setDosenList(List<Dosen> dosenList) {
        this.dosenList = dosenList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTopik != null ? idTopik.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Topik)) {
            return false;
        }
        Topik other = (Topik) object;
        if ((this.idTopik == null && other.idTopik != null) || (this.idTopik != null && !this.idTopik.equals(other.idTopik))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.kel6.schedule.entities.Topik[ idTopik=" + idTopik + " ]";
    }
    
}
