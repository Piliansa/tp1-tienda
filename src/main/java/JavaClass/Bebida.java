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
        this.tipoEnv = tipoEnv;
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

//    public Bebida(String descripcion, double precio, int cantStock, double ganancia, boolean isDisponible, boolean esImportado, int gradAlcohol, int calorias, String tipoEnv, double descuento, LocalDate fechaVen) {
//        super();
//        this.gradAlcohol = gradAlcohol;
//        calcularCalorias(iComestible.calorias);
//        id = generarId();
//        this.isDisponible = isDisponible;
//        this.fechaVen = getFechaVen();
//    }
//
//    public String generarId() {
//        Random codProd = new Random();
//        int num = codProd.nextInt(900) + 100; //genera un numero entre 100 y 999
//        return "AB" + num;
//    }
//
//    @Override
//    public void esImportado() {
//    }
//
//    @Override
//    public double calcularCalorias(double calorias) {
//        if(gradAlcohol >= 0 && gradAlcohol <=2) { return calorias;
//        } else if (gradAlcohol > 2 && gradAlcohol <= 4.5){
//            calorias = gradAlcohol*1.25;
//        } else if (gradAlcohol > 4.5) {
//            calorias = gradAlcohol*1.5;
//        }
//        return calorias;
//    }
//
//    @Override
//    public LocalDate getFechaVen() {
//        return this.fechaVen;
//    }
//
//
//    public boolean isDisponible() {
//
//        LocalDate fechaActual = LocalDate.now();
//        if (!fechaVen.isBefore(fechaActual)) {
//            this.isDisponible = false;
//            System.out.println("El producto " + this.descripcion + " está vencido, no está disponible.");
//        }
//        return isDisponible;
//    }



