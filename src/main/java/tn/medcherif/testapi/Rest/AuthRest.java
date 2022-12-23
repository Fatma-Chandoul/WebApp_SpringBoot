package tn.medcherif.testapi.Rest;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import tn.medcherif.testapi.DAO.RoleDao;
import tn.medcherif.testapi.Model.Compte;
import tn.medcherif.testapi.Model.ERole;
import tn.medcherif.testapi.Model.Personne;
import tn.medcherif.testapi.Payload.Request.LoginRequest;
import tn.medcherif.testapi.Payload.Request.SignupRequest;
import tn.medcherif.testapi.Payload.Response.JwtResponse;
import tn.medcherif.testapi.Payload.Response.MessageResponse;
import tn.medcherif.testapi.Security.jwt.JwtUtils;
import tn.medcherif.testapi.Security.service.CompteDetailsImpl;
import tn.medcherif.testapi.Service.CompteService;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth/")

public class AuthRest {
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;
    private final CompteService compteService;
    private final RoleDao roleDao;
    private final JwtUtils jwtUtils;

    public AuthRest(AuthenticationManager authenticationManager, PasswordEncoder passwordEncoder, CompteService compteService, RoleDao roleDao, JwtUtils jwtUtils) {
        this.authenticationManager = authenticationManager;
        this.passwordEncoder = passwordEncoder;
        this.compteService = compteService;
        this.roleDao = roleDao;
        this.jwtUtils = jwtUtils;
    }


    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(),
                        loginRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);
        CompteDetailsImpl compteDetails = (CompteDetailsImpl) authentication.getPrincipal();
        List<String> role = compteDetails.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList());
        return ResponseEntity.ok(new JwtResponse(jwt, compteDetails.getId(), role, compteDetails.getPrenom(), compteDetails.getNom()));
    }

    @PostMapping("/signup")
    public Object signup(@Valid @RequestBody SignupRequest signupRequest) {
        if (compteService.existByLogin(signupRequest.getUsername())) {
            return ResponseEntity.badRequest().body(new MessageResponse("login indisponible"));
        }
        Compte compte = new Compte(signupRequest.getUsername(), passwordEncoder.encode(signupRequest.getPassword()),
                new Personne(signupRequest.getNom(), signupRequest.getPrenom(), signupRequest.getCin()));
        compte.addRole(roleDao.findByRole(ERole.ROLE_USER).get());
        compteService.addCompte(compte);
        return ResponseEntity.ok(compte);
    }


}





