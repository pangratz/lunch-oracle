import java.util.Random;

public class Oracle {

	private enum Restaurant {
		McDonalds, A2ChinaRestaurant, JKUMensa, KHGMensa
	}

	public static void main(String[] args) {

		Random r = new Random();
		Restaurant[] restaurantos = Restaurant.values();

		Restaurant chosenEatingThing = restaurantos[r.nextInt(restaurantos.length)];

		System.out.println("Today's best choice is: " + chosenEatingThing.name());

	}
}
