package com.training.groovy

class ProcessingNumbersDemo {
	
	void challangeMyVersion() {
		// Read numbers from files balances.txt and years.txt and store then in List
		// read content line by line		
		List myList = new ArrayList()
		File file = new File("resources/challange/balances.txt")
		file.eachLine { String line ->
			myList.add(line) 
		}
		file = new File("resources/challange/years.txt")
		file.eachLine { String line ->
			myList.add(line)
		}
		println myList
				
		// Capture all numbers in a list, Omit other entries
		List<Integer> newList = myList.collect() { 
			try {
				it as Integer
			} catch (Exception e) {}
		} - null
		println newList
		
		// Find the highest number
		println newList.max()
		
		// Create the sum of all numbers.
		// Add all numbers in List and print sum.
		println newList.sum()
	}
	
	void challangeSolutionVersion() {
		// Read numbers from files and store then in List
		List<Integer> allNumbers =  readAllNumbers()
		println allNumbers
		
		// Find the highest number
		Integer maxNumber = allNumbers.max()
		assert maxNumber == 2044
		println allNumbers.max()
		
		// Create the sum of all numbers.
		Integer sum = allNumbers.sum()
		println sum
	}
	
	private static List<Integer> readAllNumbers() {
		File resourceDir = new File("resources/challange")
		List<Integer> allNumbers = []
		
		resourceDir.eachFile { file -> 
			file.eachLine { line ->
				if (line.isNumber()) {
					allNumbers << line.toInteger()
				}
			}
		}
		return allNumbers
	}
}
