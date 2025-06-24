package com.nc.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface DashboardMapper {
    @Select(" select * from users_dashboard")
    List<Map<String ,String>> getAll();
}
