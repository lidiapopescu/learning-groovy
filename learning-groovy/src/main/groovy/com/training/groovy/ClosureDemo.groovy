package com.training.groovy


class ClosureDemo {
	
	public closureDemo() {
		Employee person = new Employee();
		person.setFirstName("Lidia")
		person.setLastName("Popescu")
		person.setAge(30)
		
		// Create Closure that prints String representation of a person
		/** Just wrap in curly braces
		 The login within the curly braces does not get executed automatically,
		 you will actively have to invoke it somewhere else in the program
		 in preparation of invoking assign to a variable Closure
		 */
		Closure personToString = { println person.toString() }
		/** Method named 'call' */
		personToString()
		
		// Closures can define parameters similar to methods
		/** Will enhance our closure by defining a Person instance as a parameter
		 Groovy requires to separate the parameters list from the Closure body with the arrow sign. */
		Closure personToStringWithParam = { Employee employee -> println employee.toString() }
		personToStringWithParam(person)
		/** Closures always return a value upon execution.
		 The return value is derived from the last statement of the Closure body.
		 The print line doesn't really return anything, therefore, the return value is null. */
		
		// Pass Closure to a method and execute it
		/** You can pass a Closure to a method as a parameter */
		handlePerson(personToStringWithParam, person)
		
		// Create Closure that prints full name of a person
		Closure personFullName =  { Employee employee ->
			println employee.getFirstName() + " " + employee.getLastName() + " has "+ employee.getAge() + " years old."
		}
		handlePerson(personFullName, person)
	}
	
	void handlePerson(Closure c, Employee p) {
		if ( p == null) {
			throw new RuntimeException("A person instance cannot be null!");
		}
		c(p)
	}
}
