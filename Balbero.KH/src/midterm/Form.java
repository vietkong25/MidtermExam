package midterm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Form extends JFrame implements ActionListener
{

	private JLabel nameL, passwordL, confirmPassL,cityL, genderL, emailL;
	private JTextField nameTF, emailTF;
	private JPasswordField passwordPF,confirmPassPF;
	private JComboBox cities;
	private JRadioButton male,female;
	private JButton submitB;
	private static final String FILENAME = "C:/Users/Balbero Family/Desktop/Output.txt";
	
	public Form() 
	{
		setTitle("Midterm Form");
		setSize(320,295);
		setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		
		nameL = new JLabel ("Name");
		add(nameL).setBounds(10,10,100,30);
		
		nameTF = new JTextField();
		add(nameTF).setBounds(150,15,150,20);
		
		passwordL = new JLabel ("Password");
		add(passwordL).setBounds(10,40,100,30);
		
		passwordPF = new JPasswordField();
		add(passwordPF).setBounds(150,45,150,20);
		
		confirmPassL = new JLabel("Confirm Password");
		add(confirmPassL).setBounds(10,70,120,30);
		
		confirmPassPF = new JPasswordField();
		add(confirmPassPF).setBounds(150,75,150,20);
		
		cityL = new JLabel ("City");
		add(cityL).setBounds(10,100,100,30);
		
		String [] selectCity = {"Select City","Quezon City", "Pasay City", "Cebu City", "Davao City", "Makati City"};
		cities = new JComboBox(selectCity);
		add(cities).setBounds(150,105,100,20);
		
		genderL = new JLabel("Gender");
		add(genderL).setBounds(10,130,100,30);
		
		male = new JRadioButton("Male");
		female = new JRadioButton("Female");
		
		add(male).setBounds(145,135,100,20);
		add(female).setBounds(145,155,100,20);
		ButtonGroup bg=new ButtonGroup();    
		bg.add(male);bg.add(female);    
		add(male);
		add(female);   
		
		emailL = new JLabel("Gmail");
		add(emailL).setBounds(10,185,100,30);
		
		emailTF = new JTextField();
		add(emailTF).setBounds(150,190,150,20);
		
		submitB = new JButton("Submit");
		add(submitB).setBounds(200,220,100,20);
		submitB.addActionListener(this);
		
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource() == submitB)
		{
			GettersSetters get = new GettersSetters();

			get.setUserName(nameTF.getText().toString());
			get.setUserPass(passwordPF.getText().toString());
			get.setUserPassFinal(confirmPassPF.getText().toString());
			get.setUserCity(cities.getSelectedItem().toString());
			if(male.isSelected())
			{
				get.setUserGender(male.getLabel().toString());
			}
			else
			{
				get.setUserGender(female.getLabel().toString());
			}
			get.setUserEmail(emailTF.getText().toString());

			BufferedWriter bw = null;
			FileWriter fw = null;
			try 
			{
				fw = new FileWriter(FILENAME, true);
				bw = new BufferedWriter(fw);
				bw.write(get.getUserName()+ ";" + get.getUserPass() + ";" + get.getUserPassFinal()+ ";"+ get.getUserCity() + ";" + get.getUserGender() + ";" + get.getUserEmail());
				bw.newLine();

				bw.close();
			} 
			catch (IOException e1) 
			{
				e1.printStackTrace();
			}
			JOptionPane.showMessageDialog(null, "Added");
			nameTF.setText(null);
			passwordPF.setText(null);
			confirmPassPF.setText(null);
			cities.setSelectedIndex(0);
			male.setSelected(false);
			female.setSelected(false);
			emailTF.setText(null);		
		}
	}
	public static void main(String[] args) 
	{
		Form run = new Form();
	}
}