package com.example;

import static org.dozer.loader.api.FieldsMappingOptions.customConverter;

import org.dozer.loader.api.BeanMappingBuilder;

public class MyMappingBuilder extends BeanMappingBuilder {
	@Override
	protected void configure() {
		mapping(ClassA.class, ClassB.class)
				.fields("text", "text")
				.fields("properties", "myProperty", customConverter(StringToMapConverter.class, "abc"));
	}

}