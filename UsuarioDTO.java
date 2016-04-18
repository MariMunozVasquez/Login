package mx.uatx.dto;

public class UsuarioDTO {
	private String user;
	private String pass;
	private Integer rol;
	
	public String getUsuarioo() {
		return user;
	}
	public void setUsuario(String usuario) {
		this.user = usuario;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public Integer getRol() {
		return rol;
	}
	public void setRol(Integer rol) {
		this.rol = rol;
	}
	
}

