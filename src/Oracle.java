public class Oracle {

	private enum Restaurant {
		McDonalds, A2ChinaRestaurant, JKUMensa, KHGMensa
	}

	public static void main(String[] args) {

		Restaurant chosenEatingThing = Restaurant.A2ChinaRestaurant;

		System.out.println("Today's best choice is: " + chosenEatingThing.name());

	}
}
