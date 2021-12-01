/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import logica.RelacionProductosVendidos;

/**
 *
 * @author usuario
 */
public class ArchivoVentasTexto implements IArchivos {

    private File Archivo;
    private FileWriter aEscritura;
    private Scanner aLectura;

    public ArchivoVentasTexto() {
        this.Archivo = new File("ReporteVentas.dat");
    }

    public ArchivoVentasTexto(String name) {
        this.Archivo = new File(name);
    }

    public File getArchivo() {
        return Archivo;
    }

    public void setArchivo(File Archivo) {
        this.Archivo = Archivo;
    }

    public FileWriter getaEscritura() {
        return aEscritura;
    }

    public void setaEscritura(FileWriter aEscritura) {
        this.aEscritura = aEscritura;
    }

    public Scanner getaLectura() {
        return aLectura;
    }

    public void setaLectura(Scanner aLectura) {
        this.aLectura = aLectura;
    }

    public RelacionProductosVendidos leerRelacionProductosVendidos(String linea[]) {
        RelacionProductosVendidos Rpv = new RelacionProductosVendidos();
        Rpv.setCodigoTienda(linea[0]);
        Rpv.setNombreTienda(linea[1]);
        Rpv.setCiudad(linea[2]);
        Rpv.setDepartamento(linea[3]);
        Rpv.setNombreProduccion(linea[4]);
        Rpv.setSubtotal(Double.valueOf(linea[5]));
        Rpv.setDescuentoAplicado(Double.valueOf(linea[6]));
        Rpv.setTotal(Double.valueOf(linea[7]));
        return Rpv;

    }

    @Override
    public List<RelacionProductosVendidos> leer() throws IOException {
        List<RelacionProductosVendidos> lista = null;

        try {
            this.aLectura = new Scanner(this.Archivo);
            lista = new ArrayList();
            while (this.aLectura.hasNext()) {
                String linea[] = this.aLectura.nextLine().split(";");
                RelacionProductosVendidos Rpv = this.leerRelacionProductosVendidos(linea);
                lista.add(Rpv);
            }
            return lista;

        } catch (FileNotFoundException ex) {
            throw new IOException("Error al leer este Archivo!!");
        } finally {
            if (this.aLectura != null) {
                this.aLectura.close();
            }
        }
    }

    @Override
    public boolean escribir(RelacionProductosVendidos Rpv) throws IOException {
        PrintWriter escritor = null;
        boolean exito = false;
        try {
            this.aEscritura = new FileWriter(this.Archivo, true);
            escritor = new PrintWriter(this.aEscritura);
            escritor.println(Rpv.getDastosArchivosTexto());
            exito = true;
            return exito;

        } catch (IOException ioe) {
            throw new IOException("Error al tratar de abrir el Archivo en modo escritura!!");
        } finally {
            if (escritor != null) {
                escritor.close();
            }
        }
    }
}
