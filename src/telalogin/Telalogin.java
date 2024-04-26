package telalogin;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.CompoundBorder;

import conexoes.Conexaobancologin;
import telainicial.Telainicial;

public class Telalogin extends JFrame {
	
	Conexaobancologin dao = new Conexaobancologin();
	private Connection con;
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Telalogin chamar = new Telalogin();
		chamar.metodoum();
	}

	public void metodoum() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Telalogin frame = new Telalogin();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public Telalogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 244);
		contentPane = new JPanel();
		contentPane.setBorder(new CompoundBorder());
		contentPane.setLayout(null);

		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("LOGIN*");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(138, 49, 46, 14);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(187, 46, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblSenha = new JLabel("SENHA*");
		lblSenha.setHorizontalAlignment(SwingConstants.CENTER);
		lblSenha.setBounds(138, 77, 46, 14);
		contentPane.add(lblSenha);
		
		JButton btnNewButton = new JButton("ENTRAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Boolean verificar = dados(textField)||
						dados(passwordField);
			if(verificar) {
				JOptionPane.showMessageDialog(null, "CAMPO(S) VAZIO(S), PREENCHA TODOS OS CAMPOS OBRIGATÓRIO *","ATENÇÃO",2);
			}else {
				if(e.getSource() == btnNewButton) {
					entrar();}
}
	
			}
		});
		btnNewButton.setBounds(114, 128, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnRegistrar = new JButton("REGISTRAR");
		btnRegistrar.setBounds(222, 128, 99, 23);
		contentPane.add(btnRegistrar);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(187, 74, 86, 20);
		contentPane.add(passwordField);
		btnRegistrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Boolean verificar = dados(textField)||
									dados(passwordField);
						if(verificar) {
							JOptionPane.showMessageDialog(null, "CAMPO(S) VAZIO(S), PREENCHA TODOS OS CAMPOS OBRIGATÓRIO *","ATENÇÃO",2);
						}else {
				registar();
			}
		}
	});
}
	
	public void entrar() {
		String sql = "SELECT * FROM biblioteca_login WHERE usuario = ? AND senha = ?";
		try { con = dao.conexaologin();
		PreparedStatement registro = con.prepareStatement(sql);
			registro.setString(1, textField.getText().toString());
			registro.setString(2, passwordField.getText().toString());
			ResultSet resultado = registro.executeQuery();
			if(resultado.next()) {
				Telainicial chamarjanela = new Telainicial();
				chamarjanela.show();
				chamarjanela.setLocationRelativeTo(null);
				this.setVisible(false);
			}else {
				JOptionPane.showMessageDialog(null, "USUÁRIO OU SENHA INCORRETA OU NÃO REGISTRADO, TENTE NOVAMENTE","ATENÇÃO",2);
			}
			con.close();
			registro.close();
			resultado.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	private void registar() {
		
		String sql = "INSERT INTO biblioteca_login(usuario,senha) VALUES (?,?)";
		String sql2 = "SELECT * FROM biblioteca_login WHERE usuario = ?";
		
		try {con = dao.conexaologin();
			PreparedStatement consultar = con.prepareStatement(sql2);
				consultar.setString(1, textField.getText().toString());
				ResultSet resultadoconsultar = consultar.executeQuery();
				
				if(resultadoconsultar.next()) {
					
					JOptionPane.showMessageDialog(null, "USUÁRIO EXISTENTE,TENTE NOVAMENTE","ATENÇÃO",2);
					
				}else {
					
					PreparedStatement registro = con.prepareStatement(sql);
					registro.setString(1,textField.getText().toString());
					registro.setString(2, passwordField.getText().toString());
					registro.execute();
					registro.close();
					JOptionPane.showMessageDialog(null, "REGISTRADO COM SUCESSO","ATENÇÃO",1);
				
				}
				
				con.close();
				resultadoconsultar.close();
				
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	private boolean dados(JTextField testedados) {
		return testedados.getText().toString().trim().isEmpty();
	}
}
