package conexion;

import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import Modelos.ProductosModelo;

public class productosDAO 
{
    private Connection con;
    
    public void AgregarProducto(ProductosModelo producto)
    {
        try{
            if(con == null)
                con = conexion.getConexion();
            
            String sql = "INSERT INTO PRODUCTO(nombre,precio) values(?,?)";
            
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, producto.getNombre());
            statement.setDouble(2, producto.getPrecio());
            int RowsInserted = statement.executeUpdate();
            
            if(RowsInserted > 0)
            {
                JOptionPane.showMessageDialog(null, "Insercion exitosa \nProducto: " + producto.getNombre()+"\nPrecio: " + 
                        producto.getPrecio() + "$","Exito",JOptionPane.INFORMATION_MESSAGE);
                System.out.println("La insercion fue exitosa");
                System.out.println("--------------------------------------");
            }
            else
            {
                System.out.println("Hubo un error con la insercion");
                System.out.println("--------------------------------------");
            }
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }
    }
    
    public void ActualizarProducto(ProductosModelo producto)
    {
        try{
            if(con == null)
                con = conexion.getConexion();
            
            String sql = "UPDATE producto SET precio = ? WHERE idproducto=?";
            
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setDouble(1, producto.getPrecio());
            statement.setInt(2, producto.getId());
            
            int rowsUpdated = statement.executeUpdate();
            if(rowsUpdated > 0)
            {
                JOptionPane.showMessageDialog(null, "Actualizacion exitosa \nProducto: " + producto.getNombre()+"\nNuevo Precio: " + 
                        producto.getPrecio() + "$","Exito",JOptionPane.INFORMATION_MESSAGE);
                
                System.out.println("La modificacion fue exitosa");
                System.out.println("--------------------------------------");
            }
            else
            {
                System.out.println("Hubo un error en la modificacion");
                System.out.println("--------------------------------------");
            }
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }
    }
    
    public ProductosModelo ObtenerProducto(int id)
    {
        ProductosModelo producto = new ProductosModelo();    
        try
        {
            if(con == null)
                con = conexion.getConexion();
            
            String sql = "SELECT * FROM producto WHERE idproducto = ?";    
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            
            result.next();
            producto = new ProductosModelo(result.getInt(1),result.getString(2),result.getInt(3));          
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }
        
        return producto;
    }
    
    public ArrayList<ProductosModelo> ObtenerProductos()
    {       
        ArrayList<ProductosModelo> productos = new ArrayList<ProductosModelo>();
        try
        {
            if(con == null)
                con = conexion.getConexion();
            
            String sql = "SELECT * FROM producto";
            Statement statement = con.createStatement();
            ResultSet result = statement.executeQuery(sql);
            
            while(result.next())
            {
                ProductosModelo producto = new ProductosModelo(result.getInt(1),result.getString(2),result.getInt(3));
                productos.add(producto);
            }  
        }catch(SQLException ex)
        {
            ex.printStackTrace();
        }
        return productos;
    }
    
    public void EliminarProducto(int id)
    {
        try{
            if(con == null)
                con = conexion.getConexion();
        
            String sql = "DELETE FROM producto WHERE idproducto=?";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, id);
            
            int RowsDeleted = statement.executeUpdate();
            if(RowsDeleted > 0)
            {
                JOptionPane.showMessageDialog(null, "Producto eliminado","Advertencia",JOptionPane.WARNING_MESSAGE);
                System.out.println("Se elimino el producto");
                System.out.println("--------------------------------------");
            }
            else
            {
                System.out.println("No se pudo eliminar el producto");
                System.out.println("--------------------------------------");
            }
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }
    }
}
