/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.kel6.schedule.session;

import com.kel6.schedule.entities.Dosen;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Esa_Lucu
 */
@Stateless
public class DosenFacade extends AbstractFacade<Dosen> {
    @PersistenceContext(unitName = "com.rpl_schedule-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DosenFacade() {
        super(Dosen.class);
    }
    
    public Dosen getDosenByUserName(String username){
        Query createNamedQuery = getEntityManager().createNamedQuery("Dosen.findByUsername");

        createNamedQuery.setParameter("username", username);

        if (createNamedQuery.getResultList().size() > 0) {
            return (Dosen) createNamedQuery.getSingleResult();
        }
        else {
            return null;
        }
    }
    
    
}
