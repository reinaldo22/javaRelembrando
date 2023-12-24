package com.Utilities;

import java.beans.Expression;
import java.text.Normalizer;
import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;

import javax.persistence.criteria.CriteriaBuilder;
import static java.text.Normalizer.normalize;

import static java.util.regex.Pattern.compile;


import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CommonValidationConstants {
    public static String removeAccents(String str) {
        if (str != null) {
            return normalize(str, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
        }
        return null;
    }
    // public static Expression<String> unaccentFunction(
    //         CriteriaBuilder criteriaBuilder,
    //         Expression<String> expression) {
    //     return criteriaBuilder.function("\"precojusto-service-platform\".unaccent", String.class, expression);
    // }

    // public static boolean validateEmail(String email) {
    //     if (email == null) {
    //         return false;
    //     }
    //     return (compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", CASE_INSENSITIVE).matcher(email)).matches();
    // }

    public static boolean validateName(String name) {
        return name.split("\\s+").length > 1;
    }

    public static boolean validatePhoneNumber(String phone) {
        var phoneUtil = PhoneNumberUtil.getInstance();
        try {
            var phoneNumberProto = phoneUtil.parse(phone, "BR");
            return phoneUtil.isValidNumberForRegion(phoneNumberProto, "BR");
        } catch (NumberParseException e) {
            return false;
        }
    }

    public static boolean isNullValue(String value) {
        if (value == null) {
            return true;
        }

        if (value.trim().equals("")) {
            return true;
        }

        if(value.isEmpty()){
            return true;
        }

        if(value.isBlank()){
            return true;
        }

        return false;
    }
}

