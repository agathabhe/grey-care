package server.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.xml.ws.Response;

import org.apache.tomcat.util.http.parser.MediaType;

import com.sun.jersey.multipart.FormDataParam;
import com.sun.org.apache.xerces.internal.util.Status;

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
	public User getUserByName(@QueryParam("user") String user) {
		return UserDAO.getUserByUsername(user);
	}

	@POST
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Consumes(MediaType.MULTIPART_FORM_DATA)
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
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public User updateUser(@PathParam("id") int id, (@FormDataParam("nome") String nome, @FormDataParam("tipo") String tipo,
			@FormDataParam("user") String user, @FormDataParam("senha")String senha,
			@FormDataParam("confSenha") String confSenha, @FormDataParam("crm")String crm,	
			@FormDataParam("telefone") String telefone, @FormDataParam("especialidade") String especialidade, 
			@FormDataParam("email") String email, @FormDataParam("nascimento") String nascimento, 
			@FormDataParam("cpf") String cpf) {
		
	}

	@DELETE
	@Path("/{id}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public void deleteUser(@PathParam("id") int id) {
		UserDAO.deleteUser(id);
	}
	
	//Session
	@POST
	@Path("/oi")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces("application/json")
    public Response hello(@Context HttpServletRequest req, @FormDataParam("name") String name) {
        HttpSession session = req.getSession(true);
        Object foo = session.getAttribute("foo");
        System.out.println(session.getId());
        
        if (foo != null) {
            System.out.println(foo.toString());
        } else {
            foo = "bar";
            session.setAttribute("foo", foo);
            System.out.println("first");
        }
        
        return Response.status(Status.OK).entity(foo.toString()).build();
    }
}
