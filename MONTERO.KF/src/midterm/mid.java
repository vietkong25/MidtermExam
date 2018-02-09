package midterm;



import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;

public class mid extends JFrame
{
	private JButton submitB;
	private JLabel nameLbl, passLbl, cfrmPassLbl, cityLbl, genderLbl, gmailLbl;
	private JTextField nameTF, passTF, cfrmPassTF, cityTF, genderTF, gmailTF;
	private String name, pass, cfrmPass, city, gender, gmail;
	
	public mid()
	{
		setTitle("REGISTRATION FORM");
		setBackground(Color.LIGHT_GRAY);	
		try
		{
		Control gs = new Control();
		File output = new File("C:/Users/Keith/WorkSpace/MONTERO.KF/src/K/File.txt");
		PrintStream print = new PrintStream(output);
		
		nameLbl = new JLabel("Name:");
		nameLbl.setFont(new Font("SansSerif", Font.PLAIN, 12));
		nameLbl.setBounds(30,22,100,20);
		nameTF = new JTextField(25);
		nameTF.setBounds(140, 20, 200, 25);
		
		passLbl = new JLabel("Password:");
		passLbl.setFont(new Font("SansSerif", Font.PLAIN, 12));
		passLbl.setBounds(30,70,150,20);
		passTF = new JTextField(25);
		passTF.setBounds(140, 68, 200, 25);

		cfrmPassLbl = new JLabel("Confirm Password:");
		cfrmPassLbl.setFont(new Font("SansSerif", Font.PLAIN, 12));
		cfrmPassLbl.setBounds(30,120,200,20);
		cfrmPassTF = new JTextField(30);
		cfrmPassTF.setBounds(140, 118, 200, 25);

		cityLbl = new JLabel("City:");
		cityLbl.setFont(new Font("SansSerif", Font.PLAIN, 12));
		cityLbl.setBounds(30,170,100,20);
		cityTF = new JTextField(25);
		cityTF.setBounds(140, 168, 200, 25);
		
		genderLbl = new JLabel("Gender:");
		genderLbl.setFont(new Font("SansSerif", Font.PLAIN, 12));
		genderLbl.setBounds(30,220,100,20);
		genderTF = new JTextField(30);
		genderTF.setBounds(140, 218, 200, 25);
		
		gmailLbl = new JLabel("Gmail:");
		gmailLbl.setFont(new Font("SansSerif", Font.PLAIN, 12));
		gmailLbl.setBounds(30,270,100,20);
		gmailTF = new JTextField(25);
		gmailTF.setBounds(140, 268, 200, 25);
		
		submitB = new JButton("SUBMIT");
		submitB.setBounds(284, 348, 200, 50);
		submitB.addActionListener(new ActionListener(){
			public void actionPerformed1(ActionEvent ae){
			    JOptionPane.showMessageDialog( submitB, "Success "
			  );
			}
		
		
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
		setSize(600,500);
		setResizable(false);
		setLocation(600, 150);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		getContentPane().add(nameTF);
		getContentPane().add(passTF);
		getContentPane().add(cfrmPassTF);
		getContentPane().add(cityTF);
		getContentPane().add(genderTF);
		getContentPane().add(gmailTF);
		getContentPane().add(submitB);
		getContentPane().add(nameLbl);
		getContentPane().add(passLbl);
		getContentPane().add(cfrmPassLbl);
		getContentPane().add(cityLbl);
		getContentPane().add(genderLbl);
		getContentPane().add(gmailLbl);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	public static void main(String[]args)
	{		
		new mid();
	}
}
