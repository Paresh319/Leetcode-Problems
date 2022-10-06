package Leetcode_Problems.FindAndReplaceInAString;

public class FindAndReplaceInAString {
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        
        StringBuilder sb = new StringBuilder();
        int j = 0;
        while(j < s.length()){
            sb.append(s.charAt(j++));
        }
        for(int i = 0; i < indices.length; i++){
            if(sb.substring(indices[i]).startsWith(sources[i])) {
                sb.replace(indices[i], indices[i] + sources[i].length(), sources[i]);
            }
        }
        return sb.toString();
    }
    
}
