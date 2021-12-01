/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

/**
 *
 * @author usuario
 */
public class RelacionProductosVendidos {

    private String CodigoTienda;
    private String NombreTienda;
    private String Ciudad;
    private String Departamento;
    private String NombreProduccion;
    private double Subtotal;
    private double DescuentoAplicado;
    private double Total;

    public RelacionProductosVendidos(String CodigoTienda, String NombreTienda, String Ciudad, String Departamento, String NombreProduccion, double Subtotal, double DescuentoAplicado, double Total) {
        this.CodigoTienda = CodigoTienda;
        this.NombreTienda = NombreTienda;
        this.Ciudad = Ciudad;
        this.Departamento = Departamento;
        this.NombreProduccion = NombreProduccion;
        this.Subtotal = Subtotal;
        this.DescuentoAplicado = DescuentoAplicado;
        this.Total = (double) this.Subtotal - this.DescuentoAplicado;
    }

    public RelacionProductosVendidos() {
    }

    public String getCodigoTienda() {
        return CodigoTienda;
    }

    public void setCodigoTienda(String CodigoTienda) {
        this.CodigoTienda = CodigoTienda;
    }

    public String getNombreTienda() {
        return NombreTienda;
    }

    public void setNombreTienda(String NombreTienda) {
        this.NombreTienda = NombreTienda;
    }

    public String getCiudad() {
        return Ciudad;
    }

    public void setCiudad(String Ciudad) {
        this.Ciudad = Ciudad;
    }

    public String getDepartamento() {
        return Departamento;
    }

    public void setDepartamento(String Departamento) {
        this.Departamento = Departamento;
    }

    public String getNombreProduccion() {
        return NombreProduccion;
    }

    public void setNombreProduccion(String NombreProduccion) {
        this.NombreProduccion = NombreProduccion;
    }

    public double isSubtotal() {
        return Subtotal;
    }

    public void setSubtotal(double Subtotal) {
        this.Subtotal = Subtotal;
    }

    public double isDescuentoAplicado() {
        return DescuentoAplicado;
    }

    public void setDescuentoAplicado(double DescuentoAplicado) {
        this.DescuentoAplicado = DescuentoAplicado;
    }

    public double isTotal() {
        return Total;
    }

    public void setTotal(double Total) {
        this.Total = Total;
    }

    public String getDastosArchivosTexto() {
        return this.CodigoTienda + ";"
                + this.NombreTienda + ";"
                + this.Ciudad + ";"
                + this.Departamento + ";"
                + this.NombreProduccion + ";"
                + this.Subtotal + ";"
                + this.DescuentoAplicado + ";"
                + this.Total;
    }

}
