/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Seguridad.Controlador;
import java.util.List;
import Seguridad.Modelo.daoVentas;
/**
 *
 * @author visitante
 */
public class clsVentas {
    private int IdAplicacion;
    private String NombreAplicacion;
    private String EstatusAplicacion;
    private int Ventas;

    public int getIdAplicacion() {
        return IdAplicacion;
    }

    public void setIdAplicacion(int IdAplicacion) {
        this.IdAplicacion = IdAplicacion;
    }

    public String getNombreAplicacion() {
        return NombreAplicacion;
    }

    public void setNombreAplicacion(String NombreAplicacion) {
        this.NombreAplicacion = NombreAplicacion;
    }

    public String getEstatusAplicacion() {
        return EstatusAplicacion;
    }

    public void setEstatusAplicacion(String EstatusAplicacion) {
        this.EstatusAplicacion = EstatusAplicacion;
    }
    
    public int getVentas() {
        return Ventas;
    }

    public void setVentas(int Ventas) {
        this.Ventas = Ventas;
    }

    public clsVentas(int IdAplicacion, String NombreAplicacion, int Ventas, String EstatusAplicacion) {
        this.IdAplicacion = IdAplicacion;
        this.NombreAplicacion = NombreAplicacion;
        this.Ventas = Ventas;
        this.EstatusAplicacion = EstatusAplicacion;
    }

    public clsVentas(int IdAplicacion, String NombreAplicacion) {
        this.IdAplicacion = IdAplicacion;
        this.NombreAplicacion = NombreAplicacion;
    }

    public clsVentas(int IdAplicacion) {
        this.IdAplicacion = IdAplicacion;
    }

    public clsVentas() {
    }

    
    //Metodos de acceso a la capa controlador
    public clsVentas getBuscarInformacionAplicacionPorNombre(clsVentas aplicacion)
    {
        daoVentas daoAplicacion = new daoVentas();
        return daoAplicacion.consultaAplicacionPorNombre(aplicacion);
    }
    public clsVentas getBuscarInformacionAplicacionPorId(clsVentas aplicacion)
    {
        daoVentas daoAplicacion = new daoVentas();
        return daoAplicacion.consultaAplicacionPorId(aplicacion);
    }    
    public List<clsVentas> getListadoAplicaciones()
    {
        daoVentas daoAplicacion = new daoVentas();
        List<clsVentas> listadoUsuarios = daoAplicacion.consultaAplicacion();
        return listadoUsuarios;
    }
    public int setBorrarAplicacion(clsVentas aplicacion)
    {
        daoVentas daoAplicacion = new daoVentas();
        return daoAplicacion.borrarAplicacion(aplicacion);
    }          
    public int setIngresarAplicacion(clsVentas aplicacion)
    {
        daoVentas daoAplicacion = new daoVentas();
        return daoAplicacion.ingresaAplicacion(aplicacion);
    }              
    public int setModificarAplicacion(clsVentas aplicacion)
    {
        daoVentas daoAplicacion = new daoVentas();
        return daoAplicacion.actualizaAplicacion(aplicacion);
    }              
}
