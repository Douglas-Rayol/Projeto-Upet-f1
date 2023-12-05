package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {
	private static String servidor = "localhost";
	private static String db = "pi_upet";
	private static String usuario = "root";
	private static String senha = "";
	
	public static Connection conectar() throws Exception{
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://"+ servidor +"/"+ db, usuario, senha);
	}
}
