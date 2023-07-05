package GUIs;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EmptyBorder;

import estoque.Conexao;



public class Update extends JFrame {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel painel;
	static Update frame = new Update();
	
	public static void main() {
		
		frame.criaJanela();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
	public Update() {
		super("ATUALIZAR ESTOQUE");
		criaJanela();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setContentPane(painel);
		
		// legenda geral
		JLabel lblNewLabel = new JLabel("EDITAR PRODUTOS: ");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel.setBounds(110, 11, 389, 14);
		painel.add(lblNewLabel);
					
				
	}
	
	
	@SuppressWarnings("removal")
	public void criaJanela() {
		painel = new JPanel();
		painel.setLayout(null);
		setBounds(100, 100, 376, 194);
		painel.setBorder(new EmptyBorder(5, 30, 5, 30));
		
		// --------- CRIAÇÃO DOS COMPONENTES ------------ //
		
				// LEGENDA
				JLabel legendaAntes = new JLabel("ONDE O ID FOR IGUAL A");
				legendaAntes.setForeground(Color.RED);
				legendaAntes.setFont(new Font("Arial", Font.PLAIN, 10));
				legendaAntes.setBounds(10, 75, 389, 14);
				painel.add(legendaAntes);
				
				// CAIXA PARA DIGITAR
				
				JSpinner idSpinner = new JSpinner();
				idSpinner.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
				idSpinner.setBounds(150, 75, 40, 18);
				painel.add(idSpinner);
				
		
				// ------------------------------------------------- //
				
				// LEGENDA
				JLabel legendaDepois = new JLabel("ADICIONAR OU REMOVER DO ESTOQUE");
				legendaDepois.setForeground(Color.RED);
				legendaDepois.setFont(new Font("Arial", Font.PLAIN, 10));
				legendaDepois.setBounds(10, 100, 389, 14);
				painel.add(legendaDepois);
				
				
				// CAIXA PARA DIGITAR
				JSpinner estoqueSpinner = new JSpinner();
				estoqueSpinner.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
				estoqueSpinner.setBounds(230, 100, 40, 18);
				painel.add(estoqueSpinner);
				
				
				// -------- CRIAÇÃO DO BOTÃO E AÇÃO DO MESMO ---------- //
				
				JButton botaoAdc = new JButton("ADICIONAR");
				botaoAdc.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Connection con = Conexao.getConnection();
						
						// aqui monta a string SQL de acordo com os números selecionados
						int valorId = (int) idSpinner.getValue();
						int valorEstoque = (int) estoqueSpinner.getValue();
						String sql =  "update produtos set estoque = estoque +" + valorEstoque + " where id = " + valorId;
						
										
						
						try {
							PreparedStatement st = con.prepareStatement(sql);
							
							st.executeUpdate();
							
							st.close();
							
							
							
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						JOptionPane.showMessageDialog(null, "atualizado", "", -1);
						
						frame.dispose();
						Read.main();
						
						
						
						
					}
					
					
				});
				
				JButton botaoRem = new JButton("REMOVER");
				botaoRem.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Connection con = Conexao.getConnection();
						
						int valorId = (int) idSpinner.getValue();
						int valorEstoque = (int) estoqueSpinner.getValue();
						String sql =  "update produtos set estoque = estoque -" + valorEstoque + " where id = " + valorId;
						
						try {
							PreparedStatement st = con.prepareStatement(sql);
							
							st.executeUpdate();
							
							st.close();
							
							
							
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						JOptionPane.showMessageDialog(null, "atualizado", "", -1);
						
						frame.dispose();
						Read.main();
					}
				});
				
				botaoAdc.setBounds(60, 130, 100, 20);
				botaoRem.setBounds(200, 130, 100, 20);
				painel.add(botaoAdc);
				painel.add(botaoRem);
		
	}
	
	
}
