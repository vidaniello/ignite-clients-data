package com.github.vidaniello.ignite;

import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.Set;

import org.apache.ignite.Ignite;
import org.apache.ignite.internal.util.IgniteUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.reflections.Reflections;

import com.github.vidaniello.ignite.data.Entity;
import com.github.vidaniello.ignite.data.IgniteEntityManager;
import com.github.vidaniello.ignite.data.IgniteEntityManagerFactory;
import com.github.vidaniello.ignite.entityexamples.Person;
import com.github.vidaniello.ignite.entityexamples.Phone;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtField;
import javassist.Loader;
import javassist.Modifier;

public class Tests {

	
	static{

	     //URL file di configurazione Log4j2
	     System.setProperty("log4j.configurationFile", "https://gist.github.com/vidaniello/e6cf911c5a440c05f57b946a15d27822/raw/c919f0b423d4b08ec18419cddc0b9bdb7c2e6599/log4j2-test-ignite.xml");

	     //Tips per java.util.logging
	     System.setProperty("java.util.logging.manager", "org.apache.logging.log4j.jul.LogManager");
	}
	
	private Logger log = LogManager.getLogger();
	
	/**
	 * Make sure you have a server node started as default before starting this test.
	 */
	@Test //@Ignore
	public void firstFindEntities() {
		try {		
			
			
			
			
			
			Reflections ref = new Reflections();
			Set<Class<?>> res = ref.getTypesAnnotatedWith(Entity.class);
			
			IgniteEntityManager manager = IgniteEntityManagerFactory.instance();
			
			Phone ph1 = new Phone();
			Phone ph2 = new Phone();
			Phone ph3 = new Phone();
			Phone ph4 = new Phone();
			
			Person person1 = new Person();
			
			person1.setPrivatePhone(ph1);
			person1.getAllPhones().add(ph3);
			person1.getAllPhones().add(ph4);
			
			manager.create(person1);
			
			
			
			
			
			/*
			ClassPool pool = ClassPool.getDefault();
			CtClass cc = pool.get(Person.class.getCanonicalName());
			CtClass ccd = pool.get(IgniteEntityProxy.class.getCanonicalName());
			cc.setSuperclass(ccd);
			
			CtField fi = new CtField(CtClass.floatType, "abefglie", cc);
			fi.setModifiers(Modifier.PRIVATE);
			cc.addField(fi);
			
			Object dd = cc.toClass().newInstance();
			
			
			
			Person per = new Person();
			*/
			
			/*
			Person per1 = IgniteEntityProxy.newInstance(Person.class);
			String canname = per1.getClass().getCanonicalName();
			Object d = per1.getName();
			Object f = per1.getName();
			Object g = per1.hashCode();
			*/
			
			
			
			int stop = 0;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
	}
	
	/**
	 * Make sure you have a server node started as default before starting this test.
	 */
	@Test @Ignore
	public void tesClientLocalTestnet() {
		try {
			
			Ignite testnet = ClientProvider.instance().ignite();
			
			Ignite testnetSame = ClientProvider.instance().ignite();
			
			int i = 0;
			//testnet.close();
		}catch (Exception e) {
			log.error(e.getMessage(), e);
		}
	}
	
	
	
	@Test
	public void tesLoadingConfig() {
		try {
			Map<String,String> testnet =  ClientProvider.instance().getMapFromPropertiesByClusterTag("testnet");
			Map<String,String> mainnet =  ClientProvider.instance().getMapFromPropertiesByClusterTag("mainnet");
			Map<String,String> other =  ClientProvider.instance().getMapFromPropertiesByClusterTag("other");
			Map<String,String> empty =  ClientProvider.instance().getMapFromPropertiesByClusterTag("empty");
			
			Assert.assertTrue(testnet.get("clusterTag").equals("testnet"));
			Assert.assertTrue(!testnet.get("uri").isEmpty());
			
			Assert.assertTrue(mainnet.get("clusterTag").equals("mainnet"));
			Assert.assertTrue(!mainnet.get("uri").isEmpty());
			
			Assert.assertTrue(other.get("clusterTag").equals("other"));
			Assert.assertTrue(!other.get("uri").isEmpty());
			
			Assert.assertTrue(empty.isEmpty());
			
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		
	}
}
