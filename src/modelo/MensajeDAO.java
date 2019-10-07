/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class MensajeDAO {

    Conexion con;

    public MensajeDAO() {
        this.con = new Conexion();
    }

    public ArrayList<Mensaje> getMensajes() {

        ArrayList<Mensaje> mensajes = new ArrayList<>();
        Connection accesoBD = con.getConexion();

        try {
            String sql = "SELECT * FROM mensaje ";

            //System.out.println(sql);
            Statement st = accesoBD.createStatement();
            ResultSet resultados = st.executeQuery(sql);

            while (resultados.next()) {
                int id_mensaje = resultados.getInt("id_mensaje");
                String contenido = resultados.getString("contenido");
                int id_usr_emisor = resultados.getInt("id_usr_emisor");
                int id_usr_receptor = resultados.getInt("id_usr_receptor");

                mensajes.add(new Mensaje(id_mensaje, contenido, id_usr_emisor, id_usr_receptor));
            }
            accesoBD.close();
            return mensajes;
        } catch (Exception e) {
            System.out.println();
            System.out.println("Error al obtener");
            e.printStackTrace();
            return null;
        }

    }

    public Mensaje obtenerMensaje(int id_usr_emisor) {

        Mensaje m;
        Connection accesoBD = con.getConexion();

        try {
            String sql = "SELECT * FROM mensaje WHERE id = " + id_usr_emisor + " ";

            //System.out.println(sql);
            Statement st = accesoBD.createStatement();
            ResultSet rs = st.executeQuery(sql);

            if (rs.first()) {
                int id_mensaje=rs.getInt("id_mensaje");
                String contenido = rs.getString("contenido");
                int id_usr_receptor = rs.getInt("id_usr_receptor");

                m = new Mensaje(id_mensaje, contenido, id_usr_emisor, id_usr_receptor);
                accesoBD.close();
                return m;
            } else {
                return null;
            }
        } catch (Exception e) {
            System.out.println();
            System.out.println("Error al obtener");
            e.printStackTrace();
            return null;
        }

    }



}