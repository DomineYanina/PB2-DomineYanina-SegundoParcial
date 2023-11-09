package ar.edu.unlam.pb2.Parcial01;

public interface Vendible {
	
	public String codigo = null;
	public String nombre=null;
	public double precio=0.0;
	
	public String getCodigo();
	public String getNombre();
	public Double getPrecio();
	public void setCodigo(String codigo);
	public void setNombre(String nombre);
	public void setPrecio(double precio);
	public void setCantidad(int cantidad);
	public Integer getCantidad();
	
	
}
