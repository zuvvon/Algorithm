class Solution {
    public int solution(int n, int k) {
        
        String baseK = Integer.toString(n, k);

        String[] parts = baseK.split("0");

        int count = 0;

        for (String part : parts) {
            if (part.isEmpty()) continue;
            long num = Long.parseLong(part);
            if (isPrime(num)) {
                count++;
            }
        }

        return count;
    }

    private boolean isPrime(long num) {
        if (num < 2) return false;
        if (num == 2) return true;
        if (num % 2 == 0) return false;

        for (long i = 3; i * i <= num; i += 2) {
            if (num % i == 0) return false;
        }
        return true;
    }
}
