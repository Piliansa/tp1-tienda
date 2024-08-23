package org.example;

import JavaClass.Bebida;
import JavaClass.Builders.BebidaBuilder;
import JavaClass.Builders.EnvasadoBuilder;
import JavaClass.Builders.LimpiezaBuilder;
import JavaClass.Envasado;
import JavaClass.Producto;
import JavaClass.Tienda;

public class TestTienda extends Tienda {
    public static void main(String[] args) {
//
        Tienda tienda = new Tienda();




        Producto envasado1 = new EnvasadoBuilder()
                .setDescripcion("Galletitas de agua")
                .setPrecioPorUnid(350)
                .setPorcentajeGanancia(15)
                .setDisponible(true)
                .setImportado(true)
                .setCantStock(1)
                .setFechaVen(2025,5,25)
                .setCalorias(300)
                .setTipoEnv("plastico").buildEnvasado();
        Producto envasado2 = new EnvasadoBuilder()
                .setDescripcion("Arroz")
                .setCantStock(2)
                .setPrecioPorUnid(1050)
                .setPorcentajeGanancia(15)
                .setImportado(true)
                .setCalorias(300)
                .setFechaVen(2020, 3, 3)
                .setTipoEnv("plastico").buildEnvasado();

        Producto bebida1 = new BebidaBuilder()
                .setDescripcion("Coca Cola")
                .setPrecioPorUnid(1600)
                .setPorcentajeGanancia(20)
                .setDisponible(true)
                .setImportado(false)
                .setCalorias(5000)
                .setCantStock(5)
                .setTipoEnv("plastico")
                .setGradAlcohol(1)
                .setFechaVen(2026, 3,5)
                .buildBebida();


//        Producto limpieza1 = new LimpiezaBuilder()
//                .setDescripcion("Limpia vidrios")
//                .setPrecioPorUnid(250)
//                .setPorcentajeGanancia(15)
//                .setDisponible(true)
//                .setCantStock(20)
//                .setTipoEnv("plastico")
//                .setTipoAplic("MULTIUSO")
//                .buildLimpieza();

        tienda.comprarProducto(envasado1);
        tienda.comprarProducto(envasado2);
        tienda.comprarProducto(bebida1);
        tienda.mostrarProductos();
        tienda.venderProductos();


    }


}