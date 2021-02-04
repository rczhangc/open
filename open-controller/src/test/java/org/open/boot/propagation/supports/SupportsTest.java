package org.open.boot.propagation.supports;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.open.boot.propagation.required.RequiredServiceA;
import org.open.boot.propagation.PropagationBehaviorBaseTest;

/**
 * @author barnak
 */
public class SupportsTest extends PropagationBehaviorBaseTest {

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
