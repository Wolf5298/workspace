import static org.junit.Assert.*;
import org.junit.Test;

/**
 * The test class for the CandleImpl class implementation of the interface
 * Candle.
 * 
 * @author Chris
 *
 */
public class CandleImplTest {

	// values in candles
	private static final double OPEN = 10.8;
	private static final double HIGH = 11.5;
	private static final double LOW = 8.7;
	private static final double LATEST = 11.3;

	// Fields of Type CandleImpl
	private CandleImpl _candle1;
	private CandleImpl _candle2;

	// initializes the Fields to be tested.
	public CandleImplTest() {
		prepareTestCandles();
	}

	@Test
	public void testConstructorOne() {
		try {
			assertFalse(_candle1.isClosed());
		} catch (AssertionError e) {
			fail();
		}

		try {
			assertEquals(OPEN, _candle1.getOpen(), 0);
			assertEquals(OPEN, _candle1.getHigh(), 0);
			assertEquals(OPEN, _candle1.getLow(), 0);
			assertEquals(OPEN, _candle1.getLatest(), 0);
		} catch (AssertionError e) {
			fail();
		}
	}

	@Test
	public void testConstructorTwo() {
		try {
			assertEquals(OPEN, _candle2.getOpen(), 0);
			assertEquals(HIGH, _candle2.getHigh(), 0);
			assertEquals(LOW, _candle2.getLow(), 0);
			assertEquals(LATEST, _candle2.getLatest(), 0);
		} catch (AssertionError e) {
			fail();
		}

		try {
			assertFalse(_candle1.isClosed());
		} catch (AssertionError e) {
			fail();
		}

		try {
			@SuppressWarnings("unused")
			Candle errortest = new CandleImpl(OPEN, LATEST, LOW, HIGH);
			fail();
		} catch (AssertionError ignored) {
		}
		
		try {
			@SuppressWarnings("unused")
			Candle errortest = new CandleImpl(OPEN, HIGH, LATEST, LOW);
			fail();
		} catch (AssertionError ignored) {
		}
	}

	@Test
	public void testClose() {

		_candle1.close();
		try {
			assertTrue(_candle1.isClosed());
		} catch (AssertionError e) {
			fail();
		}

		try {
			_candle1.close();
			fail();
		} catch (AssertionError ingnored) {

		}
	}

	@Test
	public void testRefresh() {

		_candle1.refresh(HIGH);
		try {
			assertEquals(HIGH, _candle1.getLatest(), 0);
			assertEquals(HIGH, _candle1.getHigh(), 0);
		} catch (AssertionError e) {
			fail();
		}

		_candle1.refresh(LOW);
		try {
			assertEquals(LOW, _candle1.getLatest(), 0);
			assertEquals(LOW, _candle1.getLow(), 0);
		} catch (AssertionError e) {
			fail();
		}

		_candle1.refresh(LATEST);
		try {
			assertEquals(LATEST, _candle1.getLatest(), 0);
			assertEquals(HIGH, _candle1.getHigh(), 0);
			assertEquals(LOW, _candle1.getLow(), 0);
		} catch (AssertionError e) {
			fail();
		}

		_candle1.close();
		try {
			_candle1.refresh(HIGH);
			fail();
		} catch (AssertionError ignored) {

		}
	}

	@Test
	public void testIsBullish() {
		_candle1.refresh(HIGH);
		try {
			assertTrue(_candle1.isBullish());
		} catch (AssertionError e) {
			fail();
		}

		_candle1.refresh(LOW);
		try {
			assertFalse(_candle1.isBullish());
		} catch (AssertionError e) {
			fail();
		}
	}

	private void prepareTestCandles() {
		_candle1 = new CandleImpl(OPEN);
		_candle2 = new CandleImpl(OPEN, HIGH, LOW, LATEST);
	}
}
