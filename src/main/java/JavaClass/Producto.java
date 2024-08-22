package JavaClass;

public class Producto {
    //Atributos
    protected String id;
    protected String descripcion;
    protected int cantStock;
    protected double precioPorUnid;
    protected double porcentajeGanancia;
    protected boolean isDisponible;
    protected boolean isImportado;
    protected int calorias;
    protected String tipoEnv;
//    protected int calorias;

    //Constructor vacio
    public Producto() {
    }

    //Getters y Setters

    public String getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getCantStock() {
        return cantStock;
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

    public String getTipoEnv() {return tipoEnv;}

    public String setId(String id) {
        this.id = id;
        return id;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setCantStock(int cantStock) {
        this.cantStock = cantStock;
    }

    public void setPrecioPorUnid(double precioPorUnid) {
        this.precioPorUnid = precioPorUnid;
    }

    public void setPorcentajeGanancia(double porcentajeGanancia) {
        this.porcentajeGanancia = porcentajeGanancia;
    }

    public void setDisponible(boolean disponible) {
        isDisponible = disponible;
    }

    public void setImportado(boolean importado) {
        isImportado = importado;
    }

    public void setCalorias(int calorias) {
        this.calorias = calorias;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "id='" + id + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", cantStock=" + cantStock +
                ", precioPorUnid=" + precioPorUnid +
                ", porcentajeGanancia=" + porcentajeGanancia +
                ", isDisponible=" + isDisponible +
                ", isImportado=" + isImportado +
                ", calorias=" + calorias +
                '}';
    }

    //Constructor


    //metodos










}


