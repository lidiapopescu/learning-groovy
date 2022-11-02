package com.training.groovy

import org.codehaus.groovy.control.InstanceOfVerifier

class CollectionsDemo {
	
	void collectionsDemo() {
		Employee lidiaPopescu = new Employee("Lidia", "Popescu" , 30);
		Employee valentinaGutu = new Employee("Valentina", "Gutu", 70);
		Employee gabrielPopescu = new Employee("Gabriel", "Popescu", 40);
		
		// Create a new list of persons
		def allEmployees = [lidiaPopescu , valentinaGutu, gabrielPopescu]
		
		// Querying Collections
		assert allEmployees instanceof List
		assert allEmployees.size() == 3
		assert allEmployees[2] == gabrielPopescu
		
		// Iterate over elements
		/** If no parameter has been defined for the closure they can simply reference 
		 * the iteration element with this 'it' keyword for convenient reasons. 
		 * Of cause, you can always change it to a name parameter if you want to be more expressive. 
		 * */
		allEmployees.each {
			println it
		}
		
		// Iterate over elements and using an index
		/** Next method eachWithIndex, comes with the benefit of the each method,
		 * but also injects an index parameter to reference the position of an element in the collection
		 * */
		allEmployees.eachWithIndex { Employee e, int i ->
			println i + ": " + e
		}
		
		// Filtering a specific element
		/** The find method queries for a particular element based on a specific criteria defined as a closure body
		 * */
		println allEmployees.find { it.lastName == "Popescu" }                   // prints 1st finding
		println allEmployees.find { it.lastName == "Popescu" } == lidiaPopescu   // true
		println allEmployees.find { it.lastName == "Popescu" } == gabrielPopescu // false
		
		// Transforming elements into something else
		/** The collect method can transform each element in a collection and turn it into something else as needed.
		 * */
		println allEmployees.collect() { it.age <= 30 }
		allEmployees.collect() { it.age <= 30 } == [true, false, false]
		
		// Sorting elements based on a criterion
		println allEmployees.sort { it.age }
		println allEmployees.sort { it.age } == [ lidiaPopescu, gabrielPopescu, valentinaGutu ]
	}
}
