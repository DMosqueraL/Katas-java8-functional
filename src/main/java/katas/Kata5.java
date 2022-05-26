package katas;

import model.Movie;
import util.DataUtil;

import java.util.List;

/*
    Goal: Retrieve the largest rating using reduce()
    DataSource: DataUtil.getMovies()
    Output: Double
*/
public class Kata5 {
    public static Double execute() {
        List<Movie> movies = DataUtil.getMovies();

        var rating = movies.stream()
                .mapToDouble(e -> e.getRating().doubleValue())
                .reduce((a, b) -> Double.max(0.0, 5.0)).getAsDouble();

        return rating;
    }
}
