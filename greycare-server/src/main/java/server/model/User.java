package server.model;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAccessType;

@XmlRootElement(name = "user")
@XmlAccessorType(XmlAccessType.FIELD)
public class User {
	
	private int id;
	private String tipo;
	private String username;
	private String senha;
	private String nome;
	private String crm;
	private String telefone;
	private String especialidade;
	private String email;
	private String nascimento;
	private String cpf;
	
	public User() { 
		
	}
	
	public User(int id, String tipo, String username, String senha, String nome, String crm,
			String telefone, String especialidade, String email, String nascimento, String cpf) {
		super();
		this.id = id;
		this.tipo = tipo;
		this.username = username;
		this.senha = senha;
		this.nome = nome;
		this.crm = crm;
		this.telefone = telefone;
		this.especialidade = especialidade;
		this.email = email;
		this.nascimento = nascimento;
		this.cpf = cpf;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCrm() {
		return crm;
	}

	public void setCrm(String crm) {
		this.crm = crm;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNascimento() {
		return nascimento;
	}

	public void setNascimento(String nascimento) {
		this.nascimento = nascimento;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", tipo=" + tipo + ", username=" + username + ", senha=" + senha +", nome=" + nome + ", crm=" + crm + ", telefone=" + telefone + ", especialidade=" + especialidade
				+ ", email=" + email + ", nascimento=" + nascimento + ", cpf=" + cpf + "]";
	}
	
	
	
	
}
