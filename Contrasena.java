package mx.uatx.controller;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;


import mx.uatx.dao.ContrasenaDAO;
import mx.uatx.dto.ContrasenaDTO;
import mx.uatx.dto.UsuarioDTO;

@RequestScoped
@SessionScoped
	public class Contrasena {
		private ContrasenaDTO password;
		private UsuarioDTO usuario;

		
		public void verificaUsuario() {

			FacesContext currentInstance = FacesContext.getCurrentInstance();
			try {
				if (password.getContrasenia() == "" || password.getContrasenaNueva() == "" || password.getConfirmarContrasena() == "") {
//					FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_WARN," Campos requeridos ");
//					currentInstance.addMessage(null);
				} else {

					if (password.getContrasenaNueva().equals(password.getConfirmarContrasena())) {
						ContrasenaDAO c = new ContrasenaDAO();
						boolean valido = c.verifica(usuario, password);

						if (valido) { 
							System.out.println("existencia de usuario");

							boolean actualizado = c.update(usuario, password);
							if (actualizado) {
								System.out.println("Contrase�a actualizado");
								FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Contrase�a",
										" Actualizado correctamente ");
								currentInstance.addMessage(null, fm);
                            
							} else {
								System.out.println("Error en la cambio de conytrase�a");
								FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, " ",
										" No se pudo actualizar tu contrase�a ");
								currentInstance.addMessage(null, fm);

							}
						} else {
							System.out.println("No hay usuario");
							FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
									" Contrase�a Incorrecta ");
							currentInstance.addMessage(null, fm);
						}
						
					} else {
						FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
								" Las contrase�as no coinciden ");
						currentInstance.addMessage(null, fm);
					}
				}

			} catch (Exception e) {

			}
		}


		public ContrasenaDTO getPassword() {
			return password;
		}


		public void setPassword(ContrasenaDTO password) {
			this.password = password;
		}
}

