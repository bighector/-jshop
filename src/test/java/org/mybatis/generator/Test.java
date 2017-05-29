package org.mybatis.generator;

import net.jeeshop.services.manage.task.bean.Task;

/**
 * Created by tommy on 17/5/27.
 */
public class Test {
    public static void main(String[] args) {
        try {
            try {
                Task.class.getMethod("setId",String.class);
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
            Task.class.getField("id");
            Task.class.getDeclaredField("id");
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
}
