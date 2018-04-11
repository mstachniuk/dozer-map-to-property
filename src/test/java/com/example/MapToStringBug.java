package com.example;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.dozer.DozerBeanMapperBuilder;
import org.dozer.Mapper;
import org.junit.Test;

public class MapToStringBug {

	@Test
	public void shouldMapMapToString() {
		// given
		Map<String, String> map = new HashMap<>();
		map.put("myProperty", "myValue");
		ClassA source = new ClassA();
		source.setProperties(map);
		Mapper mapper = DozerBeanMapperBuilder.create()
				.withMappingBuilder(new MyMappingBuilder())
				.build();

		// when
		ClassB result = mapper.map(source, ClassB.class);

		// then
		assertEquals("myValue", result.getMyProperty());
	}

}

