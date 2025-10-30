package example;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Pallindrome {

    public static void main(String[] args){
        List<Integer> number = Arrays.asList(1, 1, 3, 4, 6);

        Set<Integer> s = new HashSet<Integer>(number);

        System.out.println(s);
    }
    
}
