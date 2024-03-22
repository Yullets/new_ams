package com.example.ams.generate;

import org.passay.CharacterData;
import org.passay.CharacterRule;
import org.passay.EnglishCharacterData;
import org.passay.PasswordGenerator;

import static org.passay.AllowedRegexRule.ERROR_CODE;

public class SecurePasswordGenerator {
    public static String generateSecurePassword() {
        PasswordGenerator passwordGenerator = new PasswordGenerator();

        CharacterRule upperCase = new CharacterRule(EnglishCharacterData.UpperCase, 2);
        CharacterRule lowerCase = new CharacterRule(EnglishCharacterData.LowerCase, 2);
        CharacterRule digit = new CharacterRule(EnglishCharacterData.Digit, 2);

        CharacterData specialChars = new CharacterData() {
            public String getErrorCode() {
                return ERROR_CODE;
            }

            public String getCharacters() {
                return "$,.%";
            }
        };

        CharacterRule splCharRule = new CharacterRule(specialChars, 2);

        int passwordLength = 8 + (int) (Math.random() * 4);

        return passwordGenerator.generatePassword(passwordLength, upperCase, lowerCase, digit, splCharRule);
    }
}
