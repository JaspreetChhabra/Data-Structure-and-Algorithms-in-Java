package Tries;

import javax.swing.tree.TreeNode;

public class InsertAndSearchPrefix {
    public TrieNode root;

    public InsertAndSearchPrefix(){
        root = new TrieNode();
    }

    public void insert(String word){
        TrieNode node = root;

        for (int i=0; i< word.length(); i++){
            if(!node.containsKey(word.charAt(i)))
                node.insert(word.charAt(i), new TrieNode());

            node = node.get(word.charAt(i));
        }

        node.setEnd();
    }

    public TrieNode searchPrefix(String word){
        TrieNode node = root;

        for (int i=0; i< word.length(); i++){
            if(node.containsKey(word.charAt(i)))
                node = node.get(word.charAt(i));
            else return null;
        }
        return node;
    }

    public boolean searchWord(String word){
        TrieNode node = searchPrefix(word);
        return node != null && node.isEnd();
    }

    public TrieNode delete(String key, int depth, TrieNode node) {

        if (node == null) return null;

        if(key.length() == depth) {

            if(node.isEnd())
                node.resetEnd();

            if (isEmpty(node)) {
                node = null;
            }
            return node;
        }

        node = delete(key, depth +1, node.get(key.charAt(depth)));

        if(node != null && isEmpty(node) && node.isEnd() == false)
            node = null;

        return node;
    }

    private boolean isEmpty(TrieNode node){

        for (int i=0; i< 26; i++){
            if(node.exists(i))
                return false;
        }
        return true;
    }

    public static void main(String[] args){
        InsertAndSearchPrefix insert = new InsertAndSearchPrefix();

        insert.insert("trie");
        System.out.println(insert.searchWord("trie"));
        System.out.println(insert.searchWord("triessss"));
        insert.delete("trie", 0, insert.root);
        System.out.println(insert.searchWord("trie"));
    }
}
