package com.shivang.bajajproject.service;

import com.shivang.bajajproject.dto.DTOrequest;
import com.shivang.bajajproject.dto.DTOresponse;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BfhlService {

    /* ---------- static profile data ---------- */
    private static final String USER_ID     = "shivang_srivastava";
    private static final String EMAIL       = "shivangsrivastava99@gmail.com";
    private static final String ROLL_NUMBER = "22BCE3668";

    public DTOresponse process(DTOrequest request) {

        List<String> oddNumbers         = new ArrayList<>();
        List<String> evenNumbers        = new ArrayList<>();
        List<String> alphabets          = new ArrayList<>();
        List<String> specialCharacters  = new ArrayList<>();
        List<Character> alphaChars      = new ArrayList<>();
        int sum = 0;

        for (String item : request.getData()) {

            if (isInteger(item)) {
                int num = Integer.parseInt(item);
                sum += num;
                if (num % 2 == 0) {
                    evenNumbers.add(item);
                } else {
                    oddNumbers.add(item);
                }

            } else if (item.matches("[a-zA-Z]+")) {
                alphabets.add(item.toUpperCase());
                for (char c : item.toCharArray()) {
                    alphaChars.add(c);
                }

            } else {
                specialCharacters.add(item);
            }
        }

        String concatString = buildAlternatingCaps(alphaChars);

        return new DTOresponse(
                true,
                USER_ID,
                EMAIL,
                ROLL_NUMBER,
                oddNumbers,
                evenNumbers,
                alphabets,
                specialCharacters,
                String.valueOf(sum),
                concatString
        );
    }


    private boolean isInteger(String s) {
        try { Integer.parseInt(s); return true; }
        catch (NumberFormatException ex) { return false; }
    }

    private String buildAlternatingCaps(List<Character> chars) {
        Collections.reverse(chars);
        StringBuilder sb = new StringBuilder();
        boolean upper = true;
        for (char c : chars) {
            sb.append(upper ? Character.toUpperCase(c) : Character.toLowerCase(c));
            upper = !upper;
        }
        return sb.toString();
    }
}
