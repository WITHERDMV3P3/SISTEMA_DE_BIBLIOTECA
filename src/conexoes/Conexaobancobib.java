package conexoes;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexaobancobib {
	private Connection con;
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://127.0.0.1:3306/biblioteca_dados";
	private String user = "root";
	private String password = "Cc01102003+";
	
	public Connection conexaobib() {
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,user,password);
			return con;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

}
