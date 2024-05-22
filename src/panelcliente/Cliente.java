package panelcliente;


import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.text.TableView;

import com.mysql.cj.xdevapi.Table;

import conexoes.Conexaobancobib;

import javax.swing.JScrollPane;

public class Cliente extends JPanel {

	Conexaobancobib dao = new Conexaobancobib();
	private Connection con;
	
	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private JButton btnInserirCliente;
	private JButton btnDeletarCliente;
	private JButton btnAlterarCliente;
	private JLabel lblNewLabel;
	private JPanel panel_1;
	JTable table;
	private JScrollPane scrollPane;

	/**
	 * Create the panel.
	 */
	public Cliente() {
		setSize(791,605);
		setBackground(new Color(255, 255, 255));
		setLayout(null);
		
		panel = new JPanel();
		panel.setToolTipText("Opções para inserir, atualizar,alterar e deletar dados.");
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "OP\u00C7\u00D5ES", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBackground(new Color(0, 0, 0, 0));
		panel.setBounds(28, 108, 741, 72);
		add(panel);
		
		
		btnInserirCliente = new JButton("Inserir Cliente");
		btnInserirCliente.setHorizontalTextPosition(SwingConstants.LEADING);
		btnInserirCliente.setIcon(new ImageIcon(Cliente.class.getResource("/Imagens/adicionar (1).png")));
		btnInserirCliente.setToolTipText("Inserir dados do Cliente");
		btnInserirCliente.setFont(new Font("Arial", Font.BOLD, 14));
		btnInserirCliente.setOpaque(true);
		btnInserirCliente.setBackground(new Color(0, 204, 0));
		btnInserirCliente.setBounds(10, 23, 161, 38);
		panel.add(btnInserirCliente);
		btnInserirCliente.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				chamartela("Inserir");
			}
		});
		
		btnDeletarCliente = new JButton("Deletar Cliente");
		btnDeletarCliente.setHorizontalTextPosition(SwingConstants.LEADING);
		btnDeletarCliente.setIcon(new ImageIcon(Cliente.class.getResource("/Imagens/botao-apagar.png")));
		btnDeletarCliente.setToolTipText("Deletar dados do cliente da tabela");
		btnDeletarCliente.setFont(new Font("Arial", Font.BOLD, 14));
		btnDeletarCliente.setOpaque(true);
		btnDeletarCliente.setBackground(Color.RED);
		btnDeletarCliente.setBounds(552, 23, 179, 38);
		panel.add(btnDeletarCliente);
		btnDeletarCliente.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				avisodeletar();
				
			}
		});
		
		scrollPane = new JScrollPane();
		scrollPane.setToolTipText("Tabela onde contêm dados do cliente.");
		scrollPane.setBounds(28, 192, 741, 380);
		add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "NOME", "DATA DE NASCIMENTO", "EMAIL", "ENDERE\u00C7O", "CPF", "TELEFONE"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(28);
		table.getColumnModel().getColumn(1).setPreferredWidth(132);
		table.getColumnModel().getColumn(2).setPreferredWidth(130);
		table.getColumnModel().getColumn(4).setPreferredWidth(165);
		
		lblNewLabel = new JLabel("Cliente");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 23));
		lblNewLabel.setBounds(326, 75, 120, 23);
		add(lblNewLabel);
		
		panel_1 = new JPanel();
		panel_1.setBackground(new Color(51, 255, 204));
		panel_1.setBounds(0, 131, 15, 59);
		add(panel_1);
		
		btnAlterarCliente = new JButton("Alterar Cliente");
		btnAlterarCliente.setHorizontalTextPosition(SwingConstants.LEADING);
		btnAlterarCliente.setIcon(new ImageIcon(Cliente.class.getResource("/Imagens/escreva (1).png")));
		btnAlterarCliente.setToolTipText("Alteração de dados do cliente");
		btnAlterarCliente.setFont(new Font("Arial", Font.BOLD, 14));
		btnAlterarCliente.setOpaque(true);
		btnAlterarCliente.setBackground(new Color(255, 255, 0));
		btnAlterarCliente.setBounds(376, 23, 166, 38);
		panel.add(btnAlterarCliente);
		btnAlterarCliente.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				chamartela("Alterar");
			}
		});
		
		JButton btnAtualizar = new JButton("Atualizar Tabela");
		btnAtualizar.setIcon(new ImageIcon(Cliente.class.getResource("/Imagens/refresh.png")));
		btnAtualizar.setToolTipText("Atualizar a tabela de clientes para verificação de inserção ou atualização de dados");
		btnAtualizar.setOpaque(true);
		btnAtualizar.setHorizontalTextPosition(SwingConstants.LEADING);
		btnAtualizar.setFont(new Font("Arial", Font.BOLD, 14));
		btnAtualizar.setBackground(new Color(0, 0, 0));
		btnAtualizar.setBounds(186, 23, 175, 38);
		panel.add(btnAtualizar);
		btnAtualizar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				atualizar();
			}
		});

	}
	
	private void avisodeletar() {
		int tabela = 0;
		tabela = table.getSelectedColumnCount();
		if(tabela==1){
			Object[] opcoes = {"Sim" , "Não"}; 
			tabela = 0;
			int valor = JOptionPane.showOptionDialog(null, "Deseja realmente excluir?","EXCLUIR",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,opcoes,opcoes[1]);
			if(valor == 0) {
				deletar();
				atualizar();
				JOptionPane.showMessageDialog(null, "Dados excluidos com sucesso!", "ATENÇÃO", 1);
				table.clearSelection();
				}
			else {
				atualizar();}
			}
		else if(tabela==0) {
			JOptionPane.showMessageDialog(null, "Selecione uma linha da tabela para continuar", "ATENÇÃO", 0);
		}
			}

	private void chamartela(String acao) {
		Inserircliente inserircliente = new Inserircliente(acao);
		DefaultTableModel tablee = (DefaultTableModel) table.getModel();

		TableModel tabela1 = null ;
		
		tabela1 = table.getModel();
		int tabela = 0;
		
		tabela = table.getSelectedColumnCount();
		
		
		if(acao=="Alterar") {
		try {
		if(tabela==0) {
		JOptionPane.showMessageDialog(null, "Selecione uma linha da tabela para continuar", "ATENÇÃO", 0);
		}
		else if (tabela>=1){
			
		tabela1.getValueAt(table.getSelectedRow(),0).toString();
		int codigo = (int) table.getValueAt(table.getSelectedRow(),0);
		String nomepessoa = (String) table.getValueAt(table.getSelectedRow(),1);
		String datadenascimento = (String) table.getValueAt(table.getSelectedRow(),2);
		String emailpessoal = (String) table.getValueAt(table.getSelectedRow(),3);
		String enderecocompleto = (String) table.getValueAt(table.getSelectedRow(),4);
		String cpfusuario = (String) table.getValueAt(table.getSelectedRow(),5);
		String telefoneusuario = (String) table.getValueAt(table.getSelectedRow(),6);
		
		inserircliente.preenchercampos(codigo,nomepessoa,datadenascimento,emailpessoal,enderecocompleto,cpfusuario,telefoneusuario);
		inserircliente.setVisible(true);
		inserircliente.setLocationRelativeTo(null);
		
		JButton button = inserircliente.btnInserirCliente;
		
		
		button.setText("Alterar Cliente");
		button.setIcon(new ImageIcon(Cliente.class.getResource("/Imagens/escreva (1).png")));
		button.setBackground(new Color(255, 255, 0));
		table.clearSelection();
		tablee.setRowCount(0);
		atualizar();
		}else if(tablee != null){
			JOptionPane.showMessageDialog(null, "Selecione uma linha da tabela para continuar", "ATENÇÃO", 0);}
		}
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
	
	public void atualizar() {
		DefaultTableModel model = (DefaultTableModel) table.getModel();	
		model.setRowCount(0);
		
	String sql = "SELECT * from usuario";
	try { con = dao.conexaobib();
	PreparedStatement registro = con.prepareStatement(sql);
		ResultSet resultset = registro.executeQuery(sql);
		while(resultset.next()) {
		Object[] rowData = {
				resultset.getInt("id"),
				resultset.getString("nome"),
				resultset.getString("datanascimento"),
				resultset.getString("email"),
				resultset.getString("endereco"),
				resultset.getString("cpf"),
				resultset.getString("telefone"),
		};
		model.addRow(rowData);
		
		}
	} catch (SQLException e) {
		System.out.println("ERRO AO ATUALIZAR A TABELA: "+ e.getMessage());
	}
	}
	
	public void deletar() {
		String sql = "Delete from usuario where id=?"; 
		try {con = dao.conexaobib();
			PreparedStatement registro = con.prepareStatement(sql);
			for(int linha : table.getSelectedRows()) {
				registro.setInt(1, Integer.parseInt(table.getValueAt(linha, 0).toString()));
				registro.execute();
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
	}
	}
}
