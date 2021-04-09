/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sn.thies.ut.modeles;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author PC
 */
@Entity
@Table(name = "image")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Image.findAll", query = "SELECT i FROM Image i")
    , @NamedQuery(name = "Image.findByCle", query = "SELECT i FROM Image i WHERE i.cle = :cle")
    , @NamedQuery(name = "Image.findByNom", query = "SELECT i FROM Image i WHERE i.nom = :nom")
    , @NamedQuery(name = "Image.findByUrl", query = "SELECT i FROM Image i WHERE i.url = :url")})
public class Image implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @Column(name = "cle")
    private int cle;
    @Basic(optional = false)
    @Column(name = "nom")
    private String nom;
    @Basic(optional = false)
    @Column(name = "url")
    private String url;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "imageCle")
    private List<Etudiant> etudiantList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "imageCle")
    private List<Livre> livreList;

    public Image() {
    }

    public Image(int cle) {
        this.cle = cle;
    }

    public Image(int cle, String nom, String url) {
        this.cle = cle;
        this.nom = nom;
        this.url = url;
    }

    public int getCle() {
        return cle;
    }

    public void setCle(int cle) {
        this.cle = cle;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


 
    
}
