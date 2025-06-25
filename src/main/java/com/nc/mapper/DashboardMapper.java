package com.nc.mapper;

import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface DashboardMapper {
    @Select(" select * from users_dashboard")
    List<Map<String ,String>> getAll();

    @Update("update users_dashboard set name=#{name},roll=#{roll},address=#{address},action=#{action} where sNo=#{id}")
    int update(@Param("id") int id,@Param("name") String name,@Param("roll") String  roll,@Param("address") String address,@Param("action") boolean action);

    @Delete("delete from users_dashboard where sNo =#{id}")
    int delete(@Param("id") int id);
}
