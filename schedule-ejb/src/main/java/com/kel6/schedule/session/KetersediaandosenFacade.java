/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.kel6.schedule.session;

import com.kel6.schedule.entities.KetersediaanDosen;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Esa_Lucu
 */
@Stateless
public class KetersediaandosenFacade extends AbstractFacade<KetersediaanDosen> {
    @PersistenceContext(unitName = "com.rpl_schedule-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public KetersediaandosenFacade() {
        super(KetersediaanDosen.class);
    }
    
}
