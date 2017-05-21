package edu.chdtu.timemanagement.security;

import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Created by Metr_yumora on 21.05.2017.
 */
public class CustomPasswordEncoder implements PasswordEncoder {
    @Override
    public String encode(CharSequence charSequence) {
        try {
            return PasswordStorage.createHash(charSequence.toString());
        } catch (PasswordStorage.CannotPerformOperationException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean matches(CharSequence charSequence, String s) {
        try {
            return PasswordStorage.verifyPassword(charSequence.toString(), s);
        } catch (PasswordStorage.CannotPerformOperationException e) {
            e.printStackTrace();
        } catch (PasswordStorage.InvalidHashException e) {
            e.printStackTrace();
        }
        return false;
    }
}
