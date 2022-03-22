public class TeamFormations {
	
	private int totalPlayers, lastRole;
	private boolean[] isMin;
	private int[] conditionPlayers;
	
	public TeamFormations(int totalPlayers, int roles) {
		this.totalPlayers = totalPlayers;
		lastRole = roles - 1;
		isMin = new boolean[roles];
		conditionPlayers = new int[roles];
	}
	
	public void setRole(int role, boolean isMin, int rolePlayers) {
		this.isMin[role] = isMin;
		this.conditionPlayers[role] = rolePlayers;
	}
	
	public int getNumRoles() {
		return isMin.length;
	}
	
	public long calculateFormations() {
		return calculateFormations(0, totalPlayers);
	}
	
	public long calculateFormations(int role, int remainingPlayers) {
		int min = 0, max = conditionPlayers[role];
	
		if (isMin[role]) {
			min = conditionPlayers[role];
			max = remainingPlayers;
		}
		
		if (remainingPlayers < min || role == lastRole && remainingPlayers > max) {
			return 0;
		}
		if (role == lastRole) {
			return 1;
		}
		
		int minMax = Math.min(remainingPlayers, max);
		long sum = 0;
		
		for (int i = min; i <= minMax; i++) {
			sum += calculateFormations(role + 1, remainingPlayers - i);
		}
		
		return sum;
	}
	
}
