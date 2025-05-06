package com.Repository;

import com.example.Model.RegistroModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LoginRepository extends JpaRepository<RegistroModel, Integer> {
    Optional<RegistroModel> findByCorreo(String correo);
}
