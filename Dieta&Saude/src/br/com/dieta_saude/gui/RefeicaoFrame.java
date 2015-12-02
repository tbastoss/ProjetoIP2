package br.com.dieta_saude.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RefeicaoFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RefeicaoFrame frame = new RefeicaoFrame();
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
	public RefeicaoFrame() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnNewButton = new JButton("Criar refei\u00E7\u00E3o");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CriarRefeicaoFrame crf = new CriarRefeicaoFrame();
				crf.setVisible(true);
			}
		});
		btnNewButton.setBounds(32, 66, 114, 48);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Montar dieta");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int qntRef = Integer.parseInt(JOptionPane.showInputDialog("Quantas refeições você deseja ter por dia?"));
				DietaFrame df = new DietaFrame(qntRef);
				df.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(233, 66, 114, 48);
		contentPane.add(btnNewButton_1);
	}
}