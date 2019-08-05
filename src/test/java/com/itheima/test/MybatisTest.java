package com.itheima.test;

import com.itheima.dao.IUserDao;
import com.itheima.dao.impl.UserDaoImpl;
import com.itheima.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.sql.SQLOutput;
import java.util.List;

/**
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 * mybatis的入门案例
 */
public class MybatisTest {

    /**
     * 入门案例
     * @param args
     */
    public static void main(String[] args)throws Exception {
        //1.读取配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
//       本例子是实现了dao的，所以不用动态代理，下面的代码要修改
//        //3.使用工厂生产SqlSession对象
//        SqlSession session = factory.openSession();
        //4.使用SqlSession创建Dao接口的代理对象
//        IUserDao userDao = session.getMapper(IUserDao.class);
//
//        //5.使用代理对象执行方法
//        List<User> users = userDao.findAll();
//        for(User user : users){
//            System.out.println(user);
//        }
//        //6.释放资源
//        session.close();
//        in.close();
        // 3.使用工厂创建dao对象
        IUserDao userDao = new UserDaoImpl(factory);
        // 4.使用dao对象执行方法
        List<User> users = userDao.findAll();
        for (User user : users) {
            System.out.println(user);
        }
        // 5.释放资源
        in.close();
    }
}
