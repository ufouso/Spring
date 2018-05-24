package com.xpp.test.config;

public class DataSourceManager {
	
	private static final ThreadLocal<DataSources> dataTypes = new ThreadLocal<DataSources>(){
		@Override
		protected DataSources initialValue() {
			return DataSources.db1;
		}
	};
	
	public static DataSources get(){
		return dataTypes.get();
	}
	
	public static void set(DataSources ds){
		dataTypes.set(ds);
	}
	
	public static void reset(){
		dataTypes.set(DataSources.db1);
	}
}
