## 代理模式
给某一个对象（目标对象）提供一个代理，并由代理对象控制原对象（目标对象）的引用进行操作，这种模式一般称之为代理模式。

- 静态代理
- 动态代理

#### 静态代理
静态代理只能代理一个具体的类，如果要代理一个接口的多个实现的话需要定义不同的代理类。

#### 动态代理（SpringAOP）
- jdk -> 只能代理接口，因为生成的代理类需要继承Proxy
- cglib -> 不能代理final类。 因为需要继承被代理类。所以不能被final修饰

两个核心的类：
- `java.lang.reflect.Proxy`
- `java.lang.reflect.InvocationHandler`

`proxy`类是用来创建代理对象。而`InvocationHandler`主要是用来处理执行逻辑

反编译后的代理类：
```java
public class $Proxy1 extends Proxy implements ISubject {
    private static Method m1;
    private static Method m2;
    private static Method m3;
    private static Method m0;

    public $Proxy1(InvocationHandler var1) throws  {
        super(var1);
    }

    public final boolean equals(Object var1) throws  {
        try {
            return ((Boolean)super.h.invoke(this, m1, new Object[]{var1})).booleanValue();
        } catch (RuntimeException | Error var3) {
            throw var3;
        } catch (Throwable var4) {
            throw new UndeclaredThrowableException(var4);
        }
    }

    public final String toString() throws  {
        try {
            return (String)super.h.invoke(this, m2, (Object[])null);
        } catch (RuntimeException | Error var2) {
            throw var2;
        } catch (Throwable var3) {
            throw new UndeclaredThrowableException(var3);
        }
    }

    public final void execute() throws  {
        try {
            super.h.invoke(this, m3, (Object[])null);
        } catch (RuntimeException | Error var2) {
            throw var2;
        } catch (Throwable var3) {
            throw new UndeclaredThrowableException(var3);
        }
    }

    public final int hashCode() throws  {
        try {
            return ((Integer)super.h.invoke(this, m0, (Object[])null)).intValue();
        } catch (RuntimeException | Error var2) {
            throw var2;
        } catch (Throwable var3) {
            throw new UndeclaredThrowableException(var3);
        }
    }

    static {
        try {
            m1 = Class.forName("java.lang.Object").getMethod("equals", new Class[]{Class.forName("java.lang.Object")});
            m2 = Class.forName("java.lang.Object").getMethod("toString", new Class[0]);
            m3 = Class.forName("com.crossoverjie.proxy.jdk.ISubject").getMethod("execute", new Class[0]);
            m0 = Class.forName("java.lang.Object").getMethod("hashCode", new Class[0]);
        } catch (NoSuchMethodException var2) {
            throw new NoSuchMethodError(var2.getMessage());
        } catch (ClassNotFoundException var3) {
            throw new NoClassDefFoundError(var3.getMessage());
        }
    }
}

```

可以看到代理类继承了 Proxy 类，并实现了 ISubject 接口，由此也可以看到 JDK 动态代理为什么需要实现接口，已经继承了 Proxy是不能再继承其余类了。

其中实现了 ISubject 的 execute() 方法，并通过 InvocationHandler 中的 invoke() 方法来进行调用的。

