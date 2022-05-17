package framework;

import java.awt.List;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Set;
import java.util.stream.Collectors;

import org.reflections.Reflections;
import org.reflections.scanners.ResourcesScanner;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;
import org.reflections.util.FilterBuilder;

import metier.MetierImpl;

public class MyAnnotationConfigApplicationContext {
	HashMap<Class, Object> instances=new HashMap<Class, Object>();
	public void getClasses(String... packages) throws InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException{
		ArrayList<Class> classes=new ArrayList<Class>();
		String methodName=null;
		Set<Class<?>> subTypesOf=null;
		for(String packageName : packages) {
		Reflections reflections = new Reflections(new ConfigurationBuilder()
	            .setScanners(new SubTypesScanner(false /* don't exclude Object.class */), new ResourcesScanner())
	            .addUrls(ClasspathHelper.forJavaClassPath()) 
	            .filterInputsBy(new FilterBuilder()
	            .include(FilterBuilder.prefix(packageName))));

	subTypesOf = reflections.getSubTypesOf(Object.class);
	for( Class c :subTypesOf) {
		if(c.toString().contains("class")) {
			Object o = c.newInstance();
			instances.put(c.getInterfaces()[0], o);
			classes.add(c);
		}
	}
	
	
	}
	//inject dependency :
		     for(Class c : classes) {
			if( c.getAnnotations()[0].toString().contains("Component") && c.getDeclaredFields().length>0 ) {
				Field[] fields =c.getDeclaredFields();
				for(Field f : fields) {
					if(f.getAnnotations()[0].toString().contains("Autowired"))
					{
					methodName="set"+f.getName().substring(0, 1).toUpperCase() + f.getName().substring(1);
						Method method=c.getMethod(methodName,f.getType());
						method.invoke(instances.get(c.getInterfaces()[0]), instances.get(f.getType()));
					    System.out.println(instances);
					}
				}
			}
		}
	
	}
	public HashMap<Class, Object> getInstances(){
		return instances;
	}
	
}
