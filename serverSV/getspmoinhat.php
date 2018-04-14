<?php
    include "connect.php";
    $mangspmoinhat = array();
    $query = "SELECT * FROM sanpham ORDER by ID DESC LIMIT 6";

    $data = mysqli_query($conn, $query);
    while ($row = mysqli_fetch_assoc($data)) {
        array_push($mangspmoinhat, new spmoinhat(
            $row['id'],
            $row['tensp'],
            $row['giasp'],
            $row['hinhanhsp'],
            $row['motasp'],
            $row['idsp']));
    }
    echo json_encode($mangspmoinhat);

    class spmoinhat{
        public function spmoinhat($id, $tensp, $giasp, $hinhanhsp, $motasp, $idsp) {
            $this->id  = $id;
            $this->tensp  = $tensp;
            $this->giasp  = $giasp;
            $this->hinhanhsp   = $hinhanhsp;
            $this->motasp  = $motasp;
            $this->idsp  = $idsp;   
        }
    }
?>