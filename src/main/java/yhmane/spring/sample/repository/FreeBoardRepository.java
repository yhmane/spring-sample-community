package yhmane.spring.sample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import yhmane.spring.sample.entity.FreeBoardEntity;

import java.util.Optional;

public interface FreeBoardRepository extends JpaRepository<FreeBoardEntity, Long> {

    Optional<FreeBoardEntity> findById(Long id);
}
