package com.portfoliobuilder.backend.security;

import com.portfoliobuilder.backend.util.JwtUtil;

import jakarta.servlet.*;
import jakarta.servlet.http.*;

import lombok.RequiredArgsConstructor;

import org.springframework.security.authentication.
        UsernamePasswordAuthenticationToken;

import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.security.core.userdetails.UserDetails;

import org.springframework.security.web.authentication.
        WebAuthenticationDetailsSource;

import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter
        extends GenericFilter {

    private final JwtUtil jwtUtil;

    private final CustomUserDetailsService userDetailsService;

    @Override
    public void doFilter(
            ServletRequest request,
            ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req =
                (HttpServletRequest) request;

        String authHeader =
                req.getHeader("Authorization");

        if (authHeader != null &&
                authHeader.startsWith("Bearer ")) {

            String token =
                    authHeader.substring(7);

            String email =
                    jwtUtil.extractEmail(token);

            UserDetails userDetails =
                    userDetailsService
                            .loadUserByUsername(email);

            UsernamePasswordAuthenticationToken auth =
                    new UsernamePasswordAuthenticationToken(
                            userDetails,
                            null,
                            userDetails.getAuthorities());

            auth.setDetails(
                    new WebAuthenticationDetailsSource()
                            .buildDetails(req));

            SecurityContextHolder
                    .getContext()
                    .setAuthentication(auth);
        }

        chain.doFilter(request, response);
    }
}