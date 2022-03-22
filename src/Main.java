import java.io.IOException;

public class Main {
	
	private static final String MIN = "MIN";
	
	public static void main(String[] args) throws IOException {
		TurboScanner in = new TurboScanner(System.in);
		TeamFormations teamFormations = new TeamFormations(in.nextInt(), in.nextInt());
		
		for (int i = 0; i < teamFormations.getNumRoles(); i++) {
			teamFormations.setRole(i, in.next().equals(MIN), in.nextInt());
		}
		
		System.out.println(teamFormations.calculateFormations());
		in.close();
	}
	
}
