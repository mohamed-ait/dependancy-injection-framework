package dao;

import framework.Component;

@Component
public class DaoImpl implements IDao{

	public double getValue() {
		return Math.random()*40;
	}
	

}
