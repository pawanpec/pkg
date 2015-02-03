package com.spedia.service;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;
@Service("socialServiceProvider")
public class SocialServiceProvider implements Serializable, ApplicationContextAware{
	private static final long serialVersionUID = 1L;
	private ApplicationContext ctx;

	private static Map<String, ISocialService> socialServiceProvidersMap = new HashMap<String, ISocialService>();
	
	public SocialServiceProvider() {}
	
	public ISocialService getInstanceForSocialService(String provider)
			throws Exception {
		if (socialServiceProvidersMap.containsKey(provider)) {
			return (ISocialService) socialServiceProvidersMap.get(provider);
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void setApplicationContext(ApplicationContext ctx)
			throws BeansException {
		this.ctx = ctx;
		Map<String, ISocialService> providersMap = ctx.getBeansOfType(ISocialService.class);
		if (providersMap.isEmpty()) {
			Error noProcessorError = new Error(
					"No Bean configured. Check Spring Context");
			throw noProcessorError;
		}
		Set<Entry<String, ISocialService>> processorEntrySet = providersMap
				.entrySet();
		Iterator<Entry<String, ISocialService>> iterator = processorEntrySet
				.iterator();

		while (iterator.hasNext()) {
			Entry<String, ISocialService> entry = iterator.next();
			socialServiceProvidersMap.put(entry.getValue().getProviderId(),
					entry.getValue());
		}
		
	}
}
