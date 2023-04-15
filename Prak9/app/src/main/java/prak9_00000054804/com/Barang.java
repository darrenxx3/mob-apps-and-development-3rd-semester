package prak9_00000054804.com;

public class Barang {
    private long _id;
    private String _namabarang;
    private String _kategoribarang;
    private long _hargabarang;

    //constructor class barang
    public Barang(){

    }
    //set id barang
    public void setID(long id){
        this._id = id;
    }
    //get ID barang
    public long getID(){
        return this._id;
    }
    //set nama barang
    public void setNamaBarang(String namabarang){
        this._namabarang = namabarang;
    }

    //get nama barang
    public String getNamaBarang(){
        return this._namabarang;
    }
    //set kategori barang
    public void setKategoriBarang(String kategoribarang){
        this._kategoribarang = kategoribarang;
    }
    //get kategori barang
    public String getKategoriBarang(){
        return this._kategoribarang;
    }
    //set harga barang
    public void setHargaBarang(long hargabarang){
        this._hargabarang = hargabarang;
    }
    //get harga barang
    public long getHargaBarang(){
        return this._hargabarang;
    }
    //

    @Override
    public String toString() {
        return "Nama Barang\t\t\t\t: "+ _namabarang + "\nKategori Barang\t: " + _kategoribarang + "\nHarga Barang\t\t\t\t: " + _hargabarang;
    }
}

