package BinarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class TimeBasedKeyValue {

    //wrong solution
//    String key;
//    String val;
//    int timeStamp;
//
//    public TimeMap() {
//
//    }
//
//    public void set(String key, String value, int timestamp) {
//        this.key = key;
//        this.val = value;
//        this.timeStamp = timestamp;
//    }
//
//    public String get(String key, int timestamp) {
//        if(timestamp == this.timeStamp && key==this.key){
//            return val;
//        }else{
//            return null;
//        }
//    }


    class TimeMap {

        class Pair{
            String value;
            int timeStamp;
            Pair(String value,int timeStamp){
                this.value = value;
                this.timeStamp = timeStamp;
            }
        }

        HashMap<String, ArrayList<Pair>> map;

        public TimeMap() {
            map = new HashMap<>();
        }

        public void set(String key, String value, int timestamp) {
            map.putIfAbsent(key,new ArrayList<>());
            map.get(key).add(new Pair(value,timestamp));
        }

        public String get(String key, int timestamp) {
            if(!map.containsKey(key)){
                return "";
            }
            ArrayList<Pair> list = map.get(key);

            int left = 0;
            int right = list.size() - 1;
            String ans = "";

            while(left <= right){
                int mid = left + (right - left ) / 2;
                if(list.get(mid).timeStamp <= timestamp){
                    ans = list.get(mid).value;
                    left = mid+1;
                }else{
                    right = mid -1;
                }
            }

            return ans;
        }
    }
}
