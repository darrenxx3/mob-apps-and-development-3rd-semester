<?php
    header('Content-type:application/json;charset=utf-8');
    include "conn.php";


    if(isset($_POST['nama'])&& isset($_POST['alamat'])){
        $nama = $_POST['nama'];
        $alamat = $_POST['alamat'];

        $q=mysql_query("INSERT INTO mahasiswa(nama, alamat) VALUES('$nama','$alamat')");
        $response = array();

        if($q){
            $response["success"] = 1;
            $response["message"] = "Data berhasil ditambah";
            echo json_encode($response);
        }
        else{
            $response["success"] = 0;
            $response["message"] = "Data gagal ditambah";
            echo json_encode($response);
        }
    }
    else{
        $response["success"] = -1;
        $response["message"] = "Data kosong";
        echo json_encode($response);
    }
?>