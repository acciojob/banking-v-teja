package com.driver;

public class CurrentAccount extends BankAccount{
    String tradeLicenseId; //consists of Uppercase English characters only

    public String getTradeLicenseId() {
        return tradeLicenseId;
    }

    public void setTradeLicenseId(String tradeLicenseId) {
        this.tradeLicenseId = tradeLicenseId;
    }

    public CurrentAccount(String name, double balance, String tradeLicenseId) throws Exception {
        // minimum balance is 5000 by default. If balance is less than 5000, throw "Insufficient Balance" exception
        super(name,balance,5000);
        if(balance<5000){
            throw new Exception("Insufficient Balance");
        }
        setTradeLicenseId(tradeLicenseId);
    }

    public char getMaxCountChar(int[] count){
        int max = 0;
        char ch = 0;
        for (int i = 0; i < 26; i++) {
            if (count[i] > max) {
                max = count[i];
                ch = (char)((int)'a' + i);
            }
        }
        return ch;
    }

    public void validateLicenseId() throws Exception {
        // A trade license Id is said to be valid if no two consecutive characters are same
        // If the license Id is valid, do nothing
        // If the characters of the license Id can be rearranged to create any valid license Id
        // If it is not possible, throw "Valid License can not be generated" Exception

        int n = getTradeLicenseId().length();
        if(n==0){
            throw new Exception("valid License can not be generated");
        }
        boolean flag = true;
        for(int i=0;i<n-1;i++){
            char temp1 = getTradeLicenseId().charAt(i);
            char temp2 = getTradeLicenseId().charAt(i+1);
            if(temp1==temp2){
                flag = false;
                break;
            }
        }

        if(flag==false){
            int count[] = new int[26];
            for(int i=0;i<26;i++){
                count[i] = 0;
            }
            for(char ch: getTradeLicenseId().toCharArray()){
                count[(int)ch-(int)'a']++;
            }

            char chMax = getMaxCountChar(count);
            int maxCount = count[(int)chMax - (int)'a'];
            if (maxCount > (n + 1) / 2){
                throw new Exception("valid License can not be generated");
            }

            String res = "";
            for (int i = 0; i < n; i++) {
                res += ' ';
            }
            int ind = 0;
            // filling the most frequently occurring char in the
            // even indices
            while (maxCount > 0) {
                res = res.substring(0, ind) + chMax
                        + res.substring(ind + 1);
                ind = ind + 2;
                maxCount--;
            }
            count[(int)chMax - (int)'a'] = 0;

            // now filling the other Chars, first filling the
            // even positions and then the odd positions
            for (int i = 0; i < 26; i++) {
                while (count[i] > 0) {
                    ind = (ind >= n) ? 1 : ind;
                    res = res.substring(0, ind)
                            + (char)((int)'a' + i)
                            + res.substring(ind + 1);
                    ind += 2;
                    count[i]--;
                }
            }
            setTradeLicenseId(res);
        }

    }

}
