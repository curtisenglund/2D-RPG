

public class EnemyPosHeap{
   private Enemy[] Heap;
   private int size;
   private int maxsize;
   
   private static final int FRONT = 1;
   
   public EnemyPosHeap(int maxsize, Enemy furthestMob){
      this.maxsize = maxsize;
      this.size = 0;
      
      Heap = new Enemy[this.maxsize + 1];
      Heap[0] = furthestMob;
   }
   
   
   private int parent(int pos) {
      return (pos / 2);
   }
   
   private int leftChild(int pos){
      return (2 * pos);
   }
   
   private int rightChild(int pos){
      return (2 * pos) + 1;
   }
   
   private boolean isLeaf(int pos){
      if ( pos > (size / 2) && pos <= size){
         return true;
      }
      
      return false;
   }
   
   private void swap(int fpos, int spos) {
      Enemy tmp;
      tmp = Heap[fpos];
      
      Heap[fpos] = Heap[spos];
      Heap[spos] = tmp;
   }
   
   private void minHeapify(int pos){
      if (!isLeaf(pos)){
         if (Heap[pos].distanceToHero > Heap[leftChild(pos)].distanceToHero || Heap[pos].distanceToHero > Heap[rightChild(pos)].distanceToHero) {
            if (Heap[leftChild(pos)].distanceToHero < Heap[rightChild(pos)].distanceToHero) {
               swap(pos, leftChild(pos));
               minHeapify(leftChild(pos));
            } else {
               swap(pos, rightChild(pos));
               minHeapify(rightChild(pos));
            }
         }
      }
   }
   
   public void insert(Enemy element){
      if (size >= maxsize){
         return;
      }
      
         Heap[++size] = element;
         int current = size;
      
         while (Heap[current].distanceToHero < Heap[parent(current)].distanceToHero) {
            swap(current, parent(current));
            current = parent(current);
         }
   }
   
   public void print(){
      for (int i = 1; i <= size / 2; i++) {
      
         System.out.print(" PARENT : " + Heap[i].distanceToHero
                + " LEFT CHILD : " + Heap[2 * i].distanceToHero
                + " RIGHT CHILD :" + Heap[rightChild(i)].distanceToHero);
      
         System.out.println();
      }
   }
   
   public Enemy remove(){
   
      Enemy popped = Heap[FRONT];
      Heap[FRONT] = Heap[size--];
      minHeapify(FRONT);
   
      return popped;
   }
   
   public void reHeap(){
      minHeapify(FRONT);
   }
   
   public Enemy closestEnemy(){
      return Heap[1];
   }
   
   public void printClosestEnemy(){
      System.out.println("Closest enemy at X:" + closestEnemy().getEnemyXPos()
                           + " Y:" + closestEnemy().getEnemyYPos());
   }
}