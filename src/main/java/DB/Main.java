package DB;

import java.sql.*;

public class Main {
    public static void main(String[] args) {

        Connection bd = conexion();
        System.out.println("Realizando consultas...");
        //aqui van las llamadas a los metodos donde hacemos las consultas.
        consulta(bd);
//        insertar(bd);
        upDate(bd);
        consulta(bd);

        desconectar(bd);

    }

    public static void upDate(Connection conexion){
        System.out.println("Modificando...");

        String query = "UPDATE estudiante set nombre='Patri' where nia='43214321'";

        Statement stmt;

        try {
            stmt = conexion().createStatement();
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static void insertar(Connection conexion){
        System.out.println("Insertando...");
        String query = "INSERT INTO estudiante (nia, nombre, dob) VALUES (43214321, 'Patricia', '1900-04-19');";

        Statement stmt;

        try {
            stmt = conexion().createStatement();
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static void consulta(Connection conexion){

        String query = "SELECT * FROM estudiante";

        Statement stmt;
        ResultSet respuesta;

        try {
            stmt = conexion().createStatement();
            respuesta = stmt.executeQuery(query);

            while (respuesta.next()){
                int nia = respuesta.getInt("nia");
                String nombre = respuesta.getString("nombre");
                Date dob = respuesta.getDate("dob");
                System.out.println("NIA: " + nia + " Nombre: " + nombre + " Fecha de nacimiento: " + dob);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }




    }

    public static Connection conexion() {
        Connection conexion;
        String host = "jdbc:mariadb://localhost:3310/";
        String user = "root";
        String psw = "";
        String bd = "instituto";
        System.out.println("Conectando...");

        try {
            conexion = DriverManager.getConnection(host+bd,user,psw);
            System.out.println("Conexión realizada con éxito.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }

        return conexion;
    }

    public static void desconectar(Connection conexion){

        System.out.println("Desconectando...");

        try {
            conexion.close();
            System.out.println("Conexión finalizada.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
