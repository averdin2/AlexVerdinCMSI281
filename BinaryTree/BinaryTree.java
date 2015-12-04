import java.lang.Iterable;
import java.util.Iterator;
import java.util.ArrayList;

public class BinaryTree implements Iterable {
	private treeNode root;
	private treeNode cursor;
	private int size;

	public BinaryTree(){
		this.root = null;
		this.cursor = null;
		this.size = 0;
	}

	public BinaryTree(Object obj){
		treeNode firstNode = new treeNode(obj);
		this.root = firstNode;
		this.size = 1; 
	}
	public treeNode getRoot(){
		return this.root;
	}

	public treeNode getCursor() {
		return this.cursor;
	}

	public int size() {
		return this.size;
	}

	

	public boolean putCursorAtRoot(){
		if(this.size == 0){
			return false;
		} else {
			this.cursor = root;
		}

		return true;
	} 

	public boolean putCursorAtLeftSon(){
		if(cursor == null){
			return false;
		} else if(cursor.getLeftSon() == null){
			return false;
		} else {
			cursor = cursor.getLeftSon();
		}

		return true;
	}

	public boolean putCursorAtRightSon(){
		if(cursor == null){
			return false;
		} else if(cursor.getRightSon() == null){
			return false;
		} else {
			cursor = cursor.getRightSon();
		}

		return true;
	}

	public boolean putCursorAtFather(){
		if(cursor == null){
			return false;
		} else if(cursor.getFather() == null){
			return false;
		} else {
			cursor = cursor.getFather();
		}

		return true;
	}

	public boolean attachLeftSonAtCursor(Object obj){
		if(cursor.getLeftSon() != null){
			return false;
		} else if(cursor == null) {
			return false;
		} else {
			treeNode leftNode = new treeNode(obj);
			cursor.setLeftSon(leftNode);
			cursor.getLeftSon().setFather(cursor);
			size ++;
		}

		return true;
	}

	public boolean attachRightSonAtCursor(Object obj){
		if(cursor.getRightSon() != null){
			return false;
		} else if(cursor == null) {
			return false;
		} else {
			treeNode rightNode = new treeNode(obj);
			cursor.setRightSon(rightNode);
			cursor.getRightSon().setFather(cursor);
			size ++;
		}

		return true;
	}

	public int pruneInOrder(treeNode r){
		int iCount = 1;
		if(this.root == null){
			return 0;
		} else {
			if(r.getLeftSon() != null){
				pruneInOrder(r.getLeftSon());
				iCount ++;
			}
			if(r.getRightSon() != null) {
				pruneInOrder(r.getRightSon());
				iCount++;
			}
		}
		return iCount;
	}


	public boolean pruneFromCursor(){

		if(this.cursor == null){
			return false;
		} else {
			if(this.root == this.cursor){
				this.root = null;
				this.cursor = null;
				this.size = 0;
			} else {

				int counter = pruneInOrder(this.cursor);
				this.size = this.size - counter;
				this.cursor.getFather().setLeftSon(null);
				this.cursor.setFather(null);
				this.cursor = this.root;
			}
		}	
		return true;
	}

	public boolean containsObj(treeNode n) {
		boolean contains = false;
		if(this.root.getData() == n.getData()) {
			return true;
		}
		if (this.root.getLeftSon() == null && this.root.getRightSon() == null && this.root.getData() != n.getData()){
        	return false;
        }
		return containsObj(this.root.getLeftSon()) && containsObj(this.root.getRightSon());


		// boolean contains = false;
		// if(this.root == null){
		// 	return false;
		// } else {
			
		// 	if(this.root.getData() == obj){
		// 		contains = true;
		// 	} else {
				
		// 		if(this.root.getLeftSon() != null){
		// 			if(this.root.getLeftSon().getData() == obj){
		// 				contains = true;
		// 			}
		// 			containsInOrder(this.root.getLeftSon());
		// 		}

		// 		if(this.root.getRightSon() != null){
		// 			if(this.root.getRightSon().getData() == obj){
		// 				contains = true;
		// 			}
		// 			containsInOrder(this.root.getRightSon());
		// 		}
		// 	}
		// }
		// return contains;
	}

	public boolean contains(Object obj){
		treeNode object = new treeNode(obj);
		if(containsObj(object) == true){
			return true;
		} else {
			return false;
		}
	}   

	
	
	public boolean similarTrees(treeNode r1, treeNode r2) {
		if (r1 == null && r2 == null){
        	return true;
        }
    	if ((r1 == null && r2 != null) || (r1 != null && r2 == null)){
        	return false;
        }
		return similarTrees(r1.getLeftSon(), r2.getLeftSon()) && similarTrees(r1.getRightSon(), r2.getRightSon());
	}

	public boolean similar(Object obj) {
		 if(!(obj instanceof BinaryTree)) {
		 	return false;
		 } else {
			return similarTrees(this.root,((BinaryTree)obj).getRoot());
		}
	}

	public boolean equalTrees(treeNode r1, treeNode r2d2) {
		if(r1 == null && r2d2 == null) {
			return true;
		}
		if ((r1 == null && r2d2 != null) || (r1 != null && r2d2 == null)) {
			return false;
		}
		return (r1.getData() == r2d2.getData()) && equalTrees(r1.getLeftSon(), r2d2.getLeftSon()) && equalTrees(r1.getRightSon(), r2d2.getRightSon());
	}

	public boolean equals(Object obj) {
		if(!(obj instanceof BinaryTree)) {
			return false;
		} else {
		    return equalTrees(this.root,((BinaryTree)obj).getRoot());
		}
	}


	 public Iterator iterator() {
	 	throw new UnsupportedOperationException();
	 }

	 public Iterator inOrder() {
	 	return new TreeIterator(this.root);
	 }

}
