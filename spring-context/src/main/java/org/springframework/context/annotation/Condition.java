/*
 * Copyright 2002-2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.context.annotation;

import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * A single {@code condition} that must be {@linkplain #matches matched} in order
 * for a component to be registered.
 *
 * <p>Conditions are checked immediately before the bean-definition is due to be
 * registered and are free to veto registration based on any criteria that can
 * be determined at that point.
 *
 * <p>Conditions must follow the same restrictions as {@link BeanFactoryPostProcessor}
 * and take care to never interact with bean instances. For more fine-grained control of conditions that interact with {@code @Configuration} beans consider the
 * {@link ConfigurationCondition} interface.
 *
 *
 * 必须按照顺序匹配才能注册组件
 * <p>在bean定义到期之前立即检查条件，并且可以根据此时可以确定的任何标准自由否决注册。
 * <p>条件必须遵循与{@link BeanFactoryPostProcessor}
 * 相同的限制，并注意永远不要与bean实例交互。对于与{@code @Configuration} bean交互的条件的更精细控制
 *，请考虑
 * {@link ConfigurationCondition}接口。
 *
 * @author Phillip Webb
 * @since 4.0
 * @see ConfigurationCondition
 * @see Conditional
 * @see ConditionContext
 */
@FunctionalInterface
public interface Condition {

	/**
	 * Determine if the condition matches.
	 * @param context the condition context
	 * @param metadata metadata of the {@link org.springframework.core.type.AnnotationMetadata class}
	 * or {@link org.springframework.core.type.MethodMetadata method} being checked
	 * @return {@code true} if the condition matches and the component can be registered,
	 * or {@code false} to veto the annotated component's registration
	 *
	 * 确定条件是否匹配。
	 * @param context 条件上下文
	 * @param metadata 需要被检查的元数据{@link org.springframework.core.type.AnnotationMetadata 类}
	 * 或{@link org.springframework.core.type.MethodMetadata 方法} 、
	 * @return { @code true}如果条件匹配且组件可以注册，*或{@code false}否决注释组件的注册
	 */
	boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata);

}
