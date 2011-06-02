public class Oracle {

  private enum Restaurant {
    McDonalds, A2ChinaRestaurant, JKUMensa, KHGMensa
  }

  public static void main(String[] args) {

    int result = (int) ((Math.random() * 10) % Restaurant.values().length);

    for (Restaurant restaurant : Restaurant.values()) {
      if (restaurant.ordinal() == result)
        System.out.println("Today's best choice is: " + restaurant.name());
    }

  }

}
