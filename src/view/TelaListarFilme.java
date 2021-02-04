package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.bean.Filme;
import model.dao.FilmeDAO;

import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaListarFilme extends JFrame {

	private JPanel contentPane;
	private JTable tableFilme;

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
	public TelaListarFilme() {
		setTitle("ListagemFilmes");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 570, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblListarFilmes = new JLabel("Listagem de Filmes");
		lblListarFilmes.setFont(new Font("Arial", Font.BOLD, 16));
		lblListarFilmes.setBounds(194, 11, 154, 24);
		contentPane.add(lblListarFilmes);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 46, 513, 199);
		contentPane.add(scrollPane);
		
		tableFilme = new JTable();
		tableFilme.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"idFilme", "Titulo", "Categoria", "Tempo"
			}
		));
		scrollPane.setViewportView(tableFilme);
		
		JButton btnCadastrarFilme = new JButton("Cadastrar filme");
		btnCadastrarFilme.setFont(new Font("Arial", Font.PLAIN, 11));
		btnCadastrarFilme.setBounds(85, 265, 105, 24);
		contentPane.add(btnCadastrarFilme);
		
		JButton btnAlterarFilme = new JButton("Alterar filme");
		btnAlterarFilme.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(tableFilme.getSelectedRow()!= -1) {
					TelaAtualizarFilme af = new TelaAtualizarFilme(
							(int)tableFilme.getValueAt(tableFilme.getSelectedRow(), 0));
					af.setVisible(true);
				}else {
					JOptionPane.showMessageDialog(null, "Selecione um filme!");
				}
				readJTable();
			
			}
		});
		btnAlterarFilme.setFont(new Font("Arial", Font.PLAIN, 11));
		btnAlterarFilme.setBounds(218, 266, 99, 24);
		contentPane.add(btnAlterarFilme);
		
		JButton btnDeletarFilme = new JButton("Deletar filme");
		btnDeletarFilme.setHorizontalAlignment(SwingConstants.RIGHT);
		btnDeletarFilme.setFont(new Font("Arial", Font.PLAIN, 11));
		btnDeletarFilme.setBounds(346, 266, 89, 23);
		contentPane.add(btnDeletarFilme);
		
		readJTable();
		
	}
	
	public void readJTable() {
		DefaultTableModel modelo = (DefaultTableModel) tableFilme.getModel();
		modelo.setNumRows(0);
		FilmeDAO fdao = new FilmeDAO();
		for(Filme f : fdao.read()) {
			modelo.addRow(new Object[] {
					f.getIdFilme(),
					f.getTitulo(),
					f.getCategoria(),
					f.getTempo()
			});
		}
		
	}
}