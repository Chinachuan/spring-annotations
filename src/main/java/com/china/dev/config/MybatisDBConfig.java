package com.china.dev.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
/**
 * @ClassName: MybatisDBConfig
 * @Description: TODO(数据源配置) 
 * @author: Jiuchuan.Shi
 * @Date: 2018年7月13日 上午10:03:07
 */
@Configuration
@MapperScan(basePackages = {"com.china.dev.dao"}, sqlSessionFactoryRef = "sqlSessionFactory")
public class MybatisDBConfig {
	
	private static final String MAPPER_LOCATION = "classpath:sqlmap/**/*.xml";
	
	/**
	 * 	@Autowired 加载原理
	 *    默认按照类型，去容器中找相应的组件，然后赋值
	 *    如果存在多少多个类型相同的Bean,则再将Bean的名字做为ID，去容器中查找，然后再赋值
	 *    
	 *    只要使用了@Autowired自动装配，就一定要把属性赋值好，如果没有就会报错, 但如果声明了
	 *    @Autowired(required=false) 即不是必须赋值装配，就不会报错了
	 *    
	 *    @Qualifier("XXX") 注解是指定加载哪一个组件
	 *    @Primary 让Spring自动装配的时候，默认使用首选的bean
	 *        也可以使用@Qualifier 指定装配的组件的名称
	 *        
	 *    @Resource(name="primaryDataSource") spring支持是JSR250和 JSR330 java注解的规范
	 *    @Inject  需要导入相应的jar包，和@Autowired功能一样，也是java的规范
	 */

	@Autowired
	@Qualifier("primaryDataSource")
	private DataSource primaryDataSource;


	@Bean(name = "primaryDataSource")
	@ConfigurationProperties(prefix = "spring.datasource")
	public DataSource primaryDataSource() {
		return DataSourceBuilder.create().build();
	}


	@Bean(name = "sqlSessionFactory")
	public SqlSessionFactory sqlSessionFactory() throws Exception {
		SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
		factoryBean.setDataSource(primaryDataSource);
		PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		factoryBean.setMapperLocations(resolver.getResources(MAPPER_LOCATION));
		return factoryBean.getObject();

	}

	@Bean(name = "transactionManager")
	@Primary
	public DataSourceTransactionManager masterTransactionManager() {
		return new DataSourceTransactionManager(primaryDataSource);
	}
	
	

}
