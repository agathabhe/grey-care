package server.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import server.model.User;
import server.util.DbUtil;

public class UserDAO {

	private static Connection connection = DbUtil.getConnection();

	public static User addUser(String tipo, String user, String senha, String confSenha, String nome, String crm,
			String telefone, String especialidade, String email, String nascimento, String cpf) {
		try {
			PreparedStatement pStmt = connection.prepareStatement(
					"insert into users(nome, tipo, user, senha, conf_senha, crm, telefone, especialidade, \n"
							+ "					email, nascimento, cpf) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
					Statement.RETURN_GENERATED_KEYS);
			pStmt.setString(1, nome);
			pStmt.setString(2, tipo);
			pStmt.setString(3, user);
			pStmt.setString(4, senha);
			pStmt.setString(5, confSenha);
			pStmt.setString(6, crm);
			pStmt.setString(7, telefone);
			pStmt.setString(8, especialidade);
			pStmt.setString(9, email);
			pStmt.setString(10, nascimento);
			pStmt.setString(11, cpf);
			pStmt.executeUpdate();
			ResultSet rs = pStmt.getGeneratedKeys();
			if (rs.next()) {
//				int id, String tipo, String user, String senha, String confSenha, String nome, String crm,
//				String telefone, String especialidade, String email, String nascimento, String cpf
				return new User(rs.getInt("id"), rs.getString("tipo"), rs.getString("user"), rs.getString("senha"),
						rs.getString("conf_senha"), rs.getString("nome"), rs.getString("crm"), rs.getString("telefone"),
						rs.getString("especialidade"), rs.getString("email"), rs.getString("nascimento"),
						rs.getString("cpf"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	public static User updateUser(int id, String tipo, String user, String senha, String confSenha, String nome, String crm,
			String telefone, String especialidade, String email, String nascimento, String cpf) {
		try {
			PreparedStatement pStmt = connection.prepareStatement("update users set nome=?, tipo=?, user=?, senha=?, conf_senha=?, crm=?, telefone=?, especialidade=?, email=?, nascimento=?, cpf=? where id=?",
					Statement.RETURN_GENERATED_KEYS);
			pStmt.setString(1, nome);
			pStmt.setString(2, tipo);
			pStmt.setString(3, user);
			pStmt.setString(4, senha);
			pStmt.setString(5, confSenha);
			pStmt.setString(6, crm);
			pStmt.setString(7, telefone);
			pStmt.setString(8, especialidade);
			pStmt.setString(9, email);
			pStmt.setString(10, nascimento);
			pStmt.setString(11, cpf);
			pStmt.setInt(12, id);
			pStmt.executeUpdate();
			ResultSet rs = pStmt.getGeneratedKeys();
			if (rs.next()) {
				return new User(rs.getInt("id"), rs.getString("tipo"), rs.getString("user"), rs.getString("senha"),
						rs.getString("conf_senha"), rs.getString("nome"), rs.getString("crm"), rs.getString("telefone"),
						rs.getString("especialidade"), rs.getString("email"), rs.getString("nascimento"),
						rs.getString("cpf"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	public static void deleteUser(int id) {
		try {
			PreparedStatement pStmt = connection.prepareStatement("delete from users where id=?");
			pStmt.setInt(1, id);
			pStmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static List<User> getAllUser() {
		List<User> users = new ArrayList<User>();
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("select * from users order by id");
			while (rs.next()) {
				User user = new User(rs.getInt("id"),  rs.getString("tipo"), rs.getString("user"), rs.getString("senha"),
						rs.getString("conf_senha"), rs.getString("nome"), rs.getString("crm"), rs.getString("telefone"),
						rs.getString("especialidade"), rs.getString("email"), rs.getString("nascimento"),
						rs.getString("cpf"));
				users.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return users;
	}

	public static User getUser(int id) {
		try {
			PreparedStatement pStmt = connection.prepareStatement("select * from users where id=?");
			pStmt.setInt(1, id);
			ResultSet rs = pStmt.executeQuery();
			if (rs.next()) {
				return new User(rs.getInt("id"), rs.getString("tipo"), rs.getString("user"), rs.getString("senha"),
						rs.getString("conf_senha"), rs.getString("nome"), rs.getString("crm"), rs.getString("telefone"),
						rs.getString("especialidade"), rs.getString("email"), rs.getString("nascimento"),
						rs.getString("cpf"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	public static User getUserByUsername(String user) {
		try {
			PreparedStatement pStmt = connection.prepareStatement("select * from users where user=?");
			pStmt.setString(1, user);
			ResultSet rs = pStmt.executeQuery();
			if (rs.next()) {
				return new User(rs.getInt("id"), rs.getString("tipo"), rs.getString("user"), rs.getString("senha"),
						rs.getString("conf_senha"), rs.getString("nome"), rs.getString("crm"), rs.getString("telefone"),
						rs.getString("especialidade"), rs.getString("email"), rs.getString("nascimento"),
						rs.getString("cpf"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	
}
