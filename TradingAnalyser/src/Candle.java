/**
 * This Interface specifies a Candle for usage in candle-stick-diagramms.
 * 
 * A Candles State consists of a opening Value, a highest Value, a lowest Value
 * and a latest value. Once "closed" a Candles state can never be changed again.
 * 
 * A Candle can never be initalized without a opening value, which also is the
 * high, low and latest value after initialization. A default Candle()
 * constructor is deprecated.
 * 
 * @author Chris
 *
 */
public interface Candle {

	/**
	 * returns the opening value of the specific Candle
	 * 
	 * @return the opening value
	 * @ensure this.getOpen() == openingValue
	 */
	public double getOpen();

	/**
	 * returns the highest saved value during the representated time interval.
	 * 
	 * @return the highest value
	 * @ensure this.getHigh() == highestValue
	 */
	public double getHigh();

	/**
	 * returns the lowest saved value during the representated time interval
	 * 
	 * @return the lowest value
	 * @ensure this.getLow() == lowestValue
	 */
	public double getLow();

	/**
	 * returns the latest value of this Candle.
	 * 
	 * @return the latest value
	 * @ensure this.getLatest() == latestValue
	 */
	public double getLatest();

	/**
	 * returns true if and only if the closing value is higher than the opening
	 * value of the represented time interval
	 * 
	 * @return a boolean if the candle is bullish or not
	 * @ensure if(this.getOpen > this.getClose()) {this.isBullish() == true}
	 */
	public boolean isBullish();

	/**
	 * refreshes high, low and close value, if the represented time Interval
	 * since the opening has not yet been achieved.
	 * 
	 * @param value
	 *            the current value to refresh the candles state
	 * @require this.isClosed() == false;
	 * @ensure this.getClose() == value;
	 */
	public void refresh(double value);

	/**
	 * Sets the Candles state to closed. Once closed a Candle can never be
	 * opened again.
	 * 
	 * @require this.isClosed() == false;
	 * @ensure this.isClosed() == true;
	 */
	public void close() throws AssertionError;

	/**
	 * checks if the candle is closed and if so returns true.
	 * 
	 * @return true if the candle is closed.
	 */
	public boolean isClosed();
}
