package ar.edu.unlam.pb2.Parcial01;

public class Cliente extends Persona {
	private String email;
	private String cuit;

	public Cliente(String cuit,String nombre) {
		super(nombre);
		this.cuit=cuit;
		// TODO Auto-generated constructor stub
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String getNombre() {
		// TODO Auto-generated method stub
		return super.getNombre();
	}

	public String getCuit() {
		return cuit;
	}

	public void setCuit(String cuit) {
		this.cuit = cuit;
	}
	
}
