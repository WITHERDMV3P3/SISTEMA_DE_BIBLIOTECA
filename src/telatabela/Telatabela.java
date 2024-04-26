package telatabela;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class Telatabela extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnInserirLivro;
	private JButton btnDeletarLivro;
	private JButton btnAlterarLivro;
	private JTextArea textArea;
	private JTable tableLivro;
	private JPanel panel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Telatabela chamar = new Telatabela();
		chamar.chamar();
	}
	
	public void chamar() {
		try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Throwable e) {
            e.printStackTrace();
        }
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					 UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					 Telatabela frame = new Telatabela();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Telatabela() {
		setTitle("TELA AUTORES");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 817, 511);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 128, 255));
		contentPane.setBorder(new CompoundBorder());

		setContentPane(contentPane);
		contentPane.setLayout(null);
		textArea = new JTextArea();
		textArea.setBounds(54, 94, 663, 367);
		contentPane.add(textArea);
		
		tableLivro = new JTable();
		tableLivro.setBounds(39, 0, 1, 1);
		contentPane.add(tableLivro);
		
		panel = new JPanel();
		panel.setBounds(54, 11, 663, 72);
		panel.setToolTipText("");
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "OP\u00C7\u00D5ES TABELA", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBackground(new Color(0,0,0,0));
		contentPane.add(panel);
		panel.setLayout(null);
		
		btnInserirLivro = new JButton("INSERIR AUTOR");
		btnInserirLivro.setBounds(53, 23, 151, 38);
		panel.add(btnInserirLivro);
		btnInserirLivro.setToolTipText("");
		btnInserirLivro.setContentAreaFilled(false);
		btnInserirLivro.setOpaque(true);
		btnInserirLivro.setBackground(Color.green);
		btnInserirLivro.setFont(new Font("Arial", Font.BOLD, 14));
		
		btnDeletarLivro = new JButton("DELETAR AUTOR");
		btnDeletarLivro.setBounds(244, 23, 167, 38);
		panel.add(btnDeletarLivro);
		btnDeletarLivro.setToolTipText("");
		btnDeletarLivro.setContentAreaFilled(false);
		btnDeletarLivro.setOpaque(true);
		btnDeletarLivro.setBackground(Color.red);
		btnDeletarLivro.setFont(new Font("Arial", Font.BOLD, 14));
		
		btnAlterarLivro = new JButton("ALTERAR AUTOR");
		btnAlterarLivro.setBounds(453, 23, 167, 38);
		panel.add(btnAlterarLivro);
		btnAlterarLivro.setToolTipText("");
		btnAlterarLivro.setContentAreaFilled(false);
		btnAlterarLivro.setOpaque(true);
		btnAlterarLivro.setBackground(Color.lightGray);
		btnAlterarLivro.setFont(new Font("Arial", Font.BOLD, 14));
	}

}
