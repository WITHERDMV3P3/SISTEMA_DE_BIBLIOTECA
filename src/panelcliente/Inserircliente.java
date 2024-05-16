package panelcliente;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicTabbedPaneUI.TabbedPaneLayout;
import javax.swing.table.DefaultTableModel;

import conexoes.Conexaobancobib;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import java.awt.Font;
import java.awt.Window;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import java.awt.Window.Type;
import javax.swing.JFormattedTextField;
import java.awt.event.WindowAdapter;

public class Inserircliente extends JFrame{
	
	Conexaobancobib dao = new Conexaobancobib();
	private Connection con;
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabelnome;
	private JTextField nome;
	private JLabel lblNewLabeldatanascimento;
	private JLabel lblNewLabeltelefone;
	private JLabel lblNewLabelemail;
	private JTextField email;
	private JLabel lblNewLabelcpf;
	private JLabel lblNewLabelend;
	private JTextField endereco;
	JButton btnInserirCliente;
	private JLabel lblId;
	private JTextField id;
	private static String acao;
	Cliente cliente = new Cliente(); 
	private JFormattedTextField datanascimento;
	private JFormattedTextField cpf;
	private JFormattedTextField telefone;
	

	/**
	 * Launch the application.
	 */
	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Throwable e) {
            e.printStackTrace();
        }
		EventQueue eventQueue = new EventQueue();
		eventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inserircliente frame = new Inserircliente(acao);
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Inserircliente(String acao) {
		
		setResizable(false);
		setType(Type.UTILITY);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 600, 332);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		cpf = new JFormattedTextField();
		cpf.setFont(new Font("Arial", Font.PLAIN, 14));
		cpf.setBounds(363, 71, 179, 24);
		contentPane.add(cpf);
		
		telefone = new JFormattedTextField();
		telefone.setFont(new Font("Arial", Font.PLAIN, 14));
		telefone.setBounds(363, 116, 179, 24);
		contentPane.add(telefone);
		
		datanascimento = new JFormattedTextField();
		datanascimento.setFont(new Font("Arial", Font.PLAIN, 14));
		datanascimento.setBounds(35, 116, 293, 24);
		contentPane.add(datanascimento);
		
		
		lblNewLabelnome = new JLabel("*Nome:");
		lblNewLabelnome.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblNewLabelnome.setBounds(35, 58, 293, 20);
		contentPane.add(lblNewLabelnome);
		
		nome = new JTextField();
		nome.setFont(new Font("Arial", Font.PLAIN, 14));
		nome.setBounds(35, 73, 293, 24);
		contentPane.add(nome);
		nome.setColumns(10);
		
		lblNewLabeldatanascimento = new JLabel("Data de nascimento:");
		lblNewLabeldatanascimento.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblNewLabeldatanascimento.setBounds(35, 101, 163, 20);
		contentPane.add(lblNewLabeldatanascimento);
		
		lblNewLabeltelefone = new JLabel("Telefone:");
		lblNewLabeltelefone.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblNewLabeltelefone.setBounds(363, 98, 103, 26);
		contentPane.add(lblNewLabeltelefone);
		
		lblNewLabelemail = new JLabel("Email:");
		lblNewLabelemail.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblNewLabelemail.setBounds(35, 146, 103, 20);
		contentPane.add(lblNewLabelemail);
		
		email = new JTextField();
		email.setFont(new Font("Arial", Font.PLAIN, 14));
		email.setColumns(10);
		email.setBounds(35, 163, 293, 24);
		contentPane.add(email);
		
		lblNewLabelcpf = new JLabel("*CPF:");
		lblNewLabelcpf.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblNewLabelcpf.setBounds(363, 58, 103, 17);
		contentPane.add(lblNewLabelcpf);
		
		lblNewLabelend = new JLabel("Endereço:");
		lblNewLabelend.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblNewLabelend.setBounds(35, 192, 103, 20);
		contentPane.add(lblNewLabelend);
		
		endereco = new JTextField();
		endereco.setFont(new Font("Arial", Font.PLAIN, 14));
		endereco.setColumns(10);
		endereco.setBounds(35, 209, 378, 24);
		contentPane.add(endereco);
		
		btnInserirCliente = new JButton("");
		btnInserirCliente.setHorizontalTextPosition(SwingConstants.LEADING);
		btnInserirCliente.setToolTipText("");
		btnInserirCliente.setOpaque(true);
		btnInserirCliente.setFont(new Font("Arial", Font.BOLD, 14));
		btnInserirCliente.setBackground(new Color(0, 204, 0));
		btnInserirCliente.setBounds(224, 244, 161, 38);
		contentPane.add(btnInserirCliente);
		btnInserirCliente.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(acao.equals("Inserir")) {
					boolean checar =
							naoativo(nome)||
							naoativo(cpf);
					if(checar) {
						JOptionPane.showMessageDialog(null, "Campos Não Preenchidos, Preenche-os!!!","ATENÇÃO",1);
					}else {
						metodoinserir();
					}
					
				}else if(acao.equals("Alterar")) {
						boolean checar =
								naoativo(nome)||
								naoativo(cpf);
						if(checar) {
							JOptionPane.showMessageDialog(null, "Campos Não Preenchidos, Preenche-os!!!","ATENÇÃO",1);
						}else {
							metodoalterar();
						}
				}
			}	
		});
		
		lblId = new JLabel("ID:");
		lblId.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblId.setBounds(35, 11, 103, 17);
		contentPane.add(lblId);
		
		id = new JTextField();
		id.setEnabled(false);
		id.setEditable(false);
		id.setFont(new Font("Arial", Font.PLAIN, 14));
		id.setColumns(10);
		id.setBounds(35, 26, 179, 24);
		contentPane.add(id);
	}

	private void metodoalterar() {
		String sql = "UPDATE usuario SET nome = ?, datanascimento = ?, email = ? , endereco= ?, cpf = ?, telefone = ? WHERE id = ? ";
		try { con = dao.conexaobib();
				PreparedStatement registro = con.prepareStatement(sql);{
				registro.setString(1, nome.getText().toString());
				registro.setString(2, datanascimento.getText().toString());
				registro.setString(3, email.getText().toString());
				registro.setString(4, endereco.getText().toString());
				registro.setString(5, cpf.getText().toString());
				registro.setString(6, telefone.getText().toString());
				registro.setString(7, id.getText().toString());
			registro.executeUpdate();
			con.close();
		}} catch (SQLException e) {
			System.out.println(e.getMessage());
	}
		
		JOptionPane.showMessageDialog(null, "Dados atualizados com sucesso!!!","ATENÇÃO",1);
	}
	
	

	private void metodoinserir() {
		
		String sql = "INSERT INTO usuario(nome,datanascimento, email, endereco, cpf, telefone) VALUES(?,?,?,?,?,?)"; //click do botão vai inserir dados essas sao os metodos para conexão e inserção de dados
		try {con = dao.conexaobib();
			PreparedStatement registro = con.prepareStatement(sql);
			registro.setString(1, nome.getText().toString());
			registro.setString(2, datanascimento.getText().toString());
			registro.setString(3, email.getText().toString());
			registro.setString(4, endereco.getText().toString());
			registro.setString(5, cpf.getText().toString());
			registro.setString(6, telefone.getText().toString());
			registro.execute();
			con.close();
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
	}
		JOptionPane.showMessageDialog(null, "Dados inseridos com sucesso!!!","ATENÇÃO",1);
		limparcampos();
	}
	
	

	@SuppressWarnings("static-access")
	public void inserircliente(String acao) {
		this.acao = acao;
	}
	
	public void preenchercampos(int codigo, String nomepessoa,String datadenascimento,String emailpessoal,String enderecocompleto,String cpfusuario,String telefoneusuario) {
		id.setText(String.valueOf(codigo));
		nome.setText(String.valueOf(nomepessoa));
		datanascimento.setText(String.valueOf(datadenascimento));
		email.setText(String.valueOf(emailpessoal));
		endereco.setText(String.valueOf(enderecocompleto));
		cpf.setText(String.valueOf(cpfusuario));
		telefone.setText(String.valueOf(telefoneusuario));
	}
	
	public void limparcampos() {
		nome.setText("");
		datanascimento.setText("");
		email.setText("");
		endereco.setText("");
		cpf.setText("");
		telefone.setText("");
	}
	
	private boolean naoativo(JTextField testedados) {
		return testedados.getText().toString().trim().isEmpty();
	}
}
	
	

