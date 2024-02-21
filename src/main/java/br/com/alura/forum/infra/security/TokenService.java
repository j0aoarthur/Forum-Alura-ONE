package br.com.alura.forum.infra.security;

import br.com.alura.forum.usuarios.Usuario;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Service
public class TokenService {

    @Value("${api.security.token.password}")
    private String senha;

    private final String ISSUER = "API Forum.Alura";

    public String criarToken(Usuario usuario) {
        try {
            Algorithm algoritmo = Algorithm.HMAC256(senha);
            return JWT.create()
                    .withIssuer(ISSUER)
                    .withSubject(usuario.getLogin())
                    .withExpiresAt(dataExpiracao())
                    .sign(algoritmo);
        } catch (JWTCreationException exception){
            throw new RuntimeException("Erro ao criar token JWT", exception);
        }
    }

    public String getSubject(String token) {
        try {
            Algorithm algoritmo = Algorithm.HMAC256(senha);
            return JWT.require(algoritmo)
                    .withIssuer(ISSUER)
                    .build()
                    .verify(token)
                    .getSubject();
        } catch (JWTVerificationException exception){
            throw new RuntimeException("JWT Token inválido ou expirado.", exception);
        }
    }

    public Instant dataExpiracao() {
        return LocalDateTime.now().plusHours(2).atZone(ZoneId.of("Brazil/West")).toInstant();
    }
}
