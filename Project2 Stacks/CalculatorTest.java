public class CalculatorTest {
    public static void main(String args[]){

        Calculator a = new Calculator();

        String infix = "a / b*(c+(d-e))";
        String postFix;
        postFix = a.ConvertInfixToPostfix(infix);
        System.out.println(infix);
        System.out.println(postFix);
        System.out.println();

        String infix2 = "( a + b ) / ( c - d )";
        String postFix2;
        postFix2 = a.ConvertInfixToPostfix(infix2);
        System.out.println(infix2);
        System.out.println(postFix2);
        System.out.println();
        
        String infix1 = "a / ( b - c ) * d";
        String postFix1;
        postFix1 = a.ConvertInfixToPostfix(infix1);
        System.out.println(infix1);
        System.out.println(postFix1);
        System.out.println();

        
    }
}
