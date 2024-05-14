package panelcliente;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import conexoes.Conexaobancobib;

public class Cliente extends JPanel {

	Conexaobancobib dao = new Conexaobancobib();
	private Connection con;
	private static final long serialVersionUID = 1L;
	private JTextArea textArea;
	private JTable table;
	private JPanel panel;
	private JButton btnInserirCliente;
	private JButton btnDeletarLivro;
	private JButton btnAlterarLivro;
	private JLabel lblNewLabel;
	private JPanel panel_1;

	/**
	 * Create the panel.
	 */
	public Cliente() {
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
		
		btnInserirCliente = new JButton("Inserir Cliente");
		btnInserirCliente.setHorizontalTextPosition(SwingConstants.LEADING);
		btnInserirCliente.setIcon(new ImageIcon(Cliente.class.getResource("/Imagens/adicionar (1).png")));
		btnInserirCliente.setToolTipText("");
		btnInserirCliente.setFont(new Font("Arial", Font.BOLD, 14));
		btnInserirCliente.setOpaque(true);
		btnInserirCliente.setBackground(new Color(0, 204, 0));
		btnInserirCliente.setBounds(43, 23, 161, 38);
		panel.add(btnInserirCliente);
		btnInserirCliente.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				chamartela("Inserir");
			}
		});
		
		btnDeletarLivro = new JButton("Deletar Cliente");
		btnDeletarLivro.setHorizontalTextPosition(SwingConstants.LEADING);
		btnDeletarLivro.setIcon(new ImageIcon(Cliente.class.getResource("/Imagens/botao-apagar.png")));
		btnDeletarLivro.setToolTipText("");
		btnDeletarLivro.setFont(new Font("Arial", Font.BOLD, 14));
		btnDeletarLivro.setOpaque(true);
		btnDeletarLivro.setBackground(Color.RED);
		btnDeletarLivro.setBounds(244, 23, 179, 38);
		panel.add(btnDeletarLivro);
		
		lblNewLabel = new JLabel("Cliente");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 23));
		lblNewLabel.setBounds(326, 75, 120, 23);
		add(lblNewLabel);
		
		panel_1 = new JPanel();
		panel_1.setBackground(new Color(51, 255, 204));
		panel_1.setBounds(0, 131, 15, 59);
		add(panel_1);
		
		btnAlterarLivro = new JButton("Alterar Cliente");
		btnAlterarLivro.setHorizontalTextPosition(SwingConstants.LEADING);
		btnAlterarLivro.setIcon(new ImageIcon(Cliente.class.getResource("/Imagens/escreva (1).png")));
		btnAlterarLivro.setToolTipText("");
		btnAlterarLivro.setFont(new Font("Arial", Font.BOLD, 14));
		btnAlterarLivro.setOpaque(true);
		btnAlterarLivro.setBackground(new Color(255, 255, 0));
		btnAlterarLivro.setBounds(453, 23, 179, 38);
		panel.add(btnAlterarLivro);
		btnAlterarLivro.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				chamartela("Alterar");
				
			}
		});
		
	}
	
	private void chamartela(String acao) {
		Inserircliente inserircliente = new Inserircliente(acao);
		
		if(acao=="Alterar") {
		DefaultTableModel tabela1 = null ;
		try {
		
		tabela1 = (DefaultTableModel) table.getModel();
		int tabela = 0;
		
		tabela = table.getSelectedColumnCount();
		if(tabela==0) {
		JOptionPane.showMessageDialog(null, "Selecione uma linha da tabela para continuar", "ATENÇÃO", 0);
		}else {
			
		tabela1.getValueAt(table.getSelectedRow(),0).toString();
		int codigo = (int) table.getValueAt(table.getSelectedRow(),0);
		String nomepessoa = (String) table.getValueAt(table.getSelectedRow(),1);
		String datadenascimento = (String) table.getValueAt(table.getSelectedRow(),2);
		String emailpessoal = (String) table.getValueAt(table.getSelectedRow(),3);
		String enderecocompleto = (String) table.getValueAt(table.getSelectedRow(),4);
		String cpfusuario = (String) table.getValueAt(table.getSelectedRow(),5);
		String telefoneusuario = (String) table.getValueAt(table.getSelectedRow(),6);
		Inserircliente inserircliente2 = new Inserircliente(acao);
		inserircliente2.preenchercampos(codigo,nomepessoa,datadenascimento,emailpessoal,enderecocompleto,cpfusuario,telefoneusuario);
		
		inserircliente.setVisible(true);
		inserircliente.setLocationRelativeTo(null);
		JButton button = inserircliente.btnInserirCliente;
		button.setText("Alterar Cliente");
		button.setIcon(new ImageIcon(Cliente.class.getResource("/Imagens/escreva (1).png")));
		button.setBackground(new Color(255, 255, 0));
		
		}}
		catch (Exception e1){
		e1.printStackTrace();
			}
		}
		
		
		else if(acao=="Inserir") {
		inserircliente.setVisible(true);
		inserircliente.setLocationRelativeTo(null);
		JButton button = inserircliente.btnInserirCliente;
		button.setText("Inserir Cliente");
		button.setIcon(new ImageIcon(Cliente.class.getResource("/Imagens/adicionar (1).png")));
		button.setBackground(new Color(0, 204, 0));
		}
	}
	
}
