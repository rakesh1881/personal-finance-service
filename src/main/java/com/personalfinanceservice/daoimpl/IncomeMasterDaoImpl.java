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

import com.personalfinanceservice.dao.IncomeMasterDao;
import com.personalfinanceservice.model.IncomeMasterModel;
import com.personalfinanceservice.query.IncomeQuery;

@Component
public class IncomeMasterDaoImpl   implements IncomeMasterDao {
	
	@Autowired
	JdbcTemplate masterdb;
	@Autowired
	IncomeQuery incomeQuery;
	
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Override
	public IncomeMasterModel getIncomeMasterbykeycode(String keyCode) throws Exception{
		try {
			logger.debug("Get Income Master keycode is{}",keyCode);
		return masterdb.queryForObject(incomeQuery.getIncomeQuerykeycode(keyCode),
				BeanPropertyRowMapper.newInstance(IncomeMasterModel.class));
		
		} catch (EmptyResultDataAccessException e) {
			throw new Exception("Error");
		} catch (IncorrectResultSizeDataAccessException e) {
			throw new Exception("Error");
		}
	
	
	}

	@Override
	public IncomeMasterModel saveIncomeMaster(IncomeMasterModel  incomeMasterModel ) throws Exception {
		try {
		SimpleJdbcCall jdbc = new SimpleJdbcCall(masterdb.getDataSource());
		jdbc.setProcedureName("sp_saveIncome");
		Map< String, Object> map = new HashMap<String, Object>();
		
		map.put("incomenameparam", incomeMasterModel.getIncomeName());
		map.put("keycodeparam", incomeMasterModel.getIncomeId());
		map.put("activeParam", incomeMasterModel.getActive());
		
		jdbc.execute(map);
		
		return incomeMasterModel;
		}catch(Exception e){
			
			throw new Exception ("Not able to save");
		}
		
	}

	@Override
	public int getIncomeLastnumber() throws Exception {
		
		return masterdb.queryForObject(incomeQuery.getIncomeCount(), Integer.class);
	}

	@Override
	public String upateIncomeMaster(IncomeMasterModel incomemasterModel) throws Exception {
		try {
		masterdb.execute(incomeQuery.getupdateQuery(incomemasterModel));
		return "Updated SuccessFully";
		}
		catch(Exception e) {
			logger.info(e.getMessage());
			return "Not Able to Save";
		}	
	}

	@Override
	public List<IncomeMasterModel> getIncomeMaster()  {
		try {
		 return masterdb.query(incomeQuery.getIncomeQuery(),
				BeanPropertyRowMapper.newInstance(IncomeMasterModel.class));
		}catch(Exception e) {
			logger.info(e.getMessage());
			return null;
		}
		
	}

	@Override
	public String getIncomeCodeByincomename(String incomeName) throws Exception {
		try {
			 return masterdb.queryForObject(incomeQuery.getIncomeCodebyIncomeName(incomeName),
					String.class);
			}catch(Exception e) {
				logger.info(e.getMessage());
				return null;
			}
	}

}
