package com.collateral.loans.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.collateral.loans.dao.UserDAO;
import com.collateral.loans.model.UserData;

@Service
public class CustomerDetailsService implements UserDetailsService {
//	private static final Logger LOGGER = LoggerFactory.getLogger(CustomerDetailsService.class);
	@Autowired
	private UserDAO userdao;

	@Override
	public UserDetails loadUserByUsername(String uid) throws UsernameNotFoundException {
//		LOGGER.info("Start");
//		LOGGER.info("Load User By Username");
		UserData custuser = userdao.findById(uid).orElse(null);
//		LOGGER.info(custuser.toString());
//		LOGGER.info("Ending Load User By Username");
		return new User(custuser.getUserid(), custuser.getUpassword(), new ArrayList<>());

	}

}
