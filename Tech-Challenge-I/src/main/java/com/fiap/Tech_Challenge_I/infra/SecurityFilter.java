package com.fiap.Tech_Challenge_I.infra;

import com.fiap.Tech_Challenge_I.adapter.coverter.CustomUserDetails;
import com.fiap.Tech_Challenge_I.adapter.coverter.UserConverter;
import com.fiap.Tech_Challenge_I.core.port.ITokenServicePort;
import com.fiap.Tech_Challenge_I.core.port.IUserRepositoryPort;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class SecurityFilter extends OncePerRequestFilter {

    private final ITokenServicePort tokenServicePort;
    private final IUserRepositoryPort userRepositoryPort;

    public SecurityFilter(ITokenServicePort tokenService, IUserRepositoryPort userRepositoryPort) {
        this.tokenServicePort = tokenService;
        this.userRepositoryPort = userRepositoryPort;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        var token = this.recoverToken(request);

        if(token != null){
            var loginUsername = tokenServicePort.validateToken(token);
            var user = userRepositoryPort.findByUsername(loginUsername);

            CustomUserDetails userDetails = new CustomUserDetails(UserConverter.userEntityToUser(user));

            var authentication =
                    new UsernamePasswordAuthenticationToken(
                            user,null, userDetails.getAuthorities()
                    );

            SecurityContextHolder.getContext().setAuthentication(authentication);
        }

        filterChain.doFilter(request, response);
    }

    private String recoverToken(HttpServletRequest request) {
        var authHeader = request.getHeader("Authorization");
        if(authHeader == null) return null;
        return authHeader.replace("Bearer ", "");
    }
}
