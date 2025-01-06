import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

import static java.util.Arrays.asList;

public class Solver {
    private static java.lang.Exception Exception;

    private static String findValue(ArrayList<String> symbols) throws Exception {
        String[] op = {"*", "/"};
        if (Objects.equals(symbols.get(0), ""))
            symbols.remove(0);

        for (int i = 0; i < 2; i++) {
            while (symbols.contains(op[i])) {
                int index = symbols.indexOf(op[i]);
                double numb1 = Double.parseDouble(symbols.get(index - 1));
                double numb2 = Double.parseDouble(symbols.get(index + 1));
                double result = 0;
                switch (symbols.get(index)) {
                    case "*":
                        result = numb1 * numb2;
                        break;
                    case "/":
                        if (numb2 == 0)
                            throw new Exception("Деление на ноль");
                        result = numb1 / numb2;
                        break;
                }
                symbols.remove(index + 1);
                symbols.remove(index);
                symbols.remove(index - 1);
                symbols.add(index - 1, String.valueOf(result));
            }
        }
        if (symbols.getFirst().equals("-")) {
            symbols.set(1, "-" + symbols.get(1));
            symbols.remove(0);
        }
        while (symbols.contains("+") || symbols.contains("-")) {
            double result = 0;
            double numb1 = Double.parseDouble(symbols.getFirst());
            double numb2 = Double.parseDouble(symbols.get(2));
            switch (symbols.get(1)) {
                case "+":
                    result = numb1 + numb2;
                    break;
                case "-":
                    result = numb1 - numb2;
                    break;
            }
            symbols.remove(0);
            symbols.remove(0);
            symbols.remove(0);
            symbols.add(0, String.valueOf(result));
        }
        return String.valueOf(symbols.getFirst());
    }

    private static String findValue(ArrayList<String> symbols, String letter) throws Exception {
        ArrayList<String> leftPart = new ArrayList<String>(asList(symbols.get(0).split(" ")));
        ArrayList<String> rightPart = new ArrayList<String>(asList(symbols.get(1).split(" ")));
        leftPart.remove(0);
        rightPart.remove(0);

        if (leftPart.getFirst().equals("-")) {
            symbols.set(1, "-" + symbols.get(1));
            symbols.remove(0);
        }

        for (int i = 0; i < leftPart.size(); i++) {
            if (Objects.equals(leftPart.get(i), "-")) {
                leftPart.set(i + 1, "-" + leftPart.get(i + 1));
                leftPart.set(i, "+");
            }
        }

        if (rightPart.getFirst().equals("-")) {
            symbols.set(1, "-" + symbols.get(1));
            symbols.remove(0);
        }

        for (int i = 0; i < rightPart.size(); i++) {
            if (Objects.equals(rightPart.get(i), "-")) {
                rightPart.set(i + 1, "-" + rightPart.get(i + 1));
                rightPart.set(i, "+");
            }
        }

        ArrayList<String> mainPart;
        ArrayList<String> helpPart;
        if (leftPart.contains(letter) || leftPart.contains("-" + letter)) {
            mainPart = new ArrayList<String>(leftPart);
            helpPart = new ArrayList<String>(rightPart);
        } else {
            mainPart = new ArrayList<String>(rightPart);
            helpPart = new ArrayList<String>(leftPart);
        }

        double result = Double.parseDouble(findValue(helpPart));

        if (mainPart.contains("^")) {
            double c = Double.parseDouble(mainPart.getLast()) - result, a = 0, b = 0;

            int fIndex = mainPart.indexOf(letter), hIndex = mainPart.indexOf("^"), lIndex = mainPart.lastIndexOf(letter);
            int qInd = (hIndex - fIndex) == 1 ? fIndex : lIndex, lInd = (hIndex - fIndex) == 1 ? lIndex : fIndex;
            if (qInd == 0 || !Objects.equals(mainPart.get(qInd - 1), "*")) a = 1;
            else a = Double.parseDouble(mainPart.get(qInd - 2));

            if (lInd == -1) b = 0;
            else {
                if (lInd == 0 || !Objects.equals(mainPart.get(lInd - 1), "*")) b = 1;
                else b = Double.parseDouble(mainPart.get(lInd - 2));
            }


            double disk = b * b - 4 * a * c;

            if (disk < 0) return "Не имеет решений в действительных числах";
            else if (disk == 0) return String.valueOf((-b + Math.sqrt(disk)) / (2 * a));
            else {
                return String.valueOf((-b + Math.sqrt(disk)) / (2 * a)) + " " + String.valueOf((-b - Math.sqrt(disk)) / (2 * a));
            }
        }
        else{
            double k = 0, b = 0;
            int index = mainPart.indexOf(letter);
            if (index == 0 || !Objects.equals(mainPart.get(index - 1), "*")) k = 1;
            else k = Double.parseDouble(mainPart.get(index - 2));

            int pIndex = mainPart.indexOf("+");
            if (pIndex == 0) b = 0;
            else {
                try {
                    b = index < pIndex ? Double.parseDouble(mainPart.get(pIndex + 1)) : Double.parseDouble(mainPart.get(pIndex - 1));
                }
                catch (java.lang.IndexOutOfBoundsException e){b = 0;}
            }
            double ans = (result - b) / k;
            return String.valueOf(mainPart.get(index).contains("-") ? ans * (-1) : ans);
        }
    }

    private static String findLetter(String s) {
        char[] array = {'+', '-', '*', '/', ' '};
        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetter(s.charAt(i))) {
                boolean check = true;
                for (char elm : array)
                    if (s.charAt(i) == elm) {
                        check = false;
                        break;
                    }
                if (check)
                    return Character.toString(s.charAt(i));
            }
        }
        return "0";
    }

    public static String findDecision(String s) throws Exception {
        if (s.contains("=")) {
            String letter = findLetter(s);
            return letter + " = " + findValue(new ArrayList<String>(asList(s.split("="))), letter);
        } else {
            return findValue(new ArrayList<String>(asList(s.split(" "))));
        }
    }
}
