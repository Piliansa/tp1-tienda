package JavaClass;

import Interfaces.IVendible;

import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;




public class Tienda extends Producto implements IVendible {
    private String nombre;
    private int numMaxStock = 500;
    private double saldoCaja = 10000000;
    private final static double IVA = 0.21;
    private List<Producto> productosAComprar = new ArrayList<>();
    private int cantStockInventario = productosAComprar.size();


    public Tienda() {
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void saludar() {
        System.out.println("¡BIENVENIDOS A TIENDA " + nombre + "!");
    }

    public void comprarProducto(Producto producto) {
        double costoTotalProdSinIva = producto.getPrecioPorUnid() * producto.getCantStock();
        double costoTotalProducto = producto.getPrecioPorUnid() * producto.getCantStock() + (producto.getPrecioPorUnid()*IVA) * producto.getCantStock();
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
            System.out.println("Sin iva: " + costoTotalProdSinIva);
            System.out.println("Productos con iva: " + costoTotalProducto);
        }



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
        }
    }

    @Override
    public void venderProductos() {
        List<Producto> list = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        final int numMaxVenta = 3;
        final int numMaxProdCate = 12;




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
            if(producto.isImportado){
                producto.setPrecioPorUnidad(producto.getPrecioPorUnid() + producto.getPrecioPorUnid()* 0.12);
            }
            if (producto.isComestible) {
                producto.setPrecioPorUnidad(producto.getPrecioPorUnid() + producto.getPrecioPorUnid()* 0.2); //Los productos comestibles no pueden superar un 20% de ganancia
            } else if(!producto.isComestible && claveProd == "AZ"){ //Los de limpieza son siempre NO COMESTIBLES
                try {
                        if (producto.tipoAplic == "BAÑO"|| producto.tipoAplic == "ROPA") {
                            producto.setPrecioPorUnidad(producto.getPrecioConDescuento()); //suma el porcentaje de ganancia que no puede superar el 10%
                        } else if (claveProd == "AZ" && Objects.equals(producto.tipoAplic, "MULTIUSO") || Objects.equals(producto.tipoAplic, "COCINA")) { //salvo los "MULTIUSO" O "COCINA" que no tienen minimo en este caso le ponemos un 20%
                            producto.setPrecioPorUnidad(producto.getPrecioConDescuento());
                        }
                } catch (ArithmeticException e) {
                    System.out.println("Hubo un error de cálculo");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                productosFiltro.add(producto);
            }
            producto.setCantStock(producto.getCantStock() - cantProdAAVender);

            totalVenta = cantProdAAVender*producto.getPrecioPorUnid();
            saldoCaja = saldoCaja + totalVenta ;
            System.out.println(producto.id + " " + producto.descripcion + " " + cantProdAAVender + " X " + producto.precioPorUnid + " " + producto.isComestible + "\n precio Total: $" + totalVenta + "\n El saldo de caja es $ " + saldoCaja + "\n" + producto.cantStock + " Es lo que queda de producto en stock");

        mostrarStockTotal();
        };
    public void mostrarStockTotal(){
        int stockTotal = productosAComprar.stream()
                .mapToInt(Producto::getCantStock)
                .sum();

        System.out.println("El stock total de la tienda es de " + stockTotal + " productos.");
    }



    public void obtenerComestiblesConMenorDescuento(int porcentaje_descuento){

            List<String> descripcionesProdConMenorDesc = productosAComprar.stream()
                    .filter(prod ->prod.isComestible)
                    .filter(prod -> !prod.isImportado)
                    .filter(prod -> prod.getDescuento() < porcentaje_descuento)
                    .sorted(Comparator.comparingDouble(Producto::getDescuento))
                    .map(Producto::getDescripcion)
                    .collect(Collectors.toList());


        System.out.println("Los productos No Importados con menor descuento son: " + descripcionesProdConMenorDesc);





    }
}



//        System.out.println(productosFiltro.);

















