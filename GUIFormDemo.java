import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class GUIFormDemo implements ActionListener {
	JFrame f = new JFrame("Student Grading System");
	JLabel l = new JLabel("Grade Calculator");

	JLabel l1 = new JLabel("Enter IA-1 Marks");
	JLabel l2 = new JLabel("Enter IA-2 Marks");
	JLabel l3 = new JLabel("Enter IA-3 Marks");
	JLabel l4 = new JLabel("Enter CTA Marks");
	JLabel l5 = new JLabel("Enter SEE Marks");
	JLabel l6 = new JLabel();
	JLabel l7 = new JLabel();
	JLabel ltotal = new JLabel();
	JLabel lgrade = new JLabel();

	JPanel p = new JPanel();
	JPanel p1 = new JPanel();
	JPanel p2 = new JPanel();
	JPanel p3 = new JPanel();
	JPanel p4 = new JPanel();
	JPanel p5 = new JPanel();
	JPanel pbutton = new JPanel();
	JPanel p6 = new JPanel();

	JButton b1 = new JButton("CALCULATE");

	JTextField f1 = new JTextField(10);
	JTextField f2 = new JTextField(10);
	JTextField f3 = new JTextField(10);
	JTextField f4 = new JTextField(10);
	JTextField f5 = new JTextField(10);

	public GUIFormDemo() {
		b1.setSize(100, 100);
		f.setVisible(true);
		f.setBounds(200, 200, 900, 500);

		p.add(l);
		p1.add(l1);
		p1.add(f1);
		p2.add(l2);
		p2.add(f2);
		p3.add(l3);
		p3.add(f3);
		p4.add(l4);
		p4.add(f4);
		p5.add(l5);
		p5.add(f5);
		pbutton.add(b1);
		
		p6.add(ltotal);
		p6.add(l6);
		p6.add(lgrade);
		p6.add(l7);

		f.add(p);
		f.add(p1);
		f.add(p2);
		f.add(p3);
		f.add(p4);
		f.add(p5);
		f.add(pbutton);
		f.add(p6);

		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLayout(new GridLayout(10, 0));
		p6.setLayout(new GridLayout(0, 4));
		b1.addActionListener(this);
	}
	public static void main(String[] args) {
		new GUIFormDemo();
	}
	public void actionPerformed(ActionEvent e) {
		try {
			if (e.getSource() == b1) {
				int ia1 = Integer.parseInt(f1.getText());
				int ia2 = Integer.parseInt(f2.getText());
				int ia3 = Integer.parseInt(f3.getText());
				int cta = Integer.parseInt(f4.getText());
				double see= Integer.parseInt(f5.getText());

				if (ia1 < 0 || ia1 > 20 || ia2 < 0 || ia2 > 20 || ia3 < 0 ||ia3 > 20 || cta < 0 || cta > 10 || see < 0 || see > 100) 
				{
				lgrade.setText("Invalid marks entered.");
					return;
				}
				int cie;
				int sum1, sum2, largest;
				largest = ia1 + ia2;
				sum1 = ia2 + ia3;
				sum2 = ia1 + ia3;
				if (sum1 > largest) {
					largest = sum1;	
}	
				if (sum2 > largest) {
					largest = sum2;
				}
				cie = largest + cta;
				if (cie < 20) {
		         lgrade.setText("student is detained for SEE");
					return;	}
				if (see == 38 || see == 39) {
					see = 40;
				}
				double totalMarks = (cie + Math.round(see/ 2));
			 	totalMarks = Math.round(totalMarks);
				String grade;
				if (totalMarks >= 90) {
					grade = "S";				
				} else if (totalMarks >= 80) {
					grade = "A";
				} else if (totalMarks >= 70) {
					grade = "B";
				} else if (totalMarks >= 60) {
					grade = "C";
				} else if (totalMarks >= 50) {
					grade = "D";
				} else if (totalMarks >= 40) {
					grade = "E";
				} else {
					grade = "F";
				}
			
				ltotal.setText("totalMarks:" + totalMarks);
				lgrade.setText("Grade:" + grade);
				if (see < 38) {
					lgrade.setText("Grade:F");
					return;	
				}
			}
		} catch (NumberFormatException nfe) {
			lgrade.setText("Invalid Input Given"); 
		}
	}
}