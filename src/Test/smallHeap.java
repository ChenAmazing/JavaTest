package Test;

public class smallHeap {//构造小顶堆
    public static void main(String[] args) {
        int[] ar = new int[]{1,11,55,2,14,0,48,100,24,11};
        makeHeap(ar);
    }

    public static void makeHeap(int[] array){
        Node[] nodes = new Node[array.length];
        for(int i=0;i<array.length;i++){
            Node n = new Node();
            nodes[i] = n;
            nodes[i].num = array[i];
            nodes[i].index = i;
        }
        Dg(0,nodes);
        for(Node n:nodes){
            System.out.println(n.num);
        }
    }
    public static void Dg(int n,Node[] nodes){
        if(n>nodes.length-1||n>nodes.length-1){
            return;
        }

        Dg(nodes[n].getLchild(),nodes);
        Dg(nodes[n].getRchild(),nodes);
        Node temp = compare(nodes[n],nodes);
        int t = nodes[n].num;
        nodes[n].num = temp.num;
        nodes[temp.index].num = t;
//        Node tmp = nodes[n];//不能直接更换结点，因为结点里面的index值是在数组赋值时就确定的了
//        nodes[temp.index] = tmp;
//        nodes[n] = temp;
    }
    public static Node compare(Node n,Node[] nodes){

        if(n.getRchild()<=nodes.length-1&&n.getLchild()<=nodes.length-1){
            Node l = nodes[n.getLchild()];
            Node r = nodes[n.getRchild()];
            if(l.num<=r.num&&l.num<n.num){
                return l;
            }else if(r.num<=l.num&&r.num<n.num){
                return r;
            }else{
                return n;
            }
        }else if(n.getRchild()>nodes.length-1&&n.getLchild()>nodes.length-1){
           return n;
        }else{
            Node l = nodes[n.getLchild()];
            if(l.num<n.num){
                return l;
            }else{
                return n;
            }
        }
    }

    static class Node{
        int lchild;
        int rchild;
        int num;
        int index;
        public int getLchild() {
            lchild = index*2 + 1;
            return lchild;
        }

        public int getRchild() {
            rchild = index*2 + 2;
            return rchild;
        }
    }

}
