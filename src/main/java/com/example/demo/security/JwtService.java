package com.example.demo.security;

import io.jsonwebtoken.Jwts;
import lombok.RequiredArgsConstructor;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;



import io.jsonwebtoken.Claims;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;


import javax.crypto.SecretKey;
import java.util.*;
import java.util.function.Function;

@Service
@RequiredArgsConstructor
public class JwtService {
    private  static  final long EXPIRATION_TIME = 86400000; //24hours or 86400000 milisecs



    public String generateToken(Map<String,Object> extraclaims,UserDetails userDetails){
        var authorities =userDetails.getAuthorities()
                .stream()
                .map(GrantedAuthority::getAuthority)
                .toList();

        return Jwts
                .builder()
                .setClaims(extraclaims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .claim("authorities",authorities)
                .signWith(getKeySignIn(), SignatureAlgorithm.HS256)
                .compact();
    }

    private <T> T extractClaims(String token, Function<Claims, T> claimsTFunction){
        final Claims claims =extractAllClaims(token);
        return claimsTFunction.apply(claims);
    }

    private Claims extractAllClaims (String token)
    {
        return Jwts.parserBuilder()
                .setSigningKey(getKeySignIn())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public SecretKey getKeySignIn(){
        byte[] Decode = Decoders.BASE64.decode("843567893696976453275974432697R634976R738467TR678T34865R6834R8763T478378637664538745673865783678548735687R3");
        return Keys.hmacShaKeyFor(Decode);


    }

    public String extractUsername(String token){
        return extractClaims(token, Claims::getSubject);
    }


    public boolean isTokenValid(String token, UserDetails userDetails){
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    public boolean isTokenExpired(String token){
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token){
        return extractClaims(token, Claims::getExpiration);
    }

}