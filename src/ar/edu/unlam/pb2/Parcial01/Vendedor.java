package ar.edu.unlam.pb2.Parcial01;
import java.util.ArrayList;
import java.util.List;

public class Vendedor extends Persona {
	
	String dni;
	
	List<Venta> ventasRealizadas = new ArrayList<>();
	
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

	@Override
	public String getNombre() {
		// TODO Auto-generated method stub
		return super.getNombre();
	}
	
	public void agregarVenta(Venta venta) {
		ventasRealizadas.add(venta);
	}
	
	
	public Integer getCantidadDeVentasRealizadas() {
		return ventasRealizadas.size();
	}
}
