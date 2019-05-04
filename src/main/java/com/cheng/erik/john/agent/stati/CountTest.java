package com.cheng.erik.john.agent.stati;

/**
 * @ClassName ：CountTest
 * @Author ：JohnErikCheng
 * @Email ：dong@19910925@126.com
 * @Date ：Created in 2019/5/4 14:18
 * @Description: 账号测试类
 */
public class CountTest {
    public static void main(String[] args) {

        CountImpl count = new CountImpl();
        CountProxy countProxy = new CountProxy(count);
        countProxy.queryCount();
        countProxy.updateCount();

    }
}
