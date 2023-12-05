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

import classe.Produto;
import dao.ProdutoDao;


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

public class TProdutoFuncionario extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private ProdutoDao produtoDao;
	private DefaultTableModel modelo;
	private List<Produto> lista;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TProdutoFuncionario frame = new TProdutoFuncionario();
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
	public TProdutoFuncionario() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\dougl\\Downloads\\Upet\\icon\\upet.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 896, 685);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Upet");
		mnNewMenu.setIcon(new ImageIcon("C:\\Users\\dougl\\Downloads\\Upet\\icon\\upet.png"));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Clientes");
		mntmNewMenuItem_1.setIcon(new ImageIcon("C:\\Users\\dougl\\Downloads\\Upet\\icon\\aperto-de-mao.png"));
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TClienteFuncionario tcf = new TClienteFuncionario();
				tcf.setVisible(true);
				tcf.setLocationRelativeTo(null);
				dispose();
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenu mnNewMenu_1 = new JMenu("Sobre");
		mnNewMenu_1.setIcon(new ImageIcon("C:\\Users\\dougl\\Downloads\\Upet\\icon\\interocação.png"));
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Ajuda");
		mntmNewMenuItem.setIcon(new ImageIcon("C:\\Users\\dougl\\Downloads\\Upet\\icon\\interocação.png"));
		mnNewMenu_1.add(mntmNewMenuItem);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 165, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 95, 836, 506);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				Integer selecionado = table.getSelectionModel().getMaxSelectionIndex();
				lista.get(selecionado);
			}
		});
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] {}));
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_4 = new JLabel("Produtos");
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_4.setBounds(20, 69, 110, 15);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\dougl\\Downloads\\Upet\\icon\\logo_upet.png"));
		lblNewLabel.setBounds(22, 11, 100, 41);
		contentPane.add(lblNewLabel);
		popularTabela();
		limpar();
	}
	
	public void limpar() {
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
