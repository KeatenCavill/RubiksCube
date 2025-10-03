package RubiksCube;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

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
    

    public static void main(String[] args)
    throws IOException   
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        TheCube  RubikCube = new TheCube();

        boolean argsCheck = false;
        int argsRunIndex = 0;
        ArrayList<String> moves = new ArrayList<>();

        if(args.length > 0){
            argsCheck = true;
            for(String arg : args){
                moves.add(arg);
            }
        }

        boolean proceed = true;

        while(proceed){
            String input;
           

            //main loop
            if(!argsCheck){
        
                System.out.println("Welcome to the Great Cube of Rubik's");
                System.out.println("Moves To Solve: " + String.join(" ", moves));
                System.out.println("Move Options: U, D, R, L, F, B, add ' to move counterclockwise");
                System.out.println("Q to Quit");
                System.out.println("Input Move:");
                input = reader.readLine();
            } else{
                if(argsRunIndex == args.length){
                  argsCheck = false;
                  
                  return;
                }else{
                    input = moves.get(argsRunIndex);
                    argsRunIndex++;
                }
            }
            // all possible imputs
            switch(input){
                case "u":
                case "U":
                 RubikCube.U();
                RubikCube.showcube();
                moves.add("U");
                break;
                
                case "u'":
                case "U'":
                RubikCube.UPrime();
                RubikCube.showcube();
                moves.add("U'");
                break;

                case"d":
                case "D":
                RubikCube.D();
                RubikCube.showcube();
                moves.add("D");
                break;

                case "d'":
                case "D'":
                RubikCube.DPrime();
                RubikCube.showcube();
                moves.add("D'");
                break;

                case "r":
                case "R":
                RubikCube.R();
                RubikCube.showcube();
                moves.add("R");
                break;

                case"r'":
                case "R'":
                RubikCube.RPrime();
                RubikCube.showcube();
                moves.add("R'");
                break;

                case "l":
                case "L":
                RubikCube.L();
                RubikCube.showcube();
                moves.add("L");
                break;

                case "l'":
                case "L'":
                RubikCube.LPime();
                RubikCube.showcube();
                moves.add("L'");
                break;

                case "f":
                case "F":
                RubikCube.F();
                RubikCube.showcube();
                moves.add("F");
                break;

                case "f'":
                case "F'":
                RubikCube.FPrime();
                RubikCube.showcube();
                moves.add("F'");
                break;

                case "b":
                case "B":
                RubikCube.B();
                RubikCube.showcube();
                moves.add("B");
                break;

                case "b'":
                case "B'":
                RubikCube.BPrime();
                RubikCube.showcube();
                moves.add("B'");
                break;

                case "q":
                case "Q":
                proceed = false;
                break;

            }
        }

    }
}   