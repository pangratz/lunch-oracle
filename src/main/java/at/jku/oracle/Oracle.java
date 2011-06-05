package at.jku.oracle;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.GnuParser;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.OptionBuilder;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public class Oracle {

	public static enum Restaurant {
		McDonalds, A2ChinaRestaurant, JKUMensa, KHGMensa
	}

	public static void main(String[] args) {

		Oracle oracle = new Oracle();
		String choice = oracle.ask(args);

		System.out.println("Today's best choice is: " + choice);

	}

	private final Options options;
	private final Random r;
	private final String[] defaultRestaurants;

	public Oracle() {
		super();

		r = new Random();

		Restaurant[] values = Restaurant.values();
		List<String> restaurantNames = new ArrayList<String>(values.length);
		for (Restaurant restaurant : values) {
			restaurantNames.add(restaurant.name());
		}
		defaultRestaurants = restaurantNames.toArray(new String[values.length]);

		Option nogsOpt = OptionBuilder.create("nogs");
		Option ownRestaurantsOpt = OptionBuilder.withDescription("alternative restaurants").hasOptionalArgs()
				.create("a");

		options = new Options();
		options.addOption(ownRestaurantsOpt);
		options.addOption(nogsOpt);
	}

	public String ask(String... args) {
		// create the parser
		CommandLineParser parser = new GnuParser();
		try {
			// parse the command line arguments
			CommandLine line = parser.parse(options, args);

			if (line.hasOption("nogs")) {
				return Restaurant.A2ChinaRestaurant.name();
			} else if (line.hasOption("a")) {
				String[] restaurants = line.getOptionValues("a");
				return selectRandom(restaurants);
			} else {
				return selectRandom(defaultRestaurants);
			}

		} catch (ParseException exp) {
			throw new IllegalStateException("Parsing failed.  Reason: " + exp.getMessage(), exp);
		}
	}

	private String selectRandom(String[] args) {
		return args[r.nextInt(args.length)];
	}
}
