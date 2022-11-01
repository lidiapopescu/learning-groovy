package com.training.groovy

class Main {
    
    static void main(String[] args) {
        println "Hello World"
		
		variablesDataTypes()
		
		classInstatiationAndErrorHandling()
		
    }
	
	
	private static void variablesDataTypes() {
		// Define a typed variable
		int age = 40

		// Print variable value
		println age

		// Print variable type
		println age.getClass()

		// Define a variable with dynamic typing
		def name = "John"

		// Print variable value
		println name

		// Print variable type
		println name.getClass()
	}
	
	private static classInstatiationAndErrorHandling() {
		
		// Create new Person class and instantiate it
		// Getters and setters are automatically created
		Person person = new Person();
		person.setFirstName("Lidia")
		person.setLastName("Popescu")
		person.setAge(30)
		
		
		// Print the full name and age of the Person instance
		println person.getFullName()
		println person.getAge()
		
		// Identify if Person is middle-aged using a conditional
		if ( person.getAge() >= 45 && person.getAge() <= 65 ) {
			println person.getFullName() + " is middle-aged"
		} else {
			println person.getFullName() + " is " + person.getAge() + " years old."
		}
		
		// Define a list of Persons
		def persons = [person, new Person(firstName: "Cristiana", lastName: "Popescu", age: 6), new Person(firstName: "Valentina", lastName: "Gutu", age: 70)]
		
		// Iterate over Person instances in list
		for (Person p : persons) {
			println p.getFullName()
		}
		
		// Handling Exceptions
		// Catch unchecked exception and handle it by printing a message
		try {
			// Convert a String into a Long data type
			person.getFirstName().toLong()
			// Exception in thread "main" java.lang.NumberFormatException: For input string: "Lidia"
		} catch (NumberFormatException e) {
			assert e instanceof NumberFormatException
			e.printStackTrace()
			println "Cannot convert a String into a Long"
		}
	}
}
