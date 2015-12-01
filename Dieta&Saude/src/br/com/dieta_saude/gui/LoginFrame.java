package br.com.dieta_saude.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.dieta_saude.controladores.ControladorDeUsuario;
import br.com.dieta_saude.dados.RepositorioUsuario;
import br.com.dieta_saude.dados.RepositorioUsuarioAdm;
import br.com.dieta_saude.java_beans.Usuario;
import br.com.dieta_saude.java_beans.UsuarioAdm;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginFrame extends JFrame {

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

		nome = new JTextField();
		nome.setBounds(10, 44, 86, 20);
		contentPane.add(nome);
		nome.setColumns(10);

		senha = new JTextField();
		senha.setBounds(10, 75, 86, 20);
		contentPane.add(senha);
		senha.setColumns(10);

		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControladorDeUsuario controlador = new ControladorDeUsuario();
					Usuario usuarioComum = RepositorioUsuario.getInstance().procurar(nome.getText(), senha.getText());
					Usuario usuarioAdm = RepositorioUsuarioAdm.getInstance().procurar(nome.getText(), senha.getText());
					if(usuarioComum != null){
						if(controlador.verificaExistenciaDeUsuario(nome.getText(), senha.getText())){
							JOptionPane.showMessageDialog(null, "é comum");
						}
					}else if(usuarioAdm != null){
						if(controlador.verificaExistenciaDeUsuarioAdm(nome.getText(), senha.getText())){
							JOptionPane.showMessageDialog(null, "é adm");
						}
					}
					else{
						JOptionPane.showMessageDialog(null, "erro");
					}
				}//*/
		});
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
