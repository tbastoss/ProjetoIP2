package br.com.dieta_saudeGUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;

public class LoginFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame frame = new LoginFrame();
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
	public LoginFrame() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(10, 44, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(10, 75, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnOk = new JButton("OK");
		btnOk.setBounds(10, 118, 89, 23);
		contentPane.add(btnOk);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(105, 47, 46, 14);
		contentPane.add(lblNome);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(106, 78, 46, 14);
		contentPane.add(lblSenha);
	}

}

