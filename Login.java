package mx.uatx.controller;
import java.io.Serializable;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import mx.uatx.dao.LoginDAO;
import mx.uatx.dto.UsuarioDTO;

@ManagedBean
public class Login implements Serializable {
	private String usuario;
	private String contrasena;
	private String msg;
	private String RolAdmi;
	private String RolPone;
	
	
	/**
	 * Verifica sea admnistrador
	 * 
	 */

	public boolean tieneRolAdmi(String rol) {

		String valor = obtenerValorSesion(rol);
		if (valor == null)
			return false;
		if (valor.equals("1")) {

			return true;

		} else {
			return false;
		}

	}

	/**
	 * Verifica ponente
	
	 */
	public boolean tieneRolPone(String rol) {

		String valor = obtenerValorSesion(rol);
		if (valor == null)
			return false;
		if (valor.equals("2")) {

			return true;

		} else {
			return false;
		}

	}
	
	public String obtenerValorSesion(String rol) {
		try {
			FacesContext context = FacesContext.getCurrentInstance();
			String bd = (String) context.getExternalContext().getSessionMap().get(rol);
			return bd;
		} catch (Exception ex) {
			return "";
		}
	}
	public void mostrarMensaje(String mensaje) {
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage(mensaje));
	}
	/**
	 * verifica si el usuario esta registrado en la base de datos
	 */
//	public String validateUsernamePassword() {
//		boolean valid = LoginDAO.validate(usuario, contrasena);
//		if (valid) {
//			HttpSession session = SessionBean.getSession();
//			session.setAttribute("username", usuario);
//			return "admin";
//		} else {
//			FacesContext.getCurrentInstance().addMessage(
//					null,
//					new FacesMessage(FacesMessage.SEVERITY_WARN,
//						"Incorrecto Usuario y contrasena",
//							"Please enter correct username and Password"));
//			return "login";
//		}
//	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getRolAdmi() {
		return RolAdmi;
	}

	public void setRolAdmi(String rolAdmi) {
		RolAdmi = rolAdmi;
	}

	public String getRolPone() {
		return RolPone;
	}

	public void setRolPone(String rolPone) {
		RolPone = rolPone;
	}
	

	
}