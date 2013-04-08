package com.pighunt.util.maze;

import java.util.List;
//versao alterada de um singleton
//moldado para armazenar multiplas instancias privadas de si mesmo
public class Node{
	private static List<Node> nodeList;
	private int x;
	private int y;
	private Node(int x, int y)
	{
		this.x=x;
		this.y=y;
	}
	public static Node addNode(int x, int y)
	{
		Node temp;
		if(getNode(x,y)==null){
			temp=new Node(x,y);
			nodeList.add(temp);
			return temp;
		}
		return null;
	}
	public static Node getNode(int x, int y){
		for (Node n: nodeList)
		{
			if((n.getX()==x)&&(n.getY()==y))
				return n;
		}
		return null;
	}
	public static void removeNode(int x, int y)
	{
		Node temp=getNode(x, y);
		if (temp!=null) nodeList.remove(temp);
	}
	public static void clear()
	{
		nodeList.clear();
	}
	public static List<Node> getNodeList(){return nodeList;}
	public static void setNodeList(List<Node> list){nodeList=list;}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
}
