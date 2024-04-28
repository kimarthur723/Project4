public class Base2Math {
    public static int log2(int num){
        int count = 0;
        while( num > 0){
            num /= 2;
            count++;
        }
        return count;
    }
    public static boolean isPowerOfTwo(int num) {
        while (num < 2) {
            if (num % 2 != 0) {
                return false;
            }
            num /= 2;
        }
        return true;
    }
}
