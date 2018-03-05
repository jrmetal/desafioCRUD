package services;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import dao.UsuarioDAO;
import domain.Usuario;

@Path("usuario")
public class UsuarioService {

	@GET
	public String exibir() {
		UsuarioDAO usuarioDAO = new UsuarioDAO();

		List<Usuario> usuario = usuarioDAO.listarSQL();
		return "Teste Restful Usuario" + usuario;

	}

}
