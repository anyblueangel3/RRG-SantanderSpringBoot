package RRG_SantanderSpringBoot.demo3.dominio.repositorio;

import RRG_SantanderSpringBoot.demo3.dominio.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioUsuario extends JpaRepository<Usuario, Long> {
}
