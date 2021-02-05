package org.open.boot.propagation.supports;

import org.junit.Test;
import org.open.boot.propagation.PropagationBehaviorBaseTest;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author barnak
 */
public class SupportsTest extends PropagationBehaviorBaseTest {

    @Autowired
    private SupportsServiceA methodA;

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
