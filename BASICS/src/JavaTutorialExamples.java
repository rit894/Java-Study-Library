public class JavaTutorialExamples {
    public static void main(String[] args) {

        // 1. Java Syntax
        System.out.println("Welcome to Java!");

        // 2. Java Output
        System.out.println("This is text output.");
        System.out.println(123); // Number output

        // 3. Java Comments
        // This is a single-line comment
        /* This is a 
           multi-line comment */

        // 4. Java Variables
        int age = 20;
        String name = "Sridhar";
        System.out.println("Name: " + name + ", Age: " + age);

        // 5. Java Data Types (including your uploaded example)
        int myNum = 5;                 // Integer (whole number)
        float myFloatNum = 5.99f;      // Floating point number
        char myLetter = 'D';           // Character
        boolean myBool = true;         // Boolean
        String myText = "Hello";       // String

        System.out.println("Integer: " + myNum);
        System.out.println("Float: " + myFloatNum);
        System.out.println("Char: " + myLetter);
        System.out.println("Boolean: " + myBool);
        System.out.println("String: " + myText);

        // 6. Java Type Casting
        int x = 10;
        double y = x; // Implicit casting
        System.out.println("Implicit cast (int to double): " + y);
        double z = 9.78;
        int w = (int) z; // Explicit casting
        System.out.println("Explicit cast (double to int): " + w);

        // 7. Java Operators
        int a = 10, b = 5;

        // Arithmetic
        System.out.println("Addition: " + (a + b));
        System.out.println("Subtraction: " + (a - b));
        System.out.println("Multiplication: " + (a * b));
        System.out.println("Division: " + (a / b));
        System.out.println("Modulus: " + (a % b));

        // Assignment
        int c = 7;
        c += 3; System.out.println("Assignment += : " + c);
        c -= 2; System.out.println("Assignment -= : " + c);
        c *= 2; System.out.println("Assignment *= : " + c);
        c /= 3; System.out.println("Assignment /= : " + c);
        c %= 2; System.out.println("Assignment %= : " + c);

        // Comparison
        System.out.println("a == b: " + (a == b));
        System.out.println("a != b: " + (a != b));
        System.out.println("a > b: " + (a > b));
        System.out.println("a < b: " + (a < b));
        System.out.println("a >= b: " + (a >= b));
        System.out.println("a <= b: " + (a <= b));

        // Logical
        boolean xBool = true, yBool = false;
        System.out.println("x && y: " + (xBool && yBool));
        System.out.println("x || y: " + (xBool || yBool));
        System.out.println("!x: " + (!xBool));

        // Bitwise
        int p = 6, q = 3; // binary: 6=110, 3=011
        System.out.println("p & q: " + (p & q));
        System.out.println("p | q: " + (p | q));
        System.out.println("p ^ q: " + (p ^ q));
        System.out.println("~p: " + (~p));
        System.out.println("p << 1: " + (p << 1));
        System.out.println("p >> 1: " + (p >> 1));

        // 8. Java Strings
        String greeting = "Hello, " + name;
        String str1 = "  Hello Java  ";
        String str2 = "hello java";

        System.out.println(greeting);
        System.out.println("Length of name: " + name.length());
        System.out.println("Uppercase name: " + name.toUpperCase());
        System.out.println("Lowercase name: " + name.toLowerCase());
        System.out.println("Index of 'J': " + str1.indexOf("J"));
        System.out.println("Char at(6): " + str1.charAt(6));
        System.out.println("Equals: " + str1.equals(str2));
        System.out.println("Trim: '" + str1.trim() + "'");
        System.out.println("CompareTo: " + str1.compareTo(str2));
        System.out.println("CompareToIgnoreCase: " + str1.compareToIgnoreCase(str2));
        System.out.println("Concat: " + str1.concat(" Tutorial"));
        System.out.println("Contains 'Java': " + str1.contains("Java"));

        char[] chars = str1.toCharArray();
        System.out.println("CopyValueOf: " + String.copyValueOf(chars, 2, 5));

        System.out.println("EqualsIgnoreCase: " + str1.trim().equalsIgnoreCase(str2));
        System.out.println("Join: " + String.join("-", "Java", "is", "fun"));
        System.out.println("Format: " + String.format("My age is %d", age));
        System.out.println("Replace: " + str1.replace("Java", "World"));

        // 9. Java Math
        System.out.println("Max of 10 and 20: " + Math.max(10, 20));
        System.out.println("Min of 10 and 20: " + Math.min(10, 20));
        System.out.println("Square root of 16: " + Math.sqrt(16));
        System.out.println("Absolute value of -5: " + Math.abs(-5));
        System.out.println("Power (2^3): " + Math.pow(2, 3));
        System.out.println("Round 5.65: " + Math.round(5.65));
        System.out.println("Ceil 5.25: " + Math.ceil(5.25));
        System.out.println("Floor 5.75: " + Math.floor(5.75));
        System.out.println("Random (0-1): " + Math.random());
        System.out.println("Random (0-100): " + (int)(Math.random() * 101));

        // 10. Java Booleans
        boolean isJavaFun = true;
        boolean isFishTasty = false;
        System.out.println("Is Java fun? " + isJavaFun);
        System.out.println("Is fish tasty? " + isFishTasty);
    }
}



