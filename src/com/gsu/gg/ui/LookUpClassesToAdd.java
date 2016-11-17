package com.gsu.gg.ui;

import com.gsu.gg.to.User;

import javafx.application.Application;
import javafx.collections.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import javafx.stage.*;


public class LookUpClassesToAdd  extends Application{
			
	public static void main(String[] args){
		launch(args);
	}
	
	ListView<String> lvDegree, lvSubject, lvCampus, parTerm, instr, crsType; 
	TextField crsNum, title, credRange, credRange2;
	ChoiceBox sHour, eHour, sMinute, eMinute, sAP, eAP;
	CheckBox  cbMon, cbTue, cbWed, cbThur, cbFri, cbSat, cbSun;
	Button secSearch, reset, exit;
	Label degree, subject, crsNumLab, titleLab, crdRan, camLab, parTLab;
	Label instLab, crsTypLab, hourS, hourE, minS, minE, apS, apE;
	Label  lDays, sTime, eTime;
	
	
	//public void display() {
	public void start(Stage lookUp){
		
		//Create Stage.
		//Stage lookUp = new Stage();
		//Give the stage a title.
		lookUp.setTitle("Class Schedule Search");
		
		//Use a VBox for the root node. 
		VBox rootNode = new VBox();
		rootNode.setAlignment(Pos.TOP_CENTER);
				
		//Create a scene.
		Scene myScene = new Scene(rootNode,  800, 600);
		
		//Set scene on the stage.
		lookUp.setScene(myScene);
		
		//Create Label names
		degree = new Label("Degree:");
		subject = new Label("Subject:");
		crsNumLab = new Label("Course Number:");
		titleLab = new Label("Title:");
		crdRan = new Label("Credit Range:");
		camLab = new Label("Campus:");
		parTLab = new Label("Part of Term:");
		instLab = new Label("Instructor:");
		crsTypLab = new Label("Course Type:");
		hourS = new Label("Hour");
		hourE = new Label("Hour");
		minS = new Label("Minute");
		minE = new Label("Minute");
		apS= new Label("am/pm");
		apE = new Label("am/pm");
		lDays = new Label("Days:");
		sTime = new Label("Start Time:");
		eTime = new Label("End Time:");		
		
		//Create the CheckBoxes.
		//CheckBox  mon, tue, wed, thur, fri, sat, sun;
		cbMon = new CheckBox("Monday");
		cbTue = new CheckBox("Tuesday");
		cbWed = new CheckBox("Wednesday");
		cbThur = new CheckBox("Thursday");
		cbFri = new CheckBox("Friday");
		cbSat = new CheckBox("Saturday");
		cbSun = new CheckBox("Sunday");
		
		//Create ListViews
		//ListView<String> lvDegree, lvSubject, lvCampus, parTerm, instr, crsType
		//ListView<String> for Degree types.
		lvDegree = new ListView<String>();
		ObservableList<String> degItems = FXCollections.observableArrayList ("Associates (2-year undergraduate students)", "Bachelors(4-year undergraduate students", "Graduate (Graduate level students");
		lvDegree.setItems(degItems);
		lvDegree.setMinSize(250, 75);
		lvDegree.setMaxSize(250, 75);
		
		
		//ListView<String> for Subject types.
		lvSubject = new ListView<String>();
		ObservableList<String> subItems = FXCollections.observableArrayList("ACCOUNTING", "BIOLOGY", "CHEMISTRY", "COMPUTER SCIENCE", "DRAWING AND PAINTING", 
				"ECONOMICS", "FINANCE", "GEOLOGY", "HISTORY", "INTERIOR DESIGN", "JOURNALISM", "SPANISH", "SPEECH COMMUNICATION", "STATISTICS",
				"kINESIOLOGY", "LANGUAGE ARTS EDUCATION", "MATHEMATICS", "NURSING", "PERSPECTIVE", "REAL ESTATE", "TAXATION", "WOMEN'S GENDER & SEXUALITY STU");
		lvSubject.setItems(subItems);
		lvSubject.setPrefHeight(100);
		
		//ListView<String> for Campus
		lvCampus = new ListView<String>();
		ObservableList<String> locItems = FXCollections.observableArrayList("All", "Alpharetta-Associates courses", "Atlanta", "Foreign Campus");
		lvCampus.setItems(locItems);
		lvCampus.setPrefHeight(100);
		lvCampus.setMinSize(200, 50);
		lvCampus.setMaxSize(200, 50);
		
		//ListView<String> for Terms
		parTerm = new ListView<String>();
		ObservableList<String> termItems = FXCollections.observableArrayList("All", "Exception (All Terms)", "Full Term(Fall or Spring", "Mini-mester 1 (Fall or Spring)", "Mini-mester 2 (Fall or Spring)");
		parTerm.setItems(termItems);
		parTerm.setMinSize(200, 75);
		parTerm.setMaxSize(200, 75);
		
		//ListView<String> for Instructors
		instr = new ListView<String>();
		ObservableList<String> insItems = FXCollections.observableArrayList("Jerome, Key", "Instructor, Your F.", "Bhola, Jaman L.");
		instr.setItems(insItems);
		instr.setMinSize(150, 50);
		instr.setMaxSize(150, 50);
		
		//ListView<String> for course type.
		crsType = new ListView<String>();
		ObservableList<String> crsItems = FXCollections.observableArrayList("All", "Critical Thinking Thru Writing", "Honors", "Hybrid/Partially Online", "Online", "Supplemental Instruction");
		crsType.setItems(crsItems);
		crsType.setMinSize(200, 100);
		crsType.setMaxSize(200, 100);
		
		//Create TextFields
		//TextField crsNum, title, credRange, credRange2;
		crsNum = new TextField();
		crsNum.setPromptText("Course Number e.g. 4350");
		crsNum.getText();
		
		//title TextField
		title = new TextField();
		title.setPromptText("e.g. Software Engineering-CTW");
		title.getText();
		
		//Create ChoiceBoxes
		//ChoiceBox sHour, eHour, sMinute, eMinute, sAP, eAP;
		sHour = new ChoiceBox(FXCollections.observableArrayList("01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"));
		eHour = new ChoiceBox(FXCollections.observableArrayList("01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"));
		sMinute = new ChoiceBox(FXCollections.observableArrayList("00", "05", "10", "15", "20", "25", "30", "35", "40", "45", "50", "55"));
		eMinute =new ChoiceBox(FXCollections.observableArrayList("00", "05", "10", "15", "20", "25", "30", "35", "40", "45", "50", "55"));
		sAP = new ChoiceBox(FXCollections.observableArrayList("am", "pm"));
		eAP = new ChoiceBox(FXCollections.observableArrayList("am", "pm"));
		
		//create a FlowPane to go in VBox with appropriat labels
		FlowPane controlla = new FlowPane();
		controlla.setPadding(new Insets(20,0,10,30));
		controlla.setHgap(20);
		controlla.getChildren().addAll(degree, lvDegree, subject, lvSubject );
		controlla.setPrefWrapLength(400);
		controlla.setAlignment(Pos.CENTER_LEFT);
		
		FlowPane fCon = new FlowPane();
		fCon.getChildren().addAll(crsNumLab, crsNum, titleLab, title);
		fCon.setPrefWrapLength(100);
		fCon.setAlignment(Pos.CENTER_LEFT);
		fCon.setHgap(50);
		fCon.setPadding(new Insets(20,0,0,30));
		
		HBox hbCBoxes = new HBox();
		hbCBoxes.setSpacing(10);
		hbCBoxes.getChildren().addAll(lDays, cbMon, cbTue, cbWed, cbThur, cbFri, cbSat, cbSun);
		
		HBox chBoxes = new HBox();
		chBoxes.setSpacing(20);
		chBoxes.getChildren().addAll(hourS, sHour, minS, sMinute, apS, sAP, apE, eAP);
		
		HBox chBoxes2 = new HBox();
		chBoxes2.setSpacing(20);
		chBoxes2.getChildren().addAll(hourE, eHour, minE, eMinute, apE, eAP);
		
		//Button secSearch, reset, exit;
		//XCreate buttons
		secSearch = new Button("Section Search");
		reset = new Button("Reset");
		exit = new Button("Back");
		
		/**Handle the action events for the First button.
		secSearch.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent ae) {
				open new window
				 new LookUpClassTable(user).display();
			}
		});
		**/
		
		/**Handle the action event for the exit button.
		exit.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent ae){
			//new AddDropWithdrawClasses(user).display();
			}
		});
		**/
		
		/**Handle the action even for the reset button.
		reset.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent ae){
				//cbMon.setSelected(false);
				//cbTue.setSelected(false);
				//cbWed.setSelected(false);
				//cbThur.setSelected(false);
				//cbFri.setSelected(false);
				//cbSat.setSelected(false);
				//cbSun.setSelected(false);
				
			}
		});
		**/
		
		HBox bBox = new HBox();
		bBox.setAlignment(Pos.CENTER);
		bBox.setMaxWidth(200);
		bBox.setMinWidth(200);
		GridPane bGP = new GridPane();
		bGP.setHgap(10);
		bGP.add(secSearch, 4, 0);
		bGP.add(exit, 5, 0);
		bBox.getChildren().add(bGP);
		
		HBox bBox2 = new HBox();
		bBox2.setAlignment(Pos.CENTER);
		bBox2.setMaxWidth(200);
		bBox2.setMinWidth(200);
		GridPane bGP2 = new GridPane();
		bGP2.setHgap(10);
		bGP2.add(reset, 0, 0);
		
		
		
		GridPane gP = new GridPane();
		gP.setPadding(new Insets(20,0,0,30));
		gP.setHgap(35);
		gP.setVgap(20);
		gP.add(camLab, 0, 0);
		gP.add(lvCampus, 1, 0);
		gP.add(parTLab, 0, 1);
		gP.add(parTerm, 1, 1);
		gP.add(instLab, 2, 0);
		gP.add(instr, 3, 0);
		gP.add(crsTypLab, 2, 1);
		gP.add(crsType, 3, 1);
		gP.add(sTime, 0, 3);
		gP.add(eTime, 0, 4);
		gP.add(chBoxes, 1, 3, 3, 3);
		gP.add(chBoxes2, 1, 4, 4, 4);
		gP.add(hbCBoxes, 0, 5, 5, 5);
		gP.add(bBox, 3, 7, 2, 1);
		gP.add(bGP2, 0, 7, 2, 1);
		
				
		rootNode.getChildren().addAll(controlla, fCon, gP);
	
		lookUp.show();
	}
	

}
