/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoADatos;

import Entidades.Producto;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author 2022
 */
public class ProductoData {
    //productoData lo hacemos con alumnoData
     private Connection con = null;
    
    public ProductoData(){
        con = Conexion.getConexion();
    }
    
    public void guardarProducto(Producto producto){
        String sql = "INSERT INTO producto (nombreProducto, descripcion, precioActual, stock, estado) VALUES (?,?,?,?,?)";
        PreparedStatement ps;
         try {
             ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
             ps.setString(1, producto.getNombreProducto());
            ps.setString(2, producto.getDescripcion());
            ps.setDouble(3,producto.getPrecioActual() );
            ps.setInt(4,producto.getStock() );
            ps.setBoolean(5, producto.isEstado());
            ps.executeUpdate();
            
            ResultSet rs= ps.getGeneratedKeys();
            
            if(rs.next()){
                producto.setIdProducto(rs.getInt(1));
                //averiguar
                JOptionPane.showMessageDialog(null, "Producto Agregado Exitosamente!");
               
            
            }
            ps.close();
         } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "No se pudo realizar la acción");
         }
            
}
    
     public Producto buscarProductoPorId(int idProducto){
        Producto producto = null;
        String sql= "SELECT nombreProducto, descripcion, precioActual, stock FROM producto WHERE idProducto= ? AND estado=1";
        PreparedStatement ps= null;
        
        try {
            
            ps= con.prepareStatement(sql);
            ps.setInt(1, idProducto);
            ResultSet rs= ps.executeQuery();
            if(rs.next()){
             producto = new Producto();
             producto.setIdProducto(idProducto);
             //no entendi porque no funciona con: (rs.getInt("idProducto");
             producto.setNombreProducto(rs.getString("nombreProducto"));
             producto.setDescripcion(rs.getString("descripcion"));
             producto.setPrecioActual(rs.getDouble("precioActual"));
             producto.setStock(rs.getInt("stock"));
             producto.setEstado(true);
             
             JOptionPane.showMessageDialog(null, "Se trajo el producto de la bd");
             
              
            }else{
               JOptionPane.showMessageDialog(null, "No se encontró el producto");
               ps.close();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR al acceder a la tabla producto"+ ex.getMessage());
         
        }return producto;
     
    }
     
     public List<Producto> listarProductos(){
        List<Producto> productos = new ArrayList<>();
        
        String sql= "SELECT * FROM producto WHERE estado=1";
        
        try {
            PreparedStatement ps= con.prepareStatement(sql);
            ResultSet rs= ps.executeQuery();
            while(rs.next()){
                Producto prod = new Producto();
                prod.setIdProducto(rs.getInt("idProducto"));
                prod.setNombreProducto(rs.getString("nombreProducto"));
                prod.setDescripcion(rs.getString("descripcion"));
                prod.setPrecioActual(rs.getDouble("precioActual"));
                prod.setStock(rs.getInt("stock"));
                prod.setEstado(rs.getBoolean("estado"));
                
                productos.add(prod);
                /*Acá está guardando en el ArrayList productos, el producto prod en el que fuimos agregandole los datos que 
                sacabamos del resultset rs*/
                JOptionPane.showMessageDialog(null,"Se devolvió la lista esperada");
                
            }
            
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo conectar a la tabla producto"+ ex.getMessage());
            
        }
        return productos;
        /*Este método lo que devuelve es un ArrayList, al que lo definimos en el nombre del método parece y 
        lo terminamos creando en la linea de abajo del nombre*/
        
    }
     
     public void modificarProducto(Producto producto){
        
        String sql= "UPDATE producto SET nombreProducto= ?, descripcion = ?, precioActual =?, stock = ? WHERE idProducto=? ";
        //NO le pongo para actualizar el ESTADO porque de eso se va a encargar el método de ELIMINAR (eliminado lógico)
        PreparedStatement ps= null;
        /*En el UPDATE le estoy dando datos a mi bd(ps.setString, ps.setInt - le estoy dando a mi ps los datos),
        pero los tengo que sacar del objeto producto que le doy al método(producto.getNombreProducto),
        que en la vista de modificar producto es en donde le voy a pasar los datos.*/
        try {
            ps= con.prepareStatement(sql);
            ps.setString(1, producto.getNombreProducto());
            ps.setString(2, producto.getDescripcion());
            ps.setDouble(3, producto.getPrecioActual());
            ps.setInt(4,producto.getStock());
            ps.setInt(5, producto.getIdProducto());
            
            int exito= ps.executeUpdate();
            /*Se pone el uno en la línea siguiente exito==1 porque el executeUpdate, te devuelve un número uno si la acción que vos le pediste
            se cumplió, y un 0 si no se cumplió.*/
            if(exito==1){
                JOptionPane.showMessageDialog(null, "Modificado exitósamente");
               ps.close();
            }else{
                JOptionPane.showMessageDialog(null, "El producto NO existe");
                
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla producto"+ ex.getMessage());
            
        }
     
     }
     
     public void eliminarProductoPorId(int idProducto){
        
        String sql= "UPDATE producto SET estado=0 WHERE idProducto = ? ";
        //NO le pongo para actualizar el ESTADO porque de eso se va a encargar el método de ELIMINAR (eliminado lógico)
        PreparedStatement ps= null;
        /*En el UPDATE le estoy dando datos a mi bd(ps.setString, ps.setInt - le estoy dando a mi ps los datos),
        pero los tengo que sacar del objeto producto que le doy al método(producto.getNombreProducto),
        que en la vista de modificar producto es en donde le voy a pasar los datos.*/
        try {
            ps= con.prepareStatement(sql);
            ps.setInt(1, idProducto);
            int exito= ps.executeUpdate();
            /*Se pone el uno en la línea siguiente exito==1 porque el executeUpdate, te devuelve un número uno si la acción que vos le pediste
            se cumplió, y un 0 si no se cumplió.*/
            if(exito==1){
                JOptionPane.showMessageDialog(null, "Producto eliminado");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla producto"+ ex.getMessage());
            
        }
     
}}