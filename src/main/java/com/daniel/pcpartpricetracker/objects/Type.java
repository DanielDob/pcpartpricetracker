package com.daniel.pcpartpricetracker.objects;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Type {
	
	public final static int CPU=1;
	public final static int GPU=2;
	public final static int GPU_2=11;
	public final static int MOTHER_BOARD=3;
	public final static int RAM=4;
	public final static int RAM_2=12;
	public final static int RAM_3=13;
	public final static int RAM_4=14;
	public final static int POWER_SUPLLY_UNIT=5;
	public final static int COOLER=6;
	public final static int HDD=7;
	public final static int HDD_2=15;
	public final static int HDD_3=16;
	public final static int HDD_4=17;
	public final static int SDD=8;
	public final static int SDD_2=18;
	public final static int SDD_3=19;
	public final static int SDD_4=20;
	public final static int M2=9;
	public final static int M2_2=21;
	public final static int M2_3=22;
	public final static int CASE=10;
	
	public final static String CPU_STRING="CPU";
	public final static String GPU_STRING="GPU";
	public final static String GPU_2_STRING="GPU_2";
	public final static String MOTHER_BOARD_STRING="Mother board";
	public final static String RAM_STRING="RAM";
	public final static String RAM_2_STRING="RAM_2";
	public final static String RAM_3_STRING="RAM_3";
	public final static String RAM_4_STRING="RAM_4";
	public final static String POWER_SUPLLY_UNIT_STRING="PSU";
	public final static String COOLER_STRING="COOLER";
	public final static String HDD_STRING="HDD";
	public final static String HDD_2_STRING="HDD_2";
	public final static String HDD_3_STRING="HDD_3";
	public final static String HDD_4_STRING="HDD_4";
	public final static String SDD_STRING="SSD";
	public final static String SDD_2_STRING="SSD_2";
	public final static String SDD_3_STRING="SSD_3";
	public final static String SDD_4_STRING="SSD_4";
	public final static String M2_STRING="M2";
	public final static String M2_2_STRING="M2_2";
	public final static String M2_3_STRING="M2_3";
	public final static String CASE_STRING="Case";
	
	public static HashMap<Integer, String> idToString = new LinkedHashMap<Integer, String>();
	{
		idToString.put(CPU,CPU_STRING);
		idToString.put(GPU,GPU_STRING);
		idToString.put(GPU_2,GPU_2_STRING);
		idToString.put(MOTHER_BOARD,MOTHER_BOARD_STRING);
		idToString.put(RAM,RAM_STRING);
		idToString.put(RAM_2,RAM_2_STRING);
		idToString.put(RAM_3,RAM_3_STRING);
		idToString.put(RAM_4,RAM_4_STRING);
		idToString.put(POWER_SUPLLY_UNIT,POWER_SUPLLY_UNIT_STRING);
		idToString.put(COOLER,COOLER_STRING);
		idToString.put(HDD,HDD_STRING);
		idToString.put(HDD_2,HDD_2_STRING);
		idToString.put(HDD_3,HDD_3_STRING);
		idToString.put(HDD_4,HDD_4_STRING);
		idToString.put(SDD,SDD_STRING);
		idToString.put(SDD_2,SDD_2_STRING);
		idToString.put(SDD_3,SDD_3_STRING);
		idToString.put(SDD_4,SDD_4_STRING);
		idToString.put(M2,M2_STRING);
		idToString.put(M2_2,M2_2_STRING);
		idToString.put(M2_3,M2_3_STRING);
		idToString.put(CASE,CASE_STRING);
	}
	
	public static HashMap<String,Integer> stringToId = new LinkedHashMap<String,Integer>();
	{
		stringToId.put(CPU_STRING,CPU);
		stringToId.put(GPU_STRING,GPU);
		stringToId.put(GPU_2_STRING,GPU_2);
		stringToId.put(MOTHER_BOARD_STRING,MOTHER_BOARD);
		stringToId.put(RAM_STRING,MOTHER_BOARD);
		stringToId.put(RAM_2_STRING,RAM_2);
		stringToId.put(RAM_3_STRING,RAM_3);
		stringToId.put(RAM_4_STRING,RAM_4);
		stringToId.put(POWER_SUPLLY_UNIT_STRING,POWER_SUPLLY_UNIT);
		stringToId.put(COOLER_STRING,COOLER);
		stringToId.put(HDD_STRING,HDD);
		stringToId.put(HDD_2_STRING,HDD_2);
		stringToId.put(HDD_3_STRING, HDD_3);
		stringToId.put(HDD_4_STRING,HDD_4);
		stringToId.put(SDD_STRING,SDD);
		stringToId.put(SDD_2_STRING,SDD_2);
		stringToId.put(SDD_3_STRING,SDD_3);
		stringToId.put(SDD_4_STRING,SDD_4);
		stringToId.put(M2_STRING,M2);
		stringToId.put(M2_2_STRING,M2_2);
		stringToId.put(M2_3_STRING,M2_3);
		stringToId.put(CASE_STRING,CASE);
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(@SuppressWarnings("rawtypes") Map.Entry i :  stringToId.entrySet()) {
			sb.append(i+" ");
		}
		return sb.toString();
	}
}
