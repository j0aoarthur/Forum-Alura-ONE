package br.com.alura.forum.controllers;

import br.com.alura.forum.infra.security.TokenDTO;
import br.com.alura.forum.infra.security.TokenService;
import br.com.alura.forum.usuarios.AuthenticationService;
import br.com.alura.forum.usuarios.Usuario;
import br.com.alura.forum.usuarios.UsuarioDadosDTO;
import br.com.alura.forum.usuarios.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/login")
    public ResponseEntity fazerLogin(@RequestBody UsuarioDadosDTO usuarioLoginDTO) {
        var authenticationToken = new UsernamePasswordAuthenticationToken(usuarioLoginDTO.login(), usuarioLoginDTO.senha());
        var authentication = manager.authenticate(authenticationToken);

        var tokenJWT = tokenService.criarToken((Usuario) authentication.getPrincipal());

        return ResponseEntity.ok(new TokenDTO(tokenJWT));
    }

    @PostMapping("/cadastro")
    public ResponseEntity cadastrarUsuario(@RequestBody UsuarioDadosDTO usuarioDadosDTO) {
        authenticationService.registerUser(usuarioDadosDTO);

        return fazerLogin(usuarioDadosDTO);
    }
}
