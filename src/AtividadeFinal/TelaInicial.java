package AtividadeFinal;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class TelaInicial {

	private JFrame frmInicio;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaInicial window = new TelaInicial();
					window.frmInicio.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaInicial() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmInicio = new JFrame();
		frmInicio.setTitle("Inicio");
		frmInicio.setBounds(100, 100, 600, 550);
		frmInicio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmInicio.getContentPane().setLayout(null);
	      // Criação de bordas com título
		   // Criação de bordas com título
        TitledBorder titledBorderLabel = BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(java.awt.Color.BLACK, 2), "Bem-Vindo");
        titledBorderLabel.setTitleFont(new Font("Arial Black", Font.PLAIN, 20));

        // Label "Bem-Vindo" com borda e título
        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setFont(new Font("Arial Black", Font.PLAIN, 20));
        lblNewLabel_1.setBounds(100, 100, 400, 342);
        lblNewLabel_1.setBorder(titledBorderLabel); // Adiciona borda ao label
        frmInicio.getContentPane().add(lblNewLabel_1);

        // Botão "INICIAR" com borda e título
        JButton btnNewButton_1 = new JButton("INICIAR");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ControlePilha altprd = new ControlePilha();
                altprd.setVisible(true);
                altprd.setLocation(300, 300);
                altprd.setResizable(false);
            }
        });
        btnNewButton_1.setFont(new Font("Arial Black", Font.PLAIN, 20));
        btnNewButton_1.setBounds(118, 50, 164, 85); // Relativo ao lblNewLabel_1
        lblNewLabel_1.add(btnNewButton_1);

        // Botão "SAIR" com borda e título
        JButton btnNewButton_1_1 = new JButton("SAIR");
        btnNewButton_1_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        btnNewButton_1_1.setFont(new Font("Arial Black", Font.PLAIN, 20));
        btnNewButton_1_1.setBounds(118, 175, 164, 85); // Relativo ao lblNewLabel_1
        lblNewLabel_1.add(btnNewButton_1_1);
                
                JLabel lblNewLabel_1_2_4_1 = new JLabel("Consultório DR. No Problem\r\n");
                lblNewLabel_1_2_4_1.setBackground(new Color(175, 238, 238));
                lblNewLabel_1_2_4_1.setForeground(Color.WHITE);
                lblNewLabel_1_2_4_1.setFont(new Font("Tahoma", Font.BOLD, 17));
                lblNewLabel_1_2_4_1.setBounds(176, 19, 243, 45);
                frmInicio.getContentPane().add(lblNewLabel_1_2_4_1);
                
                JLabel lblNewLabel_1_2_4 = new JLabel("CRM 01.892\r\n");
                lblNewLabel_1_2_4.setForeground(Color.WHITE);
                lblNewLabel_1_2_4.setFont(new Font("Tahoma", Font.BOLD, 17));
                lblNewLabel_1_2_4.setBounds(245, 44, 114, 45);
                frmInicio.getContentPane().add(lblNewLabel_1_2_4);
                
                        // Label para imagem de fundo
                        JLabel lblNewLabel = new JLabel("");
                        lblNewLabel.setIcon(new ImageIcon("C:\\Users\\MICRO\\Downloads\\AtvFinal (2)\\AtvFinal\\src\\Img\\imgTelaInicial.png"));
                        lblNewLabel.setBounds(-443, -13, 1124, 576); // Ajuste conforme necessário para cobrir o frame
                        frmInicio.getContentPane().add(lblNewLabel);
    }

}
