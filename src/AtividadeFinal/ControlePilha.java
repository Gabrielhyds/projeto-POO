package AtividadeFinal;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JCheckBox;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Comparator;

import javax.swing.JRadioButton;
import javax.swing.JTree;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JSlider;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Panel;
import javax.swing.JSpinner;
import javax.swing.JTextPane;
import java.awt.Canvas;
import java.awt.Scrollbar;
import javax.swing.AbstractListModel;
import javax.swing.SwingConstants;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JCheckBoxMenuItem;
import java.awt.Choice;
import java.awt.List;
import java.awt.TextArea;
import java.awt.ScrollPane;
import javax.swing.JScrollBar;

public class ControlePilha extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtPainelSenha;

	private Pilha idoso;
	private Pilha idoso80;
	private Pilha preferencial;
	private Pilha normal;
	private Pilha vip;
	private Pilha urgente;

	private TextArea txtIdoso;
	private TextArea txtIdoso80;
	private TextArea txtNormal;
	private TextArea txtPreferencial;
	private TextArea txtUrgente;
	private TextArea txtVip;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ControlePilha frame = new ControlePilha();
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
	public ControlePilha() {
		idoso = new Pilha(TipoLista.IDOSO);
		idoso80 = new Pilha(TipoLista.IDOSO80);
		preferencial = new Pilha(TipoLista.PREFERENCIAL);
		normal = new Pilha(TipoLista.NORMAL);
		vip = new Pilha(TipoLista.VIP);
		urgente = new Pilha(TipoLista.URGENTE);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 939, 739);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JList list = new JList();
		list.setBounds(149, 74, 1, 1);
		contentPane.add(list);

		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "SELECIONE", "IDOSO", "IDOSO 80+", "NORMAL", "PREFERENCIAL", "URGENTE ", "VIP" }));
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 19));
		comboBox.setBounds(308, 231, 302, 64);
		contentPane.add(comboBox);

		JPanel panel_22 = new JPanel();

		txtIdoso = new TextArea();
		txtIdoso.setBounds(10, 92, 188, 60);
		panel_22.add(txtIdoso);

		txtIdoso80 = new TextArea();
		txtIdoso80.setBounds(10, 201, 188, 60);
		panel_22.add(txtIdoso80);

		txtNormal = new TextArea();
		txtNormal.setBounds(10, 308, 188, 60);
		panel_22.add(txtNormal);

		txtPreferencial = new TextArea();
		txtPreferencial.setBounds(10, 416, 188, 60);
		panel_22.add(txtPreferencial);

		txtUrgente = new TextArea();
		txtUrgente.setBounds(10, 520, 188, 60);
		panel_22.add(txtUrgente);

		txtVip = new TextArea();
		txtVip.setBounds(10, 630, 188, 60);
		panel_22.add(txtVip);

		

		JButton btnNewButton = new JButton("GERAR SENHA");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selection = comboBox.getSelectedIndex();
				switch (selection) {
					case 1:
						idoso.inserir();
						txtIdoso.setText(idoso.listar());
						break;
					case 2:
						idoso80.inserir();
						txtIdoso80.setText(idoso80.listar());
						break;
					case 3:
						normal.inserir();
						txtNormal.setText(normal.listar());
						break;
					case 4:
						preferencial.inserir();
						txtPreferencial.setText(preferencial.listar());
						break;
					case 5:
						urgente.inserir();
						txtUrgente.setText(urgente.listar());
						break;
					case 6:
						vip.inserir();
						txtVip.setText(vip.listar());
						break;
					default:
						JOptionPane.showMessageDialog(null, "Selecione uma opção");
						break;
				}
			}
		});

		Panel panel = new Panel();
		JButton btnNewButton_2 = new JButton("CHAMAR");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				   Pilha[] pilhas = { normal, idoso, idoso80, preferencial, vip, urgente };
			        double valor = 0.0;
			        double maiorValor = 0;
			        int indiceMaiorPilha = -1; 
			        for (int i = 0; i < pilhas.length; i++) {
			        	if(!pilhas[i].equals(urgente) && pilhas[i] != null) {
			        		valor = pilhas[i].tamanho() * (i + 1); // Multiplica o tamanho da pilha pelo índice do vetor mais 1
				            System.out.println("Valor da pilha " + pilhas[i].getTipoLista() + ": " + valor);	
			        		
			        	}
			        	else {
			        		valor = pilhas[i].tamanho() * (i + 5); 
			        		System.out.println("Valor da pilha " + pilhas[i].getTipoLista() + ": " + valor);
			        	}
			        	 if (valor > maiorValor) {
			        		String mensagem = pilhas[i].chamar();
			 				txtPainelSenha.setText(mensagem);
			 				indiceMaiorPilha = i;
			        	 }
			        }
			        switch (indiceMaiorPilha) {
			        case 0:
			            // A maior pilha é normal
			        	txtNormal.setText(normal.listar());
			            break;
			        case 1:
			            // A maior pilha é idoso
			        	txtIdoso.setText(idoso.listar());
			            break;
			        case 2:
			            // A maior pilha é idoso80
			        	txtIdoso80.setText(idoso80.listar());
			            break;
			        case 3:
			            // A maior pilha é preferencial
			        	txtPreferencial.setText(preferencial.listar());
			            break;
			        case 4:
			            // A maior pilha é vip
			        	txtVip.setText(vip.listar());
			            break;
			        case 5:
			            // A maior pilha é urgente
			        	txtUrgente.setText(urgente.listar());
			            break;
			        default:
			            // Caso o índice não corresponda a nenhuma pilha conhecida
			        	System.out.println("PORRA SCOOBY DO dnv");
			            break;
			    }
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_2.setBounds(42, 229, 146, 45);
		panel.add(btnNewButton_2);

		JButton btnNewButton_2_1 = new JButton("ATENDER");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//atender
			}
		});
		btnNewButton_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_2_1.setBounds(42, 285, 146, 45);
		panel.add(btnNewButton_2_1);
		
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(308, 327, 302, 45);
		contentPane.add(btnNewButton);

		panel_22.setBounds(655, 0, 270, 700);
		contentPane.add(panel_22);
		panel_22.setLayout(null);

		JLabel lblNewLabel_1_1 = new JLabel("FILAS DE ATENDIMENTO");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(10, 25, 302, 25);
		panel_22.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("IDOSO");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2.setBounds(10, 61, 70, 25);
		panel_22.add(lblNewLabel_1_2);

		JLabel lblNewLabel_1_2_1 = new JLabel("IDOSO 80+");
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2_1.setBounds(10, 170, 88, 25);
		panel_22.add(lblNewLabel_1_2_1);

		JLabel lblNewLabel_1_2_2 = new JLabel("NORMAL");
		lblNewLabel_1_2_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2_2.setBounds(10, 277, 70, 25);
		panel_22.add(lblNewLabel_1_2_2);

		JLabel lblNewLabel_1_2_3 = new JLabel("PREFERENCIAL");
		lblNewLabel_1_2_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2_3.setBounds(10, 385, 116, 25);
		panel_22.add(lblNewLabel_1_2_3);

		JLabel lblNewLabel_1_2_3_2 = new JLabel("URGENTE");
		lblNewLabel_1_2_3_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2_3_2.setBounds(10, 489, 116, 25);
		panel_22.add(lblNewLabel_1_2_3_2);

		JLabel lblNewLabel_1_2_3_2_1 = new JLabel("VIP");
		lblNewLabel_1_2_3_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2_3_2_1.setBounds(10, 599, 116, 25);
		panel_22.add(lblNewLabel_1_2_3_2_1);

		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(253, 0, 17, 700);
		panel_22.add(scrollBar);

		txtPainelSenha = new JTextField();
		txtPainelSenha.setForeground(new Color(0, 0, 0));
		txtPainelSenha.setHorizontalAlignment(SwingConstants.CENTER);
		txtPainelSenha.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtPainelSenha.setText("Aguarde ser chamado...");
		txtPainelSenha.setEditable(false);
		txtPainelSenha.setBounds(308, 74, 302, 70);
		contentPane.add(txtPainelSenha);
		txtPainelSenha.setColumns(10);

		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 219, 700);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\MICRO\\Downloads\\Design sem nome (28).png"));
		lblNewLabel.setBounds(0, 0, 219, 201);
		panel.add(lblNewLabel);

		JButton btnNewButton_1 = new JButton("SAIR");
		btnNewButton_1.setBounds(42, 341, 146, 45);
		panel.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[] { lblNewLabel, btnNewButton_2, btnNewButton_2_1, btnNewButton_1 }));

		JLabel lblNewLabel_1 = new JLabel("SELECIONE A FILA DE ATENDIMENTO");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(308, 200, 302, 25);
		contentPane.add(lblNewLabel_1);
	}

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
