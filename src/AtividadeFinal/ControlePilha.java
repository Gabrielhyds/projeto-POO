package AtividadeFinal;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.border.EmptyBorder;
import javax.swing.JCheckBox;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

import java.awt.Font;
import java.awt.Panel;
import java.awt.TextArea;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JRadioButton;
import javax.swing.JScrollBar;
import javax.swing.JTree;
import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JSlider;

public class ControlePilha extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	Pilha idoso = new Pilha(TipoLista.IDOSO);
	Pilha idoso80 = new Pilha(TipoLista.IDOSO80);
	Pilha preferencial = new Pilha(TipoLista.PREFERENCIAL);
	private JTextField txtAguardeSerChamado;
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
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 939, 522);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JList list = new JList();
		list.setBounds(149, 74, 1, 1);
		contentPane.add(list);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"SELECIONE", "IDOSO", "IDOSO 80+", "NORMAL", "PREFERENCIAL", "URGENTE ", "VIP"}));
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 19));
		comboBox.setBounds(308, 231, 302, 64);
		contentPane.add(comboBox);
		
		JButton btnNewButton = new JButton("GERAR SENHA");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 int selection = comboBox.getSelectedIndex();
		            switch (selection) {
		                case 1:
	                		Pilha idoso = new Pilha(TipoLista.IDOSO);
	                		idoso.inserir();
	                		System.out.print(idoso.getTipoLista() +" "+idoso.listar());
	                		break;
		                case 2:
		                	Pilha idoso80 = new Pilha(TipoLista.IDOSO80);
	                		idoso80.inserir();
		                	JOptionPane.showMessageDialog(null, "sucesso ");
		                	System.out.print(idoso80.getTipoLista() +" "+idoso80.listar());
		                    break;
		                case 3:
		                	Pilha normal = new Pilha(TipoLista.NORMAL);
		                	normal.inserir();
		                    JOptionPane.showMessageDialog(null, "Sua senha é " + normal.listar());;
		                    break;
		                case 4:
		                	Pilha preferencial = new Pilha(TipoLista.PREFERENCIAL);
		                	preferencial.inserir();
		                    JOptionPane.showMessageDialog(null, "Sua senha é " + preferencial.listar());
		                    break;
		                case 5:
		                	Pilha urgente = new Pilha(TipoLista.URGENTE);
		                	urgente.inserir();
		                    JOptionPane.showMessageDialog(null, "Sua senha é " + urgente.listar());
		                    break;
		                case 6:
		                	Pilha vip = new Pilha(TipoLista.VIP);
		                	vip.inserir();
		                    JOptionPane.showMessageDialog(null, "Sua senha é " + vip.listar());
		                    break;
		                default:
		                	JOptionPane.showMessageDialog(null, "Selecione uma opção");
		                    break;
		            }
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(308, 327, 302, 45);
		contentPane.add(btnNewButton);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(655, 0, 270, 700);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1_1 = new JLabel("FILAS DE ATENDIMENTO");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(10, 25, 302, 25);
		panel_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("IDOSO");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2.setBounds(10, 61, 70, 25);
		panel_1.add(lblNewLabel_1_2);
		
		TextArea textArea = new TextArea();
		textArea.setBounds(10, 92, 188, 60);
		panel_1.add(textArea);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("IDOSO 80+");
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2_1.setBounds(10, 170, 88, 25);
		panel_1.add(lblNewLabel_1_2_1);
		
		TextArea textArea_1 = new TextArea();
		textArea_1.setBounds(10, 201, 188, 60);
		panel_1.add(textArea_1);
		
		JLabel lblNewLabel_1_2_2 = new JLabel("NORMAL");
		lblNewLabel_1_2_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2_2.setBounds(10, 277, 70, 25);
		panel_1.add(lblNewLabel_1_2_2);
		
		TextArea textArea_2 = new TextArea();
		textArea_2.setBounds(10, 308, 188, 60);
		panel_1.add(textArea_2);
		
		JLabel lblNewLabel_1_2_3 = new JLabel("PREFERENCIAL");
		lblNewLabel_1_2_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2_3.setBounds(10, 385, 116, 25);
		panel_1.add(lblNewLabel_1_2_3);
		
		TextArea textArea_3 = new TextArea();
		textArea_3.setBounds(10, 416, 188, 60);
		panel_1.add(textArea_3);
		
		JLabel lblNewLabel_1_2_3_1 = new JLabel("PREFERENCIAL");
		lblNewLabel_1_2_3_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2_3_1.setBounds(10, 385, 116, 25);
		panel_1.add(lblNewLabel_1_2_3_1);
		
		TextArea textArea_3_1 = new TextArea();
		textArea_3_1.setBounds(10, 416, 188, 60);
		panel_1.add(textArea_3_1);
		
		JLabel lblNewLabel_1_2_3_2 = new JLabel("URGENTE");
		lblNewLabel_1_2_3_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2_3_2.setBounds(10, 489, 116, 25);
		panel_1.add(lblNewLabel_1_2_3_2);
		
		TextArea textArea_3_2 = new TextArea();
		textArea_3_2.setBounds(10, 520, 188, 60);
		panel_1.add(textArea_3_2);
		
		JLabel lblNewLabel_1_2_3_2_1 = new JLabel("VIP");
		lblNewLabel_1_2_3_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2_3_2_1.setBounds(10, 599, 116, 25);
		panel_1.add(lblNewLabel_1_2_3_2_1);
		
		TextArea textArea_3_2_1 = new TextArea();
		textArea_3_2_1.setBounds(10, 630, 188, 60);
		panel_1.add(textArea_3_2_1);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		scrollBar.setBounds(253, 0, 17, 690);
		panel_1.add(scrollBar);
		
		txtAguardeSerChamado = new JTextField();
		txtAguardeSerChamado.setForeground(new Color(0, 0, 0));
		txtAguardeSerChamado.setHorizontalAlignment(SwingConstants.CENTER);
		txtAguardeSerChamado.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtAguardeSerChamado.setText("Aguarde ser chamado...");
		txtAguardeSerChamado.setEditable(false);
		txtAguardeSerChamado.setBounds(308, 74, 302, 70);
		contentPane.add(txtAguardeSerChamado);
		txtAguardeSerChamado.setColumns(10);
		
		Panel panel = new Panel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 219, 700);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\MICRO\\Downloads\\Design sem nome (28).png"));
		lblNewLabel.setBounds(0, 0, 219, 201);
		panel.add(lblNewLabel);
		
		JButton btnNewButton_2 = new JButton("CHAMAR");
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_2.setBounds(42, 229, 146, 45);
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_2_1 = new JButton("ATENDER");
		btnNewButton_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_2_1.setBounds(42, 285, 146, 45);
		panel.add(btnNewButton_2_1);
		
		JButton btnNewButton_1 = new JButton("SAIR");
		btnNewButton_1.setBounds(42, 347, 146, 45);
		panel.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
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


//Gostosa