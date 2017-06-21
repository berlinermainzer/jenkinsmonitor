package de.felten.jenkinsmonitor.backing;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter("customLocalDateTimeConverter")
public class LocalDateTimeConverter implements Converter {

	final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM. HH:MM:ss", new Locale("de"));

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		return LocalDateTime.parse(value, formatter);
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		LocalDateTime dateTime = (LocalDateTime) value;
		return dateTime.format(formatter).toString();
	}

}
