package com.collateral.loans.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.collateral.loans.dao.UserDAO;
import com.collateral.loans.model.AuthResponse;
import com.collateral.loans.model.UserData;
import com.collateral.loans.service.CustomerDetailsService;
import com.collateral.loans.service.JwtUtil;

@RestController
@RequestMapping("/authapp")
public class AuthController {

	@Autowired
	private JwtUtil jwtutil;
	@Autowired
	private CustomerDetailsService custdetailservice;
	@Autowired
	private UserDAO userservice;

	private static final Logger LOGGER = LoggerFactory.getLogger(AuthController.class);

	@RequestMapping(path = "/health", method = RequestMethod.GET)
	public ResponseEntity<?> healthCheckup() {
		LOGGER.info("AWS Health Check ");
		return new ResponseEntity<>("", HttpStatus.OK);
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<?> login(@RequestBody UserData userlogincredentials) {
		LOGGER.info("Start Login");
		final UserDetails userdetails = custdetailservice.loadUserByUsername(userlogincredentials.getUserid());
		String uid = "";
		String generateToken = "";
		if (userdetails.getPassword().equals(userlogincredentials.getUpassword())) {
			uid = userlogincredentials.getUserid();
			generateToken = jwtutil.generateToken(userdetails);
//			LOGGER.info("Uid :"+uid);
//			LOGGER.info("Token: "+generateToken);
//			LOGGER.info("Ending Login");
			return new ResponseEntity<>(new UserData(uid, null, null, generateToken), HttpStatus.OK);
		} else {
			LOGGER.error("Not Accesible");
//			LOGGER.info("Ending Login");
			return new ResponseEntity<>("Not Accesible", HttpStatus.FORBIDDEN);
		}
	}

	@RequestMapping(value = "/validate", method = RequestMethod.GET)
	public ResponseEntity<?> getValidity(@RequestHeader("Authorization") final String token) {
		String token1 = token.substring(7);
		LOGGER.info("Starting Validity");
//		LOGGER.info("Get Validity");
		AuthResponse res = new AuthResponse();
		if (jwtutil.validateToken(token1)) {
			res.setUid(jwtutil.extractUsername(token1));
			res.setValid(true);
			res.setName(userservice.findById(jwtutil.extractUsername(token1)).get().getUname());
		} else {
			res.setValid(false);
			LOGGER.error("Token Has Expired");

		}
//		LOGGER.info("Ending Validity");
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

}
