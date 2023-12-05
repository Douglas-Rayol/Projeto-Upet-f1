package classe;

public class Cliente {
	private Integer idcliente;
	private String nome;
	private String endereco;
	private String telefone;
	private String senha;
	private String email;
	private String cpf;
	private String cidade;
	private String estado;
	private String cep;
	
	public Cliente() {
		
	}

	public Cliente(Integer idcliente, String nome, String endereco, String telefone, String senha, String email,
			String cpf, String cidade, String estado, String cep) {
		this.idcliente = idcliente;
		this.nome = nome;
		this.endereco = endereco;
		this.telefone = telefone;
		this.senha = senha;
		this.email = email;
		this.cpf = cpf;
		this.cidade = cidade;
		this.estado = estado;
		this.cep = cep;
	}

	public Integer getIdcliente() {
		return idcliente;
	}

	public void setIdcliente(Integer idcliente) {
		this.idcliente = idcliente;
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

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	@Override
	public String toString() {
		return "Cliente [idcliente=" + idcliente + ", nome=" + nome + ", endereco=" + endereco + ", telefone="
				+ telefone + ", senha=" + senha + ", email=" + email + ", cpf=" + cpf + ", cidade=" + cidade
				+ ", estado=" + estado + ", cep=" + cep + "]";
	}
	
	

}
