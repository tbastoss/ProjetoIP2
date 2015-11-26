package br.com.dieta_saude.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ComumFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JComboBox comboBox;
	private JLabel lblSexo;
	private JLabel lblAltura;
	private JLabel lblPeso;
	private JLabel lblIdade;
	private JLabel lblNvelDeSedentarismo;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ComumFrame frame = new ComumFrame();
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
	public ComumFrame() {
		super("CADASTRO: Usuário Comum");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textField = new JTextField();
		textField.setBounds(10, 47, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(10, 78, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		textField_3 = new JTextField();
		textField_3.setBounds(10, 144, 86, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);

		textField_4 = new JTextField();
		textField_4.setBounds(10, 175, 86, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);

		textField_5 = new JTextField();
		textField_5.setBounds(295, 47, 86, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);

		textField_6 = new JTextField();
		textField_6.setBounds(295, 78, 86, 20);
		contentPane.add(textField_6);
		textField_6.setColumns(10);

		JButton btnOk = new JButton("OK");
		btnOk.setBounds(292, 174, 89, 23);
		contentPane.add(btnOk);

		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(106, 50, 46, 14);
		contentPane.add(lblNome);

		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(106, 81, 46, 14);
		contentPane.add(lblSenha);

		String[] sexo = { "M", "F" };
		comboBox = new JComboBox(sexo);
		comboBox.setBounds(10, 109, 86, 24);
		contentPane.add(comboBox);

		lblSexo = new JLabel("Sexo");
		lblSexo.setBounds(106, 116, 46, 14);
		contentPane.add(lblSexo);

		lblAltura = new JLabel("Altura");
		lblAltura.setBounds(106, 147, 46, 14);
		contentPane.add(lblAltura);

		lblPeso = new JLabel("Peso");
		lblPeso.setBounds(106, 178, 46, 14);
		contentPane.add(lblPeso);

		lblIdade = new JLabel("Idade");
		lblIdade.setBounds(239, 50, 46, 14);
		contentPane.add(lblIdade);

		lblNvelDeSedentarismo = new JLabel("N\u00EDvel de Sedentarismo");
		lblNvelDeSedentarismo.setBounds(179, 81, 106, 14);
		contentPane.add(lblNvelDeSedentarismo);

		textField_2 = new JTextField();
		textField_2.setBounds(295, 109, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);

		JLabel lblPeriodo = new JLabel("Periodo (dd/mm/aaaa)");
		lblPeriodo.setBounds(179, 114, 117, 14);
		contentPane.add(lblPeriodo);
	}
}