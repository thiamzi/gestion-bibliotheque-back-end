/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sn.thies.ut.modeles;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author PC
 */
@Entity
@Table(name = "emprunt")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "Emprunt.Nouveaux", query = "SELECT e FROM Emprunt e WHERE e.confirmer = false AND e.regle = false")
    , @NamedQuery(name = "Emprunt.Regles", query = "SELECT e FROM Emprunt e WHERE e.confirmer = true AND e.regle = true")
    , @NamedQuery(name = "Emprunt.EnCours", query = "SELECT e FROM Emprunt e WHERE e.confirmer = true AND e.regle = false")
    , @NamedQuery(name = "Emprunt.EnRetard", query = "SELECT e FROM Emprunt e WHERE e.confirmer = true AND e.regle = false AND e.dateFin < :now")
    , @NamedQuery(name = "Emprunt.findByNumeroEmprunt", query = "SELECT e FROM Emprunt e WHERE e.numeroEmprunt = :numeroEmprunt")
    , @NamedQuery(name = "Emprunt.findByDateDebut", query = "SELECT e FROM Emprunt e WHERE e.dateDebut = :dateDebut")
    , @NamedQuery(name = "Emprunt.findByDateFin", query = "SELECT e FROM Emprunt e WHERE e.dateFin = :dateFin")
    , @NamedQuery(name = "Emprunt.findByDateremise", query = "SELECT e FROM Emprunt e WHERE e.dateremise = :dateremise")
    , @NamedQuery(name = "Emprunt.findByConfirmer", query = "SELECT e FROM Emprunt e WHERE e.confirmer = :confirmer")
    , @NamedQuery(name = "Emprunt.findByRegle", query = "SELECT e FROM Emprunt e WHERE e.regle = :regle")})
public class Emprunt implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "numero_emprunt")
    private Integer numeroEmprunt;
    @Basic(optional = false)
    @Column(name = "date_debut")
    @Temporal(TemporalType.DATE)
    private Date dateDebut;
    @Basic(optional = false)
    @Column(name = "date_fin")
    @Temporal(TemporalType.DATE)
    private Date dateFin;
    @Column(name = "dateremise")
    @Temporal(TemporalType.DATE)
    private Date dateremise;
    @Basic(optional = false)
    @Column(name = "confirmer")
    private boolean confirmer;
    @Basic(optional = false)
    @Column(name = "regle")
    private boolean regle;
    @Basic(optional = false)
    @Column(name = "delai_recup")
    private Date delai_recup;
    @JoinColumn(name = "etudiant_user_iduser", referencedColumnName = "user_iduser")
    @ManyToOne(optional = false)
    private Etudiant etudiantUserIduser;
    @JoinColumn(name = "livre_idlivre", referencedColumnName = "idlivre")
    @ManyToOne(optional = false)
    private Livre livreIdlivre;

    public Emprunt() {
    }

    public Emprunt(Integer numeroEmprunt) {
        this.numeroEmprunt = numeroEmprunt;
    }

    public Emprunt(Integer numeroEmprunt, Date dateDebut, Date delai_recup, Date dateFin, boolean confirmer, boolean regle) {
        this.numeroEmprunt = numeroEmprunt;
        this.dateDebut = dateDebut;
        this.delai_recup = delai_recup;
        this.dateFin = dateFin;
        this.confirmer = confirmer;
        this.regle = regle;
    }

    public Integer getNumeroEmprunt() {
        return numeroEmprunt;
    }

    public void setNumeroEmprunt(Integer numeroEmprunt) {
        this.numeroEmprunt = numeroEmprunt;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }
    

    public Date getDelai_recup() {
		return delai_recup;
	}

	public void setDelai_recup(Date delai_recup) {
		this.delai_recup = delai_recup;
	}

	public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public Date getDateremise() {
        return dateremise;
    }

    public void setDateremise(Date dateremise) {
        this.dateremise = dateremise;
    }

    public boolean getConfirmer() {
        return confirmer;
    }

    public void setConfirmer(boolean confirmer) {
        this.confirmer = confirmer;
    }

    public boolean getRegle() {
        return regle;
    }

    public void setRegle(boolean regle) {
        this.regle = regle;
    }

    public int getEtudiantUserIduser() {
        return etudiantUserIduser.getUserIduser();
    }
/*
    public void setEtudiantUserIduser(Etudiant etudiantUserIduser) {
        this.etudiantUserIduser = etudiantUserIduser;
    }
*/
    public int getLivreIdlivre() {
        return livreIdlivre.getIdlivre();
    }
/*
    public void setLivreIdlivre(Livre livreIdlivre) {
        this.livreIdlivre = livreIdlivre;
    }
*/
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numeroEmprunt != null ? numeroEmprunt.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Emprunt)) {
            return false;
        }
        Emprunt other = (Emprunt) object;
        if ((this.numeroEmprunt == null && other.numeroEmprunt != null) || (this.numeroEmprunt != null && !this.numeroEmprunt.equals(other.numeroEmprunt))) {
            return false;
        }
        return true;
    }

}
