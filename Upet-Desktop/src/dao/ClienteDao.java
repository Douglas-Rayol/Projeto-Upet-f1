package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import classe.Cliente;
import util.Conexao;

public class ClienteDao {
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public ClienteDao() throws Exception {
		con = Conexao.conectar();
	}
	
	public Cliente buscarUm (Integer idcliente) throws Exception{
		if(idcliente == null) {
			throw new Exception("Codigo vazio");
		}
		try {
			String sql = "select * from cliente where idcliente = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, idcliente);
			rs = ps.executeQuery();
			if(!rs.next()) {
				throw new Exception("Consulta nao encontrou nada");
			};
			String nome = rs.getString("nome");
			String endereco = rs.getString("endereco");
			String telefone = rs.getString("telefone");
			String senha = rs.getString("senha");
			String email = rs.getString("email");
			String cpf = rs.getString("cpf");
			String cidade = rs.getString("cidade");
			String estado = rs.getString("estado");
			String cep = rs.getString("cep");
			Cliente cliente = new Cliente(idcliente, nome, endereco, telefone, senha, email, cpf, cidade, estado, cep);
			return cliente;
		} catch (Exception e) {
			throw new Exception(e);
		} finally {
			con.close();
		}
	}
	
	public List<Cliente> buscarTodos() throws Exception {
		try {
			String sql = "select * from Cliente";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			List<Cliente> lista = new ArrayList<Cliente>();
			while (rs.next()) {
				Integer id = rs.getInt("idcliente");
				String nome = rs.getString("nome");
				String endereco = rs.getString("endereco");
				String telefone = rs.getString("telefone");
				String senha = rs.getString("senha");
				String email = rs.getString("email");
				String cpf = rs.getString("cpf");
				String cidade = rs.getString("cidade");
				String estado = rs.getString("estado");
				String cep = rs.getString("cep");
				Cliente cliente = new Cliente(id, nome, endereco, telefone, email, senha, cpf, cidade, estado, cep);
				lista.add(cliente);
			}
			return lista;

		} catch (Exception e) {
			throw new Exception("Ocorreu um erro" + e);
		} finally {
			con.close();
		}
	}

	public void incluir(Cliente cliente) throws Exception{
		if(cliente == null) {
			throw new Exception("Objeto vazio");
		}
		try {
			String sql = "insert into cliente (nome, endereco, telefone, senha, email, cpf, cidade, estado, cep) values (?,?,?,?,?,?,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, cliente.getNome());
			ps.setString(2, cliente.getEndereco());
			ps.setString(3, cliente.getTelefone());
			ps.setString(4, cliente.getSenha());
			ps.setString(5, cliente.getEmail());
			ps.setString(6, cliente.getCpf());
			ps.setString(7, cliente.getCidade());
			ps.setString(8, cliente.getEstado());
			ps.setString(9, cliente.getCep());
			ps.executeUpdate();
		} catch (Exception e) {
			throw new Exception("Erro ao executar SQL" + e);
		} finally {
			con.close();
		}
	}
	
	public void excluir(Cliente cliente) throws Exception {
		if(cliente == null) {
			throw new Exception("Objeto vazio");
		}
		try {
			String sql = "delete from cliente where idcliente = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, cliente.getIdcliente());
			ps.executeUpdate();
		} catch (Exception e) {
			throw new Exception("Erro ao executar SQL" + e);
		} finally {
			con.close();
		}
	}
	
	public void alterar(Cliente cliente) throws Exception {
		if(cliente == null) {
			throw new Exception("Objeto vazio");
		}
		try {
			String sql = "Update cliente set nome = ?, endereco = ?, telefone = ?, senha = ?, email = ?, cpf = ?, cidade = ?, estado = ?, cep = ? where idcliente = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, cliente.getNome());
			ps.setString(2, cliente.getEndereco());
			ps.setString(3, cliente.getTelefone());
			ps.setString(4, cliente.getSenha());
			ps.setString(5, cliente.getEmail());
			ps.setString(6, cliente.getCpf());
			ps.setString(7, cliente.getCidade());
			ps.setString(8, cliente.getEstado());
			ps.setString(9, cliente.getCpf());
			ps.setInt(10, cliente.getIdcliente());
			ps.executeUpdate();
		} catch (Exception e) {
			throw new Exception("Erro ao executar SQL" + e);
		} finally {
			con.close();
		}
		}
}
