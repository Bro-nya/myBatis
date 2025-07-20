package com.bronya.test;

import com.bronya.mapper.BrandMapper;
import com.bronya.mapper.userMapper;
import com.bronya.pojo.Brand;
import com.bronya.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.reflection.ParamNameResolver;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import javax.sql.rowset.spi.SyncProvider;
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
       /*Brand brand = new Brand();
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

    @Test
    public void selectByConditionSingle() throws IOException {
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
        /* List<Brand> brands = brandMapper.selectByCondition(status,companyName,brandName);*/
        /// 2.
        Brand brand = new Brand();
       /* brand.setStatus(status);
        brand.setCompanyName(companyName);
        brand.setBrandName(brandName);*/
        List<Brand> brands = brandMapper.selectByConditionSingle(brand);
        /// 3.
      /*  Map map = new HashMap();
        map.put("status",status);
        map.put("companyName",companyName);
        map.put("brandName",brandName);
        List<Brand> brands = brandMapper.selectByCondition(map);*/

        System.out.println(brands);
        //释放资源
        sqlSession.close();
    }

    @Test
    public void testAdd() throws IOException {
        //1.myBatisd的核心配置文件加载，获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //2.获取sqlsession对象，用它来执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession(false);///autoCommit:是否开启自动提交事务

        //3.获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        //执行方法
        int status=1;
        String companyName="小米5";
        String brandName="小米手机";
        String description="为发烧而生";
        int ordered=100;

        Brand brand=new Brand();
        brand.setStatus(status);
        brand.setBrandName(brandName);
        brand.setCompanyName(companyName);
        brand.setDescription(description);
        brand.setOrdered(ordered);

        brandMapper.add(brand);
        Integer id=brand.getId();
        System.out.println(id);
        brandMapper.add(brand);
        Integer id2=brand.getId();
        System.out.println(id2);

        sqlSession.commit();//事务提交，因为mybatis把自动提交关了
        //释放资源
        sqlSession.close();
    }

    @Test
    public void testUpdate() throws IOException {
        //1.myBatisd的核心配置文件加载，获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //2.获取sqlsession对象，用它来执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession(false);///autoCommit:是否开启自动提交事务

        //3.获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        //执行方法
        int status=1;
        String companyName="小米666";
        String brandName="小米手机666";
        String description="咩咩咩咩咩咩咩咩咩咩咩";
        int ordered=200;
        int id=12;

        Brand brand=new Brand();
        brand.setStatus(status);
        brand.setBrandName(brandName);
        brand.setCompanyName(companyName);
        brand.setDescription(description);
        brand.setOrdered(ordered);
        brand.setId(id);

        int count = brandMapper.update(brand);
        System.out.println(count);
        sqlSession.commit();//事务提交，因为mybatis把自动提交关了
        //释放资源
        sqlSession.close();
    }

    @Test
    public void testDeleteById() throws IOException {
        //1.myBatisd的核心配置文件加载，获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //2.获取sqlsession对象，用它来执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession(false);///autoCommit:是否开启自动提交事务

        //3.获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        //执行方法
        int id=11;

        Brand brand=new Brand();
        brand.setId(id);

        int count = brandMapper.delete(brand);
        System.out.println(count);
        sqlSession.commit();//事务提交，因为mybatis把自动提交关了
        //释放资源
        sqlSession.close();
    }

    @Test
    public void testDeletes() throws IOException {
        //1.myBatisd的核心配置文件加载，获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //2.获取sqlsession对象，用它来执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession(false);///autoCommit:是否开启自动提交事务

        //3.获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        //执行方法
        int[] ids={15,3,7};

        int count = brandMapper.deletes(ids);
        System.out.println(count);
        sqlSession.commit();//事务提交，因为mybatis把自动提交关了
        //释放资源
        sqlSession.close();
    }

    @Test
    public void testSelect2() throws IOException {
        //1.myBatisd的核心配置文件加载，获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //2.获取sqlsession对象，用它来执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession(false);///autoCommit:是否开启自动提交事务

        //3.获取Mapper接口的代理对象
        userMapper userMapper = sqlSession.getMapper(userMapper.class);

        //执行方法
        User count= userMapper.selectAll2(2);
        System.out.println(count);
        //释放资源
        sqlSession.close();
    }
}
