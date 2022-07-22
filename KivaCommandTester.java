
/**
 * Write a description of KivaCommandTester here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class KivaCommandTester {
    public void testForward(){
        KivaCommand command = KivaCommand.FORWARD;
        System.out.println(command);
        System.out.println(command.getDirectionKey());
    }
    public void testTurnLeft(){
        KivaCommand turnLeft = KivaCommand.TURN_LEFT;
        System.out.println(turnLeft);
        System.out.println(turnLeft.getDirectionKey());
    }
    public void testTurnRight(){
        KivaCommand turnRight = KivaCommand.TURN_RIGHT;
        System.out.println(turnRight);
        System.out.println(turnRight.getDirectionKey());
    }
    public void testTake(){
        KivaCommand take = KivaCommand.TAKE;
        System.out.println(take);
        System.out.println(take.getDirectionKey());
        
    }
    public void testDrop(){
        KivaCommand drop = KivaCommand.DROP;
        System.out.println(drop);
        System.out.println(drop.getDirectionKey());
    }
    
}
