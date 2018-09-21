package com.example.demo.mapper;

import com.example.demo.model.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface UserMapper {
    @Delete({
        "delete from user",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into user (id, name, ",
        "sex, description, delete_flag)",
        "values (#{id,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR}, ",
        "#{sex,jdbcType=CHAR}, #{description,jdbcType=VARCHAR}, #{deleteFlag,jdbcType=CHAR})"
    })
    int insert(User record);

    int insertSelective(User record);

    @Select({
        "select",
        "id, name, sex, description, delete_flag",
        "from user",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ResultMap("com.example.demo.mapper.UserMapper.BaseResultMap")
    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    @Update({
        "update user",
        "set name = #{name,jdbcType=VARCHAR},",
          "sex = #{sex,jdbcType=CHAR},",
          "description = #{description,jdbcType=VARCHAR},",
          "delete_flag = #{deleteFlag,jdbcType=CHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(User record);
}