package com.fl.auth.authshiro.config;

import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.fl.auth.authshiro.security.realm.CredentialMatcher;
import com.fl.auth.authshiro.security.realm.UsernamePasswordRealm;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.cache.MemoryConstrainedCacheManager;
import org.apache.shiro.config.Ini;
import org.apache.shiro.config.Ini.Section;
import org.apache.shiro.session.mgt.eis.EnterpriseCacheSessionDAO;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.mgt.WebSecurityManager;
import org.apache.shiro.web.servlet.ShiroHttpSession;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
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
		securityFilter.setSuccessUrl("/");
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
		securityManager.setRealm(usernamePasswordRealm());
		return securityManager;
	}

	@Bean
	public UsernamePasswordRealm usernamePasswordRealm() {
		UsernamePasswordRealm authRealm = new UsernamePasswordRealm();
		authRealm.setCredentialsMatcher(credentialsMatcher());
		return authRealm;
	}

	@Bean
	public CredentialMatcher credentialsMatcher() {
		return new CredentialMatcher();
	}

	@Bean
	public DefaultWebSessionManager sessionManager() {
		DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
		sessionManager.setGlobalSessionTimeout(3600000L);
		sessionManager.setSessionDAO(new EnterpriseCacheSessionDAO());
		sessionManager.setCacheManager(securityCacheMananger());
		SimpleCookie cookie = new SimpleCookie(ShiroHttpSession.DEFAULT_SESSION_ID_NAME);
		cookie.setSecure(true);
		sessionManager.setSessionIdCookie(cookie);
		return sessionManager;
	}

	@Bean
	public CacheManager securityCacheMananger() {
		return new MemoryConstrainedCacheManager();
	}

	@Bean
	public static LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
		return new LifecycleBeanPostProcessor();
	}
}
