<?php
    require_once "../util/config.php";

    $nome = "Marcos";
    $telefone = "(91)99884512";
    $endereco = "Rua joaquim tavora, 234";

    $sql = "INSERT INTO funcionario (nome, telefone, endereco) VALUES(?, ?, ?)";
    
    $stmt = mysqli_prepare($link, $sql);
    
    mysqli_stmt_bind_param($stmt, "sss", $nome, $telefone, $endereco);

    if(mysqli_stmt_execute($stmt)){
        echo " Registrado com Sucesso";
    }else{
        echo " Falha no Registro";
    }

?>