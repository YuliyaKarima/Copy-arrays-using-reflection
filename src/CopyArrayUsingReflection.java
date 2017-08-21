
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.*;
import org.apache.commons.lang.builder.*;

/**
 * Main-Class In this class we create object of class MyClass1, initialize it
 * using static method and get copy of it using static methods of help class
 * Copy_Array_Class
 * 
 * @author Другие
 *
 */
public class CopyArrayUsingReflection {

	/**
	 * Prints array's attributes(which presented by an array of object of type
	 * MyClass2)
	 * 
	 * @param o
	 *            - MyClass1 array object
	 */
	public static void print_array(Object[] o) {
		MyClass1[] ob = (MyClass1[]) o;
		System.out.println("Printing array's data");
		for (int i = 0; i < o.length; i++) {
			for (int y = 0; y < ob[i].getr(); y++) {
				System.out.println("Object " + (i + 1) + ": " + ob[i].myclass2Obj(y).getA());
			}
			System.out.println();
		}

	}

	/**
	 * This method initialize array MyClass2 in array MyClass1
	 * 
	 * @param o
	 *            - MyClass1 array object
	 * @param s
	 *            - a value to initialize MyClass2 attribute
	 */

	public static void init_array(MyClass1[] o, int s) {

		System.out.println("Initialization");
		for (int i = 0; i < o.length; i++) {
			o[i] = new MyClass1();
			o[i].setr(i + 1);
			for (int y = 0; y < o[i].getr(); y++) {
				o[i].addA(new MyClass2(s + y));
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Array objects of MyClass1
		MyClass1[] myclass1 = new MyClass1[3];
		MyClass1[] myclass2 = new MyClass1[3];

		init_array(myclass1, 1);
		System.out.println("Array 1");
		print_array(myclass1);
		System.out.println();
		init_array(myclass2, 10);
		System.out.println("Array 2");
		print_array(myclass2);
		// in this case we copy one array's data to another array's data
		System.out.println(Copy_Array_Class.copyToArray(myclass1, myclass2));
		System.out.println("Array 2 after being copying");

		print_array(myclass2);

		System.out.println(compare_obj(myclass1, myclass2));
		System.out.println(compare_obj(myclass1, myclass1));
		// in this case we get copy of the array from method
		print_array(cast_to_MyClass1(Copy_Array_Class.copyArray(myclass1)));

	}

	/**
	 * Method compares two objects
	 * 
	 * @param one
	 *            first object that being compared
	 * @param two
	 *            second object that being compared to
	 * @return
	 */
	public static String compare_obj(Object one, Object two) {
		boolean equal = false;
		if (one.equals(two) && (one.hashCode() == two.hashCode()))
			equal = true;
		else
			equal = false;
		return (equal) ? "Objects are equal" : "Objects are not equal";

	}

	/**
	 * This method casts array object returned by method copyArray to MyClass1
	 * array object
	 * 
	 * @param o
	 *            Object array object
	 * @return MyClass1 array object
	 */
	public static MyClass1[] cast_to_MyClass1(Object[] o) {
		MyClass1[] new_obj = new MyClass1[o.length];
		for (int i = 0; i < o.length; i++) {
			new_obj[i] = (MyClass1) o[i];
		}
		return new_obj;
	}

}
