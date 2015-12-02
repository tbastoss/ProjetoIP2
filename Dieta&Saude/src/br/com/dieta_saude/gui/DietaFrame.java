package br.com.dieta_saude.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.time.temporal.ChronoUnit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.dieta_saude.dados.RepositorioAlimento;
import br.com.dieta_saude.dados.RepositorioRefeicao;
import br.com.dieta_saude.java_beans.Dieta;
import br.com.dieta_saude.java_beans.Refeicao;
import br.com.dieta_saude.java_beans.Sessao;

import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DietaFrame extends JFrame {

	private JPanel contentPane;
	private static int qntRef;
	private static Dieta dieta;
	private static int periodoAction = 0;
	private static int qtdRefeicaoAction = 0;
	private JLabel pontosDieta;
	private JLabel pontosUsuario;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DietaFrame frame = new DietaFrame(0);
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
	public DietaFrame(int qtdRefeicao) {
		qntRef = qtdRefeicao;
		int periodo = (int) Sessao.getInstance().getUsuario().getInicio().until(Sessao.getInstance().getUsuario().getFim(), ChronoUnit.DAYS);
		dieta = new Dieta(qntRef, periodo);
		dieta.setPeriodoEmDiasDaDieta(periodo);
		dieta.setQtdRefeicao(qntRef);
		Sessao.getInstance().getUsuario().setDieta(dieta);
		Refeicao refeicao[][] = new Refeicao[dieta.getPeriodoEmDiasDaDieta()][dieta.getQtdRefeicao()];
		
		JOptionPane.showMessageDialog(null, periodo + " dias e " + qntRef + " refeições");
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(30, 63, 220, 20);
		contentPane.add(comboBox);
		comboBox.removeAllItems();
		for(int i=0;i<RepositorioRefeicao.getInstance().tamanhoRepositorio();i++){
			comboBox.addItem(RepositorioRefeicao.getInstance().mostrarRefeicao(i).getNome() + " tem:"+RepositorioRefeicao.getInstance().mostrarRefeicao(i).getPontos() + "pontos");
		}

		/*JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dieta.setRefeicao(refeicao);
				dieta.setInicioDieta(Sessao.getInstance().getUsuario().getInicio());
				dieta.setFimDieta(Sessao.getInstance().getUsuario().getFim());
				JOptionPane.showMessageDialog(null, dieta.toString());
			}
		});
		btnOk.setBounds(176, 155, 89, 23);
		contentPane.add(btnOk);*/

		JLabel lblRefeio = new JLabel("Refei\u00E7\u00E3o");
		lblRefeio.setBounds(30, 41, 46, 14);
		contentPane.add(lblRefeio);
		
		pontosDieta = new JLabel("0");
		pontosDieta.setBounds(158, 166, 76, 14);
		contentPane.add(pontosDieta);
		
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if (periodoAction == (dieta.getPeriodoEmDiasDaDieta())){
					JOptionPane.showMessageDialog(null, "Você criou sua dieta!");
					dieta.setRefeicao(refeicao);
					dieta.setInicioDieta(Sessao.getInstance().getUsuario().getInicio());
					dieta.setFimDieta(Sessao.getInstance().getUsuario().getFim());
					JOptionPane.showMessageDialog(null, String.valueOf(dieta.toString()));
					AcompanhamentoFrame af = new AcompanhamentoFrame(dieta);
					af.setVisible(true);
				}else{
					String divComando[] = new String[2];
					divComando = comboBox.getSelectedItem().toString().split(" ");
					refeicao[periodoAction][qtdRefeicaoAction] = (Refeicao) RepositorioRefeicao.getInstance().procurar(divComando[0]);
					//JOptionPane.showMessageDialog(null, periodoAction + " "+ refeicao[periodoAction][qtdRefeicaoAction].getPontos() + refeicao[periodoAction][qtdRefeicaoAction].getNome() + " "+qtdRefeicaoAction);
					dieta.setPontos(refeicao[periodoAction][qtdRefeicaoAction].getPontos());
					qtdRefeicaoAction++;
					
				}
				if (qtdRefeicaoAction == (dieta.getQtdRefeicao())){
					periodoAction++;
					qtdRefeicaoAction = 0;
				}
				pontosDieta.setText(String.valueOf(dieta.getPontos()));
					
			}
		});
		btnAdicionar.setBounds(291, 62, 89, 23);
		contentPane.add(btnAdicionar);
		
		JLabel lblSeusPontos = new JLabel("Seus pontos di\u00E1rios:");
		lblSeusPontos.setBounds(30, 135, 102, 20);
		contentPane.add(lblSeusPontos);
		
		JLabel lblPontosDaDieta = new JLabel("Pontos totais da dieta:");
		lblPontosDaDieta.setBounds(30, 166, 119, 14);
		contentPane.add(lblPontosDaDieta);
		
		pontosUsuario = new JLabel(String.valueOf(Sessao.getInstance().getUsuario().getPontos()));
		pontosUsuario.setBounds(158, 138, 76, 14);
		contentPane.add(pontosUsuario);
	}
}
