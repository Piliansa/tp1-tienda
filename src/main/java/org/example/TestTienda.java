package org.example;


import JavaClass.Builders.BebidaBuilder;
import JavaClass.Builders.EnvasadoBuilder;
import JavaClass.Builders.LimpiezaBuilder;
import JavaClass.Producto;
import JavaClass.Tienda;

import java.util.ArrayList;
import java.util.List;

public class TestTienda extends Tienda {
    public static void main(String[] args) {
        Tienda tienda = new Tienda();
        tienda.setNombre("FAROLITO");
        tienda.saludar();
        List<Producto> detalleVenta = new ArrayList<>();


        //Creacion de productos:
        Producto galletita = new EnvasadoBuilder()
                .setDescripcion("GALLETITAS")
                .setPrecioPorUnid(350)
                .setPorcentajeGanancia(15) //Agrego % ganancia sabiendo que
                .setDisponible(true)
                .setImportado(false)
                .setCantStock(1)
                .isComestible(true)
                .setDescuento(3)
                .setFechaVen(2025,5,25)
                .setCalorias(300)
                .setTipoEnv("plastico").buildEnvasado();



        Producto arroz = new EnvasadoBuilder()
                .setDescripcion("ARROZ")
                .setCantStock(2)
                .setPrecioPorUnid(1050)
                .setPorcentajeGanancia(15)
                .isComestible(true)
                .setImportado(false)
                .setDescuento(2)
                .setCalorias(300)
                .setFechaVen(2025, 3, 3)
                .setTipoEnv("plastico").buildEnvasado();

        Producto cocaCola = new BebidaBuilder()
                .setDescripcion("COCA COLA")
                .setPrecioPorUnid(1600)
                .setPorcentajeGanancia(20)
                .setDisponible(true)
                .setImportado(false)
                .setDescuento(20)
                .setCalorias(5000)
                .setCantStock(5)
                .setTipoEnv("plastico")
                .isComestible(true)
                .setGradAlcohol(1)
                .setFechaVen(2026, 3,5)
                .buildBebida();


        Producto limpiaVidrio = new LimpiezaBuilder()
                .setDescripcion("LIMPIA VIDRIOS")
                .setPrecioPorUnid(250)
                .setPorcentajeGanancia(15)
                .setImportado(true)
                .setDisponible(true)
                .setCantStock(20)
                .setDescuento(3)
                .setTipoEnv("PLASTICO")
                .setTipoAplic("MULTIUSO")
                .buildLimpieza();

        Producto lavandina = new LimpiezaBuilder()
                .setDescripcion("LAVANDINA")
                .setPrecioPorUnid(250)
                .setPorcentajeGanancia(15)
                .setDisponible(true)
                .setImportado(false)
                .setCantStock(20)
                .setDescuento(3)
                .setTipoEnv("PLASTICO")
                .setTipoAplic("BAÑO")
                .buildLimpieza();

        Producto detergente = new LimpiezaBuilder()
                .setDescripcion("DETERGENTE")
                .setPrecioPorUnid(250)
                .setPorcentajeGanancia(1)
                .setDisponible(true)
                .setImportado(false)
                .setCantStock(20)
                .setDescuento(1)
                .setTipoEnv("PLASTICO")
                .setTipoAplic("COCINA")
                .buildLimpieza();

        Producto trapo = new LimpiezaBuilder()
                .setDescripcion("TRAPO")
                .setPrecioPorUnid(250)
                .setPorcentajeGanancia(15)
                .setDisponible(true)
                .setCantStock(20)
                .setTipoEnv("Tela")
                .setDescuento(5)
                .setTipoAplic("MULTIUSO")
                .buildLimpieza();

        Producto cerveza = new BebidaBuilder()
                .setDescripcion("CERVEZA")
                .setPrecioPorUnid(1600)
                .setPorcentajeGanancia(20)
                .setDisponible(true)
                .setCalorias(5000)
                .setImportado(false)
                .setDescuento(1)
                .setCantStock(200)
                .setTipoEnv("VIDRIO")
                .isComestible(true)
                .setGradAlcohol(4)
                .setFechaVen(2026, 3,5)
                .buildBebida();

        Producto jugoFruta = new BebidaBuilder()
                .setDescripcion("JUGO")
                .setPrecioPorUnid(900)
                .setDisponible(true)
                .setPorcentajeGanancia(20)
                .setCalorias(5000)
                .setImportado(false)
                .setDescuento(1)
                .setCantStock(5)
                .setTipoEnv("PLASTICO")
                .isComestible(true)
                .setGradAlcohol(4)
                .setFechaVen(2026, 3,5)
                .buildBebida();



        tienda.comprarProducto(galletita);
        tienda.comprarProducto(arroz);
        tienda.comprarProducto(cerveza);
        tienda.comprarProducto(detergente);
        tienda.comprarProducto(cocaCola);
        tienda.comprarProducto(trapo);
        tienda.comprarProducto(lavandina);
        tienda.comprarProducto(limpiaVidrio);
        tienda.comprarProducto(jugoFruta);
        //Hago algunas compras para agregar productos a mi inventario

        //Muestro los productos en stock
        tienda.mostrarProductos();


        //REALIZAR VENTA |---
        //---------------|---
        //---------------V---
        //Realizo una venta donde me pedirá el codigo de tipo de producto, su nombre, y la cantidad de productos que quiero vender de c/u.

        int topeDeVentas = 3;
        for(int i = 0; i < topeDeVentas; i++){
            tienda.venderProductos();//itero tres veces el vender un producto como forma de limitar las ventas a tres productos. FALTA IMPRIMIR CORRECTAMENTE
        }
  //----VER PRODUCTOS NO IMPORTADOS COMESTIBLES CUYO DESCUENTO SEA < AL PORCENTAJE PASADO POR PARAMETRO:
        tienda.obtenerComestiblesConMenorDescuento(10);
//        tienda.mostrarProductos();







//        tienda.comprarProducto(yerba);
//        tienda.comprarProducto(limpiaVidrio);
//        tienda.comprarProducto(limpiaVidrio);
//        tienda.comprarProducto(limpiaVidrio);
//        tienda.comprarProducto(limpiaVidrio);






    }


}