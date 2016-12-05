package framework;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.TextArea;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

import java.awt.Color;
import db.mannager.*;
import framework.match.EnumMatchers;
import framework.webcrawler.EnumPicaretas;

import java.util.List;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.JCheckBox;

public class GUI {

	private JFrame frmMineradorDeCorrupo;
	private TextArea textArea;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frmMineradorDeCorrupo.setVisible(true);
					window.frmMineradorDeCorrupo.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUI() {
		initialize();
	}

	/**
	 * Recebe lista e atualiza textArea.
	 */	
	public void attTextArea(List<Product> l){
		for(Product j : l){
			textArea.append("Nome do Produto: " + j.getName()+ "\nPreço: " + j.getCost() + "\nDescrição: " + j.getDescr()+"\nLink:"+j.getAnounceLink()+"\n\n");
		}
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMineradorDeCorrupo = new JFrame();
		frmMineradorDeCorrupo.setTitle("BestBuy");
		frmMineradorDeCorrupo.setBounds(100, 100, 800, 600);
		frmMineradorDeCorrupo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMineradorDeCorrupo.getContentPane().setLayout(null);
		

		final JLabel label = new JLabel("");
		label.setBounds(326, 17, 174, 16);
		frmMineradorDeCorrupo.getContentPane().add(label);
		
		JButton btnNewButton = new JButton("Atualizar Banco");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Date dataHoje = new Date();
				SimpleDateFormat formataData = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
				String data = formataData.format(dataHoje);
				label.setText(data);	
				
				//textArea.setText("Atualizando a base de dados de bolsa familia...");
				//DadosDoSistema.getDados().getMiner().minerar(EnumPicaretas.B_FAMILIA); //Picareata de servidor
				textArea.append("Atualizando lista de produtos...");
				DadosGlobais.getDados().getMiner().minerar(EnumPicaretas.PROD); //Picareata de servidor
			}
		});
		btnNewButton.setBounds(10, 13, 183, 25);
		frmMineradorDeCorrupo.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Buscar Item");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");
				DadosGlobais.getDados().setMatcher(EnumMatchers.V_BUY);
				String produto = textField.getText();
				if (produto.isEmpty()){
					attTextArea(DadosGlobais.getDados().getMatcher().allMatchs());
				}
				else{
					attTextArea(DadosGlobais.getDados().getMatcher().matchByName(produto));
				}
			}
		});
		btnNewButton_1.setBounds(512, 13, 260, 25);
		frmMineradorDeCorrupo.getContentPane().add(btnNewButton_1);
		
		textArea = new TextArea();
		textArea.setBackground(SystemColor.controlHighlight);
		textArea.setFont(new Font("Courier New", Font.PLAIN, 15));
		textArea.setForeground(Color.BLACK);
		textArea.setEditable(false);
		textArea.setBounds(10, 132, 762, 413);
		frmMineradorDeCorrupo.getContentPane().add(textArea);
		
		JLabel lblNewLabel = new JLabel("\u00DAltima atualiza\u00E7\u00E3o:");
		lblNewLabel.setBounds(205, 17, 121, 16);
		frmMineradorDeCorrupo.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(512, 54, 260, 26);
		frmMineradorDeCorrupo.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNomeDoProduto = new JLabel("Nome do produto:");
		lblNomeDoProduto.setBounds(364, 57, 143, 20);
		frmMineradorDeCorrupo.getContentPane().add(lblNomeDoProduto);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Pre\u00E7o");
		JCheckBox chckbxNome = new JCheckBox("Nome");
		chckbxNewCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxNome.isSelected()){
					chckbxNome.setSelected(false);
				}
			}
		});
		chckbxNewCheckBox.setBounds(11, 86, 76, 29);
		frmMineradorDeCorrupo.getContentPane().add(chckbxNewCheckBox);
		
		JLabel lblOrdenarPor = new JLabel("Ordenar por:");
		lblOrdenarPor.setBounds(20, 67, 151, 20);
		frmMineradorDeCorrupo.getContentPane().add(lblOrdenarPor);
		
		chckbxNome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(chckbxNewCheckBox.isSelected()){
					chckbxNewCheckBox.setSelected(false);
				}
			}
		});
		chckbxNome.setBounds(93, 86, 139, 29);
		frmMineradorDeCorrupo.getContentPane().add(chckbxNome);
	}
}
