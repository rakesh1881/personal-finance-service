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
import com.personalfinanceservice.dao.ExpenseTranDao;
import com.personalfinanceservice.model.ExpenseTranModel;
import com.personalfinanceservice.query.ExpenseQuery;

@Component
public class ExpenseTranDaoImpl implements ExpenseTranDao{

	@Autowired
	JdbcTemplate trandb; 
	
	@Autowired
	ExpenseQuery expenseQuery;
	
	@Autowired
	ConnectionConfig connection;
		
	Logger logger  = LoggerFactory.getLogger(getClass());
		
	@Override
	public List<ExpenseTranModel> getExpenseTransaction() {
		try {
			
			return trandb.query(expenseQuery.getExpenseTran(), BeanPropertyRowMapper.newInstance(ExpenseTranModel.class));
			
		} catch (Exception e) {
			logger.info("ERROR IN Get ExpenseTransaction "+e.getMessage());
			return null;
		}

	}

	@Override
	public ExpenseTranModel getExpenseTransactionbyTrankey(String trankey) {
		try {
			return trandb.queryForObject(expenseQuery.getExpensetranbyTrankey(trankey),
					BeanPropertyRowMapper.newInstance(ExpenseTranModel.class));
		} catch (Exception e) {
			logger.info("ERROR in Get ExpenseTransaction "+e.getMessage());
			return null;
		}
		
	}

	@Override
	public ExpenseTranModel saveExpenseTransaction(ExpenseTranModel expensetranmodel) {
		try {
			
		SimpleJdbcCall jdbc = new SimpleJdbcCall(trandb);
		jdbc.setProcedureName("sp_createExpenseTransaction");
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("description_param", expensetranmodel.getDescription());
		map.put("account_param", expensetranmodel.getAccountCode());
		map.put("expensename_param", expensetranmodel.getExpenseCode());
		map.put("amount_param", expensetranmodel.getAmount());
		map.put("trandate_param", expensetranmodel.getTrandate());
		
		jdbc.execute(map);
		
		return expensetranmodel;
		} catch (Exception e) {
			logger.info("Error in Save "+e.getMessage());
			return null;
		}
	}
	@Override
	public String updateExpenseTransaction(ExpenseTranModel expensetranmodel){		
		try {
			
			trandb.execute(expenseQuery.updateExpensetranbyTrankey(expensetranmodel));
			return "Updated Successfully";
			
		} catch (Exception e) {
			logger.info("Error in Save "+e.getMessage());
			return "NOT Updated";
		}
		
		
		
	}

}
