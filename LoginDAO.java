package mx.uatx.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import mx.uatx.dto.UsuarioDTO;
import mx.uatx.db.ConexionBD;
public class LoginDAO {

	public List<UsuarioDTO> isAcountExists(String usuario, String contrasena) {
		try {
			ConexionBD conexionBD = new ConexionBD();
			PreparedStatement ps = null;
			List<UsuarioDTO> listUsuarioEnSessionDTO = new ArrayList<UsuarioDTO>();
			UsuarioDTO filaUsuarioDTO = null;
			ResultSet rs = null;
			conexionBD.abrir();
			Connection conn = conexionBD.getConexion();
			ps = conn.prepareStatement(
			"Select usuario,contrasenia from usuarios where usuario collate latin1_bin = ? and contrasena collate latin1_bin = ?");
			ps.setString(1, usuario);
			ps.setString(2, contrasena);
			rs = ps.executeQuery();

			int count = 0;
			while (rs.next()) {
				filaUsuarioDTO = new UsuarioDTO();
				
				filaUsuarioDTO.setUsuario(rs.getString("usuario"));
				
				filaUsuarioDTO.setPass(rs.getString("contrasena"));
				
				filaUsuarioDTO.setRol(rs.getInt("RolAdmi"));
				
				listUsuarioEnSessionDTO.add(filaUsuarioDTO);

				count++;

				return listUsuarioEnSessionDTO;
			}
			if (count == 0) {
				System.out.println("Usuario no registrado");
			}
			
		} catch (Exception ex) {
			System.out.println("UsuarioDAO.isAcountExists:" + ex.getMessage());
			return null;
		}
		return null;
	}

}

