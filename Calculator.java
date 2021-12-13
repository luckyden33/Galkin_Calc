import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    public static void main(String[] args) {

        char agn = 'y';
        int a = 0, b = 0, result = 0; // переменные для хранения операндов и результата вычисления.
        char oper;
        String resultInRom = null;
        System.out.println("Калькулятор Галкина Дениса.\nВыполняет следующие математические действия: Сложение +, Вычитание -, умножение *, деление /.\n" +
                "с арабскими или римскими числами в одном выражении, в диапазоне от 0 до 10. Например: 3+3 или III+III.\nВведите математическую формулу и нажмите Enter:");

        while (true) //Использую цикл для выполнения нескольких решений.
        {
            boolean messageInEnd;
            String ups = ("Ошибка: ничего не ввели, ввели число больше 10 или недопустимое математическое действие или символ, или делите на 0. Пожалуйста попробуйте ещё раз.");
            Scanner in = new Scanner(System.in); // Use Class scanner for read user's input
            String input = in.nextLine(); // Присваиваю ввод строке. Сразу в array не могу, т. к. заполнить вводом в консоль через цикл for array char or String нельзя, используя счётчик int.
            String temp = input.replaceAll("\\s+", ""); // delete all spaces what user can make (find it in Google).
            String pattern = "^[IVX0-9+*/-]$";
            Pattern notRightSimbols = Pattern.compile(pattern);
            Matcher look = notRightSimbols.matcher(temp);
            do {
                if(look.find()) messageInEnd = true;
                else messageInEnd = false;


                if (temp.contains("+") || temp.contains("-") || temp.contains("*") || temp.contains("/")) {
                    int countOper = 0;
                    for (int i = 0; i < temp.length(); i++) { // проверяю, чтобы не было больше одного мат. символа.
                        if ((temp.charAt(i) == '+') || (temp.charAt(i) == '-') || (temp.charAt(i) == '*') || (temp.charAt(i) == '/')) {
                            countOper++;
                        }
                    }
                    if (countOper == 1) {
                        if (temp.contains("I") || temp.contains("II") || temp.contains("III") || temp.contains("IV") || temp.contains("V") || temp.contains("VI") || temp.contains("VII") || temp.contains("VIII")
                                || temp.contains("IX") || temp.contains("X")) { // Проверка на ввод римских чисел.
                            int countArab = 0;
                            for (int i = 0; i < temp.length(); i++) { // проверяю, чтобы не было арабских цифр.
                                if ((temp.charAt(i) == '0') || (temp.charAt(i) == '1') || (temp.charAt(i) == '2') || (temp.charAt(i) == '3') || (temp.charAt(i) == '4') || (temp.charAt(i) == '5') || (temp.charAt(i) == '6')
                                        || (temp.charAt(i) == '7') || (temp.charAt(i) == '8') || (temp.charAt(i) == '9')) {
                                    countArab++;
                                }
                            }
                            if (countArab == 0) {
                                String[] romanNums = {" ", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                                        "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIV", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIV", "XL",
                                        "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX", "LXI", "LXII", "LXIII", "LXIV",
                                        "LXV", "LVI", "LXVII", "LXVIII", "LXIX", "LXX", "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX", "LXXXI", "LXXXII", "LXXXIII", "LXXXIV",
                                        "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC", "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"}; //array Roman nums from 1 to 100. 100 is max 10*10
                                if (temp.contains("+")) {
                                    String[] inputSplit = temp.split("\\+"); // Разделяю строку методом split на 2 переменные a1 and b1.
                                    String a1 = inputSplit[0];
                                    String b1 = inputSplit[1];
                                    for (int i = 0; i < 100; i++) { // By loop for I'm converting String значения а1 и b1 в int - это возможно, т.к. индексы массива romanNums совпадают со значением его элементов I = [1]
                                        if (romanNums[i].equals(a1))
                                            a = i;
                                        if (romanNums[i].equals(b1))
                                            b = i;
                                    }
                                    if (a <= 10 & b <= 10) {
                                        result = a + b;
                                        for (int i = 0; i < romanNums.length; i++) {
                                            if (i == result) {
                                                resultInRom = romanNums[i];
                                                System.out.println(a1 + "+" + b1 + "= " + resultInRom);
                                            }
                                        }
                                    } else System.out.println(ups);

                                }
                                if (temp.contains("-")) {
                                    String[] inputSplit = temp.split("-"); // Разделяю строку методом split на 2 переменные a1 and b1.
                                    String a1 = inputSplit[0];
                                    String b1 = inputSplit[1];
                                    for (int i = 0; i < 100; i++) { // By loop for I'm converting String значения а1 и b1 в int - это возможно, т.к. индексы массива romanNums совпадают со значением его элементов I = [1]
                                        if (romanNums[i].equals(a1)) // Если элемент массива [i] равен переменной а1 или b1, то a и b равны переменой (счетчику) i, соответственно.
                                            a = i; //Пример: String a1 = III. "Элемент массива romanNums[3] имеет значение "III", цикл на 4-м проходе доходит до этого элемента (0-1-2-3) i = 3 и a = i = 3.
                                        if (romanNums[i].equals(b1))
                                            b = i;
                                    }
                                    if (a <= 10 & b <= 10 & a > b) {
                                        result = a - b;
                                        for (int i = 0; i < romanNums.length; i++) {
                                            if (i == result) {
                                                resultInRom = romanNums[i];
                                                System.out.println(a1 + "-" + b1 + "= " + resultInRom);
                                            }
                                        }
                                    } else System.out.println(ups);
                                }
                                if (temp.contains("*")) {
                                    String[] inputSplit = temp.split("\\*"); // Разделяю строку методом split на 2 переменные a1 and b1.
                                    String a1 = inputSplit[0];
                                    String b1 = inputSplit[1];
                                    for (int i = 0; i < 100; i++) { // By loop for I'm converting String значения а1 и b1 в int - это возможно, т.к. индексы массива romanNums совпадают со значением его элементов I = [1]
                                        if (romanNums[i].equals(a1))
                                            a = i;
                                        if (romanNums[i].equals(b1))
                                            b = i;
                                    }
                                    if (a <= 10 & b <= 10) {
                                        result = a * b;
                                        for (int i = 0; i < romanNums.length; i++) {
                                            if (i == result) {
                                                resultInRom = romanNums[i];
                                                System.out.println(a1 + "*" + b1 + "= " + resultInRom);
                                            }
                                        }
                                    } else System.out.println(ups);

                                }
                                if (temp.contains("/")) {
                                    String[] inputSplit = temp.split("/"); // Разделяю строку методом split на 2 переменные a1 and b1.
                                    String a1 = inputSplit[0];
                                    String b1 = inputSplit[1];
                                    for (int i = 0; i < 100; i++) { // By loop for I'm converting String значения а1 и b1 в int - это возможно, т.к. индексы массива romanNums совпадают со значением его элементов I = [1]
                                        if (romanNums[i].equals(a1))
                                            a = i;
                                        if (romanNums[i].equals(b1))
                                            b = i;
                                    }
                                    if (a <= 10 & b <= 10 & a >= b) {
                                        result = a / b;
                                        for (int i = 0; i < romanNums.length; i++) {
                                            if (i == result) {
                                                resultInRom = romanNums[i];
                                                System.out.println(a1 + "/" + b1 + "= " + resultInRom);
                                            }
                                        }
                                    } else System.out.println(ups);

                                }
                            }
                        }
                        // else System.out.println(ups); // Проверка на ввод римских чисел. END BLOCK
                        if (temp.contains("1") || temp.contains("2") || temp.contains("3") || temp.contains("4") || temp.contains("5") || temp.contains("6") || temp.contains("7")
                                || temp.contains("8") || temp.contains("9") || temp.contains("0")) {
                            int countRom = 0;
                            for (int i = 0; i < temp.length(); i++) { // проверяю, чтобы не было римских цифр.
                                if ((temp.charAt(i) == 'I') || (temp.charAt(i) == 'V') || (temp.charAt(i) == 'X')) {
                                    countRom++;
                                }
                            }
                            if (countRom < 1) {
                                if (temp.contains("+")) {
                                    String[] inputSplit = temp.split("\\+");
                                    String tempA = inputSplit[0];
                                    String tempB = inputSplit[1];
                                    a = Integer.parseInt(tempA);
                                    b = Integer.parseInt(tempB);
                                    if (a <= 10 & b <= 10) System.out.println(temp + "=" + (a + b));
                                    else System.out.println(ups);
                                }
                                if (temp.contains("-")) {
                                    String[] inputSplit = temp.split("-");
                                    String tempA = inputSplit[0];
                                    String tempB = inputSplit[1];
                                    a = Integer.parseInt(tempA);
                                    b = Integer.parseInt(tempB);
                                    if (a <= 10 & b <= 10) System.out.println(temp + "=" + (a - b));
                                    else System.out.println(ups);
                                }
                                if (temp.contains("*")) {
                                    String[] inputSplit = temp.split("\\*");
                                    String tempA = inputSplit[0];
                                    String tempB = inputSplit[1];
                                    a = Integer.parseInt(tempA);
                                    b = Integer.parseInt(tempB);
                                    if (a <= 10 & b <= 10) System.out.println(temp + "=" + (a * b));
                                    else System.out.println(ups);
                                }
                                if (temp.contains("/")) {
                                    String[] inputSplit = temp.split("/");
                                    String tempA = inputSplit[0];
                                    String tempB = inputSplit[1];
                                    a = Integer.parseInt(tempA);
                                    b = Integer.parseInt(tempB);
                                    if (a <= 10 & b > 0 & b <= 10) System.out.println(temp + "=" + (a / b));
                                    else System.out.println(ups);
                                }
                            }
                        }
                        // System.out.println("Выполнить еще арифмитическое действие, Y/N?");
                        // Scanner inQ = new Scanner(System.in);
                        // agn = inQ.next().charAt(0);
                    } else System.out.println(ups);
                } else System.out.println(ups);

            }
            while (look.find());
            //if (!messageInEnd) System.out.println("'''" + ups);

        }
    }
    // while (agn == 'y' || agn == 'Y' || agn == 'н' || agn == 'Н');
}