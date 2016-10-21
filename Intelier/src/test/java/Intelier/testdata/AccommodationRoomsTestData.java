package Intelier.testdata;

import java.io.FileReader;
import java.io.IOException;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

public class AccommodationRoomsTestData {
	
	public static String General_Status;
	public static String General_InternalName;
	public static String General_RoomCategory;
    public static String General_FromRate;
    public static String General_SizeFrom;
    public static String General_SizeTo;
    public static String General_Unit;
    public static int General_AdultGuests;
    public static int General_ChildrenGuests;
    public static String General_Amenities;
    public static String LanguageSpecific_English_TitleTag;
    public static String LanguageSpecific_English_MetaKeywords;
    public static String LanguageSpecific_English_MetaDescription;
    public static String LanguageSpecific_English_Name;
    public static String LanguageSpecific_English_VanityURL;
    public static String LanguageSpecific_English_Headline;
    public static String LanguageSpecific_English_Description;
    public static String LanguageSpecific_English_BedTypes;
    public static String LanguageSpecific_English_Features;
    public static String LanguageSpecific_English_Notes; 
    
    public static void PrepareTestData (long testdata) {
    	
    	String file = "src/test/resources/test-data/AccommodationRooms.csv";

    	Iterable<CSVRecord> records = null;
		try {
			records = CSVFormat.RFC4180.withFirstRecordAsHeader().parse(new FileReader(file));
		} catch (IOException e) {
			e.printStackTrace();
		}
    	
    	for (CSVRecord record : records) {
    		if (record.getRecordNumber() == testdata) {
    			General_Status = record.get("General_Status");
        	    General_InternalName = record.get("General_InternalName");
        	    General_RoomCategory = record.get("General_RoomCategory");
        	    General_FromRate = record.get("General_FromRate");
        	    General_SizeFrom = record.get("General_SizeFrom");
        	    General_SizeTo = record.get("General_SizeTo");
        	    General_Unit = record.get("General_Unit");
        	    General_AdultGuests = Integer.parseInt(record.get("General_AdultGuests"));
        	    General_ChildrenGuests = Integer.parseInt(record.get("General_ChildrenGuests"));
        	    General_Amenities = record.get("General_Amenities");
        	    LanguageSpecific_English_TitleTag = record.get("LanguageSpecific_English_TitleTag");
        	    LanguageSpecific_English_MetaKeywords = record.get("LanguageSpecific_English_MetaKeywords");
        	    LanguageSpecific_English_MetaDescription = record.get("LanguageSpecific_English_MetaDescription");
        	    LanguageSpecific_English_Name = record.get("LanguageSpecific_English_Name");
        	    LanguageSpecific_English_VanityURL = record.get("LanguageSpecific_English_VanityURL");
        	    LanguageSpecific_English_Headline = record.get("LanguageSpecific_English_Headline");
        	    LanguageSpecific_English_Description = record.get("LanguageSpecific_English_Description");
        	    LanguageSpecific_English_BedTypes = record.get("LanguageSpecific_English_BedTypes");
        	    LanguageSpecific_English_Features = record.get("LanguageSpecific_English_Features");
        	    LanguageSpecific_English_Notes = record.get("LanguageSpecific_English_Notes");
    		}
        	    
    	}

    }

    
}
