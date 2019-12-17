package com.sf;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
	public static void main(String[] args) {

		AnnotationConfigApplicationContext  applicationContext=new AnnotationConfigApplicationContext(TestConfig.class);
		System.out.println(applicationContext.getBean(ModelA.class));
	}
}
