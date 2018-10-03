package com.animal.refugio.refugioanimales.persistance;

public class ItemsTable {
    public static final String TABLE_ITEMS = "Animal";
    public static final String COLUMN_ID = "Id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_AGE = "age";
    public static final String COLUMN_CHIP = "hasChip";
    public static final String COLUMN_TYPE = "type";
    public static final String COLUMN_DATE = "registrationDate";
    public static final String COLUMN_IMAGE = "image";
    public static final String SQL_CREATE =
            "CREATE TABLE " + TABLE_ITEMS + "(" +
                    COLUMN_ID + " TEXT PRIMARY KEY," +
                    COLUMN_NAME + " TEXT," +
                    COLUMN_AGE + " INTEGER," +
                    COLUMN_CHIP + " BOOLEAN," +
                    COLUMN_TYPE + " TEXT," +
                    COLUMN_DATE + " DATE," +
                    COLUMN_IMAGE + " TEXT" + ");";
    public static final String SQL_DELETE =
            "DROP TABLE " + TABLE_ITEMS;
}