package calculator;

import java.awt.*;
import java.awt.event.*;
import java.text.NumberFormat;
import java.util.Locale;

import javax.swing.*;


public class InterestGUI extends JFrame {

	private JTextField userInvestment;
	private JTextField interestRate;
	private JTextField numOfYears;
	private JTextField endValue;
	private JButton computeSimple;
	private JButton computeCompound;



	public InterestGUI() {




		setTitle("Interest Calculator");
		setSize(600,400);
		setLayout(new GridLayout(5,1,5,5));
		setLocationRelativeTo(null);


		JLabel investmentLabel = new JLabel("  Principal: ");
		JLabel rateLabel = new JLabel("  Rate(Percentage):");
		JLabel numOfYearsLabel = new JLabel("  Years: ");
		JLabel endValueLabel = new JLabel(" Total: ");


		userInvestment = new JTextField();
		interestRate = new JTextField();
		numOfYears = new JTextField();
		endValue = new JTextField();
		endValue.setEditable(false);


		computeSimple = new JButton("Compute Simple Interest");
		computeCompound = new JButton("Compute Compound Interest");


		add (investmentLabel);
		add (userInvestment);

		add (rateLabel);
		add (interestRate);

		add (numOfYearsLabel);
		add (numOfYears);

		add (endValueLabel);
		add (endValue);

		add (computeSimple);
		add (computeCompound);


		ListenerClass listener = new ListenerClass();
		computeSimple.addActionListener(listener);
		computeCompound.addActionListener(listener);

		setVisible(true);

	}




	public static void main(String[] args) {
		new InterestGUI();
	}


	private void computeCompoundInterest() {

		double rate = Double.parseDouble(interestRate.getText());
		double years = Double.parseDouble(numOfYears.getText());
		double principal = Double.parseDouble(userInvestment.getText());
		double compoundInterestAmount = principal * Math.pow( (1 + rate/100), years );
		
		NumberFormat dollarFormat = NumberFormat.getCurrencyInstance(Locale.US);
		
		endValue.setText(dollarFormat.format(compoundInterestAmount));

	}


	public void computeSimpleInterest() {

		computeSimple.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				double rate = Double.parseDouble(interestRate.getText());
				double years = Double.parseDouble(numOfYears.getText());
				double principal = Double.parseDouble(userInvestment.getText());
				double simpleInterestAmount = principal + (principal * (rate/100) * years);
				
				 NumberFormat dollarFormat = NumberFormat.getCurrencyInstance(Locale.US);
				
				endValue.setText(dollarFormat.format(simpleInterestAmount));
			}

		});

	}


	private class ListenerClass implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {

			if (arg0.getSource() == computeSimple) {
				computeSimpleInterest();
			}

			if (arg0.getSource() == computeCompound) {
				computeCompoundInterest();
			}
		}
	}
}