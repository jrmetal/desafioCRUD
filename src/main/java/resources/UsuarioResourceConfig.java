package resources;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("restUsuario")
public class UsuarioResourceConfig extends ResourceConfig{

	public UsuarioResourceConfig() {
		packages("services");
	}
}
