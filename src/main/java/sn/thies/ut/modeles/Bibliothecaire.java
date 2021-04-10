/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sn.thies.ut.modeles;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author PC
 */
@Entity
@Table(name = "bibliothecaire")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bibliothecaire.findAll", query = "SELECT b FROM Bibliothecaire b")
    , @NamedQuery(name = "Bibliothecaire.findByUserIduser", query = "SELECT b FROM Bibliothecaire b WHERE b.userIduser = :userIduser")
    , @NamedQuery(name = "Bibliothecaire.findByNom", query = "SELECT b FROM Bibliothecaire b WHERE b.nom = :nom")
    , @NamedQuery(name = "Bibliothecaire.findByPrenom", query = "SELECT b FROM Bibliothecaire b WHERE b.prenom = :prenom")})
public class Bibliothecaire implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @Column(name = "user_iduser")
    private Integer userIduser;
    @Basic(optional = false)
    @Column(name = "nom")
    private String nom;
    @Basic(optional = false)
    @Column(name = "prenom")
    private String prenom;
    @JoinColumn(name = "user_iduser", referencedColumnName = "iduser", insertable = true, updatable = true)
    @OneToOne(optional = false)
    private UserModel userModel;

    public Bibliothecaire() {
    }

    public Bibliothecaire(Integer userIduser) {
        this.userIduser = userIduser;
    }

    public Bibliothecaire(Integer userIduser, String nom, String prenom) {
        this.userIduser = userIduser;
        this.nom = nom;
        this.prenom = prenom;
    }

    public Integer getUserIduser() {
        return userIduser;
    }

    public void setUserIduser(Integer userIduser) {
        this.userIduser = userIduser;
    }

    public String getNom() {
        return nom;
    }

    public void setNon(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public UserModel getUser() {
        return userModel;
    }

    public void setUser(UserModel user) {
        this.userModel = user;
    }
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userIduser != null ? userIduser.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bibliothecaire)) {
            return false;
        }
        Bibliothecaire other = (Bibliothecaire) object;
        if ((this.userIduser == null && other.userIduser != null) || (this.userIduser != null && !this.userIduser.equals(other.userIduser))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication3.Bibliothecaire[ userIduser=" + userIduser + " ]";
    }
    
}
