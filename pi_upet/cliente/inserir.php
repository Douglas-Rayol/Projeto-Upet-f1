<?php
    require_once "../util/config.php";

    $nome = "Marcos";
    $telefone = "(91)99884512";
    $endereco = "Rua joaquim tavora, 234";
    $senha = "123456";
    $email = "marcos.tavora@gmail.com";
    $cpf = "000.000.000-00";
    $cidade = "Belem";
    $estado = "PA";
    $cep = "66020340";
 
    $sql = "INSERT INTO cliente (nome, telefone, endereco, senha, email, cpf, cidade, estado, cep) VALUES(?, ?, ?, ?, ?,?,?,?,?)";
    
    $stmt = mysqli_prepare($link, $sql);
    
    mysqli_stmt_bind_param($stmt, "sssssssss", $nome, $telefone, $endereco, $senha, $email, $cpf, $cidade, $estado, $cep);

    if(mysqli_stmt_execute($stmt)){
        echo " Cadastro com sucesso";
    }else{
        echo " Erro no cadastro";
    }

?>