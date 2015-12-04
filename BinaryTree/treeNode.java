public class treeNode {
	private Object data;
	private treeNode leftSon;
	private treeNode rightSon;
	private treeNode father;

	public treeNode (Object obj) {
		this.data = obj;
		this.rightSon = null;
		this.leftSon = null;
		this.father = null;
	}

	public void setLeftSon(treeNode n){
		this.leftSon = n;
	}

	public void setRightSon(treeNode n){
		this.rightSon = n;
	}

	public void setFather(treeNode n){
		this.father = n;
	}

	public treeNode getLeftSon(){
		return this.leftSon;
	}

	public treeNode getRightSon(){
		return this.rightSon;
	}

	public treeNode getFather(){
		return this.father;
	}

	public Object getData(){
		return data;
	}
}
