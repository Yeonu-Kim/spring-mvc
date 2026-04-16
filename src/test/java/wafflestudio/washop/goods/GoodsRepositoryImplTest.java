package wafflestudio.washop.goods;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GoodsRepositoryImplTest {
    GoodsRepository goodsRepository = new GoodsRepositoryImpl();

    @AfterEach
    void clearAllItems() {
        goodsRepository.clearStore();
    }

    @Test
    void save() {
        Goods goods = new Goods("itemA", 10000, 10);
        Goods saveGoods = goodsRepository.save(goods);

        Goods findGoods = goodsRepository.findById(goods.getId());
        Assertions.assertThat(findGoods).isEqualTo(saveGoods);
    }

    @Test
    void findAll() {
        Goods goods1 = new Goods("itemA", 10000, 10);
        Goods goods2 = new Goods("itemB", 20000, 10);

        goodsRepository.save(goods1);
        goodsRepository.save(goods2);

        List<Goods> result = goodsRepository.findAll();

        Assertions.assertThat(result.size()).isEqualTo(2);
        Assertions.assertThat(result).contains(goods1, goods2);
    }

    @Test
    void updateItem() {
        Goods goods1 = new Goods("itemA", 10000, 10);

        Goods saveGoods = goodsRepository.save(goods1);
        Long itemId = saveGoods.getId();

        Goods updateParam = new Goods("itemB", 20000, 30);
        goodsRepository.update(itemId, updateParam);

        Goods findItem = goodsRepository.findById(itemId);

        Assertions.assertThat(findItem.getName()).isEqualTo(updateParam.getName());
        Assertions.assertThat(findItem.getPrice()).isEqualTo(updateParam.getPrice());
        Assertions.assertThat(findItem.getQuantity()).isEqualTo(updateParam.getQuantity());
    }
}