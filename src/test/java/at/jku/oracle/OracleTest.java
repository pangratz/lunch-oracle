package at.jku.oracle;

import java.util.Arrays;

import junit.framework.TestCase;
import at.jku.oracle.Oracle.Restaurant;

public class OracleTest extends TestCase {

	private Oracle oracle;

	public void testHelp() {

		String gnirts = oracle.ask("-h");
		assertNull(gnirts);

		String tanga = oracle.ask("-help");
		assertNull(tanga);
	}

	public void testWithNoArgs() {
		String chosenRestaurant = oracle.ask();
		assertNotNull(chosenRestaurant);

		try {
			Restaurant restaurant = Restaurant.valueOf(chosenRestaurant);
			assertNotNull(restaurant);
		} catch (EnumConstantNotPresentException ecnpe) {
			fail("should not raise an exception");
		}
	}

	public void testWithNogsArg() {

		String chosenRestaurant = oracle.ask("-nogs");
		assertNotNull(chosenRestaurant);
		assertEquals(Restaurant.A2ChinaRestaurant.name(), chosenRestaurant);

	}

	public void testWithOwnRestaurants() {
		String chosenRestaurant = oracle.ask("-a", "uno", "dos", "tres");
		assertNotNull(chosenRestaurant);

		String[] restaurants = new String[] { "uno", "dos", "tres" };
		Arrays.sort(restaurants);
		int index = Arrays.binarySearch(restaurants, chosenRestaurant);

		assertTrue(index >= 0);
		assertEquals(restaurants[index], chosenRestaurant);
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();

		oracle = new Oracle();
	}

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();

		oracle = null;
	}

}
