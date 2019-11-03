/**
 * Author : Zhang Zhe
 */
//节点类
 class ListNode{
     public int date;
     public ListNode next;
     public ListNode(int date){
         this.date=date;
         this.next=null;
     }
}
class MySingleList {
    public ListNode head;//标志头
    public MySingleList() {
        this.head = null;
    }

    //头插法
    public void addFirst(int date) {
        ListNode node = new ListNode(date);
        if (this.head == null) {
            this.head = node;
        } else {
            node.next = this.head;
            this.head = node;
        }
    }

    //尾插法
    public void addLast(int date) {
        ListNode node = new ListNode(date);
        ListNode cur = this.head;
        if (this.head == null) {
            this.head = node;
        } else {
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = node;
        }
    }

    //打印单列表数据
    public void display() {
       if (this.head == null) {
            return;
        }
            ListNode cur = this.head;
            while (cur!= null) {
                System.out.print(cur.date+"   ");
                cur = cur.next;
            }
            System.out.println();
        }

    private ListNode searchIndex(int index) {
        ListNode prev = this.head;
        int count = 0;
        while(count<index-1){
            prev=prev.next;
            count++;
        }
        return prev;
    }
    //插入到index位置
    //任意位置插入，第一个数据节点为0号下标
    public boolean addIndex(int index, int date) {
        if(index<0||index>getLength()){
            return false;
        }
        if (index == 0) {
            addFirst(date);
            return true;
        } else {
            ListNode prev = searchIndex(index);
            ListNode node = new ListNode(date);
            node.next=prev.next;
            prev.next=node;
        }
        return false;
    }
    public int getLength(){
        int count = 0;
        ListNode cur = this.head;
        while (cur!=null){
            count++;
            cur = cur.next;
        }
        return count;
    }
    //查找key
    public boolean contains(int key){
        ListNode cur = this.head;
        while(cur!=null){
            if(cur.date==key){
                return  true;
            }
            cur=cur.next;
        }
        return false;
    }
    //删除非头节点，找前驱，若找不到返回null
    private  ListNode searchPrev(int key){
        ListNode prev = this.head;
        while(prev.next!=null) {
            if (prev.next.date == key) {
                return prev;
            }
            prev=prev.next;
        }
        return null;
    }
    //删除第一次出现关键字为key的节点
 public void remove(int key){
        if(key==this.head.date){
            this.head=this.head.next;
            return;
        }
        ListNode prev = searchIndex(key);
          if(prev==null){
            System.out.println("没有你要删除的点");
            return;
        }
        ListNode del = prev.next;
          //进行删除
        prev.next=del.next;
        //删除头节点
        //删除非头节点，找前驱，若找不到返回null
    }
    //删除所有值为key的节点
   public void removeAllKey(int key){
        ListNode prev = this.head;
        ListNode cur = this.head.next;
        while(cur!=null){
            if(prev.next.date==key){
                prev.next=cur.next;
                cur=cur.next;
            }else{
                prev=cur;
                cur=cur.next;
            }
        }
        //最后删除头
        if(this.head.date==key){
            this.head=this.head.next;
        }
    }
    public void clear(){
        while(this.head.next!=null){
            ListNode cur = this.head.next;
            this.head.next = cur.next;
        }
        this.head = null;
    }
}