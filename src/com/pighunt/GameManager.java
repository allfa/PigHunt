package com.pighunt;

public final class GameManager {
	private static GameManager instance;
	private GameManager(){}//singletom
	public static GameManager getGM()
	{
		if(instance==null)
			instance=new GameManager();
		return instance;
	}
	public void pause(){
		//todo
	}
}
