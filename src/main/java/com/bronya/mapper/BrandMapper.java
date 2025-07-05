package com.bronya.mapper;

import com.bronya.pojo.Brand;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface BrandMapper {
    /// 查看全部
    public List<Brand> selectAll();
    /// 查看详情
    Brand selectById(int id);
    ///条件查询
    ///1.
   /* List<Brand> selectByCondition(@Param("status") int status, @Param("companyName") String companyName, @Param("brandName") String brandName);*/
    /// 2.
     /*List<Brand> selectByCondition(Brand brand);*/
    /// 3.
    List<Brand> selectByCondition(Map map);
}
