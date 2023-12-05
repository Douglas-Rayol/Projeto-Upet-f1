package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import classe.Produto;
import util.Conexao;

public class ProdutoDao {
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;

	public ProdutoDao() throws Exception {
		con = Conexao.conectar();
	}
	
	public Produto buscarUm(Integer id) throws Exception {
		if (id == null) {
			throw new Exception("Codigo vazio");
		}
		try {
			String sql = "select * from produtos where id = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if (!rs.next()) {
				throw new Exception("Consulta nao encontrou nada");
			}
			String nome = rs.getString("nome");
			String descricao = rs.getString("descricao");
			Double preco = rs.getDouble("preco");
			Produto produto = new Produto(id, nome, descricao, preco);
			return produto;
		} catch (Exception e) {
			throw new Exception(e);
		} finally {
			con.close();
		}
	}

	public List<Produto> buscarTodos() throws Exception {
		try {
			String sql = "select * from produtos";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			List<Produto> lista = new ArrayList<Produto>();
			while (rs.next()) {
				Integer id = rs.getInt("id");
				String nome = rs.getString("nome");
				String descricao = rs.getString("descricao");
				Double preco = rs.getDouble("preco");
				Produto produto = new Produto(id, nome, descricao, preco);
				lista.add(produto);
			}
			return lista;

		} catch (Exception e) {
			throw new Exception("Ocorreu um erro" + e);
		} finally {
			con.close();
		}
	}
	
	public static List<Produto> consultarNome(String nome) throws Exception{
		Connection con = Conexao.conectar();
		PreparedStatement ps;
		ResultSet rs;
		String sql = "select * from produtos where nome like ?";
		ps = con.prepareStatement(sql);
		ps.setString(1, "%" + nome + "%");
		rs = ps.executeQuery();
		List<Produto>resultado = new ArrayList<Produto>();
		while (rs.next()) {
			Produto p = new Produto();
			p.nome = rs.getString("nome");
			resultado.add(p);
		}
		return resultado;
	}
	
	public void incluir(Produto produto) throws Exception{
		if(produto == null) {
			throw new Exception("Objeto vazio");
		}
		try {
			String sql = "insert into produtos (nome, descricao, preco) values (?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, produto.getNome());
			ps.setString(2, produto.getDescricao());
			ps.setDouble(3, produto.getPreco());
			ps.executeUpdate();
		} catch (Exception e) {
			throw new Exception("Erro ao executar SQL" + e);
		} finally {
			con.close();
		}
	}
	
	public void excluir(Produto produto) throws Exception {
		if(produto == null) {
			throw new Exception("Objeto vazio");
		}
		try {
			String sql = "delete from produtos where id = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, produto.getId());
			ps.executeUpdate();
		} catch (Exception e) {
			throw new Exception("Erro ao executar SQL" + e);
		} finally {
			con.close();
		}
	}
	
	public void alterar(Produto produto) throws Exception {
		if(produto == null) {
			throw new Exception("Objeto vazio");
		}
		try {
			String sql = "Update produtos set nome = ?, descricao = ?, preco = ? where id = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, produto.getNome());
			ps.setString(2, produto.getDescricao());
			ps.setDouble(3, produto.getPreco());
			ps.setInt(4, produto.getId());
			ps.executeUpdate();
		} catch (Exception e) {
			throw new Exception("Erro ao executar SQL" + e);
		} finally {
			con.close();
		}
	}
}
