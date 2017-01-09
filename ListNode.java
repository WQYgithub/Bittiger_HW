package list;

public class ListNode {
	int val;
	ListNode next;
	ListNode (int x) { 
		val = x; 
	}
	
	//codeLab_week1
	public void deleteNode (ListNode node) {
		node.val = node.next.val;
		node.next = node.next.next;
	}
	
	public ListNode deleteNthFromEnd (ListNode head, int n) {
//		ListNode result = head;
//		if (result != null)
//		{
//			int size = 1;
//			while (result.next != null)
//			{
//				size ++;
//				result = result.next;
//			}
//			
//			int place = size-n+1;
//			result = head;
//			if (place == size)
//			{
//				for (int i = 2; i <= place; i ++)
//				{
//					result = result.next;
//				}
//				result = null;
//			}
//			else if (place < size)
//			{
//				for (int i = 2; i <= place; i ++)
//				{
//					result = result.next;
//				}
//				result.val = result.next.val;
//				result.next = result.next.next;
//			}
//		}
//		
//		return head;
		
		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		
		if (dummy.next != null)
		{
			int size = 0;
			while (dummy.next != null)
			{
				size++;
				dummy = dummy.next;
			}
			
			int place = size-n+1;
			dummy = head.next;
			ListNode temp = dummy;
			for (int i = 1; i < place; i++)
			{
				temp = temp.next;
			}
			ListNode deleted = temp.next;
			temp.next = temp.next.next;
			deleted = null;
		}
		
		return dummy.next;
		
//		ListNode dummy = new ListNode(-1);
//		dummy.next = head;
//		ListNode fast = dummy;
//		ListNode slow = dummy;
//		
//		while (n > 0)
//		{
//			fast = fast.next;
//			n--;
//		}
//		
//		while (fast.next != null)
//		{
//			fast = fast.next;
//			slow = slow.next;
//		}
//		
//		slow.next = slow.next.next;
//		
//		if (head.next == null)
//		{
//			head = null;
//		}
//		
//		return dummy.next;
	}
	
	public ListNode insertNode (ListNode head, ListNode node) {
		//corner case
		if (head == null) {
			return node;
		}
		if (node == null) {
			return head;
		}
		//core logic
		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		while (node.val >= dummy.next.val) {
			dummy = dummy.next;
		}
		node.next = dummy.next;
		dummy.next = node;
		return dummy.next;
	}
	
//	public ListNode reverseList (ListNode head) {
////		ListNode pre = null;
////		ListNode cur = head;
////		while (cur != null) {
////			ListNode temp = cur.next;
////			cur.next = pre;
////			pre = cur;
////			cur = temp;
////		}
////		return pre;
//		
////		return helper(null, head);
//		
//		if (head == null || head.next == null) {
//			return head;
//		}
//		
//		ListNode nextNode = head.next;
//		ListNode reverseHead = reverseList(nextNode);
//		nextNode.next = head;
//		head.next = null;
//		
//		return reverseHead;
//	}
	
//	public ListNode helper (ListNode pre, ListNode head) {
//		if (head == null) {
//			return pre;
//		}
//		
//		ListNode tmp = head.next;
//		head.next = pre;
//		pre = head;
//		head = tmp;
//		return helper(pre, head);
//	}
	
	
	
	//hw_week1
	
	//369. Plus One Linked List
	public ListNode plusOne (ListNode head) {
		//reverse head list
		ListNode newHead = reverseList(head);
		ListNode dummy = new ListNode(-1);
		dummy.next = newHead;
		int one = 1, result = newHead.val+one;
		//add one from newHead to before last
		while (newHead.next != null) {
			result = newHead.val+one;
			if (result < 10) {
				newHead.val = result;
				result = 0;
				one = 0;
				break;
			}
			else {
				one = result/10;
				result = result%10;
				newHead.val = result;
				newHead = newHead.next;
			}
		}
		//if condition add last
		if (one != 0) {		
			result = newHead.val+one;
			if (result == 10) {			
				newHead.val = result%10;
				ListNode last = new ListNode(one);
				newHead.next = last;
			}
			if (result < 10 && result > 0) {
				newHead.val = result;
			}
		}
		//reverse newHead list
		head = reverseList(dummy.next);
		//get result
		return head;
	}
	
	public ListNode reverseList (ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		
		ListNode nextNode = head.next;
		ListNode reverseHead = reverseList(nextNode);
		nextNode.next = head;
		head.next = null;
		return reverseHead;
	}
	
//	public ListNode plusOne (ListNode head) {
//		if (head == null) {
//			return null;
//		}
//		if (head.next == null) {
//			int one = 1;
//			int result = one+head.val;
//			if (result > 1 && result < 10) {
//				head.val = result;
//			}
//			else if (result == 10) {
//				head.val = 0;
//				ListNode last = new ListNode (1);
//				last.next = head;
//				head = last;
//			}
//			return head;
//		}
//		head = head.next;
//		return plusOne(head);
//	}
	
//	public int[] plusOne(int[] digits) {
//		//corner case
//		if (digits.length == 0) {
//			return digits;
//		}
//		//core logic
//        StringBuffer result1 = new StringBuffer();
//        for (int i: digits) {
//        	result1.append(i);
//        }
//        String result2 = result1.toString();
//        System.out.println(result2);
//        Long number = Long.parseLong(result2);
//        number++;
//        result2 = ""+number;
//        int length = result2.length();
//        System.out.println(result2 + " " + length);
//        int [] result3 = new int[length];
//        for (int i = length-1; i >= 0; i--) {
//        	result3[i] = (int) (number%10);
//        	number = number/10;
//        }
//        return result3;
//    }
	
	// 66. Plus One
	public int [] plusOne (int [] digits) {
		int length = digits.length;
		int one = 1;
		int result = one+digits[length-1];
		for (int i = length-1; i >= 1; i--) {
			result = one+digits[i];
			if (result < 10) {
				digits [i] = result;
				one = 0;
				result = 0;
				break;
			}
			else if (result == 10) {
				digits[i] = result%10;
				one = result/10;
			}
		}
		
		if (one != 0) {
			result = one+digits[0];
			if (result < 10) {
				digits [0] = result;
				return digits;
			}
			else if (result == 10) {
				int [] newDigits = new int[length+1];
				digits[0] = result%10;
				newDigits[0] = result/10;
				for (int i = 0; i < length; i++) {
					newDigits[i+1] = digits[i];
				}
				return newDigits;
			}
		}
		return digits;
	}
	
	// 67. AddBinary 
	public String addBinary(String a, String b) {
		//corner case
		if (a.length() == 0) {
			return b;
		}
		if (b.length() == 0) {
			return a;
		}
		//core logic
		//get lengthA, lengthB arrayA, arrarB and minLength
        int lengthA = a.length();
        int lengthB = b.length();
        int [] arrayA = new int[lengthA];
        int [] arrayB = new int[lengthB];
        for (int i = 0; i <= lengthA-1; i++) {
        	arrayA[i] = Integer.parseInt("" + a.charAt(i));
        }
        for (int i = 0; i <= lengthB-1; i++) {
        	arrayB[i] = Integer.parseInt("" + b.charAt(i));
        }       
        int minLength = 0;
        if (lengthA >= lengthB) {
        	minLength = lengthB;
        }
        else {
        	minLength = lengthA;
        }
        //add both of A and B
        StringBuffer result = new StringBuffer();
        int add = 0, sum = 0;
        for (int i = 1; i <= minLength; i ++) {
        	sum = add+arrayA[lengthA-i]+arrayB[lengthB-i];
        	if (sum == 0) {
        		add = 0;
        		result.append("0");
        	}
        	else if (sum == 1) {
        		add = 0;
        		result.append("1");
        	}
        	else if (sum == 2) {
        		add = 1;
        		result.append("0");
        	}
        	else if (sum == 3) {
        		add = 1;
        		result.append("1");
        	}
        }
        //add A or B
        if (lengthA == lengthB) {
        	if (add == 1) {
        		add = 0;
        		result.append("1");
        	}
        }
        else if (lengthA < lengthB) {
        	for (int i = lengthB-lengthA-1; i >= 0; i--) {
        		sum = add + arrayB[i];
        		if (sum == 0) {
            		add = 0;
            		result.append("0");
            	}
            	else if (sum == 1) {
            		add = 0;
            		result.append("1");
            	}
            	else if (sum == 2) {
            		add = 1;
            		result.append("0");
            	}
        	}
        }
        else if (lengthA > lengthB) {
        	for (int i = lengthA-lengthB-1; i >= 0; i--) {
        		sum = add + arrayA[i];
        		if (sum == 0) {
            		add = 0;
            		result.append("0");
            	}
            	else if (sum == 1) {
            		add = 0;
            		result.append("1");
            	}
            	else if (sum == 2) {
            		add = 1;
            		result.append("0");
            	}
        	}
        }
        if (add == 1) {
        	result.append("1");
        }
        return result.reverse().toString();
    }
	
	//151. Reverse Words in a String
	public String reverseWords(String s) {
		//corner case
		if (s.length() == 0) {
			return s;
		}
		//core logic
		String [] splitS = s.trim().split("\\s+");
		StringBuffer result = new StringBuffer();
		for (int i = splitS.length-1; i >= 0; i--) {
			result.append(splitS[i] + " ");
		}
		return result.toString().trim();
    }
	
	//61. Rotate List
	public ListNode rotateRight(ListNode head, int k) {
		//corner case
		if (head == null) {
			return head;
		}
		//get length and k
		ListNode tmp = head;
		int length = 0;
		while (tmp != null) {
			length++;
			tmp = tmp.next;
		}
		k = k%length;
		//corner case
		if (k == 0) {
			return head;
		}
		//core logic
		int place = length-k;
		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		for (int i = 1; i <= place; i ++) {
			dummy = dummy.next;
		}
		ListNode result = dummy.next;
		dummy.next = null;
		tmp = result;
		for (int i = place+1; i <= length-1; i++) {
			tmp = tmp.next;
		}
		tmp.next = head;
		return result;
	}
	
	
	//8. String to Integer (atoi)
	public int myAtoi(String str) {
		//corner case
		if (str == null || str.length() == 0) {
			return 0;
		}
		//corner case
		str = str.trim();
		if (str == null || str.length() == 0) {
			return 0;
		}
		//get qualifiedStr
		int sign = 1;
		if (str.charAt(0) == '+') {
			sign = 1;
			str = str.substring(1);
		}
		else if (str.charAt(0) == '-') {
			sign = -1;
			str = str.substring(1);
		}
		StringBuffer qualifiedStr = new StringBuffer();
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
				qualifiedStr.append(str.charAt(i));
			}
			else {
				break;
			}
		}
		//corner case
		if (qualifiedStr.toString() == null || qualifiedStr.toString().length() == 0) {
			return 0;
		}
		//get result
		long result = 0;
		if (qualifiedStr.toString().length() > 10) {
			if (sign > 0) {
				result = Integer.MAX_VALUE;
			}
			else {
				result = Integer.MIN_VALUE;
			}
		}
		else {
			result = sign*Long.parseLong(qualifiedStr.toString());
			if (result > Integer.MAX_VALUE) {
				result = Integer.MAX_VALUE;
			}
			else if (result < Integer.MIN_VALUE) {
				result = Integer.MIN_VALUE;
			}
		}
		return (int)result;
    }
	
	//1. Two Sum
	public int[] twoSum(int[] nums, int target) {
        int [] result = new int[2];
        findResult:
        for (int i = 0; i <= nums.length-1; i++) {
        	for (int j = i+1; j <= nums.length-1; j++) {
        		if ((nums[i]+nums[j]) == target) {
        			result[0] = i;
        			result[1] = j;
        			break findResult;
        		}
        	}
        }
        return result;
    }
	
	//167. Two Sum II - Input array is sorted
	public int[] twoSumTwo(int[] numbers, int target) {
        int [] result = new int[2];
        findResult:
        for (int i = 0; i <= numbers.length-1; i++) {
        	for (int j = i+1; j <= numbers.length-1; j++) {
        		if ((numbers[i]+numbers[j]) == target) {
        			result[0] = i+1;
        			result[1] = j+1;
        			break findResult;
        		}
        	}
        }
        return result;
    }
	
	//75. Sort Colors
	public void sortColors(int[] nums) {
        int length = nums.length;
        int tmp = 0;
        for (int i = 1; i <=length-1; i++) {
        	for (int j = 0; j <= length-1-i; j++) {
        		if (nums[j] > nums[j+1]) {
        			tmp = nums[j];
        			nums[j] = nums[j+1];
        			nums[j+1] = tmp;
        		}
        	}
        }
        for (int i:nums) {
        	System.out.println(i);
        }
    }
	
	//21. Merge Two Sorted Lists
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //corner case
		if (l1 == null) {
			return l2;
		}
		if (l2 == null) {
			return l1;
		}
		//core logic
		ListNode dummy = new ListNode(-1);
		ListNode result = dummy;
		while (l1 != null) {
			if (l2 != null) {
				if (l1.val <= l2.val) {
					dummy.next = l1;
					dummy = dummy.next;
					l1 = l1.next;
				}
				else {
					dummy.next = l2;
					dummy = dummy.next;
					l2 = l2.next;
				}
			}
			else {
				break;
			}
		}
		//corner case
		if (l1 == null) {
			dummy.next = l2;
		}
		if (l2 == null) {
			dummy.next = l1;
		}
		//get result
		return result.next;
    }
	
	//189. Rotate Array
	public void rotate(int[] nums, int k) {
        //corner case
		if (nums.length == 0) {
			return;
		}
		//get k and length
		int n = nums.length;
		k = k%n;
		//corner case
		if (k == 0) {
			return;
		}
		//core logic
		int [] newNums = new int[n];
		for (int i =0; i <= n-1; i++) {
			if (i >= n-k) {
				newNums[i-(n-k)] = nums[i];
			}
			else {
				newNums[k+i] = nums[i];
			}
		}
		for (int i = 0; i <= n-1; i++) {
			nums[i] = newNums[i];
		}
    }
	
	//48. Rotate Image
    public void rotate(int[][] matrix) {
    	//corner case
    	if (matrix.length == 0 || matrix.length == 1) {
    		return;
    	}
    	//core logic
    	int n = matrix.length;
        int [][] rotateM = new int [n][n];
        for (int i = 0; i < n; i++) {
        	for (int j = 0; j < n; j++) {
        		rotateM[j][n-1-i] = matrix[i][j];
        	}
        }
        for (int i = 0; i < n; i++) {
        	for (int j = 0; j < n; j++) {
        		matrix[i][j] = rotateM[i][j];
        	}
        } 
    }
    
    //28. Implement strStr()
    public int strStr(String haystack, String needle) {
        //corner case
    	if (haystack == null || needle == null) {
    		return -1;
    	}
    	//get length1, length2
    	int length1 = haystack.length();
    	int length2 = needle.length();
    	//corner case
    	if (length1 == 0) {
    		if (length2 == 0) {
    			return 0;
    		}
    		else {
    			return -1;
    		}
    	}
    	if (length2 == 0) {
    		return 0;
    	}
    	if (length2 > length1) {
    		return -1;
    	}
    	//core logic
    	int result = -1;
    	int n = length1 -length2;
    	for (int i = 0; i <=n; i++) {
    		int count = 0;
    		for (int j = 0; j <= length2-1; j++) {			
    			if (haystack.charAt(i+j) == needle.charAt(j)) {
    				count++;
    			}
    			else {
    				break;
    			}
    		}
    		if (count == length2) {
    			result = i;
    			break;
    		}
    	}
    	return result;
    }
	
    //344. Reverse String
	public String reverseString(String s) {
		//corner case
		if (s == null || s.length() == 0) {
			return s;
		}
		//core logic
        StringBuffer reverseS = new StringBuffer();
        int length = s.length();
        for (int i = length-1; i >= 0; i--) {
        	reverseS.append(s.charAt(i));
        }
        return reverseS.toString();
    }
	
	//415. Add Strings
	public String addStrings(String num1, String num2) {
        //corner case
		if (num1 == null || num1.length() == 0) {
			return num2;
		}
		if (num2 == null || num2.length() == 0) {
			return num1;
		}
		//get length1,length2
		StringBuffer result = new StringBuffer();
		int add = 0, sum = 0;
		int length1 = num1.length(), length2 = num2.length();
		//core logic
		if (length1 > length2) {
			int j = length2-1;
			for (int i = length1-1; i >= 0; i--) {
				if (j >= 0) {
					sum = (num1.charAt(i)-'0')+(num2.charAt(j)-'0')+add;
					add = sum/10;
					sum = sum%10;				
					result.append(sum);
					j--;
				}
				else {
					if (add == 0) {
						result.append(num1.charAt(i));
					}
					else if (add == 1){
						sum = (num1.charAt(i)-'0')+add;
						add = sum/10;
						sum = sum%10;
						result.append(sum);
					}
				}
			}
			if (add == 1) {
				result.append(1);
			}
		}
		else if (length1 < length2) {
			int j = length1-1;
			for (int i = length2-1; i >= 0; i--) {
				if (j >= 0) {
					sum = (num2.charAt(i)-'0')+(num1.charAt(j)-'0')+add;
					add = sum/10;
					sum = sum%10;
					result.append(sum);
					j--;
				}
				else {
					if (add == 0) {
						result.append(num2.charAt(i));
					}
					else if (add == 1){
						sum = (num2.charAt(i)-'0')+add;
						add = sum/10;
						sum = sum%10;
						result.append(sum);
					}
				}
			}
			if (add == 1) {
				result.append(1);
			}
		}
		else if (length1 == length2) {
			for (int j = length2-1; j >= 0; j--) {
				sum = (num1.charAt(j)-'0')+(num2.charAt(j)-'0')+add;
				add = sum/10;
				sum = sum%10;
				result.append(sum);
			}
			if (add == 1) {
				result.append(1);
			}
		}
		return result.reverse().toString();	
    }
	
	//Find if an array can be divided into two subArrays of equal sum
	public boolean beDivided (int [] array) {
		//corner case
		int length = array.length;
		if (length == 0 || length == 2) {
			return false;
		}
		if (length == 1) {
			return true;
		}
		//get sum
		int left = 0, right = 0, sum = 0;
		for (int i = 0; i < length; i++) {
			sum = sum+array[i];
		}
		//core logic
		boolean isDivided = false;
		for (int i = 1; i <= length-2; i++) {
			left = left+array[i-1];
			right = sum-left-array[i];
			if (left == right) {
				isDivided = true;
				break;
			}
		}
		return isDivided;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
//		node2 = null;
//		System.out.println(node1.next.val);
		
//		ListNode node5 = new ListNode(9);
//		System.out.println(node1.plusOne(node1).val);
		
//		int [] a = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
//		int [] b = {1, 2};
//		System.out.println(node1.addStrings("1", "9"));
	}
}













