package puzzlers;

public class NineStonesBags {
	

	private int[] inp;
	private int group3s[];
	private int group2s[];
	private int group1s[];
	private int weightResult ;
	private int noofTimesMeasureWeightIsCalled;

	public void setInput(int[] inp) {
		this.inp = inp;
	}

	public void solve() {
		solveTheProblem();
		System.out.println( noofTimesMeasureWeightIsCalled );
		System.out.println( "Stone is "+ (weightResult < 1 ?"lighter":"heavier" ));
	}

	private void solveTheProblem() {
		initializeGroup();
		weightResult = measureWeight( sum(group1s) , sum(group2s)); 
		if (  weightResult == 0)
		{
			weightResult = measureWeight(inp[6], inp[8]);
			solveGroup(3);
			return;
		}
		int tempWeight=measureWeight(sum(group2s), sum(group3s));
		if ( tempWeight == 0)
		{
			solveGroup( 1 );
		}
		else{
			weightResult = tempWeight;
			solveGroup( 2 );
		}
	}

	private int solveGroup( int groupId) {
		int newlocation=3 * (groupId -1 );
		int tempWeight = measureWeight(inp[newlocation], inp[newlocation +1]);
		if( tempWeight == 0 )
		{
			System.out.println(newlocation + 2);
			weightResult = groupId == 3 ? -weightResult : weightResult;
		}
		else if ( tempWeight == weightResult)
		{
			System.out.println( newlocation );
		}
		else{
			System.out.println( newlocation + 1 );
			weightResult = groupId == 3 ? -tempWeight : weightResult;
		}
		return tempWeight;
	}

	private int measureWeight(int sum, int sum2) {
		noofTimesMeasureWeightIsCalled++;
		return sum-sum2;
	}

	private void initializeGroup() {
		group1s = new int[] {inp[0],inp[1],inp[2]};
		group2s = new int[] {inp[3],inp[4],inp[5]};
		group3s = new int[] {inp[6],inp[7],inp[8]};
	}

	/*private void solveGroup3() {
		int tempWeight = measureWeight(inp[7], inp[8]);
		if (weightResult == 0) {
			System.out.println("9");
			weightResult = -tempWeight;
			return;
		}
		if ( tempWeight == -weightResult )
		{
			System.out.println("8");
		} else {
			System.out.println("7");
		}
	}*/

	private int sum(int[] group) {
		int sum = 0;
		for (int i : group) {
			sum+=i;
		}
		return sum;
	}

}
