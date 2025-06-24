package com.nc.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface LoginMapper {
    @Select("select count(*)>0 from user_login where username=#{username} and password=#{password}")
    boolean isUserExist(String username,String password);
}
