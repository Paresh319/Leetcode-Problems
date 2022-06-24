package Leetcode_Problems.UniqueEmailAddresses;

import java.util.HashSet;

public class UniqueEmailAddresses {
    public int numUniqueEmails(String[] emails) {
        HashSet<String> hs = new HashSet<>();

        for(String s: emails)
        {
            int posOfAt = s.indexOf('@');
            String localName = s.substring(0, posOfAt);
            int posOfPlus = localName.indexOf('+');
            if(posOfPlus != -1)
            {
                localName = localName.substring(0, posOfPlus);
            }
            StringBuilder sb = new StringBuilder();

            for(char c: localName.toCharArray())
            {
                if(c != '.')
                {
                    sb.append(c);
                }
            }
            localName = sb.toString();
            sb.append(s.substring(posOfAt, s.length() - 1));
            hs.add(sb.toString());
        }
        return hs.size();
    }
    
}
