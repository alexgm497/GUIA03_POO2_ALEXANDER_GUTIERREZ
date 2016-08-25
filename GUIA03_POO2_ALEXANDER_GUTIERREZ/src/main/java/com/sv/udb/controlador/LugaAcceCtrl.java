/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.controlador;

import com.sv.udb.modelo.LugaAcce;
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
public class LugaAcceCtrl {

    public boolean guar(LugaAcce obje) {
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

    public List<LugaAcce> consTodo() {
        List<LugaAcce> resp = new ArrayList<>();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("POOPU");
        EntityManager em = emf.createEntityManager();
        try {
            final CriteriaBuilder cb = em.getCriteriaBuilder();
            final CriteriaQuery<LugaAcce> q = cb.createQuery(LugaAcce.class);
            final Root<LugaAcce> Acce = q.from(LugaAcce.class);
            q.select(Acce);
            List<LugaAcce> result = em.createQuery(q).getResultList();
            for (LugaAcce l : result) {
                resp.add(new LugaAcce(l.getCodiLugaAcce(), l.getNombLugaAcce(), l.getFechAlta(), l.getFechBaja(), l.getEsta()));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        em.close();
        emf.close();
        return resp;
    }

    public LugaAcce cons(int idAcce) {
        LugaAcce resp = null;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("POOPU");
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<LugaAcce> query = em.createNamedQuery("LugaAcce.findByCodiLugaAcce", LugaAcce.class);
            query.setParameter("codiLugaAcce", idAcce);
            List<LugaAcce> result = query.getResultList();
            for (LugaAcce l : result) {
                resp = new LugaAcce(l.getCodiLugaAcce(), l.getNombLugaAcce(), l.getFechAlta(), l.getFechBaja(), l.getEsta());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        em.close();
        emf.close();
        return resp;
    }

    public boolean actu(LugaAcce obje) {
        boolean resp = false;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("POOPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            LugaAcce obj = em.find(LugaAcce.class, obje.getCodiLugaAcce());
            obj.setNombLugaAcce(obje.getNombLugaAcce());
            em.getTransaction().commit();
            resp = true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        em.close();
        emf.close();
        return resp;
    }

    public boolean elim(LugaAcce obje) {
        boolean resp = false;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("POOPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        LugaAcce lugaAcce;
        try {
            lugaAcce = em.getReference(LugaAcce.class, obje.getCodiLugaAcce());
            lugaAcce.getCodiLugaAcce();
            em.remove(lugaAcce);
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
