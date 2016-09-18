package edu.vub.ns.webcore.util;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import sun.reflect.generics.reflectiveObjects.ParameterizedTypeImpl;

import com.google.common.collect.ImmutableList;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

public class UnivergeJsonDeserializer implements JsonDeserializer<ImmutableList<?>> {

	@Override
	public ImmutableList<?> deserialize(JsonElement json, Type type, JsonDeserializationContext conext)
			throws JsonParseException {
		final Type type2 = ParameterizedTypeImpl.make(List.class, ((ParameterizedType) type).getActualTypeArguments(), null);
		final List<?> list = conext.deserialize(json, type2);
		return ImmutableList.copyOf(list);
	}

    
}
