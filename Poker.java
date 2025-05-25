import java.util.Scanner;


public class Poker {
    //Initialize variables
    private int suit[] = {1, 2, 3, 4};
    private int cardHolder[][] = {{-1, -1 , -1, -1}, {-1, -1 , -1, -1}, {-1, -1 , -1, -1}, 
                                {-1, -1 , -1, -1}, {-1, -1 , -1, -1}, {-1, -1 , -1, -1}, 
                                {-1, -1 , -1, -1}, {-1, -1 , -1, -1}, {-1, -1 , -1, -1}, 
                                {-1, -1 , -1, -1}, {-1, -1 , -1, -1}, {-1, -1 , -1, -1}, {-1, -1 , -1, -1}};
    for(int i=0; i<4; i++){
        for(int j=0; j<13; j++){
            cardHolder[i][j]=-1;
        }
    }
}
