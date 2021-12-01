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
public interface IArchivos {

    public List<RelacionProductosVendidos> leer() throws IOException;

    public boolean escribir(RelacionProductosVendidos Rpv) throws IOException;

}
