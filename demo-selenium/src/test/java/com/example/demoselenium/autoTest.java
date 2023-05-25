package com.example.demoselenium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

/**
 * @author sgj
 * @create 2023-05-23 11:13
 */

public class autoTest {

    // 单参数
    @ParameterizedTest
    @ValueSource(strings = {"sgj", "tfg"})
    void parameter01Test (String name) {
        System.out.println("name :" + name);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2})
    void parameter02Test (int num) {
        System.out.println("name :" + num);
    }

    // 多参数
    // 默认分隔符是逗号
    @ParameterizedTest
    @CsvSource(value={"sgj, 20", "ggg, 30"}) // 默认分隔符是逗号
    void parameter03Test (String name, int num) {
        System.out.println("name : " + name + " ; " + "name :" + num);
    }

    // 指定分隔符是逗号
    @ParameterizedTest
    @CsvSource(value={"sgj-20", "ggg-30"}, delimiterString = "-") // 指定分隔符是逗号
    void parameter04Test (String name, int num) {
        System.out.println("name : " + name + " ; " + "name :" + num);
    }

    // 如果参数中包含逗号，就需要使用单引号('')作为转义字符
    @ParameterizedTest
    @CsvSource(value={"'s,g,j'-20", "ggg-30"}, delimiterString = "-")
    void parameter05Test (String name, int num) {
        System.out.println("name : " + name + " ; " + "name :" + num);
    }


    // 如果参数非常多，在代码中编写不太好看，就可以借助文件注入的方式来添加
    // resource文件夹下
    @ParameterizedTest
    @CsvFileSource(resources = "/csv")
    void parameter06Test (String name, int num) {
        System.out.println("name : " + name + " ; " + "name :" + num);
    }

    // 自定义文件夹(本地硬盘下)
    @ParameterizedTest
    @CsvFileSource(files = "E:\\IDEA\\demo-selenium\\src\\main\\resources\\csv")
    void parameter07Test (String name, int num) {
        System.out.println("name : " + name + " ; " + "name :" + num);
    }

    // 动态参数
    // 单参
    @ParameterizedTest
    @MethodSource // 会去找跟用例同名的静态方法
    void parameter08Test (String x) {
        System.out.println(x);
    }

    // 定义提供数据的方法, 返回值可以是stream流, 且必须是静态的方法
    static Stream<String> parameter08Test() {
        return Stream.of("zhangsan", "lisi");
    }

    // 多参
    @ParameterizedTest
    @MethodSource // 会去找跟用例同名的静态方法
    void parameter09Test (String x, int y) {
        System.out.println(x + " : " + y);
    }

    // 定义提供数据的方法, 返回值可以是stream流, 且必须是静态的方法
    static Stream<Arguments> parameter09Test() {
        return Stream.of(Arguments.arguments("zhangsan", 1), Arguments.arguments("liss", 2));
    }
}
