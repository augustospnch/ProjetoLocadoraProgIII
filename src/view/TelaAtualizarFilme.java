package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.bean.Filme;
import model.dao.FilmeDAO;

import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;

public class TelaAtualizarFilme extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldTitulo;
	private JTextField textFieldSinopse;
	private JTextField textFieldCategoria;
	
	private static int id;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaAtualizarFilme frame = new TelaAtualizarFilme(id);
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
	public TelaAtualizarFilme(int id) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 551, 389);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAtualizarFilme = new JLabel("Atualizar filme:");
		lblAtualizarFilme.setFont(new Font("Arial", Font.BOLD, 17));
		lblAtualizarFilme.setBounds(212, 11, 128, 19);
		contentPane.add(lblAtualizarFilme);
		
		FilmeDAO fdao = new FilmeDAO();
		Filme f = fdao.read(id);
		
		JLabel lblNewLabel = new JLabel("ID do filme:");
		lblNewLabel.setBounds(396, 15, 57, 19);
		contentPane.add(lblNewLabel);
		
		JLabel lblId = new JLabel("New label");
		lblId.setBounds(457, 15, 57, 19);
		contentPane.add(lblId);
		
		
		JLabel lblTitulo = new JLabel("T\u00EDtulo");
		lblTitulo.setFont(new Font("Arial", Font.PLAIN, 12));
		lblTitulo.setBounds(248, 41, 37, 14);
		contentPane.add(lblTitulo);
		
		textFieldTitulo = new JTextField();
		textFieldTitulo.setBounds(10, 58, 515, 20);
		contentPane.add(textFieldTitulo);
		textFieldTitulo.setColumns(10);
		
		JLabel lblSinopse = new JLabel("Sinopse:");
		lblSinopse.setFont(new Font("Arial", Font.PLAIN, 12));
		lblSinopse.setBounds(239, 89, 46, 19);
		contentPane.add(lblSinopse);
		
		textFieldSinopse = new JTextField();
		textFieldSinopse.setBounds(10, 109, 515, 74);
		contentPane.add(textFieldSinopse);
		textFieldSinopse.setColumns(10);
		
		JLabel lblCategoria = new JLabel("Categoria:");
		lblCategoria.setFont(new Font("Arial", Font.PLAIN, 12));
		lblCategoria.setBounds(10, 194, 57, 14);
		contentPane.add(lblCategoria);
		
		textFieldCategoria = new JTextField();
		textFieldCategoria.setBounds(10, 210, 320, 20);
		contentPane.add(textFieldCategoria);
		textFieldCategoria.setColumns(10);
		
		JLabel lblDuracao = new JLabel("Dura\u00E7\u00E3o:");
		lblDuracao.setFont(new Font("Arial", Font.PLAIN, 12));
		lblDuracao.setBounds(475, 194, 50, 14);
		contentPane.add(lblDuracao);
		
		JSpinner spinnerDuracao = new JSpinner();
		spinnerDuracao.setBounds(440, 210, 85, 20);
		contentPane.add(spinnerDuracao);
		
		JRadioButton nrb2D = new JRadioButton("2D");
		nrb2D.setFont(new Font("Arial", Font.PLAIN, 12));
		nrb2D.setBounds(10, 258, 46, 19);
		contentPane.add(nrb2D);
		
		JRadioButton nrb3D = new JRadioButton("3D");
		nrb3D.setFont(new Font("Arial", Font.PLAIN, 12));
		nrb3D.setBounds(58, 256, 46, 23);
		contentPane.add(nrb3D);
		
		ButtonGroup imagem = new ButtonGroup();
		imagem.add(nrb3D);
		imagem.add(nrb2D);
		
		JLabel lblImagem = new JLabel("Imagem:");
		lblImagem.setFont(new Font("Arial", Font.PLAIN, 12));
		lblImagem.setBounds(10, 241, 57, 14);
		contentPane.add(lblImagem);
		
		JLabel lblAudio = new JLabel("\u00C1udio:");
		lblAudio.setFont(new Font("Arial", Font.PLAIN, 12));
		lblAudio.setBounds(145, 242, 46, 14);
		contentPane.add(lblAudio);
		
		JRadioButton nrbDublado = new JRadioButton("Dublado");
		nrbDublado.setFont(new Font("Arial", Font.PLAIN, 12));
		nrbDublado.setBounds(145, 257, 73, 23);
		contentPane.add(nrbDublado);
		
		JRadioButton nrbLegendado = new JRadioButton("Legendado");
		nrbLegendado.setFont(new Font("Arial", Font.PLAIN, 12));
		nrbLegendado.setBounds(220, 257, 109, 23);
		contentPane.add(nrbLegendado);
		
		ButtonGroup audio = new ButtonGroup();
		audio.add(nrbDublado);
		audio.add(nrbLegendado);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setFont(new Font("Arial", Font.PLAIN, 12));
		btnLimpar.setBounds(102, 316, 89, 23);
		contentPane.add(btnLimpar);
		
		lblId.setText(String.valueOf(f.getIdFilme()));
		lblTitulo.setText(f.getTitulo());
		spinnerDuracao.setValue(f.getTempo());
		if(f.isImagem() == true) {
			nrb3D.setSelected(true);
		}else if (f.isImagem() == false) {
			nrb2D.setSelected(true);
		}
		if(f.isAudio() == true) {
			nrbDublado.setSelected(true);
		}else if (f.isAudio() == false) {
			nrbLegendado.setSelected(true);
		}
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Filme f = new Filme();
				FilmeDAO dao = new FilmeDAO();
				f.setTitulo(textFieldTitulo.getText());
				f.setSinopse(textFieldSinopse.getText());
				f.setCategoria(textFieldCategoria.getText());
				f.setTempo(Integer.parseInt(spinnerDuracao.getValue().toString()));
				if(nrb2D.isSelected()) {
					f.setImagem(false);
				}else if(nrb3D.isSelected()) {
					f.setImagem(true);
				}
				if(nrbDublado.isSelected()) {
					f.setAudio(true);
				}else if(nrbLegendado.isSelected()) {
					f.setAudio(false);
				}
				
				dao.update(f);
			}
			
		});
		btnAtualizar.setFont(new Font("Arial", Font.BOLD, 12));
		btnAtualizar.setBounds(220, 316, 89, 23);
		contentPane.add(btnAtualizar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Arial", Font.PLAIN, 12));
		btnCancelar.setBounds(337, 316, 89, 23);
		contentPane.add(btnCancelar);
		
	}
}
