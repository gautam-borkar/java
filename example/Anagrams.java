package example;

public class Anagrams {
    private static boolean anagrams(String a, String b){
        String testStr = b;
        if (a.length() == b.length()) {
            for (int i =0; i < a.length(); i++){
                char c = a.charAt(i);
                testStr = testStr.replaceFirst(String.valueOf(c), "");
            }

            if(testStr.length() == 0){
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args){
        System.out.println(anagrams("listen", "silent"));
        System.out.println(anagrams("listen", "ssilen"));
    }
}
