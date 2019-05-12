package server.controller;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.sun.jersey.multipart.FormDataParam;

import server.dao.UserDAO;
import server.model.User;

@Path("/users")
public class UserService {

	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<User> getUsers() {
		return UserDAO.getAllUsers();
	}

	// Controle da resposta (status code, mensagem)
	@GET
	@Path("/{id}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response getUser(@PathParam("id") int id) {
		return Response.status(Status.OK).entity(UserDAO.getUser(id)).build();
	}

	@GET
	@Path("/search")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public User getUserByUsername(@QueryParam("user") String user) {
		return UserDAO.getUserByUsername(user);
	}

	@POST
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
		public User addUser(@FormDataParam("nome") String nome, @FormDataParam("tipo") String tipo,
			@FormDataParam("user") String user, @FormDataParam("senha")String senha,
			@FormDataParam("confSenha") String confSenha, @FormDataParam("crm")String crm,	
			@FormDataParam("telefone") String telefone, @FormDataParam("especialidade") String especialidade, 
			@FormDataParam("email") String email, @FormDataParam("nascimento") String nascimento, 
			@FormDataParam("cpf") String cpf) {

		return UserDAO.addUser(nome, tipo, user, senha, confSenha, crm, telefone, especialidade, 
				email, nascimento, cpf);
	}

	@PUT
	@Path("/{id}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public User updateUser(@PathParam("id") int id, @FormDataParam("nome") String nome, @FormDataParam("tipo") String tipo,
			@FormDataParam("user") String user, @FormDataParam("senha")String senha,
			@FormDataParam("confSenha") String confSenha, @FormDataParam("crm")String crm,	
			@FormDataParam("telefone") String telefone, @FormDataParam("especialidade") String especialidade, 
			@FormDataParam("email") String email, @FormDataParam("nascimento") String nascimento, 
			@FormDataParam("cpf") String cpf) {
		
		return UserDAO.updateUser(id, nome, tipo, user, senha, confSenha, crm, telefone, especialidade, 
				email, nascimento, cpf);
	}

	@DELETE
	@Path("/{id}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public static void deleteUser(@PathParam("id") int id) {
		UserDAO.deleteUser(id);
	}
	

}
