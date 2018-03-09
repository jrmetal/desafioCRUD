package services;

import java.util.List;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import com.google.gson.Gson;

import dao.UsuarioDAO;
import domain.Usuario;

@Path("usuario")
public class UsuarioService {

	@GET
	public String listar() {

		UsuarioDAO usuarioDAO = new UsuarioDAO();

		List<Usuario> usuarios = usuarioDAO.listar();

		Gson gson = new Gson();

		String json = gson.toJson(usuarios);

		return json;
	}

	@GET
	@Path("{id}")
	public String buscar(@PathParam("id") int id) {
		UsuarioDAO usuarioDAO = new UsuarioDAO();

		Usuario usuario = new Usuario();
		usuario = usuarioDAO.buscarPorCodigo(id);

		Gson gson = new Gson();

		String json = gson.toJson(usuario);

		return json;
	}

	@POST
	public String salvar(String json) {

		Gson gson = new Gson();
		Usuario usuario = gson.fromJson(json, Usuario.class);

		UsuarioDAO usuarioDAO = new UsuarioDAO();
		usuarioDAO.salvar(usuario);

		return "{\"Status\":true,\"MSG\":\"Usuário cadastrado com sucesso\",\"ID\":" + usuario.getId() + "}";
	}

	@PUT
	public String editar(String json) {
		Gson gson = new Gson();
		Usuario usuario = gson.fromJson(json, Usuario.class);

		UsuarioDAO usuarioDAO = new UsuarioDAO();
		usuarioDAO.editar(usuario);
		return "{\"Status\":true,\"MSG\":\"Usuário atualizado com sucesso\"," + json + "}";
	}

	@DELETE
	public String excluir(String json) {

		Gson gson = new Gson();
		Usuario usuario = gson.fromJson(json, Usuario.class);

		UsuarioDAO usuarioDAO = new UsuarioDAO();
		usuarioDAO.excluir(usuario);

		return "{\"Status\":true,\"MSG\":\"Usuário " + usuario.getNome() + " deletado com sucesso\"}";

	}
}
