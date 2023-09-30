package course.examples.UI.Project02;

import java.util.ArrayList;
import java.util.Arrays;

public class AnimalHelper {

    private static ArrayList<String> animalNames = new ArrayList(
		Arrays.asList("Lion", "Wolf", "Moose", "Zebra", "Wolverine", "Bear", "Beaver", "Penguin")
	);

    public static ArrayList<String> getAnimalNames(){
        return animalNames;
    }

    private static ArrayList<String> urls = new ArrayList(
            Arrays.asList("https://en.wikipedia.org/wiki/Lion",
                    "https://en.wikipedia.org/wiki/Wolf","https://en.wikipedia.org/wiki/Moose",
                    "https://en.wikipedia.org/wiki/Zebra", "https://en.wikipedia.org/wiki/Wolverine",
                    "https://en.wikipedia.org/wiki/Bear", "https://en.wikipedia.org/wiki/Beaver",
                    "https://en.wikipedia.org/wiki/Penguin")
    );

    public static ArrayList<String> getUrls(){
        return urls;
    }

    private static String lion =
            "Lifespan: 10 - 15 years\n" +
                    "Max Weight: 496 lbs\n" +
                    "Habitat: Grassy Plains, Savannas\n";

    private static String wolf =
            "Lifespan: 14 - 16 years\n" +
                    "Max Weight: 175 lbs\n" +
                    "Habitat: Forests, Grasslands, Mountains\n";

    private static String moose =
            "Lifespan: 15 - 25 years\n" +
                    "Max Weight: 1500 lbs\n" +
                    "Habitat: Forests\n";

    private static String zebra =
            "Lifespan: 25 years\n" +
                    "Max Weight: 992 lbs\n" +
                    "Habitat: Treeless Grasslands, Savanna Woodlands\n";

    private static String wolverine =
            "Lifespan: 5 - 13 years\n" +
                    "Max Weight: 40 lbs\n" +
                    "Habitat: Boreal Forests, Tundra, Western Mountains\n";

    private static String bear =
            "Lifespan: 20 - 30 years\n" +
                    "Max Weight: 900 lbs\n" +
                    "Habitat: Forests, Mountains, Tundra, Deserts, Grassy Areas\n";

    private static String beaver =
            "Lifespan: 10 - 12 years\n" +
                    "Max Weight: 65 lbs\n" +
                    "Habitat: Ponds, Lakes, Rivers, Streams\n";

    private static String penguin =
            "Lifespan: 15 - 20 years\n" +
                    "Max Weight: 99 lbs\n" +
                    "Habitat: Oceans, Coasts\n";

    private static ArrayList<String> info = new ArrayList<>(
            Arrays.asList(lion, wolf, moose, zebra, wolverine, bear, beaver, penguin)
    );

    public static ArrayList<String> getInfo(){
        return info;
    }

}
