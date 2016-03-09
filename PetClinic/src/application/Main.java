package application;
	

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	
	Scene mainScene, addCustomerScene, petScene;
	Stage stage;
	TableView<Customer> customerTable;
	TableView<Pet> petTable;
	Customer selectedCustomer;	
	Pet selectedPet;
	ObservableList<Customer> customers = FXCollections.observableArrayList();
	ObservableList<Pet> pets = FXCollections.observableArrayList();
	
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) {
		
		stage = primaryStage;
		stage.setTitle("PetCare Veterinary Service");
        stage.setWidth(450);
        stage.setHeight(500);
        
        //scene labels
        //mainScene Label 
        final Label mainLabel = new Label("Address Book");
        mainLabel.setFont(new Font("Arial", 20));
        
        //customerScene Label
        final Label customerLabel = new Label("Customer Details");
        customerLabel.setFont(new Font("Arial", 20));
        
        //petScene Label
        final Label petLabel = new Label("Pet Details");
        petLabel.setFont(new Font("Arial", 20));
        
        
        
        
        //buttons for mainScene
        //1. addCustomer button
        Button addCustomerBtn = new Button("Add");
        addCustomerBtn.setOnAction(e -> stage.setScene(addCustomerScene));
        //2. deleteCustomer button
        Button deleteCustomerBtn = new Button("Delete");
        deleteCustomerBtn.setOnAction(e -> {
        	selectedCustomer = customerTable.getSelectionModel().getSelectedItem();
        	customers.remove(selectedCustomer);
        });
        
        
        TextField firstName = new TextField();
        TextField lastName = new TextField();
        TextField address = new TextField();
        TextField phoneNumber = new TextField();
        TextField petName = new TextField();
        petName.setPromptText("Enter pets name");
        TextField typeOfAnimal = new TextField();
        typeOfAnimal.setPromptText("Enter type of animal");
        
        firstName.setPromptText("Enter your first name");
        lastName.setPromptText("Enter your last name");
        address.setPromptText("Enter your address");
        phoneNumber.setPromptText("Enter your phone number");
        
        //buttons for addCustomerScene
        //1. saveCustDetailsBtn
        Button saveCustDetailsBtn = new Button("Save");
        saveCustDetailsBtn.setOnAction(e -> {
        customers.add(new Customer(firstName.getText(),lastName.getText(),address.getText(),phoneNumber.getText()));
        stage.setScene(mainScene);
        });
        //2.addPetBtn
        Button addPetBtn = new Button("AddPet");
        addPetBtn.setOnAction(e -> {
        	
        stage.setScene(petScene);	
        });
        
        
        //buttons for petScene
        Button savePetBtn = new Button("Save");
        savePetBtn.setOnAction(e -> {
        	pets.add(new Pet(petName.getText(),typeOfAnimal.getText()));
        });
        
        //petTable columns
        //Pet name column 
        TableColumn<Pet, String> petNameCol = new TableColumn<>("PetName");
        petNameCol.setMinWidth(90);
        petNameCol.setCellValueFactory(new PropertyValueFactory<>("petName"));
        
        //Type of animal column
        TableColumn<Pet, String> typeOfAnimalCol = new TableColumn<>("TypeOfAnimal");
        typeOfAnimalCol.setMinWidth(90);
        typeOfAnimalCol.setCellValueFactory(new PropertyValueFactory<>("typeOfAnimal"));
        
        
        //add pet details and columns to the petTable
        petTable = new TableView<>();
        petTable.setItems(getPet());
        petTable.getColumns().addAll(petNameCol,typeOfAnimalCol);
        
        

        
        //customerTable columns
        //First name column 
        TableColumn<Customer, String> firstNameCol = new TableColumn<>("FirstName");
        firstNameCol.setMinWidth(90);
        firstNameCol.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        
        //Last name column
        TableColumn<Customer, String> lastNameCol = new TableColumn<>("LastName");
        lastNameCol.setMinWidth(90);
        lastNameCol.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        
        //Address column
        TableColumn<Customer, String> addressCol = new TableColumn<>("Address");
        addressCol.setMinWidth(90);
        addressCol.setCellValueFactory(new PropertyValueFactory<>("address"));
        
        //Phone number column of customerTable
        TableColumn<Customer, String> phoneCol = new TableColumn<>("PhoneNumber");
        phoneCol.setMinWidth(50);
        phoneCol.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        
        //add customer details and columns to the customerTable
        customerTable = new TableView<>();
        customerTable.setItems(getCustomer());
        customerTable.getColumns().addAll(firstNameCol,lastNameCol,addressCol,phoneCol);
        
        
        //layouts for the three scenes
        //1. mainScene Layout
        VBox mainLayout = new VBox();
        mainLayout.setSpacing(5);
        mainLayout.setPadding(new Insets(10, 0, 0, 10));
        mainLayout.getChildren().addAll(mainLabel,customerTable,addCustomerBtn, deleteCustomerBtn);
        mainScene = new Scene(mainLayout,500, 600);
        
        //2.addCustomerScene Layout
        VBox customerLayout = new VBox();
        customerLayout.setSpacing(5);
        customerLayout.setPadding(new Insets(10, 0, 0, 10));
        customerLayout.getChildren().addAll(customerLabel, firstName,lastName,address,phoneNumber,saveCustDetailsBtn,addPetBtn);
        addCustomerScene = new Scene(customerLayout,400, 400);
        
        //3.petScene Layout
        VBox petLayout = new VBox();
        petLayout.setSpacing(5);
        petLayout.setPadding(new Insets(10, 0, 0, 10));
        petLayout.getChildren().addAll(petLabel,petTable, petName, typeOfAnimal,savePetBtn);
        petScene  = new Scene(petLayout,400, 400);
        
        
        stage.setScene(mainScene);
        stage.show();
	}
	
	
	
	public ObservableList<Customer> getCustomer(){
     	customers.add(new Customer("John", "Smith", "Cork", "1234567"));
     	return customers;
	 }
	
	public ObservableList<Pet> getPet(){
     	pets.add(new Pet("Bert", "Bee"));
     	return pets;
	}
	 
   
}
	 
