package email;

public class EmailModel {

	private String destinataire;
	private String message;
	private String objet;
	private String password;
	private String numero;


	public EmailModel(String destinataire, String message, String objet, String password, String numero) {
		super();
		this.destinataire = destinataire;
		this.message = message;
		this.objet = objet;
		this.password = password;
		this.numero = numero;
	}


	public String getDestinataire() {
		return destinataire;
	}


	public void setDestinataire(String destinataire) {
		this.destinataire = destinataire;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public String getObjet() {
		return objet;
	}


	public void setObjet(String objet) {
		this.objet = objet;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getNumero() {
		return numero;
	}


	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	
	
}
