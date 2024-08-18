package JavaClass;

import Interfaces.iComestible;

import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.util.Random;

public class Envasado extends Producto implements iComestible {
    public Envasado(String descripcion, double precio, int cantStock, double ganancia, boolean disponible, boolean esImportado, ChronoLocalDate fechaVen) {
        super (descripcion, precio, cantStock, ganancia, disponible, esImportado);
        this.fechaVen = fechaVen;
        id = generarId();
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

    @Override
    public boolean esComestible() {
        LocalDate fechaActual = LocalDate.now();
        this.esComestible = !fechaActual.isBefore(fechaVen);
        return false;
    }
}
