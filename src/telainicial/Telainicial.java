package telainicial;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;

import panelautores.Autores;
import panelcliente.Cliente;
import panelempdev.Emprestimoedevolucoes;
import panellivro.Livro;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class Telainicial extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panel;
	private JButton btncliente;
	private JButton btnLivros;
	private JButton btnSair;
	private JButton btnAutores;
	private JButton btnEmprestimoeDevolucoes;
	private final JDesktopPane pane = new JDesktopPane();
	private JTabbedPane tabbedPane;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;
	private JPanel panel_4;
	private JButton btnTelaInicial;
	private JPanel panel_5;
	private JPanel panel_6;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Telainicial chamar = new Telainicial();
		chamar.chamartela();
	}
	
	public void chamartela() {
		try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Throwable e) {
            e.printStackTrace();
        }
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Telainicial frame = new Telainicial();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Telainicial() {
		setUndecorated(true);
		setTitle("TELA PRINCIPAL");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 953, 603);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new CompoundBorder());
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 180, 603);
		contentPane.add(panel);
		panel.setLayout(null);
		
	/*	addWindowListener(new WindowAdapter() {
			Cliente cliente = new Cliente();
            @Override
            public void windowClosing(WindowEvent e) {
                // Quando a janela é fechada pelo botão de fechar (X), notifica a tela um para atualizar a JTable
               cliente.atualizar();
            }
        }); */
		
		btncliente = new JButton("Cliente");
		btncliente.setBorder(UIManager.getBorder("InternalFrame.border"));
		btncliente.setBounds(10, 127, 160, 59);
		panel.add(btncliente);
		btncliente.setForeground(new Color(0, 0, 0));
		btncliente.setContentAreaFilled(false);
		btncliente.setOpaque(true);
		btncliente.setBackground(new Color(51, 255, 204));
		btncliente.setFont(new Font("Arial", Font.BOLD, 15));
		btncliente.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				chamartelacliente();
			}
		});
		
		btnAutores = new JButton("Autores");
		btnAutores.setBorder(UIManager.getBorder("InternalFrame.border"));
		btnAutores.setBounds(10, 205, 160, 59);
		panel.add(btnAutores);
		btnAutores.setContentAreaFilled(false);
		btnAutores.setOpaque(true);
		btnAutores.setBackground(new Color(0, 204, 255));
		btnAutores.setFont(new Font("Arial", Font.BOLD, 15));
		btnAutores.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				chamartelaautores();
			}
		});
		
		btnLivros = new JButton("Livros");
		btnLivros.setBorder(UIManager.getBorder("InternalFrame.border"));
		btnLivros.setBounds(10, 291, 160, 59);
		panel.add(btnLivros);
		btnLivros.setContentAreaFilled(false);
		btnLivros.setOpaque(true);
		btnLivros.setBackground(new Color(51, 255, 204));
		btnLivros.setFont(new Font("Arial", Font.BOLD, 15));
		btnLivros.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				chamartelalivro();
			}
		});
		
		btnEmprestimoeDevolucoes = new JButton("<html><center>Empréstimo<br>e Devolução<html><center>");
		btnEmprestimoeDevolucoes.setBorder(UIManager.getBorder("InternalFrame.border"));
		btnEmprestimoeDevolucoes.setFont(new Font("Arial", Font.BOLD, 15));
		btnEmprestimoeDevolucoes.setContentAreaFilled(false);
		btnEmprestimoeDevolucoes.setOpaque(true);
		btnEmprestimoeDevolucoes.setBackground(new Color(0, 204, 255));
		btnEmprestimoeDevolucoes.setBounds(10, 374, 160, 59);
		panel.add(btnEmprestimoeDevolucoes);
		btnEmprestimoeDevolucoes.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				chamartelaempdev();
			}
		});;
		
		
		btnSair = new JButton("Sair");
		btnSair.setIcon(new ImageIcon(Telainicial.class.getResource("/Imagens/sair.png")));
		btnSair.setBorder(UIManager.getBorder("InternalFrame.border"));
		btnSair.setBounds(29, 551, 128, 41);
		panel.add(btnSair);
	//	btnSair.setContentAreaFilled(false);
		btnSair.setOpaque(true);
		btnSair.setBackground(Color.RED);
		btnSair.setFont(new Font("Arial", Font.BOLD, 15));
		btnSair.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String[] opcoes = {
					"Sim",
					"Não"
				};
				int valor = JOptionPane.showOptionDialog(null, "Deseja realmente sair?","SAIR",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,opcoes,opcoes[1]);
				if(valor==1) {
					
				}
				else {
					System.exit(0);
				}
			}
		});
		
		
		btnTelaInicial = new JButton("Início");
		btnTelaInicial.setFont(new Font("Arial", Font.BOLD, 15));
		btnTelaInicial.setContentAreaFilled(false);
		btnTelaInicial.setOpaque(true);
		btnTelaInicial.setBorder(UIManager.getBorder("InternalFrame.border"));
		btnTelaInicial.setBackground(new Color(0, 204, 255));
		btnTelaInicial.setBounds(10, 54, 160, 59);
		panel.add(btnTelaInicial);
		btnTelaInicial.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				chamartelainicial();
				
			}
		});

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(170, -29, 806, 643);
		contentPane.add(tabbedPane);
		
		panel_5 = new JPanel();
		tabbedPane.addTab("New tab", null, panel_5, null);
		panel_5.setLayout(null);
		
		panel_1 = new JPanel();
		tabbedPane.addTab("New tab", null, panel_1, null);
		panel_1.setLayout(null);
		Cliente cliente = new Cliente();
		cliente.setBorder(new LineBorder(new Color(0, 0, 0), 10));
		cliente.setSize(791,706);
		cliente.setLocation(0,0);
		panel_1.removeAll();
		panel_1.add(cliente,BorderLayout.CENTER);
		panel_1.revalidate();
		panel_1.repaint();
		
		panel_2 = new JPanel();
		tabbedPane.addTab("New tab", null, panel_2, null);
		panel_2.setLayout(null);
		Autores autores = new Autores();
		autores.setBorder(new LineBorder(new Color(0, 0, 0), 10));
		autores.setSize(791,706);
		autores.setLocation(0,0);
		panel_2.removeAll();
		panel_2.add(autores,BorderLayout.CENTER);
		panel_2.revalidate();
		panel_2.repaint();
		
		
		panel_3 = new JPanel();
		tabbedPane.addTab("New tab", null, panel_3, null);
		panel_3.setLayout(null);
		Livro livro = new Livro();
		livro.setBorder(new LineBorder(new Color(0, 0, 0), 10));
		livro.setSize(791,706);
		livro.setLocation(0,0);
		panel_3.removeAll();
		panel_3.add(livro,BorderLayout.CENTER);
		panel_3.revalidate();
		panel_3.repaint();
		
		panel_4 = new JPanel();
		tabbedPane.addTab("New tab", null, panel_4, null);
		panel_4.setLayout(null);
		Emprestimoedevolucoes empdev= new Emprestimoedevolucoes();
		empdev.setBorder(new LineBorder(new Color(0, 0, 0), 10));
		empdev.setSize(791,706);
		empdev.setLocation(0, 0);
		panel_4.removeAll();
		panel_4.add(empdev,BorderLayout.CENTER);
		panel_4.revalidate();
		panel_4.repaint();
		
	}
	
	

	private void chamartelacliente() {
		tabbedPane.setSelectedIndex(1);
	}

	private void chamartelaautores() {
		tabbedPane.setSelectedIndex(2);
	}
	
	private void chamartelalivro() {
		tabbedPane.setSelectedIndex(3);
	}
	private void chamartelaempdev() {
		tabbedPane.setSelectedIndex(4);
	}
	private void chamartelainicial() {
		tabbedPane.setSelectedIndex(0);
	}
	}


