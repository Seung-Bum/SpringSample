package co.kr.mono.studydb.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
//@RequiredArgsConstructor
@AllArgsConstructor
@ToString
//@Data == @Getter, @Setter, @RequiredArgsConstructor, @ToString, @EqualsAndHashCode
public class AreaSalesDTO {
    private String areaCd;
    private String regionArea;
    private String prodId;
    private int saleCnt;
}
