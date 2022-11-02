package com.training.groovy

class Main {
    
    static void main(String[] args) {
		println "Hello Groovy World !"
		
		variablesDataTypes()
		
		classInstatiationAndErrorHandling()
		
		usingCalculatorClassInstance()
		
		usingAnnotations()
		
		usingClosures()
		
		usingCollections()
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
	
	private static void classInstatiationAndErrorHandling() {
		
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
			println p.getFullName() + " has " + p.getAge() + " Years old."
//			println p.getFirstName().dropRight(2)
		}
		
		// Handling Exceptions
		// Catch unchecked exception and handle it by printing a message
		try {
			// Convert a String into a Long data type
			person.getFirstName().toLong()
			// Exception in thread "main" java.lang.NumberFormatException: For input string: "Lidia"
		} catch (NumberFormatException e) {
			assert e instanceof NumberFormatException
//			e.printStackTrace()
			println "Cannot convert a String into a Long"
		}
		
		// Use the dropRight method to remove 2 characters from the end
		println ""
//		Exception in thread "main" groovy.lang.MissingMethodException: No signature of method: java.lang.String.dropRight() is applicable for argument types: (LinkedHashMap) values: [[num:2]]
//		println person.getFirstName().dropRight(num: 2)
		println person.getFirstName()
		println person.getFirstName().dropRight(2)
		println person.getFirstName().takeRight(2)
	}
	
	private static void usingCalculatorClassInstance() {
		
		Calculator calculator = new Calculator();
		assert calculator.add(3, 4) == 7
		println calculator.add(3, 4)
		
		assert calculator.substract(5, 10) == -5
		println calculator.substract(5, 10)
		
		assert calculator.multiply(3, 4) == 12
		println calculator.multiply(3, 4)
		
		assert calculator.divide( 10, 3) == 3.3333333f
		println calculator.divide(10, 0)
	}
	
	private static void usingAnnotations() {
		
		Employee johnDoe = new Employee()
		johnDoe.setFirstName("John")
		johnDoe.setLastName("Doe")
		johnDoe.setAge(40)

		assert johnDoe.toString() == "com.training.groovy.Employee(John, Doe, 40)"
		println johnDoe.toString()
		assert johnDoe.equals(johnDoe)
		println "johnDoe.equals(johnDoe) = " + johnDoe.equals(johnDoe)
		assert !johnDoe.equals(new Employee(firstName: "Mary", lastName: "Hill", age: 30))
		println "!johnDoe.equals(new Employee(firstName: \"Mary\", lastName: \"Hill\", age: 30)) =  "+ !johnDoe.equals(new Employee(firstName: "Mary", lastName: "Hill", age: 30))
		assert new Employee("Mary", "Hill", 30).toString() == "com.training.groovy.Employee(Mary, Hill, 30)"
	}
	
	
	private static void usingClosures() {
		
		ClosureDemo cDemo = new ClosureDemo()
		cDemo.closureDemo()
	}
	
	private static void usingCollections() {
		
		CollectionsDemo cDemo = new CollectionsDemo()
		cDemo.collectionsDemo()
	}
}
