请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一格开始，每一步可以在矩阵中向左、右、上、下移动一格。如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。例如，在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字母用加粗标出）。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/ju-zhen-zhong-de-lu-jing-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
class Solution {
    public boolean exist(char[][] board, String word) {
        int row=board.length;
        int col=board[0].length;
        char[] c=word.toCharArray();
        boolean[][] isVisited=new boolean[row][col];
        for(int i=0;i<row;i++){
            Arrays.fill(isVisited[i],false);
       }
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(board[i][j]==c[0]&&dfs(board,i,j,row,col,c,0,isVisited)){
                    return true;
                }
            }
        }
        return false;
    }
    private boolean dfs(char[][] board,int i,int j,int row,int col,char[] c,int index,boolean[][] isVisited){
        if(index==c.length){
            return true;
        }
        if(i<0||j<0||i>=row||j>=col||isVisited[i][j]||board[i][j]!=c[index]){
            return false;
        }
        
        isVisited[i][j]=true;
        if(dfs(board,i+1,j,row,col,c,index+1,isVisited)||
        dfs(board,i-1,j,row,col,c,index+1,isVisited)||
        dfs(board,i,j+1,row,col,c,index+1,isVisited)||
        dfs(board,i,j-1,row,col,c,index+1,isVisited)){
            return true;
        }

        isVisited[i][j]=false;
        return false;
    }
}

给你一份『词汇表』（字符串数组） words 和一张『字母表』（字符串） chars。

假如你可以用 chars 中的『字母』（字符）拼写出 words 中的某个『单词』（字符串），那么我们就认为你掌握了这个单词。

注意：每次拼写时，chars 中的每个字母都只能用一次。

返回词汇表 words 中你掌握的所有单词的 长度之和。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/find-words-that-can-be-formed-by-characters
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

class Solution {
    public int countCharacters(String[] words, String chars) {
        int[] arr=new int[26];
        for(int i=0;i<chars.length();i++){
            arr[chars.charAt(i)-'a']++;
        }
        int res=0;
        for(String str:words){
            int[] tmp=new int[26];
            int len=0;
            for(int i=0;i<str.length();i++){
                tmp[str.charAt(i)-'a']++;
                if(tmp[str.charAt(i)-'a']<=arr[str.charAt(i)-'a']){
                    len++;
                }else{
                    break;
                }
            }
            if(len==str.length()){
                res+=len;
            }
        }
        return res;
    }
}

请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set=new HashSet<>();
        int max=0;
        int len=0;
        for(int left=0,right=0;right<s.length();right++){
            while(set.contains(s.charAt(right))){
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            max=Math.max(max,right-left+1);
        }
        return max;
    }
}

