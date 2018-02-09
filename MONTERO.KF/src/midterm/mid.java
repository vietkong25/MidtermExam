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
	private JLabel namelbl, passlbl, cfrmPasslbl, citylbl, genderlbl, emailLbl;
	private JTextField nameTF, passTF, cfrmPassTF, cityTF, genderTF, emailTF;
	private String name, pass, cfrmPass, city, gender, email;
	
	public mid()
	{
		setTitle("REGISTRATION FORM");
		setBackground(Color.LIGHT_GRAY);	
		try
		{
		Control gs = new Control();
		File output = new File("C:/Users/Keith/WorkSpace/MONTERO.KF/src/midterm/File.txt");
		PrintStream print = new PrintStream(output);
		
		namelbl = new JLabel("Name:");
		namelbl.setFont(new Font("SansSerif", Font.PLAIN, 12));
		namelbl.setBounds(30,22,100,20);
		nameTF = new JTextField(25);
		nameTF.setBounds(140, 20, 200, 25);
		
		passlbl = new JLabel("Password:");
		passlbl.setFont(new Font("SansSerif", Font.PLAIN, 12));
		passlbl.setBounds(30,70,150,20);
		passTF= new JTextField(25);
		passTF.setBounds(140, 68, 200, 25);

		cfrmPasslbl = new JLabel("Confirm Password:");
		cfrmPasslbl.setFont(new Font("SansSerif", Font.PLAIN, 12));
		cfrmPasslbl.setBounds(30,120,200,20);
		cfrmPassTF = new JTextField(30);
		cfrmPassTF.setBounds(140, 118, 200, 25);

		citylbl = new JLabel("City:");
		citylbl.setFont(new Font("SansSerif", Font.PLAIN, 12));
		citylbl.setBounds(30,170,100,20);
		cityTF = new JTextField(25);
		cityTF.setBounds(140, 168, 200, 25);
		
		genderlbl = new JLabel("Gender:");
		genderlbl.setFont(new Font("SansSerif", Font.PLAIN, 12));
		genderlbl.setBounds(30,220,100,20);
		genderTF = new JTextField(30);
		genderTF.setBounds(140, 218, 200, 25);
		
		emailLbl = new JLabel("Gmail:");
		emailLbl.setFont(new Font("SansSerif", Font.PLAIN, 12));
		emailLbl.setBounds(30,270,100,20);
		emailTF = new JTextField(25);
		emailTF.setBounds(140, 268, 200, 25);
		
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
				gs.setEmail(emailTF.getText());
				
				name = gs.getName();
				pass = gs.getPassword();
				cfrmPass = gs.getConPass();
				city = gs.getCity();
				gender = gs.getGender();
				email = gs.getGmail();
				
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
