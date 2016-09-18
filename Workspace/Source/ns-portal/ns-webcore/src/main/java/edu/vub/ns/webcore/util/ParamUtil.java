package edu.vub.ns.webcore.util;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import com.google.common.base.Joiner;

public class ParamUtil {
    
    @SuppressWarnings("rawtypes")
	public synchronized static Object[] getParams(Object obj) throws Exception
    {
        List<Object> params = new ArrayList<Object>();
        for (Field f : obj.getClass().getDeclaredFields())
        {
            f.setAccessible(true);
            Class type = f.getType();
            Object value = f.get(obj);
            if(!type.isPrimitive() && value == null)
            {
                continue;
            }
            else if(type.isPrimitive() && type == boolean.class && Boolean.FALSE.equals(value))
            {
                continue;
            }
            else if(type.isPrimitive() && type == Number.class &&((Number) value).doubleValue() == 0)
            {
                continue;
            }
            params.add(value);
        }
        return params.toArray();
    }
    
    @SuppressWarnings("rawtypes")
	public synchronized static Object[] getParamsWithAdditional(Object obj, String extValue) throws Exception
    {
        List<Object> params = new ArrayList<Object>();
        for (Field f : obj.getClass().getDeclaredFields())
        {
            f.setAccessible(true);
            Class type = f.getType();
            Object value = f.get(obj);
            if(!type.isPrimitive() && value == null)
            {
                continue;
            }
            else if(type.isPrimitive() && type == boolean.class && Boolean.FALSE.equals(value))
            {
                continue;
            }
            else if(type.isPrimitive() && type == Number.class &&((Number) value).doubleValue() == 0)
            {
                continue;
            }
            params.add(value);
        }
        params.add(extValue);
        return params.toArray();
    }
    
    public synchronized static Object[] getParamsWithoutObject(Object...obj)
    {
        return obj;
    }
    
    public synchronized static String getOids(String[] oids)
    {
        StringBuffer oid = new StringBuffer();
        oid.append("'");
        oid.append(Joiner.on("','").join(oids));
        oid.append("'");
        return oid.toString();
    }
    
}
