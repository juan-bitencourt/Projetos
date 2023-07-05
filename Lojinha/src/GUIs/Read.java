package GUIs;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import estoque.Categorias;
import estoque.Comandos;


public class Read extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	
	
	private JPanel painelFundo;
	private JPanel painelBotoes;
	private JTable tabela;
	private JScrollPane barraRolagem;
	
	private DefaultTableModel modelo = new DefaultTableModel();
		
	
	
	
	// execução do código
	public static void main() {
		Read sel = new Read();
		// para mostrar a janela no meio da tela
		sel.setLocationRelativeTo(null);
		sel.setVisible(true);
		
		
	}
	
	
	public Read() {
		super("ESTOQUE");
		criaJTable();
		criaJanela();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		
	}
	// método para criação da Janela onde vai a aplicação
	public void criaJanela() {
		// 2 "janelas" diferentes, apenas para fazer os botões ficarem na parte inferior
		painelBotoes = new JPanel();
		painelFundo = new JPanel();
		
		barraRolagem = new JScrollPane(tabela);
		painelFundo.setLayout(new BorderLayout());
		// CENTER E SOUTH são os locais onde cada janela irá ficar
		// isso ajuda a não precisar ficar testando pixel por pixel para achar a posição certa
		painelFundo.add(BorderLayout.CENTER, barraRolagem);
		painelFundo.add(BorderLayout.SOUTH, painelBotoes);

		JButton vender = new JButton ("VENDER / COMPRAR");
		painelBotoes.add(vender);
		vender.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Update.main();
//				sel.setVisible(false);
				
			}
			
		});
		
		vender.setBounds(120, 130, 118, 20);
		
		
		getContentPane().add(painelFundo);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(900, 320);
		setVisible(true);
		
		
	}
		
	// criação da tabela 
	private void criaJTable() {
		tabela = new JTable(modelo);
		tabela.setEnabled(false);
	
		modelo.addColumn("Id");
		modelo.addColumn("Setor");
		modelo.addColumn("Modelo");
		modelo.addColumn("Tamanho");
		modelo.addColumn("Cor");
		modelo.addColumn("Preco");
		modelo.addColumn("Estoque");
		
		tabela.getColumnModel().getColumn(0)
		.setPreferredWidth(5);
		tabela.getColumnModel().getColumn(1)
		.setPreferredWidth(10);
		tabela.getColumnModel().getColumn(1)
		.setPreferredWidth(400);
		tabela.getColumnModel().getColumn(1)
		.setPreferredWidth(10);
		tabela.getColumnModel().getColumn(1)
		.setPreferredWidth(10);
		tabela.getColumnModel().getColumn(1)
		.setPreferredWidth(5);
		tabela.getColumnModel().getColumn(1)
		.setPreferredWidth(10);
		
		pesquisar(modelo);
	}
	// coloca as linhas que buscou no BD
	public static void pesquisar(DefaultTableModel modelo) {
		modelo.setNumRows(0);
		Comandos cmd = new Comandos();

		for (Categorias c : cmd.ver()) {
			modelo.addRow(new Object[]{c.getId(), c.getSetor(),
			c.getModelo(), c.getTamanho(), c.getCor(), c.getPreco(), c.getEstoque()});
		}
	}
	
	
	
	
	
}
