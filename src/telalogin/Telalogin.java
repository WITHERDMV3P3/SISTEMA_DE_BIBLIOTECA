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
import javax.swing.UIManager;
import javax.swing.border.CompoundBorder;

import conexoes.Conexaobancologin;
import telainicial.Telainicial;
import java.awt.Font;
import java.awt.Color;
import java.awt.Window.Type;
import java.awt.Frame;

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
		try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Throwable e) {
            e.printStackTrace();
        }
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Telalogin frame = new Telalogin();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public Telalogin() {
		setTitle("TELA LOGIN");
		setType(Type.UTILITY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 512, 275);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 128, 255));
		contentPane.setBorder(new CompoundBorder());
		contentPane.setLayout(null);

		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("USUÁRIO*");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(115, 65, 99, 14);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setFont(new Font("Arial", Font.PLAIN, 14));
		textField.setBounds(217, 62, 152, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblSenha = new JLabel("SENHA*");
		lblSenha.setForeground(new Color(0, 0, 0));
		lblSenha.setFont(new Font("Arial Black", Font.BOLD, 14));
		lblSenha.setHorizontalAlignment(SwingConstants.CENTER);
		lblSenha.setBounds(115, 93, 99, 14);
		contentPane.add(lblSenha);
		
		JButton btnNewButton = new JButton("ENTRAR");
		btnNewButton.setFont(new Font("Arial Black", Font.BOLD, 14));
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setOpaque(true);
		btnNewButton.setBackground(Color.green);
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
		btnNewButton.setBounds(115, 132, 115, 35);
		contentPane.add(btnNewButton);
		
		JButton btnRegistrar = new JButton("REGISTRAR");
		btnRegistrar.setFont(new Font("Arial Black", Font.BOLD, 14));
		btnRegistrar.setContentAreaFilled(false);
		btnRegistrar.setOpaque(true);
		btnRegistrar.setBackground(Color.lightGray);
		btnRegistrar.setBounds(251, 132, 136, 35);
		contentPane.add(btnRegistrar);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(217, 90, 152, 20);
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
