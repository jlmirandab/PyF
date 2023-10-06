package Entidades;

import javax.swing.JOptionPane;

public class Cliente {
    
    private int idCliente;
    private String apellido;
    private String nombre;
    private String telefono;
    private String domilicio;
    private boolean estado;

    public Cliente(int idCliente, String apellido, String nombre, String telefono, String domilicio, boolean estado) {
        this.idCliente = idCliente;
        this.apellido = apellido;
        this.nombre = nombre;
        this.telefono = telefono;
        this.domilicio = domilicio;
        this.estado = estado;
    }


    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public boolean isEstado() {
        return estado;
    }

    public Cliente(String apellido, String nombre, String telefono, String domilicio, boolean estado) {
        this.apellido = apellido;
        this.nombre = nombre;
        this.telefono = telefono;
        this.domilicio = domilicio;
        this.estado = estado;
    }

    public Cliente() {
    }

    public int getIdCliente() {
        return idCliente;
    }

    public String getApellido() {
        return apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getDomilicio() {
        return domilicio;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setDomilicio(String domilicio) {
        this.domilicio = domilicio;
    }

    @Override
    public String toString() {
        return "ID Cliente=" + idCliente + ", Apellido=" + apellido + ", Nobmre=" + nombre + ", Telefono=" + telefono + ", Domilicio=" + domilicio;
    }
    
    
}
