package repositories;

import com.example.backend.Modelo.Entidades.ServicioEspecial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicioEspecialRepo extends JpaRepository<ServicioEspecial, String> {
}
