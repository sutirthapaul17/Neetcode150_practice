package BackTracking;

public class TowerOfHanoi {
    public int towerOfHanoi(int n, int from, int to, int aux) {
        if(n==1) return 1;
        int moves =0;
        moves+=towerOfHanoi(n-1,from,aux,to);
        moves+=1;//move 1 disk from source to destination
        moves += towerOfHanoi(n-1,aux,to,from); //move n-1 disk from aux to source via destination
        return moves;
    }
}
