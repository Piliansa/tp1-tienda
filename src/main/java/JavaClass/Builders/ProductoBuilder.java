package JavaClass.Builders;

import Interfaces.IBuilder;
import JavaClass.Bebida;
import JavaClass.Envasado;
import JavaClass.Limpieza;

import java.time.LocalDate;

public class ProductoBuilder implements IBuilder<ProductoBuilder>  {

    //Atributos
    private String descripcion;
    private double precioPorUnid;
    private double porcentajeGanancia;
    private boolean isDisponible;
    private boolean isImportado;
    private int calorias;
    private String tipoEnv;
    private double gradAlcohol;
    private String tipoAplic;
    private int cantStock;
    private LocalDate fechaVen;
    private boolean isComestible;

    public String getDescripcion() {
        return descripcion;
    }

    public double getPrecioPorUnid() {
        return precioPorUnid;
    }

    public double getPorcentajeGanancia() {
        return porcentajeGanancia;
    }

    public boolean isDisponible() {
        return isDisponible;
    }

    public boolean isImportado() {
        return isImportado;
    }

    public int getCalorias() {
        return calorias;
    }

    public String getTipoEnv() {
        return tipoEnv;
    }

    public double getGradAlcohol() {
        return gradAlcohol;
    }

    public String getTipoAplic() {
        return tipoAplic;
    }

    public int getCantStock() {
        return cantStock;
    }

    public LocalDate getFechaVen() {
        return fechaVen;
    }

    public boolean isComestible() {
        return isComestible;
    }

    public int getDescuento() {
        return descuento;
    }

    public static int getLimpiezaCount() {
        return limpiezaCount;
    }

    public static int getEnvasadoCount() {
        return envasadoCount;
    }

    public static int getBebidaCount() {
        return bebidaCount;
    }

    private int descuento;

    public ProductoBuilder setDescuento(int descuento) {
        this.descuento = descuento;
        return this;
    }

    //especificos para Ids:
    protected static int limpiezaCount = 0;
    protected static int envasadoCount = 0;
    protected static int bebidaCount = 0;


    //Setters
    public ProductoBuilder setDescripcion(String descripcion) {
        this.descripcion = descripcion;
        return this;
    }

    //    public ProductoBuilder setCantStock(int cantStock) {
//        this.cantStock = cantStock;
//        return this;
//    }
    public ProductoBuilder setPrecioPorUnid(double precioPorUnid) {
        this.precioPorUnid = precioPorUnid;
        return this;
    }

    public ProductoBuilder setPorcentajeGanancia(double porcentajeGanancia) {
        this.porcentajeGanancia = porcentajeGanancia;
        return this;
    }

    public ProductoBuilder setDisponible(boolean disponible) {
        this.isDisponible = disponible;
        return this;
    }

    public ProductoBuilder setImportado(boolean importado) {
        this.isImportado = importado;
        return this;
    }

    public ProductoBuilder setCalorias(int calorias) {
        this.calorias = calorias;
        return this;
    }

    public ProductoBuilder setTipoEnv(String tipoEnv) {
        this.tipoEnv = tipoEnv;
        return this;
    }

    public ProductoBuilder setCantStock(int cantStock) {
        this.cantStock = cantStock;
        return this;
    }

    public ProductoBuilder setGradAlcohol(double gradAlcohol) {
        this.gradAlcohol = gradAlcohol;
        return this;
    }

    public ProductoBuilder setTipoAplic(String tipoAplic) {
        this.tipoAplic = tipoAplic;
        return this;
    }

    public ProductoBuilder setFechaVen(int y, int m, int d) {
        this.fechaVen = LocalDate.of(y, m, d);
        return this;
    }

    public ProductoBuilder isComestible(boolean b) {
        this.isComestible = b;
        return this;
    }

    //Constructor Envasado:
    public Envasado buildEnvasado() {
        envasadoCount++;
        String id = generarId("AB", envasadoCount);
        if(isComestible) {
            isDisponible = !LocalDate.now().isAfter(fechaVen);
        }
        if (tipoEnv == null) throw new IllegalArgumentException("Debe añadir el tipo de envase");
        return new Envasado(id, descripcion, precioPorUnid, porcentajeGanancia, isDisponible, isImportado, calorias, cantStock, tipoEnv, isComestible);
    }

    //Constructor Bebida
    public Bebida buildBebida() {
        bebidaCount++;
        String id = generarId("AC", bebidaCount);
        if (fechaVen == null){
            throw new IllegalArgumentException("La fecha de vencimiento sebe ser especificada.");
        }
        isDisponible = !LocalDate.now().isAfter(fechaVen);
        if (gradAlcohol < 0)
            throw new IllegalArgumentException("Escriba la graduacion alcoholica, si es sin alcohol escriba 0, por favor.");
        return new Bebida(id, descripcion, precioPorUnid, porcentajeGanancia, isDisponible, isImportado, cantStock, gradAlcohol, fechaVen, isComestible);
    }

    //Constructor Limpieza
    public Limpieza buildLimpieza() {
        limpiezaCount++;
        String id = generarId("AZ", limpiezaCount);
        if (tipoAplic == null) {
            throw new IllegalArgumentException("Debe especificar el tipo de aplicación.");
        }
        return new Limpieza(id, descripcion, precioPorUnid, porcentajeGanancia, isDisponible, isImportado, calorias, tipoEnv, cantStock, tipoAplic);
    }


    @Override
    public ProductoBuilder build() {
        return this;
    }

    private String generarId(String letras, int count) {
        if (count > 999) {
            throw new IllegalArgumentException("Se alcanzó el número máximo de Id");
        }
        return letras + String.format("%03d", count);
    }



}