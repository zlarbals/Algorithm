/*
모든 지점에서 다른 모든 지점까지의 최소 거리 구하기.
1. 초기 그래프 전체는 최대값으로 초기화
2. 자기 자신으로의 거리는 0으로 초기화
3. 거리 입력
 */


public class FloydWarshall {

    private int[][] result;

    public int[][] getResult() {
        return result;
    }

    public void doFloydWarshall(int[][] graph,int nodeCount){

        //원본 수정 방지.
        result=array2CopyClone(graph);

        for(int k=1;k<=nodeCount;k++){
            for(int i=1;i<=nodeCount;i++){
                for (int j=1;j<=nodeCount;j++){
                    result[i][j]=Math.min(result[i][j],result[i][k]+result[k][j]);
                }
            }
        }
    }

     private int[][] array2CopyClone(int[][] array) {
        int[][] copy = new int[array.length][array[0].length];

        for (int i = 0; i < array.length; i++) {
            copy[i] = array[i].clone();
        }

        return copy;
    }

}
