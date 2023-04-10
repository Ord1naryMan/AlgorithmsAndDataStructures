package org.aads.task2;

import java.util.Stack;

public class FindMin {
    public int[] findMin(int[] arr, int center){
        int j = 0;
        int[] ans = new int[2];
        if(arr[0] != center)
            ans[0] = arr[0];
        ans[1] = arr[arr.length-1];
        for(int i = 0; i<arr.length; i++){
            if(arr[i] == center && j == 0) {//check if we reach center element
                if(i == arr.length-1)
                    ans[1] = 0;
                j++;
            }
            else if(arr[i] < ans[j])
                ans[j] = arr[i];
        }
        return ans;
    }

    public int[] findMinStack(int[] arr, int center){
        Stack<Integer> s = new Stack<>();
        boolean left = true;
        s.push(arr[0]);
        for(int item : arr){
            if(item == center && left) {
                left = false;
                s.push(arr[arr.length - 1]);
            }
            else
                if(s.peek() > item){
                    s.pop();
                    s.push(item);
                }
        }
        int[] ans = new int[2];
        if(arr[0] == center) {
            ans[1] = s.peek();
        }
        else if(s.size() == 1)
            ans[0] = s.peek();
        else{
            ans[1] = s.peek();
            s.pop();
            ans[0] = s.peek();
        }
        return ans;
    }
}
