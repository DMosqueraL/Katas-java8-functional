package katas;

import model.Movie;
import util.DataUtil;

import java.util.List;

/*
    Goal: Retrieve the url of the largest boxart using map() and reduce()
    DataSource: DataUtil.getMovieLists()
    Output: String
*/
public class Kata6 {
    public static String execute() {
        List<Movie> movies = DataUtil.getMovies();

        var url = movies.stream()
                .map(e -> e.getBoxarts())
                .flatMap(el -> el.stream())
                .reduce((menor, mayor) -> mayor.getWidth() > menor.getWidth() ? mayor : menor)
                .map(el -> el.getUrl()).get();

        return url;
    }
}
