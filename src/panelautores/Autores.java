package panelautores;


import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import conexoes.Conexaobancobib;

import javax.swing.JScrollPane;

public class Autores extends JPanel {

	Conexaobancobib dao = new Conexaobancobib();
	private Connection con;
	
	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private JButton btnInserirAutores;
	private JButton btnDeletarAutor;
	private JButton btnAlterarAutores;
	private JLabel lblNewLabel;
	private JPanel panel_1;
	JTable table;
	private JScrollPane scrollPane;

	/**
	 * Create the panel.
	 */
	public Autores() {
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
		
		
		btnInserirAutores = new JButton("Inserir Autor");
		btnInserirAutores.setHorizontalTextPosition(SwingConstants.LEADING);
		btnInserirAutores.setIcon(new ImageIcon(Autores.class.getResource("/Imagens/adicionar (1).png")));
		btnInserirAutores.setToolTipText("Inserir dados do autor");
		btnInserirAutores.setFont(new Font("Arial", Font.BOLD, 14));
		btnInserirAutores.setOpaque(true);
		btnInserirAutores.setBackground(new Color(0, 204, 0));
		btnInserirAutores.setBounds(10, 23, 161, 38);
		panel.add(btnInserirAutores);
		btnInserirAutores.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				chamartela("Inserir");
			}
		});
		
		btnDeletarAutor = new JButton("Deletar Autor");
		btnDeletarAutor.setHorizontalTextPosition(SwingConstants.LEADING);
		btnDeletarAutor.setIcon(new ImageIcon(Autores.class.getResource("/Imagens/botao-apagar.png")));
		btnDeletarAutor.setToolTipText("Deletar dados do autor da tabela");
		btnDeletarAutor.setFont(new Font("Arial", Font.BOLD, 14));
		btnDeletarAutor.setOpaque(true);
		btnDeletarAutor.setBackground(Color.RED);
		btnDeletarAutor.setBounds(552, 23, 179, 38);
		panel.add(btnDeletarAutor);
		btnDeletarAutor.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				avisodeletar();
				
			}
		});
		
		scrollPane = new JScrollPane();
		scrollPane.setToolTipText("Tabela onde contêm dados do autor.");
		scrollPane.setBounds(28, 192, 741, 380);
		add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "NOME", "DATA DE NASCIMENTO", "EMAIL", "ENDERE\u00C7O", "TELEFONE"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(28);
		table.getColumnModel().getColumn(1).setPreferredWidth(132);
		table.getColumnModel().getColumn(2).setPreferredWidth(130);
		table.getColumnModel().getColumn(4).setPreferredWidth(165);
		
		lblNewLabel = new JLabel("Autor");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 23));
		lblNewLabel.setBounds(326, 75, 120, 23);
		add(lblNewLabel);
		
		panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 204, 255));
		panel_1.setBounds(0, 208, 15, 59);
		add(panel_1);
		
		btnAlterarAutores = new JButton("Alterar Autor");
		btnAlterarAutores.setHorizontalTextPosition(SwingConstants.LEADING);
		btnAlterarAutores.setIcon(new ImageIcon(Autores.class.getResource("/Imagens/escreva (1).png")));
		btnAlterarAutores.setToolTipText("Alteração de dados do autor");
		btnAlterarAutores.setFont(new Font("Arial", Font.BOLD, 14));
		btnAlterarAutores.setOpaque(true);
		btnAlterarAutores.setBackground(new Color(255, 255, 0));
		btnAlterarAutores.setBounds(376, 23, 166, 38);
		panel.add(btnAlterarAutores);
		btnAlterarAutores.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				chamartela("Alterar");
			}
		});
		
		JButton btnAtualizar = new JButton("Atualizar Tabela");
		btnAtualizar.setIcon(new ImageIcon(Autores.class.getResource("/Imagens/refresh.png")));
		btnAtualizar.setToolTipText("Atualizar a tabela de autor para verificação de inserção ou atualização de dados");
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

	private void chamartela(String acaoAutor) {
		InserirAutor inserirAutor = new InserirAutor(acaoAutor);
		DefaultTableModel tablee = (DefaultTableModel) table.getModel();

		TableModel tabela1 = null ;
		
		tabela1 = table.getModel();
		int tabela = 0;
		
		tabela = table.getSelectedColumnCount();
		
		
		if(acaoAutor=="Alterar") {
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
		String telefoneusuario = (String) table.getValueAt(table.getSelectedRow(),5);
		inserirAutor.preenchercampos(codigo,nomepessoa,datadenascimento,emailpessoal,enderecocompleto,telefoneusuario);
		inserirAutor.setVisible(true);
		inserirAutor.setLocationRelativeTo(null);
		
		JButton button = inserirAutor.btnInserirAutor;
		
		
		button.setText("Alterar Autor");
		button.setIcon(new ImageIcon(Autores.class.getResource("/Imagens/escreva (1).png")));
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
		
		
		else if(acaoAutor=="Inserir") {
			inserirAutor.setVisible(true);
			inserirAutor.setLocationRelativeTo(null);
		JButton button = inserirAutor.btnInserirAutor;
		button.setText("Inserir Autor");
		button.setIcon(new ImageIcon(Autores.class.getResource("/Imagens/adicionar (1).png")));
		button.setBackground(new Color(0, 204, 0));
		}
	}
	
	public void atualizar() {
		DefaultTableModel model = (DefaultTableModel) table.getModel();	
		model.setRowCount(0);
		
	String sql = "SELECT * from autor";
	try { con = dao.conexaobib();
	PreparedStatement registro = con.prepareStatement(sql);
		ResultSet resultset = registro.executeQuery(sql);
		while(resultset.next()) {
		Object[] rowData = {
				resultset.getInt("id"),
				resultset.getString("nome_autor"),
				resultset.getString("datanascimento"),
				resultset.getString("email"),
				resultset.getString("endereco"),
				resultset.getString("telefone")
		};
		model.addRow(rowData);
		
		}
	} catch (SQLException e) {
		System.out.println("ERRO AO ATUALIZAR A TABELA: "+ e.getMessage());
	}
	}
	
	public void deletar() {
		String sql = "Delete from autor where id=?"; 
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
