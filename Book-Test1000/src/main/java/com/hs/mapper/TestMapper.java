package com.hs.mapper;

import com.hs.entity.Test;
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
}
