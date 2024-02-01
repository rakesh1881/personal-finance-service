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

import com.personalfinanceservice.dao.AccountMasterDao;
import com.personalfinanceservice.model.AccountMasterModel;
import com.personalfinanceservice.query.AccountQuery;

@Component
public class AccountMasterDaoImpl implements AccountMasterDao{


	@Autowired
	JdbcTemplate masterdb;
	@Autowired
	AccountQuery accountQuery;
	
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Override
	public AccountMasterModel getAccountMasterbykeycode(String keyCode) throws Exception{
		try {
			logger.debug("Get Account Master keycode is{}",keyCode);
		return masterdb.queryForObject(accountQuery.getAccountQuerykeycode(keyCode),
				 BeanPropertyRowMapper.newInstance(AccountMasterModel.class));
		
		} catch (EmptyResultDataAccessException e) {
			throw new Exception("Error");
		} catch (IncorrectResultSizeDataAccessException e) {
			throw new Exception("Error");
		}catch (Exception e) {
			throw new Exception("Problem in Get AccountMaster");
		}
	
	
	}

	@Override
	public AccountMasterModel saveAccountMaster(AccountMasterModel  accountMasterModel ) throws Exception {
		try {
		SimpleJdbcCall jdbc = new SimpleJdbcCall(masterdb.getDataSource());
		jdbc.setProcedureName("sp_saveAccount");
		Map< String, Object> map = new HashMap<String, Object>();
		
		map.put("accountnameparam", accountMasterModel.getAccountName());
		map.put("keycodeparam", accountMasterModel.getAccountId());
		map.put("activeParam", accountMasterModel.getActive());
		
		jdbc.execute(map);
		
		return accountMasterModel;
		}catch(Exception e){
			throw new Exception ("Not able to save");
		}
	}

	@Override
	public int getAccountLastnumber() throws Exception {
		
		return masterdb.queryForObject(accountQuery.getAccountCount(), Integer.class);
	}

	@Override
	public String upateAccountMaster(AccountMasterModel accountmasterModel) throws Exception {
		try {
		masterdb.execute(accountQuery.getupdateQuery(accountmasterModel));
		return "Updated SuccessFully";
		}
		catch(Exception e) {
			logger.info(e.getMessage());
			return "Not Able to Save";
		}	
	}

	@Override
	public List<AccountMasterModel> getAccountMaster()  {
		try {
		 return masterdb.query(accountQuery.getAccountQuery(),
				BeanPropertyRowMapper.newInstance(AccountMasterModel.class));
		}catch(Exception e) {
			logger.info(e.getMessage());
			return null;
		}
		
	}

	@Override
	public String getAccountCodeByAccountname(String accountName) throws Exception {
		try {
			 return masterdb.queryForObject(accountQuery.getAccountCodeByAccountName(accountName),
					String.class);
			}catch(Exception e) {
				logger.info(e.getMessage());
				return null;
			}
	}


}
