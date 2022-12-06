package subway.service;

import java.util.List;
import subway.constant.ErrorMessage;
import subway.domain.section.SectionRepository;
import subway.dto.PathDto;

public class PathLookupService {

    public PathDto findShortestPath(String srcStation, String dstStation) {
        if (srcStation.equals(dstStation)) {
            throw new IllegalArgumentException(ErrorMessage.NOT_EXIST_SECTION);
        }
        List<String> stations = SectionRepository.findShortestPathVertexList(srcStation, dstStation);
        int distance = SectionRepository.findShortestPathDistance(srcStation, dstStation);
        int time = SectionRepository.findShortestPathTime(stations);
        return new PathDto(distance, time, stations);
    }

    public PathDto findMinimumTime(String srcStation, String dstStation) {
        if (srcStation.equals(dstStation)) {
            throw new IllegalArgumentException(ErrorMessage.NOT_EXIST_SECTION);
        }
        List<String> stations = SectionRepository.findMinimumTimeVertexList(srcStation, dstStation);
        int time = SectionRepository.findMinimumTime(srcStation, dstStation);
        int distance = SectionRepository.findMinimumTimeDistance(stations);
        return new PathDto(distance, time, stations);
    }
}
