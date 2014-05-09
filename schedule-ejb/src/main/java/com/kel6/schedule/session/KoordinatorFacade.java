/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.kel6.schedule.session;

import com.kel6.schedule.entities.Dosen;
import com.kel6.schedule.entities.Koordinator;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Esa_Lucu
 */
@Stateless
public class KoordinatorFacade extends AbstractFacade<Koordinator> {
    @PersistenceContext(unitName = "com.rpl_schedule-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public KoordinatorFacade() {
        super(Koordinator.class);
    }
    
    public Koordinator getKoordinatorByNik(String nik){
        String query = "SELECT k FROM Koordinator k WHERE k.nikDosen.nikDosen = ?1";
        Query createNamedQuery = getEntityManager().createQuery(query);

        createNamedQuery.setParameter(1, nik);

        if (createNamedQuery.getResultList().size() > 0) {
            return (Koordinator) createNamedQuery.getSingleResult();
        }
        else {
            return null;
        }
    }
    
}
