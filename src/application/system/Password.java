package application.system;

import org.springframework.security.crypto.bcrypt.BCrypt;

public class Password {

    private static final int LOAD = 8;

    public static String hash(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt(LOAD));
    }
    public static boolean verifyHash(String password, String hash) {
        return BCrypt.checkpw(password, hash);
    }

}
