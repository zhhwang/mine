package com.botany.mint.exercise;

/**
 * @author wangzh
 */
public class Test {

    private volatile Object object;

    public Test(Object object) {
        this.object = object;
    }

    public Object getObject() {
        if (object == null) {
            synchronized (object) {
                if (null == object) {
                    object = new Object();
                }
            }
        }

        return object;
    }

    public static void main(String[] args) {
        Test test = new Test(null);
        test.getObject();
    }


}
