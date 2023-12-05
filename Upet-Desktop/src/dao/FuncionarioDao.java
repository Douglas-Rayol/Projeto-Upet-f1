package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import classe.Funcionario;
import util.Conexao;

public class FuncionarioDao {
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;

	public FuncionarioDao() throws Exception {
		con = Conexao.conectar();
	}

	public Boolean validarFuncionario(Funcionario funcionario) throws Exception {
		if (funcionario == null) {
			throw new Exception("Objeto vazio");
		}
		try {
			String sql = "select * from funcionario where email = ? and senha = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, funcionario.getEmail());
			ps.setString(2, funcionario.getSenha());
			rs = ps.executeQuery();
			if (rs.next()) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			throw new Exception("e");
		} finally {
			con.close();
		}
	}
	
	public Boolean validarAdmin(Funcionario funcionario) throws Exception {
		if (funcionario == null) {
			throw new Exception("Objeto vazio");
		}
		try {
			String sql = "select * from funcionario where email = ? and tipo = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, funcionario.getEmail());
			ps.setString(2, funcionario.getTipo());
			rs = ps.executeQuery();
			if (rs.next()) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			throw new Exception("N�o funcionou o tipo"+e);
		}
	}

	public Funcionario buscarUm (Integer idfuncionario) throws Exception{
		if(idfuncionario == null) {
			throw new Exception("Codigo vazio");
		}
		try {
			String sql = "select * from funcionario where idfuncionario = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, idfuncionario);
			rs = ps.executeQuery();
			if(!rs.next()) {
				throw new Exception("Consulta n�o encontrou nada");
			};
			String nome = rs.getString("nome");
			String endereco = rs.getString("endereco");
			String telefone = rs.getString("telefone");
			String email = rs.getString("email");
			String senha = rs.getString("senha");
			String tipo = rs.getString("tipo");
			Funcionario funcionario = new Funcionario(idfuncionario, nome, endereco, telefone, email, senha, tipo);
			return funcionario;
		} catch (Exception e) {
			throw new Exception(e);
		} finally {
			con.close();
		}
	}
	
	public Funcionario validar (String login, String senha) throws Exception{
		try {
			String sql = "select * from funcionario where email = ? and senha = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, login);
			ps.setString(2, senha);
			rs = ps.executeQuery();
			if(!rs.next()) {
				throw new Exception("Consulta n�o encontrou nada");
			};
			Integer id = rs.getInt("idfuncionario");
			String nome = rs.getString("nome");
			String endereco = rs.getString("endereco");
			String telefone = rs.getString("telefone");
			String email = rs.getString("email");
			String senha2 = rs.getString("senha");
			String tipo = rs.getString("tipo");
			Funcionario funcionario = new Funcionario(id, nome, endereco, telefone, email, senha2, tipo);
			return funcionario;
		} catch (Exception e) {
			throw new Exception(e);
		} finally {
			con.close();
		}
	}
	
	public List<Funcionario> buscarTodos() throws Exception {
		try {
			String sql = "select * from Funcionario";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			List<Funcionario> lista = new ArrayList<Funcionario>();
			while (rs.next()) {
				Integer id = rs.getInt("idfuncionario");
				String nome = rs.getString("nome");
				String endereco = rs.getString("endereco");
				String telefone = rs.getString("telefone");
				String email = rs.getString("email");
				String senha = rs.getString("senha");
				String tipo = rs.getString("tipo");
				Funcionario funcionario = new Funcionario(id, nome, endereco, telefone, email, senha, tipo);
				lista.add(funcionario);
			}
			return lista;

		} catch (Exception e) {
			throw new Exception("Ocorreu um erro" + e);
		} finally {
			con.close();
		}
	}

	public void incluir(Funcionario funcionario) throws Exception{
		if(funcionario == null) {
			throw new Exception("Objeto vazio");
		}
		try {
			String sql = "insert into funcionario (nome, endereco, telefone, email, senha) values (?,?,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, funcionario.getNome());
			ps.setString(2, funcionario.getEndereco());
			ps.setString(3, funcionario.getTelefone());
			ps.setString(4, funcionario.getEmail());
			ps.setString(5, funcionario.getSenha());
			ps.executeUpdate();
		} catch (Exception e) {
			throw new Exception("Erro ao executar SQL" + e);
		} finally {
			con.close();
		}
	}
	
	public void excluir(Funcionario funcionario) throws Exception {
		if(funcionario == null) {
			throw new Exception("Objeto vazio");
		}
		try {
			String sql = "delete from funcionario where idfuncionario = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, funcionario.getIdfuncionario());
			ps.executeUpdate();
		} catch (Exception e) {
			throw new Exception("Erro ao executar SQL" + e);
		} finally {
			con.close();
		}
	}
	
	public void alterar(Funcionario funcionario) throws Exception {
		if(funcionario == null) {
			throw new Exception("Objeto vazio");
		}
		try {
			String sql = "Update funcionario set nome = ?, endereco = ?, telefone = ?, email = ?, senha = ? where idfuncionario = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, funcionario.getNome());
			ps.setString(2, funcionario.getEndereco());
			ps.setString(3, funcionario.getTelefone());
			ps.setString(4, funcionario.getEmail());
			ps.setString(5, funcionario.getSenha());
			ps.setInt(6, funcionario.getIdfuncionario());
			ps.executeUpdate();
		} catch (Exception e) {
			throw new Exception("Erro ao executar SQL" + e);
		} finally {
			con.close();
		}
	}
}
