package leetcode.string;


public class LongestCommonPrefix {

	public static void main(String[] args) {
		System.out.println(new LongestCommonPrefix().longestCommonPrefix(new String[]{"ab","a"}));
	}
	
	class Trie {
		int count;
		Trie[] child;
		Trie(){
			child = new Trie[26];
			count = 0;
		}
	}
	
	void makeTrie(Trie root, String str){
		Trie tmp = root;
		int index;
		char[] ch = str.toCharArray();
		for(int i=0; i<ch.length; i++){
			index = ch[i] - 'a';
			if(tmp.child[index] == null){
				tmp.child[index] = new Trie();
				tmp = tmp.child[index];
			} else {
				tmp = tmp.child[index];
				tmp.count++;
			}
		}
	}
	
	public String longestCommonPrefix(String[] strs) {
		if(strs.length == 0) return "";
		if(strs[0].length() == 0) return "";
		if(strs.length == 1 && strs[0].length() != 0) return strs[0];
		Trie root = new Trie();
		String ret = "";
		int len = strs.length;
        for(int i=0; i < len; i++)
        	if(strs[i].length() > 0)
        		makeTrie(root, strs[i]);
        
        char[] ch = strs[0].toCharArray();
        int index;
        for(int i = 0; i<ch.length; i++){
        	index = ch[i] - 'a';
        	if(root.child[index].count == len - 1) {
        		ret += ch[i];
        		root = root.child[index];
        	}
        	else break;
        }
        
        return ret;
    }
}

