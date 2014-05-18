/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.kel6.schedule.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Esa_Lucu
 */
@Entity
@Table(name = "koordinator")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Koordinator.findAll", query = "SELECT k FROM Koordinator k"),
    @NamedQuery(name = "Koordinator.findByIdKoordinator", query = "SELECT k FROM Koordinator k WHERE k.idKoordinator = :idKoordinator")})
public class Koordinator implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_koordinator")
    private Integer idKoordinator;
    @JoinColumn(name = "nik_dosen", referencedColumnName = "nik_dosen")
    @ManyToOne
    private Dosen nikDosen;

    public Koordinator() {
    }

    public Koordinator(Integer idKoordinator) {
        this.idKoordinator = idKoordinator;
    }

    public Integer getIdKoordinator() {
        return idKoordinator;
    }

    public void setIdKoordinator(Integer idKoordinator) {
        this.idKoordinator = idKoordinator;
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
        hash += (idKoordinator != null ? idKoordinator.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Koordinator)) {
            return false;
        }
        Koordinator other = (Koordinator) object;
        if ((this.idKoordinator == null && other.idKoordinator != null) || (this.idKoordinator != null && !this.idKoordinator.equals(other.idKoordinator))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.kel6.schedule.entities.Koordinator[ idKoordinator=" + idKoordinator + " ]";
    }
    
}
