public class Main {
    public static void main(String[] args) {
        PasswordGenerator passwordGenerator = new PasswordGenerator();
        String p0 = passwordGenerator.generate(20, Boolean.TRUE, Boolean.TRUE, Boolean.TRUE, Boolean.TRUE);
        String p1 = passwordGenerator.generate(20, Boolean.TRUE, Boolean.FALSE, Boolean.TRUE, Boolean.TRUE);
        String p2 = passwordGenerator.generate(1, Boolean.TRUE, Boolean.FALSE, Boolean.TRUE, Boolean.FALSE);
        String p3 = passwordGenerator.generate(0, Boolean.TRUE, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE);
        String p4 = passwordGenerator.generate(12, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE);
        System.out.println("p0 = " + p0);
        System.out.println("p1 = " + p1);
        System.out.println("p2 = " + p2);
        System.out.println("p3 = " + p3);
        System.out.println("p4 = " + p4);
    }
}
