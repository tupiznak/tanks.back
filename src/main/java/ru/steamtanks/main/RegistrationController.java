package ru.steamtanks.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import ru.steamtanks.models.UserProfile;
import ru.steamtanks.services.AccauntService;

/**
 * Created by jake on 24.09.16.
 */

@RestController
public class RegistrationController {

    final private AccauntService accauntService;

    @Autowired
    public RegistrationController(AccauntService accauntService) {
        this.accauntService = accauntService;
    }

    @RequestMapping(path = "/api/user/add", method = RequestMethod.POST)
    @CrossOrigin()
    public ResponseEntity userAdd(@RequestBody RegistrationRequest body) {
        String login = body.getLogin();
        String email = body.getEmail();
        String password = body.getPassword();

        if (StringUtils.isEmpty(login)
                || StringUtils.isEmpty(email)
                || StringUtils.isEmpty(password)
                ) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{}");
        }
        final UserProfile existingUser = accauntService.getUser(login);
        if (existingUser!=null)
            return ResponseEntity.status(HttpStatus.OK).body("{\"error\":\"1\"}");

        accauntService.addUser(login, password, email);


        return ResponseEntity.status(HttpStatus.OK).body("{\"login\":\""+login+"\"}");
        //return ResponseEntity.ok(new SuccessResponse(login));

    }


    @RequestMapping(path = "/api/user/del", method = RequestMethod.POST)
    @CrossOrigin()
    public ResponseEntity userDel(@RequestBody RegistrationRequest body) {
        String login = body.getLogin();

        final UserProfile existingUser = accauntService.getUser(login);
        if (existingUser==null)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{}");

        accauntService.delUser(login);

        return ResponseEntity.status(HttpStatus.OK).body("{\"status\":\"ok\"}");
    }

    private static final class RegistrationRequest {
        private String login;
        private String email;
        private String password;

        public String getLogin() {
            return login;
        }

        public String getEmail() {
            return email;
        }

        public String getPassword() {
            return password;
        }
    }
/*
    private static final class SuccessResponse{
        private Object data;

        private SuccessResponse(java.lang.Object data){
            this.data = data;
        }

        public Object getLogin() {
            return data;
        }
    }
    */
}
