package co.kr.mono.studydb.model.nudle;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor // 파라미터가 없는 기본생성자를 생성
@AllArgsConstructor // 모든 필드값을 파라미터로 받는 생성자를 만들어줌

// 국수 상품
public class Nudle {

    private int productId;

    private String productCategory;

    private String productName;

    private int productPrice;

    @Override
    public String toString() {
        return "Nudle{" +
                "productId=" + productId +
                ", productCategory='" + productCategory + '\'' +
                ", productName='" + productName + '\'' +
                ", productPrice=" + productPrice +
                '}';
    }
}
