package GUIs;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import estoque.Conexao;

public class Delete extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField condicao;
	static Delete frame = new Delete();
	/**
	 * Launch the application.
	 */
	public static String main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		return null;
	}

	/**
	 * Create the frame.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Delete() {
		setTitle("REMOVER PRODUTO");
		
		setType(Type.POPUP);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		addWindowListener(new WindowAdapter(){ 
			public void windowClosing(WindowEvent evt){ 
				if (JOptionPane.showConfirmDialog(null,"Certeza?", null, JOptionPane.YES_NO_OPTION)==JOptionPane.OK_OPTION){
					frame.dispose();}
				
					}
			});
		setBounds(100, 100, 376, 194);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("DELETAR DO ESTOQUE O PRODUTO QUE TIVER:");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 11, 389, 14);
		contentPane.add(lblNewLabel);
		
		JComboBox coluna = new JComboBox();
		coluna.setModel(new DefaultComboBoxModel(new String[] {"id", "setor", "modelo", "tamanho", "cor"}));
		coluna.setBounds(53, 38, 86, 18);
		contentPane.add(coluna);
		
		JLabel lblNewLabel_1 = new JLabel("O(A)");
		lblNewLabel_1.setBounds(10, 40, 33, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("IGUAL A:");
		lblNewLabel_1_1.setBounds(149, 40, 58, 14);
		contentPane.add(lblNewLabel_1_1);
		
		condicao = new JTextField();
		condicao.setBounds(217, 37, 86, 20);
		contentPane.add(condicao);
		condicao.setColumns(10);
		
		JButton botao = new JButton("EXECUTAR");
		botao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			
				String col = (String) coluna.getSelectedItem();
				String val = (String) condicao.getText();
				String sql;	
				
				
				Connection con = Conexao.getConnection();
				// verifica se o valor da coluna será id, se sim, a variavel retornará um inteiro
				// para não dar erro no SQL
					if (col == "Id") {
						int intVal = Integer.parseInt(val);
						sql = "delete from produtos where " + col + " = " + intVal;
					}
				// fun fact: deu erro 500x para eu descobrir que o que faltava na string SQL era justamente as aspas duplas " "
					else {
						
						sql = "delete from produtos where " + col + " = " + '"'+val.toUpperCase()+'"';
					}	
					
				try {
					
					
					PreparedStatement st = con.prepareStatement(sql);
					st.executeUpdate();
					JOptionPane.showMessageDialog(null, "DADOS REMOVIDOS COM SUCESSO", "", -1);
					
					st.close();
					con.close();
					
					frame.dispose();
					Read.main();
					
					
				} catch (SQLException e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "VERIFIQUE SE INSERIU NOMES VÁLIDOS", "ERRO", 0);
					
					
				}
				
			}
		});
		botao.setBounds(96, 95, 168, 32);
		contentPane.add(botao);
	}
}
