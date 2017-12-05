package com.fl.auth.authshiro.config;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.apache.shiro.config.Ini;
import org.apache.shiro.config.Ini.Section;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.mgt.WebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

@Configuration
public class SecurityConfig {

	@Bean(name = "securityFilter")
	public ShiroFilterFactoryBean securityFilter() {
		ShiroFilterFactoryBean securityFilter = new ShiroFilterFactoryBean();
		securityFilter.setFilterChainDefinitionMap(filterChainDefinitions());
		securityFilter.setSecurityManager(securityManager());

		return securityFilter;
	}

	@Bean(name = "filterChainDefinitions")
	public Map<String, String> filterChainDefinitions() {
		Map<String, String> filterChainDefinitions = new LinkedHashMap<>();
		try (InputStream inputStream = new ClassPathResource("/shiro.ini").getInputStream()) {
			Ini ini = new Ini();
			ini.load(inputStream);
			Section section = ini.getSection("urls");
			Set<Entry<String, String>> set = section.entrySet();
			for (Entry<String, String> entry : set) {
				filterChainDefinitions.put(entry.getKey(), entry.getValue());
			}
		} catch (Exception e) {
		}
		return filterChainDefinitions;
	}

	@Bean
	public WebSecurityManager securityManager() {
		DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
		return securityManager;
	}

	@Bean
	public static LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
		return new LifecycleBeanPostProcessor();
	}
}
