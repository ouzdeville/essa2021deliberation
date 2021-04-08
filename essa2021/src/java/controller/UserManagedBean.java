/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.Serializable;
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
    public String connect(){
        if("essa".equals(this.user.getLogin()) && "essa".equals(this.user.getPassword())){
            this.user.setPrenom("Drame");
            return "accueil";
        } else {
            return "";
        }
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }

    
    
}
