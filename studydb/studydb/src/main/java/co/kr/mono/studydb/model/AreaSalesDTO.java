package co.kr.mono.studydb.model;

import lombok.*;

// 모델을 테이블, 도메인 JPA에서는 엔티티라고함
@Getter
@Setter
@NoArgsConstructor
//@RequiredArgsConstructor
@AllArgsConstructor
@ToString
//@Data
public class AreaSalesDTO { // 데이터를 주고 받을때 사용하는 객체
    private String areaCd;
    private String regionArea;
    private String prodId;
    private int saleCnt;

}
