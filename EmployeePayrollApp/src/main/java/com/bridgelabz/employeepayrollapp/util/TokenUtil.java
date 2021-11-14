package com.bridgelabz.employeepayrollapp.util;

import org.springframework.stereotype.Component;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import com.auth0.jwt.interfaces.Verification;

/**
 * Create JWT token authorization
 *
 * @author Sanjay Pandit
 * @version 0.0.1
 * @since 10/11/2021
 */
@Component
public class TokenUtil {
	public final String TOKEN_SECRET = "Sanjay";

	/**
	 * Function to get particular token of employee id
	 *
	 * @param empId unique Id
	 * @return JWT token
	 */
	public String createToken(Integer id) {
		try {
			// to set algorithm
			Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);

			String token = JWT.create().withClaim("user_id", id).sign(algorithm);
			return token;
		} catch (JWTCreationException exception) {
			exception.printStackTrace();
			// log Token Signing Failed
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Function to get particular token of employee id
	 *
	 * @param token
	 * @return userId data object
	 */
	public Integer decodeToken(String token) {
		Integer userid;
		// for verification algorithm
		Verification verification = null;
		try {
			verification = JWT.require(Algorithm.HMAC256(TOKEN_SECRET));
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JWTVerifier jwtverifier = verification.build();
		// to decode token
		DecodedJWT decodedjwt = jwtverifier.verify(token);

		Claim claim = decodedjwt.getClaim("user_id");
		userid = claim.asInt();
		return userid;

	}

}
