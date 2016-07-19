
//TODO: Implementation

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * This class tests the functionality of the KeyValuePair Class.
 * 
 * @author Chris
 *
 */
public class KeyValuePairTest {

	// fields to initialize the Object of instance KeyValuePair
	private static final Object KEY = new Object();
	private static final Object VALUE = new Object();

	// The field with the declaration of the KeyValuePair Object
	private KeyValuePair _pair;

	public KeyValuePairTest() {
	}

	private void initializePair() {
		_pair = new KeyValuePair(KEY, VALUE);
	}

	@Test
	public void testConstructor() {
		// tests that both key and value mustn't be null
		try {
			_pair = new KeyValuePair(null, VALUE);
			fail();
		} catch (AssertionError ignored) {
		}
		try {
			_pair = new KeyValuePair(KEY, null);
			fail();
		} catch (AssertionError ignored) {
		}
		try {
			_pair = new KeyValuePair(null, null);
			fail();
		} catch (AssertionError ignored) {
		}

		// tests that key and value are assigned correctly.
		this.initializePair();
		try {
			assertEquals(KEY, _pair.getKey());
			assertEquals(VALUE, _pair.getValue());
		} catch (AssertionError e) {
			fail();
		}
	}
}
