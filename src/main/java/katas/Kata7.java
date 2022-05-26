package katas;

import model.MovieList;
import util.DataUtil;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
    Goal: Retrieve the id, title, and smallest box art url for every video
    DataSource: DataUtil.getMovieLists()
    Output: List of ImmutableMap.of("id", "5", "title", "Bad Boys", "boxart": "url)
*/
public class Kata7 {
    public static List<Map> execute() {
        List<MovieList> movieLists = DataUtil.getMovieLists();

        return movieLists.stream()
                .flatMap(e -> e.getVideos().stream())
                .map(el -> Map.of("id", el.getId(),
                        "title", el.getTitle(),
                        "boxart", el.getBoxarts().stream()
                                .reduce((menor, mayor) -> menor.getWidth() * menor.getHeight() <
                                        mayor.getWidth() * mayor.getHeight() ? menor : mayor)))
                .collect(Collectors.toList());


//        return ImmutableList.of(ImmutableMap.of("id", 5, "title", "Bad Boys", "boxart", "url"));
    }
}



