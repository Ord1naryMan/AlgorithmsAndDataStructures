package org.aads.task1;

import java.util.Stack;


public class Sequence {

    public boolean check(String sequence){
        int len = sequence.length();
        Stack<Character> s = new Stack<>();
        s.push(sequence.charAt(0));
        for(int i  = 1; i<len; i++){
            if(s.size() != 0 && sequence.charAt(i) == ')' && s.peek() == '(')
                s.pop();
            else if(s.size() != 0 && sequence.charAt(i) == ']' && s.peek() == '[')
                s.pop();
            else if(s.size() != 0 && sequence.charAt(i) == '}' && s.peek() == '{')
                s.pop();
            else if(sequence.charAt(i) == '{' ||
                    sequence.charAt(i) == '[' ||
                    sequence.charAt(i) == '(')
                s.push(sequence.charAt(i));
            else
                return false;
        }
        return s.size() == 0;
    }
}
