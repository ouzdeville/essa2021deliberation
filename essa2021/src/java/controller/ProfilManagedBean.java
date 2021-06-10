/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import model.Profil;

/**
 *
 * @author OUSMANE
 */
@ManagedBean
@RequestScoped
public class ProfilManagedBean implements Serializable{

    /**
     * Creates a new instance of ProfilManagedBean
     */
    public ProfilManagedBean() {
    }
    private List<Profil> profilList;
    private Profil profil;
    private EntityManager em;
    @PostConstruct
    public void init(){
        EntityManagerFactory emf=Persistence.createEntityManagerFactory("essa2021PU");
        em=emf.createEntityManager();
        profil=new Profil();
        
    }
    
   public List<Profil> getProfilList(){
       Query cq = em.createNamedQuery("Profil.findAll");
        List<Profil> list = cq.getResultList();
        return list;
   }
   
   public void delete(){
       em.getTransaction().begin();
        em.remove(this.profil);
        em.getTransaction().commit();
   }

    public Profil getProfil() {
        return profil;
    }

    public void setProfil(Profil profil) {
        this.profil = profil;
    }
   
    public void modify(){
        em.getTransaction().begin();
        em.merge(this.profil);
        em.getTransaction().commit();
    }
    
    public void create(){
        em.getTransaction().begin();
        em.persist(this.profil);
        em.getTransaction().commit();
    }
    
    
}
