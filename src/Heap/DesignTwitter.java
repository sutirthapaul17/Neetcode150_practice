package Heap;

import java.util.*;

public class DesignTwitter {

    static int timeStamp;
    Map<Integer, List<int[]>> tweetMap = new HashMap<>();
    Map<Integer,Set<Integer>> followMap = new HashMap<>();
    PriorityQueue<int[]> minHeap = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[1], b[1])
    );


    public DesignTwitter() {
        timeStamp = 0;
    }

    public void postTweet(int userId, int tweetId) {
        if(!tweetMap.containsKey(userId)){
            tweetMap.put(userId,new ArrayList<>());
        }
        tweetMap.get(userId).add(new int[]{tweetId,timeStamp++});

    }

    public List<Integer> getNewsFeed(int userId) {
        minHeap.clear();

        if(tweetMap.containsKey(userId)) {
            for (int[] tweet : tweetMap.get(userId)) {

                if (minHeap.size() < 10) {
                    minHeap.add(tweet);
                }
                else if (tweet[1] > minHeap.peek()[1]) {
                    minHeap.poll();
                    minHeap.add(tweet);
                }
            }
        }
        //Add tweets from followed users
        if(followMap.containsKey(userId)){
            Set<Integer> followees = followMap.get(userId);

            for(int followeeId : followees){
                if(!tweetMap.containsKey(followeeId)){
                    continue;
                }
                for (int[] tweet : tweetMap.get(followeeId)) {

                    if (minHeap.size() < 10) {
                        minHeap.add(tweet);
                    }
                    else if (tweet[1] > minHeap.peek()[1]) {
                        minHeap.poll();
                        minHeap.add(tweet);
                    }
                }
            }
        }

        List<Integer> ans = new ArrayList<>();

        while (!minHeap.isEmpty()) {
            ans.add(0, minHeap.poll()[0]);
        }
        return ans;
    }

    public void follow(int followerId, int followeeId) {
        if(!followMap.containsKey(followerId)){
            followMap.put(followerId,new HashSet<>());
        }
        followMap.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if(!followMap.containsKey(followerId)){
            return;
        }
        followMap.get(followerId).remove(followeeId);
    }
}
