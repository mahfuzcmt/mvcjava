package edu.vub.ns.webcore.dao;


import java.util.List;

import org.springframework.transaction.PlatformTransactionManager;


public interface SpringJdbcDao {

    public void saveObject(String sql, Object[] obj) throws Exception;
    
    @SuppressWarnings("rawtypes")
	public Object getObject(String sql, Object[] params, Class clazz) throws Exception;
    
    @SuppressWarnings("rawtypes")
	public List getObjectList(String sql, Object[] params, Class clazz) throws Exception;
    
    @SuppressWarnings("rawtypes")
	public List getPrimitiveList(String sql, Object[] params, Class clazz) throws Exception;
    
    public void deleteObject(String sql, Object[] obj) throws Exception;
    
    public void updateObject(String sql, Object[] obj) throws Exception;
        
    public long count(String sql, Object[] params) throws Exception;
    
    public void saveObjectList(List<String> sql, List<Object[]> obj) throws Exception;
    
    public void executeSql(String sql) throws Exception;
    
    public int getRowCount(String sql) throws Exception;
    
    public long getMaxValue(String sql) throws Exception;
    
    public PlatformTransactionManager getTransactionManager();

}