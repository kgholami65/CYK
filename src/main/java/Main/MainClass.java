package Main;

import Algorithm.CYK;
import Grammar.Rule;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MainClass {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String input = " ";
        List<Rule> rules = new ArrayList<>();

        while(true){
            input = sc.nextLine();
            if (input.equals("exit"))
                break;

            rules.add(getRuleInput(input));
        }

        input = sc.nextLine();
        CYK cyk = new CYK(input, rules);
        System.out.println(cyk.run());

    }

    private static Rule getRuleInput(String input){
        String[] string1 = input.split("->")[1].split("\\|");

        return new Rule(new ArrayList<>(Arrays.asList(string1)),
                String.valueOf(input.charAt(0)));
    }
}
