package BackTracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {

    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        generate("",0,0,n,ans);
        return ans;
    }
    private void generate(String s,int opening,int closing,int n,List<String> ans){
        if(closing == n){
            ans.add(s);
            return;
        }
        if(opening < n) generate(s+'(',opening + 1,closing,n,ans);
        if(opening > closing) generate(s+')',opening,closing + 1,n,ans);
    }
}
