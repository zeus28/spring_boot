package com.userfront.service.UserServiceImpl;



import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.userfront.dao.PrimaryAccountDao;
import com.userfront.dao.SavingsAccountDao;
import com.userfront.domain.PrimaryAccount;
import com.userfront.domain.SavingsAccount;
import com.userfront.service.AccountService;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {
	private static int nextAccountNumber= 1112533; 
	
	@Autowired
	private PrimaryAccountDao primaryAccountDao;
	
	@Autowired
	private SavingsAccountDao savingsAccountDao;
	
	@Override
	public PrimaryAccount createPrimaryAccount() {
		PrimaryAccount primaryAccount=new PrimaryAccount();
		primaryAccount.setAccountBalance(new BigDecimal(0.0));
		primaryAccount.setAccountNumber(accountGen());
		primaryAccountDao.save(primaryAccount);
		return primaryAccountDao.findByAccountNumber(primaryAccount.getAccountNumber());
		// TODO Auto-generated method stub
	
	}

	@Override
	public SavingsAccount createSavingsAccount() {
		// TODO Auto-generated method stub
		SavingsAccount savingAccount = new SavingsAccount();
		savingAccount.setAccountBalance(new BigDecimal(0.0));
		savingAccount.setAccountNumber(accountGen());
		savingsAccountDao.save(savingAccount);
		return savingsAccountDao.findByAccountNumber(savingAccount.getAccountNumber());
	}
	
	private int accountGen() {
		return ++nextAccountNumber;
	}

}
