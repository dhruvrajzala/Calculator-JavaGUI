import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class calculator implements ActionListener{
	
	JFrame frame;
	JPanel panel;
	JTextField text;
	JButton[] numButton=new JButton[10];
	JButton[] funButton=new JButton[9];
	JButton add,sub,mul,div,dec,equ,del,clr,neg;
	double num1,num2,result;
	char operator;

	calculator(){
		
		frame = new JFrame();
		frame.setSize(450,500);
		frame.setTitle("Calculator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		ImageIcon image=new ImageIcon("C:\\Users\\Admin\\eclipse-workspace\\Calculator\\src\\logo.png");
		frame.setIconImage(image.getImage());
		
		text = new JTextField();
		text.setBounds(50,50,350,50);
		text.setFont(new Font("Times New Roman",Font.BOLD,30));
		text.setEditable(false);
		
		add=new JButton("+");
		sub=new JButton("-");
		mul=new JButton("*");
		div=new JButton("/");
		dec=new JButton(".");
		equ=new JButton("=");
		del=new JButton("Del");
		clr=new JButton("Clr");
		neg=new JButton("(-)");
		
		funButton[0]=add;
		funButton[1]=sub;
		funButton[2]=mul;
		funButton[3]=div;
		funButton[4]=dec;
		funButton[5]=equ;
		funButton[6]=del;
		funButton[7]=clr;
		funButton[8]=neg;
		
		for(int i=0;i<9;i++) {
			funButton[i].addActionListener(this);
			funButton[i].setFocusable(false);
			funButton[i].setFont(new Font("MV Boli",Font.PLAIN,30));;
		}
		
		for(int i=0;i<10;i++){
			numButton[i]=new JButton(String.valueOf(i));
			numButton[i].addActionListener(this);
			numButton[i].setFocusable(false);
			numButton[i].setFont(new Font("MV Boli",Font.PLAIN,30));
		}
		
		neg.setBounds(80, 380, 80, 50);
		del.setBounds(180, 380, 80, 50);
		clr.setBounds(280, 380, 80, 50);
		
		panel=new JPanel();
		panel.setBounds(50,110,350,250);
		panel.setLayout(new GridLayout(4,4,10,10));
		panel.add(numButton[1]);
		panel.add(numButton[2]);
		panel.add(numButton[3]);
		panel.add(add);
		panel.add(numButton[4]);
		panel.add(numButton[5]);
		panel.add(numButton[6]);
		panel.add(sub);
		panel.add(numButton[7]);
		panel.add(numButton[8]);
		panel.add(numButton[9]);
		panel.add(mul);
		panel.add(dec);
		panel.add(numButton[0]);
		panel.add(equ);
		panel.add(div);
		
		
		frame.add(panel);
		frame.add(neg);
		frame.add(del);
		frame.add(clr);
		frame.add(text);
		frame.setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new calculator();
	}

	public void actionPerformed(ActionEvent e) {
		
		for(int i=0;i<10;i++) {
			if(e.getSource()==numButton[i]) {
				text.setText(text.getText().concat(String.valueOf(i)));
			}
		}
		
		if(e.getSource()==add) {
			num1=Double.parseDouble(text.getText());
			text.setText("");
			operator = '+';
		}
		
		if(e.getSource()==sub) {
			num1=Double.parseDouble(text.getText());
			text.setText("");
			operator = '-';
		}
		
		if(e.getSource()==mul) {
			num1=Double.parseDouble(text.getText());
			text.setText("");
			operator = '*';
		}
		
		if(e.getSource()==div) {
			num1=Double.parseDouble(text.getText());
			text.setText("");
			operator = '/';
		}
		
		if(e.getSource()==dec) {
			text.setText(text.getText().concat("."));
		}
		
		if(e.getSource()==equ) {
			num2=Double.parseDouble(text.getText());
			switch(operator) {
			case'+':
				result=num1+num2;
				break;
			case'-':
				result=num1-num2;
				break;
			case'*':
				result=num1*num2;
				break;
			case'/':
				result=num1/num2;
				break;
			}
			text.setText(String.valueOf(result));
			num1=result;
		}
		
		if(e.getSource()==clr) {
			text.setText("");
		}
		
		if(e.getSource()==del) {
			String temp=text.getText();
			text.setText("");
			for(int i=0;i<temp.length()-1;i++) {
				text.setText(text.getText()+temp.charAt(i));
			}
		}
		
		try {
			if(e.getSource()==neg) {
				double temp=Double.parseDouble(text.getText());
				temp*=-1;
				text.setText(String.valueOf(temp));
			}
		} catch (NumberFormatException e1) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Please enter a number and then add the negative sign to input a negative number.");
			e1.printStackTrace();
		}
	}
}
