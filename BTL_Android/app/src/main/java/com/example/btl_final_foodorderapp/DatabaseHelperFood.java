    package com.example.btl_final_foodorderapp;

    import android.content.Context;
    import android.database.sqlite.SQLiteDatabase;
    import android.database.sqlite.SQLiteOpenHelper;

    public class DatabaseHelperFood extends SQLiteOpenHelper {

        public static final String DATABASE_NAME = "food.db";
        public static final int DATABASE_VERSION = 1;




        public static final String TABLE_FOOD_DRINK = "food_drink";
        public static final String COLUMN_ID_DRINK = "id";
        public static final String COLUMN_NAME_DRINK = "name";
        public static final String COLUMN_PRICE_DRINK = "price";


        public static final String TABLE_FOOD_RAMEN = "food_ramen";
        public static final String COLUMN_ID_RAMEN = "id";
        public static final String COLUMN_NAME_RAMEN = "name";
        public static final String COLUMN_PRICE_RAMEN = "price";

        public static final String TABLE_FOOD_ICECREAM = "food_icecream";
        public static final String COLUMN_ID_ICECREAM = "id";
        public static final String COLUMN_NAME_ICECREAM = "name";
        public static final String COLUMN_PRICE_ICECREAM = "price";

        public static final String TABLE_FOOD_FASTFOOD = "food_fastfood";
        public static final String COLUMN_ID_FASTFOOD = "id";
        public static final String COLUMN_NAME_FASTFOOD = "name";
        public static final String COLUMN_PRICE_FASTFOOD = "price";

        public static final String TABLE_FOOD_CAKE = "food_cake";
        public static final String COLUMN_ID_CAKE = "id";
        public static final String COLUMN_NAME_CAKE = "name";
        public static final String COLUMN_PRICE_CAKE = "price";

        public DatabaseHelperFood(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            String createTableFoodDrinkQuery  = "CREATE TABLE " + TABLE_FOOD_DRINK + " ("
                    + COLUMN_ID_DRINK + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + COLUMN_NAME_DRINK + " TEXT, "
                    + COLUMN_PRICE_DRINK + " INTEGER)";
            db.execSQL(createTableFoodDrinkQuery);

            // Thêm dữ liệu sẵn
            String insertFoodDrinkQuery  = "INSERT INTO " + TABLE_FOOD_DRINK + " ("
                    + COLUMN_NAME_DRINK + ", " + COLUMN_PRICE_DRINK + ") VALUES ";
            db.execSQL(insertFoodDrinkQuery  + "('Trà sữa', 30000)");
            db.execSQL(insertFoodDrinkQuery  + "('Trà đào', 25000)");
            db.execSQL(insertFoodDrinkQuery  + "('Trà chanh', 15000)");
            db.execSQL(insertFoodDrinkQuery  + "('Bia', 20000)");

            String createTableFoodRamenQuery = "CREATE TABLE " + TABLE_FOOD_RAMEN + " ("
                    + COLUMN_ID_RAMEN + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + COLUMN_NAME_RAMEN + " TEXT, "
                    + COLUMN_PRICE_RAMEN + " INTEGER)";
            db.execSQL(createTableFoodRamenQuery);

            // Thêm dữ liệu sẵn
            String insertFoodRamenQuery  = "INSERT INTO " + TABLE_FOOD_RAMEN + " ("
                    + COLUMN_NAME_RAMEN + ", " + COLUMN_PRICE_RAMEN + ") VALUES ";
            db.execSQL(insertFoodRamenQuery + "('Mỳ ý', 100000)");
            db.execSQL(insertFoodRamenQuery + "('Mỳ xào', 25000)");
            db.execSQL(insertFoodRamenQuery + "('Mỳ ly', 8000)");
            db.execSQL(insertFoodRamenQuery + "('Mỳ gói', 50000)");



            String createTableFoodIcreamQuery = "CREATE TABLE " + TABLE_FOOD_ICECREAM + " ("
                    + COLUMN_ID_ICECREAM + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + COLUMN_NAME_ICECREAM + " TEXT, "
                    + COLUMN_PRICE_ICECREAM + " INTEGER)";
            db.execSQL(createTableFoodIcreamQuery);

            String insertQueryIcecream = "INSERT INTO " + TABLE_FOOD_ICECREAM + " ("
                    + COLUMN_NAME_ICECREAM + ", " + COLUMN_PRICE_ICECREAM + ") VALUES ";
            db.execSQL(insertQueryIcecream + "('Kem socola', 35000)");
            db.execSQL(insertQueryIcecream + "('Kem vani', 30000)");
            db.execSQL(insertQueryIcecream + "('Kem dâu', 40000)");
            db.execSQL(insertQueryIcecream + "('Kem xoài', 45000)");


            String createTableFastFoodQuery = "CREATE TABLE " + TABLE_FOOD_FASTFOOD + " ("
                    + COLUMN_ID_FASTFOOD + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + COLUMN_NAME_FASTFOOD + " TEXT, "
                    + COLUMN_PRICE_FASTFOOD + " INTEGER)";
            db.execSQL(createTableFastFoodQuery);

            String insertQueryFastfood = "INSERT INTO " + TABLE_FOOD_FASTFOOD + " ("
                    + COLUMN_NAME_FASTFOOD + ", " + COLUMN_PRICE_FASTFOOD + ") VALUES ";
            db.execSQL(insertQueryFastfood + "('Burger', 50000)");
            db.execSQL(insertQueryFastfood + "('Khoai tây chiên', 35000)");
            db.execSQL(insertQueryFastfood + "('Hotdog', 45000)");
            db.execSQL(insertQueryFastfood + "('Cơm gà rán', 40000)");


            String createTableCakeQuery = "CREATE TABLE " + TABLE_FOOD_CAKE + " ("
                    + COLUMN_ID_CAKE + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + COLUMN_NAME_CAKE + " TEXT, "
                    + COLUMN_PRICE_CAKE + " INTEGER)";
            db.execSQL(createTableCakeQuery);


            String insertQueryCake = "INSERT INTO " + TABLE_FOOD_CAKE + " ("
                    + COLUMN_NAME_CAKE + ", " + COLUMN_PRICE_CAKE + ") VALUES ";
            db.execSQL(insertQueryCake + "('Bánh sinh nhật', 80000)");
            db.execSQL(insertQueryCake + "('Bánh bông lan', 60000)");
            db.execSQL(insertQueryCake + "('Bánh kem', 100000)");
            db.execSQL(insertQueryCake + "('Bánh mì', 20000)");




        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            // Không làm gì trong trường hợp này
        }

        public static String getColumnIdDrink() {
            return COLUMN_ID_DRINK;
        }

        public static String getColumnNameDrink() {
            return COLUMN_NAME_DRINK;
        }

        public static String getColumnPriceDrink() {
            return COLUMN_PRICE_DRINK;
        }
        //
        public static String getColumnIdDRamen() {
            return COLUMN_ID_RAMEN;
        }

        public static String getColumnNameRamen() {
            return COLUMN_NAME_RAMEN;
        }

        public static String getColumnPriceRamen() {
            return COLUMN_PRICE_RAMEN;
        }
        //
        public static String getColumnIdDIcecream() {
            return COLUMN_ID_ICECREAM;
        }

        public static String getColumnNameIcecream() {
            return COLUMN_NAME_ICECREAM;
        }

        public static String getColumnPriceIcecream() {
            return COLUMN_PRICE_RAMEN;
        }
        //
        public static String getColumnIdFastFood() {
            return COLUMN_ID_FASTFOOD;
        }

        public static String getColumnNameFastFood() {
            return COLUMN_NAME_FASTFOOD;
        }

        public static String getColumnPriceFastFood() {
            return COLUMN_PRICE_FASTFOOD;
        }


    }
