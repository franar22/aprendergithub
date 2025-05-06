package com.Service;

import com.example.Model.LoginModel;
import com.example.Model.RegistroModel;
import com.Repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import com.example.login.client.RegistroClient; // Importa el cliente Feign


@Service
public class LoginService {

    @Autowired
    private LoginRepository loginRepository;
    @Autowired
    private RegistroClient registroClient;

    public RegistroModel autenticarUsuario(LoginModel loginModel) {
       Optional<RegistroModel> usuarioOptional = loginRepository.findByCorreo(loginModel.getCorreo());
        if(usuarioOptional.isPresent()){
           RegistroModel usuario = usuarioOptional.get();
           if (usuario.getContraseña().equals(loginModel.getContraseña())) {
               return usuario;
           } else {
              throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Contraseña incorrecta");
           }
        }
        else{
           //El usuario no existe en la base de datos local, lo busca en el servicio de registro
           //Esto es solo un ejemplo, el flujo correcto dependerá de la lógica de negocio de tu aplicación.
           RegistroModel usuarioRegistro = new RegistroModel();
           usuarioRegistro.setCorreo(loginModel.getCorreo());
           usuarioRegistro.setContraseña(loginModel.getContraseña());
           try{
               return registroClient.registrar(usuarioRegistro).getBody();
           }catch(Exception e){
               throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Usuario no encontrado y error al registrarlo");
           }

        }
    }
}
