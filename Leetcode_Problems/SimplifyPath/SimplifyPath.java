package Leetcode_Problems.SimplifyPath;

public class SimplifyPath {
    public String simplifyPath(String path) {
        Stack<String> s = new Stack<>();
        String[] temp = path.split("/");
        for(String d: temp){
            if(d.equals(".") | d.isEmpty()){
                continue;
            }
            else if(d.equals("..")){
                if(!s.isEmpty()){
                    s.pop();
                }
            }
            else
            {
                s.add(d);
            }
        }
        String p = "";
        
        for(String d: s)
        {
            p+="/";
            p+=d;
        }
        return p.length() > 0? p: "/";
        
    }
    
}
