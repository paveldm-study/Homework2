package org.dpa.study.userbase1;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {

//        String str = "{ \"id\": 4, \"name\": \"Samantha Smithttt\"}";

//        String[] parts = str.split(":");
//
//        for (String part : parts) {
//            System.out.println("+" + part);
//            System.out.println();
//        }

//        Map<String, String> map = new HashMap<>();
//
//        Pattern pattern = Pattern.compile("\"(.*?)\":\\s*\"(.*?)\"");
//        Matcher matcher = pattern.matcher(str);
//
//        while (matcher.find()) {
//            map.put(matcher.group(1), matcher.group(2));
//        }
//
//        System.out.println(map); // {id=4, name=Samantha Smithttt}
//
//        map.forEach((key, value) -> {
//            System.out.println(key + " : " + value);
//            System.out.println();
//            System.out.println();
//        });
//
////        String str = "{ \"id": 4, "name": "Samantha Smithttt"}"; " +
////        String[] arr = str.replaceAll("[^a-zA-Z0-9]", "").split(""); for (String element : arr) { System.out.print(element + " "); } // Output: id 4 name SamanthaSmithttt
//
//        String str00 = "{ \"id\": 4, \"name\": \"Samantha Smithttt\"}";
//        String[] arr = str00.replaceAll("[^a-zA-Z0-9]", "").split("");
//        for (String element : arr) { System.out.print(element + " "); } // Output: id 4 name SamanthaSmithttt
//
//
//        String input = "a";
//        if (input.matches("[a-zA-Z0-9]")) {
//            System.out.println("Соответствует букве или числу");
//        } else {
//            System.out.println("Не соответствует букве или числу");
//        }
//
//        String result0 = str.replaceAll("[{}\":,]", "");
//        String result = str.replaceAll("[{}\":,]", "").trim();
//
//        System.out.println("|" + result0 + "|");
//        System.out.println("|" + result + "|");
//
        String input00 = "id 4 name Samantha Smithttt";




        String[] parts = input00.split("\\s+");
        HashMap<String, String> map00 = new HashMap<>();

        for (int i = 0; i < parts.length; i++) {
            System.out.println("+" + parts[i]);
//            String key = parts[i];
//            String value = parts[i + 1];
//            map00.put(key, value);
        }
//
//        map00.forEach((key, value) -> System.out.println(key + ": " + value));





    }
}
