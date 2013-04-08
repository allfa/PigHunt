package com.pighunt.unit;

public final class Player extends Unit {

	@Override
	public boolean isChasing() {
		// TODO Auto-generated method stub
		return false;
		//return super.isChasing();
	}

	@Override
	public void setChasing(boolean isChasing) {
		// TODO Auto-generated method stub
		//super.setChasing(isChasing);
	}

	@Override
	public boolean isRemote() {
		return false;
		// TODO Auto-generated method stub
	}

	@Override
	public void setRemote(boolean isRemote) {
		// TODO Auto-generated method stub
		//super.setRemote(isRemote);
	}

	@Override
	public void genAI() {
		return;
		// TODO Auto-generated method stub
		//super.genAI();
	}
	
}
