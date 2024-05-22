package panellivro;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicTabbedPaneUI.TabbedPaneLayout;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import java.awt.Window.Type;
import javax.swing.JFormattedTextField;
import java.awt.event.WindowAdapter;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JList;
import javax.swing.DefaultComboBoxModel;

public class Inserirlivro extends JFrame{
	
	Conexaobancobib dao = new Conexaobancobib();
	private Connection con;
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabelnome;
	private JTextField titulo;
	private JLabel lblNewLabeldatanascimento;
	private JLabel lblNewLabelemail;
	private JTextField subtitulo;
	private JLabel lblNewLabelcpf;
	private JLabel lblNewLabelend;
	private JTextField editora;
	JButton btnInserirLivro;
	private JLabel lblId;
	private JTextField id;
	private static String acao;
	Livro cliente = new Livro(); 
	private JFormattedTextField datapublicacao;
	private JFormattedTextField isbn;
	private JComboBox<String> comboBox;

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
					Inserirlivro frame = new Inserirlivro(acao);
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
	public Inserirlivro(String acao) {
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
						titulo.requestFocus();
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
					titulo.requestFocus();
				}
			}
		});
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
				MaskFormatter isbnform = null;
		try {
			isbnform = new MaskFormatter("#############");
		} catch (ParseException e) {
			System.out.println("Erro ao criar a máscara");
		} 
		
		MaskFormatter dataform = null; // TODO ele coloca o formattedtextfield como campo para colocar datas 
		try {
			dataform = new MaskFormatter("##/##/####");
		} catch (ParseException e) {
			System.out.println("Erro ao criar a máscara");
		}
		
		
		isbn = new JFormattedTextField(isbnform);
		isbn.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					editora.requestFocus();
					}else if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {
						datapublicacao.requestFocus();
					}
			}
		});
		isbn.setFont(new Font("Arial", Font.PLAIN, 14));
		isbn.setBounds(361, 123, 179, 24);
		contentPane.add(isbn);
		
		
		datapublicacao = new JFormattedTextField(dataform);
		datapublicacao.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					isbn.requestFocus();
					}else if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {
						comboBox.requestFocus();
					}
			}
		});
		datapublicacao.setFont(new Font("Arial", Font.PLAIN, 14));
		datapublicacao.setBounds(361, 78, 136, 24);
		contentPane.add(datapublicacao);
		
		
		lblNewLabelnome = new JLabel("*Título:");
		lblNewLabelnome.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblNewLabelnome.setBounds(35, 58, 293, 20);
		contentPane.add(lblNewLabelnome);
		
		titulo = new JTextField();
		titulo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					subtitulo.requestFocus();
					}
				}
				
		});
		titulo.setFont(new Font("Arial", Font.PLAIN, 14));
		titulo.setBounds(35, 73, 293, 24);
		contentPane.add(titulo);
		titulo.setColumns(10);
		
		lblNewLabeldatanascimento = new JLabel("Data de publicação:");
		lblNewLabeldatanascimento.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblNewLabeldatanascimento.setBounds(361, 63, 163, 20);
		contentPane.add(lblNewLabeldatanascimento);
		
		lblNewLabelemail = new JLabel("Subtítulo:");
		lblNewLabelemail.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblNewLabelemail.setBounds(35, 108, 103, 20);
		contentPane.add(lblNewLabelemail);
		
		subtitulo = new JTextField();
		subtitulo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					comboBox.requestFocus();
					}else if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {
						titulo.requestFocus();
					}
			}
		});
		subtitulo.setFont(new Font("Arial", Font.PLAIN, 14));
		subtitulo.setColumns(10);
		subtitulo.setBounds(35, 125, 293, 24);
		contentPane.add(subtitulo);
		
		lblNewLabelcpf = new JLabel("*ISBN:");
		lblNewLabelcpf.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblNewLabelcpf.setBounds(361, 110, 103, 17);
		contentPane.add(lblNewLabelcpf);
		
		lblNewLabelend = new JLabel("Editora:");
		lblNewLabelend.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblNewLabelend.setBounds(361, 151, 179, 20);
		contentPane.add(lblNewLabelend);
		
		editora = new JTextField();
		editora.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					btnInserirLivro.requestFocus();
					}else if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {
						isbn.requestFocus();
					}
			}
		});
		editora.setFont(new Font("Arial", Font.PLAIN, 14));
		editora.setColumns(10);
		editora.setBounds(361, 168, 179, 24);
		contentPane.add(editora);
		
		btnInserirLivro = new JButton("");
		btnInserirLivro.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {
					comboBox.requestFocus();
				}
			}
		});
		btnInserirLivro.setHorizontalTextPosition(SwingConstants.LEADING);
		btnInserirLivro.setToolTipText("");
		btnInserirLivro.setOpaque(true);
		btnInserirLivro.setFont(new Font("Arial", Font.BOLD, 14));
		btnInserirLivro.setBackground(new Color(0, 204, 0));
		btnInserirLivro.setBounds(225, 219, 161, 38);
		contentPane.add(btnInserirLivro);
		btnInserirLivro.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(acao.equals("Inserir")) {
					boolean checar =
							naoativo(titulo)||
							naoativo(isbn);
					if(checar) {
						JOptionPane.showMessageDialog(null, "Campos Não Preenchidos, Preenche-os!!!","ATENÇÃO",1);
					}else {
						metodoinserir();
					}
					
				}else if(acao.equals("Alterar")) {
						boolean checar =
								naoativo(titulo)||
								naoativo(isbn);
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
		
		JLabel lblAutor = new JLabel("Autor:");
		lblAutor.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblAutor.setBounds(35, 154, 103, 20);
		contentPane.add(lblAutor);
		
		comboBox = new JComboBox();
		comboBox.setEditable(true);
		comboBox.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					datapublicacao.requestFocus();
					}else if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {
						subtitulo.requestFocus();
					}
			}
		});
		comboBox.setBounds(35, 169, 293, 22);
		contentPane.add(comboBox);
		preencherComboBox();
		AutoCompleteDecorator.decorate(comboBox);
	}
	
	 private void preencherComboBox() {
	        String sql = "SELECT nome_autor FROM autor";
	        try {
	            Connection con = dao.conexaobib();
	            PreparedStatement stmt = con.prepareStatement(sql);
	            ResultSet rs = stmt.executeQuery();
	            List<String> autores = new ArrayList<>();
	            autores.add("--Selecione Autor--");
	            while (rs.next()) {
	                autores.add(rs.getString("nome_autor"));
	            }
	            comboBox.setModel(new DefaultComboBoxModel<>(autores.toArray(new String[1])));
	            con.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	            JOptionPane.showMessageDialog(this, "Erro ao carregar autores", "Erro", JOptionPane.ERROR_MESSAGE);
	        }
	    }

	private void metodoalterar() {
		String dadoselecionado = (String) comboBox.getSelectedItem();
		
		String sql = "UPDATE livro SET titulo = ?, subtitulo = ?, editora = ? , datapublicacao= ?, isbn = ?, autor = ? WHERE id = ? ";
		try { con = dao.conexaobib();
				PreparedStatement registro = con.prepareStatement(sql);{
				registro.setString(1, titulo.getText().toString());
				registro.setString(2, subtitulo.getText().toString());
				registro.setString(3, editora.getText().toString());
				registro.setString(4, datapublicacao.getText().toString());
				registro.setString(5, isbn.getText().toString());
				registro.setString(6, dadoselecionado);
				registro.setString(7, id.getText().toString());
			registro.executeUpdate();
			con.close();
		}} catch (SQLException e) {
			System.out.println(e.getMessage());
	}
		
		JOptionPane.showMessageDialog(null, "Dados atualizados com sucesso!!!","ATENÇÃO",1);
	}
	
	

	private void metodoinserir() {
		String dadoselecionado = (String) comboBox.getSelectedItem();
		String sql = "INSERT INTO livro(titulo, subtitulo, editora, datapublicacao, isbn, autor) VALUES(?,?,?,?,?,?)"; //click do botão vai inserir dados essas sao os metodos para conexão e inserção de dados
		try {con = dao.conexaobib();
			PreparedStatement registro = con.prepareStatement(sql);
			registro.setString(1, titulo.getText().toString());
			registro.setString(2, subtitulo.getText().toString());
			registro.setString(3, editora.getText().toString());
			registro.setString(4, datapublicacao.getText().toString());
			registro.setString(5, isbn.getText().toString());
			registro.setString(6, dadoselecionado);
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
	
	public void preenchercampos(int codigo, String titulolivro,String subtitulolivro,String autorlivro, String editoralivro,String datapublicacaolivro,String isbnlivro) {
		id.setText(String.valueOf(codigo));
		titulo.setText(String.valueOf(titulolivro));
		subtitulo.setText(String.valueOf(subtitulolivro));
		comboBox.setSelectedItem(String.valueOf(autorlivro));
		editora.setText(String.valueOf(editoralivro));
		datapublicacao.setText(String.valueOf(datapublicacaolivro));
		isbn.setText(String.valueOf(isbnlivro));
	}
	
	public void limparcampos() {
		titulo.setText("");
		datapublicacao.setText("");
		subtitulo.setText("");
		editora.setText("");
		isbn.setText("");
		comboBox.setSelectedItem(null);;
	}
	
	private boolean naoativo(JTextField testedados) {
		return testedados.getText().toString().trim().isEmpty();
	}
}
	
	

