package Modelos;

public class ProductosModelo 
{
    private int id = 0;
    private String nombre;
    private double precio;

    public ProductosModelo()
    {
        this.id = 0;
        this.nombre = null;
        this.precio = 0;
    }

    public ProductosModelo(String nombre,double precio)
    {
        this.nombre = nombre;
        this.precio = precio;
    }
    
    public ProductosModelo(int id,String nombre,double precio)
    {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setId(int id) {
        this.id = id;
    }
 
    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
