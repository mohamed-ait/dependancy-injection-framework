package FramewrokVersionXML;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Beans {
	@XmlElement(name="bean")
private ArrayList<Bean> beans;

public Beans(ArrayList<Bean> beans) {
	super();
	this.beans = beans;
}

public Beans() {
	super();
	// TODO Auto-generated constructor stub
}

public ArrayList<Bean> getBeans() {
	return beans;
}

public void setBeans(ArrayList<Bean> beans) {
	this.beans = beans;
}

}
