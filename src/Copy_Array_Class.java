import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

import org.apache.commons.lang.builder.EqualsBuilder;

/**
 * Help class for copy arrays
 * 
 * @author Yuliya
 *
 */
public class Copy_Array_Class {
	/**
	 * Method copies one array's data to another array's data using reflection
	 * 
	 * @param copy_from
	 *            an array (copied)
	 * @param copy_to
	 *            an array (copying)
	 * @return String (success or failure)
	 */
	public static String copyToArray(Object[] copy_from, Object[] copy_to) {
		boolean success = false;
		System.out.println("Copying array copy_from to copy_to");
		Class<?> myclass1_class = copy_from.getClass();
		// getting class of array copy_from
		Class<?> myclass1_array = myclass1_class.getComponentType();
		// вытаскиваем поля данного класса
		Field[] f = myclass1_array.getDeclaredFields();
		int count = copy_from.length;
		// для каждого объекта в массиве
		for (int c = 0; c < count; c++) {
			// ходить по каждому полю
			for (int i = 0; i < f.length; i++) {
				// делать копию полей объекта
				try {
					f[i].setAccessible(true);
					Object val = f[i].get(copy_from[c]);
					f[i].set(copy_to[c], val);
					f[i].setAccessible(false);
					success = true;
				} catch (Exception e) {
					System.out.println(e);
					success = false;
				}
			}
		}
		if (success)
			return "Копирование завершено удачно";
		else
			return "Произошла ошибка";
	}

	/**
	 * Метод создает массив объектов на основании переданного массива, использую
	 * рефлексию
	 * 
	 * @param copy_from
	 *            массив (копируемый массив)
	 * @param copy_to
	 *            массив (копирующий массив)
	 * @return массив
	 */
	public static Object[] copyArray(Object[] copy_from) {

		System.out.println("Копирование данных массива");
		Class<?> class_array = copy_from.getClass();
		// получаем класс составляющей данного массива
		Class<?> class_class = class_array.getComponentType();
		int count = copy_from.length;
		// вытаскиваем поля данного класса
		Field[] f = class_class.getDeclaredFields();
		Object[] copy_to = new Object[count];
		try {
			for (int i = 0; i < count; i++) {
				copy_to[i] = class_class.newInstance();
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		// для каждого объекта в массиве
		for (int c = 0; c < count; c++) {
			// ходить по каждому полю
			for (int i = 0; i < f.length; i++) {
				// делать копию полей объекта
				try {
					f[i].setAccessible(true);
					Object val = f[i].get(copy_from[c]);
					f[i].set(copy_to[c], val);
					f[i].setAccessible(false);
				} catch (Exception e) {
					System.out.println(e);
				}
			}
		}
		return copy_to;
	}

}
