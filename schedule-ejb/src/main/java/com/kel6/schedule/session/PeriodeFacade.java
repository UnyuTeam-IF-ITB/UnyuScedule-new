/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.kel6.schedule.session;

import com.kel6.schedule.entities.Periode;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Esa_Lucu
 */
@Stateless
public class PeriodeFacade extends AbstractFacade<Periode> {
    @PersistenceContext(unitName = "com.rpl_schedule-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PeriodeFacade() {
        super(Periode.class);
    }
    public Periode getPeriodeById(long id){
        Query createNamedQuery = getEntityManager().createNamedQuery("Periode.findByIdPeriode");

        createNamedQuery.setParameter("idPeriode", id);

        if (createNamedQuery.getResultList().size() > 0) {
            return (Periode) createNamedQuery.getSingleResult();
        }
        else {
            return null;
        }
	}

}
