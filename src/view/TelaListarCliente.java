package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.bean.Cliente;
import model.bean.Filme;
import model.dao.ClienteDAO;
import model.dao.FilmeDAO;

import javax.swing.JButton;
import javax.swing.SwingConstants;

public class TelaListarCliente extends JFrame {

	private JPanel contentPane;
	private JTable tableCliente;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaListarFilme frame = new TelaListarFilme();
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
	public TelaListarCliente() {
		setTitle("ListagemClientes");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 570, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblListarClientes = new JLabel("Listagem de Clientes");
		lblListarClientes.setFont(new Font("Arial", Font.BOLD, 16));
		lblListarClientes.setBounds(194, 11, 154, 24);
		contentPane.add(lblListarClientes);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 46, 513, 199);
		contentPane.add(scrollPane);
		
		tableCliente = new JTable();
		tableCliente.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"idCliente", "Nome", "Telefone", "Email"
			}
		));
		scrollPane.setViewportView(tableCliente);
		
		JButton btnCadastrarCliente = new JButton("Cadastrar cliente");
		btnCadastrarCliente.setFont(new Font("Arial", Font.PLAIN, 11));
		btnCadastrarCliente.setBounds(85, 265, 123, 24);
		contentPane.add(btnCadastrarCliente);
		
		JButton btnAlterarCliente = new JButton("Alterar cliente");
		btnAlterarCliente.setFont(new Font("Arial", Font.PLAIN, 11));
		btnAlterarCliente.setBounds(218, 266, 99, 24);
		contentPane.add(btnAlterarCliente);
		
		JButton btnDeletarCliente = new JButton("Deletar cliente");
		btnDeletarCliente.setHorizontalAlignment(SwingConstants.RIGHT);
		btnDeletarCliente.setFont(new Font("Arial", Font.PLAIN, 11));
		btnDeletarCliente.setBounds(327, 266, 108, 23);
		contentPane.add(btnDeletarCliente);
		
		readJTable();
		
	}
	
	public void readJTable() {
		DefaultTableModel modelo = (DefaultTableModel) tableCliente.getModel();
		modelo.setNumRows(0);
		ClienteDAO fdao = new ClienteDAO();
		for(Cliente f : fdao.read()) {
			modelo.addRow(new Object[] {
					f.getIdCliente(),
					f.getNome(),
					f.getTelefone(),
					f.getEmail()
			});
		}
		
	}
}