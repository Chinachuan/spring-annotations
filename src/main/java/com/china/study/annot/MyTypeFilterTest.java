package com.china.study.annot;

import java.io.IOException;

import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

/**
 * @ClassName: MyTypeFilterTest
 * @Description: TODO(自定义包的扫描范围) 
 * @author: Jiuchuan.Shi
 * @Date: 2018年7月16日 下午6:03:19
 */
public class MyTypeFilterTest implements TypeFilter {

	/**
	 * metadataReader 读取到当前正在扫描类的信息
	 * metadataReaderFactory 可以获取到其他任何类的信息
	 */
	@Override
	public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory)
			throws IOException {
		// 获取当前类注解的信息
		AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();
		//获取当前正在扫描类的信息
		ClassMetadata classMetadata = metadataReader.getClassMetadata();
		// 获取当前类资源的信息（类的路径）
		Resource resource = metadataReader.getResource();
		// 扫描类的类名
		String className = classMetadata.getClassName();
		System.out.println("这是类名：==>" + className);
		System.out.println("类的相关信息==>" + annotationMetadata +","+ resource);
		boolean flag = false;
		// 如果类名包含test,返回true
		if(className.contains("test")){
			flag = true;
		}else{
			flag = true;
		}
		
		// 如果返回值为false,表示都不包含
		return flag;
	}

	

}
