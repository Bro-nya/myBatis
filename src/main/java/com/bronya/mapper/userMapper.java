package com.bronya.mapper;

import com.bronya.pojo.Brand;
import com.bronya.pojo.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface userMapper {
    List<User> selectAll();

    /// 注解开发测试
    @Select("select * from tb_user where id=#{id}")
    User selectAll2(int i);
}
