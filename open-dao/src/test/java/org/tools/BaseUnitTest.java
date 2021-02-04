package org.tools;

import junit.textui.TestRunner;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author barnak
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = TestRunner.class)
@MapperScan(basePackages = {"org.tools.dao.*.impl"})
@ActiveProfiles("dao-test")
@SpringBootApplication
public class BaseUnitTest {
}
