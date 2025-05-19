// https://www.geeksforgeeks.org/problems/n-meetings-in-one-room-1587115620/1

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NMeetingsInOneRoom {
    public static void main(String[] args) {
        int[] start = {1, 3, 0, 5, 8, 5};
        int[] finish = {2, 4, 6, 7, 9, 9};
        ActivitySelection as = new ActivitySelection();
        int maxActivities = as.activitySelection(start, finish);
        System.out.println("Maximum number of activities: " + maxActivities);
    }

    public int maxMeetings(int start[], int finish[]) {
        int n = start.length;
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < n; i++)  {
            list.add(new int[]{start[i], finish[i]});
        }

        Collections.sort(list, (a, b) -> Integer.compare(a[1], b[1]));

        int ans = 1;
        int last = list.get(0)[1];
        for (int i = 1; i < n; i++) {
            if (list.get(i)[0] > last) {
                ans++;
                last = list.get(i)[1];
            }
        }
        return ans;
    }
}
