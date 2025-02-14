package tech.artcoded.login.repository;

import org.apache.commons.lang.StringUtils;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;
import tech.artcoded.login.entity.User;

import java.security.Principal;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long>, UserDetailsService {
    @Override
    default UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return this.findOneByUsername(s).orElseThrow(() -> new UsernameNotFoundException(s + " not found"));
    }

    default User principalToUser(Principal p) {
        return this.findOneByUsername(p.getName()).orElseThrow(() ->
                new RuntimeException(String.format("Principal %s not found", StringUtils.defaultIfEmpty(p.getName(), "USERNAME_NULL")))
        );
    }

    Optional<User> findOneByUsername(String username);
}
