package panelcliente;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Window.Type;

public class Inserircliente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabelnome;
	private JTextField nome;
	private JLabel lblNewLabeldatanascimento;
	private JTextField datanascimento;
	private JLabel lblNewLabeltelefone;
	private JTextField telefone;
	private JLabel lblNewLabelemail;
	private JTextField email;
	private JLabel lblNewLabelcpf;
	private JTextField cpf;
	private JLabel lblNewLabelend;
	private JTextField endereço;
	private JButton btnInserirCliente;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Throwable e) {
            e.printStackTrace();
        }
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inserircliente frame = new Inserircliente();
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
	public Inserircliente() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 600, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabelnome = new JLabel("*Nome:");
		lblNewLabelnome.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblNewLabelnome.setBounds(36, 11, 293, 20);
		contentPane.add(lblNewLabelnome);
		
		nome = new JTextField();
		nome.setFont(new Font("Calibri", Font.PLAIN, 14));
		nome.setBounds(36, 26, 293, 24);
		contentPane.add(nome);
		nome.setColumns(10);
		
		lblNewLabeldatanascimento = new JLabel("Data de nascimento:");
		lblNewLabeldatanascimento.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblNewLabeldatanascimento.setBounds(36, 54, 163, 20);
		contentPane.add(lblNewLabeldatanascimento);
		
		datanascimento = new JTextField();
		datanascimento.setFont(new Font("Calibri", Font.PLAIN, 14));
		datanascimento.setColumns(10);
		datanascimento.setBounds(36, 70, 293, 24);
		contentPane.add(datanascimento);
		
		lblNewLabeltelefone = new JLabel("Telefone:");
		lblNewLabeltelefone.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblNewLabeltelefone.setBounds(364, 51, 103, 26);
		contentPane.add(lblNewLabeltelefone);
		
		telefone = new JTextField();
		telefone.setFont(new Font("Calibri", Font.PLAIN, 14));
		telefone.setColumns(10);
		telefone.setBounds(364, 72, 179, 22);
		contentPane.add(telefone);
		
		lblNewLabelemail = new JLabel("Email:");
		lblNewLabelemail.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblNewLabelemail.setBounds(36, 99, 103, 20);
		contentPane.add(lblNewLabelemail);
		
		email = new JTextField();
		email.setFont(new Font("Calibri", Font.PLAIN, 14));
		email.setColumns(10);
		email.setBounds(36, 116, 293, 24);
		contentPane.add(email);
		
		lblNewLabelcpf = new JLabel("*CPF:");
		lblNewLabelcpf.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblNewLabelcpf.setBounds(364, 11, 103, 17);
		contentPane.add(lblNewLabelcpf);
		
		cpf = new JTextField();
		cpf.setFont(new Font("Calibri", Font.PLAIN, 14));
		cpf.setColumns(10);
		cpf.setBounds(364, 26, 179, 24);
		contentPane.add(cpf);
		
		lblNewLabelend = new JLabel("Endereço:");
		lblNewLabelend.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblNewLabelend.setBounds(36, 145, 103, 20);
		contentPane.add(lblNewLabelend);
		
		endereço = new JTextField();
		endereço.setFont(new Font("Calibri", Font.PLAIN, 14));
		endereço.setColumns(10);
		endereço.setBounds(36, 162, 378, 24);
		contentPane.add(endereço);
		
		btnInserirCliente = new JButton("Inserir Cliente");
		btnInserirCliente.setHorizontalTextPosition(SwingConstants.LEADING);
		btnInserirCliente.setToolTipText("");
		btnInserirCliente.setIcon(new ImageIcon(Cliente.class.getResource("/Imagens/adicionar (1).png")));
		btnInserirCliente.setOpaque(true);
		btnInserirCliente.setFont(new Font("Arial", Font.BOLD, 14));
		btnInserirCliente.setBackground(new Color(0, 204, 0));
		btnInserirCliente.setBounds(222, 212, 161, 38);
		contentPane.add(btnInserirCliente);
	}
}
