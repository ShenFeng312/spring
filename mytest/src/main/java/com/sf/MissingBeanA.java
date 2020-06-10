package com.sf;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.*;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class MissingBeanA  implements Condition, ConfigurationCondition {
	@Bean
	@Conditional({MissingBeanA.class})
	public BeanA beanB(){
		BeanA beanA=new BeanA();
		beanA.setName("beanB");
		System.out.println("beanB createing");
		return beanA;
	}
	@Bean
	public BeanA beanA(){
		BeanA beanA=new BeanA();
		beanA.setName("beanA");
		System.out.println("beanA createing");
		return beanA;
	}


	@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		BeanDefinition beanA = context.getBeanFactory().getBeanDefinition("beanA");
		if (beanA==null){
			System.out.println("beanB need create");
			return true;

		}
		System.out.println("beanB cant create");
		return false;
	}

	@Override
	public ConfigurationPhase getConfigurationPhase() {
		return ConfigurationPhase.REGISTER_BEAN;
}
}
