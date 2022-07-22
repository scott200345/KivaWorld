import edu.duke.FileResource;

/**
 * This is the class that controls Kiva's actions. Implement the <code>run()</code>
 * method to deliver the pod and avoid the obstacles.
 *
 * This is starter code that may or may not work. You will need to update the code to
 * complete the project.
 */
import edu.duke.*;
import java.util.*;
public class RemoteControl {
    KeyboardResource keyboardResource;

    /**
     * Build a new RemoteControl.
     */
    public RemoteControl() {
        keyboardResource = new KeyboardResource();
    }

    /**
     * The controller that directs Kiva's activity. Prompts the user for the floor map
     * to load, displays the map, and asks the user for the commands for Kiva to execute.
     *
     * [Here's the method you'll execute from within BlueJ. It may or may not run successfully
     * as-is, but you'll definitely need to add more to complete the project.]
     */
    public void run() {
        System.out.println("Please select a map file.");
        FileResource fileResource = new FileResource();
        String inputMap = fileResource.asString();
        FloorMap floorMap = new FloorMap(inputMap);
        System.out.println(floorMap);
        Kiva gundan = new Kiva(floorMap);
        System.out.println("Stats: "+gundan);
        System.out.println("Please enter the directions for the Kiva Robot to take.");
        String directions = keyboardResource.getLine();
        System.out.println("Directions that you typed in: " + directions);
        KivaCommand[] moves = convertToKivaCommands(directions);
        for(KivaCommand k:moves){
            gundan.move(k);
        }
        if(gundan.isSuccessfullyDropped()&&directions.charAt(directions.length()-1)=='D'){
            System.out.println("“Successfully picked up the pod and dropped it off. Thank you!");
        }else if(directions.charAt(directions.length()-1)!='D'){
            System.out.println("I'm sorry. The Kiva Robot did not pick up the pod and then drop it off in the right place.");
        }else {
            System.out.println("I'm sorry. The Kiva Robot did not pick up the pod and then drop it off in the right place.");
        }
    }
    public KivaCommand[] convertToKivaCommands(String input){
        KivaCommand[] kc= KivaCommand.values();
        KivaCommand[] result = new KivaCommand[input.length()];
        String keys = "FRLTD";
        for(int i = 0;i<input.length();i++){
            char action = input.charAt(i);
            if(keys.indexOf(action)==-1){
                throw new IllegalArgumentException(String.format("Action: %c is not a valid move",action));
            }
            for(KivaCommand k:kc){
                if(k.getDirectionKey()==action){
                    result[i] = k;
                }
            }
        }
        return result;
    }
}
