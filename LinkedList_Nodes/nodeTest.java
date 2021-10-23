public class nodeTest{
	public static void main(String[] args){
		Node a = new Node(9);
		Node b = new Node(8, a);
		Node c = new Node(6, b);
		Node d = new Node(4, c);
		Node firstNode = d; 
		Node currentNode = firstNode; 
		 


		while(currentNode.next != null){ 
			System.out.print(currentNode.data);
			currentNode = currentNode.next;
		}
		/*while(firstNode != null){
			System.out.println(firstNode.data);
			firstNode = firstNode.next;
		}*/
	}
}