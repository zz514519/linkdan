/**
 * Author : Zhang Zhe
 */
class Demo{
    public int data;
    public Demo next;
    public Demo(int data){
        this.data=data;
        this.next=null;
    }
}
 class DemoList {
     public Demo head;
     public DemoList() {
         this.head = null;
     }

     //头插法
     public void addfirst(int data) {
         Demo node = new Demo(data);
         if (this.head == null) {
             this.head = node;
         } else {
             node.next = this.head;
             this.head = node;
         }
     }

     //尾插法
     public void addlast(int data) {
         Demo node = new Demo(data);
         Demo cur = this.head;
         if (this.head == null) {
             this.head = node;
         } else {
             while (cur.next != null) {
                 cur = cur.next;
             }
             cur.next = node;
         }
     }

     //打印
     public void display() {
         if (this.head == null) {
             return;
         }
         Demo cur = this.head;
         while (cur != null) {
             System.out.println(cur.data + " ");
             cur=cur.next;
         }
         System.out.println();
     }

     ////插入到index位置
     //    //任意位置插入，第一个数据节点为0号下标
     private Demo searchIndex(int index){
         Demo prev = this.head;
         int count=0;
         while(count<index-1){
             prev=prev.next;
             count++;
         }
         return  prev;
     }
     //获取链表长度
     public int getLength(){
         int count = 0;
         Demo cur = this.head;
         while(cur!=null){
             count++;
             cur=cur.next;
         }
         return  count;
     }
     public boolean addIndex(int index,int data){
         if(index<0||index>getLength()){
             return false;
         }
         if(index==0){
             addfirst(data);
             return true;
         }else{
             Demo  prev=searchIndex(index);
             Demo node = new Demo(data);
             node.next=prev.next;
             prev.next=node;
         }
         return  false;
     }
     //查找key
     public boolean contains(int key){
         Demo cur = this.head;
         while(cur!=null){
             if(cur.data==key){
                 return true;
             }
             cur=cur.next;
         }
         return false;
     }

     //删除非头节点，找前驱，若找不到返回null
     private Demo seachPrev(int key){
         Demo prev = this.head;
         while (prev.next!=null){
             if(prev.next.data==key){
                 return  prev;
             }
             prev=prev.next;
         }
         return null;
     }

     public void remove(int key){
        if(this.head.data==key){
            this.head=this.head.next;
            return;
        }
            Demo prev = seachPrev(key);
            if(prev==null){
                System.out.println("没有你要删除的点");
                return;
            }
            Demo del = prev.next;
            prev.next=del.next;
        }
        //删除所有key的点
     public void removeAllKey(int key){
         Demo prev = this.head;
         Demo cur = this.head.next;
         while(cur!=null){
             if(prev.next.data==key){
                 prev.next=cur.next;
                 cur=cur.next;
             }else{
                 prev=cur;
                 cur=cur.next;
             }
         }
         if(this.head.data==key){
             this.head=this.head.next;
         }
     }
    }

