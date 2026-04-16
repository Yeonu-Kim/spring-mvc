package wafflestudio.washop.goods;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GoodsRepositoryImpl implements GoodsRepository{
    private static final Map<Long, Goods> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Goods save(Goods goods) {
        goods.setId(++sequence);
        store.put(goods.getId(), goods);
        return goods;
    }

    @Override
    public Goods findById(Long id) {
        return store.get(id);
    }

    @Override
    public List<Goods> findAll() {
        return new ArrayList<>(store.values());
    }

    @Override
    public void update(Long id, Goods goodsParam) {
        Goods findGoods = findById(id);
        findGoods.setName(goodsParam.getName());
        findGoods.setPrice(goodsParam.getPrice());
        findGoods.setQuantity(goodsParam.getQuantity());
    }

    public void clearStore() {
        store.clear();
    }
}
