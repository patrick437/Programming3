//Java core packages
import java.awt.*;
import java.awt.event.*;

// Java extension packages
import javax.swing.*;

/**
 * Class which creates the GUI 
 */
public class JLabelExample extends JFrame {

	
	/**
	 *  Instantiating all the new JPanels, JButton, JRadioButtons, JRadioBoxes etc
	 */
	private JPanel pictures, buttons, buttons2, pictures2, comboBox;
	private JButton jbutton;
	private int i=1, z=1;
	private JRadioButton jbutton1, jbutton2, jbutton3, jbutton4, jbutton5, jbutton6, jbutton7, jbutton8;
	private JComboBox imagesComboBox;
	private JLabel label, label2;
	
	//Set arrays for each story adding the names of each athlete to arrays and adding there picture into a separate array
	private String coffeeClubNames[] = { "MorganMcdonald.jpg", "OliHoare.jpg", "GeordieBeamish.jpg" };
	private String bowermanNames[] = { "GrantFisher.jpg", "MathewCentrowitz.jpg", "Jager_Evan.jpg", "WoodyKincaid.jpg", "LopezLomong.jpg" };
	private String stories[] = { "Coffee Club", "Bowerman Track Club"};
	
	private Icon coffeeClub[] = { new ImageIcon( coffeeClubNames[0]), new ImageIcon(coffeeClubNames[1]), new ImageIcon( coffeeClubNames[2])};
	private Icon bowerman[] = { new ImageIcon( bowermanNames[0]), new ImageIcon(bowermanNames[1]), new ImageIcon(bowermanNames[2]), new ImageIcon(bowermanNames[3]), new ImageIcon(bowermanNames[4])};
	

	/**
	 * Constructor which creates the GUI when JLabel object is instantiated
	 */
	public JLabelExample()
	{
		
		//story 1 created 
		super( "Testing ComboBox");
		
		//creating a container which willl contain all the JPanels
		Container story1 = getContentPane();
		setSize(500,500);
		story1.setLayout( new BorderLayout() );
				
		//creating radiobuttons for the first story
		jbutton1 = new JRadioButton( );
		jbutton2 = new JRadioButton( );
		jbutton3 = new JRadioButton( );		
		
		//giving all these buttons an item listener
		RadioButtonHandler handler = new RadioButtonHandler();
		jbutton1.addItemListener(handler);
		jbutton2.addItemListener(handler);
		jbutton3.addItemListener(handler);
		
		//adding all these buttons to a listener
		ButtonGroup radioGroup = new ButtonGroup();
		radioGroup.add(jbutton1);
		radioGroup.add(jbutton2);
		radioGroup.add(jbutton3);
		
		//creating a panel for these buttons and adding the buttons to the JPanel
		buttons = new JPanel();
		buttons.setBackground(Color.green);
		buttons.setPreferredSize(new Dimension(5,50));
		buttons.add(jbutton1);
		buttons.add(jbutton2);
		buttons.add(jbutton3);
		story1.add(buttons);
		buttons.setAlignmentX(Component.CENTER_ALIGNMENT);
		
	
		//creating panel for pictures and adding pictures
		label = new JLabel( coffeeClubNames[i], coffeeClub[i], SwingConstants.CENTER );
		pictures = new JPanel( new BorderLayout());
		pictures.setBackground(Color.green);
		pictures.add(label, BorderLayout.NORTH);
		story1.add(pictures, BorderLayout.NORTH);
				
		//story 2 being created
		//creating a JLabel for the second story and adding the first label in the list
		label2 = new JLabel( bowermanNames[0], bowerman[0], SwingConstants.CENTER);
		buttons2 = new JPanel();  //creating a buttons panel and a pictures panel for the second story
		buttons2.setBackground(Color.blue);
		pictures2 = new JPanel( );
		pictures2.setBackground(Color.blue);
		pictures2.add(label2, BorderLayout.NORTH);
				
		//creatung 5 new radio buttons for the second story and adding them to a group
		jbutton4 = new JRadioButton( );
		jbutton5 = new JRadioButton( );
		jbutton6 = new JRadioButton( );
		jbutton7 = new JRadioButton( );
		jbutton8 = new JRadioButton( );
		
		//placing each button into the same handler as the handler from above
		jbutton4.addItemListener(handler);
		jbutton5.addItemListener(handler);
		jbutton6.addItemListener(handler);
		jbutton7.addItemListener(handler);
		jbutton8.addItemListener(handler);
		
		ButtonGroup radioGroup2 = new ButtonGroup();
		radioGroup2.add(jbutton4);
		radioGroup2.add(jbutton5);
		radioGroup2.add(jbutton6);
		radioGroup2.add(jbutton7);
		radioGroup2.add(jbutton8);
		
		//creating a panel for these buttons and adding the buttons to the JPanel
		buttons2 = new JPanel();
		buttons2.setBackground(Color.blue);
		buttons2.setPreferredSize(new Dimension(5,50));
		buttons2.add(jbutton4);
		buttons2.add(jbutton5);
		buttons2.add(jbutton6);
		buttons2.add(jbutton7);
		buttons2.add(jbutton8);
		
		//making a combobox in order to be able to change story
		imagesComboBox = new JComboBox<String>(stories);
		imagesComboBox.setMaximumRowCount(stories.length);
		imagesComboBox.addItemListener(
				//making an item listener for the image combo box
				new ItemListener() { 
					
					public void itemStateChanged( ItemEvent event)
					{
						if( (String)imagesComboBox.getSelectedItem() == "Coffee Club")
						{
							story1.repaint();
							story1.revalidate();
							//story1.add(buttons, BorderLayout.CENTER);
							//story1.add(pictures, BorderLayout.NORTH);
							
							//making the selected panels visible and invisible
							buttons2.setVisible(false);
							pictures2.setVisible(false);
							buttons.setVisible(true);
							pictures.setVisible(true);
							
						}
						else if((String) imagesComboBox.getSelectedItem() == "Bowerman Track Club")
						{
							story1.repaint();
							story1.revalidate();
							
							//adding the second story's panels to the container
							story1.add(buttons2, BorderLayout.CENTER);
							story1.add(pictures2, BorderLayout.NORTH);
							
							//setting the selected panels to visible and invisible
							buttons2.setVisible(true);
							pictures2.setVisible(true);
							buttons.setVisible(false);
							pictures.setVisible(false);
							
						}
						
					}
				}
				);
		
		//Creating a JPanel for the combobox amd adding the combo box to it
		comboBox = new JPanel( new BorderLayout() );
		comboBox.add(imagesComboBox, BorderLayout.NORTH);
		comboBox.setSize(50,50);
		story1.add(comboBox, BorderLayout.SOUTH);
		
		//Creating a JButton to print when a new story has been added
		jbutton = new JButton("Add new Story");
		//creating a action listener to print to the console whenever the button has been pressed
		jbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				System.out.println("A new story has been created");
				revalidate();
			}
		}
		);
		//adding this button to the comboBox JPanel
		comboBox.add(jbutton, BorderLayout.SOUTH);
		setVisible( true );
		
		
	}
				
	
	
	
	public static void main(String args[])
	{
		//Creating a main method and creating a JLabel object whos constructor calls the GUI into action
		JLabelExample jLabel = new JLabelExample();
		jLabel.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	}
	
	

	/**
	 * RadioButtonHandler class
	 * class which handles all the radio buttons and decides what happens when each one is pressed 
	 */
	private class RadioButtonHandler implements ItemListener
	{
		//Item listener for the radio buttons. IF statement which says whichever radiobutton is selected should show the chosen Icon
		public void itemStateChanged(ItemEvent event)
		{
			if( event.getSource() == jbutton1) {
				label.setIcon(coffeeClub[0]);
				label.setText(coffeeClubNames[0]);}
			else if( event.getSource() == jbutton2) {
				label.setIcon(coffeeClub[1]);
				label.setText(coffeeClubNames[1]);}
			else if(  event.getSource() == jbutton3) {
				label.setIcon(coffeeClub[2]);
				label.setText(coffeeClubNames[2]);}
			else if( event.getSource() == jbutton4) {
				label2.setIcon(bowerman[0]);
				label2.setText(bowermanNames[0]);}
			else if( event.getSource() == jbutton5) {
				label2.setIcon(bowerman[1]);
				label2.setText(bowermanNames[1]);}
			else if( event.getSource() == jbutton6) {
				label2.setIcon(bowerman[2]);
				label2.setText(bowermanNames[2]);}
			else if( event.getSource() == jbutton7) {
				label2.setIcon(bowerman[3]);
				label2.setText(bowermanNames[3]);}
			else if( event.getSource() == jbutton8) {
				label2.setIcon(bowerman[4]);
				label2.setText(bowermanNames[4]);}
			
			
		}
	}
	
	

}
