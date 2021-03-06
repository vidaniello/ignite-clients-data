package com.github.vidaniello.ignite.entitytests2;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.github.vidaniello.ignite.data.Entity;
import com.github.vidaniello.ignite.data.PrimaryKey;
import com.github.vidaniello.ignite.data.Transient;

@Entity
public class EntityWithFieldSerializable implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@PrimaryKey
	private PrimaryKeyWithFieldsSerializable id;
	
	private transient int anInt;
	@Transient
	private Integer anIntWrapped;
	//private String aString;
	//private FieldSerializable field1;
	
	//private int[][][] anArrayOfInt;
	//private Integer[] anArrayOfIntWrapped;
	//private String[] anArrayOfString;
	//private FieldSerializable[] anArrayOfFieldSerializable;
	
	//private Collection<Integer> aCollectionOfIntWrapped;
	//private Collection<String> aCollectionOfString;
	//private Collection<FieldSerializable> aCollectionOfFieldSerializable;
	
	//private Map<Integer, Integer> aMapOfIntInt;
	
	
	private Collection<Collection<Collection<String>>> d;
	
	//private Collection<Collection<String>>[] abc;
	
	//private Map<Map<Map<String,String>,Map<String,String>>,Map<Map<String,String>,Map<String,String>>> f;
	
	public EntityWithFieldSerializable() {
		
	}
	
	
}