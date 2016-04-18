package mx.uatx.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexionBD {
	private final static String DB_USER = "root";
    private final static String DB_PASSWORD = "";
    private final static String DB_NAME = "mysql";
    
    private final static String DB_SRT_CON = "jdbc:mysql://localhost:3306/" + DB_NAME;
    Connection conexion = null;

	/**
     * Metodo que realiza una conexion  a base de datos
     * @return  una conexion a base de datos 
     */
    public void abrir() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.setConexion( DriverManager.getConnection(DB_SRT_CON,DB_USER,DB_PASSWORD));
            
            if(!conexion.isClosed()){
            	System.out.println("Se conectó a MySQL server...");
            }else{
            	System.out.println("No se conecto to MySQL server!...");
            }
        } catch (Exception ex) {
            System.out.println("Error:" + ex.getMessage());
            ex.getStackTrace();
        }
    }

   
    public Connection getConexion() {
		return conexion;
	}
    public void setConexion(Connection conexion) {
		this.conexion = conexion;
	}
   
    
   
}


