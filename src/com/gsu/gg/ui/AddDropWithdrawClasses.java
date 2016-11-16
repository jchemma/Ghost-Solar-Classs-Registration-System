package com.gsu.gg.ui;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.gsu.gg.to.Course;
import com.gsu.gg.to.User;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 *
 * @author jchemma
 */
public class AddDropWithdrawClasses{
	
	User user;
	ObservableList<Course> course = FXCollections.emptyObservableList();
	
	public AddDropWithdrawClasses(User user){
		this.user = user;;
		for(int crn : user.getCRN()){
			Course c = new Course(crn);
			course.add(c);
		}
		
		
	}
    
    public void display() {
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        Date date = new Date();
        Stage window = new Stage();
        //Table
        TableView<Course> table = new TableView<Course>();
        //Columns
        double columnWidth = 67;
        TableColumn statusColumn = new TableColumn("Status");
        statusColumn.setPrefWidth(columnWidth);
        statusColumn.setCellValueFactory(new PropertyValueFactory<Course, String> ("status"));
        
        TableColumn actionColumn = new TableColumn("Action");
        actionColumn.setPrefWidth(columnWidth);
        actionColumn.setCellValueFactory(new PropertyValueFactory<Course, ComboBox> ("action"));
        
        TableColumn crnColumn = new TableColumn("CRN");
        crnColumn.setPrefWidth(columnWidth);
        crnColumn.setCellValueFactory(new PropertyValueFactory<Course, Integer> ("crn"));
        
        TableColumn subjectColumn = new TableColumn("Subject");
        subjectColumn.setPrefWidth(columnWidth);
        subjectColumn.setCellValueFactory(new PropertyValueFactory<Course, String> ("subject"));
        
        TableColumn courseColumn = new TableColumn("Course");
        courseColumn.setPrefWidth(columnWidth);
        courseColumn.setCellValueFactory(new PropertyValueFactory<Course, String> ("course"));
        
        TableColumn sectionColumn = new TableColumn("Section");
        sectionColumn.setPrefWidth(columnWidth);
        sectionColumn.setCellValueFactory(new PropertyValueFactory<Course, String> ("section"));
        
        TableColumn daysColumn = new TableColumn("Days");
        daysColumn.setPrefWidth(columnWidth);
        daysColumn.setCellValueFactory(new PropertyValueFactory<Course, String> ("days"));
        
        TableColumn timeColumn = new TableColumn("Time");
        timeColumn.setPrefWidth(columnWidth);
        timeColumn.setCellValueFactory(new PropertyValueFactory<Course, String> ("time"));
        
        TableColumn levelColumn = new TableColumn("Level");
        levelColumn.setPrefWidth(columnWidth);
        levelColumn.setCellValueFactory(new PropertyValueFactory<Course, String> ("level"));
        
        TableColumn creditHoursColumn = new TableColumn("Credit Hours");
        creditHoursColumn.setPrefWidth(columnWidth);
        creditHoursColumn.setCellValueFactory(new PropertyValueFactory<Course, Integer> ("credit hours"));
        
        TableColumn gradeModeColumn = new TableColumn("Grade Mode");
        gradeModeColumn.setPrefWidth(columnWidth);
        gradeModeColumn.setCellValueFactory(new PropertyValueFactory<Course, String> ("grade mode"));
        
        TableColumn titleColumn = new TableColumn("Title");
        titleColumn.setPrefWidth(columnWidth);
        titleColumn.setCellValueFactory(new PropertyValueFactory<Course, String> ("title"));
        
        table.setItems(course);
        
        //add columns to table
        table.getColumns().addAll(statusColumn, actionColumn, crnColumn, 
                subjectColumn, courseColumn, sectionColumn, daysColumn, 
                timeColumn, levelColumn, creditHoursColumn, gradeModeColumn, 
                titleColumn);
        
        //Labels
        //heading
        Label currentScheduleLabel = new Label("Current Schedule");
        currentScheduleLabel.setFont(new Font("Arial", 20));
        
        Label addClassesWorksheetLabel = new Label("Add Classes Worksheet");
        addClassesWorksheetLabel.setFont(new Font("Arial", 20));
        addClassesWorksheetLabel.setPadding(new Insets(30,0,0,0));
        
        //CRN textfields
        TextField crn1 = new TextField();
        TextField crn2 = new TextField();
        TextField crn3 = new TextField();
        TextField crn4 = new TextField();
        TextField crn5 = new TextField();
        TextField crn6 = new TextField();
        TextField crn7 = new TextField();
        TextField crn8 = new TextField();
        
        //crn entry layout
        HBox crnLayout = new HBox();
        crnLayout.getChildren().addAll(crn1, crn2, crn3, crn4, crn5, crn6, crn7, crn8);
        
        //Buttons
        Button submitChanges = new Button("Submit Changes");
        Button classSearch = new Button("Class Search");
        Button reset = new Button("Reset");
        
        //miscallaneous labels
        Label totalCreditHoursLabel = new Label("Total Credit Hours: ");
        Label billingHoursLabel = new Label("Billing Hours: ");
        Label minimumHoursLabel = new Label("Minimum Hours: ");
        Label maximumHoursLabel = new Label("Maximum Hours: ");
        Label currentDateLabel = new Label("Date: ");
        
        //miscellaneous value labels
        Label totalCreditHoursValueLabel = new Label("#");
        Label billingHoursValueLabel = new Label("#");
        Label minimumHoursValueLabel = new Label("#");
        Label maximumHoursValueLabel = new Label("#");
        Label currentDateValueLabel = new Label(dateFormat.format(date));
        
        //miscellaneous layout
        HBox miscellaneousLabelsAndValueLabelLayout = new HBox();
        VBox miscellaneousLabelsLayout = new VBox();
        VBox miscellaneousValueLabelLayout = new VBox();
        
        //labels
        miscellaneousLabelsLayout.getChildren().addAll(totalCreditHoursLabel, 
                billingHoursLabel, minimumHoursLabel, maximumHoursLabel, 
                currentDateLabel);
        
        //values
        miscellaneousValueLabelLayout.getChildren().addAll(
                totalCreditHoursValueLabel, billingHoursValueLabel, 
                minimumHoursValueLabel, maximumHoursValueLabel, 
                currentDateValueLabel);
        
        //labels and values
        miscellaneousLabelsAndValueLabelLayout.getChildren().addAll(
                miscellaneousLabelsLayout, miscellaneousValueLabelLayout);
        
        //layout for buttons
        HBox buttonLayout = new HBox();
        buttonLayout.getChildren().addAll(submitChanges, classSearch, reset);
        
        //layout for entire page
        VBox pageLayout = new VBox();
        pageLayout.getChildren().addAll(currentScheduleLabel, table, 
                miscellaneousLabelsAndValueLabelLayout, 
                addClassesWorksheetLabel, crnLayout, buttonLayout);
        Scene scene = new Scene(pageLayout,804,600);
        
        window.setTitle("Add/Drop/Withdraw");
        window.isAlwaysOnTop();
        window.setScene(scene);
        window.alwaysOnTopProperty();
        window.showAndWait();
    }
}