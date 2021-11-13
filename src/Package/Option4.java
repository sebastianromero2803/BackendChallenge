package Package;

import conexion.*;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import Modelos.ProductosModelo;

public class Option4 extends JFrame
{
    int contador = 0;
    
    conexion con = new conexion();
    productosDAO crud = new productosDAO();
    ArrayList<ProductosModelo> listaProductos;

    String[] titulos = {"id","nombre","precio"};
    JScrollPane jsp;
    private final JPanel PanelPrincipal = new JPanel();
    private final JPanel panelAgregar = new JPanel(new GridLayout(2,2));
    private final JPanel panelEliminar = new JPanel(new GridLayout(1,2));
    private final JPanel panelActualizar = new JPanel(new GridLayout(2,2));
    private final JPanel panelTabla = new JPanel(new BorderLayout());
    private static JTable tabla;
    private DefaultTableModel modelo;
    private Button agregar;
    private Button eliminar;
    private Button actualizar;
    private Button consultar;
    private Button salir;
    private JLabel SeccionAgregar;
    private JLabel SeccionEliminar;
    private JLabel SeccionActualizar;
    private JLabel nombre;
    private JLabel precio;
    private JLabel id;
    private JLabel id2;
    private JTextField campoNombre;
    private JTextField campoPrecio;
    private JTextField campoPrecio2;
    private JTextField campoId;
    private JTextField campoId2;
    
    public Option4()
    {      
        this.setTitle("Productos en stock");
        this.setVisible(true);
        this.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        
        //cargamos los elementos
        iniciar_componentes();
        
        //los agregamos al jframe
        this.add(PanelPrincipal, BorderLayout.CENTER);
        this.pack();
    }
    
    public void iniciar_componentes()
    {
        PanelPrincipal.setLayout(new BoxLayout(PanelPrincipal, BoxLayout.Y_AXIS));
        
        crear_consultas();
        crear_tabla();
    }
    
    public void crear_tabla()
    {
        modelo = new DefaultTableModel();
        modelo.addColumn("Id");
        modelo.addColumn("Nombre");
        modelo.addColumn("Precio");
        llenar_tabla(listaProductos);
        tabla = new JTable(modelo);

        DefaultTableCellRenderer alinear = new DefaultTableCellRenderer();
        alinear.setHorizontalAlignment(SwingConstants.CENTER);
        
        for(int i = 0; i < tabla.getColumnCount(); i++)
            tabla.getColumnModel().getColumn(i).setCellRenderer(alinear);
        
        jsp = new JScrollPane(tabla);
        
        panelTabla.add(jsp, BorderLayout.CENTER);
        
        consultar = new Button("consultar");
        panelTabla.add(consultar, BorderLayout.AFTER_LINE_ENDS);
        
        ActionListener oyente = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                if(contador == 0)
                {
                    listaProductos = crud.ObtenerProductos();
                    llenar_tabla(listaProductos);
                    contador += 1;
                }
                
            }
        };
        consultar.addActionListener(oyente);
        
        salir = new Button("Salir");
        panelTabla.add(salir, BorderLayout.SOUTH);
        
        ActionListener oyente2 = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                System.exit(0);
            }
        };        
        salir.addActionListener(oyente2);
        
        PanelPrincipal.add(panelTabla);
    }
    
    public void llenar_tabla(ArrayList<ProductosModelo> productos)
    {
        if(productos != null)
        {
            String[][] cuerpo = new String[productos.size()][3];
            for(int i = 0; i<productos.size(); i++)
            {
                modelo.addRow(new Object[]{productos.get(i).getId(),productos.get(i).getNombre(),productos.get(i).getPrecio()});
            }
        }
    }
    
    public void crear_consultas()
    {     
        SeccionAgregar = new JLabel("Seccion para agregar elementos",SwingConstants.CENTER);
        PanelPrincipal.add(SeccionAgregar);
        
        nombre = new JLabel("Nombre",SwingConstants.CENTER);
        panelAgregar.add(nombre);
        campoNombre = new JTextField();
        panelAgregar.add(campoNombre);
        
        precio = new JLabel("Precio",SwingConstants.CENTER);
        panelAgregar.add(precio);
        campoPrecio = new JTextField();
        panelAgregar.add(campoPrecio);
         
        PanelPrincipal.add(panelAgregar);
        
        agregar = new Button("Agregar");
        PanelPrincipal.add(agregar);
        
        ActionListener oyente = new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                ProductosModelo productoNuevo = new ProductosModelo(campoNombre.getText(),Double.parseDouble(campoPrecio.getText()));
                crud.AgregarProducto(productoNuevo);
                
                listaProductos = crud.ObtenerProductos();
                modelo.addRow(new Object[]{listaProductos.get(listaProductos.size()-1).getId(),listaProductos.get(listaProductos.size()-1).getNombre(),listaProductos.get(listaProductos.size()-1).getPrecio()});
                modelo.fireTableDataChanged();
            }
        };
        agregar.addActionListener(oyente);
        
        SeccionEliminar = new JLabel("Seccion para eliminar elementos",SwingConstants.CENTER);
        PanelPrincipal.add(SeccionEliminar);
    
        id = new JLabel("Id",SwingConstants.CENTER);
        panelEliminar.add(id);
        campoId = new JTextField();
        panelEliminar.add(campoId);
        PanelPrincipal.add(panelEliminar);
        
        eliminar = new Button("eliminar");
        
        ActionListener oyente2 = new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                crud.EliminarProducto(Integer.parseInt(campoId.getText()));

                int fila = 0;

                for(int i = 0; i<listaProductos.size(); i++)
                {
                    if(listaProductos.get(i).getId() == Integer.parseInt(campoId.getText()))
                        break;
                    
                    fila += 1;
                }

                listaProductos = crud.ObtenerProductos();
                modelo.removeRow(fila);
                modelo.fireTableDataChanged();
            }
        };
        eliminar.addActionListener(oyente2);
        PanelPrincipal.add(eliminar);
        
        SeccionActualizar = new JLabel("Seccion para Actualizar elementos",SwingConstants.CENTER);
        PanelPrincipal.add(SeccionActualizar);
    
        id2 = new JLabel("Id",SwingConstants.CENTER);
        panelActualizar.add(id2);
        campoId2 = new JTextField();
        panelActualizar.add(campoId2);
        precio = new JLabel("Nuevo Precio",SwingConstants.CENTER);
        panelActualizar.add(precio);
        campoPrecio2 = new JTextField();
        panelActualizar.add(campoPrecio2);
        
        PanelPrincipal.add(panelActualizar);
        
        actualizar = new Button("actualizar");
        ActionListener oyente3 = new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                ProductosModelo productoNuevo = crud.ObtenerProducto(Integer.parseInt(campoId2.getText()));
                productoNuevo.setPrecio(Integer.parseInt(campoPrecio2.getText()));
                crud.ActualizarProducto(productoNuevo);
                
                listaProductos = crud.ObtenerProductos();
                int fila = 0;
                for(int i = 0; i<listaProductos.size(); i++)
                {
                    if(listaProductos.get(i).getId() == Integer.parseInt(campoId2.getText()))
                        break;
                    
                    fila += 1;
                }
                modelo.setValueAt(productoNuevo.getPrecio(), fila, 2);
                modelo.fireTableDataChanged();
            }
        };
        actualizar.addActionListener(oyente3);
        PanelPrincipal.add(actualizar);
    }
}
