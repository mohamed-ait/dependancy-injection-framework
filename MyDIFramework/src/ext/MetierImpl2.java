package ext;

import dao.IDao;
import metier.IMetier;;

public class MetierImpl2 implements IMetier{
	private IDao dao;

	@Override
	public double calculer() {
		double res= dao.getValue()*Math.random()*200;
	    return res;
	}
	public IDao getDao() {
		return dao;
	}
	public void setDao(IDao dao) {
		this.dao = dao;
	}
	
	}