package l0080_controlstatements

import org.junit.Test


class Lession {

	@Test
	void test01_SwitchStatements() {
		// Using a switch statement, create a construct that accepts input (could be string or number) and returns
		// the following:
		// - If it's an integer between 1-100, divide it by two
		// - If it's a string that ends with 'ee', replace its end with 'ey'
		// - Otherwise return the input

		def magicClosure = { input ->
			// ------------ START EDITING HERE ----------------------
			def result
			switch (input) {
				case 1..100:
					result = input / 2
					break
				case ~/.*ee/:
					result = "${input[0..input.size() - 3]}ey"
					break
				default:
					result = input
			}
			result
			// ------------ STOP EDITING HERE  ----------------------
		}
		[5: 2.5, 'smile': 'smile', 'smilee': 'smiley', 'heehee': 'heehey'].each { key, expectedValue ->
			assert magicClosure(key) == expectedValue
		}

	}
	@Test
	void test02_IsCaseInSwitch() {
		// What the switch-case clause basically does in the following:

		// switch (test) {
		//   case candidate: break;
		// }
		//
		// candidate.isCase(test)

		// This means that if we implement our own isCase(), we can take advantage of it in switch statements.
		// For this exercise we have a Cartoon object that has one single feeling.
		// Let's implement a isCase() in Feeling so we can use switch-case on a Cartoon.

		def cartoon = new Cartoon(name: 'Mickey Mouse', feeling: Feeling.Guilty)

		switch (cartoon) {
			case Feeling.Guilty:
				// process guilty feeling cartoon
				break
			default:
				fail()
		}

		// Suppose people may have more than one Feeling. Implement the appropriate isCase to allow switching on them
		def person = new Person(name: 'Jack Bauer', feelings: [Feeling.Suicidal, Feeling.Relaxed])

		switch (person) {
			case Feeling.Anticipation:
				break
			case [Feeling.Happy, Feeling.Sad]:
				// Note how we can also use Lists here. In this case the Feeling.isCase() is triggered on all items
				break
			case Feeling.Suicidal:
				// process suicidal person
				break
			default:
				fail()
		}

	}

	@Test
	void test03_MultiAssignment() {
		// Sometimes you want to return more than one variable from a method. Yes, you could do it with an enclosing
		// class, but it could be an overkill. Groovy calls it Multiple Assignments.  You can use [var1 , var2] to
		// return multiple assignments
		
		// See http://www.groovy-lang.org/semantics.html

		// Create a closure that returns two random integers in a given range
		def generateTwoRandomInts = { int maxInt ->
			// ------------ START EDITING HERE ----------------------
			// ------------ STOP EDITING HERE  ----------------------
		}

		def (intA, intB) = generateTwoRandomInts(10)
		assert intA in 0..10
		assert intB in 0..10
	}

}
