package co.kr.mono.studydb.model.nudle;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor // 파라미터가 없는 기본생성자를 생성
@AllArgsConstructor // 모든 필드값을 파라미터로 받는 생성자를 만들어줌

// 국수판매 상세
public class OrderProduct {

    private int orderProductId;

    private int productId;

    private int orderId;

    private String location;

    private Nudle nudle;

    @Override
    public String toString() {
        return "OrderProduct{" +
                "orderProductId=" + orderProductId +
                ", productId=" + productId +
                ", orderId=" + orderId +
                ", location='" + location + '\'' +
                ", nudle=" + nudle +
                '}';
    }
}
