package pedido;

import cliente.Cliente;
import producto.Producto;

public class Venta {
    private
    int id;
    String fecha;
    String clienteDni;
    int productoId;
    int cantidad;
    double precioTotal;

    public Venta(int id, String fecha, String clienteDni, int productoId, int cantidad, double precioTotal) {
        this.id = id;
        this.fecha = fecha;
        this.clienteDni = clienteDni;
        this.productoId = productoId;
        this.cantidad = cantidad;
        this.precioTotal = precioTotal;
    }

    public Venta() {
        this.id = 0;
        this.fecha = "";
        this.clienteDni = "";
        this.productoId = 0;
        this.cantidad = 0;
        this.precioTotal = 0.0;
    }

    public int getId() {
        return id;
    }

    public String getFecha() {
        return fecha;
    }

    public String getClienteDni() {
        return clienteDni;
    }

    public int getProductoId() {
        return productoId;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }


    public void setProductoId(int productoId) {
        this.productoId = productoId;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }

    @Override
    public String toString() {
        return "Pedidos.Venta [cantidad=" + cantidad + ", DNI del Cliente=" + clienteDni + ", fecha=" + fecha + ", id=" + id + ", ID del producto="
                + productoId + ", precioTotal=" + precioTotal + "]";
    }

    public String getDniCliente() {
        return clienteDni;
    }

    public int getIdProducto() {
        return productoId;
    }

    public double getPrecio() {
        return precioTotal;
    }
}
