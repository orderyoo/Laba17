import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Token{
    public static List<String> toListAndExamination(String  expression){
        List<String> list = new ArrayList<>();
        expression = expression.replaceAll("\\s+", "");
        if(Pattern.compile("[*/=-]{2,}").matcher(expression).find()){
            list.add("Два оператора подряд!");
            return list;
        }
        Matcher matcher = Pattern.compile("\\)|\\(|[+*/-]|\\d+").matcher(expression);
        while (matcher.find()) {
            list.add(matcher.group());
        }
        return list;
    }
}
