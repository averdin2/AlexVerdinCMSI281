public class dequeNode {

	private Object info;
	private dequeNode leftLink;
	private dequeNode rightLink;

	public dequeNode() {
		this.info = null;
		this.leftLink = null;
		this.rightLink = null;
	}

	public dequeNode(Object obj) {
		this.info = obj;
		this.leftLink = null;
		this.rightLink = null;
	}

	public void setLeftLink(dequeNode link) {
		this.leftLink = link;
	}

	public void setRightLink(dequeNode link) {
		this.rightLink = link;
	}

	public dequeNode getLeftLink(){
		return this.leftLink;
	}

	public dequeNode getRightLink() {
		return this.rightLink;
	}	

	public Object getInfo() {
		return this.info;
	}
}
