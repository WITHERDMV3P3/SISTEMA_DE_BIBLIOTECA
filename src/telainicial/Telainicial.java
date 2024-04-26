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
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Telainicial frame = new Telainicial();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Telainicial() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 579, 404);
		contentPane = new JPanel();
		contentPane.setBorder(new CompoundBorder());
		contentPane.setLayout(null);

		setContentPane(contentPane);
		
		btncliente = new JButton("CLIENTE");
		btncliente.setToolTipText("");
		btncliente.setOpaque(true);
		btncliente.setFont(new Font("Arial", Font.BOLD, 14));
		btncliente.setBounds(97, 109, 141, 59);
		contentPane.add(btncliente);
		
		btnLivros = new JButton("LIVROS");
		btnLivros.setToolTipText("");
		btnLivros.setOpaque(true);
		btnLivros.setFont(new Font("Arial", Font.BOLD, 14));
		btnLivros.setBounds(320, 109, 141, 59);
		contentPane.add(btnLivros);
		
		btnAutores = new JButton("AUTORES");
		btnAutores.setToolTipText("");
		btnAutores.setOpaque(true);
		btnAutores.setFont(new Font("Arial", Font.BOLD, 14));
		btnAutores.setBounds(97, 207, 141, 59);
		contentPane.add(btnAutores);
		
		btnTabela = new JButton("TABELA");
		btnTabela.setToolTipText("");
		btnTabela.setOpaque(true);
		btnTabela.setFont(new Font("Arial", Font.BOLD, 14));
		btnTabela.setBounds(320, 207, 141, 59);
		contentPane.add(btnTabela);
		
		lblNewLabel = new JLabel("BEM VINDO(A) A NOSSA BIBLIOTECA, O QUE DESEJA:");
		lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 13));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 67, 543, 31);
		contentPane.add(lblNewLabel);
	}
	}

