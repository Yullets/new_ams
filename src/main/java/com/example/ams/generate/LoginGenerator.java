package com.example.ams.generate;

import com.ibm.icu.text.Transliterator;

public class LoginGenerator {
    public static final String CYRILLIC_TO_LATIN = "Russian-Latin/BGN";

    public static String generateLogin(String fullName) {
        fullName = fullName.replace("ь", "");
        fullName = fullName.replace("ъ", "");

        String englishName = translateToEnglish(fullName);
        String[] names = englishName.split(" ");

        return names[0].toLowerCase() + "." + names[1].toLowerCase().charAt(0) + names[2].toLowerCase().charAt(0);
    }

    public static String translateToEnglish(String login) {
        Transliterator toLatinTrans = Transliterator.getInstance(CYRILLIC_TO_LATIN);

        return toLatinTrans.transliterate(login);
    }
}
