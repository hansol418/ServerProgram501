package com.busanit501.minispringproject.mapper;

import org.apache.ibatis.annotations.Select;

public interface TimeMapper {
  @Select("select now()")
  String getTime();
}













