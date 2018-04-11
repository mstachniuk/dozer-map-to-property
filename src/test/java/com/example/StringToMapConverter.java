package com.example;

import java.util.Map;

import org.dozer.DozerConverter;

public class StringToMapConverter extends DozerConverter<Map, String> {

	public StringToMapConverter() {
		super(Map.class, String.class);
	}

	@Override
	public String convertTo(Map source, String destination) {
		System.out.println("source map: " + source);
		if (source != null) {
			return (String) source.get(getParameter());
		}
		return null;
	}

	@Override
	public Map convertFrom(String source, Map destination) {
		System.out.println("source str: " + source);
		destination.put(getParameter(), source);
		return destination;
	}
}