package panelautores;

import java.awt.Color;
import java.awt.Font;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import panelcliente.Cliente;

public class Autores extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextArea textArea;
	private JTable table;
	private JPanel panel;
	private JButton btnInserirAutores;
	private AbstractButton btnDeletarAutores;
	private AbstractButton btnAlterarAutores;
	private JLabel lblNewAutor;
	private JComponent panel_1;

	/**
	 * Create the panel.
	 */
	public Autores() {
		setSize(791,706);
		setBackground(new Color(255, 255, 255));
		setLayout(null);
		
		textArea = new JTextArea();
		textArea.setBackground(new Color(192, 192, 192));
		textArea.setBounds(53, 191, 663, 367);
		add(textArea);
		
		table = new JTable();
		table.setBounds(38, 97, 1, 1);
		add(table);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setToolTipText("");
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "OP\u00C7\u00D5ES", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBackground(new Color(0, 0, 0, 0));
		panel.setBounds(53, 108, 663, 72);
		add(panel);
		
		btnInserirAutores = new JButton("Inserir Autor");
		btnInserirAutores.setHorizontalTextPosition(SwingConstants.LEADING);
		btnInserirAutores.setIcon(new ImageIcon(Cliente.class.getResource("/Imagens/adicionar (1).png")));
		btnInserirAutores.setToolTipText("");
		btnInserirAutores.setFont(new Font("Arial", Font.BOLD, 14));
		btnInserirAutores.setOpaque(true);
		btnInserirAutores.setBackground(new Color(0, 204, 0));
		btnInserirAutores.setBounds(53, 23, 151, 38);
		panel.add(btnInserirAutores);
		
		btnDeletarAutores = new JButton("Deletar Autor");
		btnDeletarAutores.setHorizontalTextPosition(SwingConstants.LEADING);
		btnDeletarAutores.setIcon(new ImageIcon(Cliente.class.getResource("/Imagens/botao-apagar.png")));
		btnDeletarAutores.setToolTipText("");
		btnDeletarAutores.setFont(new Font("Arial", Font.BOLD, 14));
		btnDeletarAutores.setOpaque(true);
		btnDeletarAutores.setBackground(Color.RED);
		btnDeletarAutores.setBounds(244, 23, 179, 38);
		panel.add(btnDeletarAutores);
		
		btnAlterarAutores = new JButton("Alterar Autor");
		btnAlterarAutores.setHorizontalTextPosition(SwingConstants.LEADING);
		btnAlterarAutores.setIcon(new ImageIcon(Cliente.class.getResource("/Imagens/escreva (1).png")));
		btnAlterarAutores.setToolTipText("");
		btnAlterarAutores.setFont(new Font("Arial", Font.BOLD, 14));
		btnAlterarAutores.setOpaque(true);
		btnAlterarAutores.setBackground(new Color(255, 255, 0));
		btnAlterarAutores.setBounds(453, 23, 179, 38);
		panel.add(btnAlterarAutores);
		
		lblNewAutor = new JLabel("Autores");
		lblNewAutor.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewAutor.setFont(new Font("Arial Black", Font.BOLD, 23));
		lblNewAutor.setBounds(326, 75, 130, 23);
		add(lblNewAutor);
		
		panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 204, 255));
		panel_1.setBounds(0, 209, 15, 59);
		add(panel_1);

	}

}
