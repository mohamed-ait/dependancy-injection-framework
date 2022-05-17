package FramewrokVersionXML;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Property {
	@XmlAttribute
private String name;
	@XmlAttribute
private String ref;
public Property(String name, String ref) {
	super();
	this.name = name;
	this.ref = ref;
}
public Property() {
	super();
	// TODO Auto-generated constructor stub
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getRef() {
	return ref;
}
public void setRef(String ref) {
	this.ref = ref;
}

}
