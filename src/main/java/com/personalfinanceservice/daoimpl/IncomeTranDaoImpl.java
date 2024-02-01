package com.personalfinanceservice.daoimpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Component;

import com.personalfinanceservice.config.ConnectionConfig;
import com.personalfinanceservice.dao.IncomeTranDao;
import com.personalfinanceservice.model.IncomeTranModel;
import com.personalfinanceservice.query.IncomeQuery;

@Component
public class IncomeTranDaoImpl implements IncomeTranDao{

	@Autowired
	JdbcTemplate trandb; 
	
	@Autowired
	IncomeQuery incomeQuery;
	
	@Autowired
	ConnectionConfig connection;
		
	Logger logger  = LoggerFactory.getLogger(getClass());
		
	@Override
	public List<IncomeTranModel> getIncomeTransaction() {
		try {
			
			return trandb.query(incomeQuery.getIncomeTran(), BeanPropertyRowMapper.newInstance(IncomeTranModel.class));
			
		} catch (Exception e) {
			logger.info("ERROR IN Get IncomeTransaction "+e.getMessage());
			return null;
		}

	}

	@Override
	public IncomeTranModel getIncomeTransactionbyTrankey(String trankey) {
		try {
			return trandb.queryForObject(incomeQuery.getIncometranbyTrankey(trankey),
					BeanPropertyRowMapper.newInstance(IncomeTranModel.class));
		} catch (Exception e) {
			logger.info("ERROR in Get IncomeTransaction "+e.getMessage());
			return null;
		}
		
	}

	@Override
	public IncomeTranModel saveIncomeTransaction(IncomeTranModel incometranmodel) {
		try {
			
		SimpleJdbcCall jdbc = new SimpleJdbcCall(trandb);
		jdbc.setProcedureName("sp_createIncomeTransaction");
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("description_param", incometranmodel.getDescription());
		map.put("account_param", incometranmodel.getAccountCode());
		map.put("incomename_param", incometranmodel.getIncomeCode());
		map.put("amount_param", incometranmodel.getAmount());
		map.put("trandate_param", incometranmodel.getTrandate());
		
		jdbc.execute(map);
		
		return incometranmodel;
		} catch (Exception e) {
			logger.info("Error in Save "+e.getMessage());
			return null;
		}
	}
	@Override
	public String updateIncomeTransaction(IncomeTranModel incometranmodel){		
		try {
			
			trandb.execute(incomeQuery.updateIncometranbyTrankey(incometranmodel));
			return "Updated Successfully";
			
		} catch (Exception e) {
			logger.info("Error in Save "+e.getMessage());
			return "NOT Updated";
		}
		
		
		
	}

}
