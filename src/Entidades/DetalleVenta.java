
package Entidades;

public class DetalleVenta {
    private int idDetalleVent;
    private int cantidad;
    private Venta venta;
    private double precioVenta;
    private Producto producto;

    public DetalleVenta(int idDetalleVent, int cantidad, Venta venta, double precioVenta, Producto producto) {
        this.idDetalleVent = idDetalleVent;
        this.cantidad = cantidad;
        this.venta = venta;
        this.precioVenta = precioVenta;
        this.producto = producto;
    }

    public DetalleVenta(int cantidad, Venta venta, double precioVenta, Producto producto) {
        this.cantidad = cantidad;
        this.venta = venta;
        this.precioVenta = precioVenta;
        this.producto = producto;
    }

    public int getIdDetalleVent() {
        return idDetalleVent;
    }

    public int getCantidad() {
        return cantidad;
    }

    public Venta getVenta() {
        return venta;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setIdDetalleVent(int idDetalleVent) {
        this.idDetalleVent = idDetalleVent;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    @Override
    public String toString() {
        return  "ID DetalleVent=" + idDetalleVent + ", Cantidad=" + cantidad + ", Venta=" + venta + ", PrecioVenta=" + precioVenta + ", Producto=" + producto ;
    }
    
    
}
