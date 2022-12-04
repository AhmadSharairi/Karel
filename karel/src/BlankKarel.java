/*
 * File: BlankKarel.java
 * ---------------------
 * This class is a blank one that you can change at will.
 */
import stanford.karel.*;
public class BlankKarel extends SuperKarel {
    public static int length  = 1;
    public static int width = 1;
    int count=1;

    public void turnRight() {
        turnLeft();
        turnLeft();
        turnLeft();
    }
    public void getDirections() {
        while (frontIsClear()) {
            move();
            count++;
            width++;
        }

        turnLeft();
        while (frontIsClear()) {
            move();
            count++;

            length++;
        }


  }

     public void testWorld()
    {
        if(width%2==0 && length%2==0 && width!=2  &&length!=2)  // when we have even*even world
        {   evenWorld();}
        if(width==2  &&length==2)// when we have 2*2 world
        { twoByTwo(); }
        if (width % 4 == 0 && length==1) // when we have Multiples of a number 4 * 1 world
        {oneWorld(width);}
        if (width==1 && length % 4 == 0)  // when we have 1 *  Multiples of a number 4
        {oneWorld(length);}
        if(width%2!=0 && length%2!=0 && width!=1 && length!=1)   // when we have odd*odd world
        {oddWorld();}
        if(width%2==0 && length%2!=0 && width!=2 && length!=1)  // when we have even*odd world
        {WEvenLOddWorld();}
        if(width%2!=0  && length%2==0 && width!=1 && length!=2)  // when we have odd*even world
        {WOddLEvenWorld();}

    }
    public void returnHome() {
        turnAround();
        moveToWall();
        turnAround();
        turnLeft();
        moveToWall();
        turnAround();
    }
    public void returnHomeEvenWorld(){ // function for even*even world
        turnRight();
        while (frontIsClear())
        {
            move();
            count++;
        }
        turnAround();
    }
    public void putBeeperToCenterHeightEvenWorld(int temp){
        for(int j = 1; j< temp; j++)
        {  putBeeper();

            move();
            count++;
        }}
    public void putBeeperToCenterNegHeightEvenWorld(){
        int h=length/2;

        for(int j = 0; j<h-1; j++)
        { putBeeper();
            move();
            count++;
        }


    }
    public void putBeeperToCenterWidthEvenWorld()
    {
        for(int j = 1; j<width/2; j++)
        {
            putBeeper();
            move();
            count++;

        }

    }
    public void turnLeftAndRightDirectionCenterEvenWorld()
    {
        turnLeft();
        putBeeper();
        moveToWallAndPutBeepers();
        turnRight();
        move();
        count++;
        turnRight();
    }
    public void evenWorld()
    {
        int w=width/2;
        int h=length/2;

        for(int i = 1; i<w; i++)
        { 	move();
            count++;

            if(w==i+1)
            {
                turnLeft();
            }
        }
        putBeeperToCenterHeightEvenWorld(h);
        turnLeftAndRightDirectionCenterEvenWorld();
        putBeeperToCenterWidthEvenWorld();
        turnLeftAndRightDirectionCenterEvenWorld();
        putBeeperToCenterNegHeightEvenWorld();
        turnLeftAndRightDirectionCenterEvenWorld();
        putBeeperToCenterWidthEvenWorld();
        turnLeft();
        putBeeper();

        moveToWallAndPutBeepers();
        returnHomeEvenWorld();


        if(width==length)
        {
            //moveDiagonally(width);

        }
    }

    /** Above Functions for evenWorld ***/
     public void oddWorld(){

        int wOdd= (int) Math.ceil((double) width/2);
        for(int i = 1; i<wOdd; i++)
        { 	move();
            count++;
            if(wOdd==i+1)  // find last index to move in width line
            {
                turnLeft();

            }
        }
        moveToMaxLengthWallOddWorld();
        putBeeperToCenterLengthOddWorld();
        moveToWallAndPutBeepers();
        turnLeft();
        moveToWall();
        turnLeft();
        if(width==length)
        {
          //  moveDiagonally(width);

        }

    }

    public void moveToMaxLengthWallOddWorld()
    {
        putBeeper();
        move();
        count++;
        putBeeper();
        moveToWallAndPutBeepers();
        turnRight();
        moveToWall();
        turnRight();
    }

    public void putBeeperToCenterLengthOddWorld()
    {
        int hOdd=(int) Math.ceil((double)length/2);
        for(int i = 1; i<hOdd; i++)
        { 	move();
            count++;
            if(hOdd==i+1)// last index to move in length
            {
                turnRight();
                putBeeper();

            }

        }

    }

    /** Above Functions  for oddWorld ***/

    //   Function for even*odd world w*l
    public void WEvenLOddWorld()
    {

        int w=width/2;
        int hOdd= (int) Math.ceil((double) length/2);
        for(int i = 1; i<w; i++)
        { 	move();
            count++;
            if(w==i+1)
            {
                turnLeft();
            }
        }
        putBeeperToCenterHeightEvenWorld(hOdd);
        putBeeper();
        turnLeft();
        moveToWallAndPutBeepers();
        turnAround();
        for(int i = 1; i<w; i++)
        { 	move();
            count++;

        }
        turnLeftAndRightDirectionCenterEvenWorld();
        for(int j = 1; j<hOdd; j++)
        { putBeeper();
            move();
            count++;}
        putBeeper();
        turnLeft();
        moveToWallAndPutBeepers();
        turnAround();
        for(int i = 1; i<w; i++)
        { 	move();  count++;}
        turnLeft();
        putBeeperToCenterHeightEvenWorld(hOdd);
        putBeeper();
        turnRight();
        moveToWall();
        turnAround();
    }
    //   Function for odd*even world w*l
    public void WOddLEvenWorld()
    {   int wOdd=(int) Math.ceil((double) width/2);
        int h= length/2;
        turnLeft();
        for(int i = 1; i<h; i++)
        { 	move();
            count++;
            if(h==i+1)
            {
                turnRight();
            }
        }
        putBeeper();
        moveToWallAndPutBeepers();
        turnLeft();
        move();
        count++;
        turnLeft();
        putBeeper();
        moveToWallAndPutBeepers();
        turnRight();
        moveToWall();
        turnRight();
        for(int j = 1; j<wOdd; j++)
        { move();  count++;}
        putBeeper();
        turnRight();
        moveToWallAndPutBeepers();
        turnRight();
        moveToWall();
        turnAround();}
   public  void moveDiagonally(int tempWidth)
    {
        putBeeper();
        for (int i=1 ; i<tempWidth ; i++)
        {
            move();
            count++;
            turnLeft();
            move();
            count++;
            turnRight();
            putBeeper();


        }
        turnRight();
        moveToWall();
        turnRight();
        putBeeper();
        for (int i=1 ; i<tempWidth ; i++)
        {
            move();
            count++;
            turnRight();
            move();
            count++;
            turnLeft();
            putBeeper();
        }
        turnLeft();
        moveToWall();
        turnLeft();

    }
     @Override
    protected void setBeepersInBag(int i) {
        super.setBeepersInBag(i);
    }

    // Function when we have Multiples of a number 4 * 1 world  (4,8,12..)*1
    public void oneWorld(int evenNum) {

        if (length==evenNum) // check if the number is a length or width
        {  turnLeft();}
             move();
             count++;
            putBeeper();
            while (frontIsClear()) {
                boolean alreadyExecuted = false;
                for (int i = 0; i < 1; i++) {
                    for (int j = 0; j < evenNum / 4; j++) {
                        move();
                        count++;
                    }
                    if (!alreadyExecuted) {
                         putBeeper();
                        alreadyExecuted = true;
                    }

                }
            }

            turnLeft();
            turnLeft();
            moveToWall();
            turnLeft();
            turnLeft();}
    public void moveToWall()
    {
        while (frontIsClear()) {
            move();
            count++;
        }
    }
    public void moveToWallAndPutBeepers()
    {
        while (frontIsClear()) {
            move();
            count++;
            putBeeper();
        }
    }

    //Function for 2*2 world
    public void twoByTwo()
    {
        putBeeper();
        for (int i = 1; i < 2; i++) {
            move();
            count++;
            turnLeft();
            move();
            count++;
            turnRight();
            putBeeper();
        }
        turnRight();
        moveToWall();
        turnRight();
        moveToWall();
        turnAround();

    }

    public void run() {

       boolean isRun =true;
       while (isRun)
       {
          getDirections();
          returnHome();
          setBeepersInBag(1000);
          testWorld();
          isRun=false;
       }
        System.out.println("Number of the beepers used in world "+width +"*"+length +" is: " +
                "" +(1000-getBeepersInBag() + " beepers"));
        System.out.println("Number of the beepers in Bag: " + getBeepersInBag() + " beepers");
        width=length=1;




    }
}









