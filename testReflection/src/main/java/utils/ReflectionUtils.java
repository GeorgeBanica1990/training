package utils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import models.Resource;

@SuppressWarnings("rawtypes") 
public class ReflectionUtils {

	public static void printReflectionMethods(Class classToReflect) throws Exception {
		printMethods(classToReflect);
		
		printSuperclass(classToReflect);

		printInterfaces(classToReflect);
		
		printAnnotations(classToReflect);

		printFields(classToReflect);
		
		printConstructors(classToReflect);
	}

	private static void printConstructors(Class classToReflect) throws Exception {
		Constructor[] constructors = classToReflect.getDeclaredConstructors();
		for (Constructor constr : constructors) {
			System.out.println("Constructor: " + constr.getName());
			if (constr.getModifiers() == 2) {
				System.out.println("private constructor");
				constr.setAccessible(true);
				Resource privateConstruct;

				privateConstruct = (Resource) constr.newInstance("test");
				System.out.println("created from private constr: " + privateConstruct.getText());

			}
		}
	}

	private static void printFields(Class classToReflect) throws Exception {
		Field[] fields = classToReflect.getDeclaredFields();
		for (Field fld : fields) {
			if (fld.getModifiers() == 26) {
				System.out.println("private static final field: change value to test");
				changeStaticFinalFieldValue(fld, "test");
				System.out.println("change value for PSF: " + fld.get(null));
			}
			System.out.println("Field name: " + fld.getName());
			System.out.println("Modifier name: " + fld.getModifiers());
		}
	}

	private static void printAnnotations(Class classToReflect) {
		Annotation[] annotations = classToReflect.getAnnotations();
		for (Annotation annt : annotations) {
			System.out.println("annotation name: " + annt.toString());
		}
	}

	private static void printInterfaces(Class classToReflect) {
		Class[] interfaces = classToReflect.getInterfaces();
		for (Class cls : interfaces) {
			System.out.println("Interface name: " + cls.getName());
		}
	}

	private static void printSuperclass(Class classToReflect) {
		String parentclassName = classToReflect.getSuperclass().getName();
		System.out.println("parent class name: " + parentclassName);
	}

	private static void printMethods(Class classToReflect) throws Exception {
		Method[] methods = classToReflect.getDeclaredMethods();
		for (Method mthd : methods) {
			// private static modifier = 10
			if (mthd.getModifiers() == 10) {
				System.out.println("Private method, invoke with new value:");
				callPrivateMethod(mthd, "new value");
			}
			System.out.println("Method Name: " + mthd.getName() + "with modifier:" + mthd.getModifiers());
		}
	}

	public static void changeStaticFinalFieldValue(Field field, Object newValue) throws Exception {
		field.setAccessible(true);

		Field modifiersField = Field.class.getDeclaredField("modifiers");
		modifiersField.setAccessible(true);
		modifiersField.setInt(field, field.getModifiers() & ~Modifier.FINAL);

		field.set(null, newValue);
	}

	public static void callPrivateMethod(Method method, Object newValue) throws Exception {
		method.setAccessible(true);
		System.out.println("Result of private method return: " + method.invoke(null, "new value"));
	}
}
