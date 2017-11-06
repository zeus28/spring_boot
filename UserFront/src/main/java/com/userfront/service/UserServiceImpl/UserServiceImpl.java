package com.userfront.service.UserServiceImpl;

import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.userfront.dao.RoleDao;
import com.userfront.dao.UserDao;
import com.userfront.domain.User;
//import com.userfront.domain.security.Role;
import com.userfront.domain.security.UserRole;
import com.userfront.service.AccountService;
//import  com.userfront.service.UserService;
import com.userfront.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	private static final Logger LOG = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	private UserDao userDao;
	
	@Autowired 
	private RoleDao roleDao;
	
	@Autowired
	private AccountService accountService;
	
	@Autowired 
	private BCryptPasswordEncoder passwordEncoder;
	
	public void save(User user) {
		 userDao.save(user);
	}
	
	 public User createUser(User user, Set<UserRole> userRoles) {
		 
	        User localUser = userDao.findByUsername(user.getUsername());
	        // some comments;ddd

	        if (localUser != null) {
	            LOG.info("User with username {} already exist. Nothing will be done. ", user.getUsername());
	        } else {
	            String encryptedPassword = passwordEncoder.encode(user.getPassword());
	            user.setPassword(encryptedPassword);

	            for (UserRole ur : userRoles) {
	            	roleDao.save(ur.getRole());
	            	
	            }
	            user.getUserRoles().addAll(userRoles);
	            user.setPrimaryAccount(accountService.createPrimaryAccount());
	            user.setSavingsAccount(accountService.createSavingsAccount());
	            localUser = userDao.save(user);
	        }

	        return localUser;
	    }
	public User findByUsername(String username) {
		return userDao.findByUsername(username);
	}
	public User findByEmail(String email) {
		return userDao.findByEmail(email);
	}
	public boolean checkUserExists(String username,String email) {
		return (checkUsernameExists(username) || checkEmailExists(email));
	}
	public boolean checkUsernameExists(String username) {
		return this.findByUsername(username) !=null;
	}
	
	public boolean checkEmailExists(String email) {
		return this.findByEmail(email) != null ;
		
	}

	@Override
	public void create(User user) {
		// TODO Auto-generated method stub
		
	}
	

}
