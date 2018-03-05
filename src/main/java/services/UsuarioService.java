package services;

import java.util.Date;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import com.google.gson.Gson;

import dao.UsuarioDAO;
import domain.Usuario;

@Path("usuario")
public class UsuarioService {

	@GET
	public String exibir() {

		Usuario usuario = new Usuario();

		// usuario.setUsuario("Maria");
		// usuario.setDataNascimento(new Date());
		// usuario.setEndereco("rua dois");
		// usuario.setRg("1234");

		UsuarioDAO usuarioDAO = new UsuarioDAO();

		// usuarioDAO.salvar(usuario);

		List<Usuario> usuarios = usuarioDAO.listar();
		// usuario = usuarioDAO.buscarPorCodigo(usuarios.get(0).getId());
		// usuarioDAO.excluir(usuario);

		Gson gson = new Gson();

		String json = gson.toJson(usuarios);

		return "Teste Restful Usuariossss" + json;
	}

	@GET
	@Path("{id}")
	public String buscar(@PathParam("id") int id) {
		UsuarioDAO usuarioDAO = new UsuarioDAO();

		Usuario usuario = new Usuario();
		usuario = usuarioDAO.buscarPorCodigo(id);

		Gson gson = new Gson();

		String json = gson.toJson(usuario); 

		return "Teste Restful Usuariossss" + json;
	}

}
