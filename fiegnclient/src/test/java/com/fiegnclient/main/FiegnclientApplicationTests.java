package com.fiegnclient.main;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.fiegnclient.FiegnclientApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = FiegnclientApplication.class)
@WebAppConfiguration
public class FiegnclientApplicationTests {

	@Test
	public void contextLoads() {
	}

}
