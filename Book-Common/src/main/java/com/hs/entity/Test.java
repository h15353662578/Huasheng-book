package com.hs.entity;

import com.baomidou.mybatisplus.annotation.Version;
import lombok.Data;

/**
 * @author Huasheng
 * @Date 2021/04/28/9:20
 * @Description
 */
@Data
public class Test {

    private String id;

    private String name;

    private int stock;

    @Version
    private int version;
}
