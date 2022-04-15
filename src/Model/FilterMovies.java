package Model;

import java.util.ArrayList;
import java.util.Locale;

public class FilterMovies {

    /**
     * Will remove movies from the array list that don't have one of the specified genres
     * @param movies
     * @param genres
     */
    public static void filterByGenre(ArrayList<Movie> movies, ArrayList<String> genres) {
        // Uses a lambda to test if the movies have one of the genres
        movies.removeIf(
                (movie) -> {
                    boolean remove = false;
                    for (String genre : genres) {
                        remove = !movie.getgenre().contains(genre);
                    }
                    return remove;
                });
    }

    /**
     * Will remove movies from the array list that don't have one of the specified languages
     * @param movies
     * @param languages
     */
    public static void filterByLanguage(ArrayList<Movie> movies, ArrayList<String> languages) {
        movies.removeIf(
                (movie) -> {
                    boolean remove = false;
                    for (String language : languages) {
                        remove = !movie.getlanguage().contains(language);
                    }
                    return remove;
                });
    }

    /**
     * Will remove movies from the array list that weren't released in of the specified countries
     * @param movies
     * @param countries
     */
    public static void filterByCountry(ArrayList<Movie> movies, ArrayList<String> countries) {
        movies.removeIf(
                (movie) -> {
                    boolean remove = false;
                    for (String country : countries) {
                        remove = !movie.getcountry().contains(country);
                    }
                    return remove;
                });
    }

    /**
     * Will remove movies that don't have the character sequence given in the title
     * @param movies
     * @param title
     */
    public static void filterByTitle(ArrayList<Movie> movies, String title) {
        movies.removeIf((movie) -> !movie.gettitle().toLowerCase().contains(title.toLowerCase()));
    }

    /**
     * Will remove movies from the array list that weren't released that year
     * @param movies
     * @param year
     */
    public static void filterByYear(ArrayList<Movie> movies, int year) {
        movies.removeIf(
                (movie) -> {
                    return movie.getyear() != year;
                });
    }

    /**
     * Filters by specific age rating eg. PG, PG-13, R
     * @param movies
     * @param ageRating
     */
    public static void filterByAgeRating(ArrayList<Movie> movies, String ageRating) {
        movies.removeIf(
                (movie) -> {
                    return movie.getagerating() != ageRating;
                });
    }
}