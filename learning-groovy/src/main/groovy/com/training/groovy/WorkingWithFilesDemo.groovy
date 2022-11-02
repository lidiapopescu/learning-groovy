package com.training.groovy

class WorkingWithFilesDemo {
	
	void readingFiles() {
		
		Employee employee = new Employee()
		
		// Read full content of file
		File file = new File("resources/tommi-vihavainen.txt")
//		file = new File("resources/mary-hill.txt")
		println file.getText('UTF-8')
		
		// Iterate over each line of file
		/** The method eachLine for processing file line by line
		 * The method takes a closure as a parameter and
		 * the closure body deferments how each line should be handled by the application code
		 * */
		file.eachLine { String line, Integer no ->
			if (no == 1) {
				employee.setFirstName(line)
			} else if ( no == 2) {
				employee.setLastName(line)
			} else if ( no == 3) {
				employee.setAge(line.toInteger())
			} else {
				throw new RuntimeException("A person text file should only have 3 lines")
			}
		}
		
		println employee
	}
	
	void writingFiles() {
		
		// Create a file and populate contents
		/** The method withWriter will automatically remove content if file exists already.
		 * - The method writer.writeline also adds a new line character , so next appended characters will be in the new line
		 */
		File textFile = new File("resources/mary-hill.txt")
		textFile.withWriter('UTF-8') { writer ->
			writer.writeLine("Mary")
			writer.writeLine("Hill")
			writer.writeLine("35")			
		}
		
		// Appending contents to a file
		/** Option 1 */
		textFile.append("1")
		/** Option 2 
		 * The left shift operator internally calls the append method, but it does not actually add a new line */
		textFile << "2"
		
		
		// Serializing an object to a file
		/** As a prerequisite, every object needs to implement the serializable interface 
		 * Use 'withObjectOutputStream' method to directly write an instance of a person */
		Employee thomasMarks = new Employee("Thomas", "Marks", 21)
		File binFile = new File ("resources/thomas-marks.bin")
		binFile.withObjectOutputStream { out -> 
			out.writeObject(thomasMarks)
		}
		
		// Reading a serialized object from a binary file
		Employee thomasMarksRead
		binFile.withObjectInputStream { inFile ->
			 thomasMarksRead = inFile.readObject()
			 println thomasMarksRead.getFirstName() + " " + thomasMarksRead.getLastName() + " " + thomasMarksRead.getAge()
		}
	}
}