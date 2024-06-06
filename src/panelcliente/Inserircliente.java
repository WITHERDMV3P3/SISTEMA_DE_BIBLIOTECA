package panelcliente;

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
	JFormattedTextField cpf;
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
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
						nome.requestFocus();
					}
			}
		});
		
		setResizable(false);
		setType(Type.UTILITY);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 600, 306);
		contentPane = new JPanel();
		contentPane.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					nome.requestFocus();
				}
			}
		});
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
				MaskFormatter cpfform = null;
		try {
			cpfform = new MaskFormatter("###.###.###-##");
		} catch (ParseException e) {
			System.out.println("Erro ao criar a máscara");
		}
		
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
		
		
		cpf = new JFormattedTextField(cpfform);
		cpf.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					telefone.requestFocus();
					}else if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {
						datanascimento.requestFocus();
					}
			}
		});
		cpf.setFont(new Font("Arial", Font.PLAIN, 14));
		cpf.setBounds(361, 123, 179, 24);
		contentPane.add(cpf);
		
		telefone = new JFormattedTextField(telefoneform);
		telefone.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					btnInserirCliente.requestFocus();
					}else if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {
						cpf.requestFocus();
					}
			}
		});
		telefone.setFont(new Font("Arial", Font.PLAIN, 14));
		telefone.setBounds(361, 168, 179, 24);
		contentPane.add(telefone);
		
		
		datanascimento = new JFormattedTextField(dataform);
		datanascimento.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					cpf.requestFocus();
					}else if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {
						endereco.requestFocus();
					}
			}
		});
		datanascimento.setFont(new Font("Arial", Font.PLAIN, 14));
		datanascimento.setBounds(361, 78, 136, 24);
		contentPane.add(datanascimento);
		
		
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
		lblNewLabeldatanascimento.setBounds(361, 63, 163, 20);
		contentPane.add(lblNewLabeldatanascimento);
		
		lblNewLabeltelefone = new JLabel("Telefone:");
		lblNewLabeltelefone.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblNewLabeltelefone.setBounds(361, 150, 103, 26);
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
		
		lblNewLabelcpf = new JLabel("*CPF:");
		lblNewLabelcpf.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblNewLabelcpf.setBounds(361, 110, 103, 17);
		contentPane.add(lblNewLabelcpf);
		
		lblNewLabelend = new JLabel("Endereço:");
		lblNewLabelend.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblNewLabelend.setBounds(35, 151, 103, 20);
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
		endereco.setBounds(35, 168, 293, 24);
		contentPane.add(endereco);
		
		btnInserirCliente = new JButton("");
		btnInserirCliente.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {
					telefone.requestFocus();
				}
			}
		});
		btnInserirCliente.setHorizontalTextPosition(SwingConstants.LEADING);
		btnInserirCliente.setToolTipText("");
		btnInserirCliente.setOpaque(true);
		btnInserirCliente.setFont(new Font("Arial", Font.BOLD, 14));
		btnInserirCliente.setBackground(new Color(0, 204, 0));
		btnInserirCliente.setBounds(225, 221, 161, 38);
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
					}else if(verificarnomeusuario()==true) {
						
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
		id.setBounds(35, 26, 75, 24);
		contentPane.add(id);
	}

	private void metodoalterar() {
		String sql = "UPDATE usuario SET nome = ?, datanascimento = ?, email = ? , endereco= ?, telefone = ? WHERE id = ? ";
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
	
	public boolean verificarnomeusuario() {
		Verificarusuario veri = new Verificarusuario();
		String nomeusuario = cpf.getText().toString();
		return veri.verificador(nomeusuario);
	}
}
	
	

