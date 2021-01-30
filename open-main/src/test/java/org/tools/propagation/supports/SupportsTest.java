package org.tools.propagation.supports;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.tools.main.propagation.required.RequiredServiceA;
import org.tools.propagation.PropagationBehaviorBaseTest;

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
