package dao.impl;

import dao.ItemsDao;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import po.Items;

import java.util.List;

/**
 * Created by admin on 2017/7/1.
 */
public class ItemsDaoImpl implements ItemsDao {

    // 需要向dao实现类中注入SqlSessionFactory
    // 这里通过构造方法注入
    private SqlSessionFactory sqlSessionFactory;

    public ItemsDaoImpl(SqlSessionFactory sqlSessionFactory){
        this.sqlSessionFactory = sqlSessionFactory;
    }


    @Override
    public Items findItemsById(int id) throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        Items items = sqlSession.selectOne("mapper.ItemsMapper.findItemsById", id);
        //释放资源
        sqlSession.close();
        return items;
    }

    @Override
    public List<Items> findItemsByName(String name) throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<Items> list = sqlSession.selectList("mapper.ItemsMapper.findItemsByName", name);
        //释放资源
        sqlSession.close();
        return list;
    }

    @Override
    public void insertItems(Items items) throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.insert("mapper.ItemsMapper.insertItems", items);

        //提交事务
        sqlSession.commit();

        //释放资源
        sqlSession.close();
    }

    @Override
    public void deleteItems(int id) throws Exception {

        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.delete("mapper.ItemsMapper.deleteItems",id);

        sqlSession.commit();
        sqlSession.close();


    }
}
