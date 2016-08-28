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
 * Esta clase se encuentran los metodos para el manejo de los datos (CRUD) del objeto TipoDocu
 * @author Alexander José
 * @version 1.0
 */
public class TipoDocuCtrl {

    /**
     * Metodo para guardar los datos ingresados por el usuario
     * @param obje Objeto TipoDocu
     * @return boolean con el resultado de la ejecución
     */
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

    /**
     * Metodo para consultar todos los tipos de documentos existentes
     * @return List con los datos encontrados por la consulta
     */
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

    /**
     * Metodo para consultar el tipo de documento seleccionado
     * @param idDocu Id del tipo de documento a buscar
     * @return Objeto TipoDocu
     */
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

    /**
     * Metodo para actualizar los datos del registro
     * @param obje Objeto TipoDocu
     * @return boolean con el resultado de la ejecución
     */
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

    /**
     * Metodo para eliminar un registro
     * @param obje Objeto TipoDocu
     * @return boolean con el resultado de la ejecución
     */
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
