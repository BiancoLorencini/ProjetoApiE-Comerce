package br.org.serratec.ecommerce.services;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;

import br.org.serratec.ecommerce.entities.UserDetailImpl;

@Service
public class JwtTokenService {
	private static final String SECRET_KEY = "asdfSFS34wfsdfsdfSDSD32dfsddDDerQSNCK34SOWEK5354fdgdf4";

	private static final String ISSUER = "serratec.org.br";

	public String generateToken(UserDetailImpl user) {
		try {
			Algorithm algorithm = Algorithm.HMAC256(SECRET_KEY);
			return JWT.create()
					.withIssuer(ISSUER)
					.withIssuedAt(new Date())
					.withExpiresAt(expirationDate())
					.withSubject(user.getUser().getEmail())
					.sign(algorithm);
		} catch (JWTCreationException exception) {
			throw new JWTCreationException("Erro ao gerar token.", exception);
		}
	}

	public String getSubjectFromToken(String token) {
		try {
            Algorithm algorithm = Algorithm.HMAC256(SECRET_KEY);
            return JWT.require(algorithm)
                    .withIssuer(ISSUER) 
                    .build()
                    .verify(token) 
                    .getSubject(); 
        } catch (JWTVerificationException exception){
            throw new JWTVerificationException("Token inválido ou expirado.");
        }
	}

	private Instant expirationDate() {
		return ZonedDateTime.now(ZoneId.of("America/Sao_Paulo")).plusHours(2).toInstant();
	}

}
