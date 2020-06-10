package com.sf;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.concurrent.*;

public class Test {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext=new AnnotationConfigApplicationContext(MissingBeanA.class);
		applicationContext.getBean("beanA");
	}
}
