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
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.LineBorder;

import estoque.Conexao;

public class Create extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField modelo;
	private JTextField cor;
	static Create frame = new Create();
	/**
	 * Launch the application
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
	@SuppressWarnings({ "removal", "unchecked", "rawtypes" })
	public Create() {
		setType(Type.POPUP);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		addWindowListener(new WindowAdapter(){ 
			public void windowClosing(WindowEvent evt){ 
				if (JOptionPane.showConfirmDialog(null,"Certeza?", null, JOptionPane.YES_NO_OPTION)==JOptionPane.OK_OPTION){
					frame.dispose();}
				
					}
			});
		
		
		
		setFont(new Font("Bodoni MT", Font.BOLD | Font.ITALIC, 12));
		setTitle("ADICIONAR PRODUTO");
		setForeground(Color.RED);
		setBackground(Color.WHITE);
		setBounds(100, 100, 374, 300);
		contentPane = new JPanel();
		contentPane.setForeground(Color.BLACK);
		contentPane.setBackground(Color.LIGHT_GRAY);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox setor = new JComboBox();
		setor.setModel(new DefaultComboBoxModel(new String[] {"CAMISAS", "CAL\u00C7AS", "INVERNO", "BERMUDAS", "ESPORTES"}));
		setor.setBounds(71, 9, 140, 19);
		contentPane.add(setor);
		
		JLabel lblNewLabel = new JLabel("SETOR");
		lblNewLabel.setBackground(Color.LIGHT_GRAY);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 11));
		lblNewLabel.setBounds(10, 9, 95, 19);
		contentPane.add(lblNewLabel);
		
		JLabel lblModelo = new JLabel("MODELO");
		lblModelo.setFont(new Font("Arial", Font.BOLD, 11));
		lblModelo.setBackground(Color.LIGHT_GRAY);
		lblModelo.setBounds(10, 39, 95, 19);
		contentPane.add(lblModelo);
		
		modelo = new JTextField();
		modelo.setToolTipText("MARCA + MODELO");
		modelo.setBounds(71, 39, 140, 20);
		contentPane.add(modelo);
		modelo.setColumns(10);
		
		JLabel lblTamanho = new JLabel("TAMANHO");
		lblTamanho.setFont(new Font("Arial", Font.BOLD, 11));
		lblTamanho.setBackground(Color.LIGHT_GRAY);
		lblTamanho.setBounds(10, 69, 95, 19);
		contentPane.add(lblTamanho);
		
		JComboBox tamanho = new JComboBox();
		tamanho.setModel(new DefaultComboBoxModel(new String[] {"P", "M", "G", "GG"}));
		tamanho.setBounds(71, 67, 140, 19);
		contentPane.add(tamanho);
		
		JLabel lblCor = new JLabel("COR");
		lblCor.setFont(new Font("Arial", Font.BOLD, 11));
		lblCor.setBackground(Color.LIGHT_GRAY);
		lblCor.setBounds(10, 99, 95, 19);
		contentPane.add(lblCor);
		
		cor = new JTextField();
		cor.setColumns(10);
		cor.setBounds(71, 99, 140, 20);
		contentPane.add(cor);
		
		JLabel lblPreo = new JLabel("PRE\u00C7O");
		lblPreo.setFont(new Font("Arial", Font.BOLD, 11));
		lblPreo.setBackground(Color.LIGHT_GRAY);
		lblPreo.setBounds(10, 140, 95, 19);
		contentPane.add(lblPreo);
		JSlider preco = new JSlider();
		contentPane.add(preco);
		
		JLabel quantia = new JLabel("QUANTIA");
		quantia.setFont(new Font("Arial", Font.BOLD, 11));
		quantia.setBackground(Color.LIGHT_GRAY);
		quantia.setBounds(10, 185, 55, 19);
		contentPane.add(quantia);
		
		JSpinner estoque = new JSpinner();
		estoque.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		estoque.setBounds(75, 184, 44, 20);
		contentPane.add(estoque);
		
		JButton btnNewButton = new JButton("INSERIR");
		btnNewButton.setIcon(null);
		btnNewButton.setForeground(Color.MAGENTA);
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {{
								
				Connection con = Conexao.getConnection();
				String sql = "insert into Produtos(setor, modelo, tamanho, cor, preco, estoque) values"
						+ "(?, ?, ?, ?, ?, ?)";
				
				try {
				PreparedStatement st = con.prepareStatement(sql);
				// The 'String' and 'int' before some commands, is for type conversion
				st.setString(1, (String) setor.getSelectedItem());
				st.setString(2, modelo.getText().toUpperCase());
				st.setString(3, (String) tamanho.getSelectedItem());
				st.setString(4, cor.getText().toUpperCase());
				st.setFloat(5, preco.getValue());
				st.setInt(6, (int) estoque.getValue());
				
				st.executeUpdate();
				
				// close the statement and connection to free up espace
				st.close();
				con.close();
				
				
				
				
				JOptionPane.showMessageDialog(null, "DADOS INSERIDOS COM SUCESSO", "", -1);
				// abre uma nova tabela com os dados recém inseridos
			
				Read.main();
				frame.dispose();
				
				
			}catch (SQLException e1) {
				e1.printStackTrace();
				
				}
				
			}
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		});
		btnNewButton.setBounds(54, 227, 89, 23);
		contentPane.add(btnNewButton);
		
		
		preco.setBackground(Color.WHITE);
		preco.setBorder(new LineBorder(new Color(0, 0, 0)));
		preco.setPaintTrack(false);
		preco.setPaintTicks(true);
		preco.setPaintLabels(true);
		preco.setSnapToTicks(true);
		preco.setMaximum(500);
		preco.setFont(new Font("Tahoma", Font.PLAIN, 8));
		preco.setMinorTickSpacing(25);
		preco.setMajorTickSpacing(100);
		preco.setBounds(71, 129, 262, 41);
		
	}
}
