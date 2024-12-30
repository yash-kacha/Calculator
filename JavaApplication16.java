package javaapplication16;

import java.util.Arrays;
import java.util.Scanner;


//100-(30-50*(10-20))
//100-((30+50*(10-20))-100)
public class JavaApplication16 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a opration : ");
        String s = sc.nextLine(); // 1000-200*10/10 1000-200*((200+300)/100)

        while (count(s, '(') != count(s, ')')) {
            System.out.println("there are problem in writing parenthisis");
            System.out.print("Enter opration again : ");
            s = sc.nextLine();
        }

        System.out.println("Answer is : " + sub(sum(mul(div(power(kauns(s)))))));
    }

    public static int count(String s, char c) {
        int co = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                co++;
            }
        }
        return co;
    }

    public static String kauns(String s) {
        String t = s;

        //System.out.println("t is " + t);
        while (t.contains("(")) {
            int total1 = count(t, '(');
            int total2 = total1;

            int[] data = new int[t.length()];

            for (int i = 0; i < t.length(); i++) {
                if (t.charAt(i) == '(') {
                    data[i] = total1;
                    total1--;
                    total2 = total1;
                } else if (t.charAt(i) == ')') {

                    total2++;
                    data[i] = total2;

                }
            }
            //System.out.println("data is : " + Arrays.toString(data));

            int i = 1;
//            for (int i = 1; i <= count(t, '('); i++) {

            int start = 0, stop = 0;
            for (int j = 0; j < t.length(); j++) {

                if (data[j] == i) {
                    stop = j;
                }
                if (data[t.length() - j - 1] == i) {
                    start = t.length() - j - 1;
                }
            }

            String op = t.substring((start + 1), stop);

            //System.out.println("t is :" + t + " op is : " + op);
            t = (t.substring(0, start)) + (sub(sum(mul(div(power(op)))))) + (t.substring(stop + 1));
            //System.out.println("t is : " + t);

//            }
        }
        return t;
    }

    public static boolean sign(char k) {
        return k == '+' || k == '-' || k == '*' || k == '/' || k == '%' || k == '(' || k == ')';
    }

    public static String div(String t) {
        while (t.contains("/")) {

            int at = t.indexOf("/");

            double e1, e2;
            int start, stop;

            start = at;
            stop = at;
            for (int j = at - 1; !sign(t.charAt(j)) && j >= 0; j--) {

                start--;
                if (j == 0) {
                    break;
                }

            }
            int k = at + 1;
            if (sign(t.charAt(k))) {
                k++;
                stop++;
            }
            for (; !sign(t.charAt(k)) && k < t.length(); k++) {
                stop++;

                if (k == t.length() - 1) {
                    break;
                }

            }
            e1 = Double.parseDouble(t.substring(start, at));
            e2 = Double.parseDouble(t.substring(++at, ++stop));

            double div = e1 / e2;

            t = t.substring(0, start) + div + t.substring(stop);
            //System.out.println("e1 is : " + e1 + " e2 is : " + e2 + "div is : " + div + "(-)string is : " + t);
        }

        return t;
    }

    public static String remi(String s) {
        String t = s;
        while (t.contains("%")) {
            int at = t.indexOf("%");

            double e1, e2;
            int start, stop;

            start = at;
            stop = at;
            for (int j = at - 1; !sign(t.charAt(j)) && j >= 0; j--) {

                start--;
                if (j == 0) {
                    break;
                }

            }
            int k = at + 1;
            if (sign(t.charAt(k))) {
                k++;
                stop++;
            }
            for (; !sign(t.charAt(k)) && k < t.length(); k++) {
                stop++;

                if (k == t.length() - 1) {
                    break;
                }

            }

            e1 = Double.parseDouble(t.substring(start, at));
            e2 = Double.parseDouble(t.substring(++at, ++stop));

            double div = e1 % e2;

            t = t.substring(0, start) + div + t.substring(stop);
        }
        return t;
    }

    public static String power(String s) {
        String t = s;
        while (t.contains("^")) {
            int at = t.indexOf("^");

            double e1, e2;
            int start, stop;

            start = at;
            stop = at;
            for (int j = at - 1; !sign(t.charAt(j)) && j >= 0; j--) {

                start--;
                if (j == 0) {
                    break;
                }

            }
            int k = at + 1;
            if (sign(t.charAt(k))) {
                k++;
                stop++;
            }
            for (; !sign(t.charAt(k)) && k < t.length(); k++) {
                stop++;

                if (k == t.length() - 1) {
                    break;
                }

            }

            e1 = Double.parseDouble(t.substring(start, at));
            e2 = Double.parseDouble(t.substring(++at, ++stop));

            double div = Math.pow(e1, e2);
            t = t.substring(0, start) + div + t.substring(stop);
            //System.out.println("e1 is : " + e1 + " e2 is : " + e2 + "div is : " + div + "(-)string is : " + t);

        }
        return t;
    }

    public static String sum(String s) {

        String t = s;
        while (t.contains("+")) {
            int at = t.indexOf("+");

            double e1, e2;
            int start, stop;
            start = at;
            stop = at;
            for (int j = at - 1; !sign(t.charAt(j)) && j >= 0; j--) {

                start--;
                if (j == 0) {
                    break;
                }

            }
            int k = at + 1;
            if (sign(t.charAt(k))) {
                k++;
                stop++;
            }
            for (; !sign(t.charAt(k)) && k < t.length(); k++) {
                stop++;

                if (k == t.length() - 1) {
                    break;
                }

            }
            e1 = Double.parseDouble(t.substring(start, at));
            e2 = Double.parseDouble(t.substring(++at, ++stop));

            double div = e1 + e2;

            t = t.substring(0, start) + div + t.substring(stop);
            //System.out.println("e1 is : " + e1 + " e2 is : " + e2 + "div is : " + div + "(-)string is : " + t);

        }

        return t;

    }

    public static String sub(String s) {

        String t = s;
        String kkk=t;

        while (t.contains("-")) {
            if (t.charAt(0) == '-' && count(t, '-') == 1) {
                return t;
            } else {
                if (t.charAt(0) == '-') {
                    kkk = t.substring(1);
                }
                int at = kkk.indexOf("-");

                double e1, e2;
                int start, stop;

                start = at;
                stop = at;
                for (int j = at - 1; !sign(t.charAt(j)) && j >= 0; j--) {

                    start--;
                    if (j == 0) {
                        break;
                    }

                }

                int k = at + 1;
                if (sign(t.charAt(k))) {
                    k++;
                    stop++;
                }
                for (; !sign(t.charAt(k)) && k < t.length(); k++) {
                    stop++;

                    if (k == t.length() - 1) {
                        break;
                    }

                }

                e1 = Double.parseDouble(t.substring(start, at));
                e2 = Double.parseDouble(t.substring(++at, ++stop));

                double div = e1 - e2;
                t = t.substring(0, start) + div + t.substring(stop);
                //System.out.println("e1 is : " + e1 + " e2 is : " + e2 + "div is : " + div + "(-)string is : " + t);

            }
        }
        return t;
    }

    public static String mul(String s) {

        String t = s;
        while (t.contains("*")) {
            int at = t.indexOf("*");

            double e1, e2;
            int start, stop;

            start = at;
            stop = at;
            for (int j = at - 1; !sign(t.charAt(j)) && j >= 0; j--) {

                start--;
                if (j == 0) {
                    break;
                }

            }
            int k = at + 1;
            if (sign(t.charAt(k))) {
                k++;
                stop++;
            }
            for (; !sign(t.charAt(k)) && k < t.length(); k++) {
                stop++;

                if (k == t.length() - 1) {
                    break;
                }

            }

            e1 = Double.parseDouble(t.substring(start, at));
            e2 = Double.parseDouble(t.substring(++at, ++stop));

            double div = e1 * e2;
            t = t.substring(0, start) + div + t.substring(stop);

        }
        return t;
    }
}
