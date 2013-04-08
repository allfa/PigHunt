package com.pighunt.unit;

import java.util.Iterator;
import java.util.Set;

import com.pighunt.GameManager;

import android.graphics.drawable.AnimationDrawable;

public abstract class Unit {
	float x;
	float y;
	float size;
	AnimationDrawable img;
	int tinkSpeed;
	float moveSpeed;
	boolean isChasing;
	boolean isAlive;
	boolean isPaused;
	Set<Command> lastCommands;
	boolean isRemote;
	Command currentCommand;
	String nickname;
	public Unit()
	{
		this((float)0.0,(float)0.0,0,1,(float)1.0,false,false,"dummy");
	}
	public Unit(float x, float y, int size)
	{
	//placeholder	
		this(x,y,size,1,(float)1,false,false,"dummy");
	}
	public Unit(float x, float y, int size, String nome)
	{
		this(x,y,size,1,(float)1,false,false,nome);
	}
	public Unit(float x, float y, int size, int tinkSpeed, float moveSpeed, boolean isChasing, boolean isRemote, String nickname)
	{
		this.x=x;
		this.y=y;
		this.size=size;
		this.tinkSpeed=tinkSpeed;
		this.moveSpeed=moveSpeed;
		this.isChasing=isChasing;
		this.isRemote=isRemote;
		this.nickname=nickname;
	}
	public float getX() {
		return x;
	}
	public void setX(float x) {
		this.x = x;
	}
	public float getY() {
		return y;
	}
	public void setY(float y) {
		this.y = y;
	}
	public float getSize() {
		return size;
	}
	public void setSize(float size) {
		this.size = size;
	}
	public AnimationDrawable getSprite() {
		return img;
	}
	public void setSprite(AnimationDrawable img) {
		this.img = img;
	}
	public int getTinkSpeed() {
		return tinkSpeed;
	}
	public void setTinkSpeed(int tinkSpeed) {
		this.tinkSpeed = tinkSpeed;
	}
	public float getMoveSpeed() {
		return moveSpeed;
	}
	public void setMoveSpeed(float moveSpeed) {
		this.moveSpeed = moveSpeed;
	}
	public boolean isChasing() {
		return isChasing;
	}
	public void setChasing(boolean isChasing) {
		this.isChasing = isChasing;
	}
	public boolean isAlive() {
		return isAlive;
	}
	public boolean isPaused() {
		return isPaused;
	}
	public Iterator<Command> getLastCommands() {
		return lastCommands.iterator();
	}
	public boolean isRemote() {
		return isRemote;
	}
	public void setRemote(boolean isRemote) {
		this.isRemote = isRemote;
	}
	public void doCommand(Command command) {
		this.lastCommands.add(currentCommand);
		currentCommand = command;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public void pauseGame(){
		GameManager.getGM().pause();
	}
	public void genAI(){
		//placeholder
	}
	public void move(float x, float y){
		if((Math.abs(this.x-x)+Math.abs(this.y-y))>moveSpeed)
			System.err.println("ERRO:mais rapido do que a velocidade do Personagem?\n"+this.toString());
		this.x=x;
		this.y=y;
	}
	public Command getCurrentAction(){
		return currentCommand;
	}
	public void die()
	{
		isAlive=false;
	}
	public String toString()
	{
		String temp=nickname+
				": posX="+x+
				" posY="+y+
				" Tamanho="+size+
				" velocidade da AI="+tinkSpeed+
				" velocidade de movimento="+moveSpeed;
		temp+=  isChasing?" Perseguindo":" Perseguido";
		temp+=	isRemote?"Unit Remoto":"Unit Local";
		temp+=	isAlive?"Viva":"Morta";
		temp+=	(img != null)?"Tem Sprite Valida":"Sprite Invalida";
		temp+=currentCommand!=null?"Tem Comando Valido":"Comando Invalido";
		temp+=super.toString();
		return temp;
	}
}
