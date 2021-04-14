/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.User;

/**
 *
 * @author OUSMANE
 */
@ManagedBean
@SessionScoped
public class UserManagedBean implements Serializable{

    /**
     * Creates a new instance of UserManagedBean
     */
    public UserManagedBean() {
    }
    private User user=new User();
    private List<User>  userList=new ArrayList<>();
    
    public String connect(){
        if("essa".equals(this.user.getLogin()) && "essa".equals(this.user.getPassword())){
            this.user.setPrenom("Drame");
            return "accueil";
        } else {
            return "";
        }
    }
    
    /**
     * Pas besoin de donner l'objet user en argument car c'est déjà mise à jour par JSF
     * 1- verifier si tous les champs sont corrects 
     * 2-ajouter à la liste
     * @return 
     */
    public String addUser(){
        if(!this.user.getNom().equals("") && !this.user.getPrenom().equals("")){
            userList.add(0, user.clone());
             this.user.setNom("");
            this.user.setPrenom("");
            System.out.println(userList);
            return "";
        }
        return "";
    }
    
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    
    
}
