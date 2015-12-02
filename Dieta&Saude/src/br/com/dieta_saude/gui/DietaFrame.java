package br.com.dieta_saude.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.time.temporal.ChronoUnit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.dieta_saude.java_beans.Dieta;
import br.com.dieta_saude.java_beans.Sessao;

import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class DietaFrame extends JFrame {

	private JPanel contentPane;
	private static int qntRef;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					qntRef = Integer.parseInt(JOptionPane.showInputDialog("Quantas refeições você deseja ter por dia?"));
					int periodo = (int) Sessao.getInstance().getUsuario().getInicio().until(Sessao.getInstance().getUsuario().getFim(), ChronoUnit.DAYS);
					Dieta dieta = new Dieta(qntRef, periodo);
					Sessao.getInstance().getUsuario().setDieta(dieta);
					DietaFrame frame = new DietaFrame();
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
	public DietaFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(30, 63, 107, 20);
		contentPane.add(comboBox);

		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(299, 63, 98, 20);
		contentPane.add(comboBox_1);

		JButton btnOk = new JButton("OK");
		btnOk.setBounds(176, 155, 89, 23);
		contentPane.add(btnOk);

		JLabel lblRefeio = new JLabel("Refei\u00E7\u00E3o");
		lblRefeio.setBounds(30, 41, 46, 14);
		contentPane.add(lblRefeio);

		JLabel lblDia = new JLabel("Dia");
		lblDia.setBounds(301, 41, 46, 14);
		contentPane.add(lblDia);
	}
}
