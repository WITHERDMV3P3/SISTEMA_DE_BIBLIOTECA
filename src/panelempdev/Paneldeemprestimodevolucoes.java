package panelempdev;


import java.awt.Color;
import java.awt.Font;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import conexoes.Conexaobancobib;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

import javax.swing.JScrollPane;

public class Paneldeemprestimodevolucoes extends JPanel {

	Conexaobancobib dao = new Conexaobancobib();
	private Connection con;
	
	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private JButton btnInserirEmprestimo;
	private JButton btnDeletarEmpDev;
	private JButton btnAlterarEmpDev;
	private JLabel lblNewLabel;
	private JPanel panel_1;
	JTable table;
	private JScrollPane scrollPane;

	/**
	 * Create the panel.
	 */
	public Paneldeemprestimodevolucoes() {
		setSize(791,605);
		setBackground(new Color(255, 255, 255));
		setLayout(null);
		
		panel = new JPanel();
		panel.setToolTipText("Opções para inserir, atualizar,alterar e deletar dados.");
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "OP\u00C7\u00D5ES", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBackground(new Color(0, 0, 0, 0));
		panel.setBounds(28, 76, 741, 112);
		add(panel);
		
		
		btnInserirEmprestimo = new JButton("<html><center>Inserir<br> Empréstimo<html><center>");
		btnInserirEmprestimo.setHorizontalTextPosition(SwingConstants.LEADING);
		btnInserirEmprestimo.setIcon(new ImageIcon(Paneldeemprestimodevolucoes.class.getResource("/Imagens/adicionar (1).png")));
		btnInserirEmprestimo.setToolTipText("Inserir dados do empréstimo");
		btnInserirEmprestimo.setFont(new Font("Arial", Font.BOLD, 14));
		btnInserirEmprestimo.setOpaque(true);
		btnInserirEmprestimo.setBackground(new Color(0, 204, 0));
		btnInserirEmprestimo.setBounds(10, 15, 161, 38);
		panel.add(btnInserirEmprestimo);
		btnInserirEmprestimo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				chamartela("Inserir emprestimo");
			}
		});
		
		btnDeletarEmpDev = new JButton("<html><center>Deletar Dados <br> da Tabela<html><center>");
		btnDeletarEmpDev.setHorizontalTextPosition(SwingConstants.LEADING);
		btnDeletarEmpDev.setIcon(new ImageIcon(Paneldeemprestimodevolucoes.class.getResource("/Imagens/botao-apagar.png")));
		btnDeletarEmpDev.setToolTipText("Deletar dados de empréstimo e devolucões da tabela");
		btnDeletarEmpDev.setFont(new Font("Arial", Font.BOLD, 14));
		btnDeletarEmpDev.setOpaque(true);
		btnDeletarEmpDev.setBackground(Color.RED);
		btnDeletarEmpDev.setBounds(552, 15, 179, 38);
		panel.add(btnDeletarEmpDev);
		btnDeletarEmpDev.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				avisodeletar();
				
			}
		});
		
		scrollPane = new JScrollPane();
		scrollPane.setToolTipText("Tabela onde contêm dados de empréstimo e devolução");
		scrollPane.setBounds(28, 192, 741, 380);
		add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "CLIENTE", "LIVRO", "DATA EMPRESTIMO", "DATA PREVISÃO", "DATA DE DEVOLUÇÃO"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(28);
		table.getColumnModel().getColumn(1).setPreferredWidth(147);
		table.getColumnModel().getColumn(2).setPreferredWidth(103);
		table.getColumnModel().getColumn(3).setPreferredWidth(113);
		table.getColumnModel().getColumn(4).setPreferredWidth(96);
		table.getColumnModel().getColumn(5).setPreferredWidth(120);
		
		lblNewLabel = new JLabel("Empréstimos e Devoluções");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 23));
		lblNewLabel.setBounds(10, 42, 771, 23);
		add(lblNewLabel);
		
		panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 204, 255));
		panel_1.setBounds(0, 380, 15, 59);
		add(panel_1);
		
		btnAlterarEmpDev = new JButton("<html><center>Alterar Dados <br> da Tabela<html><center>");
		btnAlterarEmpDev.setHorizontalTextPosition(SwingConstants.LEADING);
		btnAlterarEmpDev.setIcon(new ImageIcon(Paneldeemprestimodevolucoes.class.getResource("/Imagens/escreva (1).png")));
		btnAlterarEmpDev.setToolTipText("Alteração de dados de empréstimos e devoluções");
		btnAlterarEmpDev.setFont(new Font("Arial", Font.BOLD, 14));
		btnAlterarEmpDev.setOpaque(true);
		btnAlterarEmpDev.setBackground(new Color(255, 255, 0));
		btnAlterarEmpDev.setBounds(376, 15, 166, 38);
		panel.add(btnAlterarEmpDev);
		btnAlterarEmpDev.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				chamartela("Alterar");
			}
		});
		
		JButton btnInserirDevolucoes = new JButton("<html><center>Inserir <br>Devoluções <html><center>");
		btnInserirDevolucoes.setIcon(new ImageIcon(Paneldeemprestimodevolucoes.class.getResource("/Imagens/adicionar (1).png")));
		btnInserirDevolucoes.setToolTipText("Inserir dados de devolução");
		btnInserirDevolucoes.setOpaque(true);
		btnInserirDevolucoes.setHorizontalTextPosition(SwingConstants.LEADING);
		btnInserirDevolucoes.setFont(new Font("Arial", Font.BOLD, 14));
		btnInserirDevolucoes.setBackground(new Color(0, 204, 0));
		btnInserirDevolucoes.setBounds(191, 15, 175, 38);
		panel.add(btnInserirDevolucoes);
		btnInserirDevolucoes.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				chamartela("Inserir devolucao");
			}
		});
		
		JButton btnAtualizar = new JButton("Atualizar Tabela");
		btnAtualizar.setIcon(new ImageIcon(Paneldeemprestimodevolucoes.class.getResource("/Imagens/refresh.png")));
		btnAtualizar.setToolTipText("<html><center>Atualizar a tabela de empréstimo e devolução <br>para verificação de inserção ou atualização de dados<html><center>");
		btnAtualizar.setOpaque(true);
		btnAtualizar.setHorizontalTextPosition(SwingConstants.LEADING);
		btnAtualizar.setFont(new Font("Arial", Font.BOLD, 14));
		btnAtualizar.setBackground(Color.BLACK);
		btnAtualizar.setBounds(53, 64, 175, 38);
		panel.add(btnAtualizar);
		
		JButton btnImprimirempAtivos = new JButton("<html><center>Imprimir <br>Empréstimos Ativos<html><center>");
		btnImprimirempAtivos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				emprestimoativo();
			}
		});
		btnImprimirempAtivos.setIcon(new ImageIcon(Paneldeemprestimodevolucoes.class.getResource("/Imagens/imprimir-sinal-de-ferramenta-de-interface-preenchida.png")));
		btnImprimirempAtivos.setToolTipText("<html><center>Imprimir a tabela de empréstimo e devolução <br>para verificar empréstimos ativos<html><center>");
		btnImprimirempAtivos.setOpaque(true);
		btnImprimirempAtivos.setHorizontalTextPosition(SwingConstants.LEADING);
		btnImprimirempAtivos.setFont(new Font("Arial", Font.BOLD, 14));
		btnImprimirempAtivos.setBackground(Color.BLACK);
		btnImprimirempAtivos.setBounds(256, 64, 210, 38);
		panel.add(btnImprimirempAtivos);
		
		JButton btnImprimirempVencidos = new JButton("<html><center>Imprimir <br>Empréstimos Vencidos<html><center>");
		btnImprimirempVencidos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				emprestimovencido();
			}
		});
		btnImprimirempVencidos.setIcon(new ImageIcon(Paneldeemprestimodevolucoes.class.getResource("/Imagens/imprimir-sinal-de-ferramenta-de-interface-preenchida.png")));
		btnImprimirempVencidos.setToolTipText("<html><center>Imprimir a tabela de empréstimo e devolução <br>para verificar empréstimos vencidos<html><center>");
		btnImprimirempVencidos.setOpaque(true);
		btnImprimirempVencidos.setHorizontalTextPosition(SwingConstants.LEADING);
		btnImprimirempVencidos.setFont(new Font("Arial", Font.BOLD, 14));
		btnImprimirempVencidos.setBackground(Color.BLACK);
		btnImprimirempVencidos.setBounds(489, 64, 228, 38);
		panel.add(btnImprimirempVencidos);
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

	private void chamartela(String acaoempdev) {
		Inserirempdev inseriremprestimodevolucao = new Inserirempdev(acaoempdev);
		
		DefaultTableModel tablee = (DefaultTableModel) table.getModel();

		TableModel tabela1 = null ;
		
		tabela1 = table.getModel();
		int tabela = 0;
		
		tabela = table.getSelectedColumnCount();
		
		
		if(acaoempdev=="Alterar") {
		try {
		if(tabela==0) {
		JOptionPane.showMessageDialog(null, "Selecione uma linha da tabela para continuar", "ATENÇÃO", 0);
		}
		else if (tabela>=1){
			
		tabela1.getValueAt(table.getSelectedRow(),0).toString();
		int codigo = (int) table.getValueAt(table.getSelectedRow(),0);
		String combocliente = (String) table.getValueAt(table.getSelectedRow(),1);
		String combolivro = (String) table.getValueAt(table.getSelectedRow(),2); 
		String emprestimo = (String) table.getValueAt(table.getSelectedRow(),3);
		String previsao = (String) table.getValueAt(table.getSelectedRow(),4);
		String entrega = (String) table.getValueAt(table.getSelectedRow(),5);
		inseriremprestimodevolucao.preenchercampos(codigo,combocliente,combolivro, emprestimo, previsao ,entrega);
		inseriremprestimodevolucao.setVisible(true);
		inseriremprestimodevolucao.setLocationRelativeTo(null);
		
		
		
		JButton button = inseriremprestimodevolucao.btnInserirEmprestimo;
		
		
		button.setText("Alterar");
		button.setIcon(new ImageIcon(Paneldeemprestimodevolucoes.class.getResource("/Imagens/escreva (1).png")));
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
		
		
		
		
		else if(acaoempdev=="Inserir emprestimo") {
			
			
			
		inseriremprestimodevolucao.setVisible(true);
		inseriremprestimodevolucao.setLocationRelativeTo(null);
		JButton button = inseriremprestimodevolucao.btnInserirEmprestimo;
		button.setText("Inserir Empréstimo");
		button.setIcon(new ImageIcon(Paneldeemprestimodevolucoes.class.getResource("/Imagens/adicionar (1).png")));
		button.setBackground(new Color(0, 204, 0));

		JFormattedTextField devolucao = inseriremprestimodevolucao.Datadevolucao;
		devolucao.setEnabled(false);
		devolucao.setEditable(false);
		}
		
		
		
		
		
		else if(acaoempdev=="Inserir devolucao") {
				
				try {
					if(tabela==0) {
					JOptionPane.showMessageDialog(null, "Selecione uma linha da tabela para inserir a devolução", "ATENÇÃO", 0);
					}
					else if (tabela>=1){
						
					tabela1.getValueAt(table.getSelectedRow(),0).toString();
					int codigo = (int) table.getValueAt(table.getSelectedRow(),0);
					String combocliente = (String) table.getValueAt(table.getSelectedRow(),1);
					String combolivro = (String) table.getValueAt(table.getSelectedRow(),2);
					String emprestimo = (String) table.getValueAt(table.getSelectedRow(),3);
					String previsao = (String) table.getValueAt(table.getSelectedRow(),4);
					String entrega = (String) table.getValueAt(table.getSelectedRow(),5);
					inseriremprestimodevolucao.preenchercampos(codigo,combocliente,combolivro, emprestimo, previsao, entrega);
					inseriremprestimodevolucao.setVisible(true);
					inseriremprestimodevolucao.setLocationRelativeTo(null);
					
					
					JButton button = inseriremprestimodevolucao.btnInserirEmprestimo;
					button.setText("Inserir Devolução");
					button.setIcon(new ImageIcon(Paneldeemprestimodevolucoes.class.getResource("/Imagens/adicionar (1).png"))); //TODO VERIFICAR A LINHA E PREENCHER IGUAL A ALTERAÇÃO POREM COM OS CAMPOS NÃO VISIVEIS APENAS A DATA DE DEVOLUÇÃO
					button.setBackground(new Color(0, 204, 0));

					JFormattedTextField campoemprestimo = inseriremprestimodevolucao.Dataemprestimo;
					campoemprestimo.setEnabled(false);
					campoemprestimo.setEditable(false);
					
					JComboBox<String> cliente = inseriremprestimodevolucao.comboBoxCliente;
					cliente.setEnabled(false);
					cliente.setEditable(false);
					
					JComboBox <String> livro = inseriremprestimodevolucao.comboBoxlivro;
					livro.setEnabled(false);
					livro.setEditable(false);
					
					table.clearSelection();
					tablee.setRowCount(0);
					atualizar();
					}else if(tablee != null){
						JOptionPane.showMessageDialog(null, "Selecione uma linha da tabela para inserir a devolução", "ATENÇÃO", 0);}
					}
					catch (Exception e1){
					e1.printStackTrace();
						}		
					
					}
	}
	
	public void atualizar() {
		DefaultTableModel model = (DefaultTableModel) table.getModel();	
		model.setRowCount(0);
		
	String sql = "SELECT * from empedev";
	try { con = dao.conexaobib();
	PreparedStatement registro = con.prepareStatement(sql);
		ResultSet resultset = registro.executeQuery(sql);
		while(resultset.next()) {
		Object[] rowData = {
				resultset.getInt("id"),
				resultset.getString("usuario"),
				resultset.getString("livro"),
				resultset.getString("dataemprestimo"),
				resultset.getString("dataprevisao"),
				resultset.getString("datadevolucao")
				
		};
		model.addRow(rowData);
		
		}
	} catch (SQLException e) {
		System.out.println("ERRO AO ATUALIZAR A TABELA: "+ e.getMessage());
	}
	}
	
	public void deletar() {
		String sql = "Delete from empedev where id=?"; 
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
	
	public void emprestimoativo() {
		URL caminho = Paneldeemprestimodevolucoes.class.getResource("/relatorio/Relatorioativos.jrxml");
	//	String caminho = "C:\\Users\\CRISTIAN EDEL\\OneDrive\\Área de Trabalho\\TESTE\\SISTEMA_DE_BIBLIOTECA3\\BIBLIOTECA2\\src\\relatorio\\Relatorioativos.jrxml";
	//	String total = caminho.substring(0, caminho.lastIndexOf('\\')) + "\\relatorio\\Relatorioativos.jrxml";
		try {
			
			con = dao.conexaobib();
			JasperReport jasper;
			try {
				jasper = JasperCompileManager.compileReport(caminho.openStream());
				JasperPrint print = JasperFillManager.fillReport(jasper, null,con);
				JasperViewer.viewReport(print,false);
			} catch (JRException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void emprestimovencido() {
		URL caminho = Paneldeemprestimodevolucoes.class.getResource("/relatorio/Relatoriovencidos.jrxml");
	//	String caminho = "C:\\Users\\CRISTIAN EDEL\\OneDrive\\Área de Trabalho\\TESTE\\SISTEMA_DE_BIBLIOTECA3\\BIBLIOTECA2\\src\\relatorio\\Relatorioativos.jrxml";
	//	String total = caminho.substring(0, caminho.lastIndexOf('\\')) + "\\relatorio\\Relatorioativos.jrxml";
		try {
			
			con = dao.conexaobib();
			JasperReport jasper;
			try {
				jasper = JasperCompileManager.compileReport(caminho.openStream());
				JasperPrint print = JasperFillManager.fillReport(jasper, null,con);
				JasperViewer.viewReport(print,false);
			} catch (JRException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
