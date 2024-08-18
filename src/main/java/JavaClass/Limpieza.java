package JavaClass;

import java.util.Random;

public class Limpieza extends Producto{
    public Limpieza(String descripcion, double precio, int cantStock, double ganancia, boolean disponible) {
        this.descripcion = descripcion;
        this.precio = precio;
        id = generarId();
    }

    public String generarId() {
        Random codProd = new Random();
        int num = codProd.nextInt(900) + 100; //genera un numero entre 100 y 999
        return "AZ" + num;
    }

    @Override
    public void aplicarDescuento() {
    }
    @Override
    public void esImportado() {
    }
}
