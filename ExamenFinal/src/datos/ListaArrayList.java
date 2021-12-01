/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.io.IOException;
import java.util.List;
import logica.RelacionProductosVendidos;

/**
 *
 * @author usuario
 */
class ListaArrayList implements IArchivos {

    private List<RelacionProductosVendidos> lista;

    List<RelacionProductosVendidos> getLista() {
        return lista;
    }

    @Override
    public List<RelacionProductosVendidos> leer() throws IOException {
        return this.getLista();
    }

    @Override
    public boolean escribir(RelacionProductosVendidos Rpv) throws IOException {
        return this.getLista().add(Rpv);
    }

}
