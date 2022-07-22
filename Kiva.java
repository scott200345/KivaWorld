
/**
 * Write a description of Kiva here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
public class Kiva {
    private Point currentLocation;
    private FacingDirection directionFacing;
    private FloorMap map;
    private boolean carryingPod;
    private boolean successfullyDropped;
    private long motorLifetime;
    public Kiva(FloorMap map){
        this(map,map.getInitialKivaLocation());
    }
    public Kiva(FloorMap map,Point currentLocation){
        this.map = map;
        this.currentLocation = currentLocation;
        this.directionFacing = FacingDirection.UP;
        this.carryingPod = false;
        this.successfullyDropped = false;
    }
    public void move(KivaCommand command){
        if(command.equals(KivaCommand.FORWARD)){
            moveForward();
            incrementMotorLifetie();
        }
        if(command.equals(KivaCommand.TURN_LEFT)){
            turnLeft();
            incrementMotorLifetie();
        }
        if(command.getDirectionKey()=='R'){
            turnRight();
            incrementMotorLifetie();
        }
        if(command.equals(KivaCommand.TAKE)){
            taking();
        }
        if(command.equals(KivaCommand.DROP)){
            dropping();
        }
    }
    private void moveForward(){
        int largestX = map.getMaxColNum();
        int largestY = map.getMaxRowNum();
        
        Point newLocation = currentLocation;
        switch(this.directionFacing){
            case UP: newLocation = new Point(currentLocation.getX(),currentLocation.getY()-1);
                     break;
            case LEFT: newLocation = new Point(currentLocation.getX()-1,currentLocation.getY());
                       break;
            case RIGHT: newLocation = new Point(currentLocation.getX()+1,currentLocation.getY());
                        break;
            case DOWN: newLocation = new Point(currentLocation.getX(),currentLocation.getY()+1);
                        break;
        }
        if(newLocation.getX()>=0&&newLocation.getX()<=largestX&&newLocation.getY()>=0&&newLocation.getY()<=largestY){
            this.currentLocation = newLocation;
        }else{
            throw new IllegalMoveException("The move will move the kiva out of map");
        }
        if(map.getObjectAtLocation(newLocation)==FloorMapObject.OBSTACLE){
            throw new IllegalMoveException(String.format("Can't move onto an obstacle at %s!",newLocation.toString()));
        }
        if(map.getObjectAtLocation(newLocation)==FloorMapObject.POD&&this.carryingPod==true){
            throw new IllegalMoveException(String.format("Pod collision happen at pod:%s with newlocation %s",map.getPodLocation(),newLocation));
        }
       
        
      
        
        /*if(this.directionFacing.equals(FacingDirection.UP)){
            newLocation = new Point(currentLocation.getX(),currentLocation.getY()-1);
        }
        if(this.directionFacing.equals(FacingDirection.LEFT)){
            newLocation = new Point(currentLocation.getX()-1,currentLocation.getY());
        }
        if(this.directionFacing.equals(FacingDirection.RIGHT)){
            newLocation = new Point(currentLocation.getX()+1,currentLocation.getY());
        }
        if(this.directionFacing.equals(FacingDirection.DOWN)){
            newLocation = new Point(currentLocation.getX(),currentLocation.getY()+1);
        }
        */
      
        
    }
    private void turnLeft(){
        switch(directionFacing){
            case UP:
                this.directionFacing = FacingDirection.LEFT;
                break;
            case DOWN:
                this.directionFacing = FacingDirection.RIGHT;
                break;
            case LEFT:
                this.directionFacing = FacingDirection.DOWN;
                break;
            case RIGHT:
                this.directionFacing = FacingDirection.UP;
                break;
            
        }
    }
    private void turnRight(){
        switch(directionFacing){
            case UP:
                this.directionFacing = FacingDirection.RIGHT;
                break;
            case DOWN:
                this.directionFacing = FacingDirection.LEFT;
                break;
            case LEFT:
                this.directionFacing = FacingDirection.UP;
                break;
            case RIGHT:
                this.directionFacing = FacingDirection.DOWN;
                break;
            
        }
    }
    private void taking(){
        if(map.getObjectAtLocation(getCurrentLocation())==FloorMapObject.POD&&this.carryingPod==false){
            this.carryingPod = true;
            this.successfullyDropped = false;
        }else{
            throw new NoPodException(String.format("Can't take nonexistent pod from location %s. Terrain is %s",getCurrentLocation(),map.getObjectAtLocation(getCurrentLocation())));
        }
    }
    private void dropping(){
        boolean onDropzone = false;
        if(map.getObjectAtLocation(getCurrentLocation())==FloorMapObject.DROP_ZONE){
            onDropzone = true;
        }
        if(onDropzone&&this.carryingPod==true){
            this.carryingPod = false;
            this.successfullyDropped = true;
        }else if(this.carryingPod==false){
            throw new NoPodException("There is no pod on this kiva");
        }
        if(onDropzone==false){
            throw new IllegalMoveException(String.format("This is not a DROPZONE at %s, DROPZONE point :%s",getCurrentLocation(),map.getDropZoneLocation()));
        }
        
       
        /*if(this.carryingPod==false){
            throw new NoPodException("There is no pod on this kiva");
        }
        if(map.getObjectAtLocation(getCurrentLocation())==FloorMapObject.DROP_ZONE&&this.carryingPod==true){
            this.carryingPod = false;
            this.successfullyDropped = true;
        }else if(this.carryingPod==false){
            throw new IllegalMoveException(String.format("This is not a DROPZONE at %s",getCurrentLocation()));
        }*/
    }
    public void incrementMotorLifetie(){
        this.motorLifetime += 1000;
    }
    
    //getter&&setter methods
     public long getMotorLifetime(){
        return this.motorLifetime;
    }
    public boolean isCarryingPod(){
        return this.carryingPod;
    }
    public boolean isSuccessfullyDropped(){
        return this.successfullyDropped;
    }
    public Point getCurrentLocation(){
        return this.currentLocation;
    }
    public FacingDirection getFacingDirection(){
        return this.directionFacing;
    }
    
    
    public String toString(){
        return String.format("Kiva is at %s, CarryingPod:%s , FacingDirection: %s, dropsuccess?: %s",getCurrentLocation(),isCarryingPod(),getFacingDirection(),isSuccessfullyDropped());
    }
}
