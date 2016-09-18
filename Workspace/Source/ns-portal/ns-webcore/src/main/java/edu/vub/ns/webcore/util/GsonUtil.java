package edu.vub.ns.webcore.util;


import com.google.common.collect.ImmutableList;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;

public class GsonUtil {
	
   // private static Logger _logger = Logger.getLogger(GsonUtil.class);
    private static Gson gson = new Gson();
	
    @SuppressWarnings({ "rawtypes", "unchecked", "finally" })
	public synchronized static Object parseObject(String json, Class clazz)
    {
    	//gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ").create();
        Object obj = null;
        try
        {
            obj = gson.fromJson(json, clazz);
        }
        catch(Exception e)
        {
           // _logger.error("An Exception occured while parse Object : ", e);
            e.printStackTrace();
        }
        finally
        {
            return obj;
        }
    }
	
    @SuppressWarnings({ "rawtypes", "unchecked", "finally" })
	public synchronized static Object parseImmutableObject(String json, Class clazz)
    {
    	
    	final Gson gson = new GsonBuilder()
    		    .registerTypeAdapter(ImmutableList.class,new UnivergeJsonDeserializer())
    		    .create();
    	
        Object obj = null;
        try
        {
            obj = gson.fromJson(json, clazz);
        }
        catch(Exception e)
        {
            //_logger.error("An Exception occured while parse Object : ", e);
            e.printStackTrace();
        }
        finally
        {
            return obj;
        }
    }
    
    @SuppressWarnings("finally")
	public synchronized static String getJson(Object obj)
    {
        String jsonString = null;
        try
        {
            jsonString = gson.toJson(obj);
        }
        catch(Exception e)
        {
           // _logger.error("An Exception occured while get JSON String from any Object : ", e);
        }
        finally
        {
            return jsonString;
        }
    }
	
    @SuppressWarnings("finally")
	public synchronized static JsonElement toJsonTree(Object obj)
    {
        JsonElement jsonString = null;
        try
        {
            jsonString = gson.toJsonTree(obj);
        }
        catch(Exception e)
        {
            //_logger.error("An Exception occured while get JSON Element from any Object : ", e);
        }
        finally
        {
            return jsonString;
        }
    }
    	
}
