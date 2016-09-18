package edu.vub.ns.webcore.dao.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.cglib.beans.BeanMap;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import edu.vub.ns.webcore.dao.SimpleJdbcDao;

public class SimpleJdbcDaoImpl extends JdbcDaoSupport implements SimpleJdbcDao {

    @SuppressWarnings("rawtypes")
    public void saveObjectList(String sql, List entityList) throws Exception {
        try {
            //String sql = "INSERT INTO CUSTOMER (CUST_ID, NAME, AGE) VALUES (:custId, :name, :age)";
            //SqlParameterSource[] params = SqlParameterSourceUtils.createBatch(entityList.toArray());             
            //getSimpleJdbcTemplate().batchUpdate(sql, params);
            getJdbcTemplate().batchUpdate(sql, entityList);
        } catch (Exception e) {
            throw new Exception(e);
        }
    }
	
	@SuppressWarnings("unchecked")
	private HashMap<String, Object> getBeanMap(Object obj) {
		HashMap<String, Object> map = new HashMap<>();
		map.putAll(BeanMap.create(obj));
		return map;
	}
	
	@Override
	public boolean saveObject(Object obj, String tableName) {
		HashMap<String, Object> map = getBeanMap(obj);
		SimpleJdbcInsert simpleInsert = new SimpleJdbcInsert(getJdbcTemplate());
		simpleInsert.setTableName(tableName);
		int rowsInserted = simpleInsert.execute(map);
		return rowsInserted == 1;
	}
    
}
