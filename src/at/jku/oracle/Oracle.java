package at.jku.oracle;

import java.util.Random;

public class Oracle {

  private enum Restaurant {
    McDonalds, A2ChinaRestaurant, JKUMensa, KHGMensa
  }

  public static void main(String[] args) {

    Random r = new Random();
    String choice;

    if (args.length > 0) {
      choice = args[r.nextInt(args.length)];
    } else {
      Restaurant[] choices = Restaurant.values();
      choice = choices[r.nextInt(choices.length)].name();
    }

    System.out.println("Today's best choice is: " + choice);

  }
}
