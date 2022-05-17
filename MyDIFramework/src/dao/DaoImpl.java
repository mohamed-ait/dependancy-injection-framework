package dao;

public class DaoImpl implements IDao{

	@Override
	public double getValue() {
		// TODO Auto-generated method stub
		return Math.random()*40;
	}

}
