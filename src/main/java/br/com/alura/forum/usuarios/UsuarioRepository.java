package br.com.alura.forum.usuarios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    UserDetails findUsuarioByLogin(String login);

    boolean existsByLogin(String login);
}
