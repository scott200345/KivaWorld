
/**
 * Write a description of KivaConstructorTest here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
public class KivaConstructorTest {
    String defaultLayout = ""
                           +"-------------\n"
                           +"        P   *\n"
                           +"   **       *\n"
                           +"   **       *\n"
                           +"  K       D *\n"
                           +" * * * * * **\n"
                           +"-------------\n";
    FloorMap defaultMap = new FloorMap(defaultLayout);
    public void testSingleArgumentConstructor(){
        Kiva pod = new Kiva(defaultMap);
        System.out.println(pod.getCurrentLocation());
        Point currentLocation = pod.getCurrentLocation();
        Point expectedLocation = new Point(2,4);
        if(currentLocation.getX()==expectedLocation.getX()&&currentLocation.getY()==expectedLocation.getY()){
            System.out.println("Single argument Success");
        }else{
            System.out.println("test failed");
        }
        Point start = new Point(3,4);
        Kiva pod2 = new Kiva(defaultMap,start);
        System.out.println(pod2.getCurrentLocation());
        System.out.println("Pod location:"+defaultMap.getPodLocation());
        
        
            
    }
    
}
