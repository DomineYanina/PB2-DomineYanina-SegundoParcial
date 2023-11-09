package ar.edu.unlam.pb2.Parcial01;

public class Servicio implements Vendible {
	private String codigo;
	private String nombre;
    private double precio;
    
    public Servicio(String codigo,String nombre, double precio) {
        this.codigo=codigo;
    	this.nombre = nombre;
        this.precio = precio;
    }

    @Override
    public String getNombre() {
        return this.nombre;
    }

    @Override
    public Double getPrecio() {
        return this.precio;
    }

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	@Override
	public void setCantidad(int cantidad) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Integer getCantidad() {
		// TODO Auto-generated method stub
		return 1;
	}

}
