package com.botany.mint.utils;

import org.junit.Test;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Map;

/**
 * 使用hibernate validator依赖于tomcat的servlet
 *  所以这个测试用例执行报错
 */
public class ValidatorUtilTest {

    @Test
    public void validatorTest() {
        Cat cat = new Cat(1, null);
        print(ValidatorUtil.validate(cat));
    }

    private static void print(Map<String,StringBuffer> errorMap){
        if(errorMap != null){
            for(Map.Entry<String, StringBuffer> m : errorMap.entrySet()){
                System.out.println(m.getKey() + ":" + m.getValue().toString());
            }
        }
    }

    public class Cat {
        private long id;

        @NotNull(message = "name can't be null")
        @Size(min = 1, max = 64, message = "name's length must between 1 and 64")
        private String name;

        public Cat(long id, String name) {
            this.id = id;
            this.name = name;
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }
    }
}
