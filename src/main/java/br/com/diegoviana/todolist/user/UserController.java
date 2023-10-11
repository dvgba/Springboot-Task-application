package br.com.diegoviana.todolist.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import at.favre.lib.crypto.bcrypt.BCrypt;

/**
 * Modificador
 * public
 * private
 * protected
 */
@RestController
@RequestMapping("/users")
public class UserController {
    
    //Método de Cadastro
    /**
     * String - (texto)
     * Integer - (int) numeros inteiros
     * Double - (double) numero 0.0000
     * Float (float) numeros 0.000
     * Caracteres - (char) A C
     * Data - (date)
     * Void (void) sem retorno
     */
    /**
     * Body
     */
    @Autowired
    private IUserRepository userRepository;
    
    @PostMapping("/")
    public ResponseEntity create(@RequestBody UserModel userModel) {
        //System.out.println(userModel.getUsername());
        var user = this.userRepository.findByUsername(userModel.getUsername());
        if(user != null){
            //System.out.println("Usuário ja existe");
            // Precisamos retornar
            // Mensagem de erro
            // Status Code
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Usuario já existe");
        }

        var passwordHashred = BCrypt.withDefaults()
                .hashToString(12, userModel.getPassword().toCharArray());

        userModel.setPassword(passwordHashred);

        var userCreated = this.userRepository.save(userModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(userCreated);
    }
}
