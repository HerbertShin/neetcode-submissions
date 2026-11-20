class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int r = 0;

        for (int pile : piles) {
            r = Math.max(r, pile);
        }

        if (piles.length == h) return r;

        int k = 1_000_000;

        while (l <= r) {
            int m = l + (r - l) / 2;

            if (validK(m, piles, h)) {
                k = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }

        return k;
    }

    private boolean validK(int k, int[] piles, int h) {
        int elapsedHours = 0;

        for (int pile : piles) {
            elapsedHours += Math.ceil(pile / (double) k);
        }

        if (elapsedHours > h) return false;

        return true;
    }
}
