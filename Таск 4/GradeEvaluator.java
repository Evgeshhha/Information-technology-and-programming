import java.util.LinkedHashMap;
import java.util.Map;

public class GradeEvaluator {

    public static void main(String[] args) {
        int[] grades = { 90, 85, 70, 40, 100 };

        Map<String, Integer> result = evaluateGrades(grades);

        System.out.print("{");
        boolean first = true;
        for (String key : result.keySet()) {
            if (!first) {
                System.out.print(", ");
            }
            System.out.print(key + ": " + result.get(key));
            first = false;
        }
        System.out.println("}");
    }

    public static Map<String, Integer> evaluateGrades(int[] grades) {
        Map<String, Integer> map = new LinkedHashMap<>();

        // инициализация всех оценок
        map.put("A", 0);
        map.put("B", 0);
        map.put("C", 0);
        map.put("D", 0);
        map.put("F", 0);

        for (int grade : grades) {
            if (grade >= 90) {
                map.put("A", map.get("A") + 1);
            } else if (grade >= 80) {
                map.put("B", map.get("B") + 1);
            } else if (grade >= 70) {
                map.put("C", map.get("C") + 1);
            } else if (grade >= 60) {
                map.put("D", map.get("D") + 1);
            } else {
                map.put("F", map.get("F") + 1);
            }
        }
        return map;
    }
}
