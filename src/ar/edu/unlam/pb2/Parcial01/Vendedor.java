package ar.edu.unlam.pb2.Parcial01;

public class Vendedor extends Persona {
	private int ventas;
	String dni;
	double porcentajeComision;
    public Vendedor(String dni,String nombre) {
		super(nombre);
		this.dni=dni;
		// TODO Auto-generated constructor stub
	}

    

	public String getDni() {
		return dni;
	}



	public void setDni(String dni) {
		this.dni = dni;
	}

	public double getPorcentajeComision() {
        
		return porcentajeComision;
    }

    public void setPorcentajeComision(double porcentajeComision) {
        this.porcentajeComision = porcentajeComision;
    }

	public int getVentas() {
		return ventas;
	}


	public void setVentas(int ventas) {
		this.ventas = ventas;
	}

	
	@Override
	public String getNombre() {
		// TODO Auto-generated method stub
		return super.getNombre();
	}

	public void incrementarVentas() {
        this.ventas++;
    }
}
