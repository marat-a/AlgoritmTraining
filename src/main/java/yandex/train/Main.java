import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();

        Deque<Integer> zeroStack = new ArrayDeque<>();
        Deque<Integer> oneStack = new ArrayDeque<>();

        for(int r = 1; r <= n; r++){
            if(s.charAt(r - 1) == '0'){
                zeroStack.push(r - 1);
            } else{
                oneStack.push(r - 1);
            }

            if(Math.abs(zeroStack.size() - oneStack.size()) <= 1){
                System.out.println(-1);
            } else if(zeroStack.size() > oneStack.size()){
                int l = binarySearch(zeroStack, r, s);
                System.out.println((l + 1) + " " + r);
            } else{
                int l = binarySearch(oneStack, r, s);
                System.out.println((l + 1) + " " + r);
            }
        }
    }


    static int binarySearch(Deque<Integer> stack, int r, String s){
        int left = 0;
        int right = stack.size() - 1;

        while(left < right){
            int mid = (left + right) / 2;
            int l = stack.toArray(new Integer[0])[mid];
            int c0 = mid;
            int c1 = stack.size() - mid - 1;
            if(c0 > c1){
                if(s.charAt(r - 1) == '0'){
                    right = mid;
                } else{
                    left = mid + 1;
                }
            } else if(c0 < c1){
                if(s.charAt(r - 1) == '1'){
                    right = mid;
                } else{
                    left = mid + 1;
                }
            } else{

                if(left == mid){

                    break;
                }
                right = mid;
            }
        }

        return stack.toArray(new Integer[0])[left];
    }
}