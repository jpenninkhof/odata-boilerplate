package com.penninkhof.odata.utils;

import java.util.Locale;
import java.util.ResourceBundle;

import org.apache.olingo.odata2.api.processor.ODataContext;

public class ODataContextUtil {

	private static ThreadLocal<ODataContext> oDataContext = new ThreadLocal<ODataContext>(); 
	
	public static void setODataContext(ODataContext c) {
		oDataContext.set(c);
	}
	
	public static ODataContext getODataContext() {
		return oDataContext.get();
	}
	
	public static ResourceBundle getResourceBundle(String name) {
		ResourceBundle i18n = null;
		if (oDataContext.get() != null) {
	 		for (Locale locale : oDataContext.get().getAcceptableLanguages()) {
				i18n = ResourceBundle.getBundle(name, locale);
				if (i18n.getLocale().equals(locale)) break;
			}
			return i18n;
		} else {
			return null;
		}
	}
}
