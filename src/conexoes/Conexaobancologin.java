package conexoes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Conexaobancologin {
	private Connection con;
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://127.0.0.1:3306/biblioteca_login";
	private String user = "root";
	private String password = "Cc01102003+";
	
	public Connection conexaologin() {
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,user,password);
			return con;
		} catch (Exception e) {
			System.out.println(e);
			System.out.println('a');
			return null;
		}
	}
}
