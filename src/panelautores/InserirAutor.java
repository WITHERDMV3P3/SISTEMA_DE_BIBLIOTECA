package panelautores;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicTabbedPaneUI.TabbedPaneLayout;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

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
import java.text.ParseException;

import javax.swing.ImageIcon;
import java.awt.Window.Type;
import javax.swing.JFormattedTextField;
import java.awt.event.WindowAdapter;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class InserirAutor extends JFrame{
	
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
	private JLabel lblNewLabelend;
	private JTextField endereco;
	JButton btnInserirAutor;
	private JLabel lblId;
	private JTextField id;
	private static String acaoAutor;
	Autores cliente = new Autores(); 
	private JFormattedTextField datanascimento;
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
					InserirAutor frame = new InserirAutor(acaoAutor);
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
	public InserirAutor(String acao) {
		
		setResizable(false);
		setType(Type.UTILITY);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 600, 305);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
	
	
	MaskFormatter dataform = null; // TODO ele coloca o formattedtextfield como campo para colocar datas 
	try {
		dataform = new MaskFormatter("##/##/####");
	} catch (ParseException e) {
		System.out.println("Erro ao criar a máscara");
	}
	
	MaskFormatter telefoneform = null; //TODO formato de telefone
	try {
		telefoneform = new MaskFormatter("(##) 9 ####-####");
	} catch (ParseException e) {
		System.out.println("Erro ao criar a máscara");
	}
		
		telefone = new JFormattedTextField(telefoneform);
		telefone.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					btnInserirAutor.requestFocus();
					}else if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {
						datanascimento.requestFocus();
					}
			}
		});
		telefone.setFont(new Font("Arial", Font.PLAIN, 14));
		telefone.setBounds(357, 126, 179, 24);
		contentPane.add(telefone);
		
		
		lblNewLabelnome = new JLabel("*Nome:");
		lblNewLabelnome.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblNewLabelnome.setBounds(35, 58, 293, 20);
		contentPane.add(lblNewLabelnome);
		
		nome = new JTextField();
		nome.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					email.requestFocus();
					}
			}
		});
		nome.setFont(new Font("Arial", Font.PLAIN, 14));
		nome.setBounds(35, 73, 293, 24);
		contentPane.add(nome);
		nome.setColumns(10);
		
		lblNewLabeldatanascimento = new JLabel("Data de nascimento:");
		lblNewLabeldatanascimento.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblNewLabeldatanascimento.setBounds(357, 58, 163, 20);
		contentPane.add(lblNewLabeldatanascimento);
		
		datanascimento = new JFormattedTextField(dataform);
		datanascimento.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					telefone.requestFocus();
					}else if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {
						endereco.requestFocus();
					}
			}
		});
		datanascimento.setFont(new Font("Arial", Font.PLAIN, 14));
		datanascimento.setBounds(357, 73, 136, 24);
		contentPane.add(datanascimento);
		
		lblNewLabeltelefone = new JLabel("Telefone:");
		lblNewLabeltelefone.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblNewLabeltelefone.setBounds(357, 108, 103, 26);
		contentPane.add(lblNewLabeltelefone);
		
		lblNewLabelemail = new JLabel("Email:");
		lblNewLabelemail.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblNewLabelemail.setBounds(35, 108, 103, 20);
		contentPane.add(lblNewLabelemail);
		
		email = new JTextField();
		email.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					endereco.requestFocus();
					}else if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {
						nome.requestFocus();
					}
			}
		});
		email.setFont(new Font("Arial", Font.PLAIN, 14));
		email.setColumns(10);
		email.setBounds(35, 125, 293, 24);
		contentPane.add(email);
		
		lblNewLabelend = new JLabel("Endereço:");
		lblNewLabelend.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblNewLabelend.setBounds(35, 161, 103, 20);
		contentPane.add(lblNewLabelend);
		
		endereco = new JTextField();
		endereco.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					datanascimento.requestFocus();
					}else if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {
						email.requestFocus();
					}
			}
		});
		endereco.setFont(new Font("Arial", Font.PLAIN, 14));
		endereco.setColumns(10);
		endereco.setBounds(35, 178, 293, 24);
		contentPane.add(endereco);
		
		btnInserirAutor = new JButton("");
		btnInserirAutor.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {
					telefone.requestFocus();
				}
			}
		});
		btnInserirAutor.setHorizontalTextPosition(SwingConstants.LEADING);
		btnInserirAutor.setToolTipText("");
		btnInserirAutor.setOpaque(true);
		btnInserirAutor.setFont(new Font("Arial", Font.BOLD, 14));
		btnInserirAutor.setBackground(new Color(0, 204, 0));
		btnInserirAutor.setBounds(222, 213, 161, 38);
		contentPane.add(btnInserirAutor);
		btnInserirAutor.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(acao.equals("Inserir")) {
					boolean checar =
							naoativo(nome);
					if(checar) {
						JOptionPane.showMessageDialog(null, "Campos Não Preenchidos, Preenche-os!!!","ATENÇÃO",1);
					}else {
						metodoinserir();
					}
					
				}else if(acao.equals("Alterar")) {
						boolean checar =
								naoativo(nome);
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
		String sql = "UPDATE autor SET nome_autor = ?, datanascimento = ?, email = ? , endereco= ?, telefone = ? WHERE id = ? ";
		try { con = dao.conexaobib();
				PreparedStatement registro = con.prepareStatement(sql);{
				registro.setString(1, nome.getText().toString());
				registro.setString(2, datanascimento.getText().toString());
				registro.setString(3, email.getText().toString());
				registro.setString(4, endereco.getText().toString());
				registro.setString(5, telefone.getText().toString());
				registro.setString(6, id.getText().toString());
			registro.executeUpdate();
			con.close();
		}} catch (SQLException e) {
			System.out.println(e.getMessage());
	}
		
		JOptionPane.showMessageDialog(null, "Dados atualizados com sucesso!!!","ATENÇÃO",1);
	}
	
	

	private void metodoinserir() {
		
		String sql = "INSERT INTO autor(nome_autor,datanascimento, email, endereco, telefone) VALUES(?,?,?,?,?)"; //click do botão vai inserir dados essas sao os metodos para conexão e inserção de dados
		try {con = dao.conexaobib();
			PreparedStatement registro = con.prepareStatement(sql);
			registro.setString(1, nome.getText().toString());
			registro.setString(2, datanascimento.getText().toString());
			registro.setString(3, email.getText().toString());
			registro.setString(4, endereco.getText().toString());
			registro.setString(5, telefone.getText().toString());
			registro.execute();
			con.close();
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
	}
		JOptionPane.showMessageDialog(null, "Dados inseridos com sucesso!!!","ATENÇÃO",1);
		limparcampos();
	}
	
	

	@SuppressWarnings("static-access")
	public void inserircliente(String acaoAutor) {
		this.acaoAutor = acaoAutor;
	}
	
	public void limparcampos() {
		nome.setText("");
		datanascimento.setText("");
		email.setText("");
		endereco.setText("");
		telefone.setText("");
	}
	
	public void preenchercampos(int codigo, String nomepessoa, String datadenascimento, String emailpessoal, String enderecocompleto, String telefoneusuario) {
		id.setText(String.valueOf(codigo));
		nome.setText(String.valueOf(nomepessoa));
		datanascimento.setText(String.valueOf(datadenascimento));
		email.setText(String.valueOf(emailpessoal));
		endereco.setText(String.valueOf(enderecocompleto));
		telefone.setText(String.valueOf(telefoneusuario));
		
	}
	
	private boolean naoativo(JTextField testedados) {
		return testedados.getText().toString().trim().isEmpty();
	}


}
	
	

