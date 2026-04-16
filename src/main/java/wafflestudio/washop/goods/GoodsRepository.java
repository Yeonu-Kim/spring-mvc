package wafflestudio.washop.goods;

import java.util.List;

public interface GoodsRepository {
    public Goods save(Goods goods);
    public Goods findById(Long id);
    public List<Goods> findAll();
    public void update(Long id, Goods goodsParam);
    public void clearStore();
}
