package com.bronya.test;

import com.bronya.mapper.BrandMapper;
import com.bronya.pojo.Brand;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyBatisTest {
    @Test
    public void testSelectAll() throws IOException {
        //1.myBatisd的核心配置文件加载，获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //2.获取sqlsession对象，用它来执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession();
        
        //3.获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        //执行方法
        List<Brand> brands=brandMapper.selectAll();
        System.out.println(brands);
        //释放资源
        sqlSession.close();
    }

    @Test
    public void testSelectById() throws IOException {
        //1.myBatisd的核心配置文件加载，获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //2.获取sqlsession对象，用它来执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3.获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        //执行方法
        int id=1;
        Brand brand = brandMapper.selectById(id);
        System.out.println(brand);
        //释放资源
        sqlSession.close();
    }

    @Test
    public void testSelectByCondition() throws IOException {
        //1.myBatisd的核心配置文件加载，获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //2.获取sqlsession对象，用它来执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3.获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        //执行方法
        int status=1;
        String companyName="华为";
        String brandName="华为";
        companyName="%"+companyName+"%";
        brandName="%"+brandName+"%";
        /// 1.
       /* List<Brand> brands = brandMapper.selectByCondition(status,companyNmae,brandNmae);*/
        /// 2.
      /*  Brand brand = new Brand();
        brand.setStatus(status);
        brand.setCompanyName(companyName);
        brand.setBrandName(brandName);
        List<Brand> brands = brandMapper.selectByCondition(brand);*/
        /// 3.
        Map map = new HashMap();
        map.put("status",status);
        map.put("companyName",companyName);
        map.put("brandName",brandName);
        List<Brand> brands = brandMapper.selectByCondition(map);

        System.out.println(brands);
        //释放资源
        sqlSession.close();
    }
}
