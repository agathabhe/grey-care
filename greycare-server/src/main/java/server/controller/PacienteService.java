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
		//int id, String nome, String cpf, String nascimento, String telefone, String estadoCivil,
		//String endereco, String cep, String email, String alergias, String tipoSanguineo, String doador
		public Paciente addPaciente(@FormDataParam("nome") String nome, @FormDataParam("cpf") String cpf, @FormDataParam("nascimento") String nascimento, @FormDataParam("telefone") String telefone,
				@FormDataParam("estadoCivil") String estadoCivil, @FormDataParam("endereco") String endereco, @FormDataParam("cep") String cep ,@FormDataParam("email")  String email , 
				@FormDataParam("alergias") String alergias,	@FormDataParam("tipoSanguineo") String tipoSanguineo, @FormDataParam("doador") String doador){

			return PacienteDAO.addPaciente(nome, cpf, nascimento, telefone, estadoCivil, endereco, cep, email, alergias, tipoSanguineo, doador);
		}

		@PUT
		@Path("/{id}")
		@Consumes(MediaType.MULTIPART_FORM_DATA)
		@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
		public Paciente updatePaciente(@PathParam("id") int id, @FormDataParam("nome") String nome, @FormDataParam("cpf") String cpf, @FormDataParam("nascimento") String nascimento, @FormDataParam("telefone") String telefone,
				@FormDataParam("estadoCivil") String estadoCivil, @FormDataParam("endereco") String endereco, @FormDataParam("cep") String cep ,@FormDataParam("email") String email , 
				@FormDataParam("alergias") String alergias,	@FormDataParam("tipoSanguineo") String tipoSanguineo, @FormDataParam("doador") String doador) {
			
			return PacienteDAO.updatePaciente(id, nome, cpf, nascimento, telefone, estadoCivil, endereco, cep, email, alergias, tipoSanguineo, doador);
		}

		@DELETE
		@Path("/{id}")
		@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
		public void deletePaciente(@PathParam("id") int id) {
			PacienteDAO.deletePaciente(id);
		}
		

}
