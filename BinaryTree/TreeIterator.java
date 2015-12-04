import java.util.Iterator;
public class TreeIterator implements Iterator{
  private treeNode next;

  public TreeIterator(treeNode root){
     next = root;
     if(next == null)
       return;
     while (next.getLeftSon() != null)
       next = next.getLeftSon();
  }

  public boolean hasNext(){
     return next != null;
  }

  public treeNode next(){
     if(!hasNext()) throw new IllegalArgumentException();
     treeNode r = next;
     if(next.getRightSon() != null){
       next = next.getRightSon();
       while (next.getLeftSon() != null)
         next = next.getLeftSon();
       return r;
     }else while(true){
       if(next.getFather() == null){
         next = null;
         return r;
       }
       if(next.getFather().getLeftSon() == next){
         next = next.getFather();
         return r;
       }
       next = next.getFather();
     }
   }
 }
