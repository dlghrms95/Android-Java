public class SecretMap {
 
    public static void main(String[] args) {
        int[] arr1;
        int[] arr2;
        
        arr1 = new int[]{9, 20, 28, 18, 11};
        arr2 = new int[]{30, 1, 21, 17, 28};
        printArr(decodeScreetMap(5, arr1, arr2));
        
        arr1 = new int[]{46, 33, 33 ,22, 31, 50};
        arr2 = new int[]{27 ,56, 19, 14, 14, 10};
        printArr(decodeScreetMap(6, arr1, arr2));
    }
    
    public static String[] decodeScreetMap(int n, int[] arr1, int[] arr2) {
        String[] retArr = new String[n];
        for(int i = 0; i < n; i++) {
            retArr[i] = Integer.toBinaryString(arr1[i]|arr2[i])
                    .replace("0", " ")
                    .replace("1", "#");
        }
        return retArr;
    }

    public static void printArr(String[] arr) {
        StringBuilder sb = new StringBuilder();
        for(String str: arr) {
            sb.append(", \""+str+"\"");
        }
        System.out.println(sb.toString().replaceFirst(", ", ""));
    }
}
