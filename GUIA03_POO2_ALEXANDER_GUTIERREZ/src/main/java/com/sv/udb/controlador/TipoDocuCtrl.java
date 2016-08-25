/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.controlador;

import com.sv.udb.modelo.TipoDocu;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Alexander José
 */
public class TipoDocuCtrl {

    public boolean guar(TipoDocu obje) {
        boolean resp = false;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("POOPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        try {
            em.persist(obje);
            et.commit();
            resp = true;
        } catch (Exception ex) {
            et.rollback();
            ex.printStackTrace();
        }
        em.close();
        emf.close();
        return resp;
    }

    public List<TipoDocu> consTodo() {
        List<TipoDocu> resp = new ArrayList<>();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("POOPU");
        EntityManager em = emf.createEntityManager();
        try {
            final CriteriaBuilder cb = em.getCriteriaBuilder();
            final CriteriaQuery<TipoDocu> q = cb.createQuery(TipoDocu.class);
            final Root<TipoDocu> Acce = q.from(TipoDocu.class);
            q.select(Acce);
            List<TipoDocu> result = em.createQuery(q).getResultList();
            for (TipoDocu l : result) {
                resp.add(new TipoDocu(l.getCodiTipoDocu(), l.getNombTipoDocu(), l.getFechAlta(), l.getFechBaja(), l.getEsta()));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        em.close();
        emf.close();
        return resp;
    }

    public TipoDocu cons(int idDocu) {
        TipoDocu resp = null;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("POOPU");
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<TipoDocu> query = em.createNamedQuery("TipoDocu.findByCodiTipoDocu", TipoDocu.class);
            query.setParameter("codiTipoDocu", idDocu);
            List<TipoDocu> result = query.getResultList();
            for (TipoDocu l : result) {
                resp = new TipoDocu(l.getCodiTipoDocu(), l.getNombTipoDocu(), l.getFechAlta(), l.getFechBaja(), l.getEsta());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        em.close();
        emf.close();
        return resp;
    }

    public boolean actu(TipoDocu obje) {
        boolean resp = false;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("POOPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            TipoDocu obj = em.find(TipoDocu.class, obje.getCodiTipoDocu());
            obj.setNombTipoDocu(obje.getNombTipoDocu());
            em.getTransaction().commit();
            resp = true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        em.close();
        emf.close();
        return resp;
    }

    public boolean elim(TipoDocu obje) {
        boolean resp = false;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("POOPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        TipoDocu tipoDocu;
        try {
            tipoDocu = em.getReference(TipoDocu.class, obje.getCodiTipoDocu());
            tipoDocu.getCodiTipoDocu();
            em.remove(tipoDocu);
            et.commit();
            resp = true;
        } catch (Exception ex) {
            et.rollback();
            ex.printStackTrace();
        }
        em.close();
        emf.close();
        return resp;
    }
}
