import java.util.HashMap;
import java.util.Scanner;

/*
* Recomendaciones Generales:
*
*    -> El método run() funcionará como nuestro método principal
*    -> No declarar objetos de tipo Scanner, utilizar el método read() para solicitar datos al usuario.
*    -> Si requiere utilizar varias clases, estas NO deben ser tipo public.
 */
/**
 * Representa a los productos que se almacenan en el inventario
 */
class Producto {

    //Atributos
    private int codigo;
    private String nombre;
    private double precio;
    private int inventario;

    //get + set: 8 metodos publicos get/set
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getInventario() {
        return inventario;
    }

    public void setInventario(int inventario) {
        this.inventario = inventario;
    }

    //Constructores
    public Producto() {
    }

    public Producto(int codigo, String nombre, double precio, int inventario) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.inventario = inventario;
    }
}

class BaseDatosProductos {

    HashMap<Integer, Producto> listaProductos = new HashMap<Integer, Producto>();

    /**
     * constructor encargado de cargar los 10 primeros productos
     */
    public BaseDatosProductos() {
        listaProductos.put(1, new Producto(1, "Manzanas", 5000.0, 25));
        listaProductos.put(2, new Producto(2, "Limones", 2300.0, 15));
        listaProductos.put(3, new Producto(3, "Peras", 2700.0, 33));
        listaProductos.put(4, new Producto(4, "Arandanos", 9300.0, 5));
        listaProductos.put(5, new Producto(5, "Tomates", 2100.0, 42));
        listaProductos.put(6, new Producto(6, "Fresas", 4100.0, 3));
        listaProductos.put(7, new Producto(7, "Helado", 4500.0, 41));
        listaProductos.put(8, new Producto(8, "Galletas", 500.0, 8));
        listaProductos.put(9, new Producto(9, "Chocolates", 3500.0, 80));
        listaProductos.put(10, new Producto(10, "Jamon", 15000.0, 10));
    }

    /**
     * Agrega un producto al HashMap 'listaProductos'
     *
     * @param producto referencia a un objeto de tipo Producto
     */
    public void agregar(Producto producto) {
        listaProductos.put(producto.getCodigo(), producto);
    }

    /**
     * Actualiza un producto al HashMap 'listaProductos'
     *
     * @param producto referencia a un objeto de tipo Producto
     */
    public void actualizar(Producto producto) {
        listaProductos.replace(producto.getCodigo(), producto);
    }

    /**
     * Elimina un producto del HashMap 'listaProductos'
     *
     * @param producto referencia a un objeto de tipo Producto
     */
    public void eliminar(Producto producto) {
        listaProductos.remove(producto.getCodigo());
    }

    /**
     * Valida si el producto identificado con la llave existe en la coleccion
     * 'listaProductos'
     *
     * @param producto referencia a un objeto de tipo Producto
     * @return true si la llave exise en la coleccion false en caso contrario
     */
    public boolean vericarExistencia(Producto producto) {
        return listaProductos.containsKey(producto.getCodigo());
    }
    
    /**
     * Calcula el promedio de precios, sumando todos los precios y dividiendo 
     * entre la cantidad de productos
     * @return double con el promedio de precios
     */
    public double promedioPrecios(){
        double promedio=0.0;
        
        for(Producto objeto:listaProductos.values()){
            promedio += objeto.getPrecio();
        }
        promedio = promedio / listaProductos.size();
        return promedio;
    }
    
    /**
     * recorre la coleccion comparando el precio de los productos
     * para obtener el de mayor precio
     * @return nombre del producto con mayor precio
     */
    public String productoMayorPrecio(){
        //almaceno el nombre y precio del primer producto
        String nombreProducto=listaProductos.values().iterator().next().getNombre();
        double precioProducto=listaProductos.values().iterator().next().getPrecio();
        
        for(Producto objeto:listaProductos.values()){
            if (objeto.getPrecio() > precioProducto){
                nombreProducto = objeto.getNombre();
                precioProducto = objeto.getPrecio();
            }
        }
        
        return nombreProducto;
    }
    
    /**
     * recorre la coleccion comparando el precio de los productos
     * para obtener el de menor precio
     * @return nombre del producto con menor precio
     */
    public String productoMenorPrecio(){
        //almaceno el nombre y precio del primer producto
        String nombreProducto=listaProductos.values().iterator().next().getNombre();
        double precioProducto=listaProductos.values().iterator().next().getPrecio();
        
        for(Producto objeto:listaProductos.values()){
            if (objeto.getPrecio() < precioProducto){
                nombreProducto = objeto.getNombre();
                precioProducto = objeto.getPrecio();
            }
        }
        
        return nombreProducto;
    }
    
    /**
     * retorna una cadena contcatenada con nombre producto mayor precio,nombre producto menor precio
     * promedio de precios     
     * @return cadnea de caracteres
     */
    public String generarInforme() {
        return productoMayorPrecio() + " " + productoMenorPrecio() + " " + String.format("%.1f", promedioPrecios());
    }
}

/**
 * Esta clase se utilizara de ahora en adelante para generar el código de
 * nuestros retos en Master Tech
 *
 * @author desaextremo
 */
class Reto3 {

    /**
     * Este debe ser el único objeto de tipo Scanner en el código
     */
    private static final Scanner scanner = new Scanner(System.in);

    /**
     * Este método es usado para solicitar datos al usuario
     *
     * @return Lectura de la siguiente linea del teclado
     */
    public static String read() {
        return scanner.nextLine();
    }

    /**
     * Se requiere para poder probar nuestro programa en Netbeas, todas las
     * sentencias de este método se deben copiar y pegar en Master Tech en el
     * método run
     *
     * @param args arreglo de cadenas de caracteres
     */
    public void run(){
        //Acciones a realizar
        //Linea 1: Operacion ACTUALIZAR BORRAR AGREGAR
        String operacion = read();
        //Linea 2:Datos del Producto ej 11 Melon 70 13
        String datos[] = read().split(" ");
        int codigo = Integer.parseInt(datos[0]);
        String nombre = datos[1];
        double precio = Double.parseDouble(datos[2]);
        int inventario = Integer.parseInt(datos[3]);

        BaseDatosProductos baseDatosProductos = new BaseDatosProductos();
        Producto producto = new Producto(codigo, nombre, precio, inventario);

        if (operacion.equals("AGREGAR")) {
            if (!baseDatosProductos.vericarExistencia(producto)) {
                baseDatosProductos.agregar(producto);
                System.out.println(baseDatosProductos.generarInforme());
            } else {
                System.out.println("ERROR");
            }
        } else if (operacion.equals("BORRAR")) {
            if (baseDatosProductos.vericarExistencia(producto)) {
                baseDatosProductos.eliminar(producto);
                System.out.println(baseDatosProductos.generarInforme());
            } else {
                System.out.println("ERROR");
            }
        } else if (operacion.equals("ACTUALIZAR")) {
            if (baseDatosProductos.vericarExistencia(producto)) {
                baseDatosProductos.actualizar(producto);
                System.out.println(baseDatosProductos.generarInforme());
            } else {
                System.out.println("ERROR");
            }
        }
    }
}
