class Solution {
    public boolean winnerOfGame(String colors) {
        int totA = 0, totB = 0, cnt_a = 0, cnt_b = 0;
    for (char ch : colors.toCharArray()) {
        if (ch == 'A') {
            if (++cnt_a > 2)
                ++totA;
            cnt_b = 0;
        } else {
            if (++cnt_b > 2)
                ++totB;
            cnt_a = 0;
        }
    }
    return totA > totB;
    }
}