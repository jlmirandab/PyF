package Entidades;

import java.time.LocalDate;

public class Venta {
    private int idVenta;
    private Cliente cliente;
    private LocalDate fechaVenta;

    public Venta(int idVenta, Cliente cliente, LocalDate fechaVenta) {
        this.idVenta = idVenta;
        this.cliente = cliente;
        this.fechaVenta = fechaVenta;
    }

    public Venta(Cliente cliente, LocalDate fechaVenta) {
        this.cliente = cliente;
        this.fechaVenta = fechaVenta;
    }

    public Venta() {
       
    }

    public int getIdVenta() {
        return idVenta;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public LocalDate getFechaVenta() {
        return fechaVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setFechaVenta(LocalDate fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    @Override
    public String toString() {
        return "ID Venta=" + idVenta + ", Cliente=" + cliente + ", Fecha de Venta=" + fechaVenta ;
    }
    
    
}
