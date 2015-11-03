public class linkedDeque {
	 
	private dequeNode left;
	private dequeNode right;
	private int size;

	public linkedDeque() {
		this.left = null;
		this.right = null;
		this.size = 0;
	}

	public void insertLeft (Object o) {
		if(this.size == 0) {
			dequeNode lefty = new dequeNode(o);
			left = lefty;
			right = lefty;
			size++;
		} else {
		dequeNode leftNode = new dequeNode(o);
		leftNode.setRightLink(left);
		left.setLeftLink(leftNode);
		left = leftNode;
		size++;
	    }
	}

	public void insertRight (Object o) {
		if(this.size == 0) {
			dequeNode righty = new dequeNode(o);
			left = righty;
			right = righty;
			size++;
		} else {
		dequeNode rightNode = new dequeNode(o);
		rightNode.setLeftLink(right);
		right.setRightLink(rightNode);
		right = rightNode;
		if (rightNode.getLeftLink() == null) {
			left = rightNode;
		}
		size++;
		}
	}

	public void deleteLeft() {
		if (this.size == 0) {
			System.out.println("nothing to delete");
		} else {
		if(this.size == 1) {
			dequeNode empty = new dequeNode();
			this.left = empty;
			this.right = empty;
			size--;
		} else {
		    dequeNode temp = new dequeNode();
		    left.getRightLink().setLeftLink(null);
		    temp = left;
		    left = left.getRightLink();
		    temp.setRightLink(null);
		    size--;
	      }
       }
	}

	public void deleteRight() {
		if (this.size == 0) {
			System.out.println("nothing to delete");
		} else {
			if (this.size == 1){
                dequeNode empty = new dequeNode();
                this.left = empty;
                this.right = empty;
                size--;
			} else {
		        dequeNode temp = new dequeNode();
		        right.getLeftLink().setRightLink(null);
				temp = right;
				right = right.getLeftLink();
				temp.setLeftLink(null);
				size--;
	         }
	     }
	}

	public Object left() {
        return this.left.getInfo();
	}

	public Object right() {
		return this.right.getInfo();
	}

	public int size() {
		return this.size;
	}

	public String toString() {
		String dequeString = "";
		dequeNode temp = this.left;
		while (temp != this.right) {
			dequeString = dequeString + "[" + temp.getInfo() + "]";
			temp = temp.getRightLink();
		}
		dequeString = dequeString + "[" + right.getInfo() + "]";
		return dequeString;
	}

	public static void main (String[] args) {
		//constructor test
		linkedDeque testDeque = new linkedDeque();
		if (testDeque.left != null || testDeque.right != null || testDeque.size != 0){
			System.out.println("constructor not working");
		} else {
			System.out.println("constructor working");
		}

		//insertLeft test
		testDeque.insertLeft('c');
		testDeque.insertLeft('b');
		testDeque.insertLeft('a');
		System.out.println(testDeque.left.getInfo());
		System.out.println(testDeque.right.getInfo());
		System.out.println(testDeque.toString());

		//deleteLeft test
		testDeque.deleteLeft();
		testDeque.deleteLeft();
		System.out.println(testDeque.toString());

		//insertRight test
		testDeque.insertRight('b');
		testDeque.insertRight('a');
		System.out.println(testDeque.toString());
        
        //right left and size test
		System.out.println(testDeque.left());
		System.out.println(testDeque.right());
		System.out.println(testDeque.size());
        
        //deleteRight test
        testDeque.deleteRight();
        testDeque.deleteRight();
        testDeque.deleteRight();
        testDeque.deleteLeft();
        testDeque.insertLeft(1);
        System.out.println(testDeque.toString());


	}
}
