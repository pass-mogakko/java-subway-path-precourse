package subway.domain;

import subway.domain.section.Section;

public enum DummyData {
    A(new Section("교대역", "강남역", "2호선", 2, 3)),
    B(new Section("강남역", "교대역", "2호선", 2, 3)),
    C(new Section("강남역", "역삼역", "2호선", 2, 3)),
    D(new Section("역삼역", "강남역", "2호선", 2, 3)),
    E(new Section("교대역", "남부터미널역", "3호선", 3, 2)),
    F(new Section("남부터미널역", "교대역", "3호선", 3, 2)),
    G(new Section("남부터미널역", "양재역", "3호선", 6, 5)),
    H(new Section("양재역", "남부터미널역", "3호선", 6, 5)),
    I(new Section("양재역", "매봉역", "3호선", 1, 1)),
    J(new Section("매봉역", "양재역", "3호선", 1, 1)),
    K(new Section("강남역", "양재역", "신분당선", 2, 8)),
    L(new Section("양재역", "강남역", "신분당선", 2, 8)),
    M(new Section("양재역", "양재시민의숲역", "신분당선", 10, 3)),
    N(new Section("양재시민의숲역", "양재역", "신분당선", 10, 3));

    private final Section section;

    DummyData(Section section) {
        this.section = section;
    }

    public Section getSection() {
        return section;
    }
}
