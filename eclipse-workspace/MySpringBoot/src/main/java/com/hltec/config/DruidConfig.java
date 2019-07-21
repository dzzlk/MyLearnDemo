package com.hltec.config;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
/**
 * 数据源自定义配置类：这里spring boot默认采用的数据源是HikariDataSource，我们改变数据源为
 * Druid数据源然后使application.yml里面配置的Druid数据源各项属性都生效比如initialSize及之后的属性
 * @author dzzlk
 * 运行MySpringBootApplicationTests测试类可能会报错：
 *   Caused by: java.lang.ClassNotFoundException: org.apache.log4j.Priority
 * 所以备注 pom.xml文件中可能需要加入如图下依赖：
 * 	   <dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-configuration-processor</artifactId>
			<optional>true</optional>
		</dependency>
		<!-- https://mvnrepository.com/artifact/org.slf4j/log4j-over-slf4j -->
		<dependency>
		    <groupId>org.slf4j</groupId>
		    <artifactId>log4j-over-slf4j</artifactId>
		 </dependency>
 * 
 *
 */
@Configuration
public class DruidConfig {
	
	@ConfigurationProperties(prefix="spring.datasource")
	@Bean
	public DataSource druid() {
		return new DruidDataSource();
	}
	
	//配置Druid的监控
    //1、配置一个管理后台的Servlet
    @Bean
    public ServletRegistrationBean statViewServlet(){
        ServletRegistrationBean bean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
        Map<String,String> initParams = new HashMap<>();

        initParams.put("loginUsername","admin");
        initParams.put("loginPassword","123456");
        initParams.put("allow","");//默认就是允许所有ip(包括localhost)访问
        initParams.put("deny","192.168.15.21");//拒绝192.168.15.21访问

        bean.setInitParameters(initParams);
        return bean;
    }
    
  //2、配置一个web监控的filter：然后启动项目后浏览器输入http://localhost:8081/druid/并用上面的用户名密码就可以登陆druid数据源监控的后台，然后
//    可以请求系统的另一个controller：http://localhost:8081/query，这样就可以在这个监控后台SQL监控里面看到相关数据库SQL的执行情况，还可以到web应用下去看看
    @Bean
    public FilterRegistrationBean webStatFilter(){
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new WebStatFilter());

        Map<String,String> initParams = new HashMap<>();
        initParams.put("exclusions","*.js,*.css,/druid/*");

        bean.setInitParameters(initParams);

        bean.setUrlPatterns(Arrays.asList("/*"));

        return  bean;
    }

}
