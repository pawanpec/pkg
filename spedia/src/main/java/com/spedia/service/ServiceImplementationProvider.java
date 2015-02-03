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

import com.spedia.service.OAuthProviderService;

@Service("serviceImplementationProvider")
public class ServiceImplementationProvider implements Serializable,
		ApplicationContextAware {
	private static final long serialVersionUID = 1591964054532128601L;
	private static Map<String, OAuthProviderService> serviceProvidersMap = new HashMap<String, OAuthProviderService>();
	private ApplicationContext ctx;

	public ServiceImplementationProvider() {}

	public OAuthProviderService getInstanceForSocialParser(String provider)
			throws Exception {
		if (serviceProvidersMap.containsKey(provider)) {
			return (OAuthProviderService) serviceProvidersMap.get(provider);
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void setApplicationContext(ApplicationContext ctx) throws BeansException {
		this.ctx = ctx;
		Map<String, OAuthProviderService> providersMap = ctx.getBeansOfType(OAuthProviderService.class);
		if (providersMap.isEmpty()) {
			Error noProcessorError = new Error("No Bean configured. Check Spring Context");
			throw noProcessorError;
		}
		Set<Entry<String, OAuthProviderService>> processorEntrySet = providersMap.entrySet();
		Iterator<Entry<String, OAuthProviderService>> iterator = processorEntrySet.iterator();

		while (iterator.hasNext()) {
			Entry<String, OAuthProviderService> entry = iterator.next();
			serviceProvidersMap.put(entry.getValue().getProviderId(),entry.getValue());
		}
	}
}
