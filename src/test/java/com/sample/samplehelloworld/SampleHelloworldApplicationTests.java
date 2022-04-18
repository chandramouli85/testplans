package com.sample.samplehelloworld;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@Tag("qa")
@SpringBootTest
public class SampleHelloworldApplicationTests {

	@Test
	void contextLoads() {
		System.out.println("automation test method");
	}
}
