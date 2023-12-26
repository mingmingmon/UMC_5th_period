package umc.study.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import umc.study.domain.Ceo;

public interface CeoRepository extends JpaRepository<Ceo, Long> {
}
