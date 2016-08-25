/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.controlador;

import com.sv.udb.modelo.TipoGafe;
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
public class TipoGafeCtrl {

    public boolean guar(TipoGafe obje) {
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

    public List<TipoGafe> consTodo() {
        List<TipoGafe> resp = new ArrayList<>();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("POOPU");
        EntityManager em = emf.createEntityManager();
        try {
            final CriteriaBuilder cb = em.getCriteriaBuilder();
            final CriteriaQuery<TipoGafe> q = cb.createQuery(TipoGafe.class);
            final Root<TipoGafe> Acce = q.from(TipoGafe.class);
            q.select(Acce);
            List<TipoGafe> result = em.createQuery(q).getResultList();
            for (TipoGafe l : result) {
                resp.add(new TipoGafe(l.getCodiTipoGafe(), l.getNombTipoGafe(), l.getFechAlta(), l.getFechBaja(), l.getEsta()));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        em.close();
        emf.close();
        return resp;
    }

    public TipoGafe cons(int idGafe) {
        TipoGafe resp = null;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("POOPU");
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<TipoGafe> query = em.createNamedQuery("TipoGafe.findByCodiTipoGafe", TipoGafe.class);
            query.setParameter("codiTipoGafe", idGafe);
            List<TipoGafe> result = query.getResultList();
            for (TipoGafe l : result) {
                resp = new TipoGafe(l.getCodiTipoGafe(), l.getNombTipoGafe(), l.getFechAlta(), l.getFechBaja(), l.getEsta());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        em.close();
        emf.close();
        return resp;
    }

    public boolean actu(TipoGafe obje) {
        boolean resp = false;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("POOPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            TipoGafe obj = em.find(TipoGafe.class, obje.getCodiTipoGafe());
            obj.setNombTipoGafe(obje.getNombTipoGafe());
            em.getTransaction().commit();
            resp = true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        em.close();
        emf.close();
        return resp;
    }

    public boolean elim(TipoGafe obje) {
        boolean resp = false;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("POOPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        TipoGafe tipoGafe;
        try {
            tipoGafe = em.getReference(TipoGafe.class, obje.getCodiTipoGafe());
            tipoGafe.getCodiTipoGafe();
            em.remove(tipoGafe);
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
