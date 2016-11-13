package com.example.mappers;

import com.example.mybatis.entity.ExamplePojo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface ExampleMapperClass {

    @Select({"<script>",
            "select id as id, content as content",
            "from ExampleDB",
            "</script>"})
    ExamplePojo getExamplePojo(@Param("id") long id, @Param("content") String content);

}
