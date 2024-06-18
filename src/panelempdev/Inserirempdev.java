package panelempdev;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

import conexoes.Conexaobancobib;
import panelcliente.Cliente;

public class Inserirempdev extends JFrame{
	
	Conexaobancobib dao = new Conexaobancobib();
	private Connection con;
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabelnome;
	JTextField FieldsAutor;
	private JLabel lblDataentrega;
	private JLabel lblCliente;
	JButton btnInserirEmprestimo;
	private JLabel lblId;
	private JTextField id;
	private static String acao;
	JComboBox<String> comboBoxCliente;
	JComboBox <String> comboBoxlivro;
	JFormattedTextField Dataemprestimo;
	private JFormattedTextField Dataprevisao;
	JFormattedTextField Datadevolucao;
    private SimpleDateFormat formatodata;
	
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
					Inserirempdev frame = new Inserirempdev(acao);
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
	public Inserirempdev(String acao) {
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
						FieldsAutor.requestFocus();
					}
			}
		});
		
		setResizable(false);
		setType(Type.UTILITY);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 600, 307);
		contentPane = new JPanel();
		contentPane.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					FieldsAutor.requestFocus();
				}
			}
		});
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		formatodata = new SimpleDateFormat("dd/MM/yyyy");
		MaskFormatter dataformato = null; // TODO ele coloca o formattedtextfield como campo para colocar datas 
		try {
			dataformato = new MaskFormatter("##/##/####");
		} catch (ParseException e) {
			System.out.println("Erro ao criar a máscara");
		}
		
		
		JLabel lblDataprevisao = new JLabel("Previsão de devolução:");
		lblDataprevisao.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblDataprevisao.setBounds(361, 108, 163, 20);
		contentPane.add(lblDataprevisao);
		
		Dataprevisao = new JFormattedTextField(dataformato);
		Dataprevisao.setEnabled(false);
		Dataprevisao.setEditable(false);
		Dataprevisao.setFont(new Font("Arial", Font.PLAIN, 14));
		Dataprevisao.setBounds(361, 123, 136, 24);
		contentPane.add(Dataprevisao);
		
		Dataemprestimo = new JFormattedTextField(dataformato);
		Dataemprestimo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					btnInserirEmprestimo.requestFocus();
					}else if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {
						comboBoxlivro.requestFocus();
					}
			}
		});
		Dataemprestimo.setFont(new Font("Arial", Font.PLAIN, 14));
		Dataemprestimo.setBounds(361, 73, 136, 24);
		contentPane.add(Dataemprestimo);
		Dataemprestimo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				calculodata();
			}
		});
		Dataemprestimo.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				calculodata();
				
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				calculodata();
				
			}
		});
		
		
		lblNewLabelnome = new JLabel("Autor Livro:");
		lblNewLabelnome.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblNewLabelnome.setBounds(35, 58, 293, 20);
		contentPane.add(lblNewLabelnome);
		
		FieldsAutor = new JTextField();
		FieldsAutor.setEnabled(false);
		FieldsAutor.setEditable(false);
		FieldsAutor.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					comboBoxlivro.requestFocus();
					}
				}
				
		});
		FieldsAutor.setFont(new Font("Arial", Font.PLAIN, 14));
		FieldsAutor.setBounds(35, 73, 293, 24);
		contentPane.add(FieldsAutor);
		FieldsAutor.setColumns(10);
		
		lblDataentrega = new JLabel("*Data do empréstimo:");
		lblDataentrega.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblDataentrega.setBounds(361, 58, 163, 20);
		contentPane.add(lblDataentrega);
		
		lblCliente = new JLabel("*Cliente:");
		lblCliente.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblCliente.setBounds(35, 108, 103, 20);
		contentPane.add(lblCliente);
		
		
		
		comboBoxCliente = new JComboBox();
		comboBoxCliente.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					comboBoxlivro.requestFocus();
				}
			}
		});
		comboBoxCliente.setEditable(true);
		comboBoxCliente.setBounds(35, 124, 293, 22);
		contentPane.add(comboBoxCliente);

		preencherComboBoxCliente(comboBoxCliente);
		AutoCompleteDecorator.decorate(comboBoxCliente);
		
		
		
		btnInserirEmprestimo = new JButton("");
		btnInserirEmprestimo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {
					comboBoxCliente.requestFocus();
				}
			}
		});
		btnInserirEmprestimo.setHorizontalTextPosition(SwingConstants.LEADING);
		btnInserirEmprestimo.setToolTipText("");
		btnInserirEmprestimo.setOpaque(true);
		btnInserirEmprestimo.setFont(new Font("Arial", Font.BOLD, 14));
		btnInserirEmprestimo.setBackground(new Color(0, 204, 0));
		btnInserirEmprestimo.setBounds(208, 219, 207, 38);
		contentPane.add(btnInserirEmprestimo);
		btnInserirEmprestimo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(acao.equals("Inserir emprestimo")) {
					boolean checar =
							naoativo(Dataemprestimo);
					if(checar) {
						JOptionPane.showMessageDialog(null, "Campos Não Preenchidos, Preenche-os!!!","ATENÇÃO",1);
					}else {
						metodoinseriremprestimo();
					}
					
				}else if(acao.equals("Alterar")) {
						boolean checar =
								naoativo(Dataprevisao)||
								naoativo(Dataemprestimo);
						if(checar) {
							JOptionPane.showMessageDialog(null, "Campos Não Preenchidos, Preenche-os!!!","ATENÇÃO",1);
						}else {
							metodoalterar();
						}
				}else if(acao.equals("Inserir devolucao")) {
					boolean checar =
							naoativo(Datadevolucao);
					if(checar) {
						JOptionPane.showMessageDialog(null, "Campos Não Preenchidos, Preenche-os!!!","ATENÇÃO",1);
					}else {
						metodoinserirdevolucao();
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
		
		JLabel lblLivro = new JLabel("*Livro:");
		lblLivro.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblLivro.setBounds(35, 154, 103, 20);
		contentPane.add(lblLivro);
		
		Datadevolucao = new JFormattedTextField(dataformato);
		Datadevolucao.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					btnInserirEmprestimo.requestFocus();
					}else if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {
						Dataemprestimo.requestFocus();
					}
			}
		});
		Datadevolucao.setFont(new Font("Arial", Font.PLAIN, 14));
		Datadevolucao.setBounds(361, 170, 136, 24);
		contentPane.add(Datadevolucao);
		
		JLabel lblDataDeEntrega = new JLabel("*Data de devolução:");
		lblDataDeEntrega.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblDataDeEntrega.setBounds(361, 155, 163, 20);
		contentPane.add(lblDataDeEntrega);
		
		comboBoxlivro = new JComboBox();
		comboBoxlivro.setEditable(true);
		comboBoxlivro.setBounds(35, 172, 293, 22);
		contentPane.add(comboBoxlivro);
		comboBoxlivro.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					Dataemprestimo.requestFocus();
					}else if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {
						comboBoxCliente.requestFocus();
					}
			}
		});		
		comboBoxlivro.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String livroselecionado = (String) comboBoxlivro.getSelectedItem();
				if(livroselecionado != null) {
				autor(livroselecionado);
				}
				
			}
		});
		
		
				preencherComboboxLivro(comboBoxlivro);
				AutoCompleteDecorator.decorate(comboBoxlivro);				
			
		
	}
	
	 private void calculodata() {
		 String dataemprestimoString = Dataemprestimo.getText();
		 if(dataemprestimoString != null && dataemprestimoString.trim().length() == 10) {		 
		try {
			java.util.Date dataemprestimo = formatodata.parse(dataemprestimoString);
		    long millis = dataemprestimo.getTime() + 30L * 24 * 60 * 60 * 1000;
		    Date datadevolucao = new Date(millis);
		    Dataprevisao.setValue(formatodata.format(datadevolucao));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
	}
		 }

	private void preencherComboboxLivro(JComboBox<String> comboBoxlivro) {
	        String sql = "SELECT titulo FROM livro";
	        try {
	            Connection con = dao.conexaobib();
	            PreparedStatement stmt = con.prepareStatement(sql);
	            ResultSet rs = stmt.executeQuery();
	            List<String> autores = new ArrayList<>();
	            autores.add("--Selecione Livro--");
	            while (rs.next()) {
	                autores.add(rs.getString("titulo"));
	            }
	            comboBoxlivro.setModel(new DefaultComboBoxModel<>(autores.toArray(new String[1])));
	            con.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	            JOptionPane.showMessageDialog(this, "Erro ao carregar livros", "Erro", JOptionPane.ERROR_MESSAGE);
	        }
	    }
	 
	 private void preencherComboBoxCliente(JComboBox<String> comboBoxCliente) {
	        String sql = "SELECT nome FROM usuario";
	        try {
	            Connection con = dao.conexaobib();
	            PreparedStatement stmt = con.prepareStatement(sql);
	            ResultSet rs = stmt.executeQuery();
	            List<String> cliente = new ArrayList<>();
	            cliente.add("--Selecione Cliente--");
	            while (rs.next()) {
	                cliente.add(rs.getString("nome"));
	            }
	            comboBoxCliente.setModel(new DefaultComboBoxModel<>(cliente.toArray(new String[1])));
	            con.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	            JOptionPane.showMessageDialog(this, "Erro ao carregar nome dos usuarios", "Erro", JOptionPane.ERROR_MESSAGE);
	        }
	    }
	 

	private void metodoalterar() {
		String dadolivro = (String) comboBoxlivro.getSelectedItem();
		String dadocliente = (String) comboBoxCliente.getSelectedItem();
		
		String sql = "UPDATE empedev SET usuario = ?, livro = ?, dataemprestimo = ? , datadevolucao= ?, dataprevisao = ? WHERE id = ? "; 
		try { con = dao.conexaobib();
				PreparedStatement registro = con.prepareStatement(sql);{
				registro.setString(1, dadocliente);
				registro.setString(2, dadolivro);
				registro.setString(3, Dataemprestimo.getText().toString()); // TODO tenho que colocar pra alterar pra ele alterar tbm a previsão
				registro.setString(4, Datadevolucao.getText().toString());
				registro.setString(5, Dataprevisao.getText().toString());				
				registro.setString(6, id.getText().toString());
			registro.executeUpdate();
			con.close();
		}} catch (SQLException e) {
			System.out.println(e.getMessage());
	}
		
		JOptionPane.showMessageDialog(null, "Dados atualizados com sucesso!!!","ATENÇÃO",1);
	}
	
	

	private void metodoinseriremprestimo() {
		String dadolivro = (String) comboBoxlivro.getSelectedItem();
		String dadocliente = (String) comboBoxCliente.getSelectedItem();
		
		String sql = "INSERT INTO empedev(usuario, livro, dataemprestimo,dataprevisao,datadevolucao) VALUES(?,?,?,?,?)"; //click do botão vai inserir dados essas sao os metodos para conexão e inserção de dados
		try {con = dao.conexaobib();
			PreparedStatement registro = con.prepareStatement(sql);
			registro.setString(1, dadocliente);
			registro.setString(2, dadolivro);
			registro.setString(3, Dataemprestimo.getText().toString());
			registro.setString(4, Dataprevisao.getText().toString());
			registro.setString(5, Datadevolucao.getText().toString());
			registro.execute();
			con.close();
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
	}
		JOptionPane.showMessageDialog(null, "Dados inseridos com sucesso!!!","ATENÇÃO",1);
		limparcampos();
	}
	
	private void metodoinserirdevolucao() {
		
		String sql = "UPDATE empedev SET datadevolucao= ? WHERE id = ?"; //click do botão vai inserir dados essas sao os metodos para conexão e inserção de dados
		try {con = dao.conexaobib();
			PreparedStatement registro = con.prepareStatement(sql);
			registro.setString(1, Datadevolucao.getText().toString());
			registro.setString(2, id.getText().toString());
			registro.executeUpdate();;
			con.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
	}
		JOptionPane.showMessageDialog(null, "Dado inseridos com sucesso!!!","ATENÇÃO",1);
		limparcampos();
	}
	
	
	

	@SuppressWarnings("static-access")
	public void inserircliente(String acao) {
		this.acao = acao;
	}
	
	public void preenchercampos(int codigo, String combocliente, String combolivro,String emprestimo,String previsao, String entrega) {
		id.setText(String.valueOf(codigo));
		comboBoxCliente.setSelectedItem(String.valueOf(combocliente));
		comboBoxlivro.setSelectedItem(String.valueOf(combolivro));
		Dataemprestimo.setText(String.valueOf(emprestimo));
		Dataprevisao.setText(String.valueOf(previsao));
		Datadevolucao.setText(String.valueOf(entrega));
	}
	
	public void limparcampos() {
		Dataprevisao.setText("");
		Dataemprestimo.setText("");
		Datadevolucao.setText("");
		comboBoxCliente.setSelectedItem(null);
		comboBoxlivro.setSelectedItem(null);
	}
	
	private boolean naoativo(JTextField testedados) {
		return testedados.getText().toString().trim().isEmpty();
	}
	
	
	
	public void autor(String autorlivro) {
		
	String sql = "SELECT autor from livro where titulo = ?";

	try { con = dao.conexaobib();
	PreparedStatement registro = con.prepareStatement(sql);
			registro.setString(1, autorlivro);
			ResultSet resultset = registro.executeQuery();
		if(resultset.next()) {
			String autor = resultset.getString("autor");
			FieldsAutor.setText(autor);
			
		}else {
			FieldsAutor.setText("Autor não existente");
		}
		
	} catch (SQLException e) {
		System.out.println("ERRO AO ATUALIZAR A TABELA: "+ e.getMessage());
	}
	}
	
	public void nada() {
		
	}
}
	
	

