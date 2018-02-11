package midtermexam;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.*;

public class MidtermExam implements ActionListener 
{
	public JFrame frame;
	
	public JButton submitButton;
	
	public JLabel nameLabel;
	public JLabel passLabel;
	public JLabel confirmLabel;
	public JLabel cityLabel;
	public JLabel genderLabel;
	public JLabel emailLabel;
	public JLabel male;
	public JLabel female;
	
	public JTextField nameField;
	public JTextField emailField;
	
	public JPasswordField passField;
	public JPasswordField confirmField;
	
	public JComboBox cityField;
	
	public JRadioButton maleButton;
	public JRadioButton femaleButton;
	
	public ButtonGroup gender;
	
	
	private String[] cityList = {"Select City","Quezon City", "Cebu City"};
	
	public MidtermExam() 
	{
		
		gender = new ButtonGroup();
		
        frame=new JFrame("Registration");
        frame.setSize(400, 400);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        nameLabel = new JLabel("Name:");
        nameLabel.setBounds(20, 30, 80, 40);
        frame.add(nameLabel);
        nameField = new JTextField();
        nameField.setBounds(190, 35, 150, 25);
        frame.add(nameField);
        
        passLabel = new JLabel("Password:");
        passLabel.setBounds(20, 70, 80, 40);
        frame.add(passLabel);
        passField = new JPasswordField();
        passField.setBounds(190, 75, 150, 25);
        frame.add(passField);
        
        confirmLabel = new JLabel("Confirm Password:");
        confirmLabel.setBounds(20, 110, 110, 40);
        frame.add(confirmLabel);
        confirmField = new JPasswordField();
        confirmField.setBounds(190, 115, 150, 25);
        frame.add(confirmField);
        
        cityLabel = new JLabel("City:");
        cityLabel.setBounds(20, 150, 80, 40);
        frame.add(cityLabel);
        cityField = new JComboBox(cityList);
        cityField.setBounds(215, 155, 100, 25);
        frame.add(cityField);
        
        genderLabel = new JLabel("Gender:");
        genderLabel.setBounds(20, 200, 80, 40);
        frame.add(genderLabel);
        maleButton = new JRadioButton();
        
        maleButton.setBounds(200, 195, 20, 25);
        frame.add(maleButton);
        femaleButton = new JRadioButton();
        femaleButton.setBounds(200, 215, 20, 25);
        frame.add(femaleButton);
        male = new JLabel("Male");
        gender.add(maleButton);
        gender.add(femaleButton);
        
        male.setBounds(240, 185, 80, 40);
        frame.add(male);
        female = new JLabel("Female");
        female.setBounds(240, 205, 80, 40);
        frame.add(female);
        
        emailLabel = new JLabel("Gmail:");
        emailLabel.setBounds(20, 250, 80, 40);
        frame.add(emailLabel);
        emailField = new JTextField();
        emailField.setBounds(195, 255, 150, 25);
        frame.add(emailField);
        
        submitButton = new JButton("SUBMIT");
        submitButton.setBounds(155, 310, 80, 40);
        frame.add(submitButton);
        submitButton.addActionListener(this);
        
        frame.setVisible(true);	
	}
	
	public static void main(String[] args) 
	{
		new MidtermExam();
	}

	@Override
	public void actionPerformed(ActionEvent arg0)
	{
		if(arg0.getSource()== submitButton)
		{
			
			SettersAndGetters sg = new SettersAndGetters();
			sg.setName(nameField.getText());	
			sg.setPassword(passField.getText());
			sg.setConfirm(confirmField.getText());
			sg.setCity(cityField.getSelectedItem().toString());
			
			if(maleButton.isSelected())
			{
				sg.setGender("Male");
			}
			else
			{
				sg.setGender("Female");
			}
			sg.setEmail(emailField.getText());
			
			JOptionPane.showMessageDialog(null, "Added");
			nameField.setText(null);
			passField.setText(null);
			confirmField.setText(null);
			cityField.setSelectedIndex(0);
			maleButton.setSelected(false);
			femaleButton.setSelected(false);
			emailField.setText(null);
						
			FileWriter writer ;
			try {
				writer = new FileWriter("C:/Users/RalphVincent/Desktop/Software Engineering/Malabanan.RV/src/MidtermExam/RegistrationOutput.txt");
				writer.write(sg.getName()+"; ");
				writer.write(sg.getPassword()+"; ");
				writer.write(sg.getConfirm()+"; ");
				writer.write(sg.getCity() +"; ");
				writer.write(sg.getGender() +"; ");
				writer.write(sg.getEmail() +"; ");
				writer.close();
			} catch (IOException e) 
			{
				e.printStackTrace();
			}

		}	
	}
}