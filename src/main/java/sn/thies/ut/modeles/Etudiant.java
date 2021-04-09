/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sn.thies.ut.modeles;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author PC
 */
@Entity
@Table(name = "etudiant")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Etudiant.findAllTrue", query = "SELECT e FROM Etudiant e WHERE e.valide=true")
    ,@NamedQuery(name = "Etudiant.findAllFalse", query = "SELECT e FROM Etudiant e WHERE e.valide=false")
    , @NamedQuery(name = "Etudiant.findByUserIduser", query = "SELECT e FROM Etudiant e WHERE e.userIduser = :userIduser")
    , @NamedQuery(name = "Etudiant.findByNumeroDossier", query = "SELECT e FROM Etudiant e WHERE e.numeroDossier = :numeroDossier")
    , @NamedQuery(name = "Etudiant.findByNom", query = "SELECT e FROM Etudiant e WHERE e.nom = :nom")
    , @NamedQuery(name = "Etudiant.findByPrenom", query = "SELECT e FROM Etudiant e WHERE e.prenom = :prenom")
    , @NamedQuery(name = "Etudiant.findByDateNaissance", query = "SELECT e FROM Etudiant e WHERE e.dateNaissance = :dateNaissance")
    , @NamedQuery(name = "Etudiant.findByValide", query = "SELECT e FROM Etudiant e WHERE e.valide = :valide")
    , @NamedQuery(name = "Etudiant.findByDateCreation", query = "SELECT e FROM Etudiant e WHERE e.dateCreation = :dateCreation")})
public class Etudiant implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "user_iduser")
    private Integer userIduser;
    @Basic(optional = false)
    @Column(name = "numero_dossier")
    private String numeroDossier;
    @Basic(optional = false)
    @Column(name = "nom")
    private String nom;
    @Basic(optional = false)
    @Column(name = "prenom")
    private String prenom;
    @Basic(optional = false)
    @Column(name = "date_naissance")
    @Temporal(TemporalType.DATE)
    private Date dateNaissance;
    @Basic(optional = false)
    @Column(name = "valide")
    private boolean valide;
    @Basic(optional = false)
    @Column(name = "date_creation")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreation;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "etudiantUserIduser")
    private List<Emprunt> empruntList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "etudiantUserIduser")
    private List<Reservation> reservationList;
    @JoinColumn(name = "image_cle", referencedColumnName = "cle")
    @ManyToOne(optional = false)
    private Image imageCle;
    @JoinColumn(name = "user_iduser", referencedColumnName = "iduser", insertable = false, updatable = false)
    @OneToOne(optional = true)
    private UserModel userModel;

    public Etudiant() {
    }

    public Etudiant(Integer userIduser) {
        this.userIduser = userIduser;
    }

    public Etudiant(Integer userIduser, String numeroDossier, String nom, String prenom, Date dateNaissance, boolean valide, Date dateCreation) {
        this.userIduser = userIduser;
        this.numeroDossier = numeroDossier;
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.valide = valide;
        this.dateCreation = dateCreation;
    }

    public Integer getUserIduser() {
        return userIduser;
    }

    public void setUserIduser(Integer userIduser) {
        this.userIduser = userIduser;
    }

    public String getNumeroDossier() {
        return numeroDossier;
    }

    public void setNumeroDossier(String numeroDossier) {
        this.numeroDossier = numeroDossier;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public boolean getValide() {
        return valide;
    }

    public void setValide(boolean valide) {
        this.valide = valide;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    @XmlTransient
    public List<Emprunt> getEmpruntList() {
        return empruntList;
    }
/*
    public void setEmpruntList(List<Emprunt> empruntList) {
        this.empruntList = empruntList;
    }
*/
    @XmlTransient
    public List<Reservation> getReservationList() {
        return reservationList;
    }
/*
    public void setReservationList(List<Reservation> reservationList) {
        this.reservationList = reservationList;
    }
*/
    public Image getImageCle() {
        return imageCle;
    }

    public void setImageCle(Image imageCle) {
        this.imageCle = imageCle;
    }

    public UserModel getUser() {
        return userModel;
    }

    public void setUser(UserModel userModel) {
        this.userModel = userModel;
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
        if (!(object instanceof Etudiant)) {
            return false;
        }
        Etudiant other = (Etudiant) object;
        if ((this.userIduser == null && other.userIduser != null) || (this.userIduser != null && !this.userIduser.equals(other.userIduser))) {
            return false;
        }
        return true;
    }

}
