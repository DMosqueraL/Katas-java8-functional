package katas;

import com.codepoetics.protonpack.StreamUtils;
import model.Bookmark;
import model.Movie;
import util.DataUtil;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
    Goal: Combine videos and bookmarks by index (StreamUtils.zip) (https://github.com/poetix/protonpack)
    DataSource: DataUtil.getMovies()
    Output: List of ImmutableMap.of("videoId", "5", "bookmarkId", "3")
*/
public class Kata8 {
    public static List<Map> execute() {
        List<Movie> movies = DataUtil.getMovies();
        List<Bookmark> bookMarks = DataUtil.getBookMarks();

        var peliculas = movies.stream()
                .map(e -> e.getId());

        var books = bookMarks.stream()
                .map(e -> e.getId());

        return StreamUtils.zip(peliculas, books, (peli, book) -> Map.of("videoId", peli, "bookmarkId", book))
                .collect(Collectors.toList());

//        return ImmutableList.of(ImmutableMap.of("videoId", 5, "bookmarkId", 3));
    }
}
