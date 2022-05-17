package metier;

import dao.IDao;
import framework.Autowired;
import framework.Component;
@Component 

public class MetierImpl implements IMetier{
	@Autowired
	private IDao dao;

	public IDao getDao() {
		return dao;
	}
	public void setDao(IDao dao) {
		this.dao = dao;
	}
	public double calculer() {
		double res= dao.getValue()*Math.random()*2;
	    return res;
	}
	
	}

