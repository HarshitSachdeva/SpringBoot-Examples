package com.harshit.springjenkins;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class SpringJenkinsApplicationTests {

	public static Logger logger=  LoggerFactory.getLogger(SpringJenkinsApplicationTests.class);

	@Test
	contextLoads() {
		logger.info("Test case are executing");
		logger.info("Test case are executing for jenkins");
		assertEquals(true,true);
	}

}
