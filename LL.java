package com.linkedlist;

public class LL {
    private Node head;
    private Node tail;
    int size;

    LL() {
        this.size = 0;
    }
                                       /*add at firt
    1 case
                make node;
                point next to head;
                head =node(current)
    case 2 (empty list)
                create node;
                head=node;
                tail=head;
                size++;
                 */
    public void insertFirst(int value){
        Node first=new Node(value);
        first.next=head;
        head=first;
        if(tail==null){
            tail=head;
        }
        size++;

    }
    /*
                                          insert at last(O(1))
    case1
    -make node
    -tail.next=node;
    -tail=node;
    case2
    if tail is null
    call insert first;


     */
    public void insertLast(int value) {
        if(tail==null){
            insertFirst(value);
            return;
        }
        Node last = new Node(value);
        tail.next=last;
        tail=last;
        size++;

    }
    /*
                                         insert at particular location

     */
    public void Insert(int val,int idx){
        if(idx==0){
            insertFirst(val);
            return;
        }
        if(idx==size){
            insertLast(val);
            return;
        }
        Node temp=head;
        for (int i=1;i<idx;i++){
            temp=temp.next;
        }
        Node myIns=new Node(val,temp.next);
        temp.next=myIns;
        size++;


    }

    /*
                                                             display
    make a copy of head in temp;
    then itrate temp till value of temp is null

     */
    public  void  display(){
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.value+"->");;
           temp= temp.next;
        }
        System.out.println("end");
    }
    /*
                                                            delete first
     */
    public void deleteFirst(){
        head=head.next;
        if (head==tail){
            tail=null;
        }
        size--;
    }
    /*
                                                             delete last
     */
    public Node get(int index){
        Node temp=head;
        for(int i=0;i<index;i++){
            temp=temp.next;
        }
        return temp;
    }
    public    void deleteLast(){
        if(size<=1){
            deleteFirst();
            return;
        }
        Node temp=head;
        for(int i=0;i<size-2;i++){
            temp=temp.next;
        }
        temp.next=null;
        tail=null;
        size--;


    }
    /*
                                                         delete at any index
     */

    public void delete(int idx){
        if(idx==size-1){
            deleteLast();
            return;
        }
        if(idx<=0){
            deleteFirst();
            return;
        }
        Node prev=get(idx-1);
        prev.next=prev.next.next;
        size--;
    }
    /*
                                                             find value
     */
    public int find(int n){
        Node temp=head;
        int idx=0;
        while(temp!=tail){
            if(temp.value==n){
                return idx;
            }

            idx++;
            temp=temp.next;
        }
        return -1;
    }
    private class Node{
        private int value;
        private Node next;
        Node(int value){
            this.value=value;
        }
        Node(int value,Node next){
            this.value=value;
            this.next=next;
        }
    }
}
