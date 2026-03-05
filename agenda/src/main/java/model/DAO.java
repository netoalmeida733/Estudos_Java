package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DAO {

	private String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private String url = "jdbc:sqlserver://192.168.14.101:1433;databaseName=dbagendas;encrypt=false";
	private String user = "sa";
	private String password = "010978";

	public Connection conectar() {
		try {
			Class.forName(driver);
			return DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public void inserirContato(JavaBeans contato) {
		String sql = "INSERT INTO contatos (nome, fone, email) VALUES (?, ?, ?)";

		try (Connection con = conectar(); PreparedStatement pst = con.prepareStatement(sql)) {

			pst.setString(1, contato.getNome());
			pst.setString(2, contato.getFone());
			pst.setString(3, contato.getEmail());

			pst.executeUpdate();

			System.out.println("Contato inserido com sucesso!");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/** CRUD - READ **/
	public ArrayList<JavaBeans> listarContatos() {

		ArrayList<JavaBeans> contatos = new ArrayList<>();
		String sql = "SELECT * FROM contatos ORDER BY nome";

		try (Connection con = conectar();
				PreparedStatement pst = con.prepareStatement(sql);
				ResultSet rs = pst.executeQuery()) {

			// enquanto houver registros no banco
			while (rs.next()) {

				// dados vindos do banco
				String idcon = rs.getString("idcon");
				String nome = rs.getString("nome");
				String fone = rs.getString("fone");
				String email = rs.getString("email");

				// adiciona no ArrayList
				contatos.add(new JavaBeans(idcon, nome, fone, email));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return contatos;
	}

	/** CRUD CONTATOS **/
	// Selecionar o contato
	public void selecionarContato(JavaBeans contato) {
		String read2 = "select *from contatos where idcon = ?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read2);
			pst.setString(1, contato.getIdcon());
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {

				// setar as variaveis JavaBeans

				contato.setIdcon(rs.getString(1));
				contato.setNome(rs.getString(2));
				contato.setFone(rs.getString(3));
				contato.setEmail(rs.getString(4));
			}
			con.close();

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	// editar o contato
	public void alterarContato(JavaBeans contato) {
		String create = "update contatos set nome = ?, fone= ? ,email= ? where idcon = ?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(create);
			pst.setString(1, contato.getNome());
			pst.setString(2, contato.getFone());
			pst.setString(3, contato.getEmail());
			pst.setString(4, contato.getIdcon());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// CRUD DELETE
	public void deletarContato(JavaBeans contato) {
		String delete = "delete from contatos  where idcon= ?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(delete);
			pst.setString(1, contato.getIdcon());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}