package br.com.dieta_saudeGUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(10, 39, 108, 20);
		contentPane.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(258, 39, 108, 20);
		contentPane.add(comboBox_1);
		
		JLabel lblAlimento = new JLabel("Alimento");
		lblAlimento.setBounds(10, 14, 46, 14);
		contentPane.add(lblAlimento);
		
		JLabel lblRefeio = new JLabel("Refei\u00E7\u00E3o");
		lblRefeio.setBounds(258, 14, 46, 14);
		contentPane.add(lblRefeio);
		
		JButton btnOk = new JButton("OK");
		btnOk.setBounds(151, 142, 89, 23);
		contentPane.add(btnOk);
	}

}
