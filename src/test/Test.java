package test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import po.Items;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by admin on 2017/7/1.
 */
public class Test {


    @org.junit.Test
    public void test01() throws IOException {

        String path = "SqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(path);
        //创建会话工厂，传入mybatis配置文件的信息
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 通过工厂得到SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        Items list = sqlSession.selectOne("mapper.ItemsMapper.queryItemsById",1);
        System.out.println(list);
        sqlSession.close();

    }

}
