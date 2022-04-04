package Model;

import java.util.ArrayList;

public class FilterMovies {

    /**
     * Will remove movies from the array list that don't have one of the specified genres
     * @param movies
     * @param genres
     */
    public void filterByGenre(ArrayList<Movie> movies, ArrayList<String> genres) {
        // Uses a lambda to test if the movies have one of the genres
        movies.removeIf(
                (movie) -> {
                    boolean remove = false;
                    for (String genre : genres) {
                        remove = !movie.getGenre().contains(genre);
                    }
                    return remove;
                });
    }

    /**
     * Will remove movies from the array list that don't have one of the specified languages
     * @param movies
     * @param languages
     */
    public void filterByLanguage(ArrayList<Movie> movies, ArrayList<String> languages) {
        movies.removeIf(
                (movie) -> {
                    boolean remove = false;
                    for (String language : languages) {
                        remove = !movie.getLanguages().contains(language);
                    }
                    return remove;
                });
    }

    /**
     * Will remove movies from the array list that weren't released in of the specified countries
     * @param movies
     * @param countries
     */
    public void filterByCountry(ArrayList<Movie> movies, ArrayList<String> countries) {
        movies.removeIf(
                (movie) -> {
                    boolean remove = false;
                    for (String country : countries) {
                        remove = !movie.getCountries().contains(country);
                    }
                    return remove;
                });
    }

    /**
     * Will remove movies from the array list that weren't released that year
     * @param movies
     * @param year
     */
    public void filterByYear(ArrayList<Movie> movies, int year) {
        movies.removeIf(
                (movie) -> {
                   return movie.getYear() != year;
                });
    }

    /**
     * Filters by specific age rating eg. PG, PG-13, R
     * @param movies
     * @param ageRating
     */
    public void filterByAgeRating(ArrayList<Movie> movies, String ageRating) {
        movies.removeIf(
                (movie) -> {
                    return movie.getAgeRating() != ageRating;
                });
    }
}
