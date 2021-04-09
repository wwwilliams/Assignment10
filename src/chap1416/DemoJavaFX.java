/* Westley W Williams
 *  CIS 2212-800 Java I FlexPace
 *  Assignment 10 - JavaFX Basics and UI Controls
 *  Started April 5th, 2021
 */
package chap1416;

//imports for the program
import java.text.SimpleDateFormat;
import java.util.Date;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
//end of imports

//beginning of DemoJavaFX class, which extends Application
public class DemoJavaFX extends Application {

	// define strings to be used later.
	String additionalItem1 = "4\" x 6\"" + "\r\n\t";// 4x6
	String additionalItem2 = "5\" x 7\"" + "\r\n\t";// 5x7
	String additionalItem3 = "8\" x 10\"" + "\r\n\t";// 8x10
	String additionalItem4 = "Button" + "\r\n\t";// Button
	String additionalItem5 = "Magnet" + "\r\n\t";// Magnet
	String additionalItem6 = "Picture Packet" + "\r\n\t";// Picture packet

	// packages are below (as opposed to the individual items)
	String packagesAvailable1 = "Picture Packet & Photo Button" + "\r\n\t";
	String packagesAvailable2 = "Picture Packet & Photo Magnet" + "\r\n\t";
	String packagesAvailable3 = "Picture Packet, Button, Magnet" + "\r\n\t";
	// The title/trademark
	String tradeMark = "SCC Photography..." + "\n" + "keeping memories alive";

	@Override
	public void start(Stage primaryStage) {
		// I used the following source
		// https://mkyong.com/java/java-date-and-calendar-examples/
		SimpleDateFormat dateFormat = new SimpleDateFormat("MMM dd yyyy");// create the format for display
		Date todaysDateAndTime = new Date();// create a new date and time
		String todaysDateWithoutTime = dateFormat.format(todaysDateAndTime.getTime());// filter out the time. I want the
		// user to only see the date as
		// the time changes so quickly
		// that it would make for a poor
		// static display
		Label dateLabel = new Label(todaysDateWithoutTime);// create a label for the date

		Label tradeMarkLabel = new Label(tradeMark);// create the trademark or title label
		tradeMarkLabel.setFont(new Font("Papyrus", 35));// set the font type to papyrus and the size to 35
		tradeMarkLabel.setTextFill(Color.FIREBRICK);// color the trademark label firebrick

		// create checkboxes and name each checkbox using the String variables created
		// above
		CheckBox additionalItemCheckbox1 = new CheckBox(additionalItem1);
		CheckBox additionalItemCheckbox2 = new CheckBox(additionalItem2);
		CheckBox additionalItemCheckbox3 = new CheckBox(additionalItem3);
		CheckBox additionalItemCheckbox4 = new CheckBox(additionalItem4);
		CheckBox additionalItemCheckbox5 = new CheckBox(additionalItem5);
		CheckBox additionalItemCheckbox6 = new CheckBox(additionalItem6);

		// create a VBox and add additionalItemCheckbox 1 through 6
		VBox additionalItemsVBox = new VBox(additionalItemCheckbox1, additionalItemCheckbox2, additionalItemCheckbox3,
				additionalItemCheckbox4, additionalItemCheckbox5, additionalItemCheckbox6);

		// create a new order button, a new clear button, and a new exit button
		Button orderButton = new Button("Process My Order");// name of button is "Process My Order"
		// style the button with background color, font size, font family
		orderButton.setStyle("-fx-background-color: Darkgreen;" + "-fx-text-fill: Lemonchiffon;"
				+ "-fx-font-size: 12px;" + "-fx-font-family: Papyrus;");
		Button clearButton = new Button("Clear");// name of button is "Clear"
		// style the button with background color, font size, and font family
		clearButton.setStyle("-fx-background-color: Darkgreen;" + "-fx-text-fill: Lemonchiffon;"
				+ "-fx-font-size: 12px;" + "-fx-font-family: Papyrus;");
		Button exitButton = new Button("Exit");// name of the button is "Exit"
		// style the button with background color, font family, font color, and bold
		exitButton.setStyle("-fx-background-color: Darkgreen;" + "-fx-text-fill: Lemonchiffon;" + "-fx-font-size: 12px;"
				+ "-fx-font-family: Papyrus;" + "-fx-font-weight: bold;");

		// package the buttons in an HBox
		HBox buttonBox = new HBox(orderButton, clearButton, exitButton);

		// create a togglegroup to place radio buttons. This makes it to where we can't
		// have two buttons clicked simultaneously
		ToggleGroup groupOfButtons = new ToggleGroup();
		// create the first radio button
		RadioButton radioButton1 = new RadioButton(packagesAvailable1);
		// create the second radio button
		RadioButton radioButton2 = new RadioButton(packagesAvailable2);
		// create the third radio button
		RadioButton radioButton3 = new RadioButton(packagesAvailable3);
		radioButton1.setToggleGroup(groupOfButtons);// put the radio button 1 in toggle group
		radioButton2.setToggleGroup(groupOfButtons);// radio button 2 goes in toggle group
		radioButton3.setToggleGroup(groupOfButtons);// radio button 3 goes in toggle group

		// Textfield where the user will eventually enter their first name
		TextField userFirstName = new TextField("Enter First Name");
		userFirstName.setMaxWidth(250);// max width of 250px
		// user will enter their last name
		TextField userLastName = new TextField("Enter Last Name");
		userLastName.setMaxWidth(250);// max width of 250 px
		// user will eventually enter their phone number
		TextField userPhone = new TextField("Enter Phone Number");
		userPhone.setMaxWidth(250);// max width of 250 px
		// total amount due field is below. This will be uneditable
		TextField totalAmountDue = new TextField("10,000.00");
		// style the total amount due first
		totalAmountDue.setStyle("-fx-background-color: Darkgreen;");
		totalAmountDue.setMinWidth(85);// set the minimum width of total amount due
		totalAmountDue.setEditable(false);// make it to where user cannot edit it. It will be display only
		// package the date label, the user fir name and last name, and the total amount
		// due and phone number in a VBox
		VBox buyerInfoVBox = new VBox(dateLabel, userFirstName, userLastName, userPhone, totalAmountDue);
		// position the buyer info VBox to center
		buyerInfoVBox.setAlignment(Pos.CENTER);

		GridPane gridPane = new GridPane();// create a new grid pane.
		// style the gridpane a Moccasin color
		gridPane.setStyle("-fx-background-color: #FFE4B5;");
		// add the trademark label at position column 0 and row 0 to extend a cell of
		// one in both directions
		gridPane.add(tradeMarkLabel, 0, 0, 1, 1);
		gridPane.add(buyerInfoVBox, 0, 1, 1, 1);// add the buyerInfoVBox to the pane
		gridPane.add(radioButton1, 0, 2, 1, 1);// add radio buttons to gridpane
		gridPane.add(radioButton2, 0, 3, 1, 1);// radio button added
		gridPane.add(radioButton3, 0, 4, 1, 1);// radio button added
		gridPane.add(additionalItemsVBox, 0, 5, 1, 1);// add individual items to pane
		gridPane.add(buttonBox, 0, 6);// add the buttons to the pane

		gridPane.setAlignment(Pos.CENTER);// center the items in the gridpane
		GridPane.setHalignment(tradeMarkLabel, HPos.CENTER);// explicitly center the trademark label
		GridPane.setHalignment(buttonBox, HPos.CENTER);// explicitly center the button box

		gridPane.setPadding(new Insets(10, 12, 10, 12));// set insets on the gridpane
		gridPane.setHgap(9);// set horizontal gaps
		gridPane.setVgap(8);// set vertical gaps

		Scene scene = new Scene(gridPane, 600, 900);// set the scene for a certain pixel height and width
		primaryStage.setTitle("SCC Photography Purchasing App");// setting the stage title
		primaryStage.setResizable(false);// the stage is set to not be resized
		primaryStage.setScene(scene);// scene goes in stage
		primaryStage.show();// show the stage
	}// end of start method

	// start of main method
	public static void main(String[] args) {
		//launch the application
		Application.launch(args);
	}// end of main method

}// end of DemoJavaFX class