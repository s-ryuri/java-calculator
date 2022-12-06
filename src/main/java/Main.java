import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("계산 식을 입력하세요!!");
        final String input = scanner.nextLine();
        final String[] formula = input.split(" ");

        Deque<Integer> number = new ArrayDeque<>();
        Deque<String> symbol = new ArrayDeque<>();
        List<String> symbols = Arrays.asList("+", "-", "*", "/");

        int total = 0;

        for (int i = 0; i < formula.length; i++) {
            char ch = formula[i].charAt(0);
            if (ch >= '0' && ch <= '9') {
                if (number.size() == 0) {
                    number.add((int) ch);
                }
                if (number.size() == 1) {
                    //이미 숫자가 한 개 들어가 있으면
                    //심볼에 문자가 있는 지 확인하고
                    //있으면 계산한다.
                    if (symbol.size() == 1) {
                        final String popSymbol = symbol.pop();
                        final Integer firstNumber = number.pollFirst();
                        final Integer secondNumber = Integer.valueOf(ch);

                        if (popSymbol.equals("+")) {
                            Integer result = firstNumber + secondNumber;
                            total += result;
                            number.add(result);
                        }

                        if (popSymbol.equals("*")) {
                            Integer result = firstNumber * secondNumber;
                            total += result;
                            number.add(result);
                        }

                        if (popSymbol.equals("-")) {
                            Integer result = firstNumber - secondNumber;
                            total += result;
                            number.add(result);
                        }

                        if (popSymbol.equals("/")) {
                            Integer result = firstNumber / secondNumber;
                            total += result;
                            number.add(result);
                        }

                        symbol.pop();
                    }
                }
            }

            if (symbols.contains(ch)) {
                symbol.add(String.valueOf(ch));
            }

        }

        System.out.println("계산 결과 : " + total);
    }
}