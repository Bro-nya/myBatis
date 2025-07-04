package com.bronya;

import com.bronya.mapper.userMapper;
import com.bronya.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/// Mapper代理开发
public class MybatisDemo2 {
    public static void main(String[] args) throws IOException {
        //1.myBatisd的核心配置文件加载，获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取sqlsession对象，用它来执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3.执行sql
      /*  List<User> Users=sqlSession.selectList("test.selectAll");
        System.out.println(Users);*/
        userMapper userMapper=sqlSession.getMapper(userMapper.class);
        List<User> users = userMapper.selectAll();
        System.out.println(users);

        //4.释放
        sqlSession.close();
    }
}
