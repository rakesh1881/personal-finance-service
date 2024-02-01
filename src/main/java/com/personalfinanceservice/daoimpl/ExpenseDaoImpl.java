package com.personalfinanceservice.daoimpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Component;

import com.personalfinanceservice.dao.ExpenseMasterDao;
import com.personalfinanceservice.model.ExpenseMasterModel;
import com.personalfinanceservice.query.ExpenseQuery;

@Component
public class ExpenseDaoImpl implements ExpenseMasterDao{

	@Autowired
	JdbcTemplate masterdb;
	@Autowired
	ExpenseQuery expenseQuery;
	
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Override
	public ExpenseMasterModel getExpenseMasterbykeycode(String keyCode) throws Exception{
		try {
			logger.debug("Get Expense Master keycode is{}",keyCode);
		return masterdb.queryForObject(expenseQuery.getExpenseQuerykeycode(keyCode),
				BeanPropertyRowMapper.newInstance(ExpenseMasterModel.class));
		
		} catch (EmptyResultDataAccessException e) {
			throw new Exception("Error");
		} catch (IncorrectResultSizeDataAccessException e) {
			throw new Exception("ERROR");
		}
	}

	@Override
	public ExpenseMasterModel saveExpenseMaster(ExpenseMasterModel  expenseMasterModel ) throws Exception {
		try {
		SimpleJdbcCall jdbc = new SimpleJdbcCall(masterdb.getDataSource());
		jdbc.setProcedureName("sp_saveExpense");
		Map< String, Object> map = new HashMap<String, Object>();
		
		map.put("expensenameparam", expenseMasterModel.getExpenseName());
		map.put("keycodeparam", expenseMasterModel.getExpenseId());
		map.put("activeParam", expenseMasterModel.getActive());
		
		jdbc.execute(map);
		
		return expenseMasterModel;
		}catch(Exception e){
			
			throw new Exception ("Not able to save");
		}
		
	}

	@Override
	public int getExpenseLastnumber() throws Exception {
		
		return masterdb.queryForObject(expenseQuery.getExpenseCount(), Integer.class);
	}

	@Override
	public String upateExpenseMaster(ExpenseMasterModel expensemasterModel) throws Exception {
		try {
		masterdb.execute(expenseQuery.getupdateQuery(expensemasterModel));
		return "Updated SuccessFully";
		}
		catch(Exception e) {
			logger.info(e.getMessage());
			return "Not Able to Save";
		}		
	}

	@Override
	public List<ExpenseMasterModel> getExpenseMaster()  {
		try {
		 return masterdb.query(expenseQuery.getExpenseQuery(),
				BeanPropertyRowMapper.newInstance(ExpenseMasterModel.class));
		}catch(Exception e) {
			logger.info(e.getMessage());
			return null;
		}
		
	}

	@Override
	public String getExpenseCodeByExpensename(String expenseName) throws Exception {
		
		try {
			 return masterdb.queryForObject(expenseQuery.getExpenseCodebyExpenseName(expenseName),
					String.class);
			}catch(Exception e) {
				logger.info(e.getMessage());
				return null;
			}
	}


}
