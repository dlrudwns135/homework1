package homework1;


import java.lang.reflect.*;
import java.util.HashMap;
import java.util.Map;

public class DynamicClassProvider {
	private static Map<Pair<String, String>, String> m_cls;
	private static Map<Pair<String, String>, Class<?>> m_cache;
	
	public DynamicClassProvider()
	{
		if (this.m_cls == null)
			m_cls = new HashMap<Pair<String,String>, String>();
		else
			m_cls = this.m_cls;
		
		if(this.m_cache == null)
			m_cache = new HashMap<Pair<String,String>, Class<?>>();
		else
			m_cache = this.m_cache;
	}
	
	public static void register(String nick, String creater, String path)
	{
		Pair<String, String> temp = new Pair<String, String>(nick, creater);
		
		try
		{
			Class<?> cl = Class.forName("homework1.DynamicClassProvider");
			Field fl = cl.getDeclaredField("m_cls");
			fl.setAccessible(true);
			Object ob = fl.get(cl.newInstance());
			Class<?> cls[] = new Class[2];
			cls[0] = Object.class;
			cls[1] = Object.class;
			
			Method m = HashMap.class.getMethod("put", cls);
			
			Object o[] = new Object[2];
			o[0] = temp;
			o[1] = path;
			m.invoke(ob, o);
			System.out.println("sss");
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
		}
	}
	
	public static Object newInstance(String nick, String creater)
	{
		Class<?> cl2 = null;
		
		Pair<String, String> key = new Pair<String, String>(nick, creater);
		
		try
		{
			Class<?> cl = Class.forName("homework1.DynamicClassProvider");
			Field fl = cl.getDeclaredField("m_cls");
			fl.setAccessible(true);
			Object ob = fl.get(cl.newInstance());
			Class<?> cls[] = new Class[1];
			cls[0] = Object.class;
			
			Method m = HashMap.class.getMethod("get", cls);
			
			Object o[] = new Object[1];
			o[0] = key;
			
			Object name = m.invoke(ob, key);
			Object temp = m_cls.get(key);
			System.out.println("sss");
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
		}
		
		return cl2;
	}
}
