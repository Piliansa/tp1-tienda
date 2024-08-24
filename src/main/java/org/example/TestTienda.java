package org.example;


import JavaClass.Builders.BebidaBuilder;
import JavaClass.Builders.EnvasadoBuilder;
import JavaClass.Builders.LimpiezaBuilder;
import JavaClass.Producto;
import JavaClass.Tienda;

public class TestTienda extends Tienda {
    public static void main(String[] args) {
//private static Tienda inicializarTienda(String nombre) {
//        Tienda tienda = new Tienda();
//        tienda.setNombre(nombre);
//        tienda.saludar();
//        return tienda;
//        Tienda tienda = inicializarTienda("FAROLITO");

        Tienda tienda = new Tienda();
        tienda.setNombre("FAROLITO");
        tienda.saludar();


        //Creacion de productos:
        Producto galletita = new EnvasadoBuilder()
                .setDescripcion("Galletitas de agua")
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
                .setDescripcion("Arroz")
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
                .setDescripcion("Coca Cola")
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
                .setDescripcion("Limpia vidrios")
                .setPrecioPorUnid(250)
                .setPorcentajeGanancia(15)
                .setImportado(true)
                .setDisponible(true)
                .setCantStock(20)
                .setDescuento(3)
                .setTipoEnv("plastico")
                .setTipoAplic("MULTIUSO")
                .buildLimpieza();

        Producto lavandina = new LimpiezaBuilder()
                .setDescripcion("Lavandina")
                .setPrecioPorUnid(250)
                .setPorcentajeGanancia(15)
                .setDisponible(true)
                .setImportado(false)
                .setCantStock(20)
                .setDescuento(3)
                .setTipoEnv("plastico")
                .setTipoAplic("BAÑO")
                .buildLimpieza();

        Producto detergente = new LimpiezaBuilder()
                .setDescripcion("Detergente")
                .setPrecioPorUnid(250)
                .setPorcentajeGanancia(1)
                .setDisponible(true)
                .setImportado(false)
                .setCantStock(20)
                .setDescuento(1)
                .setTipoEnv("plastico")
                .setTipoAplic("COCINA")
                .buildLimpieza();

        Producto trapo = new LimpiezaBuilder()
                .setDescripcion("Trapo")
                .setPrecioPorUnid(250)
                .setPorcentajeGanancia(15)
                .setDisponible(true)
                .setCantStock(20)
                .setTipoEnv("Tela")
                .setDescuento(5)
                .setTipoAplic("MULTIUSO")
                .buildLimpieza();

        Producto cerveza = new BebidaBuilder()
                .setDescripcion("Cerveza")
                .setPrecioPorUnid(1600)
                .setPorcentajeGanancia(20)
                .setDisponible(true)
                .setCalorias(5000)
                .setImportado(false)
                .setDescuento(1)
                .setCantStock(200)
                .setTipoEnv("plastico")
                .isComestible(true)
                .setGradAlcohol(4)
                .setFechaVen(2026, 3,5)
                .buildBebida();

        Producto jugoFruta = new BebidaBuilder()
                .setDescripcion("Jugo")
                .setPrecioPorUnid(900)
                .setDisponible(true)
                .setPorcentajeGanancia(20)
                .setCalorias(5000)
                .setImportado(false)
                .setDescuento(1)
                .setCantStock(5)
                .setTipoEnv("plastico")
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
        //Hago algunas compras para agregar productos a mi inventario

        //Muestro los productos en stock
        tienda.mostrarProductos();


        //REALIZAR VENTA |---
        //---------------|---
        //---------------V---
        //Realizo una venta donde me pedirá el codigo de tipo de producto, su nombre, y la cantidad de productos que quiero vender de c/u.
        for(int i = 0; i < 3; i++){
            tienda.venderProductos();
            tienda.mostrarProductos();//itero tres veces el vender un producto como forma de limitar las ventas a tres productos.
        }
        //Probar ver los productos con menor descuentos ordenados de manera ascendente:
        //   tienda.obtenerComestiblesConMenorDescuento(10);
//        tienda.mostrarProductos();







//        tienda.comprarProducto(yerba);
//        tienda.comprarProducto(limpiaVidrio);
//        tienda.comprarProducto(limpiaVidrio);
//        tienda.comprarProducto(limpiaVidrio);
//        tienda.comprarProducto(limpiaVidrio);






    }


}