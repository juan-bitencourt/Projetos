package GUIs;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Tudo extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tudo frame = new Tudo();
					frame.setLocationRelativeTo(null);
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
	public Tudo() {
		setTitle("ESTOQUE ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 446, 187);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 30, 5, 30));
		setContentPane(contentPane);
		
		
		JButton select = new JButton("VER TODOS");
		select.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Read.main();
			}
		});
		
		JButton update = new JButton("DELETAR");
		update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Delete.main();
			}
		});
		
		JLabel lblNewLabel = new JLabel("O QUE DESEJA FAZER?");
		lblNewLabel.setFont(new Font("Tahoma", Font.ITALIC, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
// ------------------------ BOTÕES E FUNÇÕES ------------------------------------------- //
		
		JButton insert = new JButton("ADICIONAR");
		insert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Create.main();
			}
		});
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("                                                                                                                                                                 ");
		contentPane.add(lblNewLabel_1);
		contentPane.add(insert);
		contentPane.add(update);
		contentPane.add(select);
	}
}
