package com.china.study.annot.one;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName: AnnotConfigTest
 * @Description: TODO(学习注解的配置文件) 
 * @author: Jiuchuan.Shi
 * @Date: 2018年7月16日 下午3:24:57
 */


@Configuration  // 声明这个一个配置文件
/**
 * excludeFilters 要扫描的包，不包含那些包
 * includeFilters 要扫描的包，只包含那些包 如果让 只包含生效，要添加配置 useDefaultFilters = false
 * FilterType  排除规则 ANNOTATION是根据注解排除
 * classes 要排除那些类型
 */
//@ComponentScan(value = "com.china.study",excludeFilters = {
//		@Filter(type=FilterType.ANNOTATION, classes = {Controller.class,Service.class}),
//		@Filter(type=FilterType.CUSTOM,classes = {MyTypeFilterTest.class})
//})

/** 只包含哪些扫描的包
   @ComponentScan(value = "com.china.study",includeFilters = {
		@Filter(type=FilterType.ANNOTATION, classes = {Controller.class,Service.class})
   },useDefaultFilters = false)
*/

/**
 * 配置多个扫描文件
   @ComponentScans(
		value = {
			@ComponentScan(value = "com.china.study",includeFilters = {
					@Filter(type=FilterType.ANNOTATION, classes = {Controller.class,Service.class})
			},useDefaultFilters = false),
			
			@ComponentScan(value = "com.china.study",includeFilters = {
					@Filter(type=FilterType.ANNOTATION, classes = {Controller.class,Service.class})
			},useDefaultFilters = false)
		}
	)	
 */
@ComponentScan(basePackages="com.china.study")
public class AnnotConfigTest {
	
	private static final Logger logger = LoggerFactory.getLogger(AnnotConfigTest.class);
	
	/**
	 * 把实体 EntityTest 注入到Spring容器中
	 * @return EntityTest对象
	 */
	@Bean("entityTest")  // entityTest01是Bean在容器中的名称，不写名称，默认为entityTest
	public EntityTest entityTest(){
		logger.info("Annot ====>  实体-EntityTest 注入成功。。。");
		EntityTest et = new EntityTest(1, "第一个实体");
		return et;
		
	}

}
