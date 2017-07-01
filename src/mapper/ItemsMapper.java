package mapper;

import po.Items;

import java.util.List;

/**
 * Created by admin on 2017/7/1.
 */
public interface ItemsMapper {

    //根据id查询商品信息
    public Items findItemsById(int id) throws Exception;

    //根据商品名列查询商品列表
    public List<Items> findItemsByName(String name) throws Exception;

    //添加商品信息
    public void insertItems(Items items) throws Exception;

    //删除商品信息
    public void deleteItems(int id) throws Exception;
}
