### 功能描述
#### 代理模式（静态代理）
代理模式是常用设计模式的一种，我们在软件设计时常用的代理一般是指静态代理，也就是在代码中显式指定的代理。

静态代理由 业务实现类、业务代理类 两部分组成。业务实现类 负责实现主要的业务方法，
业务代理类负责对调用的业务方法作拦截、过滤、预处理，主要是在方法中首先进行预处理动作，
然后调用业务实现类的方法，还可以规定调用后的操作。我们在需要调用业务时，不是直接通过业务实现类来调用的，
而是通过业务代理类的同名方法来调用被代理类处理过的业务方法。
##### 静态代理的实现：
1：首先定义一个接口，说明业务逻辑。
```java
package com.cheng.erik.john.agent.stati;

/**
 * @ClassName ：Count
 * @Author ：JohnErikCheng
 * @Email ：dong@19910925@126.com
 * @Date ：Created in 2019/5/4 14:11
 * @Description: 账户接口。
 */
public interface Count {
    /**
     *  查询账户
     */
    void queryCount();

    /**
     * 修改账户
     */
    void updateCount();
}
```   
2：然后，定义业务实现类，实现业务逻辑接口
```java
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
```
3：定义业务代理类：通过组合，在代理类中创建一个业务实现类对象来调用具体的业务方法；
通过实现业务逻辑接口，来统一业务方法；在代理类中实现业务逻辑接口中的方法时，进行预处理操作、
通过业务实现类对象调用真正的业务方法、进行调用后操作的定义。
```java
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
```
  4：在使用时，首先创建业务实现类对象，
  然后把业务实现类对象作构造参数创建一个代理类对象，
  最后通过代理类对象进行业务方法的调用。
  ```java
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
```
```text
 静态代理的缺点很明显：一个代理类只能对一个业务接口的实现类进行包装，
 如果有多个业务接口的话就要定义很多实现类和代理类才行。而且，如果代理类对业务方法的预处理、
 调用后操作都是一样的（比如：调用前输出提示、调用后自动关闭连接），则多个代理类就会有很多重复代码。
 这时我们可以定义这样一个代理类，它能代理所有实现类的方法调用：
 根据传进来的业务实现类和方法名进行具体调用。——那就是动态代理。
```