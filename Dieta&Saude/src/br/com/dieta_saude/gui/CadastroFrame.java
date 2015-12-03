package br.com.dieta_saude.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.dieta_saude.excecoes.CampoVazioException;
import br.com.dieta_saude.excecoes.CodigoInvalidoException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

public class CadastroFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	JButton btnOk = new JButton("OK");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroFrame frame = new CadastroFrame();
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
	public CadastroFrame() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblCadastro = new JLabel("Cadastro");
		lblCadastro.setBounds(242, 143, 86, 14);
		contentPane.add(lblCadastro);

		textField = new JTextField();
		textField.setBounds(177, 188, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel lblTipoDeUsurio = new JLabel("Tipo de Usu\u00E1rio (para comum digite comum, para adm digite o codigo):");
		lblTipoDeUsurio.setBounds(106, 162, 378, 14);
		contentPane.add(lblTipoDeUsurio);

		btnOk.setBounds(272, 187, 89, 23);
		contentPane.add(btnOk);
		ButtonHandler handler = new ButtonHandler();
		btnOk.addActionListener(handler);
	}

	private class ButtonHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == btnOk) {
				try{
					if(textField.getText().equals("")){
						throw new CampoVazioException();
					}
					if (textField.getText().equals("comum")) {
					ComumFrame cf = new ComumFrame();
					cf.setVisible(true);
				}else if (textField.getText().equals("dieta123")) {
					AdmFrame ct = new AdmFrame();
					ct.setVisible(true);
				}else{
					throw new CodigoInvalidoException();
				}
				}catch(CampoVazioException cve){
					JOptionPane.showMessageDialog(null, cve.getMessage());
				}catch(CodigoInvalidoException cie){
					JOptionPane.showMessageDialog(null, cie.getMessage());
				}
			}
		}

	}
}
