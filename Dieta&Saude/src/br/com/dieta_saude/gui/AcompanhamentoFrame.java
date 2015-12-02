package br.com.dieta_saude.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.dieta_saude.java_beans.Dieta;
import br.com.dieta_saude.java_beans.Sessao;

import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AcompanhamentoFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//AcompanhamentoFrame frame = new AcompanhamentoFrame();
					//frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AcompanhamentoFrame(Dieta dieta) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMinhasInformaes = new JLabel("Minhas informa\u00E7\u00F5es:");
		lblMinhasInformaes.setBounds(10, 22, 122, 14);
		contentPane.add(lblMinhasInformaes);
		
		JLabel lblDieta = new JLabel("Dieta:");
		lblDieta.setBounds(239, 22, 46, 14);
		contentPane.add(lblDieta);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(10, 47, 46, 14);
		contentPane.add(lblNome);
		
		JLabel nome = new JLabel(Sessao.getInstance().getUsuario().getNome());
		nome.setBounds(66, 47, 135, 14);
		contentPane.add(nome);
		
		JLabel lblNvelDeSedentarismo = new JLabel("N\u00EDvel de Sedentarismo:");
		lblNvelDeSedentarismo.setBounds(10, 72, 135, 14);
		contentPane.add(lblNvelDeSedentarismo);
		
		JLabel nivel = new JLabel(String.valueOf(Sessao.getInstance().getUsuario().getNivelDeSedentarismo()));
		nivel.setBounds(155, 72, 46, 14);
		contentPane.add(nivel);
		
		JLabel lblPontos = new JLabel("Pontos:");
		lblPontos.setBounds(10, 97, 46, 14);
		contentPane.add(lblPontos);
		
		JLabel pontos = new JLabel(String.valueOf(Sessao.getInstance().getUsuario().getPontos()));
		pontos.setBounds(66, 97, 122, 14);
		contentPane.add(pontos);
		
		JLabel lblIncio = new JLabel("In\u00EDcio:");
		lblIncio.setBounds(239, 47, 46, 14);
		contentPane.add(lblIncio);
		
		JLabel inicio = new JLabel(String.valueOf(Sessao.getInstance().getUsuario().getDieta().getInicioDieta()));
		inicio.setBounds(295, 47, 135, 14);
		contentPane.add(inicio);
		
		JLabel lblFim = new JLabel("Fim:");
		lblFim.setBounds(239, 72, 46, 14);
		contentPane.add(lblFim);
		
		JLabel fim = new JLabel(String.valueOf(Sessao.getInstance().getUsuario().getDieta().getFimDieta()));
		fim.setBounds(305, 72, 125, 14);
		contentPane.add(fim);
		
		JButton btnRefeies = new JButton("Refei\u00E7\u00F5es");
		btnRefeies.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, String.valueOf(dieta.toString()));
			}
		});
		btnRefeies.setBounds(237, 93, 89, 23);
		contentPane.add(btnRefeies);
	}
}
