package org.tools.common;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author barnak
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@PropertySource("classpath:application-test.yml")
public class CommonApplicationTests {

}
