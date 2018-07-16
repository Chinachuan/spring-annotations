package com.china.study.annot;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @ClassName: SysWinConditional
 * @Description: TODO(判断是不是window系统) 
 * @author: Jiuchuan.Shi
 * @Date: 2018年7月16日 下午7:42:14
 */
public class SysWinConditional implements Condition{

	@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		Environment environment = context.getEnvironment();
		String property = environment.getProperty("os.name");
		if(property.contains("Windows")){
			return true;
		}
		return false;
	}

}
