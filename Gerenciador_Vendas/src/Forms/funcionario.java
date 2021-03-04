package Forms;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JTable;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;

//IMPORTAÇÃO IMPLICITA quando não especifico a classe e trago o pacote todo (no lugar do * seria a classe na importação explicita)

import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;
import java.awt.Color;
import javax.swing.event.ChangeListener;


import BancoDados.Funcionario_Venda;
import BancoDados.Tabelas;

import javax.swing.event.ChangeEvent;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.DefaultComboBoxModel;



public class funcionario extends JFrame {

	private JPanel contentPane;
	private JTextField txt_ID_func;
	private JTextField txt_nome_func;
	private JTextField txt_CPF_func;
	
	
	

	JTextField txt_ID_func_remov;
	private JTextField Nome_cadastro;
	private JTextField CPF_cadastro;
	private JTextField salario_cadastro;
	private JTextField textField_3;
	private JTextField textField_4;
	
	
	public void ViewFuncionario() {
		
		//initComponents();
		
	//	table.setModel(tabela);
		
		
		
	}
	
	
	
	
	
	
	
	
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					funcionario frame = new funcionario();
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
	public funcionario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 568, 494);
		contentPane = new JPanel();
		contentPane.setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 0, 0), new Color(128, 128, 128)), null));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Buscar");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 49, 46, 14);
		contentPane.add(lblNewLabel);
		
		
		
		
		JButton btnNewButton = new JButton("Buscar");
		btnNewButton.addActionListener(new ActionListener() {
			

			public void actionPerformed(ActionEvent arg0) {
				
				Funcionario_Venda funcForm_Busca = new Funcionario_Venda();
			
				
				funcForm_Busca.conectar();
				System.out.println(funcForm_Busca.estaConectado());
				
				ResultSet resultado = funcForm_Busca.Busca_Func_Venda(Tabelas.funcionario, Tabelas.ID_func, Tabelas.nome_func, Tabelas.CPF,
						Tabelas.senha, Tabelas.ADM, txt_ID_func.getText(), txt_nome_func.getText(), txt_CPF_func.getText(), "", "");
				try {
					
					while(resultado.next()) {
					//JOptionPane.showMessageDialog(null, venha.getString("ID_func"));
					
		System.out.println("Cod: " + resultado.getString(Tabelas.ID_func) + " NOME: " + resultado.getString(Tabelas.nome_func));
		

		
					}

				} 
				
				catch(NullPointerException | SQLException fa) {
					//System.out.println("ERRO: " + fa.getMessage());
					JOptionPane.showMessageDialog(null, "ERRO NA BUSCA: " + fa);	
				}finally {
				
					funcForm_Busca.desconectar();
				
			}

				
			
			
		 
				// funcionarios f = new funcionarios();
				 
				// f.setFuncional("151564");
			//	 f.setNome("Marquinhos");
				// f.setCPF("15152354264");
				 
				 
				// tabela.addRow(f);
				 
				 
				 
			
				 
			}
			
			
			
			
			
			
			
			
		});
		btnNewButton.setBounds(361, 77, 86, 23);
		contentPane.add(btnNewButton);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				
				
				
			}
		});
		btnLimpar.setBounds(456, 77, 86, 23);
		contentPane.add(btnLimpar);
		
		txt_ID_func = new JTextField();
		txt_ID_func.setBounds(30, 78, 55, 20);
		contentPane.add(txt_ID_func);
		txt_ID_func.setColumns(10);
		
		txt_nome_func = new JTextField();
		txt_nome_func.setColumns(10);
		txt_nome_func.setBounds(133, 78, 86, 20);
		contentPane.add(txt_nome_func);
		
		txt_CPF_func = new JTextField();
		txt_CPF_func.setColumns(10);
		txt_CPF_func.setBounds(254, 78, 86, 20);
		contentPane.add(txt_CPF_func);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(10, 81, 36, 14);
		contentPane.add(lblId);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(95, 81, 36, 14);
		contentPane.add(lblNome);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setBounds(229, 81, 24, 14);
		contentPane.add(lblCpf);
		
		JLabel lblFuncionarios = new JLabel("Funcionarios");
		lblFuncionarios.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblFuncionarios.setBounds(246, 11, 94, 23);
		contentPane.add(lblFuncionarios);
		
		JLabel lblRemover = new JLabel("Remover");
		lblRemover.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblRemover.setBounds(10, 200, 75, 14);
		contentPane.add(lblRemover);
		
		JLabel lblNewLabel_1_1 = new JLabel("Cadastrar");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(10, 293, 75, 14);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblId_1 = new JLabel("ID");
		lblId_1.setBounds(10, 237, 36, 14);
		contentPane.add(lblId_1);
		
		JLabel lblNome_1 = new JLabel("Nome");
		lblNome_1.setBounds(95, 237, 36, 14);
		contentPane.add(lblNome_1);
		
		JLabel lblCpf_1 = new JLabel("CPF");
		lblCpf_1.setBounds(223, 237, 24, 14);
		contentPane.add(lblCpf_1);
		
		txt_ID_func_remov = new JTextField();
		txt_ID_func_remov.setColumns(10);
		txt_ID_func_remov.setBounds(30, 234, 55, 20);
		contentPane.add(txt_ID_func_remov);
		
		JLabel lblNewLabel_1 = new JLabel("-");
		lblNewLabel_1.setBounds(133, 237, 80, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("-");
		lblNewLabel_1_2.setBounds(254, 237, 97, 14);
		contentPane.add(lblNewLabel_1_2);
		
		JButton btnNewButton_1 = new JButton("Buscar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				
				Funcionario_Venda rs = new Funcionario_Venda();
			
				
				
			//	rs.conectar();
				
				
			//	ResultSet venha = rs.Busca_Funcionario(txt_ID_func_remov.getText(),"","");
				
				try {
					
				//	venha.next();
					
					//lblNewLabel_1.setText(venha.getString("nome_func"));
					//lblNewLabel_1_2.setText(venha.getString("CPF"));
					
					
		//System.out.println("Cod: " + venha.getString("ID_func") + " NOME: " + venha.getString("nome_func"));
		
					
		
				} 
				
				catch(Exception fa) {
					//System.out.println("ERRO: " + fa.getMessage());
					JOptionPane.showMessageDialog(null, "ERRO NA BUSCA OU FUNCIONAL NÃO EXISTE:  " + fa);	
				}
				 
				 rs.desconectar();
				 
				
				
				
				
				
				
				
				
				
				
			}
			
			
			
		});
		btnNewButton_1.setBounds(361, 233, 86, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Remover");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				//AVISO
				
			//	AVISO_REMOVERFUNC aviso = new AVISO_REMOVERFUNC(txt_ID_func_remov.getText(),lblNewLabel_1.getText(),lblNewLabel_1_2.getText());
				
				
				
				if( !"".equals(txt_ID_func_remov.getText())) {
					
				//	aviso.setVisible(true);
					
					txt_ID_func_remov.setText("");
					lblNewLabel_1.setText("");
					lblNewLabel_1_2.setText("");
					
				} else {
				//dispose();
				
					JOptionPane.showMessageDialog(null, "Preencher ID do funcionario");
					
				
				}
				
		
				
			}
		});
		btnNewButton_1_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.BLACK, null));
		btnNewButton_1_1.setBackground(Color.ORANGE);
		btnNewButton_1_1.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
			}
		});
		btnNewButton_1_1.setForeground(Color.BLACK);
		btnNewButton_1_1.setBounds(456, 233, 86, 23);
		contentPane.add(btnNewButton_1_1);
		
		JLabel lblNewLabel_2 = new JLabel("Sistema TROCA SENHA CRIAR");
		lblNewLabel_2.setBounds(213, 33, 176, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3_1 = new JLabel("Nome");
		lblNewLabel_3_1.setBounds(10, 333, 46, 14);
		contentPane.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("CPF");
		lblNewLabel_3_1_1.setBounds(223, 333, 36, 14);
		contentPane.add(lblNewLabel_3_1_1);
		
		JLabel lblNewLabel_3_1_1_1 = new JLabel("Sal\u00E1rio");
		lblNewLabel_3_1_1_1.setBounds(391, 333, 46, 14);
		contentPane.add(lblNewLabel_3_1_1_1);
		
		JLabel lblNewLabel_3_1_1_1_1 = new JLabel("Data admiss\u00E3o");
		lblNewLabel_3_1_1_1_1.setBounds(125, 373, 94, 14);
		contentPane.add(lblNewLabel_3_1_1_1_1);
		
		JLabel lblNewLabel_3_1_1_1_1_1 = new JLabel("Data demiss\u00E3o");
		lblNewLabel_3_1_1_1_1_1.setBounds(323, 373, 91, 14);
		contentPane.add(lblNewLabel_3_1_1_1_1_1);
		
		Nome_cadastro = new JTextField();
		Nome_cadastro.setBounds(51, 330, 140, 20);
		contentPane.add(Nome_cadastro);
		Nome_cadastro.setColumns(10);
		
		CPF_cadastro = new JTextField();
		CPF_cadastro.setBounds(254, 330, 117, 20);
		contentPane.add(CPF_cadastro);
		CPF_cadastro.setColumns(10);
		
		salario_cadastro = new JTextField();
		salario_cadastro.setBounds(435, 330, 75, 20);
		contentPane.add(salario_cadastro);
		salario_cadastro.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(227, 370, 86, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(424, 370, 86, 20);
		contentPane.add(textField_4);
		
		JLabel lblNewLabel_3_1_2 = new JLabel("ADM");
		lblNewLabel_3_1_2.setBounds(10, 373, 46, 14);
		contentPane.add(lblNewLabel_3_1_2);
		
		
		
		JComboBox comboBox_ADM_cadastro = new JComboBox();
		comboBox_ADM_cadastro.setModel(new DefaultComboBoxModel(new String[] {"N\u00C3O", "SIM"}));
		comboBox_ADM_cadastro.setBounds(51, 373, 55, 20);
		contentPane.add(comboBox_ADM_cadastro);
		
		
		
		
		
		JButton btnNewButton_1_1_1 = new JButton("Cadastrar");
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				
				
	Funcionario_Venda rs = new Funcionario_Venda();
				


//JOptionPane.showMessageDialog(null, comboBox_ADM_cadastro.getSelectedItem());	

if( !"".equals(Nome_cadastro.getText()) && !"".equals(CPF_cadastro.getText()) && !"".equals(salario_cadastro.getText())
		&& !"".equals(textField_3.getText()) ) {

				//rs.conectar();
				
			//	rs.inserirDados(Nome_cadastro.getText(), CPF_cadastro.getText(), "158UDW213H", comboBox_ADM_cadastro.getSelectedItem().toString());
				
				//rs.desconectar();
				
					
				} else {
				//dispose();
				
					JOptionPane.showMessageDialog(null, "Preencher Campos obrigatórios");
					
				
				}
				
				
				
				
			}
			
			
			
			
			
		});
		btnNewButton_1_1_1.setForeground(Color.BLACK);
		btnNewButton_1_1_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.BLACK, null));
		btnNewButton_1_1_1.setBackground(Color.ORANGE);
		btnNewButton_1_1_1.setBounds(424, 409, 86, 23);
		contentPane.add(btnNewButton_1_1_1);
		
		
	
	
		
	}
}
