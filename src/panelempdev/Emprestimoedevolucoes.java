package panelempdev;

import javax.swing.JPanel;
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

public class Emprestimoedevolucoes extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextArea textArea;
	private JTable table;
	private JPanel panel;
	private JButton btnInserirEmprestimo;
	private AbstractButton btnDeletarEmpDev;
	private AbstractButton btnAlterarEmpDev;
	private JLabel LabelEmpDev;
	private JComponent panel_1;
	private JButton btnInserirDevoluções;
	/**
	 * Create the panel.
	 */
	public Emprestimoedevolucoes() {
		
		setSize(791,706);
		setBackground(new Color(255, 255, 255));
		setLayout(null);
		
		textArea = new JTextArea();
		textArea.setBackground(new Color(192, 192, 192));
		textArea.setBounds(54, 191, 663, 367);
		add(textArea);
		
		table = new JTable();
		table.setBounds(39, 97, 1, 1);
		add(table);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setToolTipText("");
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "OP\u00C7\u00D5ES", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBackground(new Color(0, 0, 0, 0));
		panel.setBounds(10, 107, 771, 73);
		add(panel);
		
		btnInserirEmprestimo = new JButton("<html><center>Inserir<br> Empréstimo<html><center>");
		btnInserirEmprestimo.setHorizontalTextPosition(SwingConstants.LEADING);
		btnInserirEmprestimo.setIcon(new ImageIcon(Cliente.class.getResource("/Imagens/adicionar (1).png")));
		btnInserirEmprestimo.setToolTipText("");
		btnInserirEmprestimo.setFont(new Font("Arial", Font.BOLD, 14));
		btnInserirEmprestimo.setOpaque(true);
		btnInserirEmprestimo.setBackground(new Color(0, 204, 0));
		btnInserirEmprestimo.setBounds(23, 23, 151, 38);
		panel.add(btnInserirEmprestimo);
		
		btnDeletarEmpDev = new JButton("<html><center>Cancelar Empréstimo <br> ou Devoluções <html><center>");
		btnDeletarEmpDev.setHorizontalTextPosition(SwingConstants.LEADING);
		btnDeletarEmpDev.setIcon(new ImageIcon(Cliente.class.getResource("/Imagens/botao-apagar.png")));
		btnDeletarEmpDev.setToolTipText("");
		btnDeletarEmpDev.setFont(new Font("Arial", Font.BOLD, 14));
		btnDeletarEmpDev.setOpaque(true);
		btnDeletarEmpDev.setBackground(Color.RED);
		btnDeletarEmpDev.setBounds(564, 23, 186, 38);
		panel.add(btnDeletarEmpDev);
		
		btnAlterarEmpDev = new JButton("<html><center>Alterar Empréstimo <br> ou Devoluções <html><center>");
		btnAlterarEmpDev.setHorizontalTextPosition(SwingConstants.LEADING);
		btnAlterarEmpDev.setIcon(new ImageIcon(Cliente.class.getResource("/Imagens/escreva (1).png")));
		btnAlterarEmpDev.setToolTipText("");
		btnAlterarEmpDev.setFont(new Font("Arial", Font.BOLD, 14));
		btnAlterarEmpDev.setOpaque(true);
		btnAlterarEmpDev.setBackground(new Color(255, 255, 0));
		btnAlterarEmpDev.setBounds(364, 23, 179, 38);
		panel.add(btnAlterarEmpDev);
		
		btnInserirDevoluções = new JButton("<html><center>Inserir <br>Devoluções <html><center>");
		btnInserirDevoluções.setHorizontalTextPosition(SwingConstants.LEADING);
		btnInserirDevoluções.setIcon(new ImageIcon(Cliente.class.getResource("/Imagens/adicionar (1).png")));
		btnInserirDevoluções.setToolTipText("");
		btnInserirDevoluções.setOpaque(true);
		btnInserirDevoluções.setHorizontalTextPosition(SwingConstants.LEADING);
		btnInserirDevoluções.setFont(new Font("Arial", Font.BOLD, 14));
		btnInserirDevoluções.setBackground(new Color(0, 204, 0));
		btnInserirDevoluções.setBounds(193, 24, 151, 38);
		panel.add(btnInserirDevoluções);
		
		LabelEmpDev = new JLabel("Empréstimos e Devoluções");
		LabelEmpDev.setHorizontalAlignment(SwingConstants.CENTER);
		LabelEmpDev.setFont(new Font("Arial Black", Font.BOLD, 23));
		LabelEmpDev.setBounds(54, 88, 663, 23);
		add(LabelEmpDev);
		
		panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 204, 255));
		panel_1.setBounds(0, 380, 15, 59);
		add(panel_1);


	}
}
