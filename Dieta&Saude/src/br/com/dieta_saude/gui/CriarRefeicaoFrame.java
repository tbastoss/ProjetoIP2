package br.com.dieta_saude.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.dieta_saude.dados.RepositorioAlimento;
import br.com.dieta_saude.java_beans.Alimento;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JButton;

public class CriarRefeicaoFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CriarRefeicaoFrame frame = new CriarRefeicaoFrame();
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
	public CriarRefeicaoFrame() {
		Alimento banana = new Alimento("Banana", 10);
		Alimento pao = new Alimento("Pão", 30);
		Alimento copoDeSuco = new Alimento("Copo de Suco (200ml)", 10);
		Alimento porcaoDeBolacha = new Alimento("6unds de Bolacha", 20);
		Alimento fatiaDeBoloSemRecheio = new Alimento("Fatia de Bolo (Sem recheio)", 25);
		RepositorioAlimento.getInstance().cadastrar(banana);
		RepositorioAlimento.getInstance().cadastrar(pao);
		RepositorioAlimento.getInstance().cadastrar(copoDeSuco);
		RepositorioAlimento.getInstance().cadastrar(porcaoDeBolacha);
		RepositorioAlimento.getInstance().cadastrar(fatiaDeBoloSemRecheio);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(10, 39, 315, 20);
		contentPane.add(comboBox);
		comboBox.removeAllItems();
		for(int i=0;i<RepositorioAlimento.getInstance().tamanhoRepositorio();i++){
			comboBox.addItem(RepositorioAlimento.getInstance().mostrarAlimentos(i).getNome() + " tem: "+RepositorioAlimento.getInstance().mostrarAlimentos(i).getPontos() + "pontos");
		}
		JLabel lblAlimento = new JLabel("Alimento");
		lblAlimento.setBounds(10, 14, 46, 14);
		contentPane.add(lblAlimento);

		JButton btnOk = new JButton("OK");
		btnOk.setBounds(10, 70, 89, 23);
		contentPane.add(btnOk);
		
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setBounds(335, 38, 89, 23);
		contentPane.add(btnAdicionar);
	}

}
