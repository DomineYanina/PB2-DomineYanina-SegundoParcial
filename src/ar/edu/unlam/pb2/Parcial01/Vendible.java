package ar.edu.unlam.pb2.Parcial01;

public interface Vendible {
	
	public String codigo = null;
	public String nombre=null;
	public double precio=0.0;
	public Integer cantidadVendida=0;
	
	String getCodigo();
    String getNombre();
    Double getPrecio();
    void setCodigo(String codigo);
    void setNombre(String nombre);
    void setPrecio(double precio);
    void setCantidad(int cantidad);
    Integer getCantidad();
    Integer getCantidadVendida();
    void setCantidadVendida(Integer cantidad);
	
}
