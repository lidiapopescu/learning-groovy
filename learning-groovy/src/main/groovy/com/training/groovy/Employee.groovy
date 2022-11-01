package com.training.groovy

import groovy.transform.Canonical
import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString
import groovy.transform.TupleConstructor

// Declare convenience annotations on class-level
// originally all relevant boilerplate code has been added to support functionality
//@ToString
//@EqualsAndHashCode
//@TupleConstructor
// Canonical annotation aggregates functionality of all above annotations used previously
@Canonical
class Employee {
	
	String firstName
	String lastName
	int age

//	Employee() {
//	}
//
//	Employee(String firstName, String lastName, int age) {
//		this.firstName = firstName
//		this.lastName = lastName
//		this.age = age
//	}
	
//	@Override
//	boolean equals(o) {
//		if (this.is(o)) {
//			return true
//		}
//		if (!(o instanceof Employee)) {
//			return false
//		}
//
//		Employee person = (Employee) o
//
//		if (age != person.age) {
//			return false
//		}
//		if (firstName != person.firstName) {
//			return false
//		}
//		if (lastName != person.lastName) {
//			return false
//		}
//
//		return true
//	}

//	@Override
//	int hashCode() {
//		int result
//		result = (firstName != null ? firstName.hashCode() : 0)
//		result = 31 * result + (lastName != null ? lastName.hashCode() : 0)
//		result = 31 * result + age
//		return result
//	}

//	@Override
//	String toString() {
//		return this.getClass().getCanonicalName() + "(" +
//				firstName + ", " +
//				lastName + ", " +
//				age +
//				")"
//	}
}
