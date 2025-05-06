package Controller;

import com.example.Model.LoginModel;
import com.example.Model.RegistroModel;
import com.Service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping
    public ResponseEntity<RegistroModel> login(@RequestBody LoginModel loginModel) {
        RegistroModel usuarioAutenticado = loginService.autenticarUsuario(loginModel);
        return ResponseEntity.ok(usuarioAutenticado);
    }
}
