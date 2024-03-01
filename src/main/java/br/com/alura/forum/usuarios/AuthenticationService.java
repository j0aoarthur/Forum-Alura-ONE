package br.com.alura.forum.usuarios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService implements UserDetailsService {

    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findUsuarioByLogin(username);
    }

    public void registerUser(UsuarioDadosDTO usuarioDadosDTO) {
        var encodedPassword = passwordEncoder.encode(usuarioDadosDTO.senha());
        if (repository.existsByLogin(usuarioDadosDTO.login())) {
            throw new RuntimeException("Não foi possível cadastrar usuário. Login já existente no sistema!");
        }

        var usuario = new Usuario(usuarioDadosDTO.login(), encodedPassword);


        repository.save(usuario);
    }
}
