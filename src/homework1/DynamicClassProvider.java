package homework1;


import java.lang.reflect.*;
import java.util.HashMap;
import java.util.Map;

public class DynamicClassProvider {
	Map<Pair<String, String>, String> m_cls = null;
	Map<Pair<String, String>, Class<?>> m_cache = null;
	
	public static void register(String nick, String creater, String path)
	{
		Pair<String, String> temp = new Pair<String, String>(nick, creater);
		Class cl = null;
		try
		{
			cl = Class.forName("DynamicClassProvider");
			Field fl = cl.getDeclaredField("m_cls");
			Object ob;
			
			ob = fl.get(new DynamicClassProvider());
			Class cls[] = new Class[2];
			cls[0] = Object.class;
			cls[1] = Object.class;
			
			Method m = HashMap.class.getMethod("put", cls);
			
			Object o[] = new Object[2];
			o[0] = temp;
			o[1] = path;
			m.invoke(ob, o);
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
		}
		
	
	}
	
	public static Object newInstance(String nick, String creater)
	{
		return creater;
	}
}
