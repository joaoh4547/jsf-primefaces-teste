package com.teste.testejsf.app;

import org.hibernate.validator.messageinterpolation.ResourceBundleMessageInterpolator;
import org.hibernate.validator.resourceloading.PlatformResourceBundleLocator;

public class MessageInterpolator extends ResourceBundleMessageInterpolator {

	private final jakarta.validation.MessageInterpolator clientInterpolator;
	private final jakarta.validation.MessageInterpolator defaultInterpolator;

	public MessageInterpolator() {
		this.clientInterpolator = new ResourceBundleMessageInterpolator(new AppResourceBundleLocator());
		this.defaultInterpolator = new ResourceBundleMessageInterpolator(new PlatformResourceBundleLocator("messages"));
	}

	@Override
	public String interpolate(String messageTemplate, Context context) {
		String result = clientInterpolator.interpolate(messageTemplate, context);

		// Se não resolver (retorna o template mesmo), tenta no default
		if (result.equals(messageTemplate)) {
			result = defaultInterpolator.interpolate(messageTemplate, context);
		}

		return result;
	}
	
	@Override
    public String interpolate(String messageTemplate, Context context, java.util.Locale locale) {
        String result = clientInterpolator.interpolate(messageTemplate, context, locale);

        if (result.equals(messageTemplate)) {
            result = defaultInterpolator.interpolate(messageTemplate, context, locale);
        }

        return result;
    }
}
