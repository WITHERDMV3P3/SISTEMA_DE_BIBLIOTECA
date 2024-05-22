package panelcliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import conexoes.Conexaobancobib;

public class Verificarusuario {
	
	private Inserircliente registro = new Inserircliente(null);
	private Conexaobancobib conexao;
	Conexaobancobib dao = new Conexaobancobib();
	private Connection con;
	
	
	
	public boolean verificador(String cpf) {
		JFrame registro = new Inserircliente(cpf);
		String sql = "Select * from usuario where cpf =  ?";
		try {con = dao.conexaobib();
		PreparedStatement verificar = con.prepareStatement(sql);
		verificar.setString(1, cpf);
		
		try (ResultSet resultado = verificar.executeQuery()){
			if (resultado.next()==true) {
				JOptionPane.showMessageDialog(null, "CPF de cliente existente, tente novamente!!","ATENÇÃO",1);
			return true;
			}else {
				return false;
			}	
		}
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return false;
		}
}
