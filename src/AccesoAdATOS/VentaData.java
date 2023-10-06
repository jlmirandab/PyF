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
    ClienteData cData= new ClienteData();

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
    
    public void borrarVentaPorId(int idVenta){
           
           String sql= "DELETE FROM venta WHERE idVenta= ?";
           
        try {
            PreparedStatement ps= con.prepareStatement(sql);
            ps.setInt(1, idVenta);
            int filas =ps.executeUpdate();
            
            if(filas==1){
                JOptionPane.showMessageDialog(null, "Se Borro la venta");
                
            }
            ps.close();
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Error al acceder a la tabla venta");
        }
           
           
       }
    
     
    public Venta buscarVentas(int id){
        Venta venta= null;
       
        String sql= "SELECT idCliente, FechaVenta FROM venta WHERE idVenta=? ";
        PreparedStatement ps= null;
    
        
        try {
            
            ps= con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs= ps.executeQuery();
            if(rs.next()){
             
             venta= new Venta();
             venta.setIdVenta(id);
             Cliente cl= cData.buscarClientePorId(rs.getInt("idCliente"));
             venta.setCliente(cl);
             venta.setFechaVenta(rs.getDate("fechaVenta").toLocalDate());
             JOptionPane.showMessageDialog(null, "Se encontró la venta");
             
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
        
        String sql= "SELECT * FROM venta ";
        
        try {
            PreparedStatement ps= con.prepareStatement(sql);
            ResultSet rs= ps.executeQuery();
            while(rs.next()){
                Venta venta= new Venta();
                venta.setIdVenta(rs.getInt("idVenta"));
                Cliente cl= cData.buscarClientePorId(rs.getInt("idCliente"));
                
                venta.setCliente(cl);
                venta.setFechaVenta(rs.getDate("FechaVenta").toLocalDate());
               
                ventas.add(venta);
                JOptionPane.showMessageDialog(null, venta);
            }
            
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo conectar a la tabla ventas"+ ex.getMessage());
            
        }
        return ventas;
        
    }
       
    public List<Venta> buscarVentasPorFecha(Date FechaVenta){
        
        List<Venta>ventas= new ArrayList<>();
        String sql= "SELECT * FROM venta WHERE FechaVenta=? ";
        
        try {
            PreparedStatement ps= con.prepareStatement(sql);
            ps.setDate(1, FechaVenta);
            ResultSet rs= ps.executeQuery();
            
            while(rs.next()){
                Venta venta= new Venta();
                venta.setIdVenta(rs.getInt("idVenta"));
                Cliente cl= cData.buscarClientePorId(rs.getInt("idCliente"));
                
                venta.setCliente(cl);
                venta.setFechaVenta(rs.getDate("FechaVenta").toLocalDate());
               
                ventas.add(venta);
                JOptionPane.showMessageDialog(null, venta);
            }
            
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo conectar a la tabla ventas"+ ex.getMessage());
            
        }
        return ventas;
        
        
        
        
        
    }
      
   public List<Venta> buscarVentasPorCliente(int idCliente){
        
        List<Venta>ventas= new ArrayList<>();
        String sql= "SELECT * FROM venta WHERE idCliente=? ";
        
        try {
            PreparedStatement ps= con.prepareStatement(sql);
            ps.setInt(1, idCliente);
            ResultSet rs= ps.executeQuery();
            
            while(rs.next()){
                Venta venta= new Venta();
                venta.setIdVenta(rs.getInt("idVenta"));
                Cliente cl= cData.buscarClientePorId(rs.getInt("idCliente"));
                
                venta.setCliente(cl);
                venta.setFechaVenta(rs.getDate("FechaVenta").toLocalDate());
               
                ventas.add(venta);
                JOptionPane.showMessageDialog(null, venta);
            }
            
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo conectar a la tabla ventas"+ ex.getMessage());
            
        }
        return ventas;
        
        
        
        
        
    }
    }
