package panellivro;

import java.awt.Color;
import java.awt.Component;
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

public class Livro extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextArea textArea;
	private JTable table;
	private JPanel panel;
	private JButton btnInserirLivro;
	private AbstractButton btnDeletarLivro;
	private AbstractButton btnAlterarLivro;
	private JLabel lblNewLivro;
	private JComponent panel_1;

	/**
	 * Create the panel.
	 */
	public Livro() {
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
		
		btnInserirLivro = new JButton("Inserir Livro");
		btnInserirLivro.setHorizontalTextPosition(SwingConstants.LEADING);
		btnInserirLivro.setIcon(new ImageIcon(Cliente.class.getResource("/Imagens/adicionar (1).png")));
		btnInserirLivro.setToolTipText("");
		btnInserirLivro.setFont(new Font("Arial", Font.BOLD, 14));
		btnInserirLivro.setOpaque(true);
		btnInserirLivro.setBackground(new Color(0, 204, 0));
		btnInserirLivro.setBounds(53, 23, 151, 38);
		panel.add(btnInserirLivro);
		
		btnDeletarLivro = new JButton("Deletar Livro");
		btnDeletarLivro.setHorizontalTextPosition(SwingConstants.LEADING);
		btnDeletarLivro.setIcon(new ImageIcon(Cliente.class.getResource("/Imagens/botao-apagar.png")));
		btnDeletarLivro.setToolTipText("");
		btnDeletarLivro.setFont(new Font("Arial", Font.BOLD, 14));
		btnDeletarLivro.setOpaque(true);
		btnDeletarLivro.setBackground(Color.RED);
		btnDeletarLivro.setBounds(244, 23, 179, 38);
		panel.add(btnDeletarLivro);
		
		btnAlterarLivro = new JButton("Alterar Livro");
		btnAlterarLivro.setHorizontalTextPosition(SwingConstants.LEADING);
		btnAlterarLivro.setIcon(new ImageIcon(Cliente.class.getResource("/Imagens/escreva (1).png")));
		btnAlterarLivro.setToolTipText("");
		btnAlterarLivro.setFont(new Font("Arial", Font.BOLD, 14));
		btnAlterarLivro.setOpaque(true);
		btnAlterarLivro.setBackground(new Color(255, 255, 0));
		btnAlterarLivro.setBounds(453, 23, 179, 38);
		panel.add(btnAlterarLivro);
		
		lblNewLivro = new JLabel("Livro");
		lblNewLivro.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLivro.setFont(new Font("Arial Black", Font.BOLD, 23));
		lblNewLivro.setBounds(326, 75, 130, 23);
		add(lblNewLivro);
		
		panel_1 = new JPanel();
		panel_1.setBackground(new Color(51, 255, 204));
		panel_1.setBounds(0, 295, 15, 59);
		add(panel_1);


	}

}
