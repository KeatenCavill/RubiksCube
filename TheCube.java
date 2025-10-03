package RubiksCube;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class TheCube {

    //creates the cube
    static String[][] cube ={{
        " r "," r "," r ",
        " r "," r "," r ",
        " r "," r "," r ",
        },{
        " b "," b "," b ",
        " b "," b "," b ",
        " b "," b "," b ",
        },{
        " o "," o "," o ",
        " o "," o "," o ",
        " o "," o "," o ",
        },{
        " g "," g "," g ",
        " g "," g "," g ",
        " g "," g "," g ",
        },{
        " y "," y "," y ",
        " y "," y "," y ",
        " y "," y "," y ",
        },{
        " w "," w "," w ",
        " w "," w "," w ",
        " w "," w "," w ",
        }
    };

    //prints the cube
    public void showcube() {
        int index = 0;
        for(int x=0; x<6; x++){
            for(int y=0; y<3; y++){
                for(int z=0; z<3; z++){
                    System.out.print(cube[x][index++]);
                }
                System.out.println();
            }
            index = 0;
            System.out.println();
        }
    }


    //determins cubes edges
    class edgeFace{
        public int CurrentFace;
        int[] edge1 = new int[4];
        int[] edge2 = new int[4];
        int[] edge3 = new int[4];
        int[] edge4 = new int[4];


        public edgeFace(int face){
        CurrentFace = face;

        
            // Orientation:
            // 0 = Red 
            // 1 = Blue 
            // 2 = Orange
            // 3 = Green 
            // 4 = Yellow
            // 5 = White 

        switch(face){
            case 0: //red
            edge1[0] = 1; //blue,right
            edge1[1] = 2;
            edge1[2] = 5;
            edge1[3] = 8;

            edge2[0] = 4; //yellow,top
            edge2[1] = 2;
            edge2[2] = 5;
            edge2[3] = 8;

            edge3[0] = 3; //green,right
            edge3[1] = 0;
            edge3[2] = 3;
            edge3[3] = 6;

            edge4[0] = 5; //white,bottom
            edge4[1] = 2;
            edge4[2] = 5;
            edge4[3] = 8;
            break;

            case 1: //blue
            edge1[0] = 2; //orange,left
            edge1[1] = 2;
            edge1[2] = 5;
            edge1[3] = 8; 

            edge2[0] = 4; //yellow,top
            edge2[1] = 6;
            edge2[2] = 7;
            edge2[3] = 8;

            edge3[0] = 0; //red,right
            edge3[1] = 0;
            edge3[2] = 3;
            edge3[3] = 6;

            edge4[0] = 5; //white,bottom
            edge4[1] = 0;
            edge4[2] = 1;
            edge4[3] = 2;
            break;

            case 2://orange
            edge1[0] = 3; //green,left
            edge1[1] = 2;
            edge1[2] = 5;
            edge1[3] = 8;

            edge2[0] = 4; //yellow,top
            edge2[1] = 0;
            edge2[2] = 3;
            edge2[3] = 6; 

            edge3[0] = 1; //blue,right
            edge3[1] = 0;
            edge3[2] = 3;
            edge3[3] = 6;

            edge4[0] = 5; //white,bottom
            edge4[1] = 0;
            edge4[2] = 3;
            edge4[3] = 6;
            break;

            case 3://green
            edge1[0] = 0; //red,right
            edge1[1] = 2;
            edge1[2] = 5;
            edge1[3] = 8;

            edge2[0] = 4; //yellow,top
            edge2[1] = 0;
            edge2[2] = 1;
            edge2[3] = 2;

            edge3[0] = 2; //orange,Right
            edge3[1] = 0;
            edge3[2] = 3;
            edge3[3] = 6;

            edge4[0] = 5; //white,bottom
            edge4[1] = 6;
            edge4[2] = 7;
            edge4[3] = 8;
            break;

            case 4://yellow
            edge1[0] = 2; //orage,left
            edge1[1] = 0;
            edge1[2] = 1;
            edge1[3] = 2;
            
            edge2[0] = 3; //green,top
            edge2[1] = 0;
            edge2[2] = 1;
            edge2[3] = 2;

            edge3[0] = 0; //red,right
            edge3[1] = 0;
            edge3[2] = 1;
            edge3[3] = 2;

            edge4[0] = 1; //blue,bottom
            edge4[1] = 0;
            edge4[2] = 1;
            edge4[3] = 2; 

            break;

            case 5://white
            edge1[0] = 2; //oragne,left
            edge1[1] = 6;
            edge1[2] = 7;
            edge1[3] = 8;

            edge2[0] = 1; //blue,top
            edge2[1] = 6;
            edge2[2] = 7;
            edge2[3] = 8;

            edge3[0] = 0; //red,right
            edge3[1] = 6;
            edge3[2] = 7;
            edge3[3] = 8;

            edge4[0] = 3; //green,bottom
            edge4[1] = 6;
            edge4[2] = 7;
            edge4[3] = 8;
            break;
        }
        }
    }

    //sets new faces
    public void turnFace(int index, String direction){
        edgeFace eface = new edgeFace(index);

        String[][] copy = new String[6][9];

        for(int i=0; i<6; i++){
            for(int j=0; j<9; j++){
                copy[i][j] = cube[i][j];
            }
        }

        // clockwise movement
        if(direction.equals("c")){
            cube[eface.CurrentFace][0] = copy[eface.CurrentFace][2];
            cube[eface.CurrentFace][1] = copy[eface.CurrentFace][5];
            cube[eface.CurrentFace][2] = copy[eface.CurrentFace][8];
            cube[eface.CurrentFace][3] = copy[eface.CurrentFace][1];
            cube[eface.CurrentFace][5] = copy[eface.CurrentFace][7];
            cube[eface.CurrentFace][6] = copy[eface.CurrentFace][0];
            cube[eface.CurrentFace][7] = copy[eface.CurrentFace][3];
            cube[eface.CurrentFace][8] = copy[eface.CurrentFace][6];

            cube[eface.edge2[0]][eface.edge2[1]] =copy[eface.edge1[0]][eface.edge1[1]];
            cube[eface.edge2[0]][eface.edge2[2]] =copy[eface.edge1[0]][eface.edge1[2]];
            cube[eface.edge2[0]][eface.edge2[3]] =copy[eface.edge1[0]][eface.edge1[3]];
            
            cube[eface.edge3[0]][eface.edge3[1]] =copy[eface.edge2[0]][eface.edge2[1]];
            cube[eface.edge3[0]][eface.edge3[2]] =copy[eface.edge2[0]][eface.edge2[2]];
            cube[eface.edge3[0]][eface.edge3[3]] =copy[eface.edge2[0]][eface.edge2[3]];
            
            cube[eface.edge4[0]][eface.edge4[1]] =copy[eface.edge3[0]][eface.edge3[1]];
            cube[eface.edge4[0]][eface.edge4[2]] =copy[eface.edge3[0]][eface.edge3[2]];
            cube[eface.edge4[0]][eface.edge4[3]] =copy[eface.edge3[0]][eface.edge3[3]];

            cube[eface.edge1[0]][eface.edge1[1]] =copy[eface.edge4[0]][eface.edge4[1]];
            cube[eface.edge1[0]][eface.edge1[2]] =copy[eface.edge4[0]][eface.edge4[2]];
            cube[eface.edge1[0]][eface.edge1[3]] =copy[eface.edge4[0]][eface.edge4[3]];

        // counter clockwise movement
        } else if (direction.equals("cc")){
            turnFace(index, "c");
            turnFace(index, "c");
            turnFace(index, "c");
        }

    }

    // creates moves
    public void U(){
        turnFace(4, "c");
    }
    public void UPrime(){
        turnFace(4, "cc");
    }
    public void D(){
        turnFace(5, "c");
    }
    public void DPrime(){
        turnFace(5, "cc");
    }
    public void L(){
        turnFace(2, "c");
    }
    public void LPime(){
        turnFace(2, "cc");
    }
    public void R(){
        turnFace(0, "c");
    }
    public void RPrime(){
        turnFace(0, "cc");
    }
    public void F(){
        turnFace(1, "c");
    }
    public void FPrime(){
        turnFace(1, "cc");
    }
    public void B(){
        turnFace(3, "c");
    }
    public void BPrime(){
        turnFace(3, "cc");
    }
    

    static Stack<String> Moves = new Stack<>();

    // creates solution in stack
    static void solve(Stack<String> Moves){
        while(!Moves.empty()){
            String move = Moves.pop();
            String reverse = (move.contains("'")) ? move.substring(0, 1) : move + "'";
            System.out.print(reverse + " ");
        }
    }

    //creates solution in arraylist
    static void Solve(Stack<String> Moves, ArrayList<String> Solution){
        while(!Moves.empty()){
            String move = Moves.pop();
            String reverse = (move.contains("'")) ? move.substring(0, 1) : move + "'";
            System.out.print(reverse + " ");
            Solution.add(reverse);
        }
    }



    public static void main(String[] args)  
    {
        
        TheCube  RubikCube = new TheCube();
        Scanner scn = new Scanner(System.in);
        
    
        int argsRunIndex = 0;

        ArrayList<String> solution = new ArrayList<>();

        boolean proceed = true;

        System.out.println();
        System.out.println("WELLCOME TO THE CUBE");
        System.out.println("Use U, D, R, L, F, B, to move the cube clockwise, add ' to move counterclockwise");
        System.out.println("Q to quit, S to see solution, and E to show cube and inputs again");
        System.out.println();

        while(proceed){
            String input;

            if(args.length > argsRunIndex){
                input = args[argsRunIndex];
                argsRunIndex++;
            } else{
                RubikCube.showcube();
                input = scn.nextLine();
            }
           
            // all possible imputs
            switch(input.toUpperCase()){
                case "U":
                 RubikCube.U();
                Moves.push(input.toUpperCase());
                break;
                
                case "U'":
                RubikCube.UPrime();
                Moves.push(input.toUpperCase());
                break;

                case "D":
                RubikCube.D();
                Moves.push(input.toUpperCase());
                break;

                case "D'":
                RubikCube.DPrime();
                Moves.push(input.toUpperCase());
                break;

                case "R":
                RubikCube.R();
                Moves.push(input.toUpperCase());
                break;

                case "R'":
                RubikCube.RPrime();
                Moves.push(input.toUpperCase());
                break;

                case "L":
                RubikCube.L();
                Moves.push(input.toUpperCase());
                break;

                case "L'":
                RubikCube.LPime();
                Moves.push(input.toUpperCase());
                break;

                case "F":
                RubikCube.F();
                Moves.push(input.toUpperCase());
                break;

                case "F'":
                RubikCube.FPrime();
                Moves.push(input.toUpperCase());
                break;

                case "B":
                RubikCube.B();
                Moves.push(input.toUpperCase());
                break;

                case "B'":
                RubikCube.BPrime();
                Moves.push(input.toUpperCase());

                case "Q": // quits
                proceed = false;
                scn.close();
                break;

                case "E": // prints the cube and inputs
                System.out.println();
                System.out.println("Use U, D, R, L, F, B, to move the cube clockwise, add ' to move counterclockwise");
                System.out.println("Q to quit, S to see solution, and E to show cube and inputs again");
                System.out.println();
                break;

                case "S": //prints the solution
                System.out.println();
                System.out.println("Solution: ");
                Solve(Moves, solution);
                System.out.println();
                System.out.println();
                break;



            }
        }
    }
}   