package br.com.dieta_saude.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.dieta_saude.controladores.ControladorDeAlimentos;
import br.com.dieta_saude.excecoes.AlimentoInexistenteException;
import br.com.dieta_saude.excecoes.CampoVazioException;
import br.com.dieta_saude.java_beans.Alimento;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
		nome.setBounds(211, 100, 86, 20);
		contentPane.add(nome);
		nome.setColumns(10);
		
		pontos = new JTextField();
		pontos.setBounds(211, 131, 86, 20);
		contentPane.add(pontos);
		pontos.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(307, 103, 46, 14);
		contentPane.add(lblNome);
		
		JLabel lblPontos = new JLabel("Pontos");
		lblPontos.setBounds(307, 134, 46, 14);
		contentPane.add(lblPontos);
		
		JButton btnAdicionarAlimento = new JButton("Adicionar Alimento");
		btnAdicionarAlimento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					if(nome.getText().equals("")||pontos.getText().equals("")){
						throw new CampoVazioException();
					}
					Alimento aCadastrar = new Alimento(nome.getText(), Integer.parseInt(pontos.getText()));
					ControladorDeAlimentos con = new ControladorDeAlimentos();
					if(con.adicionar(aCadastrar) == false){
						throw new AlimentoInexistenteException();
					}
					}catch(CampoVazioException cve){
						JOptionPane.showMessageDialog(null, cve.getMessage());
					}catch(AlimentoInexistenteException aie){
						JOptionPane.showMessageDialog(null, aie.getMessage());
					}
			}
		});
		btnAdicionarAlimento.setBounds(208, 162, 134, 23);
		contentPane.add(btnAdicionarAlimento);
		
		JButton btnRemoverAlimento = new JButton("Remover Alimento");
		btnRemoverAlimento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					if(nome.getText().equals("")||pontos.getText().equals("")){
						throw new CampoVazioException();
					}
				Alimento aRemover = new Alimento(nome.getText(), Integer.parseInt(pontos.getText()));
				ControladorDeAlimentos con = new ControladorDeAlimentos();
				if(con.remover(aRemover) == false){
					throw new AlimentoInexistenteException();
				}
				}catch(CampoVazioException cve){
					JOptionPane.showMessageDialog(null, cve.getMessage());
				}catch(AlimentoInexistenteException aie){
					JOptionPane.showMessageDialog(null, aie.getMessage());
				}
			}
		});
		btnRemoverAlimento.setBounds(208, 188, 134, 23);
		contentPane.add(btnRemoverAlimento);
		
		JButton btnAtualizarAlimento = new JButton("Atualizar Alimento");
		btnAtualizarAlimento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					if(nome.getText().equals("")||pontos.getText().equals("")){
						throw new CampoVazioException();
					}
				Alimento aAtualizar = new Alimento(nome.getText(), Integer.parseInt(pontos.getText()));
				ControladorDeAlimentos con = new ControladorDeAlimentos();
				if(con.atualizar(aAtualizar) == false){
					throw new AlimentoInexistenteException();
				}
				}catch(CampoVazioException cve){
					JOptionPane.showMessageDialog(null, cve.getMessage());
				}catch(AlimentoInexistenteException aie){
					JOptionPane.showMessageDialog(null, aie.getMessage());
				}
			}
		});
		btnAtualizarAlimento.setBounds(209, 213, 133, 23);
		contentPane.add(btnAtualizarAlimento);
	}
}
