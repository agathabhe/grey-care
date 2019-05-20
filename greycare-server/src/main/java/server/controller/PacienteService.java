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

import server.dao.PacienteDAO;
import server.model.Paciente;

@Path("/pacientes")
public class PacienteService {

	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<Paciente> getPacientes() {
		return PacienteDAO.getAllPaciente();
	}

	// Controle da resposta (status code, mensagem)
	@GET
	@Path("/{id}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response getPaciente(@PathParam("id") int id) {
		return Response.status(Status.OK).entity(PacienteDAO.getPaciente(id)).build();
	}

	@GET
	@Path("/search")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Paciente getPacienteByName(@QueryParam("nome") String nome) {
		return PacienteDAO.getPacienteByName(nome);
	}

	@POST
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public Response addPaciente(@FormDataParam("nome") String nome, @FormDataParam("cpf") String cpf,
			@FormDataParam("nascimento") String nascimento, @FormDataParam("telefone") String telefone,
			@FormDataParam("estadoCivil") String estadoCivil, @FormDataParam("endereco") String endereco,
			@FormDataParam("cep") String cep, @FormDataParam("email") String email,
			@FormDataParam("alergias") String alergias, @FormDataParam("tipoSanguineo") String tipoSanguineo,
			@FormDataParam("doador") String doador) {
		
		if(nome == null || cpf == null || nascimento == null || telefone == null || estadoCivil == null || endereco == null || cep == null || email == null || alergias == null || 
				tipoSanguineo == null || doador == null ) {
			return Response.status(400).build();
		}

		return Response.status(Status.OK).entity(PacienteDAO.addPaciente(nome, cpf, nascimento, telefone, estadoCivil, endereco, cep, email, alergias,
				tipoSanguineo, doador)).build();
	}

	@PUT
	@Path("/{id}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public Response updatePaciente(@PathParam("id") int id, @FormDataParam("nome") String nome,
			@FormDataParam("cpf") String cpf, @FormDataParam("nascimento") String nascimento,
			@FormDataParam("telefone") String telefone, @FormDataParam("estadoCivil") String estadoCivil,
			@FormDataParam("endereco") String endereco, @FormDataParam("cep") String cep,
			@FormDataParam("email") String email, @FormDataParam("alergias") String alergias,
			@FormDataParam("tipoSanguineo") String tipoSanguineo, @FormDataParam("doador") String doador) {

		if(nome == null || cpf == null || nascimento == null || telefone == null || estadoCivil == null || endereco == null || cep == null || email == null || alergias == null || 
				tipoSanguineo == null || doador == null ) {
			return Response.status(400).build();
		}
		
		return Response.status(Status.OK).entity(PacienteDAO.updatePaciente(id, nome, cpf, nascimento, telefone, estadoCivil, endereco, cep, email,
				alergias, tipoSanguineo, doador)).build();
		
	}

	@DELETE
	@Path("/{id}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public void deletePaciente(@PathParam("id") int id) {
		PacienteDAO.deletePaciente(id);
	}

}
