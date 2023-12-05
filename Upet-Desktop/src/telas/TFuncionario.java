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

import classe.Funcionario;
import dao.FuncionarioDao;


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

public class TFuncionario extends JFrame {

	/**v
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private Funcionario funcionario;
	private FuncionarioDao funcionarioDao;
	private DefaultTableModel modelo;
	private List<Funcionario> lista;
	private JTextField txfEmail;
	private JTextField txfTelefone;
	private JTextField txfEndereco;
	private JTextField txfNome;
	private JTextField txfId;
	private JTextField txfSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TFuncionario frame = new TFuncionario();
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
	public TFuncionario() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\dougl\\Downloads\\Upet\\icon\\upet.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 896, 685);
		
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
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Clientes");
		mntmNewMenuItem_1.setIcon(new ImageIcon("C:\\Users\\dougl\\Downloads\\Upet\\icon\\aperto-de-mao.png"));
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TCliente tc = new TCliente();
				tc.setVisible(true);
				tc.setLocationRelativeTo(null);
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
		contentPane.setForeground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 290, 836, 268);
		contentPane.add(scrollPane);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				Integer selecionado = table.getSelectionModel().getMaxSelectionIndex();
				funcionario = lista.get(selecionado);
				txfId.setText(funcionario.getIdfuncionario().toString());
				txfNome.setText(funcionario.getNome());
				txfEndereco.setText(funcionario.getEndereco());
				txfTelefone.setText(funcionario.getTelefone());
				txfEmail.setText(funcionario.getEmail());
				txfSenha.setText(funcionario.getSenha());
			}
		});
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] {}));
		scrollPane.setViewportView(table);
		
		JPanel panel = new JPanel();
		panel.setBounds(20, 90, 836, 189);
		contentPane.add(panel);
		panel.setLayout(null);
		
		txfEmail = new JTextField();
		txfEmail.setText((String) null);
		txfEmail.setColumns(10);
		txfEmail.setBounds(385, 95, 260, 20);
		panel.add(txfEmail);
		
		JLabel lblNewLabel_3 = new JLabel("E-mail:");
		lblNewLabel_3.setBounds(385, 76, 46, 14);
		panel.add(lblNewLabel_3);
		
		txfTelefone = new JTextField();
		txfTelefone.setText((String) null);
		txfTelefone.setColumns(10);
		txfTelefone.setBounds(385, 41, 161, 20);
		panel.add(txfTelefone);
		
		JLabel lblNewLabel_2 = new JLabel("Telefone:");
		lblNewLabel_2.setBounds(385, 22, 79, 14);
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
		txfSenha.setBounds(385, 149, 161, 20);
		panel.add(txfSenha);
		
		JLabel lblNewLabel_3_1 = new JLabel("Senha:");
		lblNewLabel_3_1.setBounds(385, 128, 46, 14);
		panel.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_4 = new JLabel("Funcion\u00E1rios");
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_4.setBounds(20, 64, 110, 15);
		contentPane.add(lblNewLabel_4);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(20, 569, 836, 33);
		contentPane.add(panel_1);
		
		JButton btnNewButton_1 = new JButton("Salvar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					funcionario = new Funcionario();
					funcionario.setNome(txfNome.getText());
					funcionario.setEndereco(txfEndereco.getText());
					funcionario.setTelefone(txfTelefone.getText());
					funcionario.setEmail(txfEmail.getText());
					funcionario.setSenha(txfSenha.getText());
					
					funcionarioDao = new FuncionarioDao();
					funcionarioDao.incluir(funcionario);
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
					funcionario = new Funcionario();
					funcionario.setIdfuncionario(Integer.parseInt(txfId.getText()));
					funcionario.setNome(txfNome.getText());
					funcionario.setEndereco(txfEndereco.getText());
					funcionario.setTelefone(txfTelefone.getText());
					funcionario.setEmail(txfEmail.getText());
					funcionario.setSenha(txfSenha.getText());
					funcionarioDao = new FuncionarioDao();
					funcionarioDao.alterar(funcionario);
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
						funcionario = new Funcionario();
						funcionario.setIdfuncionario(Integer.parseInt(txfId.getText()));
						funcionarioDao = new FuncionarioDao();
						funcionarioDao.excluir(funcionario);
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
		lblNewLabel_6.setBounds(20, 11, 91, 42);
		contentPane.add(lblNewLabel_6);
		popularTabela();
		limpar();
	}
	
	public void limpar() {
		txfId.setText(null);
		txfNome.setText(null);
		txfEndereco.setText(null);
		txfTelefone.setText(null);
		txfEmail.setText(null);
		txfSenha.setText(null);
	}

	private void popularTabela() {
		try {
			funcionarioDao = new FuncionarioDao();
			lista = funcionarioDao.buscarTodos();
			modelo = new DefaultTableModel();
			modelo.addColumn("Nome");
			modelo.addColumn("Endereco");
			modelo.addColumn("Telefone");
			modelo.addColumn("E-mail");
			modelo.addColumn("Senha");
			for (Funcionario funcionario : lista) {
				modelo.addRow(new String[] { funcionario.getNome(), funcionario.getEndereco(),
						funcionario.getTelefone(), funcionario.getEmail(), funcionario.getSenha() });
			}
			table.setModel(modelo);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro: " + e);
		}
	}
}
