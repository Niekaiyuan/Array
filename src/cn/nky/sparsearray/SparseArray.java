package cn.nky.sparsearray;

public class SparseArray {

    public static void main(String[] args) {
        //创建一个原始的二维数组11*11
        //0:表示没有棋子，1：表示黑子，2：表示蓝子
        int[][] chessArray1 = new int[11][11];
        chessArray1[1][2] = 1;
        chessArray1[2][3] = 2;
        chessArray1[5][3] = 1;
        System.out.println("原始的二维数组");
        for(int i = 0; i<chessArray1[0].length;i++){
            for(int j = 0; j<chessArray1.length; j++){
                System.out.printf("%d\t",chessArray1[i][j]);
            }
            System.out.println();
        }
        //数组有多少个非零值
        int sum = 0;
        for(int i = 0; i<chessArray1[0].length;i++){
            for(int j = 0; j<chessArray1.length; j++){
                if(chessArray1[i][j]!=0){
                    sum++;
                }
            }
        }
        System.out.println("非零值："+sum);

        //创建稀疏数组
        int[][] sparseArray;
        sparseArray = new int[sum+1][3];
        sparseArray[0][0] = chessArray1[0].length;
        sparseArray[0][1] = chessArray1.length;
        sparseArray[0][2] = sum;

        //给稀疏数组赋值
        int count = 0;
        for (int i = 0; i < chessArray1[0].length; i++) {
            for (int j = 0; j < chessArray1.length; j++) {
                if(chessArray1[i][j]!=0){
                    count++;
                    //横坐标值
                    sparseArray[count][0] = i;
                    //纵坐标值
                    sparseArray[count][1] = j;
                    //该坐标下的值
                    sparseArray[count][2] = chessArray1[i][j];
                }
            }
        }
        System.out.println("稀疏数组的值：");
        System.out.println("row\tcol\tvalue");
        for (int[] aSparseArray : sparseArray) {
            System.out.printf("%d\t%d\t%d\n", aSparseArray[0], aSparseArray[1], aSparseArray[2]);
        }
        //将稀疏数组恢复成原始的二维数组
        int[][] chessArray2 = new int[sparseArray[0][0]][sparseArray[0][1]];

        //在读取稀疏数组后几行的数据（从第二行开始），并付给原始的二维数组
        for (int i = 1; i <sparseArray.length ; i++) {
            //二维数组的行
            int indexx = sparseArray[i][0];
            //二维数组的列
            int indexy = sparseArray[i][1];
            //将稀疏数组的第i行第3列的数据赋值给二维数组
            chessArray2[indexx][indexy] = sparseArray[i][2];
        }
        //输出恢复后的二维数组
        System.out.println("恢复后的二维数组：");
        for(int i = 0; i<chessArray2[0].length;i++){
            for(int j = 0; j<chessArray2.length; j++){
                System.out.printf("%d\t",chessArray2[i][j]);
            }
            System.out.println();
        }
    }
}
