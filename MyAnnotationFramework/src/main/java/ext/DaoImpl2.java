package ext;

import dao.IDao;
import framework.Component;
@Component
public class DaoImpl2 implements IDao{

	@Override
	public double getValue() {
		return Math.random()*4000;
	}

}
