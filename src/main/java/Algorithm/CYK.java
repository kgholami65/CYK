package Algorithm;

import Grammar.Rule;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CYK {

    private final String input;

    private final List<Rule> rules;


    public CYK(String input, List<Rule> rules) {
        this.input = input;
        this.rules = rules;
    }

    public boolean run(){
        List<List<Set<String>>> v = new ArrayList<>();

        int n = input.length();

        for (int i = 0; i < n; i++) {
            List<Set<String>> v2 = new ArrayList<>();

            for(int j = 0; j < n; j++)
                v2.add(new HashSet<>());

            v.add(v2);
        }

        for (int i = 0; i < n; i++) {
            Set<String> v3 = new HashSet<>();
            for (Rule rule : rules)
                if (rule.generate.contains(String.valueOf(input.charAt(i)))) {
                    v3.add(rule.name);
                    v.get(i).set(i, v3);
                }
        }

        for (int diagonal = 1; diagonal < n; diagonal++)
            for (int i = 0, j; i < n - diagonal; i++){
                Set<String> v4 = new HashSet<>();
                Set<String> v3 = new HashSet<>();
                j = diagonal + i;
                for (int k = i; k < j; k++)
                    v4.addAll(cartesianProduct(v.get(i).get(k), v.get(k + 1).get(j)));

                if (!v4.isEmpty())
                    for (Rule rule : rules)
                        for (String state : v4)
                            if (rule.generate.contains(state))
                                v3.add(rule.name);

                v.get(i).set(j, v3);
            }

        return v.get(0).get(n - 1).contains(rules.get(0).name);
    }

    private static Set<String> cartesianProduct(Set<String> firstSet, Set<String> secondSet){
        Set<String> cartesianProduct = new HashSet<>();
        if (firstSet.isEmpty() || secondSet.isEmpty())
            return cartesianProduct;

        for (String i: firstSet)
            for (String j: secondSet)
                cartesianProduct.add(i.concat(j));

        return cartesianProduct;
    }

}
