package test;

import dao.ItemsDao;
import dao.impl.ItemsDaoImpl;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.*;
import po.Items;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by admin on 2017/7/1.
 */
public class Test02 {

    private SqlSessionFactory sqlSessionFactory;
    // 此方法是在执行testFindUserById之前执行
    @Before
    public void setUp() throws IOException {
        // 创建sqlSessionFactory

        // mybatis配置文件
        String resource = "SqlMapConfig.xml";
        // 得到配置文件流
        InputStream inputStream = Resources.getResourceAsStream(resource);

        // 创建会话工厂，传入mybatis的配置文件信息
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    @org.junit.Test
    public void testFindItemsById() throws Exception {

        //创建ItemsDao对象
        ItemsDao itemsDao = new ItemsDaoImpl(sqlSessionFactory);

        //调用ItemsDao方法
        Items itemsById = itemsDao.findItemsById(2);

        System.out.println(itemsById);
    }
}
