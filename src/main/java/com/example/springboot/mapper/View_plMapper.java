package com.example.springboot.mapper;

import com.example.springboot.Request.BaseRequest;
import com.example.springboot.entity.View_pl;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
//@Mapper 是一个 Java 注解，主要用于在 Spring 框架中标记接口作为 MyBatis 映射器（Mapper）。MyBatis 是一个持久层框架，它可以将 Java 接口映射成对应的 SQL 查询。
////
////        在使用 MyBatis 进行数据库操作时，常见的做法是创建一个 Java 接口，并使用 @Mapper 注解来标识它。这个接口包含了需要执行的数据库操作，例如增、删、改、查等方法。MyBatis 会根据接口定义自动生成相应的 SQL 语句，并将其与数据库进行交互。
////
////        具体来说，@Mapper 注解的作用包括：
////
////        标识接口： 将其标记为 MyBatis 的映射器接口，告诉 Spring 框架这个接口是用来定义数据库操作的。
////        代理实现： Spring 在运行时会为标记了 @Mapper 注解的接口动态生成其实现类的代理对象。这个代理对象会负责实际执行与数据库相关的操作。
@Mapper
public interface View_plMapper {

    List<View_pl> listByCondition(BaseRequest baseRequest);

    List<View_pl> list();
}
