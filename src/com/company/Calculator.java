package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Calculator {

    private boolean What(String a) {
        String[] arr = {"0","1","2","3","4","5","6","7","8","9","10"};
        for (int i = 0; i< 11; i++) {
            if (arr[i].equals(a)) {
                return true;
            }
        }
        return false;
    }
    public void Input() throws Exception {

        System.out.println("Введите арифметическую операцию:");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] arifm = reader.readLine().split(" ");
        if(arifm.length>3){
            throw new Exception("формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        }
        else if(arifm.length<3){
            throw new Exception("строка не является математической операцией");

        }
        if(What(arifm[0]) && What(arifm[2])){
            String s = arifm[1];
            Arifmetic arifmetic = new Arifmetic(Integer.parseInt(arifm[0]),s,Integer.parseInt(arifm[2]));
            System.out.println(arifmetic.Arifmetic());}
        else if(What(arifm[0]) && !What(arifm[2]) || !What(arifm[0])&&What(arifm[2])){
            throw new Exception("используются одновременно разные системы счисления");
        }
        else  {
            Roman roman = new Roman();
            int fch = roman.digit(arifm[0]);
            int sch = roman.digit(arifm[2]);
            if(fch<sch && arifm[1].equals("-")){
                throw new Exception("в римской системе нет отрицательных чисел");
            }
            Arifmetic arifmetic = new Arifmetic(fch,arifm[1],sch);
            System.out.println(integerToRomanNumeral(arifmetic.Arifmetic()));}

    }

    public static String integerToRomanNumeral(int input) {
        if (input < 1 || input > 101)
            return "0";
        String s = "";
        while (input >= 100) {
            s += "C";
            input -= 100;
        }
        while (input >= 90) {
            s += "XC";
            input -= 90;
        }
        while (input >= 50) {
            s += "L";
            input -= 50;
        }
        while (input >= 40) {
            s += "XL";
            input -= 40;
        }
        while (input >= 10) {
            s += "X";
            input -= 10;
        }
        while (input >= 9) {
            s += "IX";
            input -= 9;
        }
        while (input >= 5) {
            s += "V";
            input -= 5;
        }
        while (input >= 4) {
            s += "IV";
            input -= 4;
        }
        while (input >= 1) {
            s += "I";
            input -= 1;
        }
        return s;
    }
}
