package br.com.dieta_saude.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.dieta_saude.dados.RepositorioUsuario;
import br.com.dieta_saude.java_beans.UsuarioComum;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ComumFrame extends JFrame {

	private JPanel contentPane;
	private JTextField nome;
	private JTextField senha;
	private JTextField altura;
	private JTextField peso;
	private JTextField idade;
	private JLabel lblSexo;
	private JLabel lblAltura;
	private JLabel lblPeso;
	private JLabel lblIdade;
	private JLabel lblNvelDeSedentarismo;
	private JTextField periodo;
	private JComboBox comboBox_1;
	private JButton btnNewButton;
	private JButton btnOk;
	private char sexo2;
	RepositorioUsuario repositorio = new RepositorioUsuario(50);

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

		nome = new JTextField();
		nome.setBounds(10, 47, 86, 20);
		contentPane.add(nome);
		nome.setColumns(10);

		senha = new JTextField();
		senha.setBounds(10, 78, 86, 20);
		contentPane.add(senha);
		senha.setColumns(10);

		altura = new JTextField();
		altura.setBounds(10, 144, 86, 20);
		contentPane.add(altura);
		altura.setColumns(10);

		peso = new JTextField();
		peso.setBounds(10, 175, 86, 20);
		contentPane.add(peso);
		peso.setColumns(10);

		idade = new JTextField();
		idade.setBounds(295, 47, 86, 20);
		contentPane.add(idade);
		idade.setColumns(10);

		

		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(106, 50, 46, 14);
		contentPane.add(lblNome);

		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(106, 81, 46, 14);
		contentPane.add(lblSenha);

		String[] sexo = { "M", "F" };
		double[] m = { 1.2, 1.3, 1.4, 1.5, 1.6, 1.8 };

		lblSexo = new JLabel("Sexo");
		lblSexo.setBounds(106, 112, 46, 14);
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

		periodo = new JTextField();
		periodo.setBounds(295, 109, 86, 20);
		contentPane.add(periodo);
		periodo.setColumns(10);

		JLabel lblPeriodo = new JLabel("Periodo (dd/mm/aaaa)");
		lblPeriodo.setBounds(179, 114, 117, 14);
		contentPane.add(lblPeriodo);
		String[] d = { "1", "2", "3", "4", "5", "6" };
		JComboBox nivelSedentarismo = new JComboBox(d);
		nivelSedentarismo.setBounds(295, 78, 86, 20);
		contentPane.add(nivelSedentarismo);
		
		JButton btnTeste = new JButton("M");
		btnTeste.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sexo2 = 'M';
				/*String[] m = { "1.2", "1.3", "1.4", "1.5", "1.6", "1.8" };
				nivelSedentarismo.removeAllItems();
                for(int i=0;i<m.length;i++){
                    nivelSedentarismo.addItem(m[i]);
                }*/
			}
		});
		btnTeste.setBounds(10, 108, 46, 23);
		contentPane.add(btnTeste);
		
		btnNewButton = new JButton("F");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sexo2 = 'F';
				/*String[] m = { "1.2", "1.3", "1.35", "1.45", "1.5", "1.7" };
				nivelSedentarismo.removeAllItems();
                for(int i=0;i<m.length;i++){
                    nivelSedentarismo.addItem(m[i]);
                }*/
			}
		});
		btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UsuarioComum comumUser = new UsuarioComum();
				String nivel = nivelSedentarismo.getSelectedItem().toString();
				comumUser.cadastroUsuario(nome.getText(), senha.getText(), sexo2, Double.parseDouble(altura.getText()), Double.parseDouble(peso.getText()), Integer.parseInt(idade.getText()), Integer.parseInt(nivel), 0);
				comumUser.calcularPontos();
				repositorio.cadastrar(comumUser);
			}
		});
		btnOk.setBounds(292, 174, 89, 23);
		contentPane.add(btnOk);
		btnNewButton.setBounds(58, 108, 42, 23);
		contentPane.add(btnNewButton);
		
	}
}