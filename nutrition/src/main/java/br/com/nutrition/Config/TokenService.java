package br.com.nutrition.Config;

import br.com.nutrition.Usuario.Usuario;
import br.com.nutrition.Usuario.UsuarioRepository;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TokenService {
    @Autowired
    private  UsuarioRepository usuarioRepository;

    @Value("${nutrition.jwt.expiration}")
    private String expiration;

    @Value("${nutrition.jwt.secret}")
    private String secret;



    public String gerarToken(Authentication authentication){
        Usuario usuarioLogado=(Usuario) authentication.getPrincipal();
        Date hoje=new Date();
        return Jwts.builder().
                setIssuer("API NUTRITION").
                setSubject(usuarioLogado.getId().toString()).
                setIssuedAt(hoje).
                setExpiration(new Date(hoje.getTime()+Long.parseLong(expiration)))
                .signWith(SignatureAlgorithm.HS256, secret).compact();

    }

    public boolean isValid(String token) {
        try {
            Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
            return true;
        }
        catch (Exception e){
            return false;

        }

    }

    public Usuario getUser(String token) {
        String claims= Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getSubject();
        Long userId=Long.parseLong(claims);
        return usuarioRepository.findById(userId).get();
    }
}
