package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JRadioButton;
import javax.swing.JButton;

public class TelaCadastroFilme extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldTitulo;
	private JTextField textFieldSinopse;
	private JTextField textFieldCategoria;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroFilme frame = new TelaCadastroFilme();
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
	public TelaCadastroFilme() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 551, 389);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCadastrarFilme = new JLabel("Cadastrar filme:");
		lblCadastrarFilme.setFont(new Font("Arial", Font.BOLD, 17));
		lblCadastrarFilme.setBounds(202, 11, 128, 19);
		contentPane.add(lblCadastrarFilme);
		
		JLabel lblTitulo = new JLabel("T\u00EDtulo");
		lblTitulo.setFont(new Font("Arial", Font.PLAIN, 12));
		lblTitulo.setBounds(248, 41, 37, 14);
		contentPane.add(lblTitulo);
		
		textFieldTitulo = new JTextField();
		textFieldTitulo.setBounds(10, 58, 515, 20);
		contentPane.add(textFieldTitulo);
		textFieldTitulo.setColumns(10);
		
		JLabel lblSinopse = new JLabel("Sinopse");
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
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setFont(new Font("Arial", Font.PLAIN, 12));
		btnLimpar.setBounds(102, 316, 89, 23);
		contentPane.add(btnLimpar);
		
		JButton button = new JButton("New button");
		button.setBounds(228, 317, 37, 1);
		contentPane.add(button);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setFont(new Font("Arial", Font.BOLD, 12));
		btnCadastrar.setBounds(220, 316, 89, 23);
		contentPane.add(btnCadastrar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Arial", Font.PLAIN, 12));
		btnCancelar.setBounds(337, 316, 89, 23);
		contentPane.add(btnCancelar);
	}
}
