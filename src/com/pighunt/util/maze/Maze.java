package com.pighunt.util.maze;

import java.util.EnumSet;
import java.util.Random;

import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;
public final class Maze {
    private Graph<Node, DefaultEdge> g;
	private int sizex;
	private int sizey;
	public enum Sides{LEFT(0),RIGHT(1),UP(2),DOWN(3);
	Sides(int i){}
	};
	private Random rand;
	//Class Implementation
	
	//Constructor
	public Maze()
	{
		g=new SimpleGraph<Node, DefaultEdge>(DefaultEdge.class);
		rand=new Random();
	}
	public Maze(int sizex, int sizey)
	{
		this();
		resetMaze();
	}
	private void resetMaze()
	{
		g.removeAllVertices(g.vertexSet());
		Node.clear();
	}
	public void generateMaze()
	{
		Node temp=Node.addNode(genRand(sizex), genRand(sizey));
		g.addVertex(temp);
		generateMaze(temp);
	}
	public void generateMaze(Node current)
	{
		int x=current.getX();
		int y=current.getY();
		EnumSet<Sides> side=EnumSet.allOf(Sides.class);
		for(int i=0;i<4;i++)
		{
			int ran=genRand(side.size());
			Node temp=null;
			switch((Sides)side.toArray()[ran])
			{
			case LEFT:
				if(x>0){
					temp=Node.addNode(x-1, y);
				}
				side.remove(Sides.LEFT);
				break;
			case RIGHT:
				if(x<(sizex-1)){
					temp=Node.addNode(x+1, y);
				}
				side.remove(Sides.RIGHT);
				break;
			case UP:
				if(y>0){
					temp=Node.addNode(x, y-1);
				}
				side.remove(Sides.UP);
				break;
			case DOWN:
				if(y<(sizey-1)){
					temp=Node.addNode(x, y+1);
				}
				side.remove(Sides.DOWN);
				break;
			}
			if(temp!=null){
				g.addVertex(temp);
				g.addEdge(current, temp);
				generateMaze(temp);
			}
		}
	}//assim que unit for implementado descomentar esse bloco
	/*
	public GraphPath[] findPath(Unit source, Unit target)
	{
		return KShortestPaths(getCurrentUnitNode(source),getCurrentUnitNode(target));
	}
	public Node getCurrentUnitNode(Unit u){
		return Node.getNode(u.getX()/(420/sizex),u.getY()/(360/sizey));
	}
	*/
	private int genRand(int value){return rand.nextInt(value-1);}
}
