package com.Geekster.Recipe.management.system.API.Service;

import com.Geekster.Recipe.management.system.API.Model.AuthenticationToken;
import com.Geekster.Recipe.management.system.API.Model.User;
import com.Geekster.Recipe.management.system.API.Repo.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;

@Service
public class UserService {
    @Autowired
    IUserRepo userRepo;

    @Autowired
    AuthenticationService authenticationService;
    public String userSignUp(User newUser) {
        String newEmail = newUser.getEmail();
        User existingUser = userRepo.findFirstByUserEmail(newEmail);

        if(existingUser != null)
        {
            return "email already in use";
        }

        // passwords are encrypted before we store it in the table

        String signUpPassword = newUser.getPassword();

        try {
            String encryptedPassword = PasswordEncryptor.encrypt(signUpPassword);

            newUser.setPassword(encryptedPassword);


            // User table - save User
            userRepo.save(newUser);
            return "user registered";

        } catch (NoSuchAlgorithmException e) {

            return "Internal Server issues while saving password, try again later!!!";
        }

    }

    public String userSignIn(String email, String password) {
        //check if the email is there in your tables
        //sign in only possible if this person ever signed up

        User existingUser = userRepo.findFirstByUserEmail(email);

        if(existingUser == null)
        {
            return "Not a valid email, Please sign up first !!!";
        }
        //password should be matched
        try {
            String encryptedPassword = PasswordEncryptor.encrypt(password);

            if(existingUser.getPassword().equals(encryptedPassword))
            {
                // return a token for this sign in
                AuthenticationToken token  = new AuthenticationToken(existingUser);

                    authenticationService.createToken(token);
                    return "token Value" + " = " + token.getTokenValue();
                }
            else {
                //password was wrong!!!
                return "Invalid Credentials!!!";
            }

        } catch (NoSuchAlgorithmException e) {

            return "Internal Server issues while saving password, try again later!!!";
        }
    }
}
