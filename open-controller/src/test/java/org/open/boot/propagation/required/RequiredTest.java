package org.open.boot.propagation.required;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.open.boot.propagation.PropagationBehaviorBaseTest;

/**
 * @author barnak
 */
public class RequiredTest extends PropagationBehaviorBaseTest {

    @Autowired
    private RequiredServiceA methodA;

    @Test
    public void testNonTry() {
        methodA.nonTry();
    }

    @Test
    public void testInsideTry() {
        methodA.insideTry();
    }

    @Test
    public void testOutsideTry() {
        methodA.outsideTry();
    }

}
