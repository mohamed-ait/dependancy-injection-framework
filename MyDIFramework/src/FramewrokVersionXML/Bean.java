package FramewrokVersionXML;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Bean {
	@XmlAttribute
private String id;
	@XmlAttribute
private String classe;
	@XmlElement
private Property property;
public Bean(String id, String classe, Property property) {
	super();
	this.id = id;
	this.classe = classe;
	this.property = property;
}
public Bean() {
	super();
	// TODO Auto-generated constructor stub
}
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getClasse() {
	return classe;
}
public void setClasse(String classe) {
	this.classe = classe;
}
public Property getProperty() {
	return property;
}
public void setProperty(Property property) {
	this.property = property;
}


}
