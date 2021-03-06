import java.util.*;

public class problem1 {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int caseNum = Integer.parseInt(input.nextLine());
        for (int ks = 1; ks <= caseNum; ks++) {
            System.out.println(String.format("Case #%d: %s", ks, problem1.solve(input)));
        }
    }

    public static String solve(Scanner input) {
        int length = Integer.parseInt(input.nextLine());

        String line = input.nextLine();
        int[] vals = new int[length];
        for(int i = 0; i < length; i++) {
          if(i == 0) {
            vals[i] = 1;
            continue;
          }
          if(line.charAt(i) > line.charAt(i-1)) {
            vals[i] = vals[i-1] + 1;
          } else {
            vals[i] = 1;
          }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < length; i++) {
          sb.append(vals[i]);
          if(i < (length - 1)) {
            sb.append(" ");
          }
        }
        return sb.toString();
    }

}
