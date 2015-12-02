package br.com.dieta_saude.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.dieta_saude.controladores.ControladorDeAlimentos;
import br.com.dieta_saude.java_beans.Alimento;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdmPainelFrame extends JFrame {

	private JPanel contentPane;
	private JTextField nome;
	private JTextField pontos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdmPainelFrame frame = new AdmPainelFrame();
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
	public AdmPainelFrame() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		nome = new JTextField();
		nome.setBounds(23, 41, 86, 20);
		contentPane.add(nome);
		nome.setColumns(10);
		
		pontos = new JTextField();
		pontos.setBounds(23, 72, 86, 20);
		contentPane.add(pontos);
		pontos.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(119, 44, 46, 14);
		contentPane.add(lblNome);
		
		JLabel lblPontos = new JLabel("Pontos");
		lblPontos.setBounds(119, 75, 46, 14);
		contentPane.add(lblPontos);
		
		JButton btnAdicionarAlimento = new JButton("Adicionar Alimento");
		btnAdicionarAlimento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Alimento aCadastrar = new Alimento(nome.getText(), Integer.parseInt(pontos.getText()));
				ControladorDeAlimentos con = new ControladorDeAlimentos();
				con.adicionar(aCadastrar);			
			}
		});
		btnAdicionarAlimento.setBounds(20, 103, 134, 23);
		contentPane.add(btnAdicionarAlimento);
		
		JButton btnRemoverAlimento = new JButton("Remover Alimento");
		btnRemoverAlimento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Alimento aRemover = new Alimento(nome.getText(), Integer.parseInt(pontos.getText()));
				ControladorDeAlimentos con = new ControladorDeAlimentos();
				con.remover(aRemover);		
			}
		});
		btnRemoverAlimento.setBounds(20, 129, 134, 23);
		contentPane.add(btnRemoverAlimento);
		
		JButton btnAtualizarAlimento = new JButton("Atualizar Alimento");
		btnAtualizarAlimento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Alimento aAtualizar = new Alimento(nome.getText(), Integer.parseInt(pontos.getText()));
				ControladorDeAlimentos con = new ControladorDeAlimentos();
				con.atualizar(aAtualizar);	
			}
		});
		btnAtualizarAlimento.setBounds(21, 154, 133, 23);
		contentPane.add(btnAtualizarAlimento);
	}
}
