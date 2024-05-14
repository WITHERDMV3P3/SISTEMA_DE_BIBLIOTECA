package panelcliente;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import conexoes.Conexaobancobib;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Inserircliente extends JFrame{
	
	Conexaobancobib dao = new Conexaobancobib();
	private Connection con;
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabelnome;
	private JTextField nome;
	private JLabel lblNewLabeldatanascimento;
	private JTextField datanascimento;
	private JLabel lblNewLabeltelefone;
	private JTextField telefone;
	private JLabel lblNewLabelemail;
	private JTextField email;
	private JLabel lblNewLabelcpf;
	private JTextField cpf;
	private JLabel lblNewLabelend;
	private JTextField endereco;
	JButton btnInserirCliente;
	private JLabel lblId;
	private JTextField id;
	private static String acao;
	

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
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 600, 332);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabelnome = new JLabel("*Nome:");
		lblNewLabelnome.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblNewLabelnome.setBounds(35, 58, 293, 20);
		contentPane.add(lblNewLabelnome);
		
		nome = new JTextField();
		nome.setFont(new Font("Calibri", Font.PLAIN, 14));
		nome.setBounds(35, 73, 293, 24);
		contentPane.add(nome);
		nome.setColumns(10);
		
		lblNewLabeldatanascimento = new JLabel("Data de nascimento:");
		lblNewLabeldatanascimento.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblNewLabeldatanascimento.setBounds(35, 101, 163, 20);
		contentPane.add(lblNewLabeldatanascimento);
		
		datanascimento = new JTextField();
		datanascimento.setFont(new Font("Calibri", Font.PLAIN, 14));
		datanascimento.setColumns(10);
		datanascimento.setBounds(35, 117, 293, 24);
		contentPane.add(datanascimento);
		
		lblNewLabeltelefone = new JLabel("Telefone:");
		lblNewLabeltelefone.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblNewLabeltelefone.setBounds(363, 98, 103, 26);
		contentPane.add(lblNewLabeltelefone);
		
		telefone = new JTextField();
		telefone.setFont(new Font("Calibri", Font.PLAIN, 14));
		telefone.setColumns(10);
		telefone.setBounds(363, 119, 179, 22);
		contentPane.add(telefone);
		
		lblNewLabelemail = new JLabel("Email:");
		lblNewLabelemail.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblNewLabelemail.setBounds(35, 146, 103, 20);
		contentPane.add(lblNewLabelemail);
		
		email = new JTextField();
		email.setFont(new Font("Calibri", Font.PLAIN, 14));
		email.setColumns(10);
		email.setBounds(35, 163, 293, 24);
		contentPane.add(email);
		
		lblNewLabelcpf = new JLabel("*CPF:");
		lblNewLabelcpf.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblNewLabelcpf.setBounds(363, 58, 103, 17);
		contentPane.add(lblNewLabelcpf);
		
		cpf = new JTextField();
		cpf.setFont(new Font("Calibri", Font.PLAIN, 14));
		cpf.setColumns(10);
		cpf.setBounds(363, 73, 179, 24);
		contentPane.add(cpf);
		
		lblNewLabelend = new JLabel("Endereço:");
		lblNewLabelend.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblNewLabelend.setBounds(35, 192, 103, 20);
		contentPane.add(lblNewLabelend);
		
		endereco = new JTextField();
		endereco.setFont(new Font("Calibri", Font.PLAIN, 14));
		endereco.setColumns(10);
		endereco.setBounds(35, 209, 378, 24);
		contentPane.add(endereco);
		
		btnInserirCliente = new JButton("");
		btnInserirCliente.setHorizontalTextPosition(SwingConstants.LEADING);
		btnInserirCliente.setToolTipText("");
		btnInserirCliente.setOpaque(true);
		btnInserirCliente.setFont(new Font("Arial", Font.BOLD, 14));
		btnInserirCliente.setBackground(new Color(0, 204, 0));
		btnInserirCliente.setBounds(223, 244, 161, 38);
		contentPane.add(btnInserirCliente);
		btnInserirCliente.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(acao.equals("Inserir")) {
					metodoinserir();
				}else if(acao.equals("Alterar")) {
					metodoalterar();
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
		id.setFont(new Font("Calibri", Font.PLAIN, 14));
		id.setColumns(10);
		id.setBounds(35, 26, 179, 24);
		contentPane.add(id);
	}

	private void metodoalterar() {
		
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
	
}
	
	

