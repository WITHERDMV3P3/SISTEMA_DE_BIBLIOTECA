package telainicial;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import telacliente.Telacliente;

import javax.swing.JButton;
import javax.swing.JDesktopPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Rectangle;
import javax.swing.JInternalFrame;
import javax.swing.JTabbedPane;

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
		setBounds(100, 100, 961, 701);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new CompoundBorder());
		contentPane.setLayout(null);

		setContentPane(contentPane);
		
		panel = new JPanel();
		panel.setBackground(new Color(0, 102, 204));
		panel.setBounds(0, 0, 180, 701);
		contentPane.add(panel);
		panel.setLayout(null);
		
		btncliente = new JButton("CLIENTE");
		btncliente.setBorder(UIManager.getBorder("InternalFrame.border"));
		btncliente.setBounds(10, 198, 160, 59);
		panel.add(btncliente);
		btncliente.setForeground(new Color(0, 0, 0));
		btncliente.setContentAreaFilled(false);
		btncliente.setOpaque(true);
		btncliente.setBackground(new Color(102, 255, 204));
		btncliente.setFont(new Font("Arial", Font.BOLD, 15));
		btncliente.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				chamartelacliente();
			}
		});
		
		btnAutores = new JButton("AUTORES");
		btnAutores.setBorder(UIManager.getBorder("InternalFrame.border"));
		btnAutores.setBounds(10, 268, 160, 59);
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
		
		btnLivros = new JButton("LIVROS");
		btnLivros.setBorder(UIManager.getBorder("InternalFrame.border"));
		btnLivros.setBounds(10, 338, 160, 59);
		panel.add(btnLivros);
		btnLivros.setContentAreaFilled(false);
		btnLivros.setOpaque(true);
		btnLivros.setBackground(new Color(51, 255, 204));
		btnLivros.setFont(new Font("Arial", Font.BOLD, 15));
		
		btnSair = new JButton("SAIR");
		btnSair.setBorder(UIManager.getBorder("InternalFrame.border"));
		btnSair.setBounds(10, 603, 160, 59);
		panel.add(btnSair);
		btnSair.setContentAreaFilled(false);
		btnSair.setOpaque(true);
		btnSair.setBackground(new Color(51, 255, 204));
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
		
		btnEmprestimoeDevolucoes = new JButton("<html><center>EMPRESTIMOS<br>E DEVOLUÇÃO<html><center>");
		btnEmprestimoeDevolucoes.setBorder(UIManager.getBorder("InternalFrame.border"));
		btnEmprestimoeDevolucoes.setFont(new Font("Arial", Font.BOLD, 15));
		btnEmprestimoeDevolucoes.setContentAreaFilled(false);
		btnEmprestimoeDevolucoes.setOpaque(true);
		btnEmprestimoeDevolucoes.setBackground(new Color(0, 204, 255));
		btnEmprestimoeDevolucoes.setBounds(10, 408, 160, 59);
		panel.add(btnEmprestimoeDevolucoes);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(170, -29, 806, 745);
		contentPane.add(tabbedPane);
		
		panel_1 = new JPanel();
		tabbedPane.addTab("New tab", null, panel_1, null);
		panel_1.setLayout(null);
		
		panel_2 = new JPanel();
		tabbedPane.addTab("New tab", null, panel_2, null);
		panel_2.setLayout(null);
		
		panel_3 = new JPanel();
		tabbedPane.addTab("New tab", null, panel_3, null);
		panel_3.setLayout(null);
		
		panel_4 = new JPanel();
		tabbedPane.addTab("New tab", null, panel_4, null);
		panel_4.setLayout(null);
	}

	protected void chamartelaautores() {
		tabbedPane.setSelectedIndex(1);
	}

	private void chamartelacliente() {
		tabbedPane.setSelectedIndex(0);
	}
	}


