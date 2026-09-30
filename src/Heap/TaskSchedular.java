package Heap;

import java.util.*;

public class TaskSchedular {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];

        for(char task : tasks) freq[task-'A']++;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for(int ele : freq) {
            if (ele > 0) {
                maxHeap.offer(ele);
            }
        }

        int time = 0;

        Queue<int[]> coolDownQueue = new LinkedList<>();

        while( !maxHeap.isEmpty() || !coolDownQueue.isEmpty()){
            if(!coolDownQueue.isEmpty() && coolDownQueue.peek()[1] == time){
                maxHeap.offer(coolDownQueue.remove()[0]);
            }
            if(!maxHeap.isEmpty()){
                int remaining = maxHeap.poll();
                remaining--;
                if(remaining>0){
                    coolDownQueue.add(
                            new int[]{remaining, time + n + 1}
                    );

                }
            }
            time++;
        }
        return time;
    }
}
