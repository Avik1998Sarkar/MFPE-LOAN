package com.portal.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.portal.pojo.AuthResponse;
import com.portal.pojo.UserData;


@FeignClient(url="${auth.url}",name="${auth.name}")
public interface AuthClient {
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public UserData login(@RequestBody UserData userlogincredentials);
	
	@RequestMapping(path="/validate",method=RequestMethod.GET)
	public AuthResponse verifyToken(@RequestHeader(name="Authorization",required=true)String token);
}
