package telainicial;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Telainicial extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btncliente;
	private JButton btnLivros;
	private JButton btnAutores;
	private JButton btnTabela;
	private JLabel lblNewLabel;

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
		setTitle("TELA PRINCIPAL");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 579, 404);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 128, 255));
		contentPane.setBorder(new CompoundBorder());
		contentPane.setLayout(null);

		setContentPane(contentPane);
		
		btncliente = new JButton("CLIENTE");
		btncliente.setForeground(new Color(0, 0, 0));
		btncliente.setContentAreaFilled(false);
		btncliente.setOpaque(true);
		btncliente.setBackground(Color.lightGray);
		btncliente.setFont(new Font("Arial", Font.BOLD, 15));
		btncliente.setBounds(97, 102, 141, 59);
		contentPane.add(btncliente);
		
		btnLivros = new JButton("LIVROS");
		btnLivros.setContentAreaFilled(false);
		btnLivros.setOpaque(true);
		btnLivros.setBackground(Color.lightGray);
		btnLivros.setFont(new Font("Arial", Font.BOLD, 15));
		btnLivros.setBounds(320, 102, 141, 59);
		contentPane.add(btnLivros);
		
		btnAutores = new JButton("AUTORES");
		btnAutores.setContentAreaFilled(false);
		btnAutores.setOpaque(true);
		btnAutores.setBackground(Color.lightGray);
		btnAutores.setFont(new Font("Arial", Font.BOLD, 15));
		btnAutores.setBounds(97, 200, 141, 59);
		contentPane.add(btnAutores);
		
		btnTabela = new JButton("<html><center>EMPRESTIMOS<br>E DEVOLUÇÃO<html><center>");
		btnTabela.setContentAreaFilled(false);
		btnTabela.setOpaque(true);
		btnTabela.setBackground(Color.lightGray);
		btnTabela.setFont(new Font("Arial", Font.BOLD, 15));
		btnTabela.setBounds(320, 200, 141, 59);
		contentPane.add(btnTabela);
		
		lblNewLabel = new JLabel("BEM VINDO(A) A NOSSA BIBLIOTECA, O QUE DESEJA:");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 60, 543, 31);
		contentPane.add(lblNewLabel);
	}
	}

