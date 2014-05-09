/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.kel6.schedule.entities;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "Jam_Kuliah_hari")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "JamKuliahhari.findAll", query = "SELECT j FROM JamKuliahhari j"),
    @NamedQuery(name = "JamKuliahhari.findByIdJam", query = "SELECT j FROM JamKuliahhari j WHERE j.idJam = :idJam"),
    @NamedQuery(name = "JamKuliahhari.findByTotalJam", query = "SELECT j FROM JamKuliahhari j WHERE j.totalJam = :totalJam")})
public class JamKuliahhari implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_jam")
    private Long idJam;
    @Column(name = "total_jam")
    private BigInteger totalJam;
    @OneToMany(mappedBy = "idJam")
    private Collection<SlotWaktu> slotWaktuCollection;
    @OneToMany(mappedBy = "idJam")
    private Collection<Ketersediaandosen> ketersediaandosenCollection;

    public JamKuliahhari() {
    }

    public JamKuliahhari(Long idJam) {
        this.idJam = idJam;
    }

    public Long getIdJam() {
        return idJam;
    }

    public void setIdJam(Long idJam) {
        this.idJam = idJam;
    }

    public BigInteger getTotalJam() {
        return totalJam;
    }

    public void setTotalJam(BigInteger totalJam) {
        this.totalJam = totalJam;
    }

    @XmlTransient
    public Collection<SlotWaktu> getSlotWaktuCollection() {
        return slotWaktuCollection;
    }

    public void setSlotWaktuCollection(Collection<SlotWaktu> slotWaktuCollection) {
        this.slotWaktuCollection = slotWaktuCollection;
    }

    @XmlTransient
    public Collection<Ketersediaandosen> getKetersediaandosenCollection() {
        return ketersediaandosenCollection;
    }

    public void setKetersediaandosenCollection(Collection<Ketersediaandosen> ketersediaandosenCollection) {
        this.ketersediaandosenCollection = ketersediaandosenCollection;
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
        if (!(object instanceof JamKuliahhari)) {
            return false;
        }
        JamKuliahhari other = (JamKuliahhari) object;
        if ((this.idJam == null && other.idJam != null) || (this.idJam != null && !this.idJam.equals(other.idJam))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.rpl.entities.JamKuliahhari[ idJam=" + idJam + " ]";
    }
    
}
