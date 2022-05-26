package katas;

import model.MovieList;
import util.DataUtil;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
    Goal: Retrieve each video's id, title, middle interesting moment time, and smallest box art url
    DataSource: DataUtil.getMovies()
    Output: List of ImmutableMap.of("id", 5, "title", "some title", "time", new Date(), "url", "someUrl")
*/
public class Kata9 {
    public static List<Map> execute() {
        List<MovieList> movieLists = DataUtil.getMovieLists();

        return movieLists.stream()
                .flatMap(e -> e.getVideos().stream())
                .map(el -> Map.of("id", el.getId(),
                        "title", el.getTitle(),
                        "time", el.getInterestingMoments().stream()
                                .map(elemt -> elemt.getTime()),
                        "url", el.getBoxarts().stream()
                                .reduce((boxArt, boxArt2) -> boxArt.getWidth() * boxArt.getHeight()
                                        < boxArt2.getWidth() * boxArt2.getHeight() ? boxArt : boxArt2)
                )).collect(Collectors.toList());


//        return ImmutableList.of(ImmutableMap.of("id", 5, "title", "some title", "time", new Date(), "url", "someUrl"));
    }
}
