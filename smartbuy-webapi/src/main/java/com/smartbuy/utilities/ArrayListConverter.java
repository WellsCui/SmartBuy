package com.smartbuy.utilities;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.GenericConverter;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.smartbuy.entities.Shopping;

public class ArrayListConverter implements GenericConverter {

	Set<ConvertiblePair> pairs;
	public ArrayListConverter()
	{
		pairs=new HashSet<>();		
		
		pairs.add(new ConvertiblePair((new ArrayList<String>()).getClass(),String.class));
	}
	
	@Override
	public Set<ConvertiblePair> getConvertibleTypes() {		
		return pairs;
	}

	@Override
	public Object convert(Object source, TypeDescriptor sourceType,
			TypeDescriptor targetType) {
		// TODO Auto-generated method stub
		final OutputStream out = new ByteArrayOutputStream();
	    final ObjectMapper mapper = new ObjectMapper();

	    try {
			mapper.writeValue(out, source);
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	    
	    
		return out.toString();
	}

}
