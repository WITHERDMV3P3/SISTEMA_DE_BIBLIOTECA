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

import conexoes.Conexaobancobib;
import telainicial.Telainicial;
import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Window.Type;
import java.awt.Frame;
import java.awt.Image;

import javax.swing.JEditorPane;
import javax.swing.ImageIcon;

public class Telalogin extends JFrame {
	
	Conexaobancobib dao = new Conexaobancobib();
	private Connection con;
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JPanel panel;
	private JLabel imagem;
	private JLabel label;
	private JPasswordField passwordField;
	private JButton btnSair;

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
		setUndecorated(true);
		setTitle("TELA LOGIN");
		setType(Type.UTILITY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 505, 467);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 128, 255));
		contentPane.setBorder(new CompoundBorder());
		contentPane.setLayout(null);

		setContentPane(contentPane);
		
		panel = new JPanel();
		panel.setBounds(60, 59, 381, 353);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnRegistrar = new JButton("REGISTRAR");
		btnRegistrar.setIcon(new ImageIcon(Telalogin.class.getResource("/Imagens/pngegg.png")));
		btnRegistrar.setBounds(186, 239, 155, 35);
		panel.add(btnRegistrar);
		btnRegistrar.setFont(new Font("Arial Black", Font.BOLD, 14));
	//	btnRegistrar.setContentAreaFilled(false);
		btnRegistrar.setOpaque(true);
		btnRegistrar.setBackground(Color.lightGray);
		
		JButton btnNewButton = new JButton("ENTRAR");
		btnNewButton.setIcon(new ImageIcon(Telalogin.class.getResource("/Imagens/entrar (1).png")));
		btnNewButton.setBounds(36, 239, 129, 35);
		panel.add(btnNewButton);
		btnNewButton.setFont(new Font("Arial Black", Font.BOLD, 14));
		//btnNewButton.setContentAreaFilled(false);
		btnNewButton.setOpaque(true);
		btnNewButton.setBackground(Color.green);
		
		btnSair = new JButton("SAIR");
		btnSair.setIcon(new ImageIcon(Telalogin.class.getResource("/Imagens/sair.png")));
		btnSair.setFont(new Font("Arial Black", Font.BOLD, 14));
	//	btnSair.setContentAreaFilled(false);
		btnSair.setOpaque(true);
		btnSair.setBackground(Color.RED);
		btnSair.setBounds(123, 288, 115, 35);
		btnSair.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				sair();
				
			}
		});
		panel.add(btnSair);
		
		JLabel lblSenha = new JLabel("SENHA*");
		lblSenha.setHorizontalTextPosition(SwingConstants.CENTER);
		lblSenha.setBounds(10, 161, 361, 14);
		panel.add(lblSenha);
		lblSenha.setForeground(new Color(0, 0, 0));
		lblSenha.setFont(new Font("Arial Black", Font.BOLD, 14));
		lblSenha.setHorizontalAlignment(SwingConstants.CENTER);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setBounds(109, 123, 163, 27);
		panel.add(textField);
		textField.setFont(new Font("Arial", Font.PLAIN, 14));
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("USUÁRIO*");
		lblNewLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 105, 361, 14);
		panel.add(lblNewLabel);
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		label = new JLabel("");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setIcon(new ImageIcon(Telalogin.class.getResource("/Imagens/biblioteca (1).png")));
		label.setBounds(10, 45, 361, 49);
		panel.add(label);
		
		passwordField = new JPasswordField();
		passwordField.setHorizontalAlignment(SwingConstants.CENTER);
		passwordField.setBounds(109, 180, 163, 27);
		panel.add(passwordField);
		
		
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Boolean verificar = dados(textField)||
						dados(passwordField);
			if(verificar) {
				JOptionPane.showMessageDialog(null, "Campo(s) vazio(s), preencha todos os campos obrigatório *","ATENÇÃO",2);
			}else {
				if(e.getSource() == btnNewButton) {
					entrar();}
}
	
			}
		});
		btnRegistrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Boolean verificar = dados(textField)||
									dados(passwordField);
						if(verificar) {
							JOptionPane.showMessageDialog(null, "Campo(s) vazio(s), preencha todos os campos obrigatório *","ATENÇÃO",2);
						}else {
				registar();
			}
		}
	});
}
	
	private void sair() {
		System.exit(0);			
	}

	public void entrar() {
		String sql = "SELECT * FROM biblioteca_dados WHERE usuario = ? AND senha = ?";
		try { con = dao.conexaobib();
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
				JOptionPane.showMessageDialog(null, "Usuário ou senha incorreta ou não registrado, tente novamente","ATENÇÃO",2);
			}
			con.close();
			registro.close();
			resultado.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	private void registar() {
		
		String sql = "INSERT INTO biblioteca_dados(usuario,senha) VALUES (?,?)";
		String sql2 = "SELECT * FROM biblioteca_dados WHERE usuario = ?";
		
		try {con = dao.conexaobib();
			PreparedStatement consultar = con.prepareStatement(sql2);
				consultar.setString(1, textField.getText().toString());
				ResultSet resultadoconsultar = consultar.executeQuery();
				
				if(resultadoconsultar.next()) {
					
					JOptionPane.showMessageDialog(null, "Usuário existente, tente novamente","ATENÇÃO",2);
					
				}else {
					
					PreparedStatement registro = con.prepareStatement(sql);
					registro.setString(1,textField.getText().toString());
					registro.setString(2, passwordField.getText().toString());
					registro.execute();
					registro.close();
					JOptionPane.showMessageDialog(null, "Registrado com sucesso","ATENÇÃO",1);
				
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
