package com;

public class BankCardToolChecking {

    public static boolean check(String bank_card_number){
        String cardNumber = bank_card_number;
        Integer sum = 0;
        for (int i = cardNumber.length() - 1; i >= 0; i--) {
            int digit = Integer.parseInt(cardNumber.substring(i, i + 1));

            if ((cardNumber.length() - i) % 2 == 0) {
                digit = doubleAndSumDigits(digit);
            }

            sum += digit;
        }
        return sum % 10 == 0;
    }

    private static int doubleAndSumDigits(int digit) {
        int ret = digit * 2;

        if (ret > 9) {
            ret -= 9;
        }

        return ret;
    }

}
