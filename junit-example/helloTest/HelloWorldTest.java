/*************************************************************************
    > File Name: HelloWorldTest.java
    > Author: kinsang
    > Mail: 1995jiansheng@163.com 
    > Created Time: 2015年08月03日 星期一 21时03分14秒
 ************************************************************************/

import static org.junit.Assert.*;
import org.junit.Test;

public class HelloWorldTest {
    
    @Test
    public void testHello() {
        HelloWorld hi = new HelloWorld();
        hi.hello();
        String str = hi.getStr();
        assertEquals("Hello World!", str);
    }
}

