package ar.edu.unlam.pb2.Parcial01;

import java.util.HashMap;
import java.util.Map;

public class Tienda {
    private String cuit;
    private String nombre;
    private Map<String, Vendible> vendibles = new HashMap<>();
    private Map<String, Integer> stock = new HashMap<>();
    private Map<String, Cliente> clientes = new HashMap<>();
    private Map<String, Vendedor> vendedores = new HashMap<>();
    private Map<String, Venta> ventas = new HashMap<>();

    public Tienda(String cuit, String nombre) {
        this.cuit = cuit;
        this.nombre = nombre;
    }
    

    public void agregarServicio(Servicio servicio) {
        vendibles.put(servicio.getCodigo(), servicio);
        stock.put(servicio.getCodigo(), 0);
    }
    
    public void agregarProducto(Producto producto) {
        vendibles.put(producto.getCodigo(), producto);
        stock.put(producto.getCodigo(), 0);
    }

    public void agregarProducto(Producto producto, int cantidad) {
        vendibles.put(producto.getCodigo(), producto);
        stock.put(producto.getCodigo(), cantidad);
    }

    public void agregarCliente(Cliente cliente) {
        clientes.put(cliente.getCuit(), cliente);
    }

    public void agregarVendedor(Vendedor vendedor) {
        vendedores.put(vendedor.getDni(), vendedor);
    }

    public void agregarVenta(Venta venta) {
        ventas.put(venta.getCodigo(), venta);
        venta.getVendedor().agregarVenta(venta);
    }

    public void agregarProductoAVenta(String codigoVenta, Producto producto, int cantidad) throws StockInsuficienteException, VentaInexistenteException, VendibleInexistenteException {
        Venta venta = ventas.get(codigoVenta);
        if (venta == null) {
            throw new VentaInexistenteException("Venta no encontrada: " + codigoVenta);
        }
        String codigoProducto = producto.getCodigo();
        if (!vendibles.containsKey(codigoProducto)) {
            throw new VendibleInexistenteException("Producto no encontrado: " + codigoProducto);
        }
        int stockDisponible = stock.get(codigoProducto);
        if (stockDisponible < cantidad) {
            throw new StockInsuficienteException("Stock insuficiente para la venta.");
        }
        stock.put(codigoProducto, stockDisponible - cantidad);
        venta.agregarVendible(producto, cantidad);
    }
    
    public void agregarServicioAVenta(String codigoVenta, Servicio servicio) throws VentaInexistenteException, VendibleInexistenteException {
        Venta venta = ventas.get(codigoVenta);
        
        if (venta == null) {
            throw new VentaInexistenteException("Venta no encontrada: " + codigoVenta);
        }
        
        String codigoServicio = servicio.getCodigo();
        
        if (!vendibles.containsKey(codigoServicio)) {
            throw new VendibleInexistenteException("Servicio no encontrado: " + codigoServicio);
        }
        
        venta.agregarVendible(servicio, 1); // Agregar el servicio con cantidad 1 a la venta
    }


    public Double getTotalVenta(String codigoVenta) throws VentaInexistenteException {
        Venta venta = ventas.get(codigoVenta);
        if (venta == null) {
            throw new VentaInexistenteException("Venta no encontrada: " + codigoVenta);
        }
        return venta.calcularTotal();
    }

    public Vendible getVendible(String codigo) throws VendibleInexistenteException {
        Vendible vendible = vendibles.get(codigo);
        if (vendible == null) {
            throw new VendibleInexistenteException("Vendible no encontrado: " + codigo);
        }
        return vendible;
    }

    public Integer getStock(Producto producto) {
        return stock.get(producto.getCodigo());
    }

    public Cliente getCliente(String cuit) throws ClienteInexistenteException {
        Cliente cliente = clientes.get(cuit);
        if (cliente == null) {
            throw new ClienteInexistenteException("Cliente no encontrado: " + cuit);
        }
        return cliente;
    }

    public Vendedor getVendedor(String dni) throws VendedorInexistenteException {
        Vendedor vendedor = vendedores.get(dni);
        if (vendedor == null) {
            throw new VendedorInexistenteException("Vendedor no encontrado: " + dni);
        }
        return vendedor;
    }
    
    public void establecerPorcentajeComisionVendedor(String dniVendedor, double porcentajeComision) {
        Vendedor vendedor = vendedores.get(dniVendedor);
        if (vendedor != null) {
            vendedor.setPorcentajeComision(porcentajeComision);
        }
    }

    public double getPorcentajeComisionVendedor(String dniVendedor) {
        Vendedor vendedor = vendedores.get(dniVendedor);
        if (vendedor != null) {
            return vendedor.getPorcentajeComision();
        }
        return 0.0; // Si el vendedor no existe, retornar 0.
    }

    
    public double calcularMontoTotalComisionesVendedor(String dniVendedor) throws VendedorInexistenteException {
        Vendedor vendedor = vendedores.get(dniVendedor);
        if (vendedor != null) {
            double totalComisiones = 0.0;
            for (Venta venta : ventas.values()) {
                if (venta.getVendedor().getDni().equals(dniVendedor)) {
                    totalComisiones += venta.getComisionVendedor();
                }
            }
            return totalComisiones;
        }
        throw new VendedorInexistenteException("Vendedor no encontrado: " + dniVendedor);
    }

}
