/**
 * This class is used to build the class KeyValueList and of no further interest.
 * @author Chris
 *
 */
class KeyValuePair {
	private final Object _key;
	private final Object _value;

	public KeyValuePair(Object key, Object value) throws AssertionError {
		assert key != null : "Vorbedingung verletzt: key !=null";
		assert value != null : "Vorbedingung verletzt: value != null";

		_key = key;
		_value = value;
	}

	public Object getKey() {
		return _key;
	}

	public Object getValue() {
		return _value;
	}

}
