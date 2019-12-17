package com.sf;

import org.springframework.beans.BeansException;
import org.springframework.beans.support.PropertyComparator;
import org.springframework.beans.support.SortDefinition;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.util.StringUtils;

import java.util.List;

public class ConditionTest implements Condition {
	@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		metadata.getAnnotations().forEach(it-> System.out.println(it));

		return  false;
	}
	public static void sort(List<?> source, SortDefinition sortDefinition) throws BeansException {
		if (StringUtils.hasText(sortDefinition.getProperty())) {
			source.sort(new PropertyComparator<>(sortDefinition));
		}
	}
}
