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

import classe.Produto;
import dao.ProdutoDao;


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

public class TProduto extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private Produto produto;
	private ProdutoDao produtoDao;
	private DefaultTableModel modelo;
	private List<Produto> lista;
	private JTextField txfPreco;
	private JTextField txfNome;
	private JTextField txfId;
	private JTextField txfDescricao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TProduto frame = new TProduto();
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
	public TProduto() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\dougl\\Downloads\\Upet\\icon\\upet.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 896, 685);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Upet");
		mnNewMenu.setIcon(new ImageIcon("C:\\Users\\dougl\\Downloads\\Upet\\icon\\upet.png"));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Funcion\u00E1rios");
		mntmNewMenuItem.setIcon(new ImageIcon("C:\\Users\\dougl\\Downloads\\Upet\\icon\\grupo.png"));
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TFuncionario tf = new TFuncionario();
				tf.setVisible(true);
				tf.setLocationRelativeTo(null);
				dispose();
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Clientes");
		mntmNewMenuItem_1.setIcon(new ImageIcon("C:\\Users\\dougl\\Downloads\\Upet\\icon\\aperto-de-mao.png"));
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TCliente tf = new TCliente();
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
		scrollPane.setBounds(20, 290, 836, 268);
		contentPane.add(scrollPane);
		
		JPanel panel = new JPanel();
		panel.setBounds(20, 87, 836, 192);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Descri\u00E7\u00E3o:");
		lblNewLabel_2.setBounds(386, 76, 79, 14);
		panel.add(lblNewLabel_2);
		
		txfPreco = new JTextField();
		txfPreco.setText((String) null);
		txfPreco.setColumns(10);
		txfPreco.setBounds(10, 149, 278, 20);
		panel.add(txfPreco);
		
		JLabel lblNewLabel_1 = new JLabel("Pre\u00E7o:");
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
		
		txfDescricao = new JTextField();
		txfDescricao.setText((String) null);
		txfDescricao.setColumns(10);
		txfDescricao.setBounds(386, 95, 278, 20);
		panel.add(txfDescricao);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				Integer selecionado = table.getSelectionModel().getMaxSelectionIndex();
				produto = lista.get(selecionado);
				txfId.setText(produto.getId().toString());
				txfNome.setText(produto.getNome());
				txfPreco.setText(produto.getPreco().toString());
				txfDescricao.setText(produto.getDescricao());
			}
		});
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] {}));
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_4 = new JLabel("Produtos");
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_4.setBounds(20, 61, 81, 15);
		contentPane.add(lblNewLabel_4);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(20, 569, 836, 33);
		contentPane.add(panel_1);
		
		JButton btnNewButton_1 = new JButton("Salvar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					produto = new Produto();
					produto.setNome(txfNome.getText());
					produto.setPreco(Double.parseDouble(txfPreco.getText()));
					produto.setDescricao(txfDescricao.getText());
					
					produtoDao = new ProdutoDao();
					produtoDao.incluir(produto);
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
					produto = new Produto();
					produto.setId(Integer.parseInt(txfId.getText()));
					produto.setNome(txfNome.getText());
					produto.setPreco(Double.parseDouble(txfPreco.getText()));
					produto.setDescricao(txfDescricao.getText());

					produtoDao = new ProdutoDao();
					produtoDao.alterar(produto);
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
						produto = new Produto();
						produto.setId(Integer.parseInt(txfId.getText()));
						produtoDao = new ProdutoDao();
						produtoDao.excluir(produto);
						popularTabela();
						limpar();
					}
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Erro" + ex);
				}
			}
		});
		panel_1.add(btnNewButton_3);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\dougl\\Downloads\\Upet\\icon\\logo_upet.png"));
		lblNewLabel_3.setBounds(20, 11, 104, 39);
		contentPane.add(lblNewLabel_3);
		popularTabela();
		limpar();
	}
	
	public void limpar() {
		txfId.setText(null);
		txfNome.setText(null);
		txfPreco.setText(null);
		txfDescricao.setText(null);
	}

	private void popularTabela() {
		try {
			produtoDao = new ProdutoDao();
			lista = produtoDao.buscarTodos();
			modelo = new DefaultTableModel();
			modelo.addColumn("Nome");
			modelo.addColumn("Descricao");
			modelo.addColumn("Preco");
			for (Produto produto : lista) {
				modelo.addRow(new String[] { produto.getNome(), produto.getDescricao(),
						produto.getPreco().toString() });
			}
			table.setModel(modelo);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro: " + e);
		}
	}
}
