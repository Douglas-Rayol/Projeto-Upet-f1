package classe;

public class Funcionario {
	private Integer idfuncionario;
	public String nome;
	public String endereco;
	public String telefone; 
	public String email;
	public String senha;
	public String tipo;
	
	
	public Funcionario() {
		
	}


	public Funcionario(Integer idfuncionario, String nome, String endereco, String telefone, String email,
			String senha, String tipo) {
		super();
		this.idfuncionario = idfuncionario;
		this.nome = nome;
		this.endereco = endereco;
		this.telefone = telefone;
		this.email = email;
		this.senha = senha;
		this.tipo = tipo;
	}


	public Integer getIdfuncionario() {
		return idfuncionario;
	}


	public void setIdfuncionario(Integer idfuncionario) {
		this.idfuncionario = idfuncionario;
	}
	
	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getEndereco() {
		return endereco;
	}


	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}


	public String getTelefone() {
		return telefone;
	}


	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getSenha() {
		return senha;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}


	@Override
	public String toString() {
		return "Funcionario [idfuncionario=" + idfuncionario + ", nome=" + nome + ", endereco=" + endereco
				+ ", telefone=" + telefone + ", email=" + email + ", senha=" + senha + "]";
	}


	
}
