package com.cheng.erik.john.agent.stati;

/**
 * @ClassName ：CountProxy
 * @Author ：JohnErikCheng
 * @Email ：dong@19910925@126.com
 * @Date ：Created in 2019/5/4 14:15
 * @Description: 业务代理类。
 */
public class CountProxy implements Count{

    private CountImpl countImpl;

    public CountProxy(CountImpl countImpl) {
        this.countImpl = countImpl;
    }

    @Override
    public void queryCount() {
        System.out.println("查询账号预处理...");
        countImpl.queryCount();
        System.out.println("查询账号之后...");
    }

    @Override
    public void updateCount() {
        System.out.println("修改账号预处理...");
        countImpl.updateCount();
        System.out.println("修改账号之后...");
    }
}
