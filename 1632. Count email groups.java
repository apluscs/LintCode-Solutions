public class Solution {
    /**
     * @param emails: Original email
     * @return: Return the count of groups which has more than one email address in it.
     */
    public int countGroups(List < String > emails) {
        int result = 0;
        HashMap < String, Integer > visited = new HashMap < > ();
        for (String user: emails) {
            String transf = transform(user);
            transf += user.substring(user.indexOf('@'));
            if (visited.containsKey(transf) != true) { //first instance of this email
                visited.put(transf, 1);
                continue;
            }
            if (visited.get(transf) == 1) { //found second instance, group forms
                result++;
                visited.put(transf, 2); //will never be recognized as a group again
            }
        }
        return result;
    }

    private String transform(String user) {
        StringBuilder result = new StringBuilder();
        for (char c: user.toCharArray()) {
            if (c == '@' || c == '+') {
                return result.toString();
            }
            if (c == '.') {
                continue;
            }
            result.append(c);
        }
        return "bad";
    }
}
