package ru.autoqa.sandbox;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Collections {
    public static void main(String[] args) {
        String[] langs = new String[4];
        langs[0] = "Java";
        langs[1] = "Groovy";
        langs[2] = "C#";
        langs[3] = "JS";

        List<String> languages = Arrays.asList("Java","Groovy","C++","JS");


       for (String l : languages) {
           System.out.println("Я хочу выучить " + l);
       }
    }
}
