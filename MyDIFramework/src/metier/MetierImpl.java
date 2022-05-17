package metier;

import dao.IDao;

public class MetierImpl implements IMetier{
	private IDao dao;

	@Override
	public double calculer() {
		double res= dao.getValue()*Math.random()*2;
	    return res;
	}
	public IDao getDao() {
		return dao;
	}
	public void setDao(IDao dao) {
		this.dao = dao;
	}
	
	}

