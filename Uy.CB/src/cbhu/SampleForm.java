package cbhu;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SampleForm extends JFrame {
	private static final long serialVersionUID = -5374648617154632899L;

	private String output;
	JLabel[] lbl = new JLabel[5];
	JTextField[] textField = new JTextField[4];
	JButton submit = new JButton("SUBMIT");
	JPanel[] pnl = new JPanel[3];
	File filPath = new File("C:\\output.txt");
	SetGet sg = new SetGet();

	public SampleForm() {
		setTitle("Sample Form");
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLayout(new FlowLayout(FlowLayout.CENTER));

		pnl[0] = new JPanel(new GridLayout(2, 1, 5, 5));
		pnl[1] = new JPanel(new GridLayout(4, 2, 5, 5));

		lbl[0] = new JLabel("<html><b>Full Name:</b></html>");
		lbl[1] = new JLabel("<html><b>Address:</b></html>");
		lbl[2] = new JLabel("<html><b>E-mail:</b></html>");
		lbl[3] = new JLabel("<html><b>About Me:</b></html>");

		for (int ctr = 0; ctr < 4; ctr++) {
			textField[ctr] = new JTextField(10);
			pnl[1].add(lbl[ctr]);
			pnl[1].add(textField[ctr]);
		}

		pnl[2] = new JPanel(new FlowLayout(FlowLayout.CENTER));
		pnl[2].add(submit);

		pnl[0].add(pnl[1]);
		pnl[0].add(pnl[2]);
		add(pnl[0]);

		// [0] Full Name, [1] Address, [2] E-mail, [3] About Me

		textField[0].setToolTipText("Enter your full name.");
		textField[1].setToolTipText("Enter your home address.");
		textField[2].setToolTipText("Enter your e-mail address.");
		textField[3].setToolTipText("Enter something about yourself.");
		submit.setToolTipText("<html>Click this button to submit your details.<hr />Details will be written to <i><b>C:\\output.txt</html></b></i>");

		getRootPane().setDefaultButton(submit);

		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				sg.setFullName(textField[0].getText().toString());
				sg.setAddress(textField[1].getText());
				sg.setEmail(textField[2].getText());
				sg.setAboutMe(textField[3].getText());

				writeToFile(filPath);

				submit.setEnabled(false);
				for (int ctr = 0; ctr < 4; ctr++) {
					textField[ctr].setEnabled(false);
				}

				Timer tm = new Timer();
				tm.schedule(new TimerTask() {
					public void run() {
						submit.setEnabled(true);
						for (int ctr = 0; ctr < 4; ctr++) {
							textField[ctr].setText("");
						}
					}
				}, 1000);

			}
		});

		getContentPane().repaint();
		getContentPane().revalidate();
		setSize(300, 180);
		setLocationRelativeTo(null);
	}

	void writeToFile(File f) {
		FileWriter fw;
		output = sg.getFullName() + " ; " + sg.getAddress() + " ; "
				+ sg.getEmail() + " ; " + sg.getAboutMe() + "\r\n\r\n";

		try {
			f.createNewFile();
			fw = new FileWriter(filPath, true);
			fw.write(output);
			fw.close();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

}
