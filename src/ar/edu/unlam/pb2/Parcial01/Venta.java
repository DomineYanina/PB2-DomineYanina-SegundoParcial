package ar.edu.unlam.pb2.Parcial01;

import java.util.HashMap;
import java.util.Map;

public class Venta {
	String codigo;
	Vendedor vendedor;
	private Map<String, Vendible> items = new HashMap<>();
	Cliente cliente;
	Double total;
	
	
	public Venta(String codigo, Cliente cliente, Vendedor vendedor) {
		super();
		this.codigo = codigo;
		this.cliente = cliente;
		this.vendedor = vendedor;
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
        Double total = 0.0;
        
        for (Vendible vendible : items.values()) {
            total += vendible.getPrecio() * vendible.getCantidad();
        }
        
        return total;
    }

	public void agregarVendible(Vendible vendible, int cantidad) {
        String codigo = vendible.getCodigo();
        
        if (items.containsKey(codigo)) {
            Vendible itemExistente = items.get(codigo);
            itemExistente.setCantidad(itemExistente.getCantidad() + cantidad);
        } else {
            vendible.setCantidad(cantidad);
            items.put(codigo, vendible);
        }
    }

	public Vendedor getVendedor() {
		return vendedor;
	}

	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}

	
	
}
