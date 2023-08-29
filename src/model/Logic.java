package model;

import java.util.Stack;

public class Logic {

	private Stack<Integer> tower1;
	private Stack<Integer> tower2;
	private Stack<Integer> tower3;
	private int level;
	private int active1;
	private int active2;

	public Logic() {
		tower1 = new Stack<>();
		tower2 = new Stack<>();
		tower3 = new Stack<>();
		level=0;
		active1=0;
		active2=0;
	}

	public void levelSelector(int level) {
		this.level=level;
		for (int i = 0; i < level; i++) {
			tower1.push(i);
		}
	}

	public int [] selector(int num){

		if(active1==0) {
			active1=num;
			return null;
		}else  {
			active2=num;
			
			
			if(active1==1 && active2==2) {
				int[] retorno= {tower2.push(tower1.pop()),level,1,2};
				this.restartMove();
				return retorno;
			}else if(active1==2 && active2==1) {
				int[] retorno= {tower1.push(tower2.pop()),level,2,1};
				this.restartMove();
				return retorno;
			}else if(active1==1 && active2==3) {
				int[] retorno= {tower3.push(tower1.pop()),level,1,3};
				this.restartMove();
				return retorno;
			}else if(active1==3 && active2==1) {
				int[] retorno= {tower1.push(tower3.pop()),level,3,1};
				this.restartMove();
				return retorno;
			}else if(active1==2 && active2==3) {
				int[] retorno= {tower3.push(tower2.pop()),level,2,3};
				this.restartMove();
				return retorno;
			}else if(active1==3 && active2==2){
				int[] retorno= {tower2.push(tower3.pop()),level,3,2};
				this.restartMove();
				return retorno;
			}else {
				this.restartMove();
				return null;
			}
		}


	}

	private void restartMove() {
		active1=0;
		active2=0;
	}




	public Stack<Integer> getTower1() {
		return tower1;
	}

	public void setTower1(Stack<Integer> tower1) {
		this.tower1 = tower1;
	}

	public Stack<Integer> getTower2() {
		return tower2;
	}

	public void setTower2(Stack<Integer> tower2) {
		this.tower2 = tower2;
	}

	public Stack<Integer> getTower3() {
		return tower3;
	}

	public void setTower3(Stack<Integer> tower3) {
		this.tower3 = tower3;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getActive1() {
		return active1;
	}

	public void setActive1(int active1) {
		this.active1 = active1;
	}

	public int getActive2() {
		return active2;
	}

	public void setActive2(int active2) {
		this.active2 = active2;
	}








}
