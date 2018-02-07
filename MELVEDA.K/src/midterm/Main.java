package midterm;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;

public class Main extends JFrame
{
	private JButton submitB;
	private JLabel nameLbl, passLbl, cfrmPassLbl, cityLbl, genderLbl, gmailLbl;
	private JTextField nameTF, passTF, cfrmPassTF, cityTF, genderTF, gmailTF;
	private String name, pass, cfrmPass, city, gender, gmail;
	
	public Main()
	{	
		try
		{
		DataControl gs = new DataControl();
		File output = new File("C:/Users/Kerwin/java_projects/MELVEDA.K/src/midterm/data");
		PrintStream print = new PrintStream(output);
		
		nameLbl = new JLabel("Name:");
		nameLbl.setBounds(30,20,100,20);
		nameTF = new JTextField(25);
		nameTF.setBounds(250, 20, 200, 25);
		
		passLbl = new JLabel("Password:");
		passLbl.setBounds(30,70,150,20);
		passTF = new JTextField(25);
		passTF.setBounds(250, 70, 200, 25);

		cfrmPassLbl = new JLabel("Confirm Password:");
		cfrmPassLbl.setBounds(30,120,200,20);
		cfrmPassTF = new JTextField(30);
		cfrmPassTF.setBounds(250, 120, 200, 25);

		cityLbl = new JLabel("City:");
		cityLbl.setBounds(30,170,100,20);
		cityTF = new JTextField(25);
		cityTF.setBounds(250, 170, 200, 25);
		
		genderLbl = new JLabel("Gender:");
		genderLbl.setBounds(30,220,100,20);
		genderTF = new JTextField(30);
		genderTF.setBounds(250, 220, 200, 25);
		
		gmailLbl = new JLabel("Gmail:");
		gmailLbl.setBounds(30,270,100,20);
		gmailTF = new JTextField(25);
		gmailTF.setBounds(250, 270, 200, 25);
		
		submitB = new JButton("SUBMIT");
		submitB.setBounds(250, 320, 200, 50);
		submitB.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				gs.setName(nameTF.getText());
				gs.setPassword(passTF.getText());
				gs.setConPass(cfrmPassTF.getText());
				gs.setCity(cityTF.getText());
				gs.setGender(genderTF.getText());
				gs.setGmail(gmailTF.getText());
				
				name = gs.getName();
				pass = gs.getPassword();
				cfrmPass = gs.getConPass();
				city = gs.getCity();
				gender = gs.getGender();
				gmail = gs.getGmail();
				
				print.println(name + ";"
							+ pass + ";"
							+ cfrmPass + ";"
							+ city + ";"
							+ gender + ";"
							+ gmail );
			}
			}
		);
		
		setVisible(true);
		setSize(800,500);
		setResizable(false);
		setLocation(600, 150);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		
		add(nameTF);
		add(passTF);
		add(cfrmPassTF);
		add(cityTF);
		add(genderTF);
		add(gmailTF);
		add(submitB);
		add(nameLbl);
		add(passLbl);
		add(cfrmPassLbl);
		add(cityLbl);
		add(genderLbl);
		add(gmailLbl);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	public static void main(String[]args)
	{		
		new Main();
	}
}
