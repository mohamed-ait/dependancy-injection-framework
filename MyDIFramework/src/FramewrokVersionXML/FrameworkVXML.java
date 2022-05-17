package FramewrokVersionXML;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import metier.MetierImpl;

public class FrameworkVXML {
private String fileName;

public FrameworkVXML(String fileName) {
	super();
	this.fileName = fileName;
}
public Object getBean(String name) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
	String className;
	String classRef=null;
	String methodName=null;
	Object obj=null;
	Class ob=null;
	Class obRef=null;
	try {
		JAXBContext jaxbContext = JAXBContext.newInstance(Beans.class);
		Unmarshaller unmarshaller=jaxbContext.createUnmarshaller();
		Beans beans=(Beans) unmarshaller.unmarshal(new File(fileName));
		for(Bean b : beans.getBeans()) {
			if(b.getId().equals(name)) {
				 className=b.getClasse();
				ob=Class.forName(className);
				 obj=ob.newInstance();
				methodName=b.getProperty().getName();
				classRef=b.getProperty().getRef();
			}
		}
		for(Bean b : beans.getBeans()) {
			if(b.getId().equals(classRef)) {
				String refName=b.getClasse();
				 obRef=Class.forName(refName);
				Object refObj=obRef.newInstance();
				String mn="set"+methodName.substring(0, 1).toUpperCase() + methodName.substring(1);
				Method method=ob.getMethod(mn,obRef.getInterfaces()[0]);
				method.invoke(obj, refObj);
			}
		}
	} catch (JAXBException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return obj;

}
}
