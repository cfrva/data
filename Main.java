•	Token Game and Finding Maximum Score
public static int bagOfTokensScore(int[] tokens, int power) {
    Arrays.sort(tokens);
    int i = 0, j = tokens.length - 1, score = 0, max = 0;
    while (i <= j) {
        if (power >= tokens[i]) { power -= tokens[i++]; score++; max = Math.max(max, score); }
        else if (score > 0) { power += tokens[j--]; score--; }
        else break;
    }
    return max;
}
•	Reversing Words in a String
public static String reverseWords(String s) {
    String[] w = s.trim().split("\\s+");
   String r = "";
    for (int i = w.length - 1; i >= 0; i--)
        r += w[i] + (i > 0 ? " " : "");
    return r;
}


•	Selection Sort
public static void sort(IntTracker[] arr) {
    for (int i = 0; i < arr.length - 1; i++) {
        int minIdx = i;
        for (int j = i + 1; j < arr.length; j++) {
            if (arr[j].getValue() < arr[minIdx].getValue()) minIdx = j;
        }
        IntTracker temp = arr[i];
        arr[i] = arr[minIdx];
        arr[minIdx] = temp;
    }
}






•	Bubble Sort
public static void sort(IntTracker[] arr) {
    for (int i = 0; i < arr.length - 1; i++) {
        for (int j = 0; j < arr.length - i - 1; j++) {
            if (arr[j].getValue() > arr[j + 1].getValue()) {
                IntTracker temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }
    }
}
•	Insertion Sort
public static void sort(IntTracker[] arr) {
    for (int i = 1; i < arr.length; i++) {
        IntTracker key = arr[i];
        int j = i - 1;
        while (j >= 0 && arr[j].getValue() > key.getValue()) {
            arr[j + 1] = arr[j];
            j--;
        }
        arr[j + 1] = key;
    }
}
•	Duplicating Array Elements by Their Value (with IntTracker)
public static int[] expandArray(IntTracker nums) {
    int n=0, k=0;
    for(int i=0;i<nums.size();i++)n+=nums.get(i);
    int [] a=new int[n];
    for(int j;j<nums.size();j++){
    	Arrays.fill(a,k,k+=nums.get(j),nums.get(j));
    }
     Return a;
}

•	Intersection of Two Arrays
public static int[] intersection(int[] arr1, int[] arr2) {
    Set<Integer> set = new HashSet<>();
    Set<Integer> intersect = new HashSet<>();
    for (int n : arr1) set.add(n);
    for (int n : arr2) if (set.contains(n)) intersect.add(n);
    int[] res = new int[intersect.size()];
    int i = 0;
    for (int n : intersect) res[i++] = n;
    return res;
}
•	Password Combination Generation 
static class SafeTask {
    public List<String> findCodes(String digits, int length) {
        List<String> res = new ArrayList<>();
        generate(digits, length, "", res);
        return res;
    }
    private void generate(String d, int l, String cur, List<String> res) {
        if (cur.length() == l) { res.add(cur); return; }
        for (int i = 0; i < d.length(); i++) generate(d, l, cur + d.charAt(i), res);
    }
}
•	Text Compression (Run-Length Encoding)
static class Task {
    public int compress(char[] chars) {
        int index = 0, i = 0;
        while (i < chars.length) {
            int j = i;
            while (j < chars.length && chars[j] == chars[i]) j++;
            chars[index++] = chars[i];
            if (j - i > 1) {
                for (char c : String.valueOf(j - i).toCharArray()) chars[index++] = c;
            }
            i = j;
        }
        return index;
    }
}
•	Longest Common Prefix
static class Task {

    public String longestCommonPrefix(String[] strs) {
        if(strts.length==0)return"";
        String res=strs[0];
        for(String s:strs){
        	while(!s.startsWith(res)){
            res=res.substring(0,res.length()-1);}
        }


        return res;

    }
•	Merging Intersecting Segments
public static int[][] mergeIntervals(int[][] intervals) {
    if (intervals.length <= 1) return intervals;
    Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
    List<int[]> res = new ArrayList<>();
    int[] curr = intervals[0];
    res.add(curr);
    for (int[] interval : intervals) {
        if (interval[0] <= curr[1]) curr[1] = Math.max(curr[1], interval[1]);
        else { curr = interval; res.add(curr); }
    }
    return res.toArray(new int[res.size()][]);
}
•	Restoration of a Unique Travel Route
public static String[] reconstructItinerary(String[][] t) {
    Map<String, String> m = new HashMap<>();
    for (String[] k : t) m.put(k[0], k[1]);
    String s = "";
    for (String k : m.keySet()) {
        if (!m.containsValue(k)) {
            s = k;
            break;
        }
    }
    String[] r = new String[t.length + 1];
    int i = 0;
    while (s != null) {
        r[i++] = s;
        s = m.get(s);
    }
    return r;
}
•	1D Cellular Automaton (Live Cells)
public static int[] gameOfLife1D(int[] cells) {
    int n = cells.length;
    int[] next = new int[n];
    for (int i = 0; i < n; i++) {
        int left = i > 0 ? cells[i - 1] : 0;
        int right = i < n - 1 ? cells[i + 1] : 0;
        next[i] = (left + right == 1) ? 1 : 0; 
    }
    return next;
}
•		Obtaining Hexadecimal Characters from Binary Signals
public static char convertToHexChar(boolean[] bits) {
    int val = 0;
    for (int i = 0; i < bits.length; i++) {
        if (bits[i]) val += Math.pow(2, bits.length - 1 - i);
    }
    if (val <= 9) return (char) ('0' + val);
    return (char) ('A' + val - 10);
}
Rootto leaf
public static boolean rootToLeafSum(TreeNode root, int targetSum) {
    if(root == null) return false;
    if(root.left == null && root.right == null)
        return root.val == targetSum;
    return rootToLeafSum(root.left, targetSum - root.val) ||
           rootToLeafSum(root.right, targetSum - root.val);
}
Treeeeeeeeeeeee
public static boolean isBalanced(TreeNode root) {
    return height(root) != -1;
}

private static int height(TreeNode node) {
    if(node == null) return 0;

    int left = height(node.left);
    int right = height(node.right);

    if(left == -1 || right == -1 || Math.abs(left - right) > 1)
        return -1;

    return Math.max(left, right) + 1;
}
public static boolean isValidBST(TreeNode root) {
    return validate(root, null, null) == 1;
}

private static int validate(TreeNode node, Integer min, Integer max) {
    if (node == null) return 1;

    if ((min != null && node.val <= min) ||
        (max != null && node.val >= max))
        return -1;

    if (validate(node.left, min, node.val) == -1 ||
        validate(node.right, node.val, max) == -1)
        return -1;

    return 1;
}

•	Finding the maximum degree of a general tree
public static int getMaxDegree(Node root) {
    if (root == null) return 0;
    int max = root.children.size();
    for (Node child : root.children) max = Math.max(max, getMaxDegree(child));
    return max;
}

•	The height of a node in a binary tree
public static int getNodeHeight(TreeNode root) {
    if (root == null) return 0;
    return 1 + Math.max(getNodeHeight(root.left), getNodeHeight(root.right));}
•	The depth of a specific node in a binary tree
public static int getDepth(TreeNode root, int target) {
    if (root == null) return -1;
    if (root.val == target) return 0;
    
    int left = getDepth(root.left, target);
    if (left != -1) return left + 1;
    
    int right = getDepth(root.right, target);
    if (right != -1) return right + 1;
    
    return -1;
}
•	Checking a Full Binary Tree
public static boolean isFullTree(TreeNode root) {
    if (root == null) return true;
    if (root.left == null && root.right == null) return true;
    if (root.left != null && root.right != null) {
        return isFullTree(root.left) && isFullTree(root.right);
    }
    return false;
}


•	Finding the Points Closest to a Target
static class PriorityTask {
    public List<Integer> findClosest(int[] nums, int k, int target) {
        List<Integer> list = new ArrayList<>();
        for (int n : nums) list.add(n);
        list.sort((a, b) -> Math.abs(a - target) - Math.abs(b - target));
        return list.subList(0, k);
    }
}

•	Finding the Highest-Value Elements
static class PriorityTask {
    public List<Integer> getTopK(int[] nums, int k) {
        Arrays.sort(nums);
        List<Integer> res = new ArrayList<>();
        for (int i = nums.length - 1; i >= nums.length - k; i--) res.add(nums[i]);
        return res;
    }
}
•	Teemo Attack – Poison Duration
static class Task {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if (timeSeries.length == 0) return 0;
        int total = 0;
        for (int i = 0; i < timeSeries.length - 1; i++) {
            total += Math.min(timeSeries[i + 1] - timeSeries[i], duration);
        }
        return total + duration;
    }
}

•	Finding the First Unique Character
static class StringTask {
    public int firstUniqChar(String s) {
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (s.indexOf(c) == s.lastIndexOf(c)) return i;
        }
        return -1;
    }
}

•	Generating Pascal’s Triangle
static class Task {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) row.add(1);
                else row.add(res.get(i - 1).get(j - 1) + res.get(i - 1).get(j));
            }
            res.add(row);
        }
        return res;
    }}
•	Validating a Mountain Array
static class Task {
    public boolean validMountainArray(int[] arr) {
        if (arr.length < 3) return false;
        int i = 0, n = arr.length;
        while (i + 1 < n && arr[i] < arr[i + 1]) i++;
        if (i == 0 || i == n - 1) return false;
        while (i + 1 < n && arr[i] > arr[i + 1]) i++;
        return i == n - 1;
    }
}

•	Gas Station
static class Task {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total = 0, current = 0, start = 0;
        for (int i = 0; i < gas.length; i++) {
            total += gas[i] - cost[i];
            current += gas[i] - cost[i];
            if (current < 0) { start = i + 1; current = 0; }
        }
        return total >= 0 ? start : -1;
    }
}
•	Caesar Cipher Encryption
static class Task {
    public String encrypt(String s, int shift) {
        String res = "";
        for (char c : s.toCharArray()) {
            if (c >= 'a' && c <= 'z') res += (char) ((c - 'a' + shift) % 26 + 'a');
            else if (c >= 'A' && c <= 'Z') res += (char) ((c - 'A' + shift) % 26 + 'A');
            else res += c;
        }
        return res;
    }
}

