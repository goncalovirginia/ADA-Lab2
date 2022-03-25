public class TeamFormations {
	
	private final int totalPlayers, lastRole;
	private final int[][] rolesMinMax;
	
	public TeamFormations(int totalPlayers, int roles) {
		this.totalPlayers = totalPlayers;
		lastRole = roles - 1;
		rolesMinMax = new int[roles][2];
	}
	
	public void setRole(int role, boolean isMin, int players) {
		int[] roleMinMax = rolesMinMax[role];
		
		if (isMin) {
			roleMinMax[0] = players;
			roleMinMax[1] = totalPlayers;
		}
		else {
			roleMinMax[1] = players;
		}
	}
	
	public int getNumRoles() {
		return rolesMinMax.length;
	}
	
	public long calculateFormations() {
		long[][] table = new long[lastRole + 1][totalPlayers + 1];
		int[] currentRoleMinMax = rolesMinMax[lastRole];
		long[] currentRole = table[lastRole], previousRole;
		
		for (int c = currentRoleMinMax[0]; c <= currentRoleMinMax[1]; c++) {
			currentRole[totalPlayers - c] = 1;
		}
		
		for (int role = lastRole - 1; role >= 0; role--) {
			currentRoleMinMax = rolesMinMax[role];
			currentRole = table[role];
			previousRole = table[role + 1];
			
			for (int c = currentRoleMinMax[0]; c <= currentRoleMinMax[1]; c++) {
				for (int p = 0; p <= totalPlayers; p++) {
					if (previousRole[p] > 0 && c <= p) {
						currentRole[p - c] += previousRole[p];
					}
				}
			}
		}
		
		return table[0][0];
	}
	
}
