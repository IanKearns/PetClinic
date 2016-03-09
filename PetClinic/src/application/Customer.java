package application;


import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class Customer {

	private  SimpleStringProperty firstName;
	private  SimpleStringProperty lastName;
	private  SimpleStringProperty address;
	private SimpleStringProperty phoneNumber;
	ObservableList<Pet> pets =  FXCollections.observableArrayList();



	public ObservableList<Pet> getPets() {
		return pets;
	}

	public void setPets(ObservableList<Pet> pets) {
		this.pets = pets;
	}
	
	public Customer(){
		
	}

	public Customer (String fName, String lName, String address, String phone) {
		this.firstName = new SimpleStringProperty(fName);
		this.lastName = new SimpleStringProperty(lName);
		this.address = new SimpleStringProperty(address);
		this.phoneNumber = new SimpleStringProperty(phone);

	}

	public String getFirstName() {
		return firstName.get();
	}
	public void setFirstName(String fName) {
		firstName.set(fName);
	}

	public SimpleStringProperty firstNameProperty (){
		return firstName;
	}

	public String getLastName() {
		return lastName.get();
	}
	public void setLastName(String lName) {
		lastName.set(lName);
	}

	public SimpleStringProperty lastNameProperty (){
		return lastName;
	}

	public String getAddress() {
		return address.get();
	}
	public void setAddress (String add) {
		address.set (add);
	}

	public SimpleStringProperty addressProperty (){
		return address;
	}

	public String getPhoneNumber() {
		return phoneNumber.get();
	}
	public void setPhoneNumber (String phone) {
		phoneNumber.set (phone);
	}

	public SimpleStringProperty phoneNumberProperty (){
		return phoneNumber;

	}

}