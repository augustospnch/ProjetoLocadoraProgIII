package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.bean.Cliente;
import model.dao.ClienteDAO;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;

public class TelaAtualizarCliente extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textNomeCliente;
	private JTextField textEmailCliente;
	private JTextField textTelefoneCliente;
	private JTextField textCPFCliente;
	private JTextField textEnderecoCliente;
	
	private static int id;

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaAtualizarCliente frame = new TelaAtualizarCliente(id);
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
	public TelaAtualizarCliente(int id) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 571, 407);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAtualizarCliente = new JLabel("Atualizar cliente:");
		lblAtualizarCliente.setFont(new Font("Arial", Font.BOLD, 15));
		lblAtualizarCliente.setBounds(217, 11, 132, 17);
		contentPane.add(lblAtualizarCliente);
		
		ClienteDAO fdao = new ClienteDAO();
		Cliente f = fdao.read(id);
		
		JLabel lblNewLabel = new JLabel("ID do cliente:");
		lblNewLabel.setBounds(404, 27, 64, 17);
		contentPane.add(lblNewLabel);
		
		JLabel lblId = new JLabel("New label");
		lblId.setBounds(467, 28, 46, 14);
		contentPane.add(lblId);
		
		JLabel lblNomeCliente = new JLabel("Nome:");
		lblNomeCliente.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNomeCliente.setBounds(10, 48, 46, 14);
		contentPane.add(lblNomeCliente);
		
		textNomeCliente = new JTextField();
		textNomeCliente.setBounds(10, 68, 535, 20);
		contentPane.add(textNomeCliente);
		textNomeCliente.setColumns(10);
		
		JLabel lblEmailCliente = new JLabel("Email:");
		lblEmailCliente.setFont(new Font("Arial", Font.PLAIN, 12));
		lblEmailCliente.setBounds(10, 115, 46, 14);
		contentPane.add(lblEmailCliente);
		
		textEmailCliente = new JTextField();
		textEmailCliente.setBounds(10, 134, 535, 20);
		contentPane.add(textEmailCliente);
		textEmailCliente.setColumns(10);
		
		JLabel lblTelefoneCliente = new JLabel("Telefone:");
		lblTelefoneCliente.setFont(new Font("Arial", Font.PLAIN, 12));
		lblTelefoneCliente.setBounds(10, 183, 51, 14);
		contentPane.add(lblTelefoneCliente);
		
		textTelefoneCliente = new JTextField();
		textTelefoneCliente.setBounds(10, 201, 154, 20);
		contentPane.add(textTelefoneCliente);
		textTelefoneCliente.setColumns(10);
		
		JLabel lblCPFCliente = new JLabel("CPF:");
		lblCPFCliente.setFont(new Font("Arial", Font.PLAIN, 12));
		lblCPFCliente.setBounds(10, 242, 46, 14);
		contentPane.add(lblCPFCliente);
		
		textCPFCliente = new JTextField();
		textCPFCliente.setBounds(10, 261, 154, 20);
		contentPane.add(textCPFCliente);
		textCPFCliente.setColumns(10);
		
		JLabel lblEnderecoCliente = new JLabel("Endereço:");
		lblEnderecoCliente.setFont(new Font("Arial", Font.PLAIN, 12));
		lblEnderecoCliente.setBounds(264, 184, 56, 14);
		contentPane.add(lblEnderecoCliente);
		
		textEnderecoCliente = new JTextField();
		textEnderecoCliente.setBounds(264, 201, 281, 80);
		contentPane.add(textEnderecoCliente);
		textEnderecoCliente.setColumns(10);
		
		JButton btnNewButton = new JButton("Limpar");
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 12));
		btnNewButton.setBounds(124, 319, 89, 23);
		contentPane.add(btnNewButton);
		
		lblId.setText(String.valueOf(f.getIdCliente()));
		lblNomeCliente.setText(f.getNome());
		lblEmailCliente.setText(f.getEmail());
		lblTelefoneCliente.setText(f.getTelefone());
		lblEnderecoCliente.setText(f.getEndereco());
		f.setCpf(Integer.parseInt(textCPFCliente.getText().toString()));
		
		JButton btnAtualizarCliente = new JButton("Atualizar");
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cliente f = new Cliente();
				ClienteDAO dao = new ClienteDAO();
				f.setNome(textNomeCliente.getText());
				f.setEmail(textEmailCliente.getText());
				f.setTelefone(textTelefoneCliente.getText());
				f.setEndereco(textEnderecoCliente.getText());
				f.setCpf(Integer.parseInt(textCPFCliente.getText().toString()));
				
				dao.update(f);
			}
			
		});
		btnAtualizarCliente.setFont(new Font("Arial", Font.BOLD, 12));
		btnAtualizarCliente.setBounds(242, 320, 89, 23);
		contentPane.add(btnAtualizarCliente);
		
		JButton btnNewButton_2 = new JButton("Cancelar");
		btnNewButton_2.setFont(new Font("Arial", Font.PLAIN, 12));
		btnNewButton_2.setBounds(361, 320, 89, 23);
		contentPane.add(btnNewButton_2);
		
	}
}
