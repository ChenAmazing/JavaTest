package algorithm;

import java.util.HashSet;
import java.util.Scanner;

public class UnionFind {//并查集
    static int[] parent;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int size = scan.nextInt();
        initial(size);
        int k = scan.nextInt();
        int p = 0,q = 0;
        for(int i =0;i<k;i++){
            p = scan.nextInt();
            q = scan.nextInt();
            union(p,q);
        }
        result();
    }
    public static void initial(int size){
        parent = new int[size+1];
        for(int i = 1;i<parent.length;i++){
            parent[i] = i;
        }
    }
    public static int find(int p){
        while(parent[p] != p){
            p = parent[p];
        }
        return p;
    }
    public static void union(int p,int q){
        int findp = find(p);
        int findq = find(q);
        if(findp==findq){
            return;
        }
        else{
            if(findp>findq){
                parent[findq] = findp;
            }else{
                parent[findp] = findq;
            }
        }
    }
    public static void result(){//自行添加其他操作代码
        int rs = 0;
        HashSet<Integer> hs = new HashSet<>();
        for(int i=1;i<parent.length;i++){
            rs = find(i);
            hs.add(rs);
        }
        System.out.println(hs.size());
    }
}
