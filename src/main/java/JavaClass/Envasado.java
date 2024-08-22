package JavaClass;

import java.time.LocalDate;

public class Envasado extends Producto {
    public Envasado(String id, String descripcion, double precioPorUnid,
                    double porcentajeGanancia, boolean isDisponible,
                    boolean isImportado, int calorias, int cantStock, String tipoEnv, boolean isComestible) {
        this.id = id;
        this.descripcion = descripcion;
        this.precioPorUnid = precioPorUnid;
        this.porcentajeGanancia = porcentajeGanancia;
        this.isDisponible = isDisponible;
        this.isImportado = isImportado;
        this.calorias = calorias;
        this.cantStock = cantStock;
        this.tipoEnv = tipoEnv;
        this.isComestible = isComestible;
    }

    public Envasado(String id, String descripcion, double precioPorUnid, double porcentajeGanancia, boolean isDisponible, boolean isImportado, int calorias, int cantStock, boolean isComestible) {

    }
}






//    @Override
//    public void esImportado() {
//    }
//
//    @Override
//    public double calcularCalorias(double calorias) {
//        return 0;
//    }
//
//    @Override
//    public LocalDate getFechaVen() {
//        return this.fechaVen;
//    }


//    @Override
//    public boolean esComestible() {
//        LocalDate fechaActual = LocalDate.now();
//        esComestible = fechaActual.isBefore(fechaVen);
//        return esComestible;
//    }


//    @Override
//    public boolean estaDisponible() {
//        return disponible;
//    }
