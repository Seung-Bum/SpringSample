package co.kr.mono.studydb.model.nudle;

import lombok.*;
import org.springframework.lang.Nullable;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor // 파라미터가 없는 기본생성자를 생성
@AllArgsConstructor // 모든 필드값을 파라미터로 받는 생성자를 만들어줌
@ToString

// 국수 판매현황
public class NudleOrder {

    private int orderId;

    private int memberId;

    private String orderDate;

    private int totalPrice;

}
