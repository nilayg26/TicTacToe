package GITHUB.TicTacToe;//remove this line before running the code
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
public class TicTacToe{
    static int n;
    static char choice;
        public static void main(String [] args){
        Scanner sc= new Scanner (System.in);
        System.out.println("Size of map is n*n, Enter value of n");
         n= sc.nextInt();
         buildingGame(n);
    }
    public static boolean check(char [][] map,int row, int col,char choice){
                if(map[row][col]=='X' || map[row][col]=='O'){
                    System.out.println("Already placed at that position");
                    return false;
                }
        return true;
    }
    public static boolean checkAll(char [][] map){
        int count =0;
        char[] player={'X','O'};
        for(int k=0;k<2;k++){ 
        for(int i=0;i<n;i++){ //checking same row
            count=0;
            for(int j=0;j<n;j++){
                if(map[i][j]==player[k]){
                    count++;
                }
            }
            if(count==n){
                return true;
            }
        }
        for(int i=0;i<n;i++){ //checking same col
            count=0;
            for(int j=0;j<n;j++){
                if(map[j][i]==player[k]){
                    count++;
                }
            }
            if(count==n){
                return true;
            }
        }
        count=0;
        for(int i=0;i<n;i++){ //checking diagonal 1
          
            if(map[i][i]==player[k]){
                count++;
            }
            if(count==n){
                return true;
            }
        }
        count=0;
        for(int i=0;i<n;i++){ //checking diagonal 2 
            if(map[i][n-1-i]==player[k]){
                count++;
            }
            if(count==n){
                return true;
            }
        }
    }
    return false;
    }
    public static void print(char [][] map){
        for(int i=0;i<n;i++){
            System.out.println(Arrays.toString(map[i]));
        }
    }
    public static void dispIndexMap(){
        int count1=1;
        for(int i=0;i<n;i++){
            int []dupli= new int[n];
            for(int j=0;j<n;j++){
                dupli[j]= count1;
                count1++;
            }
            System.out.println(Arrays.toString(dupli));
        }
    }
    public static void buildingGame(int n){
        HashMap<Integer,int []> search= new HashMap<>();
        int count=1;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                int [] c= new int [2];
                c[0]=i;
                c[1]=j;
                search.put(count,c);
                count++;
            }
        }
        Scanner sc= new Scanner (System.in);
        char [][] map= new char[n][n];
        int row=0;
        int col=0;
        System.out.println("Choose symbol for player 1 ");
        System.out.println("X OR O");
        char [] player  = new char[2];
        player[0]=sc.next().charAt(0);
        if(player[0]=='X'||player[0]=='x'){
            player[0]='X';
            player[1]='O';
        }
        else{
            player[0]='O';
            player[1]='X';
        }
        choice='X';
        System.out.println("Positions are marked as: ");
        dispIndexMap();
        System.out.println("PLAYER 1 is: "+player[0]);
        System.out.println("PLAYER 2 is: "+player[1]);
        int chance=0;
        int num=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                dispIndexMap();
                if(chance%2==0){
                    choice=player[0];
                    System.out.println("Player 1 turn");
                }
                else{
                    choice=player[1];
                    System.out.println("Player 2 turn");
                }
                 num=sc.nextInt();
                 row=search.get(num)[0];
                 col=search.get(num)[1];
                 if(check(map,row,col,choice)){
                    map[row][col]=choice;
                    if(checkAll(map)){
                        print(map);
                        if(chance%2==0){
                        System.out.println("Player 1 won");
                        }
                        else{
                            System.out.println("Player 2 won");
                        }
                        return;
                    }
                    print(map);
                }
                else{
                    j--;
                    continue;
                }
                chance++;
            }
        }
        System.out.println("No Player one! Try Again");
        return;
    }
}