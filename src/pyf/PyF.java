package pyf;

import AccesoADatos.ClienteData;
import AccesoADatos.Conexion;
import AccesoADatos.ProductoData;
import AccesoADatos.VentaData;
import Entidades.Cliente;
import Entidades.Producto;
import Entidades.Venta;
import java.sql.Connection;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Month;

public class PyF {

    public static void main(String[] args) {
          Connection conexion = Conexion.getConexion();
          Producto prod = new Producto(1,"telefono alcatel","azul",4000,5,true);
          Producto prod2 = new Producto(4,"telefono alcatel","rosa",4000,5,true);
         
          /*NOTA: Para agregar los productos, NO hace falta el id en los datos del producto tipo Producto,
          pero para modificarlo SI hace falta ¿por que? porque justamente para poder MODIFICAR el producto, la condicion de modificaciión
          es el ID, y ese ID se saca justamente del OBJETO producto tipo Producto que nosotros le introducimos por parámetro, por eso LO TIENE QUE TENER.*/
          ProductoData pdata = new ProductoData();
          ClienteData cData= new ClienteData();
          //pdata.listarAlumnos();
          //pdata.eliminarProductoPorId(3);
        //pdata.modificarProducto(prod2);
          //pdata.buscarProductoPorId(1);
         //pdata.guardarProducto(prod2);
         Cliente cliente1=new Cliente(5,"Miranda Bazualdo", "Jorge Luis", "115648923", "CABA",true);
         Cliente cliente2=new Cliente(1,"Fernandez", "Marcelo", "114897623", "CABA", true);
         Cliente cliente3=new Cliente(6,"Suarez", "Micael", "115987636", "CABA", true);
         Cliente cliente4= new Cliente(3, "Cabral", "Josefina", "3513347562","CABA", true);
        //cData.guardarCliente(cliente3);
         //cData.buscarClientePorId(1);
         //cData.modificarCliente(cliente1);
         //cData.eliminarClienteporId(1);
        // cData.listarClientes();
         
         Venta venta1= new Venta(cliente1, LocalDate.now());
         Venta venta2=new Venta(cliente3, LocalDate.of(2015, Month.MARCH, 10));
         Venta venta3= new Venta(cliente2, LocalDate.of(2015, Month.MARCH, 10));
         
         VentaData vData= new VentaData();
         
       // vData.guardarVenta(venta2);
        //vData.borrarVentaPorId(2);
        //vData.buscarVentas(8);
       // System.out.println(vData.listarVentas());
       
//         for (Venta venta : vData.buscarVentasPorFecha(Date.valueOf(LocalDate.of(2015, Month.MARCH, 10))) ){
//            
//            System.out.println("id venta: " + venta.getIdVenta());
//            System.out.println("Cliente: " + venta.getCliente());
//            System.out.println("Fecha: " + venta.getFechaVenta());
//        
//        
//         }
         for(Venta venta: vData.buscarVentasPorCliente(1)){
             System.out.println("id venta: " + venta.getIdVenta());
             System.out.println("Cliente: " + venta.getCliente());
             System.out.println("Fecha: " + venta.getFechaVenta());
             
             
         }
         
    }
    
}
