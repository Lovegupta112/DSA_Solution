
class Solution{

	static Node reverse(Node node){
		Node curr=node;
Node prev=null;
int len=0;
while(curr!=null){
	Node tempt=curr.next;
	curr.next=prev;
	prev=curr;
	curr=tempt;
	len++;
}
return prev;
	}
static int size(Node node){

	int len=0;
	Node temp=node;
while(temp!=null){
	len++;
	temp=temp.next;
}
return len;
}
    public static Node rearrange(Node node){
//        //Write code here
//here if we do reverse firstly so we will lost our original list ,
// here front is not able to traverse the list
// Node curr=node;
// Node prev=null;
// int len=0;
// while(curr!=null){
// 	Node tempt=curr.next;
// 	curr.next=prev;
// 	prev=curr;
// 	curr=tempt;
// 	len++;
// }
// Node front=node;
// Node back=prev;
// System.out.println(len + " ");	
 // System.out.print(front.data + " ");
	//  System.out.print(back.data + " ");
// Node newNode=new Node(-1);
// Node temp=newNode;
// int i=1;

// while(i<=len/2){
// 	Node n1=new Node(front.data);
// 	temp.next=n1;
// 	temp=temp.next;
// 	Node n2=new Node(back.data);
// 	temp.next=n2;
//    temp=temp.next;
// 	front=front.next;
//      node=node.next;
// 	back=back.next;
// 	i++;
// }
// temp.next=front;
//  return  newNode.next;

		//second approach ---we can make copy of original then we can perform reverse 

Node dummy=new Node(-1);
Node newNode=dummy;
Node temp=node;
while(temp!=null){
  Node n=new Node(temp.data);
	newNode.next=n;
	newNode=newNode.next;
	temp=temp.next;
}
newNode=dummy.next;
Node rev=reverse(newNode);

int len=size(node);
Node middleOdd=null;
temp=node;
for(int i=1;i<=len/2;i++){
	temp=temp.next;
}
middleOdd=temp;
middleOdd.next=null;	
temp=node;
int i=1;
while(i<=len/2){
	Node f=temp.next;
	temp.next=rev;

	 if(i<len/2){
	Node b=rev.next;  
   rev.next=f;
	temp=rev.next;
	rev=b;
	 }
	else{
		rev.next=null;
	}
i++;
}
if(len%2!=0){
	rev.next=middleOdd;
}
		return node;
    }
}

