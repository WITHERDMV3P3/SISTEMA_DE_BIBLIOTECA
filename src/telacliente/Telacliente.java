package telacliente;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.border.CompoundBorder;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.JTable;
import javax.swing.JLayeredPane;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.ComponentOrientation;

public class Telacliente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnInserirCliente;
	private JButton btnDeletarCliente;
	private JButton btnAlterarCliente;
	private JPanel panel;
	private JTextArea textArea;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Telacliente chamartela = new Telacliente();
		chamartela.chamar();
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
					Telacliente frame = new Telacliente();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Telacliente() {
		setTitle("TELA CLIENTE");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 817, 511);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 128, 255));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(54, 11, 663, 72);
		panel.setToolTipText("");
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "OP\u00C7\u00D5ES CLIENTE", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBackground(new Color(0,0,0,0));
		contentPane.add(panel);
		panel.setLayout(null);
		
		btnInserirCliente = new JButton("INSERIR CLIENTE");
		btnInserirCliente.setBounds(53, 23, 151, 38);
		panel.add(btnInserirCliente);
		btnInserirCliente.setToolTipText("");
		btnInserirCliente.setContentAreaFilled(false);
		btnInserirCliente.setOpaque(true);
		btnInserirCliente.setBackground(Color.green);
		btnInserirCliente.setFont(new Font("Arial", Font.BOLD, 14));
		
		btnDeletarCliente = new JButton("DELETAR CLIENTE");
		btnDeletarCliente.setBounds(244, 23, 167, 38);
		panel.add(btnDeletarCliente);
		btnDeletarCliente.setToolTipText("");
		btnDeletarCliente.setContentAreaFilled(false);
		btnDeletarCliente.setOpaque(true);
		btnDeletarCliente.setBackground(Color.red);
		btnDeletarCliente.setFont(new Font("Arial", Font.BOLD, 14));
		
		btnAlterarCliente = new JButton("ALTERAR CLIENTE");
		btnAlterarCliente.setBounds(453, 23, 167, 38);
		panel.add(btnAlterarCliente);
		btnAlterarCliente.setToolTipText("");
		btnAlterarCliente.setContentAreaFilled(false);
		btnAlterarCliente.setOpaque(true);
		btnAlterarCliente.setBackground(Color.lightGray);
		btnAlterarCliente.setFont(new Font("Arial", Font.BOLD, 14));
		
		textArea = new JTextArea();
		textArea.setBounds(54, 94, 663, 367);
		contentPane.add(textArea);
		
		table = new JTable();
		table.setBounds(0, 0, 1, 1);
		contentPane.add(table);
	}
}
