package JavaClass;

import Interfaces.IVendible;

import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;


public class Tienda extends Producto implements IVendible {
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
        if (productosAComprar.isEmpty()) {
            System.out.println("no hay productos en stock");
        } else {
            for (Producto producto : productosAComprar) {
                System.out.println("Producto Id: " + producto.getId());
                System.out.println("Descripción: " + producto.getDescripcion());
                System.out.println("Cantidad de Stock comprado: " + producto.getCantStock());
                for (String s : Arrays.asList("Precio por unidad: " + producto.precioPorUnid, "Disponibilidad: " + (producto.isDisponible() ? "SI" : "NO"), "--------------------------")) {
                    System.out.println(s);
                }
            }
            ;
        }
        ;
    }

    @Override
    public void venderProductos() {
        List<Producto> list = new ArrayList<>();
        final int numMaxVenta = 3;
        final int numMaxProdCate = 12;



    System.out.println("Ingrese el código del tipo de producto, donde AC = Bebida / AB = Envasado / AZ = Limpieza");
    Scanner scanner = new Scanner(System.in);
    CharSequence claveProd;
    claveProd = scanner.nextLine();
    System.out.println("Ingrese el nombre del Producto que quiere vender");
    String nombreProd = scanner.nextLine();
    productosAComprar.stream()
            .filter(producto -> producto.getId().contains(claveProd))
            .filter(producto -> producto.isDisponible)
            .filter(producto -> producto.descripcion.equals(nombreProd))
            .collect(Collectors.toSet())
            .forEach(producto -> {
                System.out.println("Ingrese la cantidad de productos " + nombreProd + " que quiere vender:");
                int cantAVender = scanner.nextInt();
                if(cantAVender>numMaxProdCate) {
                    System.out.println("No se pueden vender mas de 12 productos");
                    cantAVender = 12;
                }
                if (cantAVender>producto.cantStock) {
                    System.out.println("No hay suficiente stock, se venderán " + producto.cantStock + " unidades.");
                    cantAVender = cantStock;
                }
                if (producto.isComestible){
                    producto.precioPorUnid = producto.precioPorUnid + (producto.precioPorUnid*0.2);
                }
                if(claveProd == "AZ" && Objects.equals(producto.tipoAplic, "BAÑO") || Objects.equals(producto.tipoAplic, "ROPA") ) {
                    producto.precioPorUnid = producto.precioPorUnid + (producto.precioPorUnid*0.1);
                }
                if (claveProd == "AZ" && Objects.equals(producto.tipoAplic, "MULTIUSO") || Objects.equals(producto.tipoAplic, "COCINA")  ) {
                    producto.precioPorUnid = producto.precioPorUnid + (producto.precioPorUnid*0.2);
                }
                producto.cantStock = producto.cantStock - cantAVender;
                System.out.println(producto.id + producto.descripcion + cantAVender + " X " + producto.precioPorUnid + producto.isComestible);

            });


    ;


    };





            //-> Objects.equals(pro.getDescripcion(descripcion), "Galletitas de agua")


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




