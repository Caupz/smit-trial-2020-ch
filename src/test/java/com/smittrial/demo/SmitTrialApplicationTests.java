package com.smittrial.demo;

import com.smittrial.demo.service.LogServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.runners.JUnit4;

import static org.springframework.test.util.AssertionErrors.fail;

@SpringBootTest
/*@ContextConfiguration(classes = {
		LogServiceImpl.class
})*/
//@ContextConfiguration(locations = {"/applicationContext.xml"})
@RunWith(JUnit4.class)
@EnableConfigurationProperties
class SmitTrialApplicationTests {
	@Test
	void testLibrarySummary() {
		SmitTrialApplication app = new SmitTrialApplication();
		app.getLibrarySummary();
	}


}
