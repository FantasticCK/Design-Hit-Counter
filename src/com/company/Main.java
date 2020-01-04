package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
    }
}

public class HitCounter {
    int[] timestamps;
    int[] hit;
    /** Initialize your data structure here. */
    public HitCounter() {
        timestamps = new int[300];
        hit = new int[300];
    }

    /** Record a hit.
     @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        int idx = timestamp%300;
        if(timestamps[idx]!=timestamp){
            timestamps[idx]=timestamp;
            hit[idx]=1;
        }
        else
            hit[idx]++;
    }

    /** Return the number of hits in the past 5 minutes.
     @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        int count = 0;
        for(int i=0;i<300;i++){
            if(timestamp-timestamps[i]<300)
                count+=hit[i];
        }
        return count;
    }
}