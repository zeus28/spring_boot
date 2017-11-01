package com.userfront.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.userfront.dao.UserDao;
import com.userfront.domain.User;

@Service
public class UserSecurityService implements UserDetailsService {
	
	private static final Logger LOG = LoggerFactory.getLogger(UserSecurityService.class);
	
	@Autowired
	private UserDao userDao;



	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user=  userDao.findByUsername(username);
		if (user == null) {
			LOG.warn("User name {} not found ", username);
			throw new UsernameNotFoundException("Username " + username + " not found");
		}
		return user;
	}

}
