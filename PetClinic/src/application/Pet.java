package application;

import javafx.beans.property.SimpleStringProperty;

public class Pet {
	private  SimpleStringProperty petName;
	private SimpleStringProperty typeOfAnimal;
	
    
	public Pet (){
		
	}
	
	public Pet(String petName, String typeOfAnimal ){
		this.petName = new SimpleStringProperty(petName);
		this.typeOfAnimal = new SimpleStringProperty(typeOfAnimal);
	}
	
	
	public String getPetName() {
        return petName.get();
    }
    public void setPetName(String pName) {
        petName.set(pName);
    }
    
    public SimpleStringProperty petNameProperty (){
		return petName;
	}
    
    
    
	public SimpleStringProperty getTypeOfAnimal() {
		return typeOfAnimal;
	}
	public void setTypeOfAnimal(SimpleStringProperty typeOfAnimal) {
		this.typeOfAnimal = typeOfAnimal;
	}
	 public SimpleStringProperty typeOfAnimalProperty (){
			return typeOfAnimal;
		}
}
