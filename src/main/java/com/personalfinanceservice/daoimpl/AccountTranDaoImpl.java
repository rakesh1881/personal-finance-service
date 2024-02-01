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
import com.personalfinanceservice.dao.AccountTranDao;
import com.personalfinanceservice.model.AccountTranModel;
import com.personalfinanceservice.query.AccountQuery;

@Component
public class AccountTranDaoImpl implements AccountTranDao{

	@Autowired
	JdbcTemplate trandb; 
	
	@Autowired
	AccountQuery accountQuery;
	
	@Autowired
	ConnectionConfig connection;
		
	Logger logger  = LoggerFactory.getLogger(getClass());
		
	@Override
	public List<AccountTranModel> getAccountTransaction() {
		try {
			
			return trandb.query(accountQuery.getAccountTran(), BeanPropertyRowMapper.newInstance(AccountTranModel.class));
			
		} catch (Exception e) {
			logger.info("ERROR IN Get AccountTransaction "+e.getMessage());
			return null;
		}

	}

	@Override
	public AccountTranModel getAccountTransactionbyTrankey(String trankey) {
		try {
			return trandb.queryForObject(accountQuery.getAccounttranbyTrankey(trankey),
					BeanPropertyRowMapper.newInstance(AccountTranModel.class));
		} catch (Exception e) {
			logger.info("ERROR in Get AccountTransaction "+e.getMessage());
			return null;
		}
		
	}

	@Override
	public AccountTranModel saveAccountTransaction(AccountTranModel accounttranmodel) {
		try {
			
		SimpleJdbcCall jdbc = new SimpleJdbcCall(trandb);
		jdbc.setProcedureName("sp_createAccountTransaction");
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("description_param", accounttranmodel.getDescription());
		map.put("account_param", accounttranmodel.getAccountCode());
		map.put("accountname_param", accounttranmodel.getAccountCode());
		map.put("amount_param", accounttranmodel.getAmount());
		map.put("trandate_param", accounttranmodel.getTrandate());
		
		jdbc.execute(map);
		
		return accounttranmodel;
		} catch (Exception e) {
			logger.info("Error in Save "+e.getMessage());
			return null;
		}
	}
	@Override
	public String updateAccountTransaction(AccountTranModel accounttranmodel){		
		try {
			
			trandb.execute(accountQuery.updateAccounttranbyTrankey(accounttranmodel));
			return "Updated Successfully";
			
		} catch (Exception e) {
			logger.info("Error in Save "+e.getMessage());
			return "NOT Updated";
		}
		
		
		
	}

}
