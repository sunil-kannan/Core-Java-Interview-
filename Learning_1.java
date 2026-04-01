import java.util.Arrays;
import java.util.*;


// CPU task scheduling problem with cooldown.

public class Learning_1 {
    public static void main(String[] args) {
        int n = 5, cooldown = 1, m = 2;
        int[][] tasks = new int[][]{{1,3},{2,5},{4,6},{6,7},{5,8}};
        List<int[]> tasksList = new ArrayList<>(Arrays.asList(tasks));
        Arrays.sort(tasks, Comparator.comparingInt(a -> a[1]));
        int count = 0;
        int lastEnd = -1;
        List<List<int[]>> executed = new ArrayList<>();

        while(!tasksList.isEmpty()){
            Iterator<int[]> iterator = tasksList.iterator();
            List<int[]> arr = new ArrayList<>();
            while (iterator.hasNext()) {
                int[] t = iterator.next();
                if(m <= arr.size()){
                    break;
                }
                if (t[0] >= lastEnd + cooldown) {
                    lastEnd = t[1];
                    arr.add(t);
                    iterator.remove();
                }
            }
            executed.add(arr);
            lastEnd = -1;
            count++;
        }


        System.out.println("Maximum tasks CPU can execute: " + count);
        System.out.println("Executed tasks: "+count);
        for (List<int[]> arr : executed) {
            for(int[] i : arr){
                System.out.print(Arrays.toString(i));
            }
            System.out.println();
        }

    }
}
