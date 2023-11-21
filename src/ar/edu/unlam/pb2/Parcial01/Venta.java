package ar.edu.unlam.pb2.Parcial01;

import java.util.HashMap;
import java.util.Map;

public class Venta {
	private String codigo;
	private Vendedor vendedor;
	private Map<String, Vendible> items = new HashMap<>();
	private Cliente cliente;
	private Double total;
	private Double comisionVendedor;
	
	public Venta(String codigo, Cliente cliente, Vendedor vendedor, Integer cantidad) {
		super();
		this.codigo = codigo;
		this.cliente = cliente;
		this.vendedor = vendedor;
	}
	
	public void setComisionVendedor() {
		this.comisionVendedor=((this.total*vendedor.getPorcentajeComision())/100);
	}
	
	public double getComisionVendedor() {
		return this.comisionVendedor;
	}
	
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Map<String, Vendible> getItems() {
		return items;
	}

	public void setItems(Map<String, Vendible> items) {
		this.items = items;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}
	
	public Double calcularTotal() {
        this.total = 0.0;

        for (Vendible vendible : items.values()) {
            this.total += vendible.getPrecio() * vendible.getCantidadVendida();
        }

        return this.total;
    }

	public void agregarVendible(Vendible vendible, int cantidad) {
        String codigo = vendible.getCodigo();

        if (items.containsKey(codigo)) {
            Vendible itemExistente = items.get(codigo);
            itemExistente.setCantidad(itemExistente.getCantidadVendida() + cantidad);
        } else {
            vendible.setCantidadVendida(cantidad);
            items.put(codigo, vendible);
        }

        // Actualizar el total de la venta
        this.total = calcularTotal();
        setComisionVendedor();
    }

	public Vendedor getVendedor() {
		return vendedor;
	}

	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}

	
	
}
