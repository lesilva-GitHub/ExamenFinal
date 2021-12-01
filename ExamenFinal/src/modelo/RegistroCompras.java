/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import datos.ArchivoVentasTexto;
import java.io.IOException;
import java.util.List;
import logica.RelacionProductosVendidos;

/**
 *
 * @author usuario
 */
public class RegistroCompras{
    private ArchivoVentasTexto datos;

    public RegistroCompras() {
        this.datos = new ArchivoVentasTexto();
    }

    public ArchivoVentasTexto getDatos() {
        return datos;
    }

    public void setDatos(ArchivoVentasTexto datos) {
        this.datos = datos;
    }
    
    
    public boolean registrar(RelacionProductosVendidos Rpv) throws IOException{
        return this.datos.escribir(Rpv);
    }

    public List<RelacionProductosVendidos> leer() throws IOException {
        return this.datos.leer();
    }
}
