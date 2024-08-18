package JavaClass;

import java.util.HashMap;
import java.util.Map;

public class Tienda {
    private HashMap<String, Producto> productos;
    private String nombre = "Tienda Farolito";
    private int numMaxStock = 500;
    private int saldoCaja;
    


    public Tienda(){
        this.saldoCaja = saldoCaja;
        this.productos = new HashMap<>();
    }

    public void agregarProducto(Producto producto) {
        productos.put(producto.getId(), producto);
    }

    public void mostrarProductos(){
        for (Map.Entry<String, Producto> entry : productos.entrySet()) {
            System.out.println("Los productos son: " + entry.getValue() + "la cantidad de productos son: " + productos.size());
        }
    }

    public int getNumMaxStock() {
        return numMaxStock;
    }

    public void setNumMaxStock(int numMaxStock) {
        this.numMaxStock = numMaxStock;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
