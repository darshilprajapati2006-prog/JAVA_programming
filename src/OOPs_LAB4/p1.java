package OOPs_LAB4;


public class p1 {

    static int X = 3;
    static int Y = 3;
    static int Z = 3;

    public static void set(int value, int indexX, int indexY, int indexZ, int[] array1D) {
        int index = indexX * (Y * Z) + indexY * Z + indexZ;
        array1D[index] = value;
    }

    public static int get(int indexX, int indexY, int indexZ, int[] array1D) {
        int index = indexX * (Y * Z) + indexY * Z + indexZ;
        return array1D[index];
    }

    public static void main(String[] args) {

        int[] array1D = new int[X * Y * Z];

        set(10, 1, 1, 1, array1D);
        set(25, 2, 0, 2, array1D);

        System.out.println(get(1, 1, 1, array1D));
        System.out.println(get(2, 0, 2, array1D));
    }
}
