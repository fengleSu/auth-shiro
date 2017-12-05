package com.viewhigh.vhsc.omapi.config;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.DispatcherType;

import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.cache.MemoryConstrainedCacheManager;
import org.apache.shiro.config.Ini;
import org.apache.shiro.config.Ini.Section;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.mgt.WebSecurityManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import com.viewhigh.vhsc.omapi.security.StatelessAuthcFilter;
import com.viewhigh.vhsc.omapi.security.realm.CredentialMatcher;
import com.viewhigh.vhsc.omapi.security.realm.StatelessToken;
import com.viewhigh.vhsc.omapi.security.realm.TokenAuthRealm;
import com.viewhigh.vhsc.omapi.security.realm.TokenCredentialMatcher;
import com.viewhigh.vhsc.support.config.ProfileNames;

@Configuration
public class SecurityConfig {

	private static final Logger LOGGER = LoggerFactory.getLogger(SecurityConfig.class);

	@Bean(name = "securityFilter")
	public ShiroFilterFactoryBean securityFilter() {
		ShiroFilterFactoryBean securityFilter = new ShiroFilterFactoryBean();
		securityFilter.getFilters().put("tokenAuth", statelessAuthFilter());
		securityFilter.setFilterChainDefinitionMap(filterChainDefinitions());
		securityFilter.setSecurityManager(securityManager());
		securityFilter.setUnauthorizedUrl("/auth/unauthrorized");

		return securityFilter;
	}
	
	@Profile({ProfileNames.DEFAULT, ProfileNames.DEV})
	@Bean
	public FilterRegistrationBean corsFilterRegistrationBean() {
		FilterRegistrationBean registrationBean = new FilterRegistrationBean();
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		CorsConfiguration config = new CorsConfiguration();
		config.setAllowCredentials(true);
		config.addAllowedOrigin("*");
		config.addAllowedHeader("*");
		config.addAllowedMethod("*");
		source.registerCorsConfiguration("/**", config);
		registrationBean.setFilter(new CorsFilter(source));
		registrationBean.setDispatcherTypes(DispatcherType.REQUEST);
		registrationBean.setOrder(1);
		return registrationBean;
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
			LOGGER.error(e.getMessage(), e);
		}
		return filterChainDefinitions;
	}

	@Bean
	public WebSecurityManager securityManager() {
		DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
		List<Realm> realms = new ArrayList<Realm>();
		realms.add(tokenAuthRealm());
		securityManager.setRealms(realms);
		return securityManager;
	}
	
	@Bean
	public TokenAuthRealm tokenAuthRealm() {
		TokenAuthRealm authRealm = new TokenAuthRealm();
		authRealm.setAuthenticationTokenClass(StatelessToken.class);
		authRealm.setCredentialsMatcher(tokenCredentialsMatcher());
		return authRealm;
	}

	@Bean
	public CredentialMatcher credentialsMatcher() {
		return new CredentialMatcher();
	}


	@Bean
	public TokenCredentialMatcher tokenCredentialsMatcher() {
		return new TokenCredentialMatcher();
	}

	@Bean
	public CacheManager securityCacheMananger() {
		return new MemoryConstrainedCacheManager();
	}

	@Bean
	public StatelessAuthcFilter statelessAuthFilter() {
		return new StatelessAuthcFilter();
	}

	@Bean
	public static LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
		return new LifecycleBeanPostProcessor();
	}
}
