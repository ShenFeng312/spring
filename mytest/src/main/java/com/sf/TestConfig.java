package com.sf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@ComponentScan("com.sf")
public class TestConfig {
	@Autowired
	ModelA modelA;
}
