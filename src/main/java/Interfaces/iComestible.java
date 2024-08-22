package Interfaces;

import java.time.LocalDate;

public interface iComestible {
    double calorias = 0;
    LocalDate fechaVen = LocalDate.now();


    LocalDate getFechaVen();

}
