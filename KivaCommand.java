
/**
 * Write a description of KivaCommand here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public enum KivaCommand {
    FORWARD('F'),
    TURN_LEFT('L'),
    TURN_RIGHT('R'),
    TAKE('T'),
    DROP('D');
    private char action;
    private KivaCommand(char action){
        this.action = action;
    }
    public char getDirectionKey(){
        return this.action;
    }
    
}
