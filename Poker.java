// import java.util.*;

// public class Poker{
//     //Initialize variables
//     private int suit[] = {1, 2, 3, 4};
//     private int cardHolder[][];
//     private int players;
//     private int playerCards[][];
//     private ArrayList<Integer> sharedCards;

//     //initialize game
//     public  Poker (int playercnt){
//         for(int i=0; i<4; i++){
//             for(int j=0; j<13; j++){
//                 cardHolder[i][j]=-1;
//             }
//         }
//         players=playercnt;
//         playerCards= new int[players][2];
//         for(int i=0; i<playercnt; i++){
//             playerCards[i][0]=drawCard(i);
//             playerCards[i][1]=drawCard(i);
//         }
//         sharedCards.add(drawCard(0));
//         sharedCards.add(drawCard(0));
//         sharedCards.add(drawCard(0));
//     }

//     //draws a card for a given player
//     public int drawCard(int player){
//         int suitrand=(int)(Math.random()*4);
//         int numrand=(int)(Math.random()*13);
//         while(cardHolder[suitrand][numrand]!=-1){
//             suitrand=(int)(Math.random()*4);
//             numrand=(int)(Math.random()*13);
//         }
//         cardHolder[suitrand][numrand]=player;
//         return suitrand*13+numrand;
//     }

//     public int (){

//     }
// }

