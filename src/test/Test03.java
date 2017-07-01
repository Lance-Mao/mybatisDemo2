package test;

import dao.ItemsDao;
import dao.impl.ItemsDaoImpl;
import mapper.ItemsMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.*;
import po.Items;

import java.io.InputStream;

/**
 * Created by admin on 2017/7/1.
 */
public class Test03 {
    private SqlSessionFactory sqlSessionFactory;
    //注解Before是在执行本类所有测试方法之前先调用这个方法
    @Before
    public void setup() throws Exception{
        //创建SqlSessionFactory
        String resource="SqlMapConfig.xml";
        //将配置文件加载成流
        InputStream inputStream = Resources.getResourceAsStream(resource);

        //创建会话工厂，传入mybatis配置文件的信息
        sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
    }

    @org.junit.Test
    public void testFindItemsById() throws Exception{
        SqlSession sqlSession=sqlSessionFactory.openSession();

        //创建ItemsDao代理对象
        ItemsMapper mapper = sqlSession.getMapper(ItemsMapper.class);

        //调用userMapper的方法
        Items items =mapper.findItemsById(1);
        System.out.println(items.getName());
    }
}
