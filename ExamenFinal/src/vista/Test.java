/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.io.IOException;
import java.util.List;
import logica.RelacionProductosVendidos;
import modelo.RegistroCompras;

/**
 *
 * @author usuario
 */
public class Test {

    public static void main(String[] args) throws IOException {
        
        RegistroCompras modelo = new RegistroCompras();
        RelacionProductosVendidos Rpv1 = new RelacionProductosVendidos("AB - 07", "Alkosto", "Valledupar", "Cesar", "Acer - Nitro 05", 5000000, 30000, 0);
        RelacionProductosVendidos Rpv2 = new RelacionProductosVendidos("ZQ - 12", "Katronix", "Valledupar", "Cesar", "Xiaomi - RN8", 750000, 50000, 0);

        try {
            modelo.registrar(Rpv1);
            modelo.registrar(Rpv2);
            System.out.println("Compras en el Archivo: ");
            List<RelacionProductosVendidos> productos = modelo.leer();
            imprimirLista(productos);
        } catch (IOException ioe) {
            System.out.println(ioe);
        }
    }

    public static void imprimirRelacionProductosVendidos(RelacionProductosVendidos Rpv) {
        System.out.printf("%7s %18s %15s %13s %18s %20.2f %15.2f %15.2f%n", Rpv.getCodigoTienda(), Rpv.getNombreTienda(), Rpv.getCiudad(), Rpv.getDepartamento(), Rpv.getNombreProduccion(), Rpv.isSubtotal(), Rpv.isDescuentoAplicado(), Rpv.isTotal());
    }

    public static void imprimirLista(List<RelacionProductosVendidos> lista) {
        System.out.printf("%s %13s %12s %14s %17s %19s %18s %13s%n", "Codigo Tienda", "Ne Tienda", "Ciudad", "Dpt",
                "Ne Producto", "Subtotal", "Descuento", "Total");
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        lista.forEach((Rpv) -> {
            imprimirRelacionProductosVendidos(Rpv);
        });
    }
}
