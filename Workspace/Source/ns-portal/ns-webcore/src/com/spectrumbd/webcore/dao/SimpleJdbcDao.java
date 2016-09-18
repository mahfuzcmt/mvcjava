package com.spectrumbd.webcore.dao;


import java.util.List;


public interface SimpleJdbcDao {

    @SuppressWarnings("rawtypes")
	public void saveObjectList(String sql, List entityList) throws Exception;
    
    public boolean saveObject(Object obj, String tableName);
    
}