package com.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class Numbers {
    public static void main(String[] args){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.remove(0);
        var arr = list.toArray();
        System.out.println(Arrays.toString(arr));
        System.out.println(KstPrimeNumber(3));
        int[] array = {3,6,1,9,2};
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));
        System.out.println(coinChange2(6));
        int[] coins = {1,2,5};
        System.out.println(coinChange(coins,11));
        System.out.println(Arrays.asList(1,2,3));
    }
    //翻转数字
    public static boolean isPalindrome(int x){
        if(x<0 || (x%10==0 && x!=0)) return false;
        int rev = 0;
        while(rev < x){
            rev = x%10 + rev*10;
            x = x/10;
        }
        return (rev == x || rev/10 ==x);
    }
    //第k个质数，2算第一个
    public static int KstPrimeNumber(int k){
        if(k == 1) return 2;
        int index = 1;
        int cur = 3;
        while(index < k){
            boolean prime = true;
            for(int i = 2; i*i <= cur; i++){
                if(cur % i == 0){
                    prime = false;
                    break;
                }
            }
            if(prime){
                index++;
            }
            if(index == k){
                return cur;
            }
            cur += 1;
        }
        return cur;
    }
    //凑coin,最少的coin数量
    public static int coinChange(int[] coins, int amount){
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp,max);
        dp[0] = 0;
        for(int i = 1;i <= amount; i++){
            for(int j = 0;j < coins.length; j++){
                if(i >= coins[j]){
                    dp[i] = Math.min(dp[i],dp[i-coins[j]]+1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
    public static int coinChange2(int input){
        int[] coins =  {1,2,5,10,20,50,100,200};
        int amount = input * 100;
        int max = amount +1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp,max);
        dp[0] = 0;
        for(int i = 1; i <= amount; i ++){
            for(int j = 0; j < 8; j++){
                if(i >= coins[j]){
                    //如果找不到就不更新min
                    dp[i] = Math.min(dp[i],dp[i-coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount? -1 : dp[amount];
    }
    public List<List<Integer>> threeSum(int[] nums){
        List<List<Integer>> ans = new ArrayList();
        int len = nums.length;
        if(nums == null || len < 3) return ans;
        Arrays.sort(nums);
        for(int i = 0; i < len; i++){
            if(nums[i] > 0) break;
            if(i > 0 && nums[i] == nums[i - 1]) continue;
            int left = i + 1;
            int right = len - 1;
            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if(sum == 0){
                    ans.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    while(left < right && nums[left] == nums[left + 1]) left++;
                    while(left < right && nums[right] == nums[right - 1]) left++;
                    right--;
                    left++;
                }else if(sum > 0){
                    left++;
                }else{
                    right++;
                }
            }
        }
        return ans;
    }
}
