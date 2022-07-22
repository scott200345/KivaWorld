
/**
 * Write a description of RemoteControlTest here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
import edu.duke.*;
public class RemoteControlTest {
    public void testRemoteControl(){
        RemoteControl rc = new RemoteControl();
        String input = "B";
        KivaCommand[] kc = rc.convertToKivaCommands(input);
        System.out.println(Arrays.toString(kc));
        
    }
}
