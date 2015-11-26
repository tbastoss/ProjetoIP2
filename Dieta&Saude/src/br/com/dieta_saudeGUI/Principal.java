package br.com.dieta_saudeGUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.FlowLayout;

public class Principal extends JFrame {

	private JPanel contentPane;
	JButton btnCadastrar = new JButton("Cadastrar");
	JButton btnLogin = new JButton("Login");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
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
	public Principal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDietasade = new JLabel("Dieta&Sa\u00FAde");
		lblDietasade.setBounds(200, 11, 175, 30);
		lblDietasade.setForeground(Color.BLACK);
		lblDietasade.setHorizontalAlignment(SwingConstants.CENTER);
		lblDietasade.setFont(new Font("Verdana", Font.BOLD, 24));
		contentPane.add(lblDietasade);
		
		
		btnCadastrar.setBounds(93, 108, 136, 82);
		contentPane.add(btnCadastrar);
		
		
		btnLogin.setBounds(359, 108, 136, 82);
		contentPane.add(btnLogin);
		
		ButtonHandler handler = new ButtonHandler();
		btnCadastrar.addActionListener(handler);
		btnLogin.addActionListener(handler);
	}
	private class ButtonHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == btnCadastrar){
				CadastroFrame cad = new CadastroFrame();
				cad.setVisible(true);
			}
			if(e.getSource() == btnLogin){
				LoginFrame log = new LoginFrame();
				log.setVisible(true);
			}
		}

	}
}
