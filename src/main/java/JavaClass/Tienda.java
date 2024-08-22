package JavaClass;

import java.util.*;

import static java.util.spi.ToolProvider.findFirst;

public class Tienda extends Producto{
    private String nombre = "Tienda Farolito";
    private int numMaxStock = 500;
    private double saldoCaja = 10000000;
    private List<Producto> productosAComprar = new ArrayList<>();
    private int cantStockInventario = productosAComprar.size();


    public Tienda() {

    }


    public void comprarProducto(Producto producto) {

            double costoTotalProducto = producto.getPrecioPorUnid() * producto.getCantStock();
            if (costoTotalProducto > saldoCaja) {
                System.out.println("No se puede agregar el producto por saldo insuficiente en la caja.");
            } else if (productosAComprar.size() > cantStockInventario) {
                throw new RuntimeException("No se puede agregar nuevos productos a la tienda ya que se alcanzó el máximo de stock");
            } else {
                saldoCaja -= costoTotalProducto;
                productosAComprar.add(producto);
                cantStockInventario = productosAComprar.size() + cantStockInventario;
                System.out.println("producto agregado");
                System.out.println("la cantidad de productos en lista son: " + cantStockInventario);
                System.out.println("El saldo de la caja es: " + saldoCaja);
            }

            mostrarProductos();

    }


    public void mostrarProductos() {
        if(productosAComprar.isEmpty()){
            System.out.println("no hay productos en stock");
        } else {
                    for(Producto producto : productosAComprar) {
                        System.out.println("Producto Id: " + producto.getId());
                        System.out.println("Descripción: " + producto.getDescripcion());
                        System.out.println("Cantidad de Stock comprado: " + producto.getCantStock());
                        for (String s : Arrays.asList("Precio por unidad: " + producto.precioPorUnid, "Disponibilidad: " + (producto.isDisponible() ? "SI" : "NO"), "--------------------------")) {
                            System.out.println(s);
                        }
                    };
        };


    }

    public void venderProductos(){
        final int maximoDeVentaTipo = 3;
        final int maximoPorProducto = 12;

        List<Producto> productosAVender = new ArrayList<>();

        Producto productoFiltro = (Producto) productosAVender.stream()
                .filter(prod->prod.getDescripcion()->descripcion)

    }


}





//    public HashMap getProductos(){
//        final HashMap values = (HashMap) productosEnStock.values();
//        return values;
//    }

//        public int getNumMaxStock () {
//            return numMaxStock;
//        }
//
//        public void setNumMaxStock ( int numMaxStock){
//            this.numMaxStock = numMaxStock;
//        }
//
//        public String getNombre () {
//            return nombre;
//        }
//
//        public void setNombre (String nombre){
//            this.nombre = nombre;
//        }
//
//        public Map<String, Producto> getProductosEnStock () {
//            return productosEnStock;
//        }
//
//        public void setProductosEnStock (Map < String, Producto > productosEnStock){
//            this.productosEnStock = productosEnStock;
//        }









//    public <nuevaVenta> Map<Producto id, descripcion> venderProductos() {
//        final int ventaMax = 3;
//        final int maxCantUnid = 12;
//        int cantUnidades;
//        int total;
//        HashMap<String, String> productosVendidos;
//
//
//
//
//        Tienda nuevaVenta = new Tienda();
//
//
//        return Map.of();
//
//        public void buscarProductosEnCatalogo(nuevaVenta){
//                Producto descripcion = productos.get(Producto.descripcion);
//
//    }




