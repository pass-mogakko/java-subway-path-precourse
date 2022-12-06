package subway.domain.section;

public class Section {

    private String srcStationName;
    private String dstStationName;
    private String lineName;
    private int distance;
    private int time;

    public Section(String srcStationName, String dstStationName, String lineName, int distance, int time) {
        this.srcStationName = srcStationName;
        this.dstStationName = dstStationName;
        this.lineName = lineName;
        this.distance = distance;
        this.time = time;
    }

    public String getSrcStationName() {
        return srcStationName;
    }

    public String getDstStationName() {
        return dstStationName;
    }

    public String getLineName() {
        return lineName;
    }

    public int getDistance() {
        return distance;
    }

    public int getTime() {
        return time;
    }
}
