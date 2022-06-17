package co.kr.mono.studydb.model.nudle;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor // 파라미터가 없는 기본생성자를 생성
@AllArgsConstructor // 모든 필드값을 파라미터로 받는 생성자를 만들어줌
@ToString

// 국수판매 상세
public class OrderProduct {

    private int orderProductId;

    private int productId;

    private int orderId;

    private String location;

    private Nudle nudle;

    private NudleOrder nudleOrder;
}
