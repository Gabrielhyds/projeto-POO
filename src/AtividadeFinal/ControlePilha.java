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
import java.awt.SystemColor;
import javax.swing.JScrollPane;

public class ControlePilha extends JFrame {

	
	// ATRIBUTOS
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtPainelSenha;
	
	//ATRIBUTOS DO TIPO PILHA
	private Pilha idoso;
	private Pilha idoso80;
	private Pilha preferencial;
	private Pilha normal;
	private Pilha vip;
	private Pilha urgente;

	//ATRIBUTOS DO TIPO TEXTAREA
	private TextArea txtIdoso;
	private TextArea txtIdoso80;
	private TextArea txtNormal;
	private TextArea txtPreferencial;
	private TextArea txtUrgente;
	private TextArea txtVip;
	
	
	//Declarando o array de pilhas
    private Pilha[] pilhas;
    private double valor = 0.0;
    private int indiceMaiorPilha = -1;

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
		setTitle("SISTEMA GERENCIADOR DE SENHAS");
		
		//INICIANDO AS PILHAS COM OS TIPOSLISTA
		idoso = new Pilha(TipoLista.IDOSO);
		idoso80 = new Pilha(TipoLista.IDOSO80);
		preferencial = new Pilha(TipoLista.PREFERENCIAL);
		normal = new Pilha(TipoLista.NORMAL);
		vip = new Pilha(TipoLista.VIP);
		urgente = new Pilha(TipoLista.URGENTE);
	
		//Iniciando o array de pilhas
        pilhas = new Pilha[] { normal, idoso, idoso80, preferencial, vip, urgente };
        
        
        //iniciando o frame 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1049, 630);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(65, 105, 225));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JList list = new JList();
		list.setBounds(149, 74, 1, 1);
		contentPane.add(list);

		// adicionando o combobox para o user escolher a fila de atendimento
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "SELECIONE", "IDOSO", "IDOSO 80+", "NORMAL", "PREFERENCIAL", "URGENTE ", "VIP" }));
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 19));
		comboBox.setBounds(369, 268, 302, 64);
		contentPane.add(comboBox);

		
		// botão gerar senha
		JButton btnNewButton = new JButton("GERAR SENHA");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//declarando a variavel selection e atribuindo a ela os indices do combobox
				int selection = comboBox.getSelectedIndex();
				
				//iniciando o switch case para cada indice
				switch (selection) {
					case 1: // caso seja selecionado o 1 é o idoso
						idoso.inserir(); // inseri na pilha a senha gerada para o idoso
						txtIdoso.setText(idoso.listar()); // lista no txtarea o idoso
						break; // para o programa
					case 2: // caso seja selecionado o 2 é o idoso80
						idoso80.inserir();  // inseri na pilha a senha gerada para o idoso80
						txtIdoso80.setText(idoso80.listar()); // lista no txtarea o idoso80
						break;
					case 3: // caso seja selecionado o 3 é o normal
						normal.inserir(); // inseri na pilha a senha gerada para o normal
						txtNormal.setText(normal.listar()); // lista no txtarea o normal
						break;
					case 4: // caso seja selecionado o 4 é o preferencial
						preferencial.inserir(); // inseri na pilha a senha gerada para o preferencial
						txtPreferencial.setText(preferencial.listar()); // lista no txtarea o preferencial
						break;
					case 5: // caso seja selecionado o 5 é o urgente
						urgente.inserir(); // inseri na pilha a senha gerada para o urgente
						txtUrgente.setText(urgente.listar());  // lista no txtarea o urgente
						break;
					case 6: // caso seja selecionado o 6 é o vip
						vip.inserir(); // inseri na pilha a senha gerada para o vip
						txtVip.setText(vip.listar()); // lista no txtarea o vip
						break;
					default: // se não for nenhum dos casos acima então aciona essa mensagem na tela
						JOptionPane.showMessageDialog(null, "Selecione uma opção");
						break;
				}
			}
		});

		Panel panel = new Panel();
		
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(369, 364, 302, 45);
		contentPane.add(btnNewButton);

		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 1041, 87);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 1041, 87);
		panel.add(panel_1);
		panel_1.setBackground(new Color(32, 178, 170));
		panel_1.setLayout(null);
		
		
				
		JButton btnNewButton_1 = new JButton("SAIR");
		btnNewButton_1.setBounds(798, 18, 146, 45);
		panel_1.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));

		txtPainelSenha = new JTextField();
		txtPainelSenha.setBounds(370, 15, 302, 64);
		panel_1.add(txtPainelSenha);
		txtPainelSenha.setForeground(new Color(0, 0, 0));
		//txtPainelSenha.setHorizontalAlignment(SwingConstants.CENTER);
		txtPainelSenha.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtPainelSenha.setText("Aguarde ser chamado...");
		txtPainelSenha.setEditable(false);
		txtPainelSenha.setColumns(10);
		
		JLabel lblNewLabel_1_2_4 = new JLabel("CRM 01.892\r\n");
		lblNewLabel_1_2_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_2_4.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_1_2_4.setBounds(131, 34, 114, 45);
		panel_1.add(lblNewLabel_1_2_4);
		
		JLabel lblNewLabel_1_2_4_1 = new JLabel("Consultório DR. No Problem\r\n");
		lblNewLabel_1_2_4_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_2_4_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_1_2_4_1.setBounds(62, 9, 243, 45);
		panel_1.add(lblNewLabel_1_2_4_1);

		JLabel lblNewLabel_1 = new JLabel("SELECIONE A FILA DE ATENDIMENTO");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(369, 232, 302, 25);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("IDOSO");
		lblNewLabel_1_2.setBounds(79, 110, 70, 25);
		contentPane.add(lblNewLabel_1_2);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 15));


		txtIdoso = new TextArea();
		txtIdoso.setBounds(79, 141, 188, 100);
		contentPane.add(txtIdoso);
		txtIdoso.setEditable(false);
		txtIdoso.setForeground(Color.BLUE);
		txtIdoso.setFont(new Font("Arial",Font.BOLD,18));
		
		JLabel lblNewLabel_1_2_1 = new JLabel("IDOSO 80+");
		lblNewLabel_1_2_1.setBounds(79, 260, 152, 25);
		contentPane.add(lblNewLabel_1_2_1);
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		txtIdoso80 = new TextArea();
		txtIdoso80.setBounds(79, 291, 188, 100);
		contentPane.add(txtIdoso80);
		txtIdoso80.setEditable(false);
		txtIdoso80.setForeground(Color.RED);
		txtIdoso80.setFont(new Font("Arial",Font.BOLD,18));
		
		JLabel lblNewLabel_1_2_2 = new JLabel("NORMAL");
		lblNewLabel_1_2_2.setBounds(79, 409, 70, 25);
		contentPane.add(lblNewLabel_1_2_2);
		lblNewLabel_1_2_2.setFont(new Font("Tahoma", Font.BOLD, 15));
				
		txtNormal = new TextArea();
		txtNormal.setBounds(79, 440, 188, 100);
		contentPane.add(txtNormal);
		txtNormal.setEditable(false);
        txtNormal.setForeground(Color.GRAY);
		txtNormal.setFont(new Font("Arial",Font.BOLD,18));
						
		JLabel lblNewLabel_1_2_3 = new JLabel("PREFERENCIAL");
		lblNewLabel_1_2_3.setBounds(783, 110, 133, 25);
		contentPane.add(lblNewLabel_1_2_3);	
		lblNewLabel_1_2_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		txtPreferencial = new TextArea();
		txtPreferencial.setBounds(783, 141, 188, 100);
		contentPane.add(txtPreferencial);
		txtPreferencial.setEditable(false);
    	txtPreferencial.setForeground(Color.MAGENTA);
		txtPreferencial.setFont(new Font("Arial",Font.BOLD,18));

		JLabel lblNewLabel_1_2_3_2 = new JLabel("URGENTE");
		lblNewLabel_1_2_3_2.setBounds(783, 260, 188, 25);
		contentPane.add(lblNewLabel_1_2_3_2);
		lblNewLabel_1_2_3_2.setFont(new Font("Tahoma", Font.BOLD, 15));
												
		txtUrgente = new TextArea();
		txtUrgente.setBounds(783, 291, 188, 100);
		contentPane.add(txtUrgente);
		txtUrgente.setEditable(false);
		txtUrgente.setForeground(Color.GREEN);
		txtUrgente.setFont(new Font("Arial",Font.BOLD,18));

		JLabel lblNewLabel_1_2_3_2_1 = new JLabel("VIP");
		lblNewLabel_1_2_3_2_1.setBounds(783, 409, 116, 25);
		contentPane.add(lblNewLabel_1_2_3_2_1);
		lblNewLabel_1_2_3_2_1.setFont(new Font("Tahoma", Font.BOLD, 15));
																
		txtVip = new TextArea();
		txtVip.setBounds(786, 440, 188, 100);
		contentPane.add(txtVip);
		txtVip.setEditable(false);
		txtVip.setForeground(Color.ORANGE);
		txtVip.setFont(new Font("Arial",Font.BOLD,18));
		
		
		
		JButton btnNewButton_2 = new JButton("CHAMAR");
		btnNewButton_2.setBounds(369, 440, 146, 45);
		contentPane.add(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			      double maiorValor = 0;
			     // Iterando sobre as pilhas
			        for (int i = 0; i < pilhas.length; i++) {
			            // Calculando o valor da pilha de acordo com o tipo
			            switch (pilhas[i].getTipoLista()) {
			                case IDOSO:
			                    valor = pilhas[i].tamanho() * 3.0; // Valor para a pilha de idoso
			                    break;
			                case IDOSO80:
			                    valor = pilhas[i].tamanho() * 3.5; // Valor para a pilha de idosos acima de 80 anos
			                   
			                    break;
			                case PREFERENCIAL:
			                    valor = pilhas[i].tamanho() * 4.0; // Valor para a pilha preferencial
			                   
			                    break;
			                case VIP:
			                    valor = pilhas[i].tamanho() * 5.0; // Valor para a pilha VIP
			                    break;
			                case URGENTE:
			                    valor = pilhas[i].tamanho() * 6.0; // Valor para a pilha urgente                    
			                    break;
			                default:
			                    valor = pilhas[i].tamanho() * 1.0; // Valor padrão para as outras pilhas
			                    break;
			            }
			            
			            // Atualizando o maior valor e o índice da maior pilha
			            if (valor > maiorValor) {
			                maiorValor = valor;
			                indiceMaiorPilha = i;
			            }
			        }
	
			        // Verificando se foi encontrada uma pilha válida com maior valor
			        if (indiceMaiorPilha != -1) {
			            // Exibindo a senha correspondente no txtPainelSenha
			            String mensagem = "Senha: " + pilhas[indiceMaiorPilha].getTipoLista() + "_" + pilhas[indiceMaiorPilha].chamar();
			            txtPainelSenha.setText(mensagem);
			        }
			        switch (indiceMaiorPilha) {
				        case 0:
				            // A maior pilha é normal
				        	txtNormal.setText(normal.listar());
				            txtPainelSenha.setForeground(Color.PINK);
				            break;
				        case 1:
				            // A maior pilha é idoso
				        	txtIdoso.setText(idoso.listar());
				        	txtPainelSenha.setForeground(Color.BLUE);
				            break;
				        case 2:
				            // A maior pilha é idoso80
				        	txtIdoso80.setText(idoso80.listar());
				        	txtPainelSenha.setForeground(Color.RED);
				            break;
				        case 3:
				            // A maior pilha é preferencial
				        	txtPreferencial.setText(preferencial.listar());
				        	txtPainelSenha.setForeground(Color.MAGENTA);
				            break;
				        case 4:
				            // A maior pilha é vip
				        	txtVip.setText(vip.listar());
				        	txtPainelSenha.setForeground(Color.ORANGE);
				            break;
				        case 5:
				            // A maior pilha é urgente
				        	txtUrgente.setText(urgente.listar());
				        	txtPainelSenha.setForeground(Color.GREEN);
				            break;
				        default:
				            // Caso o índice não corresponda a nenhuma pilha conhecida
				        	System.out.println("Nenhuma pilha conhecida");
				        	txtPainelSenha.setForeground(Color.BLACK);
				            break;
			    }
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		
		JButton btnNewButton_2_1 =  new JButton("ATENDER");
		btnNewButton_2_1.setBounds(525, 440, 146, 45);
		contentPane.add(btnNewButton_2_1);
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Verifica se existe um índice válido de maior pilha
				if (indiceMaiorPilha != -1) {
					
				    // Verifica se a pilha no índice especificado não é nula e não está vazia
				    if (pilhas[indiceMaiorPilha] != null && !pilhas[indiceMaiorPilha].estaVazia()) {
				    	
				        // Constrói a string da senha atendida usando o tipo da lista e a próxima senha a ser atendida da pilha
				        String senhaAtendida = "Senha atendida: " + pilhas[indiceMaiorPilha].getTipoLista() + "_" + pilhas[indiceMaiorPilha].atender();

				        // Define o texto do painel de senha para exibir a senha atendida
				        txtPainelSenha.setText(senhaAtendida);
				        	
				        // Seleciona a ação a ser realizada com base no índice da maior pilha
				        switch (indiceMaiorPilha) {
				            case 0:
				                // Atualiza o texto do painel de senhas normais
				                txtNormal.setText(normal.listar());
				                break;
				            case 1:
				                // Atualiza o texto do painel de senhas de idosos
				                txtIdoso.setText(idoso.listar());
				                break;
				            case 2:
				                // Atualiza o texto do painel de senhas de idosos acima de 80 anos
				                txtIdoso80.setText(idoso80.listar());
				                break;
				            case 3:
				                // Atualiza o texto do painel de senhas preferenciais
				                txtPreferencial.setText(preferencial.listar());
				                break;
				            case 4:
				                // Atualiza o texto do painel de senhas VIP
				                txtVip.setText(vip.listar());
				                break;
				            case 5:
				                // Atualiza o texto do painel de senhas urgentes
				                txtUrgente.setText(urgente.listar());
				                break;
				            default:
				                // Caso o índice não corresponda a nenhuma pilha conhecida, imprime uma mensagem e define a cor do texto do painel de senha
				                System.out.println("Não há senhas para atender");
				                break;
				        }
				    } else {
				        // Se a pilha no índice especificado for nula ou estiver vazia, exibe mensagem que não há senhas na fila e ajusta a cor do texto
				        txtPainelSenha.setText("Não há senhas na fila.");
				    }
				}
			}
		});
		btnNewButton_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
	
		
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\MICRO\\Downloads\\AtvFinal (2)\\AtvFinal\\src\\Img\\imgTelaInicial.png"));
		lblNewLabel.setBounds(0, 56, 1219, 596);
		contentPane.add(lblNewLabel);
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
