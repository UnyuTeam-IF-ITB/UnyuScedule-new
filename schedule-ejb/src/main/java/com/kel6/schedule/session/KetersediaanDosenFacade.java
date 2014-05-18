/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.kel6.schedule.session;

import com.kel6.schedule.entities.Dosen;
import com.kel6.schedule.entities.KetersediaanDosen;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Esa_Lucu
 */
@Stateless
public class KetersediaanDosenFacade extends AbstractFacade<KetersediaanDosen> {
    @PersistenceContext(unitName = "com.rpl_schedule-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public KetersediaanDosenFacade() {
        super(KetersediaanDosen.class);
    }
    public List<KetersediaanDosen> getKetersediaanByNikDate(Dosen nik, Date tgl){
        String query = "SELECT k FROM KetersediaanDosen k WHERE k.nikDosen.nikDosen = :nik AND k.tanggalSedia = :tgl";
        Query createNamedQuery = getEntityManager().createQuery(query);

        createNamedQuery.setParameter("nik", nik.getNikDosen());
        createNamedQuery.setParameter("tgl", tgl);

        if (createNamedQuery.getResultList().size() > 0) {
            return (List<KetersediaanDosen>) createNamedQuery.getResultList();
        }
        else {
            return null;
        }
    }

}
