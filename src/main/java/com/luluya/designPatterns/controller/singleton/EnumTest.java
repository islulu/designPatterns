package com.luluya.designPatterns.controller.singleton;

/**
 * @author jairy
 * @date 2019/5/15
 */
//枚举本身是单例的，一般用于项目中定义常量。
enum HttpEnum{
    HTTP_200(200,"请求成功"),
    HTTP_500(200,"请求失败");

    private Integer code;
    private String name;

    HttpEnum(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

public class EnumTest {

    public static void main(String[] args) {
        System.out.println(HttpEnum.HTTP_200.getCode());
        System.out.println(HttpEnum.HTTP_200.getCode());
        System.out.println(HttpEnum.HTTP_200.getCode());
        System.out.println(HttpEnum.HTTP_500.getCode());
    }

}
