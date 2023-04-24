/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Seguridad.Modelo;

import Seguridad.Controlador.clsVentas;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author visitante
 */
public class daoVentas {

    private static final String SQL_SELECT = "SELECT venid, vennombre, vennumeroventas, venareaventas FROM tbl_vendedores";
    private static final String SQL_INSERT = "INSERT INTO tbl_vendedores(vennombre, vennumeroventas, venareaventas) VALUES(?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE tbl_vendedores SET vennombre=?, vennumeroventas=?, venareaventas=? WHERE venid = ?";
    private static final String SQL_DELETE = "DELETE FROM tbl_vendedores WHERE venid=?";
    private static final String SQL_SELECT_NOMBRE = "SELECT venid, vennombre, vennumeroventas, venareaventas FROM tbl_vendedores WHERE vennombre = ?";
    private static final String SQL_SELECT_ID = "SELECT venid, vennombre, vennumeroventas, venareaventas FROM tbl_vendedores WHERE venid = ?";    

    public List<clsVentas> consultaAplicacion() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<clsVentas> aplicaciones = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("venid");
                String nombre = rs.getString("vennombre");
                int ventas = rs.getInt("vennumeroventas");
                String estatus = rs.getString("venareaventas");
                clsVentas aplicacion = new clsVentas();
                aplicacion.setIdAplicacion(id);
                aplicacion.setNombreAplicacion(nombre);
                aplicacion.setVentas(ventas);
                aplicacion.setEstatusAplicacion(estatus);
                aplicaciones.add(aplicacion);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return aplicaciones;
    }

    public int ingresaAplicacion(clsVentas aplicacion) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, aplicacion.getNombreAplicacion());
            stmt.setInt(2, aplicacion.getVentas());
            stmt.setString(3, aplicacion.getEstatusAplicacion());

            System.out.println("ejecutando query:" + SQL_INSERT);
            rows = stmt.executeUpdate();
            System.out.println("Registros afectados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public int actualizaAplicacion(clsVentas aplicacion) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, aplicacion.getNombreAplicacion());
            stmt.setString(2, aplicacion.getEstatusAplicacion());
            stmt.setInt(3, aplicacion.getVentas());
            stmt.setInt(4, aplicacion.getIdAplicacion());

            rows = stmt.executeUpdate();
            System.out.println("Registros actualizado:" + rows);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public int borrarAplicacion(clsVentas aplicacion) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, aplicacion.getIdAplicacion());
            rows = stmt.executeUpdate();
            System.out.println("Registros eliminados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public clsVentas consultaAplicacionPorNombre(clsVentas aplicacion) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_SELECT_NOMBRE + " objeto recibido: " + aplicacion);
            stmt = conn.prepareStatement(SQL_SELECT_NOMBRE);
            //stmt.setInt(1, aplicacion.getIdAplicacion());            
            stmt.setString(1, aplicacion.getNombreAplicacion());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("venid");
                String nombre = rs.getString("vennombre");
                int ventas = rs.getInt("vennumeroventas");
                String estatus = rs.getString("venareaventas");

                //aplicacion = new clsAplicacion();
                aplicacion.setIdAplicacion(id);
                aplicacion.setNombreAplicacion(nombre);
                aplicacion.setVentas(ventas);
                aplicacion.setEstatusAplicacion(estatus);
                System.out.println(" registro consultado: " + aplicacion);                
            }
            //System.out.println("Registros buscado:" + persona);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        //return personas;  // Si se utiliza un ArrayList
        return aplicacion;
    }
    public clsVentas consultaAplicacionPorId(clsVentas aplicacion) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_SELECT_NOMBRE + " objeto recibido: " + aplicacion);
            stmt = conn.prepareStatement(SQL_SELECT_ID);
            stmt.setInt(1, aplicacion.getIdAplicacion());            
            //stmt.setString(1, aplicacion.getNombreAplicacion());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("venid");
                String nombre = rs.getString("vennombre");
                int ventas = rs.getInt("vennumeroventas");
                String estatus = rs.getString("venareaventas");

                //aplicacion = new clsAplicacion();
                aplicacion.setIdAplicacion(id);
                aplicacion.setNombreAplicacion(nombre);
                aplicacion.setVentas(ventas);
                aplicacion.setEstatusAplicacion(estatus);
                System.out.println(" registro consultado: " + aplicacion);                
            }
            //System.out.println("Registros buscado:" + persona);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        //return personas;  // Si se utiliza un ArrayList
        return aplicacion;
    }    
}
