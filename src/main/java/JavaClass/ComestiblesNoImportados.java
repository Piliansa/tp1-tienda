package JavaClass;

import java.util.Comparator;

public class ComestiblesNoImportados implements Comparator<Double> {

    public int compare(Double primerDescuento, Double segundoDescuento) {
        return primerDescuento.compareTo(segundoDescuento);

    }
}
