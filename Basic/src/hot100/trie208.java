package hot100;
class TrieNode{
    TrieNode[] children;
    boolean isEnd;
    TrieNode(){
        children = new TrieNode[26];
        isEnd = false;
    }
}
public class trie208 {
    TrieNode root;

    public trie208() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode pre = root;
        for(char c : word.toCharArray()){
            int idx = c-'a';
            if(pre.children[idx] == null){
                pre.children[idx] = new TrieNode();
            }
            pre = pre.children[idx]; //可以是一个单词的结尾，也可以是另一个的中间
        }
        pre.isEnd = true;
    }

    public boolean search(String word) {
        TrieNode pre = root;
        for(char c : word.toCharArray()){
            int idx = c-'a';
            if(pre.children[idx] == null){
                return false;
            }
            pre = pre.children[idx];
        }
        return pre.isEnd;
    }

    public boolean startsWith(String prefix) {
        TrieNode pre = root;
        for(char c : prefix.toCharArray()){
            int idx = c-'a';
            if(pre.children[idx] == null){
                return false;
            }
            pre = pre.children[idx];
        }
        return true;
    }
}
