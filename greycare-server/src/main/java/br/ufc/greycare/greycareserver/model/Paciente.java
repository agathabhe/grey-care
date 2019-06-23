package br.ufc.greycare.greycareserver.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Paciente {
	
	@Id
	@GeneratedValue
	private int id;
	@Column(columnDefinition="text")
	private String nome;
	@Column(columnDefinition="text")
	private String cpf;
	@Column(columnDefinition="text")
	private String nascimento;
	@Column(columnDefinition="text")
	private String telefone;
	@Column(columnDefinition="text")
	private String estadoCivil;
	@Column(columnDefinition="text")
	private String endereco;
	@Column(columnDefinition="text")
	private String cep;
	@Column(columnDefinition="text")
	private String email;
	@Column(columnDefinition="text")
	private String alergias;
	@Column(columnDefinition="text")
	private String tipoSanguineo;
	@Column(columnDefinition="text")
    private String doador;	
    
    public Paciente() {
    	
    }

	public Paciente(int id, String nome, String cpf, String nascimento, String telefone, String estadoCivil,
			String endereco, String cep, String email, String alergias, String tipoSanguineo, String doador) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.nascimento = nascimento;
		this.telefone = telefone;
		this.estadoCivil = estadoCivil;
		this.endereco = endereco;
		this.cep = cep;
		this.email = email;
		this.alergias = alergias;
		this.tipoSanguineo = tipoSanguineo;
		this.doador = doador;
	}
	
	public Paciente(String nome, String cpf, String nascimento, String telefone, String estadoCivil,
			String endereco, String cep, String email, String alergias, String tipoSanguineo, String doador) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.nascimento = nascimento;
		this.telefone = telefone;
		this.estadoCivil = estadoCivil;
		this.endereco = endereco;
		this.cep = cep;
		this.email = email;
		this.alergias = alergias;
		this.tipoSanguineo = tipoSanguineo;
		this.doador = doador;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNascimento() {
		return nascimento;
	}

	public void setNascimento(String nascimento) {
		this.nascimento = nascimento;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAlergias() {
		return alergias;
	}

	public void setAlergias(String alergias) {
		this.alergias = alergias;
	}

	public String getTipoSanguineo() {
		return tipoSanguineo;
	}

	public void setTipoSanguineo(String tipoSanguineo) {
		this.tipoSanguineo = tipoSanguineo;
	}

	public String getDoador() {
		return doador;
	}

	public void setDoador(String doador) {
		this.doador = doador;
	}

	@Override
	public String toString() {
		return "Paciente [id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", nascimento=" + nascimento + ", telefone="
				+ telefone + ", estadoCivil=" + estadoCivil + ", endereco=" + endereco + ", cep=" + cep + ", email="
				+ email + ", alergias=" + alergias + ", tipoSanguineo=" + tipoSanguineo + ", doador=" + doador + "]";
	}
    
}
