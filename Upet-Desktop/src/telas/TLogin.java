package telas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import classe.Funcionario;
import dao.FuncionarioDao;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import java.awt.Toolkit;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;

public class TLogin extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txfEmail;
	private JPasswordField txfSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TLogin frame = new TLogin();
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
	public TLogin() {
		setTitle("UPET");
		setIconImage(
				Toolkit.getDefaultToolkit().getImage("C:\\Users\\dougl\\Downloads\\Upet\\icon\\upet.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 630, 490);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 140, 0));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnNewButton = new JButton("Entrar");
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\dougl\\Downloads\\Upet\\icon\\login.png"));
		btnNewButton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				try {
					FuncionarioDao funcionarioDao = new FuncionarioDao();
					Funcionario funcionario = funcionarioDao.validar(txfEmail.getText(), txfSenha.getText());

					if (funcionario.getTipo().equals("admin")) {
						TFuncionario tf = new TFuncionario();
						tf.setVisible(true);
						tf.setLocationRelativeTo(null);
						dispose();
					} else if (funcionario.getTipo().equals("funcionario")) {
						TClienteFuncionario tc = new TClienteFuncionario();
						tc.setVisible(true);
						tc.setLocationRelativeTo(null);
						dispose();
					}
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Nao validou usuario" + ex);
				}
			}
		});
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 14));
		btnNewButton.setBounds(238, 349, 114, 32);
		contentPane.add(btnNewButton);

		txfEmail = new JTextField();
		txfEmail.setBounds(203, 206, 199, 32);
		contentPane.add(txfEmail);
		txfEmail.setColumns(10);

		txfSenha = new JPasswordField();
		txfSenha.setBounds(203, 279, 199, 32);
		contentPane.add(txfSenha);

		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(267, 166, 56, 31);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Senha");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(266, 250, 56, 23);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\dougl\\Pictures\\Upet-Desktop\\icon\\Upet Logo (desktop).png"));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(122, 11, 362, 195);
		contentPane.add(lblNewLabel_2);
	}
}
