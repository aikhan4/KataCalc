import java.util.Scanner;

public class Main {
    public static Boolean isArabianNumber(String number) {
        return number.equals("1") | number.equals("2") | number.equals("3") | number.equals("4") | number.equals("5") | number.equals("6") | number.equals("7") | number.equals("8") | number.equals("9") | number.equals("10");
    }
    public static Boolean isRomanNumber(String number) {
        return number.equals("I") | number.equals("II") | number.equals("III") | number.equals("IV") | number.equals("V") | number.equals("VI") | number.equals("VII") | number.equals("VIII") | number.equals("IX") | number.equals("X");
    }
    public static int romanToArabian(String number) {
        String[] romanArray = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"
        };
        int arabianNum = 0;
        for (int i = 0; i < romanArray.length; i++) {
            if (romanArray[i].equals(number)) {
                arabianNum = i;
            }
        }
        return arabianNum;
    }
    public static String arabianToRoman(int number) {
        String[] romanArray = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"
        };
        return romanArray[number];
    }
    public static Boolean isOperator(String operator) {
        return operator.equals("+") | operator.equals("-") | operator.equals("*") | operator.equals("/");
    }
    public static String calc(String input) throws ArithmeticException {
        if ((input.length() - input.replace(String.valueOf(' '), "").length()) == 2) {
            String[] arrayWords = input.split(" ");
            if (isArabianNumber(arrayWords[0])) {
                if (isOperator(arrayWords[1])) {
                    if (isArabianNumber(arrayWords[2])) {
                        int result;
                        int a = Integer.parseInt(arrayWords[0]);
                        int b = Integer.parseInt(arrayWords[2]);
                        if (arrayWords[1].equals("+")) {
                            result = a + b;
                        } else if (arrayWords[1].equals("-")) {
                            result = a - b;
                        } else if (arrayWords[1].equals("*")) {
                            result = a * b;
                        } else {
                            result = a / b;
                        }
                        return result + "";
                    } else {
                        throw new ArithmeticException("Некорректные числа. Введите только целые арабские или только целые римские числа.");
                    }
                } else {
                    throw new ArithmeticException("Некорректная арифметическая операция. Введите операцию сложения, вычитания, умножения или деления.");
                }
            } else if (isRomanNumber(arrayWords[0])) {
                if (isOperator(arrayWords[1])) {
                    if (isRomanNumber(arrayWords[2])) {
                        int result;
                        int a = romanToArabian(arrayWords[0]);
                        int b = romanToArabian(arrayWords[2]);
                        if (arrayWords[1].equals("+")) {
                            result = a + b;
                        } else if (arrayWords[1].equals("-")) {
                            result = a - b;
                        } else if (arrayWords[1].equals("*")) {
                            result = a * b;
                        } else {
                            result = a / b;
                        }
                        return arabianToRoman(result);
                    } else {
                        throw new ArithmeticException("Некорректные числа. Введите только целые арабские или только целые римские числа.");
                    }
                } else {
                    throw new ArithmeticException("Некорректная арифметическая операция. Введите операцию сложения, вычитания, умножения или деления.");
                }
            } else {
                throw new ArithmeticException("Некорректные числа. Введите только целые арабские или только целые римские числа.");
            }
        } else {
            throw new ArithmeticException("Некорректный ввод. Введите 2 целых числа и между ними арифметическую операцию. Ставьте пробел только между числом и операцией.");
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String result = calc(input);
        System.out.println(result);
        }
    }