package prak9_00000054804.com;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class MyDBHandler extends SQLiteOpenHelper {

    //panggil variable yang diperlukan
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "databarang.db";
    private static final String TABLE_NAME = "barang";

    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_NAMABARANG = "namabarang";
    private static final String COLUMN_KATEGORIBARANG = "kategoribarang";
    private static final String COLUMN_HARGABARANG = "hargabarang";

    //constructor
    public MyDBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    //untuk buat DB
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CREATE_TABLE_BARANG = "CREATE TABLE " + TABLE_NAME + "("+
                COLUMN_ID + "INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_NAMABARANG + " VARCHAR(50) NOT NULL, " +
                COLUMN_KATEGORIBARANG + " VARCHAR(50) NOT NULL, " +
                COLUMN_HARGABARANG + " LONG NOT NULL)";

        sqLiteDatabase.execSQL(CREATE_TABLE_BARANG);
    }

    //upgrade table
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    /*insert, select ,update dan delete*/

    private SQLiteDatabase database;
    //cara untuk buka DB connection

    public void open() throws SQLException {
        database = this.getWritableDatabase();

    }
    //inisialisasi semua kolom di tabel database
    private String [] allColumns =
            {COLUMN_ID, COLUMN_NAMABARANG, COLUMN_KATEGORIBARANG, COLUMN_HARGABARANG};

    //method untuk memindahkan isi cursor ke objek barang
    private Barang cursorToBarang(Cursor cursor){
        Barang barang = new Barang();

        barang.setID(cursor.getLong(0));
        barang.setNamaBarang(cursor.getString(1));
        barang.setKategoriBarang(cursor.getString(2));
        barang.setHargaBarang(cursor.getLong(3));

        return barang;
    }
    //method untuk menambahkan barang baru
    public void createBarang(String nama, String kategori, long harga){
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAMABARANG, nama);
        values.put(COLUMN_KATEGORIBARANG, kategori);
        values.put(COLUMN_HARGABARANG, harga);

        database.insert(TABLE_NAME, null, values);

    }
    //Method untuk mendapatkan detail per barang
    public Barang getBarang(long id){
        Barang barang = new Barang();

        Cursor cursor =
                database.query(TABLE_NAME, allColumns,"_id="+id, null, null, null, null);
        cursor.moveToFirst();
        barang = cursorToBarang(cursor);
        cursor.close();

        return barang;
    }
    // method untuk mendapatkan data semua barang di tabel barang
     public ArrayList<Barang> getAllBarang(){
        ArrayList<Barang> daftarBarang = new ArrayList<Barang>();

        Cursor cursor =
                database.query(TABLE_NAME, allColumns, null, null, null, null, null );
        cursor.moveToFirst();

        while(!cursor.isAfterLast()){
            Barang barang = cursorToBarang(cursor);
            daftarBarang.add(barang);
            cursor.moveToNext();
        }
        cursor.close();
        return daftarBarang;
     }

     //methode untuk update data barang
     public void updateBarang(Barang barang){
        String filter = "_id="+barang.getID();
        ContentValues args = new ContentValues();
        args.put(COLUMN_NAMABARANG, barang.getNamaBarang());
        args.put(COLUMN_KATEGORIBARANG, barang.getKategoriBarang());
        args.put(COLUMN_HARGABARANG, barang.getHargaBarang());

        database.update(TABLE_NAME, args, filter, null);
     }

     //Method untuk menghapus data barang
    public void deleteBarang(long id){
        String filter ="_id"+id;
        database.delete(TABLE_NAME, filter, null);
    }
}
