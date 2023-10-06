
package AccesoAdATOS;

import Entidades.Cliente;
import Entidades.Producto;
import Entidades.Venta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class DetalleVentaData {
    ClienteData cData= new ClienteData();
    VentaData vData= new VentaData();
    ProductoData pData= new ProductoData();
    private Connection con=null;
    
    private Cliente cliente;
    private Producto producto;
    private Venta venta;

    public DetalleVentaData() {
        con = AccesoADatos.Conexion.getConexion();
    }
   

    
    public List<DetalleVentaData> clientesPorProducto(int idProducto){
        
         List<Venta> detalles= new ArrayList<>();
        
        String sql= "SELECT * FROM detalle Venta WHERE idProducto=? ";
        
        try {
            PreparedStatement ps= con.prepareStatement(sql);
            ResultSet rs= ps.executeQuery();
            while(rs.next()){
                DetalleVentaData detalle= new DetalleVentaData();
                //detalle.
                Cliente cl= cData.buscarClientePorId(rs.getInt("idCliente"));
                
                venta.setCliente(cl);
                venta.setFechaVenta(rs.getDate("FechaVenta").toLocalDate());
               
                //detalle.add(detalles);
                JOptionPane.showMessageDialog(null, venta);
            }
            
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo conectar a la tabla ventas"+ ex.getMessage());
            
        }
        //return detalles;
        
    }
        
        
        
    }
    
    
    
    
    
    
}
