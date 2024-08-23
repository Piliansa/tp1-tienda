package JavaClass;

import java.time.LocalDate;




public class Bebida extends Producto {
    protected double gradAlcohol;


    public Bebida(String id, String descripcion, double precioPorUnid, double porcentajeGanancia,
                  boolean isDisponible, boolean isImportado, int cantStock,
                  double gradAlcohol, LocalDate fechaVen, boolean isComestible) {
        this.id = id;
        this.descripcion = descripcion;
        this.precioPorUnid = precioPorUnid;
        this.porcentajeGanancia = porcentajeGanancia;
        this.isDisponible = isDisponible;
        this.isImportado = isImportado;
        this.cantStock = cantStock;
        this.gradAlcohol = gradAlcohol;
        this.isComestible = isComestible;
        this.fechaVen = fechaVen;
    }

    public double getGradAlcohol() {
        return gradAlcohol;
    }

    public void setGradAlcohol(double gradAlcohol) {
        this.gradAlcohol = gradAlcohol;
    }
}


