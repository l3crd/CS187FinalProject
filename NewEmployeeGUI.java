/*

*Lara Cucciardi
*NMSU Grants - CS 187
*Final Project / Employee IT Access Request Form
*Due: May 12, 2016

*/


package com.cucciardil.finalProject;

//all of the API imports
import java.awt.Font;
import java.awt.GridBagConstraints; 
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class NewEmployeeGUI {

	public static void main(String[] args) {
	//creates the frame
		JFrame.setDefaultLookAndFeelDecorated(true);
		JFrame mainFrame = new JFrame("New Employee IT Access Request Form");
		mainFrame.setVisible(true);
		mainFrame.setSize(500, 500);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	//label for instructions
		JLabel lblTitleText = new JLabel("Please enter the following information to request program access for new employees");
		lblTitleText.setFont(new Font("San Serif", Font.BOLD, 14));
		
	//creates each label and text field or other component
		JLabel lblFirstName = new JLabel("First Name:");
		JTextField txtFirstName = new JTextField(25);
		txtFirstName.setText(" ");//have to setText so that null point exception won't happen when getText
		
		JLabel lblLastName = new JLabel("Last Name:");
		JTextField txtLastName = new JTextField(25);
		txtLastName.setText(" ");
		
		JLabel lblMidInitial = new JLabel("Middle Initial");
		JTextField txtMidInitial = new JTextField(1);
		txtMidInitial.setText(" ");
		
		JLabel lblTitle = new JLabel("Title: ");
		JTextField txtTitle = new JTextField(25);
		txtTitle.setText(" ");
		
		JLabel lblCredentials = new JLabel("Credentials:");
		JTextField txtCredentials = new JTextField(10);
		txtCredentials.setText(" ");
		
		JLabel lblStatus = new JLabel("Status:");
		JCheckBox contractBox = new JCheckBox("Contract");
		JCheckBox permanentBox = new JCheckBox("Permanent");
						
		JLabel lblShift = new JLabel("Shift:");
		JCheckBox regBox = new JCheckBox("Regular");
		JCheckBox swingBox = new JCheckBox("Swing");
		JCheckBox nightBox = new JCheckBox("Night");
		JCheckBox prnBox = new JCheckBox("PRN");
		JCheckBox allBox = new JCheckBox("All of the above");
		
		JLabel lblDepartment = new JLabel("Department:");
		String[] deptList = {"Admin", "Lab", "IT", "Cardio", "HIM", "PFS", "Radiology", "ER", "OB", "OR", "MedSurg", "Maintenance" };
		JComboBox deptBox = new JComboBox(deptList);
				
		JLabel lblPrograms = new JLabel("Needs Access to...");
		ArrayList<JCheckBox> arrayPrograms = new ArrayList<JCheckBox>();
		arrayPrograms.add(new JCheckBox("HMS-Graphical View"));
		arrayPrograms.add(new JCheckBox("HMS-Clinical View"));
		arrayPrograms.add(new JCheckBox("PICIS"));
		arrayPrograms.add(new JCheckBox("Email"));
		arrayPrograms.add(new JCheckBox("ExitCare"));
		arrayPrograms.add(new JCheckBox("OBIX"));
		arrayPrograms.add(new JCheckBox("NextRad"));
		arrayPrograms.add(new JCheckBox("3M"));
		
		JLabel lblComments = new JLabel("Comments:");
		JTextArea txtComments = new JTextArea(4,20);
		txtComments.setText(" ");
		txtComments.setLineWrap(true);
		
		JLabel lblSaveInstructions = new JLabel("Save your settings to a file and attach the file to an email to the IT Dept");
		JButton btnSave = new JButton("Save");
	
	//sets up the Panel that holds everything
		JPanel demoPanel = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.anchor = GridBagConstraints.WEST;
		c.insets = new Insets(5,5,5,5);//puts space around elements
		
	//layout for title text (instructions)
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 2;
		demoPanel.add(lblTitleText,c);
		
	//layout for first name
		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = 1;
		demoPanel.add(lblFirstName, c);
		
		c.gridx = 1;
		demoPanel.add(txtFirstName, c);
		
	//layout for last name
		c.gridx = 0;
		c.gridy = 2;
		demoPanel.add(lblLastName,c);
		
		c.gridx = 1;
		demoPanel.add(txtLastName,c);
		
	//layout for middle initial
		c.gridx = 0;
		c.gridy = 3;
		demoPanel.add(lblMidInitial,c);
		
		c.gridx = 1;
		demoPanel.add(txtMidInitial,c);
		
	//layout for title
		c.gridx = 0;
		c.gridy = 4;
		demoPanel.add(lblTitle,c);
		
		c.gridx = 1;
		demoPanel.add(txtTitle,c);
		
	//layout for credentials
		c.gridx = 0;
		c.gridy = 5;
		demoPanel.add(lblCredentials,c);
				
		c.gridx = 1;
		demoPanel.add(txtCredentials,c);
		
	//layout for status
		c.gridx = 0;
		c.gridy = 6;
		demoPanel.add(lblStatus,c);//adds label
		
		c.gridx = 1;
		c.gridy = 6;
		demoPanel.add(contractBox,c);//add checkbox for Contract
		
		c.gridx = 1;
		c.gridy = 6;
		c.anchor = GridBagConstraints.CENTER;
		demoPanel.add(permanentBox,c);//adds checkbox for Permanent
		
	//layout for shift
		c.gridx = 0;
		c.gridy = 8;
		c.anchor = GridBagConstraints.WEST;
		demoPanel.add(lblShift,c);
	
		c.gridx = 1;
		c.gridy = 8;
		c.anchor = GridBagConstraints.FIRST_LINE_START;
		demoPanel.add(regBox,c);
		c.anchor = GridBagConstraints.CENTER;
		demoPanel.add(nightBox, c);
		c.anchor = GridBagConstraints.FIRST_LINE_END;
		demoPanel.add(swingBox,c);
		c.gridy = 9;
		c.anchor = GridBagConstraints.LINE_START;
		demoPanel.add(prnBox,c);
		c.anchor = GridBagConstraints.CENTER;
		demoPanel.add(allBox,c);
		
	//layout for Department ComboBox
		c.gridx = 0;
		c.gridy = 10;
		c.gridwidth = 2;
		c.anchor = GridBagConstraints.WEST;
		demoPanel.add(lblDepartment,c);
		
		c.gridx = 1;
		demoPanel.add(deptBox,c);
				
	//layout for Program Access, experimented with new panel for layout of boxes
		c.gridx = 0;
		c.gridy = 12;
		demoPanel.add(lblPrograms,c);
		
		c.gridx = 0;
		c.gridy = 13;
		JPanel boxPanel = new JPanel(new GridLayout(2,4));
		boxPanel.add(arrayPrograms.get(0));//each of these refer to index number in ArrayList
		boxPanel.add(arrayPrograms.get(1));
		boxPanel.add(arrayPrograms.get(2));
		boxPanel.add(arrayPrograms.get(3));
		boxPanel.add(arrayPrograms.get(4));
		boxPanel.add(arrayPrograms.get(5));
		boxPanel.add(arrayPrograms.get(6));
		boxPanel.add(arrayPrograms.get(7));
		demoPanel.add(boxPanel,c);//add this panel to the demoPanel
		
	//layout for comments	
		c.gridx = 0;
		c.gridy = 14;
		c.gridwidth = 4;
		demoPanel.add(lblComments,c);
		
		c.gridx = 1;
		demoPanel.add(txtComments,c);
		
	//layout for save
		c.gridx = 0;
		c.gridy = 15;
		demoPanel.add(lblSaveInstructions,c);
		
		c.gridy = 16;
		demoPanel.add(btnSave,c);
	
		
	//add the demoPanel to the mainFrame	
		mainFrame.add(demoPanel);
		mainFrame.pack();//make everything fit
	   	
	//saves to a file when the save button is clicked
		btnSave.addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed(java.awt.event.ActionEvent e){
				
			//puts values of swing elements into variables to be used for writing to file
				String txtFnameValue = txtFirstName.getText();
				String txtLnameValue = txtLastName.getText();
				String txtMnameValue = txtMidInitial.getText();
				String txtTitleValue = txtTitle.getText();
				String txtCredentialValue = txtCredentials.getText();
				boolean cbContractSelected = contractBox.isSelected();
				boolean cbPermanentSelected = permanentBox.isSelected();
				boolean cbRegularSelected = regBox.isSelected();
				boolean cbSwingSelected = swingBox.isSelected();
				boolean cbNightSelected = nightBox.isSelected();
				boolean cbPRNSelected = prnBox.isSelected();
				boolean cbAllSelected = allBox.isSelected();
				//the next boolean variable looks to see if any are true so I can use it to do something if they are all false
				boolean cbAnySelected = regBox.isSelected() || swingBox.isSelected() || nightBox.isSelected() || prnBox.isSelected() || allBox.isSelected();
				String comboDeptSelected = (String)deptBox.getSelectedItem();// this looks through Department array and gets the checkboxes that are selected
				String txtCommentValue = txtComments.getText();
				
			//begins a writer for external, it creates a new file if there is already one there with name it overwrites that file
			//handles exceptions
				PrintWriter writer = null;
				try {
					writer = new PrintWriter("NewEmployeeOutput.txt", "UTF-8");
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				} catch (UnsupportedEncodingException e1) {
					e1.printStackTrace();
				}
			//prints headings and values on output file 
				writer.print("First Name: ");
				writer.println(txtFnameValue);
				writer.print("Last Name: ");
				writer.println(txtLnameValue);
				writer.print("Middle Initial:");
				writer.println(txtMnameValue);
				writer.print("Title: ");
				writer.println(txtTitleValue);
				writer.print("Credentials: ");
				writer.println(txtCredentialValue);
				
			/*multiple if statements to check on checkbox values that are not in arrays
			* as you can see, probably faster to use array, but I wasn't sure 
			* I could figure out how to get values from array so I did it both ways.
			*/
				writer.print("Status: ");
				
				if (cbContractSelected){
					writer.println("Contract Employee");
				}else if(cbPermanentSelected){
					writer.println("Permanent Employee");
				}else {
					writer.println("No Status Selected");
				}
					writer.print("Shift: ");
				if (cbRegularSelected) {
					writer.println("Regular Shift");
				}
				if (cbSwingSelected) {
					writer.println("Swing Shift");
				}
				if (cbNightSelected){
					writer.println("Night Shift");
				}
				if (cbPRNSelected){
					writer.println("PRN");
				}
				if (cbAllSelected){
					writer.println("Available all shifts");
				}else if(!cbAnySelected){
					writer.println("No Shift Selected");
				}
				writer.print("Department:");
				writer.println(comboDeptSelected);
				
			//looks through program list array and print values if the check box for the program is selected
				writer.print("Grants Access To: ");
				for(JCheckBox values : arrayPrograms){
					if(values.isSelected()){
						writer.print(values.getActionCommand() + ", ");
					}
				}
			//prints comments
				writer.println();
				writer.print("Comments: ");
				writer.println(txtCommentValue);
				
				writer.close();
				mainFrame.dispose();//closes frame when all is complete
			}
		});
		
	}

}
