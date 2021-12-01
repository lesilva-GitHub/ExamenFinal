/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import logica.RelacionProductosVendidos;

/**
 *
 * @author usuario
 */
public class ConsolidadoVentas implements IArchivos {

    private File Archivo;
    private FileOutputStream aEscritura;
    private FileInputStream aLectura;

    public ConsolidadoVentas() {
        this.Archivo = new File("ConsolidadosVentas.dat");
    }

    private boolean guardarLista(ListaArrayList lista) throws FileNotFoundException, IOException {
        this.aEscritura = new FileOutputStream(this.Archivo);
        ObjectOutputStream escritor = new ObjectOutputStream(this.aEscritura);
        escritor.writeObject(lista);
        escritor.close();
        this.aEscritura.close();
        return true;
    }

    private ListaArrayList leerLista() throws FileNotFoundException, IOException {
        if (this.Archivo.exists()) {
            this.aLectura = new FileInputStream(this.Archivo);
            ObjectInputStream lector = new ObjectInputStream(this.aLectura);
            try {
                ListaArrayList lista = (ListaArrayList) lector.readObject();
                return lista;
            } catch (ClassNotFoundException nfe) {
                throw new IOException("Error al leer");
            } finally {
                lector.close();
                this.aLectura.close();
            }

        } else {
            return new ListaArrayList();
        }
    }

    @Override
    public List<RelacionProductosVendidos> leer() throws IOException {
        ListaArrayList lista = this.leerLista();
        return lista.getLista();
    }

    @Override
    public boolean escribir(RelacionProductosVendidos Rpv) throws IOException {
        ListaArrayList lista = this.leerLista();
        lista.escribir(Rpv);
        return this.guardarLista(lista);
    }
}
