package Tries;

public class TrieNode {

    private int R = 26;
    private TrieNode[] links;
    private boolean isEnd;

    public TrieNode(){
        links = new TrieNode[R];
    }

    public boolean containsKey(char c){
        return links[c - 'a'] != null;
    }

    public TrieNode get(char c){
        return links[c - 'a'];
    }

    public boolean exists(int index){
        return links[index] != null;
    }

    public void insert(char c, TrieNode node){
        links[c - 'a'] = node;
    }

    public void setEnd(){
        isEnd = true;
    }

    public void resetEnd(){
        isEnd = false;
    }

    public boolean isEnd(){
        return isEnd;
    }
}
