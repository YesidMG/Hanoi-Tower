package model;

import java.util.Hashtable;
import java.util.Stack;

public class Logic {

	private Hashtable<String, Stack<Integer>> towers;
	private Stack<Integer> tower1;
	private Stack<Integer> tower2;
	private Stack<Integer> tower3;
	private int level;
	private int active1;
	private int active2;

	public Logic() {
		towers = new Hashtable<>();
		towers.put("tower1", tower1= new Stack<>());
		towers.put("tower2", tower2= new Stack<>());
		towers.put("tower3", tower3= new Stack<>());
		level=0;
		active1=0;
		active2=0;
	}

	public void levelSelector(int level) {
		this.level=level;
		tower1.clear();
		tower2.clear();
		tower3.clear();
		for (int i = 0; i < level; i++) {
			towers.get("tower1").push(i);
		}
	}

	public int [] selector(int num){
		if(active1==0) {
			active1=num;
			return null;
		}else  {
			active2=num;
			if (active2!=active1) {
				if (towers.get("tower"+active1).size()>0 && (towers.get("tower"+active2).size()==0 || towers.get("tower"+active1).peek()>towers.get("tower"+active2).peek())) {
					int[] retorno= {towers.get("tower"+active2).push(towers.get("tower"+active1).pop()),level,active1,active2};
					return retorno;
				}else{
					return null;
				}
			}else{
				return null;
			}
		}
	}

	private void restartMove() {
		active1=0;
		active2=0;
	}
	public boolean indicator(){
		if(active2==0) {
			return true;
		}else {
			this.restartMove();
			return false;
		}
	}
	public boolean winn() {
		if(tower1.isEmpty() && tower2.isEmpty()) {
			return true;
		}else {
			return false;
		}
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