package org.hubotek.web.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import org.hubotek.HubotekException;

public class InputDateConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
		Object test = null;
		try {
			if (!value.isEmpty())
				test = new SimpleDateFormat("yyyy-MM-dd").parse(value);
		} catch (ParseException e) {
			throw new HubotekException(e);
		}
		return test;
	}


	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		return new SimpleDateFormat("yyyy-MM-dd").format((Date)Optional.ofNullable(value).orElse(null));
	}

}
