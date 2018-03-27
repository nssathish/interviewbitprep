public class Factorial {

    public static void main(String[] args) {
        int input = Integer.parseInt(args[0]);
        WorkMath workMath = new WorkMath();
        int factorialResult = WorkMath.factorial(input);
        System.out.println(input + "! = " + factorialResult);
    }
}

class WorkMath {
    static int factorial(int arg) {
        if (arg == 0) {
            return 1;
        }
        else {
            /*
                               5
                           /      \
                          4        3
                        / \      /  \

             */
            return factorial(arg-1) * arg;
        }
    }
}