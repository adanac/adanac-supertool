package com.adanac.tool.supertool.j2se.clazz;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Dto2Entity {

	/**
	 * 父类DTO对象转换为实体对象。如命名不规范或其他原因导致失败
	 * 
	 * @param t
	 *            源转换的对象
	 * @param e
	 *            目标转换的对象
	 * 
	 */
	public static <T, E> void transalte(T t, E e) {
		Method[] tms = t.getClass().getSuperclass().getDeclaredMethods();
		Method[] tes = e.getClass().getSuperclass().getDeclaredMethods();
		for (Method m1 : tms) {
			if (m1.getName().startsWith("get")) {
				String mNameSubfix = m1.getName().substring(3);
				String forName = "set" + mNameSubfix;
				for (Method m2 : tes) {
					if (m2.getName().equals(forName)) {
						// 如果类型一致，或者m1的返回类型是m2的参数类型的父类或接口
						boolean canContinue = m1.getReturnType().isAssignableFrom(m2.getParameterTypes()[0]);
						if (canContinue) {
							try {
								m2.invoke(e, m1.invoke(t));
								break;
							} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e1) {
								e1.printStackTrace();
							}
						}
					}
				}
			}
		}
	}

	/**
	 * DTO对象转换为实体对象。如命名不规范或其他原因导致失败
	 * 
	 * @param t
	 *            源转换的对象
	 * @param e
	 *            目标转换的对象
	 * 
	 */
	public static <T, E> void transalte2(T t, E e) {
		Method[] tms = t.getClass().getDeclaredMethods();
		Method[] tes = e.getClass().getDeclaredMethods();
		for (Method m1 : tms) {
			if (m1.getName().startsWith("get")) {
				String mNameSubfix = m1.getName().substring(3);
				String forName = "set" + mNameSubfix;
				for (Method m2 : tes) {
					if (m2.getName().equals(forName)) {
						// 如果类型一致，或者m1的返回类型是m2的参数类型的父类或接口
						boolean canContinue = m1.getReturnType().isAssignableFrom(m2.getParameterTypes()[0]);
						if (canContinue) {
							try {
								m2.invoke(e, m1.invoke(t));
								break;
							} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e1) {
								e1.printStackTrace();
							}
						}
					}
				}
			}
		}
	}

	public static void fatherToChild(Object father, Object child) {
		if (!(child.getClass().getSuperclass() == father.getClass())) {
			System.err.println("child不是father的子类");
		}
		Class fatherClass = father.getClass();
		Field ff[] = fatherClass.getDeclaredFields();
		for (int i = 0; i < ff.length; i++) {
			Field f = ff[i];// 取出每一个属性，如deleteDate
			Class type = f.getType();
			try {
				Method m = fatherClass.getMethod("get" + upperHeadChar(f.getName()));// 方法getDeleteDate
				Object obj = m.invoke(father);// 取出属性值
				f.setAccessible(true); // 抑制Java的访问控制检查
				f.set(child, obj);
			} catch (Exception e) {
				System.err.println(e.toString());
			}
		}
	}

	/**
	 * 首字母大写，in:deleteDate，out:DeleteDate
	 */
	private static String upperHeadChar(String in) {
		String head = in.substring(0, 1);
		String out = head.toUpperCase() + in.substring(1, in.length());
		return out;
	}

}
