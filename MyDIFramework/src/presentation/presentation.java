package presentation;

import java.io.File;
import ext.*;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import FramewrokVersionXML.FrameworkVXML;

import java.lang.reflect.*;

import dao.DaoImpl;
import dao.IDao;
import metier.MetierImpl;

public class presentation {

	public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException, JAXBException {
		FrameworkVXML fvx=new FrameworkVXML("dependancies.xml");
		MetierImpl2 metier=(MetierImpl2) fvx.getBean("metier");
		/*JAXBContext jaxbContext = JAXBContext.newInstance(Beans.class);
		Unmarshaller unmarshaller=jaxbContext.createUnmarshaller();
		Beans beans=(Beans) unmarshaller.unmarshal(new File("dependancies.xml"));
	    for(Bean b : beans.getBeans()) {
	    	System.out.println(b.getClasse());
	    }*/
		System.out.println(metier.calculer());
	}

}
