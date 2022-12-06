package subway.service;

import java.util.List;
import org.jgrapht.GraphPath;
import subway.domain.section.SectionRepository;
import subway.dto.PathDto;

public class PathLookupService {

    public PathDto findShortestPath(String srcStation, String dstStation) {
        GraphPath shortestPath = SectionRepository.findShortestPath(srcStation, dstStation);
        int distance = (int) shortestPath.getWeight();
        List<String> stations = shortestPath.getVertexList();
        int time = SectionRepository.findShortestPathTime(stations);
        return new PathDto(distance, time, stations);
    }
}
