package pl.itkurnik.pedalsapi.domain.common;

import java.util.Arrays;
import java.util.List;

public class PedalsConstants {
    public static List<String> MENU_ITEMS = Arrays.asList("Total sum", "Average");

    public static String HOURS_NAME = "Rents in hours";
    public static List<String> HOURS_TITLES = Arrays.asList("Total sum amount of rents in particular hours", "Average amount of rents in particular hours");

    public static String DAYS_NAME = "Rents in weekdays";
    public static List<String> DAYS_TITLES = Arrays.asList("Total sum amount of rents in particular days", "Average amount of rents in particular days");

    public static String YEARS_NAME = "Rents in seasons";
    public static List<String> YEARS_TITLES = Arrays.asList("Total sum amount of rents in particular seasons", "Average amount of rents in particular seasons");
}
