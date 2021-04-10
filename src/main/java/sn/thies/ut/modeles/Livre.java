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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
@Table(name = "livre")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Livre.findAll", query = "SELECT l FROM Livre l WHERE l.nbdisponible > 0 ORDER BY l.dateCreation DESC")
    , @NamedQuery(name = "Livre.findByIdlivre", query = "SELECT l FROM Livre l WHERE l.idlivre = :idlivre")
    , @NamedQuery(name = "Livre.findByTitre", query = "SELECT l FROM Livre l WHERE l.titre = :titre")
    , @NamedQuery(name = "Livre.findByAuteur", query = "SELECT l FROM Livre l WHERE l.auteur = :auteur")
    , @NamedQuery(name = "Livre.findByDescription", query = "SELECT l FROM Livre l WHERE l.description = :description")
    , @NamedQuery(name = "Livre.findByExmplaire", query = "SELECT l FROM Livre l WHERE l.exmplaire = :exmplaire")
    , @NamedQuery(name = "Livre.findByDateCreation", query = "SELECT l FROM Livre l WHERE l.dateCreation = :dateCreation")
    , @NamedQuery(name = "Livre.findByNbdisponible", query = "SELECT l FROM Livre l WHERE l.nbdisponible = :nbdisponible")})
public class Livre implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @Column(name = "idlivre")
    private Integer idlivre;
    @Basic(optional = false)
    @Column(name = "titre")
    private String titre;
    @Basic(optional = false)
    @Column(name = "auteur")
    private String auteur;
    @Basic(optional = false)
    @Column(name = "description" )
    private String description;
    @Basic(optional = false)
    @Column(name = "exmplaire")
    private int exmplaire;
    @Basic(optional = false)
    @Column(name = "date_creation")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreation;
    @Basic(optional = false)
    @Column(name = "nbdisponible")
    private int nbdisponible;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "livreIdlivre")
    private List<Emprunt> empruntList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "livreIdlivre")
    private List<Reservation> reservationList;
    @JoinColumn(name = "categorie_idcategorie", referencedColumnName = "idcategorie" , insertable = true, updatable = true)
    @ManyToOne(optional = false )
    private Categorie categorieIdcategorie;
    @JoinColumn(name = "image_cle", referencedColumnName = "cle")
    @ManyToOne(optional = false)
    private Image imageCle;

    public Livre() {
    }

    public Livre(Integer idlivre) {
        this.idlivre = idlivre;
    }

    public Livre(Integer idlivre, String titre, String auteur, String description, int exmplaire, Date dateCreation, int nbdisponible) {
        this.idlivre = idlivre;
        this.titre = titre;
        this.auteur = auteur;
        this.description = description;
        this.exmplaire = exmplaire;
        this.dateCreation = dateCreation;
        this.nbdisponible = nbdisponible;
    }

    public Integer getIdlivre() {
        return idlivre;
    }

    public void setIdlivre(Integer idlivre) {
        this.idlivre = idlivre;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getExmplaire() {
        return exmplaire;
    }

    public void setExmplaire(int exmplaire) {
        this.exmplaire = exmplaire;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public int getNbdisponible() {
        return nbdisponible;
    }

    public void setNbdisponible(int nbdisponible) {
        this.nbdisponible = nbdisponible;
    }

    @XmlTransient
    public List<Emprunt> getEmpruntList() {
        return empruntList;
    }

    public void setEmpruntList(List<Emprunt> empruntList) {
        this.empruntList = empruntList;
    }

    @XmlTransient
    public List<Reservation> getReservationList() {
        return reservationList;
    }

    public void setReservationList(List<Reservation> reservationList) {
        this.reservationList = reservationList;
    }

    public int getCategorieIdcategorie() {
        return categorieIdcategorie.getIdcategorie();
    }

    public void setCategorieIdcategorie(Categorie categorieIdcategorie) {
        this.categorieIdcategorie = categorieIdcategorie;
    }

    public Image getImageCle() {
        return imageCle;
    }

    public void setImageCle(Image imageCle) {
        this.imageCle = imageCle;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idlivre != null ? idlivre.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Livre)) {
            return false;
        }
        Livre other = (Livre) object;
        if ((this.idlivre == null && other.idlivre != null) || (this.idlivre != null && !this.idlivre.equals(other.idlivre))) {
            return false;
        }
        return true;
    }

    
}
