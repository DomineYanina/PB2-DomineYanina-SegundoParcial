package ar.edu.unlam.pb2.Parcial01;
import java.util.ArrayList;
import java.util.List;

public class Vendedor extends Persona {
	
	String dni;
	double porcentajeComision;
	List<Venta> ventasRealizadas = new ArrayList<>();
	
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
	
	public double getComisionesObtenidas() {
		double comisionesObtenidas=0.0;
		for (Venta ven : ventasRealizadas) {
			comisionesObtenidas=+ven.getTotal();
		}
		comisionesObtenidas=((comisionesObtenidas*this.porcentajeComision)/100);
		return comisionesObtenidas;
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
	
	public List<Venta> getVentasRealizadas() {
		return this.ventasRealizadas;
	}
}
