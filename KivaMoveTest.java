
/**
 * Write a description of KivaMoveTest here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;

public class KivaMoveTest {
    String defaultLayout = ""
                           +"-------------\n"
                           +"        P   *\n"
                           +"   **       *\n"
                           +"   **       *\n"
                           +"  K       D *\n"
                           +" * * * * * **\n"
                           +"-------------\n";
    FloorMap defaultMap = new FloorMap(defaultLayout);
    public void testMotorLifetime(){
        Kiva kiva = new Kiva(defaultMap);
        System.out.println(kiva.getMotorLifetime());
        kiva.move(KivaCommand.FORWARD);
        System.out.println(kiva.getMotorLifetime());
        kiva.move(KivaCommand.TURN_LEFT);
        System.out.println(kiva.getMotorLifetime());
        kiva.move(KivaCommand.TURN_RIGHT);
        System.out.println(kiva.getMotorLifetime());
    }
    public void testDrop(){
        Kiva kiva = new Kiva(defaultMap);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.TURN_RIGHT);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        System.out.println(String.format("The pod is at %s and the pod is at %s",kiva.getCurrentLocation(),defaultMap.getPodLocation()));
        //kiva.move(KivaCommand.TAKE);
        System.out.println(String.format("if kiva is carrying pod: %s",kiva.isCarryingPod()));
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.TURN_RIGHT);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        System.out.println(String.format("CarryingPOd:%s , Location:%s, dropzone: %s",kiva.isCarryingPod(),kiva.getCurrentLocation(),defaultMap.getDropZoneLocation()));
        kiva.move(KivaCommand.DROP);
        System.out.println(kiva.toString());
    }
    public void testbinCollision(){
        Kiva kiva = new Kiva(defaultMap);
        kiva.move(KivaCommand.TAKE);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.TURN_RIGHT);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        System.out.println(String.format("Going to pod crash at %s",kiva.getCurrentLocation()));
        kiva.move(KivaCommand.FORWARD);
    }
    public void testMoveOutOfBounds(){
        Kiva kiva = new Kiva(defaultMap);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.TURN_LEFT);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        System.out.println("testMoveOutOfBounts: (expect an IllegalMoveException)");
        kiva.move(KivaCommand.FORWARD);
        System.out.println("testMoveOutOfBounds FAIL!");
        System.out.println("kiva outside of FloorMap!");
        
        
    }
    public void testObstacle(){
      Kiva kiva =new Kiva(defaultMap);     
      kiva.move(KivaCommand.FORWARD);
      kiva.move(KivaCommand.TURN_RIGHT);
      System.out.println("testObstacle: (expect an IllegalMoveException for hitting obstacle)");
      kiva.move(KivaCommand.FORWARD);
    }
    public void testForwardFromUp(){
      Kiva kiva =new Kiva(defaultMap);
      System.out.println(defaultMap.getMaxColNum());
      System.out.println(defaultMap.getMaxRowNum());
      System.out.println(defaultMap.getMinColNum());
      System.out.println(defaultMap.getMinRowNum());
      kiva.move(KivaCommand.FORWARD);
      kiva.move(KivaCommand.TURN_RIGHT);
      kiva.move(KivaCommand.FORWARD);
      //verifyKivaState("testForwardFromUp",kiva, new Point(2,3), FacingDirection.UP, false, false);
      /*kiva.move(KivaCommand.TURN_RIGHT);
      verifyKivaState("testForwardFromUp",kiva, new Point(2,3), FacingDirection.RIGHT, false, false);
      kiva.move(KivaCommand.TURN_RIGHT);
      verifyKivaState("TestTrunRightFromLeft",kiva, new Point(2,3), FacingDirection.DOWN, false, false);
      kiva.move(KivaCommand.TURN_RIGHT);
      verifyKivaState("testTurnRightFromDown",kiva, new Point(2,3), FacingDirection.LEFT, false, false);
      kiva.move(KivaCommand.TURN_RIGHT);
      verifyKivaState("testTurnRightFromRight",kiva, new Point(2,3), FacingDirection.UP, false, false);
      */
      //kiva.move(KivaCommand.TAKE);
      //verifyKivaState("testTakeOnPod",kiva, new Point(2,3), FacingDirection.UP, true, false);
      //kiva.move(KivaCommand.DROP);
      //verifyKivaState("testDropOnDropZone",kiva, new Point(2,3), FacingDirection.UP, false, true);
      
      //verifyKivaState("testForwardFromUp",kiva, new Point(2,3), FacingDirection.LEFT, false, false);
      //verifyKivaState("testTurnRightFromUP",kiva, new Point(2,3), FacingDirection.RIGHT, false, false);
      //verifyKivaState("TestTrunRightFromLeft",kiva, new Point(2,3), FacingDirection.UP, false, false);
      //verifyKivaState("testTurnRightFromDown",kiva, new Point(2,3), FacingDirection.LEFT, false, false);
      //verifyKivaState("testTurnRightFromRight",kiva, new Point(2,3), FacingDirection.DOWN, false, false);
      //verifyKivaState("testTakeOnPod",kiva, new Point(2,3), FacingDirection.UP, true, false);
      //verifyKivaState("testDropOnDropZone",kiva, new Point(2,3), FacingDirection.UP, false, true);
      
    }
    private boolean sameLocation(Point a, Point b) {
        return a.getX() == b.getX() && a.getY()==b.getY();
    }
    private void verifyKivaState(
        String testName,
        Kiva actual,
        Point expectLocation,
        FacingDirection expectDirection,
        boolean expectCarry,
        boolean expectDropped) {
            Point actualLocation = actual.getCurrentLocation();
            if(sameLocation(actualLocation,expectLocation)){
                System.out.println(String.format("%s: current location SUCCESS\n",testName));
            }
            else{
                System.out.println(String.format("%s: Current location FAIL\n", testName));
                System.out.println(String.format("Expected: %s, got %s\n",expectLocation,actualLocation));
            }
            FacingDirection actualDirection = actual.getFacingDirection();
            if(actualDirection == expectDirection){
                System.out.println(String.format("%s: Facing direction SUCCESS\n",testName));
            }else{
                System.out.println(String.format("Facing direction FAIL expected:%s actual:%s\n",expectDirection, actualDirection));
            }
            boolean actualCarry = actual.isCarryingPod();
            if(actualCarry == expectCarry){
                System.out.println(String.format("%s:Carrying pod SUCESS\n",testName));
            }else{
                System.out.println(String.format("%s:Carrying pod FAIL\n",testName));
                System.out.println(String.format("Expected %s,got %s\n",expectCarry, actualCarry));
                
            }
            boolean actualDropped = actual.isSuccessfullyDropped();
            if(actualDropped == expectDropped) {
                System.out.println(String.format("%s:Droptest SUCESS\n",testName));
            }else {
                System.out.println(String.format("%s:Droptest FAIL\n",testName));
                System.out.println(String.format("Expected %s, got %s\n",expectDropped, actualDropped));
            }
            
    }
    
}
