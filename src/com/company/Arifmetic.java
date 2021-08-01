package com.company;

public class Arifmetic {
    int digit;
    String operation;
    int sdigit;
    public Arifmetic(int parseInt, String s, int parseInt1) {
        digit = parseInt;
        operation = s;
        sdigit = parseInt1;
    }


    public  int Arifmetic() throws Exception {
        if (1 <= digit && digit <= 10 && sdigit <= 10 && sdigit >= 1) {
            switch (operation) {
                case ("-"):
                    return digit - sdigit;
                case ("+"):
                    return digit + sdigit;
                case ("*"):
                    return digit * sdigit;
                case ("/"):
                    return digit / sdigit;
                default:
                    throw new Exception();
            }
        }else {
            throw new Exception("Одно из чисел превышает 10, меньше 1 или неверная арифмитическая операция");
        }
    }


}
