
public class VoterHashTableSeparateChaining {

	private Node<Voter>[] hashTable;
	private int tableSize;

	public VoterHashTableSeparateChaining(int size) {
		hashTable = (Node<Voter>[]) new Node[size];
		tableSize = size;
	}
	
	public int getHashTableLocation(int voterID) {
		return Integer.hashCode(voterID) % tableSize; 
	}

	public boolean addVoter(Voter voterToAdd) {
		Node newVoter = new Node(voterToAdd);
		int hashNumber = Integer.hashCode(voterToAdd.getId()) % tableSize;   
		if(hashTable[hashNumber] == null){
			hashTable[hashNumber] = newVoter; 
			return true; 
		} else{
			Node<Voter> temp = hashTable[hashNumber]; 
			while(temp != null){
				//completing extra credit
				if(temp.data.getId() == (voterToAdd.getId())){
					return false; 
				} 
				temp = temp.next;
			}
			temp = newVoter;
			temp.next = hashTable[hashNumber];  
			hashTable[hashNumber] = temp; 
			return true; 
		} 
	}

	public Voter getVoter(int voterID) {
		int hashNumber = Integer.hashCode(voterID) % tableSize;
		Node<Voter> temp = hashTable[hashNumber];
		Voter voter = null;  
		while(temp != null){
			if(temp.data.getId() == voterID){
				voter = temp.data;
			}
			temp = temp.next; 
		}
		return voter; 
	}

	public void printTable() {
		for (int i = 0; i < tableSize; i++) {
			if (hashTable[i] != null) {
				System.out.print("Location " + i + ": ");
				Node<Voter> current = hashTable[i];
				while (current != null && current.next != null) {
					System.out.print(current.data.getName() + " -> ");
					current = current.next;
				}
				System.out.println(current.data.getName());
			}
		}
	}

}
