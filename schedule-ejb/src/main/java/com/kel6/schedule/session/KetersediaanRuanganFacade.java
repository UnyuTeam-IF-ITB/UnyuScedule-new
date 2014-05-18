/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.kel6.schedule.session;

import com.kel6.schedule.entities.KetersediaanRuangan;
import com.kel6.schedule.entities.Ruangan;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Esa_Lucu
 */
@Stateless
public class KetersediaanRuanganFacade extends AbstractFacade<KetersediaanRuangan> {
    @PersistenceContext(unitName = "com.rpl_schedule-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public KetersediaanRuanganFacade() {
        super(KetersediaanRuangan.class);
    }
    
    
    
    public List<Ruangan> findAllWithDependency() {
        return null;
        //return em;
    }
    
}
