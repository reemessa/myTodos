package com.issareem.mytodoapp.util;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import javax.faces.context.FacesContext;


/**
 * 
 * 
 * @author Reem Issa
 * @class_name MessageUtils.java
 * @class_description
 * @create_date Aug 27, 2023
 */
public class MessageUtils {

	private static String BUNDLE = "messages";

	
	public static String getMessage(String label) {
		ResourceBundle labels = null;
		try {
			labels = getBundle(BUNDLE, getLocale());
			validateResource(labels);
		} catch (MissingResourceException e) {
			throw new IllegalArgumentException(e);
		}

		return labels.getString(label);
	}

	
	public static String getMessage(String label, Object[] params) {
		ResourceBundle labels = null;
		try {
			labels = getBundle(BUNDLE, getLocale());
			validateResource(labels);
		} catch (MissingResourceException e) {
			throw new IllegalArgumentException(e);
		}

		return MessageFormat.format(labels.getString(label), params);

	}

	private static void validateResource(ResourceBundle labels) {
		if (labels == null) {
			throw new NullPointerException();
		}
	}

	public static ResourceBundle getBundle(String bundle, Locale locale) {
		return ResourceBundle.getBundle(bundle, locale);
	}

	public static Locale getLocale() {
		Locale locale = null;
		FacesContext context = FacesContext.getCurrentInstance();
		if (isContextNotNull(context)) {
			locale = context.getViewRoot().getLocale();
			locale = setLocaleNullToDefault(locale);
		} else {
			locale = getDefaultLocale();
		}
		return locale;
	}

	private static Locale setLocaleNullToDefault(Locale locale) {
		if (isLocaleNull(locale)) {
			return getDefaultLocale();
		}
		return locale;
	}

	private static Locale getDefaultLocale() {
		return Locale.getDefault();
	}

	private static boolean isLocaleNull(Locale locale) {
		return locale == null;
	}

	private static boolean isContextNotNull(FacesContext context) {
		return context != null && context.getViewRoot() != null;
	}
}
