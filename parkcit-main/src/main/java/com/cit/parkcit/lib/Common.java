package com.cit.parkcit.lib;

import java.security.SecureRandom;

public class Common {
    public static String getRandomId(int charLength){
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder randomString = new StringBuilder(charLength);
        SecureRandom secureRandom = new SecureRandom();
        for (int i = 0; i < charLength; i++) {
            int randomIndex = secureRandom.nextInt(characters.length());
            randomString.append(characters.charAt(randomIndex));
        }
        return randomString.toString();
    }
}
