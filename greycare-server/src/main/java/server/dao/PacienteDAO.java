package server.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import server.dao.PacienteDAO;
import server.model.Paciente;
import server.util.DbUtil;

public class PacienteDAO {
	private static Connection connection = DbUtil.getConnection();

	public static Paciente addPaciente(String nome, String cpf, String nascimento, String telefone, String estadoCivil,
			String endereco, String cep, String email, String alergias, String tipoSanguineo, String doador) {
		try {
			PreparedStatement pStmt = connection.prepareStatement("insert into users(nome, cpf, nascimento, telefone, estadoCivil, endereco, cep, email, alergias, tipoSanguineo, doador) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
					Statement.RETURN_GENERATED_KEYS);
			pStmt.setString(1, nome);
			pStmt.setString(2, cpf);
			pStmt.setString(3, nascimento);
			pStmt.setString(4, telefone);
			pStmt.setString(5, estadoCivil);
			pStmt.setString(6, endereco);
			pStmt.setString(7, cep);
			pStmt.setString(8, email);
			pStmt.setString(9, alergias);
			pStmt.setString(10, tipoSanguineo);
			pStmt.setString(11, doador);
			pStmt.executeUpdate();
			ResultSet rs = pStmt.getGeneratedKeys();
			//int id, String nome, String cpf, String nascimento, String telefone, String estadoCivil,
			//String endereco, String cep, String email, String alergias, String tipoSanguineo, String doador
			if (rs.next()) {	
				return new Paciente(rs.getInt("id"), rs.getString("nome"),rs.getString("cpf"), rs.getString("nascimento"), rs.getString("telefone"), rs.getString("estadoCivil"),
					rs.getString("endereco"), rs.getString("cep"), rs.getString("email"), rs.getString("alergias"), rs.getString("tipoSanguineo"), rs.getString("doador"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	public static Paciente updatePaciente(int id, String nome, String cpf, String nascimento, String telefone, String estadoCivil,
			String endereco, String cep, String email, String alergias, String tipoSanguineo, String doador) {
		try {
			PreparedStatement pStmt = connection.prepareStatement("update users set nome=?, cpf=?, nascimento=?, telefone=?, estadoCivil=?, endereco=?, cep=?, email=?, alergias=?, tipoSanguineo=?, doador=?  where id=?",
					Statement.RETURN_GENERATED_KEYS);
			pStmt.setString(1, nome);
			pStmt.setString(2, cpf);
			pStmt.setString(3, nascimento);
			pStmt.setString(4, telefone);
			pStmt.setString(5, estadoCivil);
			pStmt.setString(6, endereco);
			pStmt.setString(7, cep);
			pStmt.setString(8, email);
			pStmt.setString(9, alergias);
			pStmt.setString(10, tipoSanguineo);
			pStmt.setString(11, doador);
			pStmt.setInt(3, id);
			pStmt.executeUpdate();
			ResultSet rs = pStmt.getGeneratedKeys();
			if (rs.next()) {
			return new Paciente(rs.getInt("id"), rs.getString("nome"),rs.getString("cpf"), rs.getString("nascimento"), rs.getString("telefone"), rs.getString("estadoCivil"),
					rs.getString("endereco"), rs.getString("cep"), rs.getString("email"), rs.getString("alergias"), rs.getString("tipoSanguineo"), rs.getString("doador"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	public static void deletePaciente(int id) {
		try {
			PreparedStatement pStmt = connection.prepareStatement("delete from pacientes where id=?");
			pStmt.setInt(1, id);
			pStmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static List<Paciente> getAllPaciente() {
		List<Paciente> pacientes = new ArrayList<Paciente>();
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("select * from users order by id");
			while (rs.next()) {
				Paciente paciente = new Paciente(rs.getInt("id"), rs.getString("nome"),rs.getString("cpf"), rs.getString("nascimento"), rs.getString("telefone"), rs.getString("estadoCivil"),
						rs.getString("endereco"), rs.getString("cep"), rs.getString("email"), rs.getString("alergias"), rs.getString("tipoSanguineo"), rs.getString("doador"));
				pacientes.add(paciente);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return pacientes;
	}

	public static Paciente getPaciente(int id) {
		try {
			PreparedStatement pStmt = connection.prepareStatement("select * from users where id=?");
			pStmt.setInt(1, id);
			ResultSet rs = pStmt.executeQuery();
			if (rs.next()) {
				return new Paciente(rs.getInt("id"), rs.getString("nome"),rs.getString("cpf"), rs.getString("nascimento"), rs.getString("telefone"), rs.getString("estadoCivil"),
						rs.getString("endereco"), rs.getString("cep"), rs.getString("email"), rs.getString("alergias"), rs.getString("tipoSanguineo"), rs.getString("doador"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	public static Paciente getPacienteByName(String nome) {
		try {
			PreparedStatement pStmt = connection.prepareStatement("select * from pacientes where nome=?");
			pStmt.setString(1, nome);
			ResultSet rs = pStmt.executeQuery();
			if (rs.next()) {
				return new Paciente(rs.getInt("id"), rs.getString("nome"),rs.getString("cpf"), rs.getString("nascimento"), rs.getString("telefone"), rs.getString("estadoCivil"),
						rs.getString("endereco"), rs.getString("cep"), rs.getString("email"), rs.getString("alergias"), rs.getString("tipoSanguineo"), rs.getString("doador"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	
}
