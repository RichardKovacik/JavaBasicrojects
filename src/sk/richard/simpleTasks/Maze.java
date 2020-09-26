package sk.richard.simpleTasks;
public class Maze {
    static int[][] maze={
            {0, 0, 0, 2, 0, 0,},
            {0, 1, 1, 1, 0, 0,},
            {0, 1, 0, 0, 0, 0,},
            {3, 1, 0, 0, 1, 0,},
            {0, 1, 1, 1, 1, 0,},
            {0, 0, 0, 0, 0, 0,}};
    //0=wall
    //1=path
    //2=destination
    //3=start position
    //nemozem mat 1 na okraji cely ram cize okraj bludiska musia tvorit 0

    //dorobit algorimutmus pre slepu ulicku
    static  boolean path=true;
    public static void main(String[] args) {
        int y=findStartPosition(maze)[0];
        int x=findStartPosition(maze)[1];
        int steps=0;

        while (path){
            //move left
            if (checkBounds(y,x-1)) {
                if (maze[y][x - 1] == 1) {
                    System.out.println("Move left");
                    maze[y][x - 1] = 5;
                    steps++;
                    x = x - 1;
                } else if (maze[y][x - 1] == 2) {
                    System.out.println("Move left and You Won");
                    steps++;
                    break;
                    //slepa ulicka
                }else if (checkBounds(y,x-1)&&checkBounds(y+1,x)&&checkBounds(y-1,x)&&checkBounds(y,x+1)) {//najskor skusim ci sa este neda ist do lava az potom pojdem naspat
                    if (maze[y][x + 1] == 5 && maze[y][x - 1] == 0 && maze[y+1][x]==0 && maze[y-1][x]==0) {
                        steps--;
                        System.out.println("Move right/ back");
                        maze[y][x] = 0;
                        x = x + 1;
                    }
                }
            }
            if (checkBounds(y,x+1)){
                if (maze[y][x+1]==1) {
                    System.out.println("move right");
                    maze[y][x+1]=5;
                    x = x + 1;
                    steps++;
                }else if (maze[y][x+1]==2) {
                    System.out.println("move right and You Won");
                    steps++;
                    break;
                    //ak bz bola slepa ulicka vratim sa naspat do lava
                }else if (checkBounds(y,x+1)&&checkBounds(y+1,x)&&checkBounds(y-1,x)&&checkBounds(y,x-1)){
                    if (maze[y][x - 1] == 5 && maze[y][x + 1] == 0 && maze[y+1][x]==0 && maze[y-1][x]==0) {
                        steps--;
                        System.out.println("Move left/ back");
                        maze[y][x] = 0;
                        x = x - 1;
                    }

                }
            }
            if (checkBounds(y+1,x)){
                        if (maze[y+1][x]==1){
                            System.out.println("Move down");
                            maze[y+1][x]=5;
                            steps++;
                            y=y+1;
                        }else if (maze[y+1][x]==2) {
                            System.out.println("move down and you Won");
                            steps++;
                            break;
                        }else if (checkBounds(y,x-1)&&checkBounds(y+1,x)&&checkBounds(y-1,x)&&checkBounds(y,x+1)){
                            if (maze[y-1][x] == 5 && maze[y][x + 1] == 0 && maze[y+1][x]==0 && maze[y][x-1]==0) {
                                steps--;
                                System.out.println("Move up/ back");
                                maze[y][x] = 0;
                                y = y - 1;
                            }
                        }
                    }
            if (checkBounds(y-1,x)) {
                if (maze[y - 1][x] == 1) {
                    System.out.println("Move up");
                    steps++;
                    maze[y - 1][x] = 5;
                    y = y - 1;
                } else if (maze[y - 1][x] == 2) {
                    System.out.println("Move up and You won!!!");
                    steps++;
                    break;
                }else if (checkBounds(y,x-1)&&checkBounds(y+1,x)&&checkBounds(y-1,x)&&checkBounds(y,x+1)){
                    if (maze[y+1][x] == 5 && maze[y][x + 1] == 0 && maze[y-1][x]==0 && maze[y][x-1]==0) {
                        steps--;
                        System.out.println("Move down/ back");
                        maze[y][x] = 0;
                        y = y + 1;
                    }
                }
            }

                }

        System.out.println("Total steps: "+steps);

    }
    public static int[] findStartPosition(int[][] twoDimensionalarray){
        int [] positionXY={0,0};
        for (int i=0;i<twoDimensionalarray.length;i++){
            for (int j=0;j<twoDimensionalarray.length;j++){
                if (maze[i][j]==3){
                    positionXY[0]=i;
                    positionXY[1]=j;
                }
            }
        }
        return positionXY;
    }
    public static boolean checkBounds(int y,int x){
        return y >= 0 && y < maze.length && x >= 0 && x < maze.length;
    }

}
