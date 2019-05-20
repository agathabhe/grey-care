package server.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
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
		return UserDAO.getAllUser();
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
	public User getUserByUsername(@QueryParam("username") String username) {
		return UserDAO.getUserByUsername(username);
	}

	@POST
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response addUser(@FormDataParam("nome") String nome, @FormDataParam("tipo") String tipo,
			@FormDataParam("username") String username, @FormDataParam("senha") String senha,
			@FormDataParam("crm") String crm, @FormDataParam("telefone") String telefone,
			@FormDataParam("especialidade") String especialidade, @FormDataParam("email") String email,
			@FormDataParam("nascimento") String nascimento, @FormDataParam("cpf") String cpf) {
		
		if(nome == null|| tipo == null || username == null|| senha == null || crm == null || telefone == null || 
				especialidade == null  || email == null || nascimento == null|| cpf == null) {
			return Response.status(400).build();
		}

		return Response.status(Status.OK).entity(UserDAO.addUser(tipo, username, senha, nome, crm, telefone, especialidade, email, nascimento, cpf)).build();
	}

	@PUT
	@Path("/{id}")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response updateUser(@PathParam("id") int id, @FormDataParam("nome") String nome,
			@FormDataParam("tipo") String tipo, @FormDataParam("username") String username,
			@FormDataParam("senha") String senha, @FormDataParam("crm") String crm,
			@FormDataParam("telefone") String telefone, @FormDataParam("especialidade") String especialidade,
			@FormDataParam("email") String email, @FormDataParam("nascimento") String nascimento,
			@FormDataParam("cpf") String cpf) {

		if(nome == null|| tipo == null || username == null|| senha == null || crm == null || telefone == null || 
				especialidade == null  || email == null || nascimento == null|| cpf == null) {
			return Response.status(400).build();
		}

		return Response.status(Status.OK).entity(UserDAO.updateUser(id, nome, tipo, username, senha, crm, telefone, especialidade, email, nascimento,
				cpf)).build();
	}

	@DELETE
	@Path("/{id}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public static void deleteUser(@PathParam("id") int id) {
		UserDAO.deleteUser(id);
	}

}
