import java.util.Random;

public class MoveWords{

    public static final int EMPATE = 0;
    public static final int GANA = 1;
    public static final int PIERDE = 2;

    private static final String[] validMoves = {"TIJERAS", "PAPEL", "PIEDRA", "LAGARTIJA", "SPOCK"};
    private static final String[] validCommands = {"SALIR", "HELP"};

    private Random rnd;
    
    public MoveWords(){
    	rnd = new Random();
    }
    
    public boolean isValidMoveCommand(String value){

	    for (int i =0; i< validMoves.length; i++){
	        if(validMoves[i].equals(value))
	    	    return true;
	    }
	    
	    for (int i =0; i< validCommands.length; i++){
	        if(validCommands[i].equals(value))
		        return true;
	    }
	    
	    return false;
    }

    public String randomMove(){
	    float p = rnd.nextFloat();
	    return validMoves[ (int) (p * validMoves.length)];
    }

    public void showMoves(){
        for (String move : validMoves)
	        System.out.print(move+" ");
	    System.out.println();
    }
    public void showCommands(){
	    for (String cmd : validCommands)
	        System.out.print(cmd+" ");
	    System.out.println();
    }

    public void showWords(){
        showMoves();
        showCommands();    
    }

    private static int getIndex(String value){
	    for (int i =0; i< validMoves.length; i++){
	        if(validMoves[i].equals(value))
		        return i;
	    }
    	return -1;
    }

	public static int checkWinner(String player, String computer) {
		if (player.equals(computer)) {
			return EMPATE;
		} else if ((player.equals("TIJERAS") && (computer.equals("PAPEL") || computer.equals("LAGARTIJA"))) ||
				(player.equals("PAPEL") && (computer.equals("PIEDRA") || computer.equals("SPOCK"))) ||
				(player.equals("PIEDRA") && (computer.equals("TIJERAS") || computer.equals("LAGARTIJA"))) ||
				(player.equals("LAGARTIJA") && (computer.equals("PAPEL") || computer.equals("SPOCK"))) ||
				(player.equals("SPOCK") && (computer.equals("PIEDRA") || computer.equals("TIJERAS")))) {
			return GANA;
		} else {
			return PIERDE;
		}
	}
	
} 
