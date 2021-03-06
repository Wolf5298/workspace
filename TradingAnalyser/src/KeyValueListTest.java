import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.Test;

//TODO : inventing testcases and implementation

/**
 * class that tests the KeyValueList used within the trading analyser.
 * 
 * @author Chris
 *
 */
class KeyValueListTest {
	// first Key Value Pair for the List to be tested.
	private static final Object KEY1 = new Object();
	private static final Object VALUE1 = new Object();

	// second Key Value Pair for the List to be tested.
	private static final Object KEY2 = new Object();
	private static final Object VALUE2 = new Object();

	// field for the tested List.
	private KeyValueList<Object, Object> _list1;

	KeyValueListTest() {
		initializeLists();
	}

	private void initializeLists() {
		_list1 = new KeyValueList<Object, Object>();
	}

}
