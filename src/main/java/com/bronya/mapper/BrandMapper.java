package com.bronya.mapper;

import com.bronya.pojo.Brand;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface BrandMapper {
    /// 查看全部
    List<Brand> selectAll();
    /// 查看详情
    Brand selectById(int id);
    ///条件查询
    ///1.
   /* List<Brand> selectByCondition(@Param("status") int status, @Param("companyName") String companyName, @Param("brandName") String brandName);*/
    /// 2.
     /*List<Brand> selectByCondition(Brand brand);*/
    /// 3.
    List<Brand> selectByCondition(Map map);

    /// 单条件查询
    List<Brand> selectByConditionSingle(Brand brand);

    ///查询
    void add(Brand brand);

    /// 修改
    int update(Brand brand);

    /// 删除
    int delete(Brand brand);
    /// 批量删除
    int deletes(@Param("ids") int[] ids);


}
