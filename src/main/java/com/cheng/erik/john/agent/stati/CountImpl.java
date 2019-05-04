package com.cheng.erik.john.agent.stati;

/**
 * @ClassName ：CountImpl
 * @Author ：JohnErikCheng
 * @Email ：dong@19910925@126.com
 * @Date ：Created in 2019/5/4 14:13
 * @Description: 委托类（保函业务逻辑）。
 */
public class CountImpl implements Count {
    @Override
    public void queryCount() {
        System.out.println("查看账户...");
    }

    @Override
    public void updateCount() {
        System.out.println("修改账户...");
    }
}
