/**
 * Class that implements the Interface Candle.
 * @author Chris
 *
 */
public class CandleImpl implements Candle {

	// Fields
	private double _open;
	private double _high;
	private double _low;
	private double _latest;

	private boolean _closed;

	/**
	 * Constructor that sets all Fields initially to the open value.
	 * 
	 * @param open
	 *            the opening value of the candle
	 */
	public CandleImpl(double open) {
		_open = open;
		_high = open;
		_low = open;
		_latest = open;

		_closed = false;
	}

	/**
	 * Constructor that initializes a that already had a high/low value but is
	 * not closed yet.
	 * 
	 * @param open
	 *            the opening value
	 * @param high
	 *            the highest value so far
	 * @param low
	 *            the lowest value so far
	 * @param latest
	 * @require high = max(open, high, low, latest)
	 * @require low = min(open, high, low, latest)
	 */
	public CandleImpl(double open, double high, double low, double latest) throws AssertionError {
		// check preconditions
		assert high == max(open, high, low, latest) : "precondition high = max(open, high, low, latest) neglected";
		assert low == min(open, high, low, latest) : "precondition low = min(open, high, low, latest) neglected";

		_open = open;
		_high = high;
		_low = low;
		_latest = latest;

		_closed = false;
	}

	private double min(double open, double high, double low, double latest) {
		return Math.min(low, Math.min(high, Math.min(open, latest)));
	}

	/**
	 * compares the four parameters to find the maximum value.
	 * 
	 * @param open
	 * @param high
	 * @param low
	 * @param latest
	 * @return the maximum value of the four parameters
	 */
	private double max(double open, double high, double low, double latest) {
		return Math.max(high, Math.max(low, Math.max(open, latest)));
	}

	@Override
	public double getOpen() {
		return _open;
	}

	@Override
	public double getHigh() {
		return _high;
	}

	@Override
	public double getLow() {
		return _low;
	}

	@Override
	public boolean isBullish() {
		return (_open < _latest);
	}

	@Override
	public void refresh(double value) {
		_latest = value;

		if (_high < value) {
			_high = value;
		} else if (_low > value) {
			_low = value;
		}
	}

	@Override
	public boolean isClosed() {
		return _closed;
	}

	@Override
	public void close() throws AssertionError {
		assert this.isClosed() == false : "Precondition this.isClosed == false is neglected";

		_closed = true;
	}

	@Override
	public double getLatest() {
		return _latest;
	}

}
