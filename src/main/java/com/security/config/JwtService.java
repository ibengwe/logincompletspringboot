package com.security.config;

import com.security.model.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtService {
    private static final String SECRET_KEY="1fbe9ea6c490a3bb1ee6bf6bfd520aa03fe1673c30e6826abf2a151b444978bc";
   //extract username 3rd
    public String extractUsername(String token) {
        return extractClaim(token,Claims::getSubject);
    }

    //second single claims
    public <T> T extractClaim(String token, Function<Claims,T> claimsResolver){
        final Claims  claims=extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

   //we want to extract from our user details
    public String generateToken(UserDetails userDetails){
        return generateToken(new HashMap<>(),userDetails);
    }

    //4th steps
    public String generateToken( // if you want to pass an extra claims like authority
            Map<String,Object> extraClaims,
            UserDetails userDetails
    ){
        User user = (User) userDetails; // Assuming UserDetails is an instance of your User class
        extraClaims.put("role", user.getRole().name());
        extraClaims.put("firstname", user.getFirstname());
        extraClaims.put("lastname", user.getLastname());
        extraClaims.put("email", user.getEmail());
        extraClaims.put("id", user.getId());
        return Jwts
                .builder()
                .setClaims(extraClaims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+1000*60*24))
                .signWith(getSignInKey(), SignatureAlgorithm.HS256)
                .compact();
    }
    //start with this
    public boolean isTokenValid(String token,UserDetails userDetails){
        final String username=extractUsername(token);
        return (username.equals(userDetails.getUsername()))&& !isTokenExpired(token);
    }
//second this
    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }
    //3rd this
    private Date extractExpiration(String token) {
        return extractClaim(token,Claims::getExpiration);
    }


    // first we extract all claims
    private Claims extractAllClaims(String token){
        return Jwts
                .parserBuilder()
                .setSigningKey(getSignInKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    private Key getSignInKey() {
        byte[] keyBytes= Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
