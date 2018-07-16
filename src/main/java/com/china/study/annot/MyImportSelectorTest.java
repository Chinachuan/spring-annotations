package com.china.study.annot;

import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @ClassName: MyImportSelectorTest
 * @Description: TODO(自定义到返回的组件) 
 * @author: Jiuchuan.Shi
 * @Date: 2018年7月16日 下午8:14:34
 */
public class MyImportSelectorTest implements ImportSelector{

	/**
	 * importingClassMetadata 当前标注 @import 注解的所有的类的信息
	 */
	@Override
	public String[] selectImports(AnnotationMetadata importingClassMetadata) {
		// TODO Auto-generated method stub
		
		// 不能返回null
		return new String[]{"com.china.study.annot.ColorTest","com.china.study.annot.RedTest"};
	}

}
