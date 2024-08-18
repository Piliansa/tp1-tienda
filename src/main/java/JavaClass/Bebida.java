package JavaClass;
import Interfaces.iComestible;
import java.util.Random;

public class Bebida extends Producto implements iComestible {
    protected double gradAlcohol;


    public Bebida(String descripcion, double precio, int cantStock, double ganancia, boolean disponible, boolean esImportado, int gradAlcohol, int calorias) {
        super(descripcion, precio, cantStock, ganancia, disponible, esImportado);
        this.gradAlcohol = gradAlcohol;
        calcularCalorias();
        id = generarId();

    }



    public String generarId() {
        Random codProd = new Random();
        int num = codProd.nextInt(900) + 100; //genera un numero entre 100 y 999
        return "AB" + num;
    }

    private void calcularCalorias() {
        if(gradAlcohol >= 0 && gradAlcohol <=2){
            this.calorias = (int) gradAlcohol;
        } else if (gradAlcohol > 2 && gradAlcohol <= 4.5){
            this.calorias = (int)(gradAlcohol*1.25);
        } else if (gradAlcohol > 4.5) {
            this.calorias = (int)(gradAlcohol*1.5);
        }
    }

    @Override
    public void aplicarDescuento() {

    }
    @Override
    public void esImportado() {
    }

    @Override
    public boolean esComestible() {
        return esComestible = true;
    }
}
