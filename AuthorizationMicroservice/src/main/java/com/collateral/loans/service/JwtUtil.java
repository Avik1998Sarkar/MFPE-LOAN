package com.collateral.loans.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class JwtUtil {
//	private static final Logger LOGGER = LoggerFactory.getLogger(JwtUtil.class);

	private String secretkey = "${jwt.secret}";

	public String extractUsername(String token) {
		//		LOGGER.info("Starting Extract Username");
		//LOGGER.info("Ending Extract Username");
		return extractClaim(token, Claims::getSubject);
	}

	public Date extractExpiration(String token) {
		//	LOGGER.info("Starting Extract Expiration");
		//LOGGER.info("Ending Extract Expiration");
		return extractClaim(token, Claims::getExpiration);
	}

	public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
		//	LOGGER.info("Starting Extract Claim");
		final Claims claims = extractAllClaims(token);
		//	LOGGER.info(claims.toString());
		//LOGGER.info("Ending Extract Claim");
		return claimsResolver.apply(claims);
	}

	private Claims extractAllClaims(String token) {
		//LOGGER.info("Starting Extract All Claim");
		//LOGGER.info("Ending Extract All Claim");
		return Jwts.parser().setSigningKey(secretkey).parseClaimsJws(token).getBody();
	}

	private Boolean isTokenExpired(String token) {
		//LOGGER.info("Starting Is token Expired ");
		//LOGGER.info("Ending Is token Expired");
		return extractExpiration(token).before(new Date());
	}

	public String generateToken(UserDetails userDetails) {
		//	LOGGER.info("Starting Generate Token ");
		Map<String, Object> claims = new HashMap<>();
		//LOGGER.info(claims.toString());
		//LOGGER.info("Ending Generate Token");
		return createToken(claims, userDetails.getUsername());
	}

	private String createToken(Map<String, Object> claims, String subject) {
		//LOGGER.info("Starting Create Token ");
		
		 String compact = Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 15))// token for 15 min
				.signWith(SignatureAlgorithm.HS256, secretkey).compact();
		 // LOGGER.info(compact);
		 //	 LOGGER.info("Ending Create Token ");
		return compact;
	}

	public Boolean validateToken(String token, UserDetails userDetails) {
		//LOGGER.info("Starting Validate Token ");
		final String username = extractUsername(token);
		//LOGGER.info(username);
		//LOGGER.info("Ending Validate Token ");
		return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
	}

	public Boolean validateToken(String token) {
		//LOGGER.info("Starting Validate Token ");
		//LOGGER.info("Ending Validate Token ");
		return !isTokenExpired(token);
	}
}