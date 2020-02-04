package algorithm;

import java.util.LinkedList;

public class TrieTree {
    private static TreeNode node;
    class TreeNode{
        char str;
        int count;
        LinkedList<TreeNode> childNodeList;

        public TreeNode(char content){
            str = content;
            count = 0;
            childNodeList = new LinkedList<>();
        }
        //判断字符c是不是字典树的一个节点，如果是的话返回该节点
        public TreeNode subTree(char c){
//            if(node.childNodeList!=null){
            if(childNodeList!=null){
                for(TreeNode tNode:childNodeList){
                    if(c==tNode.str){
                        return tNode;
                    }
                }
            }
            return null;
        }
    }

    public  void insert(String s){
        TreeNode current = node;
        if(search(s)==true){
            return;
        }else{
            for(int i=0;i<s.length();i++){
                if(current.subTree(s.charAt(i))==null){
                    current.childNodeList.add(new TreeNode(s.charAt(i)));
                    current = current.subTree(s.charAt(i));
                }else{
                    current =  current.subTree(s.charAt(i));
                }
            }
        }
    }

    public  boolean search(String s){
        TreeNode current = node;
        for(int i=0;i<s.length()-1;i++){
            if(current.subTree(s.charAt(i))==null){
                return false;
            }else{
                current = current.subTree(s.charAt(i));
            }
        }
        return true;
    }

    public TrieTree(){
        node = new TreeNode(' ');
    }

    public static void main(String[] args) {
        TrieTree trie = new TrieTree();
        trie.insert("balls");
        System.out.println(trie.search("balls"));
        System.out.println(trie.search("bal"));
    }
}
