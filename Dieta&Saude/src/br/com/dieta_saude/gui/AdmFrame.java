package br.com.dieta_saude.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.dieta_saude.dados.RepositorioUsuario;
import br.com.dieta_saude.dados.RepositorioUsuarioAdm;
import br.com.dieta_saude.java_beans.UsuarioAdm;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdmFrame extends JFrame {

	private JPanel contentPane;
	private JTextField nome;
	private JTextField senha;
	RepositorioUsuarioAdm repositorio = new RepositorioUsuarioAdm(5);
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdmFrame frame = new AdmFrame();
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
	public AdmFrame() {
		super("CADASTRO: Adm");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		nome = new JTextField();
		nome.setBounds(10, 36, 86, 20);
		contentPane.add(nome);
		nome.setColumns(10);

		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(106, 39, 46, 14);
		contentPane.add(lblNome);

		senha = new JTextField();
		senha.setBounds(10, 67, 86, 20);
		contentPane.add(senha);
		senha.setColumns(10);

		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(106, 73, 46, 14);
		contentPane.add(lblSenha);

		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UsuarioAdm admUser = new UsuarioAdm();
				admUser.cadastrarAdm(nome.getText(), senha.getText(), 1);
				repositorio.cadastrar(admUser);
			}
		});
		btnOk.setBounds(10, 106, 89, 23);
		contentPane.add(btnOk);
	}
}