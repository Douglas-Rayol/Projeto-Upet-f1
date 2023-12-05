package telas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import classe.Cliente;
import dao.ClienteDao;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;

public class TCliente extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private Cliente cliente;
	private ClienteDao clienteDao;
	private DefaultTableModel modelo;
	private List<Cliente> lista;
	private JTextField txfEmail;
	private JTextField txfTelefone;
	private JTextField txfEndereco;
	private JTextField txfNome;
	private JTextField txfId;
	private JTextField txfSenha;
	private JTextField txfEstado;
	private JTextField txfCidade;
	private JTextField txfCpf;
	private JTextField txfCep;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TCliente frame = new TCliente();
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
	public TCliente() {
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
				TProduto tp = new TProduto();
				tp.setVisible(true);
				tp.setLocationRelativeTo(null);
				dispose();
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Funcion\u00E1rios");
		mntmNewMenuItem_1.setIcon(new ImageIcon("C:\\Users\\dougl\\Downloads\\Upet\\icon\\grupo.png"));
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TFuncionario tf = new TFuncionario();
				tf.setVisible(true);
				tf.setLocationRelativeTo(null);
				dispose();
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenu mnNewMenu_1 = new JMenu("Sobre");
		mnNewMenu_1.setIcon(new ImageIcon("C:\\Users\\dougl\\Downloads\\Upet\\icon\\interocação.png"));
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Ajuda");
		mntmNewMenuItem_2.setIcon(new ImageIcon("C:\\Users\\dougl\\Downloads\\Upet\\icon\\interocação.png"));
		mnNewMenu_1.add(mntmNewMenuItem_2);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 165, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 340, 1024, 218);
		contentPane.add(scrollPane);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				Integer selecionado = table.getSelectionModel().getMaxSelectionIndex();
				cliente = lista.get(selecionado);
				txfId.setText(cliente.getIdcliente().toString());
				txfNome.setText(cliente.getNome());
				txfEndereco.setText(cliente.getEndereco());
				txfTelefone.setText(cliente.getTelefone());
				txfSenha.setText(cliente.getSenha());
				txfEmail.setText(cliente.getEmail());
				txfCpf.setText(cliente.getCpf());
				txfCidade.setText(cliente.getCidade());
				txfEstado.setText(cliente.getEstado());
				txfCep.setText(cliente.getCep());
			}
		});
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] {}));
		scrollPane.setViewportView(table);
		
		JPanel panel = new JPanel();
		panel.setBounds(20, 89, 1024, 240);
		contentPane.add(panel);
		panel.setLayout(null);
		
		txfEmail = new JTextField();
		txfEmail.setText((String) null);
		txfEmail.setColumns(10);
		txfEmail.setBounds(350, 147, 260, 20);
		panel.add(txfEmail);
		
		JLabel lblNewLabel_3 = new JLabel("Email:");
		lblNewLabel_3.setBounds(350, 128, 46, 14);
		panel.add(lblNewLabel_3);
		
		txfTelefone = new JTextField();
		txfTelefone.setText((String) null);
		txfTelefone.setColumns(10);
		txfTelefone.setBounds(350, 93, 161, 20);
		panel.add(txfTelefone);
		
		JLabel lblNewLabel_2 = new JLabel("Telefone:");
		lblNewLabel_2.setBounds(350, 74, 79, 14);
		panel.add(lblNewLabel_2);
		
		txfEndereco = new JTextField();
		txfEndereco.setText((String) null);
		txfEndereco.setColumns(10);
		txfEndereco.setBounds(10, 149, 278, 20);
		panel.add(txfEndereco);
		
		JLabel lblNewLabel_1 = new JLabel("Endere\u00E7o:");
		lblNewLabel_1.setBounds(10, 128, 79, 14);
		panel.add(lblNewLabel_1);
		
		txfNome = new JTextField();
		txfNome.setText((String) null);
		txfNome.setColumns(10);
		txfNome.setBounds(10, 95, 278, 20);
		panel.add(txfNome);
		
		JLabel lblNewLabel = new JLabel("Nome:");
		lblNewLabel.setBounds(10, 72, 46, 23);
		panel.add(lblNewLabel);
		
		txfId = new JTextField();
		txfId.setEnabled(false);
		txfId.setText((String) null);
		txfId.setColumns(10);
		txfId.setBounds(10, 41, 79, 20);
		panel.add(txfId);
		
		JLabel lblNewLabel_5 = new JLabel("Id:");
		lblNewLabel_5.setBounds(10, 18, 46, 23);
		panel.add(lblNewLabel_5);
		
		txfSenha = new JTextField();
		txfSenha.setText((String) null);
		txfSenha.setColumns(10);
		txfSenha.setBounds(350, 201, 260, 20);
		panel.add(txfSenha);
		
		JLabel lblNewLabel_3_1 = new JLabel("Senha:");
		lblNewLabel_3_1.setBounds(350, 180, 46, 14);
		panel.add(lblNewLabel_3_1);
		
		txfEstado = new JTextField();
		txfEstado.setText((String) null);
		txfEstado.setColumns(10);
		txfEstado.setBounds(671, 201, 161, 20);
		panel.add(txfEstado);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("Estado:");
		lblNewLabel_3_1_1.setBounds(671, 180, 46, 14);
		panel.add(lblNewLabel_3_1_1);
		
		txfCidade = new JTextField();
		txfCidade.setText((String) null);
		txfCidade.setColumns(10);
		txfCidade.setBounds(671, 147, 260, 20);
		panel.add(txfCidade);
		
		JLabel lblNewLabel_3_2 = new JLabel("Cidade:");
		lblNewLabel_3_2.setBounds(671, 128, 46, 14);
		panel.add(lblNewLabel_3_2);
		
		txfCpf = new JTextField();
		txfCpf.setText((String) null);
		txfCpf.setColumns(10);
		txfCpf.setBounds(671, 93, 161, 20);
		panel.add(txfCpf);
		
		JLabel lblNewLabel_2_1 = new JLabel("CPF:");
		lblNewLabel_2_1.setBounds(671, 74, 79, 14);
		panel.add(lblNewLabel_2_1);
		
		txfCep = new JTextField();
		txfCep.setText((String) null);
		txfCep.setColumns(10);
		txfCep.setBounds(10, 201, 161, 20);
		panel.add(txfCep);
		
		JLabel lblNewLabel_3_1_1_1 = new JLabel("CEP:");
		lblNewLabel_3_1_1_1.setBounds(10, 180, 46, 14);
		panel.add(lblNewLabel_3_1_1_1);
		
		JLabel lblNewLabel_4 = new JLabel("Clientes");
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_4.setBounds(20, 63, 110, 15);
		contentPane.add(lblNewLabel_4);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(20, 569, 1024, 33);
		contentPane.add(panel_1);
		
		JButton btnNewButton_1 = new JButton("Salvar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					cliente = new Cliente();
					cliente.setNome(txfNome.getText());
					cliente.setEndereco(txfEndereco.getText());
					cliente.setTelefone(txfTelefone.getText());
					cliente.setSenha(txfSenha.getText());
					cliente.setEmail(txfEmail.getText());
					cliente.setCpf(txfCpf.getText());
					cliente.setCidade(txfCidade.getText());
					cliente.setEstado(txfEstado.getText());
					cliente.setCep(txfCep.getText());
					
					clienteDao = new ClienteDao();
					clienteDao.incluir(cliente);
					popularTabela();
					limpar();
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Erro: " + ex);
				}
			}
		});
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Alterar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					cliente = new Cliente();
					cliente.setIdcliente(Integer.parseInt(txfId.getText()));
					cliente.setNome(txfNome.getText());
					cliente.setEndereco(txfEndereco.getText());
					cliente.setTelefone(txfTelefone.getText());
					cliente.setSenha(txfSenha.getText());
					cliente.setEmail(txfEmail.getText());
					cliente.setCpf(txfCpf.getText());
					cliente.setCidade(txfCidade.getText());
					cliente.setEstado(txfEstado.getText());
					cliente.setCep(txfCep.getText());
					clienteDao = new ClienteDao();
					clienteDao.alterar(cliente);
					popularTabela();
					limpar();
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Erro: " + ex);
				}
			}
		});
		panel_1.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Excluir");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Integer resp = JOptionPane.showConfirmDialog(null, "Deseja excluir");
					if(resp == 0) {
						cliente = new Cliente();
						cliente.setIdcliente(Integer.parseInt(txfId.getText()));
						clienteDao = new ClienteDao();
						clienteDao.excluir(cliente);
						popularTabela();
						limpar();
					}
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Erro" + ex);
				}
			}
		});
		panel_1.add(btnNewButton_3);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon("C:\\Users\\dougl\\Downloads\\Upet\\icon\\logo_upet.png"));
		lblNewLabel_6.setBounds(20, 11, 87, 41);
		contentPane.add(lblNewLabel_6);
		popularTabela();
		limpar();
	}
	
	public void limpar() {
		txfId.setText(null);
		txfNome.setText(null);
		txfEndereco.setText(null);
		txfTelefone.setText(null);
		txfSenha.setText(null);
		txfEmail.setText(null);
		txfCpf.setText(null);
		txfCidade.setText(null);
		txfEstado.setText(null);
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
