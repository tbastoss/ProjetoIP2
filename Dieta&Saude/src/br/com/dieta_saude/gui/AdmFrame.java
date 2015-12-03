package br.com.dieta_saude.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.dieta_saude.dados.RepositorioUsuario;
import br.com.dieta_saude.dados.RepositorioUsuarioAdm;
import br.com.dieta_saude.excecoes.CampoVazioException;
import br.com.dieta_saude.java_beans.UsuarioAdm;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdmFrame extends JFrame {

	private JPanel contentPane;
	private JTextField nome;
	private JTextField senha;
	
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
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		nome = new JTextField();
		nome.setBounds(275, 128, 86, 20);
		contentPane.add(nome);
		nome.setColumns(10);

		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(219, 131, 46, 14);
		contentPane.add(lblNome);

		senha = new JTextField();
		senha.setBounds(275, 159, 86, 20);
		contentPane.add(senha);
		senha.setColumns(10);

		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(219, 165, 46, 14);
		contentPane.add(lblSenha);

		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					if(nome.getText().equals("") || senha.getText().equals("")){
						throw new CampoVazioException();
					}
					UsuarioAdm admUser = new UsuarioAdm();
					admUser.cadastrarAdm(nome.getText(), senha.getText(), 1);
					RepositorioUsuarioAdm.getInstance().cadastrar(admUser);
					JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
					AdmFrame.this.dispose();
				}catch(CampoVazioException cvz){
					JOptionPane.showMessageDialog(null, cvz.getMessage());
				}
			}
		});
		btnOk.setBounds(241, 190, 89, 23);
		contentPane.add(btnOk);
	}
}