package AccesoADatos;

import Entidades.Cliente;
import Entidades.Venta;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class VentaData {
    
    private Connection con=null;
   
    
    Cliente c= new Cliente();

    public VentaData() {
        con = Conexion.getConexion();
        
    }
    
    public void guardarVenta (Venta venta){
       String sql = "INSERT INTO venta (idCliente, FechaVenta) VALUES (?,?)";
     
        try {
           PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
           ps.setInt(1, venta.getCliente().getIdCliente());
           ps.setDate(2, Date.valueOf(venta.getFechaVenta()));          
           ps.executeUpdate();
           ResultSet rs= ps.getGeneratedKeys();
                    
           if (rs.next()) {
                venta.setIdVenta(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Venta registrada");
                }
                ps.close();

                }catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Ventas");
                }

            }
    
     
    public Venta buscarVentas(int id){
        Venta venta= null;
        String sql= "SELECT idCliente, FechaVenta WHERE idVenta=? ";
        PreparedStatement ps= null;
    
        
        try {
            
            ps= con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs= ps.executeQuery();
            if(rs.next()){
             
             venta= new Venta();
             venta.setIdVenta(id);
             //venta.setCliente(rs.getInt("idCliente"));
             venta.setFechaVenta(rs.getDate("fechaVenta").toLocalDate());
             
            }else{
               JOptionPane.showMessageDialog(null, "No se encontró la venta");
               ps.close();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR al acceder a la tabla Venta"+ ex.getMessage());
         
        }return venta;
     
    }
    
    
    public List<Venta> listarVentas(){
        List<Venta> ventas= new ArrayList<>();
        
        String sql= "SELECT * FROM alumno WHERE estado=1";
        
        try {
            PreparedStatement ps= con.prepareStatement(sql);
            ResultSet rs= ps.executeQuery();
            while(rs.next()){
                Venta venta= new Venta();
                
               // venta.setCliente(rs.getInt("idCliente"));
                venta.setFechaVenta(rs.getDate("fechaNacimiento").toLocalDate());
               
                ventas.add(venta);
              
            }
            
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo conectar a la tabla ventas"+ ex.getMessage());
            
        }
        return ventas;
        
    }
        
       
        
        
        
    }
