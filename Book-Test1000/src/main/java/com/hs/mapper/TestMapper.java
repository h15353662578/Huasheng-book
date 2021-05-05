package com.hs.mapper;

import com.hs.entity.Test;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @author Huasheng
 * @Date 2021/04/28/9:30
 * @Description
 */
@Mapper
public interface TestMapper {

    @Select("select stock from test where id = #{id}")
    public List<Test> selectById(String id,Integer stock);

    @Update("update test set stock = stock-1 where id = #{id}")
    public Integer update(String id);

    @Select("select stock from test where id = #{id}")
    public int Select(String id);

    @Update("update test set stock =stock-1,version = version + 1 where id = #{id}")
    public Integer update2(String id);

    @Select("select id,name,version,stock from test where id = #{id}")
    public List<Test> selectAll(String id);

    @Update("update test set version =0 where id = #{id}")
    public Integer result(String id);

    @Update("update test set version =0 where id = #{id}")
    public Integer result3(int id);

    @Select("select id from test")
    public List<Integer> findAll();

    @Update("update test set stock =stock-1,version = version + 1 where id = #{id}")
    public Integer update3(int id);

    @Select("select stock,id,version from test where id = #{id}")
    public List<Test> select2(int id);

    @Insert("insert into test (name) values (#{name})")
    public void insert(Test test);
}
