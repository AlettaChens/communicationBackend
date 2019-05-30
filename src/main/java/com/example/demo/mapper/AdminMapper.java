package com.example.demo.mapper;

import com.example.demo.entity.Admin;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;

@Component
@org.apache.ibatis.annotations.Mapper
public interface AdminMapper extends Mapper<Admin> {
    @Insert("insert into t_admin(AdminName,AdminPassword)values(#{name},#{password})")
    int register(@Param(value = "name") String name, @Param(value = "password") String password);

    @Select("select * from t_admin where AdminName=#{name}and AdminPassword=#{password}")
    Admin login(@Param(value = "name") String name,@Param(value = "password") String password);
}
