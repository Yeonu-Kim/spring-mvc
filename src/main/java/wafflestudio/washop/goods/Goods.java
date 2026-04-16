package wafflestudio.washop.goods;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// 지금은 따로 DB를 사용하고 있지 않으므로
// lombok의 Data 사용
@Data
@NoArgsConstructor
public class Goods {
    private Long id;
    private String name;
    private Integer price;
    private Integer quantity;

    // ID가 없는 버전의 생성자
    public Goods(String name, Integer price, Integer quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
}
