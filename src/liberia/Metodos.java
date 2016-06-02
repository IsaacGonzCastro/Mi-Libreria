/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package liberia;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 *
 * @author Isaac
 */
public class Metodos {

    Connection cn = null;
    Statement cmd = null;

    /**
     * Permite conectarse a la base de datos a traves de la url de la base,elusuario y la contraseña
     * @param url url de la base de datos.
     * @param user nombre del usuario con el que accedemos a la base.
     * @param password contraseña del usuario.
     */
    public void Conectar(String url, String user, String password) {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            cn = (Connection) DriverManager.getConnection(url, user, password);
            System.out.println("Conectado");
        } catch (Exception ex) {
            System.out.println("No se ha podido conectar, error:" + ex.getLocalizedMessage());
        }
    }

    /**
     * Permite insertar un objeto en la base de datos pasandole el nombre de la tabla,nombre de las columas y los valores que quieres insertar.
     * @param tabla nombre de la tabla de la base de datos.
     * @param columnas nombre de las columnas que queremos insertar en la base.
     * @param valor los valores que queremos insertar.
     */
    public void insertar(String tabla, String columnas, String valor) {
        try {
            PreparedStatement pst = cn.prepareStatement("insert into" + tabla + "(" + columnas + ")values(" + valor + ")");
            pst.execute();
            System.out.println("Insertado");

        } catch (Exception insertar) {
            System.out.println(insertar.getMessage());
        }
    }
}
