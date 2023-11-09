package test;
import ar.edu.unlam.pb2.Parcial01.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class testTienda {
	
	@Test
	public void queSePuedaAgregarProductos() throws VendibleInexistenteException {
		Tienda tienda = new Tienda("30123456780", "Tienda de ejemplo");
		Producto producto = new Producto("1","Producto nuevo", 15.0, 100);
		tienda.agregarProducto(producto);
		Vendible productoActual = (Producto) tienda.getVendible(producto.getCodigo());
		assertEquals(producto, productoActual);
	}
	
	@Test
	public void queSePuedaAgregarStock() throws VendibleInexistenteException {
		Tienda tienda = new Tienda("30123456780", "Tienda de ejemplo");
		Producto producto = new Producto("1","Producto nuevo", 15.0, 100);
		Integer cantidad = 10;
		tienda.agregarProducto(producto, cantidad);
		Integer stockActual = tienda.getStock((Producto) producto); 
		assertEquals(cantidad, stockActual);
		
		
	}
	
	@Test
	public void queSePuedaAgregarUnCliente() throws ClienteInexistenteException {
		Tienda tienda = new Tienda("30123456780", "Tienda de ejemplo");
		String cuitEjemplo = "30123456780";
		Cliente cliente = new Cliente(cuitEjemplo, "Cliente de ejemplo");
		tienda.agregarCliente(cliente);
		Cliente clienteActual = tienda.getCliente(cuitEjemplo);
		assertEquals(cliente, clienteActual);
		
	}
	
	@Test
	public void queSePuedaAgregarUnVendedor() throws VendedorInexistenteException {
		Tienda tienda = new Tienda("30123456780", "Tienda de ejemplo");
		String dniEjemplo = "12345678";
		Vendedor vendedor = new Vendedor (dniEjemplo, "Vendedor de ejemplo");
		tienda.agregarVendedor(vendedor);
		Vendedor vendedorActual = tienda.getVendedor(dniEjemplo);
		assertEquals(vendedor, vendedorActual);
		
	}
	
	@Test
	public void queSePuedaHacerUnaVentaDeUnProducto() throws VentaInexistenteException, VendibleInexistenteException, StockInsuficienteException {
		Tienda tienda = new Tienda("30123456780", "Tienda de ejemplo");
		String cuitCliente = "30123456780";
		Cliente cliente = new Cliente(cuitCliente, "Cliente de ejemplo");
		tienda.agregarCliente(cliente);
		String dniEjemplo = "12345678";
		Vendedor vendedor = new Vendedor (dniEjemplo, "Vendedor de ejemplo");
		Producto producto = new Producto("1","Producto nuevo", 15.0, 100);
		Integer stockInicial = 10;
		tienda.agregarProducto((Producto) producto, stockInicial);
		Venta ticket = new Venta("C-0001", cliente, vendedor);
		tienda.agregarVenta(ticket);
		Integer cantidadVendida = 5;
		tienda.agregarProductoAVenta(ticket.getCodigo(), (Producto) producto, cantidadVendida);
		Integer stockEsperado = 5;
		Integer stockActual = tienda.getStock((Producto) producto);
		assertEquals(stockEsperado, stockActual);
		
	}
	
	
	@Test (expected = StockInsuficienteException.class)
	public void queNoSePuedaAgregarUnaVentaPorStockInsuficiente() throws VentaInexistenteException, VendibleInexistenteException, StockInsuficienteException {
		Tienda tienda = new Tienda("30123456780", "Tienda de ejemplo");
		String cuitCliente = "30123456780";
		Cliente cliente = new Cliente(cuitCliente, "Cliente de ejemplo");
		tienda.agregarCliente(cliente);
		String dniEjemplo = "12345678";
		Vendedor vendedor = new Vendedor (dniEjemplo, "Vendedor de ejemplo");
		Producto producto = new Producto("1","Producto nuevo", 15.0, 100);
		Integer stockInicial = 10;
		tienda.agregarProducto(producto, stockInicial);
		Venta ticket = new Venta("C-0001", cliente, vendedor);
		tienda.agregarVenta(ticket);
		Integer cantidadVendida = 15;
		tienda.agregarProductoAVenta(ticket.getCodigo(), producto, cantidadVendida);
		
	}
	
	@Test
	public void queSePuedaHacerUnaVentaDeUnServicio() throws VentaInexistenteException, VendibleInexistenteException {
		Tienda tienda = new Tienda("30123456780", "Tienda de ejemplo");
		String cuitCliente = "30123456780";
		Cliente cliente = new Cliente(cuitCliente, "Cliente de ejemplo");
		tienda.agregarCliente(cliente);
		String dniEjemplo = "12345678";
		Vendedor vendedor = new Vendedor (dniEjemplo, "Vendedor de ejemplo");
		Servicio servicio = new Servicio("1", "Servicio Técnico", 100.0);
		Vendible producto = new Producto("1","Producto nuevo", 15.0, 100);
		Integer stockInicial = 10;
		tienda.agregarProducto((Producto) producto, stockInicial);
		
		tienda.agregarServicio((Servicio) servicio);
		Venta venta = new Venta("C-0001", cliente, vendedor);
		tienda.agregarVenta(venta);
		tienda.agregarServicioAVenta(venta.getCodigo(), servicio);
		Double totalEsperado = 100d;
		Double totalActual = venta.getTotal();
		assertEquals(totalEsperado, totalActual);
		
	}
	
	@Test
	public void queSePuedaHacerUnaVentaDeUnProductosYServicios() throws VentaInexistenteException, VendibleInexistenteException, StockInsuficienteException {
		Tienda tienda = new Tienda("30123456780", "Tienda de ejemplo");
		String cuitCliente = "30123456780";
		Cliente cliente = new Cliente(cuitCliente, "Cliente de ejemplo");
		tienda.agregarCliente(cliente);
		String dniEjemplo = "12345678";
		Vendedor vendedor = new Vendedor (dniEjemplo, "Vendedor de ejemplo");
		
		Venta venta = new Venta("C-0001", cliente, vendedor);
		tienda.agregarVenta(venta);
		Vendible vendible;
		
		vendible = new Servicio("1", "Servicio Técnico", 100.0);
		tienda.agregarServicio((Servicio) vendible);
		tienda.agregarServicioAVenta(venta.getCodigo(), (Servicio) vendible);
		
		vendible = new Producto("1","Producto nuevo", 15.0, 100);
		Integer stockInicial = 10;
		tienda.agregarProducto((Producto) vendible, stockInicial);
		Integer cantidadVendida = 2;
		tienda.agregarProductoAVenta(venta.getCodigo(), (Producto) vendible, cantidadVendida);
				
		Double totalEsperado = 800d;
		Double totalActual = venta.getTotal();
		assertEquals(totalEsperado, totalActual);
		
	}
	
	@Test
    public void queSePuedaEstablecerElPorcentajeDeComisionDeUnVendedor() {
        // Arrange
        Tienda tienda = new Tienda("30123456780", "Tienda de ejemplo");
        String dniVendedor = "12345678";
        Vendedor vendedor = new Vendedor(dniVendedor, "Vendedor de ejemplo");

        // Act
        tienda.agregarVendedor(vendedor);
        tienda.establecerPorcentajeComisionVendedor(dniVendedor, 10.0);

        // Assert
        double porcentajeComisionEsperado = 10.0;
        double porcentajeComisionActual = tienda.getPorcentajeComisionVendedor(dniVendedor);
        assertEquals(porcentajeComisionEsperado, porcentajeComisionActual, 0.01); // Utiliza una tolerancia
    }

    @Test
    public void queSeCalculeElMontoTotalDeComisionesQueTieneUnVendedor() throws VendedorInexistenteException, StockInsuficienteException, VentaInexistenteException, VendibleInexistenteException {
        // Arrange
        Tienda tienda = new Tienda("30123456780", "Tienda de ejemplo");
        String dniVendedor = "12345678";
        Vendedor vendedor = new Vendedor(dniVendedor, "Vendedor de ejemplo");
        tienda.agregarVendedor(vendedor);

        String cuitCliente = "30123456780";
        Cliente cliente = new Cliente(cuitCliente, "Cliente de ejemplo");
        tienda.agregarCliente(cliente);

        Venta venta1 = new Venta("C-0001", cliente, vendedor);
        Venta venta2 = new Venta("C-0002", cliente, vendedor);
        tienda.agregarVenta(venta1);
        tienda.agregarVenta(venta2);

        tienda.establecerPorcentajeComisionVendedor(dniVendedor, 10.0);

        Vendedor vendedorExistente = tienda.getVendedor(dniVendedor);
        Producto producto = new Producto("1", "Producto nuevo", 15.0, 100);
        tienda.agregarProducto(producto, 10);

        tienda.agregarProductoAVenta(venta1.getCodigo(), producto, 2);
        tienda.agregarProductoAVenta(venta2.getCodigo(), producto, 3);

        // Act
        double montoTotalEsperado = (2 * 15 + 3 * 15) * 0.10; // Total de ventas x comisión
        double montoTotalActual = tienda.calcularMontoTotalComisionesVendedor(dniVendedor);

        // Assert
        assertEquals(montoTotalEsperado, montoTotalActual, 0.01); // Utiliza una tolerancia
    }

}