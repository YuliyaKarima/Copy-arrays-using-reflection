import java.lang.annotation.Retention;

import java.lang.annotation.RetentionPolicy;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

/**
 * Class which object will be copied using reflection API In this class we use
 * classes EqualsBuilder and HashCodeBuilder to override Object's methods equals
 * and hashCode
 * 
 * @author Yuliya
 *
 */
public class MyClass1 {
	// array of objects of type MyClass2
	private MyClass2[] myclass2;
	// other attributes
	private int count;
	// attribute to set lenght of myclass2 array
	private int i_r;

	/**
	 * Sets value to the attribute i_r and initialize object of array myclass2
	 * 
	 * @param r
	 *            int value
	 */
	public void setr(int r) {
		i_r = r;
		myclass2 = new MyClass2[r];
	}

	/**
	 * Add object of class MyClass2 to the array myclass2
	 * 
	 * @param myclass2Obj
	 */
	public void addA(MyClass2 myclass2Obj) {
		if (count >= myclass2.length) {
			System.out.println("Объект не добавлен");
		}
		myclass2[count] = myclass2Obj;
		count++;
	}

	/**
	 * Returns count of objects in array myclass2
	 * 
	 * @return
	 */
	public int getcount() {
		return count;
	}

	/**
	 * Returns object from array myclass2 by index i
	 * 
	 * @param i
	 *            index of the object in the array myclass2
	 * @return an object on the position of index i in the array myclass2
	 */
	public MyClass2 myclass2Obj(int i) {
		return myclass2[i];
	}

	/**
	 * Returns myclass2 array's length
	 */
	public int getr() {
		return i_r;
	}

	/**
	 * Overrides Object's method equals using class
	 * org.apache.commons.lang.builder.EqualsBuilder
	 */
	public boolean equals(Object o) {

		if (this.getClass() == o.getClass())
			return true;
		if (this == o)
			return true;
		MyClass1 ob = (MyClass1) o;
		return new EqualsBuilder().append(i_r, ob.i_r).append(count, ob.count).append(myclass2, ob.myclass2).isEquals();
	}

	/**
	 * Overrides Object's method hashCode using class
	 * org.apache.commons.lang.builder.HashCodeBuilder
	 */

	public int hashCode() {
		return new HashCodeBuilder(3, 9).append(i_r).append(count).append(myclass2).toHashCode();
	}

	/**
	 * Returns object's hash code
	 * 
	 * @return object's hash code
	 */
	public String obj_hashCode() {
		String hashcode = "Хеш-код объекта " + hashCode();
		return hashcode;
	}
}
