输入一个整数 n ，求1～n这n个整数的十进制表示中1出现的次数。

例如，输入12，1～12这些整数中包含1 的数字有1、10、11和12，1一共出现了5次。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/1nzheng-shu-zhong-1chu-xian-de-ci-shu-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
class Solution {
    public int countDigitOne(int n) {
        int res=0;
        long high=n;
        long cur=0;
        long low=0;
        int i=1;
        while(high!=0){
            high/=10;
            cur=(n/i)%10;
            low=n-n/i*i;
           
            if(cur==0) res+=high*i;
            if(cur==1) res+=high*i+low+1;
            if(cur>=2) res+=(high+1)*i;
            i*=10;
        }
        return res;
    }
}

数字以0123456789101112131415…的格式序列化到一个字符序列中。在这个序列中，第5位（从下标0开始计数）是5，第13位是1，第19位是4，等等。

请写一个函数，求任意第n位对应的数字。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/shu-zi-xu-lie-zhong-mou-yi-wei-de-shu-zi-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
class Solution {
    public int findNthDigit(int n) {
        int i=1;
        for(;n-i*9*Math.pow(10,i-1)>0;i++){
            n-=i*9*Math.pow(10,i-1);
        }
        int minNum=(int)Math.pow(10,i-1)-1;
        int a=n/i;
        int b=n%i;
        int num=minNum+a;
        if(b==0){
            return num%10;
        }
        num++;
        return String.valueOf(num).charAt(b-1)-'0';
    }
}


给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m] 。请问 k[0]*k[1]*...*k[m] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。

答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/jian-sheng-zi-ii-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
class Solution {
    public int cuttingRope(int n) {
        long res=1;
        if(n<=3) return n-1;
        int a=n/3;
        int b=n%3;
        while(a!=1){
            res=res*3%1000000007;
            //res;
            a--;
        }
        if(b==0) return (int)(res*3%1000000007);
        if(b==1) return (int)(res*4%1000000007);
        if(b==2) return (int)(res*6%1000000007);
        return -1;
    }
}

实现函数double Power(double base, int exponent)，求base的exponent次方。不得使用库函数，同时不需要考虑大数问题。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/shu-zhi-de-zheng-shu-ci-fang-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
class Solution {
    public double myPow(double x, int n) {
        double res=1.0;
        int count=n;
        while(count!=0){
            if(count%2!=0){
                res*=x;
            }
            x*=x;
            count/=2;
        }
        return n>0?res:1.0/res;
    }
}

写一个函数 StrToInt，实现把字符串转换成整数这个功能。不能使用 atoi 或者其他类似的库函数。

 

首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。

当我们寻找到的第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字组合起来，作为该整数的正负号；假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。

该字符串除了有效的整数部分之后也可能会存在多余的字符，这些字符可以被忽略，它们对于函数不应该造成影响。

注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换。

在任何情况下，若函数不能进行有效的转换时，请返回 0。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/ba-zi-fu-chuan-zhuan-huan-cheng-zheng-shu-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
class Solution {
    public int strToInt(String str) {
        char[] c=str.trim().toCharArray();
        if(c.length==0) return 0;
        int res=0;
        boolean isMinus=false;
        int i=0;
        if(c[0]=='-'||c[0]=='+'||(c[0]>='0'&&c[0]<='9')){
            if(c[0]=='-'){
                isMinus=true;
                i=1;
            }
            if(c[0]=='+'){
                i=1;
            }
            while(i<c.length&&c[i]>='0'&&c[i]<='9'){
                int a=c[i]-'0';
                if(isUnvalid(res,a)){
                    return isMinus?Integer.MIN_VALUE:Integer.MAX_VALUE;
                }
                res=res*10+a;
                i++;
            }
            return isMinus?-res:res;
        }
        return 0;
    }
    private boolean isUnvalid(int res,int a){
        if(res<Integer.MIN_VALUE/10||(res==Integer.MIN_VALUE/10&&a%10<-8)||
           res>Integer.MAX_VALUE/10||(res==Integer.MAX_VALUE/10&&a%10>7)){
            return true;
        }
        return false;
    }
}

