package org.open.boot.throwable;

/**
 * @author barnak
 */
public class ThrowableSource {

    public static void main(String[] args) {
        try {
            testThrowable();
        } catch (Throwable throwable) {
            System.out.println("抛出的信息：" + throwable.getMessage());
            System.out.println("捕获的对象：" + throwable);
            throwable.printStackTrace();//打印信息的堆栈信息
        }
    }

    private static void testThrowable() throws Throwable {
        Throwable t = new Throwable("错误信息");

        Throwable t2 = new Throwable("错误信息2",t);
        throw t2;
    }
}
