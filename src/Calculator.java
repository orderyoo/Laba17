import java.util.ArrayList;
import java.util.List;

public class Calculator {
    public static List<String> calculator(List<String> list) {
        list = ParenthesesSearch(list);
        list = MultiplicationAndDivision(list);
        list = AdditionAndSubtraction(list);
        return list;
    }
    public static List<String> MultiplicationAndDivision(List<String> list) {
        for (int i = 0; list.contains("*") || list.contains("/"); i++) {
            if (list.get(i).equals("*") || list.get(i).equals("/")) {
                double num1 = Double.parseDouble(list.get(i - 1));
                double num2 = Double.parseDouble(list.get(i + 1));
                double result = 0;
                if (list.get(i).equals("*")) {
                    result = num1 * num2;
                } else {
                    result = num1 / num2;
                }
                list.remove(i - 1);
                list.remove(i - 1);
                list.set(i - 1, String.valueOf(result));
                i = 0;
            }
        }
        return list;
    }
    public static List<String> AdditionAndSubtraction(List<String> list) {
        for (int i = 0; list.size() != 1; i++) {
            if (list.get(i).equals("+") || list.get(i).equals("-")) {
                double num1 = Double.parseDouble(list.get(i - 1));
                double num2 = Double.parseDouble(list.get(i + 1));
                double result;
                if (list.get(i).equals("+")) {
                    result = num1 + num2;
                } else {
                    result = num1 - num2;
                }
                list.remove(i - 1);
                list.remove(i - 1);
                list.set(i - 1, String.valueOf(result));
                i = 0;
            }
        }
        return list;
    }
    public static List<String> ParenthesesSearch(List<String> list){
        List<String> list1 = new ArrayList<>();
        int a = 0;
        for (int i = list.indexOf("("); i <= list.indexOf(")"); i++){
            if(list.get(i).equals("(")){
                a = i;
            }
        }
        for(int i = a; i <= list.indexOf(")"); i++){
            list1.add(list.get(i));
        }
        list1.remove(list1.lastIndexOf("("));
        list1.remove(list1.indexOf(")"));
        System.out.println(list1);
        for(int i = a; i < list.indexOf(")"); i++){
            list.set(i, "o");
        }
        list1 = MultiplicationAndDivision(list1);
        list1 = AdditionAndSubtraction(list1);
        list.removeIf(n -> n.equals("o"));
        list.set(list.indexOf(")"), list1.get(0));
        System.out.println(list);
        if (list.contains("(")){
            return ParenthesesSearch(list);
        }
        return list;
    }

}

