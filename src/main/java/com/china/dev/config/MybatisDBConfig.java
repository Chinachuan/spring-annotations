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
@MapperScan(basePackages = {"com.china.dao"}, sqlSessionFactoryRef = "sqlSessionFactory")
public class MybatisDBConfig {
	
	private static final String MAPPER_LOCATION = "classpath:sqlmap/**/*.xml";

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
