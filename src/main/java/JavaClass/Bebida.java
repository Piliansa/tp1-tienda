package JavaClass;
import java.util.Random;

public class Bebida extends Producto {
    protected double gradAlcohol;


    public Bebida(String descripcion, double precio, int cantStock, double ganancia, boolean disponible) {
        id = generarId();
        this.descripcion = descripcion;
        this.precio = precio;
        this.cantStock = cantStock;
        this.ganancia = ganancia;
        this.disponible = disponible;
    }

    public String generarId() {
        Random codProd = new Random();
        int num = codProd.nextInt(900) + 100; //genera un numero entre 100 y 999
        return "AB" + num;
    }
    @Override
    public void aplicarDescuento() {
    }
    @Override
    public void esImportado() {
    }
}
