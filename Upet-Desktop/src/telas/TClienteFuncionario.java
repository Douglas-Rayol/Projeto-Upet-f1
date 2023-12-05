package telas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import classe.Cliente;
import dao.ClienteDao;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;

public class TClienteFuncionario extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private ClienteDao clienteDao;
	private DefaultTableModel modelo;
	private List<Cliente> lista;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TClienteFuncionario frame = new TClienteFuncionario();
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
	public TClienteFuncionario() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\dougl\\Downloads\\Upet\\icon\\upet.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1089, 685);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Upet");
		mnNewMenu.setIcon(new ImageIcon("C:\\Users\\dougl\\Downloads\\Upet\\icon\\upet.png"));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Produtos");
		mntmNewMenuItem.setIcon(new ImageIcon("C:\\Users\\dougl\\Downloads\\Upet\\icon\\caixa.png"));
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TProdutoFuncionario tf = new TProdutoFuncionario();
				tf.setVisible(true);
				tf.setLocationRelativeTo(null);
				dispose();
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenu mnNewMenu_1 = new JMenu("Sobre");
		mnNewMenu_1.setIcon(new ImageIcon("C:\\Users\\dougl\\Downloads\\Upet\\icon\\interocação.png"));
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Ajuda");
		mntmNewMenuItem_1.setIcon(new ImageIcon("C:\\Users\\dougl\\Downloads\\Upet\\icon\\interocação.png"));
		mnNewMenu_1.add(mntmNewMenuItem_1);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 165, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 98, 1024, 502);
		contentPane.add(scrollPane);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] {}));
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_4 = new JLabel("Clientes");
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_4.setBounds(20, 72, 110, 15);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\dougl\\Downloads\\Upet\\icon\\logo_upet.png"));
		lblNewLabel.setBounds(20, 11, 99, 50);
		contentPane.add(lblNewLabel);
		popularTabela();
		limpar();
	}
	
	public void limpar() {
	}

	private void popularTabela() {
		try {
			clienteDao = new ClienteDao();
			lista = clienteDao.buscarTodos();
			modelo = new DefaultTableModel();
			modelo.addColumn("Nome");
			modelo.addColumn("Endereco");
			modelo.addColumn("Telefone");
			modelo.addColumn("Senha");
			modelo.addColumn("E-mail");
			modelo.addColumn("CPF");
			modelo.addColumn("Cidade");
			modelo.addColumn("Estado");
			modelo.addColumn("CEP");
			for (Cliente cliente : lista) {
				modelo.addRow(new String[] { cliente.getNome(), cliente.getEndereco(),
						cliente.getTelefone(), cliente.getSenha(), cliente.getEmail(),
						cliente.getCpf(), cliente.getCidade(), cliente.getEstado(), cliente.getCep()});
			}
			table.setModel(modelo);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro: " + e);
		}
	}
}
