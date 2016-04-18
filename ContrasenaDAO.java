package mx.uatx.dao;
import java.sql.Connection;
import java.sql.ResultSet;

import mx.uatx.db.ConexionBD;
import mx.uatx.dto.ContrasenaDTO;
import mx.uatx.dto.UsuarioDTO;
import mx.uatx.db.SQLQueries;

public class ContrasenaDAO {

	public boolean verifica(UsuarioDTO usuario, ContrasenaDTO contrasenia) {
		boolean bverifica = false;
		try {
			ConexionBD conexionBD = new ConexionBD();
			SQLQueries sqlQueries = null;
			ResultSet rs = null;
			String query = "";
			conexionBD.abrir();
			Connection conn = conexionBD.getConexion();
			sqlQueries = new SQLQueries(conn);
			query = "select usuario,contrasenia from usuarios where  usuarios='" + "'  and contrasenia='";

			//proceso para saber que debe regresar
			rs = sqlQueries.consulta(query);

		} catch (Exception ex) {
			System.out.println(ex.getMessage());

			return false;
		}
		return bverifica;
	}

	public boolean update(UsuarioDTO usuario, ContrasenaDTO contrasena) {
		System.out.println("metodo update " + contrasena.getContrasenaNueva());
		try {
			ConexionBD conexionBD = new ConexionBD();
			SQLQueries sqlQueries = null;
			String query = "";
			conexionBD.abrir();

			Connection conn = conexionBD.getConexion();
			sqlQueries = new SQLQueries(conn);

			query = " UPDATE usuarios SET contrasena='" + contrasena.getConfirmarContrasena() +"'";
			sqlQueries.actualiza(query);

			return true;

		} catch (Exception ex) {
			System.out.println("Update " + ex.getMessage());

			return false;
		}
	}

}

