package com.br.consultapramim.security.services.serviceImpl;

import com.br.consultapramim.application.utils.MessageResponse;
import com.br.consultapramim.application.utils.MessageUtil;
import com.br.consultapramim.security.domains.Role;
import com.br.consultapramim.security.domains.User;
import com.br.consultapramim.security.domains.dtos.JwtAuthenticationResponseDTO;
import com.br.consultapramim.security.domains.dtos.SigninRequestDTO;
import com.br.consultapramim.security.domains.dtos.SignupRequestDTO;
import com.br.consultapramim.security.domains.enums.RoleEnum;
import com.br.consultapramim.security.repositories.RoleRepository;
import com.br.consultapramim.security.repositories.UserRepository;
import com.br.consultapramim.security.services.AuthenticationService;
import com.br.consultapramim.security.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    @Autowired
    PasswordEncoder encoder;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private JwtUtils jwtUtils;

    @Override
    public MessageResponse signup(SignupRequestDTO signUpRequest) {
        if (userRepository.existsByUsername(signUpRequest.getUsername())) {
            throw new IllegalArgumentException(MessageUtil.MSE_E01.getMsgDescription("Nome de usuário"));
        }

        if (userRepository.existsByEmail(signUpRequest.getEmail())) {
            throw new IllegalArgumentException(MessageUtil.MSE_E01.getMsgDescription("Email"));
        }

        User user = new User(signUpRequest.getUsername(), signUpRequest.getEmail(), encoder.encode(signUpRequest.getPassword()));

        Set<String> strRoles = signUpRequest.getRole();
        Set<Role> roles = new HashSet<>();

        strRoles.forEach(role -> {
            if (role.equals("admin")) {
                Role adminRole = roleRepository.findByName(RoleEnum.ADMIN)
                        .orElseThrow(() -> new RuntimeException(MessageUtil.MSG_A03.getMsgDescription("Cargo")));
                roles.add(adminRole);
            } else {
                Role userRole = roleRepository.findByName(RoleEnum.USER)
                        .orElseThrow(() -> new RuntimeException(MessageUtil.MSG_A03.getMsgDescription("Cargo")));
                roles.add(userRole);
            }
        });

        user.setRoles(roles);
        userRepository.save(user);

        return new MessageResponse(MessageUtil.MSE_S03.getMsgAbbreviation(), MessageUtil.MSE_S03.getMsgDescription("Usuário"));
    }

    @Override
    public JwtAuthenticationResponseDTO signin(SigninRequestDTO signinRequest) {
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(signinRequest.getUsername(), signinRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = "Bearer " + jwtUtils.generateJwtToken(authentication);

        UserDetailsServiceImpl userDetails = (UserDetailsServiceImpl) authentication.getPrincipal();

        List<String> roles = userDetails.getAuthorities().stream().map(GrantedAuthority::getAuthority).toList();

        return new JwtAuthenticationResponseDTO(userDetails.getId(), userDetails.getUsername(), userDetails.getEmail(), jwt, roles);
    }
}
