package JavaClass;

import Interfaces.IVendible;

import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;


public class Tienda extends Producto implements IVendible {
    private String nombre = "Tienda Farolito";
    private int numMaxStock = 500;
    private static double saldoCaja = 10000000;
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
                System.out.println("El saldo de la caja es: " + saldoCaja + " La cantidad de productos en listas son: " + producto.getCantStock());
//                for (String s : Arrays.asList("Precio por unidad: " + producto.precioPorUnid, "Disponibilidad: " + (producto.isDisponible() ? "SI" : "NO"), "--------------------------")) {
//                    System.out.println(s);
//                }
            }
            ;
        }
        ;
    }

    @Override
    public void venderProductos() {
        List<Producto> list = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        final int numMaxVenta = 3;
        final int numMaxProdCate = 12;


        for (int i = 0; i < numMaxVenta; i++) {

            System.out.println("Ingrese el código del tipo de producto, donde AC = Bebida / AB = Envasado / AZ = Limpieza");
            CharSequence claveProd = scanner.nextLine();
            System.out.println("Ingrese el nombre del Producto que quiere vender");
            String nombreProd = scanner.nextLine();
            List<Producto> productosFiltro = productosAComprar.stream()
                    .filter(producto -> producto.getId().contains(claveProd))
                    .filter(producto -> producto.isDisponible)
                    .filter(producto -> producto.descripcion.equals(nombreProd))
                    .collect(Collectors.toList());

            if (productosFiltro.isEmpty()) {
                System.out.println("No se encontró ese tipo de producto");

            }
            Producto producto = productosFiltro.get(0);

            double totalVenta = 0;
            System.out.println("Ingrese la cantidad de productos " + nombreProd + " que quiere vender:");
            int cantProdAAVender = scanner.nextInt();
            scanner.nextLine();
            if (cantProdAAVender > numMaxProdCate) {
                System.out.println("No se pueden vender mas de 12 productos");
                cantProdAAVender = 12; //vende solo el stock de venta maxima x categoria
            }
            if (cantProdAAVender > producto.cantStock) {
                cantProdAAVender = producto.cantStock; //se vende solo la cantidad disponible
            }
            try {
                if (producto.isComestible) {
                    producto.precioPorUnid = producto.precioPorUnid + (producto.precioPorUnid * 0.2);
                    totalVenta = producto.precioPorUnid * cantProdAAVender;
                } else if (claveProd == "AZ" && Objects.equals(producto.tipoAplic, "BAÑO") || Objects.equals(producto.tipoAplic, "ROPA")) {
                    producto.precioPorUnid = producto.precioPorUnid + (producto.precioPorUnid * 0.1);
                    totalVenta = producto.precioPorUnid * cantProdAAVender;
                } else if (claveProd == "AZ" && Objects.equals(producto.tipoAplic, "MULTIUSO") || Objects.equals(producto.tipoAplic, "COCINA")) {
                    producto.precioPorUnid = producto.precioPorUnid + (producto.precioPorUnid * 0.2);
                    totalVenta = producto.precioPorUnid * cantProdAAVender;
                }
                totalVenta *= cantProdAAVender;
                System.out.println(producto.id + " " + producto.descripcion + " " + cantProdAAVender + " X " + producto.precioPorUnid + " " + producto.isComestible + " precio Total: " + totalVenta);

            } catch (ArithmeticException e) {
                System.out.println("Hubo un error de cálculo");
            } catch (Exception e) {
                e.printStackTrace();
            }
            productosFiltro.add(producto);


            if (i > numMaxVenta - 1) {
                System.out.println("Desea hacer otra compra?: SI/NO");
                String respuesta = scanner.nextLine();
                if (!respuesta.equalsIgnoreCase("S")) {
                    break;
                }
            }
        }
    }
};


//        System.out.println(productosFiltro.);

















