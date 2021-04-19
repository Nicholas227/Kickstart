import java.util.*;

public class problem2 {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int caseNum = Integer.parseInt(input.nextLine());
        for (int ks = 1; ks <= caseNum; ks++) {
            System.out.println(String.format("Case #%d: %d", ks, problem2.solve(input)));
        }
    }
    public static int solve(Scanner input) {
      int length = Integer.parseInt(input.nextLine());
      String[] numbers = input.nextLine().split(" ");
      int max = 0;
      int[] nums = new int[length];
      Map<Integer, List<int[]>> mp = new HashMap<>();
      for(int i = 0; i < length; i++) {
        nums[i] = Integer.parseInt(numbers[i]);
        if(i >= 1) {
          List<int[]> diffList = mp.getOrDefault(nums[i]-nums[i-1], new ArrayList<>());
          if(diffList.size() == 0) {
            diffList.add(new int[]{i-1,i});
          } else {
          int[] lastSeq = diffList.get(diffList.size()-1);
          if(lastSeq[1] == i-1) {
            lastSeq[1]++;
          } else {
            diffList.add(new int[]{i-1, i});
          }
        }
          mp.put(nums[i]-nums[i-1], diffList);
        }
      }
      //# of differences * average sequences per difference = 2 * n - 2
      for(Integer k : mp.keySet()) {
        List<int[]> diffList = mp.get(k);
        for(int i = 0; i < diffList.size(); i++) {
          int[] curSeq = diffList.get(i);
          max = Math.max(max, Math.min(curSeq[1]-curSeq[0] + 2, nums.length));
          if(i < (diffList.size()-1)) {
            int[] nextSeq = diffList.get(i+1);
            if(nextSeq[0] == (curSeq[1] + 2) && nums[nextSeq[0]] == (nums[curSeq[1]] + 2 * k)) {
              max = Math.max(max, nextSeq[1]-curSeq[0] + 1);
            }
          }
        }
      }
      return max;
    }

}
