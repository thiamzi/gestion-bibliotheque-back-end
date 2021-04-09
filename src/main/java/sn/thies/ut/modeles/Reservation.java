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
@Table(name = "reservation")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reservation.Encours", query = "SELECT r FROM Reservation r WHERE r.regle = false")
    , @NamedQuery(name = "Reservation.Reglees", query = "SELECT r FROM Reservation r WHERE r.regle = true")
    , @NamedQuery(name = "Reservation.findByNumeroReservation", query = "SELECT r FROM Reservation r WHERE r.numeroReservation = :numeroReservation")
    , @NamedQuery(name = "Reservation.findByDate", query = "SELECT r FROM Reservation r WHERE r.date = :date")
    , @NamedQuery(name = "Reservation.findByRegle", query = "SELECT r FROM Reservation r WHERE r.regle = :regle")})
public class Reservation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "numero_reservation")
    private Integer numeroReservation;
    @Basic(optional = false)
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Basic(optional = false)
    @Column(name = "date_fin")
    @Temporal(TemporalType.DATE)
    private Date dateFin;
    @Basic(optional = false)
    @Column(name = "regle")
    private boolean regle;
    @JoinColumn(name = "etudiant_user_iduser", referencedColumnName = "user_iduser")
    @ManyToOne(optional = false)
    private Etudiant etudiantUserIduser;
    @JoinColumn(name = "livre_idlivre", referencedColumnName = "idlivre")
    @ManyToOne(optional = false)
    private Livre livreIdlivre;

    public Reservation() {
    }

    public Reservation(Integer numeroReservation) {
        this.numeroReservation = numeroReservation;
    }



    public Reservation(Integer numeroReservation, Date date, Date dateFin, boolean regle) {
		super();
		this.numeroReservation = numeroReservation;
		this.date = date;
		this.dateFin = dateFin;
		this.regle = regle;
	}

	public Integer getNumeroReservation() {
        return numeroReservation;
    }

    public void setNumeroReservation(Integer numeroReservation) {
        this.numeroReservation = numeroReservation;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    

    public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
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
        hash += (numeroReservation != null ? numeroReservation.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reservation)) {
            return false;
        }
        Reservation other = (Reservation) object;
        if ((this.numeroReservation == null && other.numeroReservation != null) || (this.numeroReservation != null && !this.numeroReservation.equals(other.numeroReservation))) {
            return false;
        }
        return true;
    }

    
}
