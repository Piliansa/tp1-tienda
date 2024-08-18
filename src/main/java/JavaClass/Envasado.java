package JavaClass;

import java.util.Random;

public class Envasado extends Producto{
    public Envasado(String descripcion, double precio, int cantStock, double ganancia, boolean disponible) {
        id = generarId();
        this.descripcion = descripcion;
        this.precio = precio;
        this.cantStock = cantStock;
        this.ganancia = ganancia;
        this.disponible = disponible;
    }

    public String generarId() {
        Random codigoProd = new Random();
        int num = codigoProd.nextInt(900) + 100; //genera un numero entre 100 y 999
        return "AB" + num;
    }

    @Override
    public void aplicarDescuento() {
    }
    @Override
    public void esImportado() {
    }
}
