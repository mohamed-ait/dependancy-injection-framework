package presentation;

import java.awt.List;
import java.io.File;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Set;

import org.reflections.Reflections;
import org.reflections.scanners.ResourcesScanner;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;
import org.reflections.util.FilterBuilder;

import dao.DaoImpl;
import dao.IDao;
import framework.Component;
import framework.MyAnnotationConfigApplicationContext;
import javassist.ClassPath;
import javassist.bytecode.Descriptor.Iterator;
import metier.IMetier;
import metier.MetierImpl;

public class presentation {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
		MyAnnotationConfigApplicationContext ctx=new MyAnnotationConfigApplicationContext();
		ctx.getClasses("metier","ext");
		IMetier metier=(MetierImpl)ctx.getInstances().get(IMetier.class);
		//System.out.println(ctx.getInstances());
		System.out.println(metier.calculer());
		
	}

}
