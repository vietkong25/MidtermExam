package midterm;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;


public class MidtermExam extends JFrame implements ActionListener
{
	private JLabel nameL, passwordL, confirmPasswordL, cityL, genderL, gmailL;
	private JTextField nameTF, gmailTF;
	private JPasswordField passwordPF, confirmPasswordPF;
	private JComboBox cityCB;
	private JRadioButton maleRB, femaleRB;
	private JButton submitB;
	
	public MidtermExam()
	{
		setSize(400, 300);
		setTitle("Registration Form");
		setLayout(null);
		
		nameL = new JLabel("Name : ");
		add(nameL);
		nameL.setBounds(20, 20, 100, 20);
		
		nameTF = new JTextField(20);
		add(nameTF);
		nameTF.setBounds(150, 20, 200, 20);
		
		passwordL = new JLabel("Password : ");
		add(passwordL);
		passwordL.setBounds(20, 50, 100, 20);
		
		passwordPF = new JPasswordField(20);
		add(passwordPF);
		passwordPF.setBounds(150, 50, 200, 20);
		
		confirmPasswordL = new JLabel("Confirm Password : ");
		add(confirmPasswordL);
		confirmPasswordL.setBounds(20, 80, 150, 20);
		
		confirmPasswordPF = new JPasswordField(20);
		add(confirmPasswordPF);
		confirmPasswordPF.setBounds(150, 80, 200, 20);
		
		cityL = new JLabel("City : ");
		add(cityL);
		cityL.setBounds(20, 110, 100, 20);
		
		String[] cities = {"---", "Quezon City", "Marikina City", "San Mateo"};
		cityCB = new JComboBox(cities);
		add(cityCB);
		cityCB.setBounds(150, 110, 200, 20);
		
		genderL = new JLabel("Gender : ");
		add(genderL);
		genderL.setBounds(20, 140, 100, 20);
		
		femaleRB = new JRadioButton("Female");
		add(femaleRB);
		femaleRB.setBounds(150, 140, 70, 20);
		
		maleRB = new JRadioButton("Male");
		add(maleRB);
		maleRB.setBounds(240, 140, 200, 20);
		
		gmailL = new JLabel("Gmail : ");
		add(gmailL);
		gmailL.setBounds(20, 170, 100, 20);
		
		gmailTF = new JTextField(30);
		add(gmailTF);
		gmailTF.setBounds(150, 170, 200, 20);
		
		submitB = new JButton("Submit");
		add(submitB);
		submitB.setBounds(130, 215, 130, 30);
		submitB.addActionListener(this);
		
		setLocationRelativeTo(null);
		setVisible(true);

	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if (e.getSource() == submitB)
		{
			submitB.setEnabled(false);
			GettersSetters getset = new GettersSetters();
			getset.setName(nameTF.getText());
			getset.setPassword(passwordPF.getText());
			getset.setCity(cityCB.getSelectedItem().toString());
			getset.setGender(maleRB.getActionCommand());
			getset.setGender(femaleRB.getActionCommand());
			getset.setGmail(gmailTF.getText());
			
			PrintWriter out;
			try {
				out = new PrintWriter(new FileWriter("C:/Users/user/Desktop/didi/DeGuzman.D/src/output.txt", true), true);
				out.write(getset.getName() + ";" + getset.getPassword() + ";" + getset.getCity() + ";" + getset.getGender() + ";" + getset.getGmail() + "\n");
				out.close();
			    Desktop.getDesktop().open(new java.io.File("C:/Users/user/Desktop/didi/DeGuzman.D/src/output.txt"));
			} 
			catch (IOException e1)
			{

				e1.printStackTrace();
			}
			
			this.dispose();
		}
	}
	public static void main(String[] args)
	{
		new MidtermExam();

	}

}

