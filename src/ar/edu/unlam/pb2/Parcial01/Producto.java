package ar.edu.unlam.pb2.Parcial01;

public class Producto implements Vendible  {
	private String codigo;
	private Integer stockActual;
	private String nombre;
    private double precio;
    private Integer cantidadVendida;

    public Producto(String codigo, String nombre, double precio, Integer stockActual) {
        this.codigo=codigo;
    	this.nombre = nombre;
        this.precio = precio;
        this.stockActual=stockActual;
        this.cantidadVendida = 0;
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


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public void realizarCompra(Integer cantidad) {
    	this.stockActual=this.stockActual+cantidad;
    }
    public boolean realizarVenta(Integer cantidad) {
    	boolean exito=false;
    	if(cantidad<this.stockActual||cantidad==this.stockActual) {
    		this.stockActual=this.stockActual-cantidad;
    		exito=true;
    	}
    	return exito;
    }

	@Override
	public void setCodigo(String codigo) {
		// TODO Auto-generated method stub
		this.codigo=codigo;
		
	}

	@Override
	public void setCantidad(int cantidad) {
		this.cantidadVendida=cantidad;
		
	}

	@Override
	public Integer getCantidad() {
		// TODO Auto-generated method stub
		return this.stockActual;
	}

	@Override
	public Integer getCantidadVendida() {
		// TODO Auto-generated method stub
		return this.cantidadVendida;
	}

	@Override
	public void setCantidadVendida(Integer cantidad) {
		this.cantidadVendida=cantidad;
	}


}
