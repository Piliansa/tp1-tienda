package JavaClass;

import java.time.chrono.ChronoLocalDate;

public abstract class Producto {
    //Atributos
    protected String id;
    protected String descripcion;
    protected int cantStock;
    protected double precio;
    protected double ganancia;
    protected boolean disponible;
    protected ChronoLocalDate fechaVen;
    protected int calorias;
    protected boolean esComestible;
    protected boolean esImportado;
    protected double descuento;

    //Constructores
    public Producto(String descripcion, double precio, int cantStock, double ganancia, boolean disponible, boolean esImportado){
        generarId();
        this.descripcion = descripcion;
        this.precio = precio;
        this.cantStock = cantStock;
        this.ganancia = ganancia;
        this.disponible = disponible;
        this.esImportado = esImportado;

    }

    public Producto() {
    }

    //metodos
    public String toString(){
        return "ID: " + this.id + ", descripcion: " + this.descripcion + ", Precio: " + this.precio + "Cantidad de Stock: " + this.cantStock
                + ", porcentaje de ganancia: " + this.ganancia + ". Estado: " + this.disponible;
    }

    public String getId(){
        return this.id;
    }

    public String generarId() {

        return null;
    }


    //metodos abstractos
    public abstract void aplicarDescuento();
    public abstract void esImportado();



}
